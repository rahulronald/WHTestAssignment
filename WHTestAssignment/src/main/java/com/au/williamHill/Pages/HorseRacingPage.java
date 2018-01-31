package com.au.williamHill.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.au.williamHill.TestUtils.TestUtil;
import com.au.williamHill.baseSetup.BasePage;

public class HorseRacingPage extends BasePage {

	@FindBy(css = "#app > div > div.App_root_3WJ > div.App_contentContainer_3od > div > div > div.TilesLayout_contentContainer_2p5 > div > div > div:nth-child(4) > div:nth-child(1) > div.Grid_grid_225 > div.Grid_content_3_1 > div > div:nth-child(1) > a:nth-child(4)")
	private static WebElement race;

	@FindBy(xpath = "//*[@id="+"app"+"]/div/div[1]/div[4]/div/div/div[1]/div/div/div[4]/div[1]/div[2]/div[2]/div/div[1]/a[5]")
	private static WebElement racee;

	@FindBy(xpath = ".//*[@id='mystery-bet']/form/div[2]/div/input")
	private static WebElement betStake;

	@FindBy(className = "MysteryBet_button_2oL")
	private static WebElement addToBetSlipButton;

	public void navToRacingPage() throws InterruptedException {
		NavigatorMenu.navToRacingMenu();
	}

	public void selectHorseRace() throws InterruptedException {
		TestUtil.waitForElement(race);
		Thread.sleep(2000L);
		race.click();
		race.click();
	}

}
