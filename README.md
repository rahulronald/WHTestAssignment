# Willian Hill Test Assignment

# Introduction:
Scenario of adding Stake of '10.5' in a bet has to be automated.
In addition, basic validations has to be performed.

## Framework Insights
* Selenium WebDriver for Web Automation
* Page Object Model employing Page Factory
* Multi-threading for parallel test execution
* TestNG for Testing Framework
* Extent Report Framework for test report & logging
* Apache POI (For Excel reading & writing)
* Listeners for centralised controlling of test execution
* User defined actions (click, sendkeys, clear etc)

## Tools Used:
* Eclipse Neon

## Programming Language:
* Java

### Config File:
**Config.properties** file is also very vital, as it has all the important **URLs, browser selection** etc. All the URLs must be specified in this file. 
**config.properties** file is located under `src > test > resources > propertyFiles folder.

### Test Data File:
Important test data is to be entered in **testData.xlsx**.
It has a tab "Place Bet" from where it is reading the values for the Stake.

## Instructions to execute the test
The entire test suite is controlled by the **TestNG.xml** file, which is located under `projectroot\src\test\resources\runner`. 
Simply, right click on the **TestNG.xml** file and select Run As : **TestNG Suite**. 

## Test Cases Description
* Test Case 1: is a dummy test case for passed scenario
* Test Case 2: is a dummy test case for failed scenario
* Test Case 3: is actual test case which is performing validations on the WH's Homepage
* Test Case 4: is actual test case which is performing test scenario mentioned above

## Test Result:

### Test Report (Test Results, Logging & Screenshots):
Extent Reporting Framework is used for test reporting. 
After the test is completed, refresh the project and get the path of the Test Report by right clicking on 'extentreport.html'. Open this path in any browser for test report. 

### Test Result Screenshots:
For every failed scenario, **screenshots** are captured and stored under `Project (ABC) > test-output > screenShots` folder location. All screenshots are stored with timestamp as their name. Also, they are attached to the test report mentioned above.

### Log Files:
Logging is done in the Test report itself.


