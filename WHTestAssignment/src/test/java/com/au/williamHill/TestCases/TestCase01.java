package com.au.williamHill.TestCases;

import org.testng.annotations.Test;
import com.au.williamHill.baseSetup.BasePage;
import com.aventstack.extentreports.Status;

public class TestCase01 extends BasePage {

	
	//Below mentioned test case is a dummy passed test case to demonstrate Extend report
	@Test
	public void DummyPassTestCase() {

		testLevelReport.get().log(Status.INFO, "Test Case 1 is being executed");

	}

}
