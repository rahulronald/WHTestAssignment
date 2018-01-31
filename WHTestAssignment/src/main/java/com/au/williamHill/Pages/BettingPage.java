package com.au.williamHill.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.au.williamHill.Actions.UserActions;
import com.au.williamHill.TestUtils.TestUtil;
import com.au.williamHill.baseSetup.BasePage;

public class BettingPage extends BasePage {

	@FindBy(css = "#mystery-bet > form > div.MysteryBet_currencyBox_3uD.CurrencyBox_root_2Lh > div > input")
	public static WebElement bettingAmount;
	
	@FindBy(className = "MysteryBet_button_2oL")
	public static WebElement bettingButton;

	public void enterBettingAmount() throws InterruptedException {
		TestUtil.waitForElement(bettingAmount);
		UserActions.clearAction(bettingAmount);
		
		UserActions.typeAction(bettingAmount, excel.getCellData("Place Bet", "Stake Amount", 2));
		testLevelReport.get().info("Successfully entered Stake amount");
	}

	public void submitBettingAmount() throws InterruptedException {
		TestUtil.waitForElement(bettingButton);
		UserActions.clickAction(bettingButton);
		testLevelReport.get().info("Submitted the bet successfully");
	}

}
