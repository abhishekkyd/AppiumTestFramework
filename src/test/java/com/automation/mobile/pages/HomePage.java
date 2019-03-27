package com.automation.mobile.pages;

import com.automation.mobile.tests.AbstractBaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static com.automation.mobile.commons.AndroidActions.*;

public class HomePage {

    private static AppiumDriver mobileDriver = AbstractBaseTest.getAndroidDriver;

    public void goToNewRegistration(){
        WebElement newRegButton = element("id", "io.selendroid.testapp:id/startUserRegistration");
        validateAndClick(newRegButton);
    }

    public void setValue(String value)
    {
        WebElement input = element("id", "io.selendroid.testapp:id/myTextField");
        validateAndSendKeys(input, value);
    }

    public String verifyValue()
    {
        WebElement input = element("id", "io.selendroid.testapp:id/myTextField");
        return validateAndGetAttribute(input, "value");
    }

    public void displayTextMessage()
    {
        WebElement textMessage = element("id", "io.selendroid.testapp:id/showTextButton");
        validateAndClick(textMessage);
    }

    public boolean verifyTextMessage()
    {
        WebElement textMessage = element("id", "io.selendroid.testapp:id/textLabel");
        try{
            waitUntilVisible(textMessage, 5);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void displayAlert()
    {
        WebElement popup = element("id", "io.selendroid.testapp:id/showPopupWindowButton");
        validateAndClick(popup);
    }

    public void displayConfirmAlert()
    {
        WebElement popup = element("id", "io.selendroid.testapp:id/showLocatorTestButton");
        validateAndClick(popup);
    }

    public boolean verifyAlert()
    {
        return isAlertPresent();
    }

    public void closeAlert()
    {
        validateAndDismissAlert();
    }

    public void displayProgressBar()
    {
        WebElement progress = element("id", "io.selendroid.testapp:id/showProgressBarButton");
        validateAndClick(progress);
    }

    public boolean isPageDisplayed()
    {
        WebElement title = element("id", "android:id/title");
        waitUntilVisible(title, 10);
        if(title.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

    public void isTextMessage()
    {
        WebElement textMessage = element("id", "io.selendroid.testapp:id/showTextButton");
        validateAndClick(textMessage);
    }

}