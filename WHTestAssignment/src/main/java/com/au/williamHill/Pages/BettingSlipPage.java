package com.au.williamHill.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.au.williamHill.Actions.UserActions;
import com.au.williamHill.TestUtils.TestUtil;
import com.au.williamHill.baseSetup.BasePage;
import com.aventstack.extentreports.Status;

public class BettingSlipPage extends BasePage {

	@FindBy(css = "button.Button_button_1Hw.SideBar_button_Hgk.SideBar_buttonSelected_3Rx > span > span")
	private static WebElement betSlipButton;

	@FindBy(css = "div.TicketContainer_container_2TR > div.SingleHeader_betInfo_Gjd > div.SingleHeader_oddsAndOptions_1gV > div > button > div > span.CheckBox_iconContainer_2z1")
	private static WebElement checkBoxWPlc;

	@FindBy(css = "div.SideBar_content_Et8 > section > section > div:nth-child(3) > span:nth-child(2) > span")
	private static WebElement betStakeAmountt;

	@FindBy(css = "div.SideBar_content_Et8 > section > div > div > section > div > div.TicketContainer_ticket_27a > div.TicketContainer_container_2TR > div:nth-child(2) > div > div.StakeNew_stakes_1bS > div > div > div > input")
	private static WebElement betStakeAmount;

	@FindBy(css = "div > div.SideBar_content_Et8 > section > section > div:nth-child(4) > button.Button_button_1Hw.Button_color_28N.Button_green_3Ux.Betslip_placeBets_3xf")
	private static WebElement placeBetsButton;

	@FindBy(css = "body > div.ReactModalPortal > div > div > div > div.Modal_body_1Kr > div > h2")
	private static WebElement LoginTitle;

	public void openBettingSlip() throws InterruptedException {
		TestUtil.waitForElement(betSlipButton);
		UserActions.clickAction(betSlipButton);
		testLevelReport.get().info("Bet slip is opened successfully");
	}

	public void uncheckWPlcCheckbox() throws InterruptedException {
		if (TestUtil.isElementPresent(checkBoxWPlc)) {
			UserActions.clickAction(checkBoxWPlc);
		}
	}

	public void validateBettingSlipAmount() {

		String BetStatkeAmount = betStakeAmount.getText();
		Assert.assertEquals(BetStatkeAmount, excel.getCellData("PlaceBet", "Stake Amount", 2),
				"Bet Stake Amount does not match");
		testLevelReport.get().info("Stake Amount is matching");
	}

	public void submitBetSlip() throws InterruptedException {
		UserActions.clickAction(placeBetsButton);
		Assert.assertEquals(LoginTitle.getText(), "Welcome back", "Login Title mismatch");
		testLevelReport.get().log(Status.INFO, "Welcome Back Title is displayed for Login Dialog");
	}

}
