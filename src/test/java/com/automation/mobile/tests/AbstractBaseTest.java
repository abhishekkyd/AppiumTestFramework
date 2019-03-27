package com.automation.mobile.tests;

import com.automation.mobile.commons.DriverClass;

import io.appium.java_client.AppiumDriver;

public abstract class AbstractBaseTest {
	private final DriverClass driverClass;
	public static AppiumDriver getAndroidDriver;

	public AbstractBaseTest() {
		driverClass = new DriverClass();
	}

	protected void initAndroidDriver() {
		this.getAndroidDriver = (AppiumDriver) driverClass.getAndroidDriver();
	}

	public void quitAndroidDriver() {
		driverClass.quitAndroidDriver();
	}

	public AppiumDriver getAndroidDriver() {
		return getAndroidDriver;
	}

	public void launchApp() {
		this.getAndroidDriver.launchApp();
	}

	public void closeApp() {
		this.getAndroidDriver.closeApp();
	}

	public void goBack() throws InterruptedException {
		this.getAndroidDriver.navigate().back();
		Thread.sleep(2000);
	}
}
