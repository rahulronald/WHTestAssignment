package com.au.williamHill.baseSetup;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.au.williamHill.Actions.UserActions;
import com.au.williamHill.TestUtils.DriverFactory;
import com.au.williamHill.TestUtils.DriverManager;
import com.au.williamHill.TestUtils.ExcelReader;
import com.au.williamHill.TestUtils.ExtentManager;
import com.au.williamHill.TestUtils.PropertyFileManager;
import com.au.williamHill.TestUtils.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/* This is an important class
* Every other class extends this class as in this class all the important functions are declared
* This class also has all the TestNG base annotation like BeforeTest, BeforeMethod etc..
*/

public class BasePage {

	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();

	protected WebDriver driver = null;
	protected static Properties configProperty;
	public static FileInputStream fis;
	public static TestUtil util;
	public static UserActions userActions;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testData.xlsx");

	// ************************
	// ******Before Suite******
	// ************************
	@BeforeSuite
	public void setUp() {

		PropertyFileManager.setConfigFilePath(
				System.getProperty("user.dir") + "\\src\\test\\resources\\propertyFiles\\config.properties");
		DriverFactory.setChromeExeFilePath("chromedriver.exe");
		DriverFactory.setIeExeFilePath("IEDriverServer.exe");
		extent = ExtentManager.GetExtent();
	}

	// ************************
	// ******Before Test*******
	// ************************
	@BeforeTest
	public void beforeTest() {

	}

	// ************************
	// ******Before Class******
	// ************************
	@BeforeClass
	public synchronized void beforeClass() {
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		classLevelReport.set(parent);
		configProperty = PropertyFileManager.createConfigFileProperty();
	}

	// ************************
	// *****Before Method******
	// ************************
	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = classLevelReport.get().createNode(method.getName());
		testLevelReport.set(child);

		WebDriver driver = null;
		if (driver == null) {
			driver = DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
			testLevelReport.get().log(Status.INFO, "Driver is successfully instantiated");
			testLevelReport.get().log(Status.INFO, "Browser is launched successfully");
			testLevelReport.get().log(Status.INFO, "Test Browser is: " + configProperty.getProperty("browser"));
			DriverManager.getDriver().navigate().to(configProperty.getProperty("TestUrl"));
			testLevelReport.get().log(Status.INFO, "Application is being launched");
		}
	}

	// ************************
	// ******After Method******
	// ************************
	@AfterMethod
	public synchronized void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			testLevelReport.get().fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			testLevelReport.get().skip(result.getThrowable());
		} else {
			testLevelReport.get().pass("Test passed");
		}

		extent.flush();
		driver = DriverManager.getDriver();
		DriverFactory.destroyDriverInstance(driver);
		testLevelReport.get().log(Status.INFO, "Driver's current instance is successfully destroyed");
	}

}
