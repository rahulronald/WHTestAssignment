package com.au.williamHill.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.au.williamHill.Pages.HomePage;
import com.au.williamHill.TestUtils.DriverManager;
import com.au.williamHill.baseSetup.BasePage;

public class TestCase03 extends BasePage {

	// This test case would have all the basic validation test cases on William
	// Hill's Home Page
	// This Test Case test the below mentioned test scenario:
	// 1. Validation of William Hill's Homepage URL
	// 2. Validation of William Hill's Homepage Title
	// 3. Validation of William Hill's Homepage content

	@Test (priority = 1)
	public void ValidateHomePageContent() throws InterruptedException {

		HomePage homePage = PageFactory.initElements(DriverManager.getDriver(), HomePage.class);

		homePage.validateHomePageUrl();
		homePage.validateHomePageTitle();
		homePage.validateHomePageContent();
	}

}
