package com.au.williamHill.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.au.williamHill.baseSetup.BasePage;

public class TestUtil extends BasePage {

	public static String screenshotPath;
	public static String screenshotName;

	/*
	 * @description: Method to take capture screenshot
	 */
	public static void captureScreenshot() throws IOException {

		screenshotPath = "./Screenshots/";
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile, new File(screenshotPath + screenshotName));
	}

	public static boolean isElementPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
