package com.automation.mobile.pages;

import com.automation.mobile.tests.AbstractBaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static com.automation.mobile.commons.AndroidActions.*;

public class ConfirmRegistrationPage {

    private static AppiumDriver mobileDriver = AbstractBaseTest.getAndroidDriver;

    public String getNameLabel(){
        WebElement nameLabel = element("id", "io.selendroid.testapp:id/label_name_data");
        return validateAndGetText(nameLabel);
    }

    public String getUsernameLabel(){
        WebElement usernameLabel = element("id", "io.selendroid.testapp:id/label_username_data");
        return validateAndGetText(usernameLabel);
    }

    public String getEmailLabel(){
        WebElement emailLabel = element("id", "io.selendroid.testapp:id/label_email_data");
        return validateAndGetText(emailLabel);
    }

    public void confirmRegistration(){
        WebElement confirmRegButton = element("id", "io.selendroid.testapp:id/buttonRegisterUser");
        validateAndClick(confirmRegButton);
    }

    public boolean isPageDisplayed()
    {
        WebElement confirmRegButton = element("id", "io.selendroid.testapp:id/buttonRegisterUser");
        waitUntilVisible(confirmRegButton, 10);
        if(confirmRegButton.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

}