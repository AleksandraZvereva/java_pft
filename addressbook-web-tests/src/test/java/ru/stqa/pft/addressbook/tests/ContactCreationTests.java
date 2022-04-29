package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().fillNewContactForm(new ContactData("Test", "Testoff", "Moscow, Red Square, 1", "test_testoff@mail.ru", "123456789"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }

}

