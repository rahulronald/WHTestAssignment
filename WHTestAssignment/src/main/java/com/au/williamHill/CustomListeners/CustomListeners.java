package com.au.williamHill.CustomListeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.au.williamHill.TestUtils.TestUtil;
import com.au.williamHill.baseSetup.BasePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/*
 * Listeners are used here
 */
public class CustomListeners extends BasePage implements ITestListener, ISuiteListener {

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * Perform below set of actions when test is failed
	 */
	public void onTestFailure(ITestResult arg0) {

		try {
			TestUtil.captureScreenshot();
		} catch (Exception e) {

		}

		String exceptionMessage = "";
		exceptionMessage = arg0.getThrowable().getMessage();
		exceptionMessage = exceptionMessage + " " + Arrays.toString(arg0.getThrowable().getStackTrace());

		testLevelReport.get().log(Status.FAIL,
				"<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>");

		try {

			testLevelReport.get().fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotPath + TestUtil.screenshotName)
							.build());
		} catch (IOException e) {

		}
		String text = "This Test case got failed";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		testLevelReport.get().log(Status.FAIL, m);
		extent.flush();
	}

	/*
	 * Perform below set of actions when test is skipped
	 */
	public void onTestSkipped(ITestResult arg0) {
		String text = "This Test case got Skipped";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.AMBER);
		testLevelReport.get().log(Status.SKIP, m);
		testLevelReport.get().log(Status.SKIP, "TestCase- " + arg0.getName() + " Skipped");
		extent.flush();
	}

	/*
	 * Perform below set of actions when test has started Log the Test Case name
	 * in the logger
	 */
	public void onTestStart(ITestResult arg0) {

		ExtentTest t = classLevelReport.get().createNode(arg0.getMethod().getMethodName());
		testLevelReport.set(t);

		testLevelReport.get().log(Status.INFO,
				"<b>" + "Execution of Test Case: " + arg0.getName() + " started" + "</b>");
	}

	/*
	 * Perform below set of actions when test has passed
	 */
		public void onTestSuccess(ITestResult arg0) {
		String text = "TestCase- " + arg0.getName() + " PASS";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		testLevelReport.get().log(Status.PASS, m);
		extent.flush();
	}

}
