package com.au.williamHill.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.au.williamHill.TestUtils.DriverManager;
import com.au.williamHill.baseSetup.BasePage;
import com.aventstack.extentreports.Status;

public class TestCase02 extends BasePage {

	//Below mentioned test case is a dummy failed test case to demonstrate Extend report
	@Test
	public void DummyFailTestCase() throws InterruptedException {
		testLevelReport.get().log(Status.INFO, "Test Case 2 is being executed");
		testLevelReport.get().log(Status.INFO, "Test Case is meant to be failed");
		DriverManager.getDriver().findElement(By.id("unknownIdToFailTheTest")).click();
	}
}