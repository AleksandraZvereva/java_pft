package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AllContactsDeletionTests extends TestBase{

  @Test
  public void testAllContactsDeletion(){
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Test", "Testoff", "Moscow, Red Square, 1", "test_testoff@mail.ru", "123456789"));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().selectAllContacts();
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptAlert();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), 0);
  }
}
