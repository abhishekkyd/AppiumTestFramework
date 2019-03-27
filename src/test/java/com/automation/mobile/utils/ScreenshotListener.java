package com.automation.mobile.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.automation.mobile.tests.AbstractBaseTest;

public class ScreenshotListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if (!result.isSuccess()) {
			AbstractBaseTest abstractBaseTest = (AbstractBaseTest) result.getInstance();
			if (abstractBaseTest.getAndroidDriver() != null) {
				File scrFile = ((TakesScreenshot) abstractBaseTest.getAndroidDriver()).getScreenshotAs(OutputType.FILE);
				try {
					String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
							+ "/test-output";
					File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
							+ formater.format(calendar.getTime()) + ".png");
					FileUtils.copyFile(scrFile, destFile);
					Reporter.log("<a href='file:\\" + destFile.getAbsolutePath() + "'> <img src='file:\\"
							+ destFile.getAbsolutePath() + "' height='25%' width='25%'/> </a>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void onStart(ITestContext testContext) {
		super.onStart(testContext);
	}
}
