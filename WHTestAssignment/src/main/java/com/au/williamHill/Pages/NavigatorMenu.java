package com.au.williamHill.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.au.williamHill.Actions.UserActions;
import com.au.williamHill.TestUtils.TestUtil;
import com.au.williamHill.baseSetup.BasePage;

public class NavigatorMenu extends BasePage {

	@FindBy(css = "#app > div > div.App_root_3WJ > div.App_navigation_3Ku > div > nav > div > div > div > div:nth-child(1) > div.MenuItem_header_HGG > a:nth-child(1) > div > div > div:nth-child(1)")
	public static WebElement racingMenu;

	@FindBy(xpath = ".//nav/div/div/div/div[2]/div[1]/a[1]/div/div/div[1]")
	public static WebElement sportsMenu;

	@FindBy(xpath = ".//nav/div/div/div/div[3]/div[1]/a[1]/div/div/div[1]")
	public static WebElement rapidKenoMenu;

	@FindBy(xpath = ".//nav/div/div/div/div[4]/div[1]/a[1]/div/div/div[1]")
	public static WebElement planetLotteryMenu;

	// Method to navigate to Racing Menu
	public static void navToRacingMenu() throws InterruptedException {

		TestUtil.waitForElement(racingMenu);
		UserActions.clickAction(racingMenu);
	}

	// Method to navigate to Sports Menu
	public static void navToSportsMenu() throws InterruptedException {
		TestUtil.waitForElement(sportsMenu);
		UserActions.clickAction(sportsMenu);
	}

	// Method to navigate to Rapid Keno Menu
	public static void navToRapidKenoMenu() throws InterruptedException {
		TestUtil.waitForElement(rapidKenoMenu);
		UserActions.clickAction(rapidKenoMenu);
	}

	// Method to navigate to Planet Lottery Menu
	public static void navToPlanetLotteryMenu() throws InterruptedException {
		TestUtil.waitForElement(planetLotteryMenu);
		UserActions.clickAction(planetLotteryMenu);
	}

}
