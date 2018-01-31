package com.au.williamHill.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.au.williamHill.TestUtils.DriverManager;
import com.au.williamHill.TestUtils.TestUtil;
import com.au.williamHill.baseSetup.BasePage;
import com.aventstack.extentreports.Status;

public class HomePage extends BasePage {

	@FindBy(css = "#app > div > div.App_root_3WJ > div.App_navigation_3Ku > div > a > img.NavigationView_logo_2rZ")
	public WebElement homepageLogo;

	@FindBy(xpath = ".//*[@id='app']/div/div[1]/div[3]/div/div[1]/button[2]")
	public WebElement betSlipLink;

	// This method is validating the Home Page Url
	public void validateHomePageUrl() {
		String expectedUrl = "https://www.williamhill.com.au/";
		testLevelReport.get().log(Status.INFO,
				"William Hill's URL actual url is: " + DriverManager.getDriver().getCurrentUrl());
		Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), expectedUrl,
				"William Hill's HomePage url does not match");
		testLevelReport.get().log(Status.INFO, "William Hill's URL validated successfully");
	}

	// This method is validating the Home Page' Title
	public void validateHomePageTitle() {
		String expectedTitle = "Sports Betting Online & Horse Racing in Australia - William Hill";
		testLevelReport.get().log(Status.INFO,
				"William Hill's actual title is: " + DriverManager.getDriver().getTitle());
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle,
				"William Hill's HomePage Title does not match");
		testLevelReport.get().log(Status.INFO, "William Hill's Title validated successfully");
	}

	// This method is validating the Bet Slip button text located on the
	// top-right corner of the Home Page
	public void validateHomePageContent() throws InterruptedException {

		TestUtil.waitForElement(betSlipLink);
		String betSlipText = betSlipLink.getText();
		testLevelReport.get().log(Status.INFO, "Bet Slip text is : " + betSlipText);
		Assert.assertEquals(betSlipText, "Bet slip", "Bet Slip text does not match");
		testLevelReport.get().log(Status.INFO, "Bet Slip text validated successfully");

		String homePageLogoText = homepageLogo.getAttribute("alt");
		testLevelReport.get().log(Status.INFO, "Homepage Logo text is : " + homePageLogoText);
		Assert.assertEquals(homePageLogoText, "William Hill Logo", "Home Page logo text does not match");
		testLevelReport.get().log(Status.INFO, "William Hill logo text validated successfully");

	}

}
