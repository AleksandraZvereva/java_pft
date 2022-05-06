package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillNewContactForm(new ContactData("UpdateTest", "UpdateTestoff", "UpdateMoscow, Red Square, 1", "Updatetest_testoff@mail.ru", "Update123456789", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
