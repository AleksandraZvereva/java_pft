package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteContact(){click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));}

  public void selectAllContacts(){click(By.xpath("//*[@id=\"MassCB\"]"));}

  public void acceptAlert(){wd.switchTo().alert().accept();}

  public void initContactModification(int index){
    wd.findElements(By.xpath("//td[@class='center']/following-sibling::td[7]")).get(index).click();
  }

  public void submitContactModification(){click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));}

  public void fillNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());

  }

  public void createContact(ContactData contact) {
    fillNewContactForm(contact);
    selectGroup(By.name("new_group"));
    submitContactCreation();
   }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void selectGroup(By locator) {
    try {
      new Select(wd.findElement(locator)).selectByIndex(1);
    } catch (NoSuchElementException e){
      e.printStackTrace();
    }

  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elementsFirstName = wd.findElements(By.cssSelector("tr[name='entry'] > td:nth-child(3)"));
    List<WebElement> elementsLastName = wd.findElements(By.cssSelector("tr[name='entry'] > td:nth-child(2)"));
    List<WebElement> elementsId = wd.findElements(By.cssSelector("td.center > input"));
    String firstName = null;
    String lastName = null;
    int id = 0;
    for(int i = 0; i < elementsFirstName.size(); i++) {
      for(WebElement element : elementsId){
        id = Integer.parseInt(element.getAttribute("value"));
      }
      for (WebElement element : elementsFirstName) {
        firstName = element.getText();
      }
      for (WebElement element : elementsLastName) {
        lastName = element.getText();
      }
      ContactData contact = new ContactData(id, firstName, lastName, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
