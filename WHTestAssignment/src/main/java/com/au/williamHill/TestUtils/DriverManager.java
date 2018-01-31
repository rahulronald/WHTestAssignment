package com.au.williamHill.TestUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/*
 * Description: This class is managing the Web Driver
 * Introduced Threads for parallel processing
 *  
 */


public class DriverManager {
		
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver(){
		return driver.get();
	}

	
	public static void setDriver(WebDriver  webdriver){
		DriverManager.driver.set( webdriver);
	}

	
	public static void maximizeBrowser(WebDriver driver){
		driver.manage().window().maximize();
	}
	
	
	public static void setImplicitWait(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
