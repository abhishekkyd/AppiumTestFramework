package com.automation.mobile.tests;

import com.automation.mobile.dataproviders.CsvDataProvider;
import com.automation.mobile.dataproviders.CsvFileParameters;
import com.automation.mobile.pages.ConfirmRegistrationPage;
import com.automation.mobile.pages.HomePage;
import com.automation.mobile.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelendroidTest extends AbstractBaseTest {

    @BeforeTest
    public void setUp() {
        initAndroidDriver();
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    @CsvFileParameters(path = "test-data.csv")
    public void enterValueInTextbox(String name, String email, String username, String password) {
        HomePage home = new HomePage();
        home.setValue(name);
        Assert.assertEquals(name, home.verifyValue(), "Name should be same as entered.");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    @CsvFileParameters(path = "test-data.csv")
    public void newRegistrationWithRequiredDetails(String name, String email, String username, String password) {
        HomePage home = new HomePage();
        RegistrationPage reg = new RegistrationPage();
        ConfirmRegistrationPage confirmReg = new ConfirmRegistrationPage();
        Assert.assertTrue(home.isPageDisplayed(), "Homepage should be displayed.");
        home.goToNewRegistration();
        Assert.assertTrue(reg.isPageDisplayed(), "Registration page should be displayed.");
        reg.newRegistration(username,email,password,name);
        Assert.assertTrue(confirmReg.isPageDisplayed(), "Confirm Registration page should be displayed.");
        Assert.assertEquals(name, confirmReg.getNameLabel(), "Name should be same as entered.");
        Assert.assertEquals(email, confirmReg.getEmailLabel(), "Email should be same as entered.");
        Assert.assertEquals(username, confirmReg.getUsernameLabel(), "Username should be same as entered.");
        confirmReg.confirmRegistration();
    }

    @Test
    public void verifyTextMessageDisplayed() {
        HomePage home = new HomePage();
        home.displayTextMessage();
        Assert.assertTrue(home.verifyTextMessage(), "Text message should be displayed.");
    }

    @Test
    public void verifyAlertPopupDisplayedAndClose() {
        HomePage home = new HomePage();
        home.displayAlert();
        Assert.assertTrue(home.verifyAlert(), "Alert pop up should be displayed.");
        home.closeAlert();
    }

    @Test
    public void verifyConfirmAlertPopupDisplayedAndClose() {
        HomePage home = new HomePage();
        home.displayAlert();
        Assert.assertTrue(home.verifyAlert(), "Alert pop up should be displayed.");
        home.closeAlert();
    }

    @AfterTest
    public void tearDown() {
        quitAndroidDriver();
    }
}