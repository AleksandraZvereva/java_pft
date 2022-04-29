package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AllContactsDeletionTests extends TestBase{

  @Test
  public void testAllContactsDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectAllContacts();
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptAlert();
    app.getNavigationHelper().gotoHomePage();
  }
}
