package com.automation.mobile.pages;

import com.automation.mobile.tests.AbstractBaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static com.automation.mobile.commons.AndroidActions.*;

public class RegistrationPage {

    private static AppiumDriver mobileDriver = AbstractBaseTest.getAndroidDriver;

    public void newRegistration(String username, String email, String password, String name){
        WebElement usernameInput = element("id", "io.selendroid.testapp:id/inputUsername");
        WebElement emailInput = element("id", "io.selendroid.testapp:id/inputEmail");
        WebElement passwordInput = element("id", "id = \"io.selendroid.testapp:id/inputPassword");
        WebElement nameInput = element("id", "io.selendroid.testapp:id/inputName");
        WebElement acceptCheckbox = element("id", "io.selendroid.testapp:id/input_adds");
        WebElement registerButton = element("id", "io.selendroid.testapp:id/btnRegisterUser");
        validateAndSendKeys(usernameInput,username);
        validateAndSendKeys(emailInput,email);
        validateAndSendKeys(passwordInput,password);
        validateAndSendKeys(nameInput,name);
        validateAndClick(acceptCheckbox);
        validateAndClick(registerButton);
    }

    public boolean isPageDisplayed()
    {
        WebElement registerButton = element("id", "io.selendroid.testapp:id/btnRegisterUser");
        waitUntilVisible(registerButton, 10);
        if(registerButton.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

}