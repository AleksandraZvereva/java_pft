package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() { click(By.name("selected[]")); }

  public void deleteContact(){click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));}

  public void selectAllContacts(){click(By.xpath("//*[@id=\"MassCB\"]"));}

  public void acceptAlert(){wd.switchTo().alert().accept();}

  public void initContactModification(){click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));}

  public void submitContactModification(){click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));}

  public void fillNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());
  }
}
