package com.au.williamHill.Actions;

import org.openqa.selenium.WebElement;

import com.au.williamHill.baseSetup.BasePage;
import com.aventstack.extentreports.Status;


// This method is for User Actions
public class UserActions extends BasePage {
	
	//This function performs the Click action of the mouse
	public static void clickAction(WebElement element) throws InterruptedException{
		testLevelReport.get().log(Status.INFO, "Inside ClickAction Method");
		element.click();
		testLevelReport.get().log(Status.INFO, "Element Clicked Successfully");
	}
	
	//This function clears the text entered in a text box 
	public static void clearAction(WebElement element) throws InterruptedException{
		testLevelReport.get().log(Status.INFO, "Inside ClearAction Method");
		element.clear();
		testLevelReport.get().log(Status.INFO, "Text is cleared from the WebElement");
	}

	//This function performs the type action and write text in a text box 
	public static void typeAction(WebElement element, String text) throws InterruptedException{
		testLevelReport.get().log(Status.INFO, "Inside TypeAction Method");
		element.sendKeys(text);
		testLevelReport.get().log(Status.INFO, "Text is typed in the WebElement");
		
	}
	
}
