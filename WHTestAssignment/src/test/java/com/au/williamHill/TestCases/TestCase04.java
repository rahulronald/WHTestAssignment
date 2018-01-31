package com.au.williamHill.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.au.williamHill.Pages.BettingPage;
import com.au.williamHill.Pages.BettingSlipPage;
import com.au.williamHill.Pages.HorseRacingPage;
import com.au.williamHill.Pages.NavigatorMenu;
import com.au.williamHill.TestUtils.DriverManager;
import com.au.williamHill.baseSetup.BasePage;

public class TestCase04 extends BasePage {

	// This Test Case test the below mentioned test scenario:
	// 1. Validation of Adding stake in a Betting Slip & Validating the same

	@Test(priority = 1)
	public void ValidateBettingSlipAmount() throws InterruptedException {
	
		PageFactory.initElements(DriverManager.getDriver(), NavigatorMenu.class);
		HorseRacingPage horseRacingPage = PageFactory.initElements(DriverManager.getDriver(), HorseRacingPage.class);
		BettingPage bettingPage = PageFactory.initElements(DriverManager.getDriver(), BettingPage.class);
		BettingSlipPage bettingSlipPage = PageFactory.initElements(DriverManager.getDriver(), BettingSlipPage .class);
		
		
		horseRacingPage.navToRacingPage();
		horseRacingPage.selectHorseRace();
		
		bettingPage.enterBettingAmount();
		bettingPage.submitBettingAmount();
		
		bettingSlipPage.openBettingSlip();
		//bettingSlipPage.uncheckWPlcCheckbox();
		bettingSlipPage.validateBettingSlipAmount();
		bettingSlipPage.submitBetSlip();

	}

}
