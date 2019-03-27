package com.automation.mobile.commons;

import com.automation.mobile.tests.AbstractBaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndroidActions {

	private static AppiumDriver mobileDriver = AbstractBaseTest.getAndroidDriver;

	public static WebElement element(String value) {
		WebElement element = null;
		element = mobileDriver.findElement(MobileBy.xpath(value));
		return element;
	}

	public static WebElement element(String type, String value) {
		WebElement element = null;
		String locatorType = type.toLowerCase();
		switch (locatorType) {
			case "id":
				element = mobileDriver.findElement(MobileBy.id(value));
				break;
			case "xpath":
				element = mobileDriver.findElement(MobileBy.xpath(value));
				break;
			case "class":
				element = mobileDriver.findElement(MobileBy.className(value));
				break;
			case "css":
				element = mobileDriver.findElement(MobileBy.cssSelector(value));
				break;
			default:
				break;
		}
		return element;
	}

	public static void validateAndSendKeys(WebElement element, String value) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(value);
		} else {
			System.out.println("Either element is not displayed or not enabled.");
		}
	}

	public static void validateSendKeysAndEnter(WebElement element, String value) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(value + Keys.ENTER);
		} else throw new  RuntimeException("element is either not displayed or enabled");
	}

	public static void validateAndClick(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		} else throw new  RuntimeException("element is either not displayed or enabled");
	}

	public static String validateAndGetText(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			return element.getText();
		} else throw new  RuntimeException("element is either not displayed or enabled");
	}

	public static String validateAndGetAttribute(WebElement element, String attribute) {
		if (element.isDisplayed() && element.isEnabled()) {
			return element.getAttribute(attribute);
		} else throw new  RuntimeException("element is either not displayed or enabled");
	}

	public static void waitUntilVisible(WebElement element, int timeOutInSec) {
		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(mobileDriver)
					.withTimeout(Duration.ofSeconds(timeOutInSec))
					.pollingEvery(Duration.ofMillis(50))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
			fWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw new  RuntimeException("element is either not displayed or enabled");
		}
	}

	public static void waitUntilClickable(WebElement element, int timeOutInSec) {
		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(mobileDriver)
					.withTimeout(Duration.ofSeconds(timeOutInSec))
					.pollingEvery(Duration.ofMillis(50))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
			fWait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw new  RuntimeException("element is either not displayed or enabled");
		}
	}

	public static void waitForNotVisible(WebElement element, int timeOutInSec) {
		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(mobileDriver)
					.withTimeout(Duration.ofSeconds(timeOutInSec))
					.pollingEvery(Duration.ofMillis(50));
			fWait.until(ExpectedConditions.invisibilityOf(element));
		} catch (org.openqa.selenium.NoSuchElementException ignored) {
		} catch (org.openqa.selenium.TimeoutException e) {
			throw new  RuntimeException("element is either not displayed or enabled");
		}
	}

	public static void waitForTitle(String title, int timeOutInSec) {
		try {
			FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(mobileDriver).withTimeout(timeOutInSec, TimeUnit.SECONDS)
					.withTimeout(Duration.ofSeconds(timeOutInSec))
					.pollingEvery(Duration.ofMillis(50));
			fWait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			throw new  RuntimeException("element is either not displayed or enabled");
		}
	}

	public static boolean isAlertPresent() {
		try{
			mobileDriver.switchTo().alert();
			return true;
		} catch (Exception e){
			return false;
		}
	}

	public static void validateAndAcceptAlert() {
		try{
			Alert alert = mobileDriver.switchTo().alert();
			alert.accept();
		} catch (Exception e){
			throw new  RuntimeException("alert is either not displayed or it is not an alert");
		}
	}

	public static void validateAndDismissAlert() {
		try{
			Alert alert = mobileDriver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e){
			throw new  RuntimeException("alert is either not displayed or it is not an alert");
		}
	}
}
