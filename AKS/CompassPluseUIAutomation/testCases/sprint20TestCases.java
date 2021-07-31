package testCases;



import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;



import com.codoid.products.exception.FilloException;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;



import components.Generics;

import generics.basketPage;

import generics.compassPlusPage;

import generics.dealBuilderPage;

import generics.designerStudioPage;

import generics.excelReusablesUI;

import generics.genericKeywords;

import generics.interactionHistoryPage;

import generics.loginPage;

import generics.profilePannel;

import generics.smeMethods;

import generics.tradeInPage;

import testSetup.reportDirectory;

import testSetup.userExceptionMsg;



public class sprint20TestCases {



	static ExtentReports extent;

	static ExtentTest test;

	static String timestampOfCreatedDirectory,dateOfActionOnDeal,nameOfTestMethode,screenshotsPath;

	static LinkedHashMap<String, ArrayList<String>> basketPageDataMap,intractHistExpandData,basketSummHeader,dealBuilderData,basketSummeryPageDescription,basketSummeryPageHeader;

	static LinkedHashMap<String, String> intractHistUfMrcEndRevenue,basketUfMrcEndRevenue,intractionHistoryLatestRow,customerDetails_profilePannel,accountDetails_profilePannel,eligibility_profilePannel,productHolding_profilePannel,usage_profilePannel,mapExistingRelationShip,excelData;         

	public static  int flag;



	@Test(enabled=true,description="TC_07-Verify SME Advisor is able to see all the Billing details at Subscription level for SME PAYM voice CTN")

	public static void tc07_SMEAdvisorAbleToSeeSubscriptionLevelBillingDetails_multiCTN_SMEPaymVoice() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07432724464",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","0 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","0 Mins");



			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);



			//Capture data from Existing relationshiptable

			smeMethods.captureDataFromExistingRelationshipTable(screenshotsPath, true);

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=false,description="TC_06-Verify SME Advisor is able to see all the Billing details at Subscription level for SME PAYM MBB CTN")

	public static void tc06_SMEAdvisorAbleToSeeSubscriptionLevelBillingDetails_multiCTN_SMEPaymMBB() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07432724464",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","0 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","0 Mins");



			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);



			//Capture data from Existing relationshiptable

			//smeMethods.captureDataFromExistingRelationshipTable(screenshotsPath, true);

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);



			//smeMethods.captureDataFromExistingRelationshipTable(screenshotsPath, true);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);





		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC_01-Verify CS SME Advisor is able to see all the Billing details at Account level for Multi CTN BAN with SME PAYM voice")

	public static void tc01_SMEAdvisorAbleToSeeAccountLevelBillingDetails_multiCTN_SMEPaymVoice() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("163188918",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			accountDetails_profilePannel=profilePannel.getAccountDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			profilePannel.validateAccountDetailsKeyValue(accountDetails_profilePannel,"Account type","SMALL LTD / PLC");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"AVG bill amount 3M","£0.00");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","19.90 GB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","1990 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","4345 Mins");



			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);



			//Capture data from Existing relationshiptable

			//smeMethods.captureDataFromExistingRelationshipTable(screenshotsPath, true);

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeNoOfCtnLinkAccount_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC_02-Verify CS SME Advisor is able to see all the Billing details at Account level for Multi CTN BAN with SME PAYM MBB")

	public static void tc02_SMEAdvisorAbleToSeeAccountLevelBillingDetails_multiCTN_SMEMBB() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("113772449",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			accountDetails_profilePannel=profilePannel.getAccountDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			profilePannel.validateAccountDetailsKeyValue(accountDetails_profilePannel,"Account type","SMALL LTD / PLC");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"AVG bill amount 3M","£0.00");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","19.90 GB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","1990 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","4345 Mins");



			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);



			//Capture data from Existing relationshiptable

			//smeMethods.captureDataFromExistingRelationshipTable(screenshotsPath, true);

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeNoOfCtnLinkAccount_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC_03-Verify CS SME Advisor is able to see all the Billing details at Account level for a single CTN BAN with SME PAYM MBB")

	public static void tc03_SMEAdvisorAbleToSeeAccountLevelBillingDetails_singleCTN_SMEMBB() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("115513685",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			accountDetails_profilePannel=profilePannel.getAccountDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			profilePannel.validateAccountDetailsKeyValue(accountDetails_profilePannel,"Account type","SMALL LTD / PLC");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"AVG bill amount 3M","£0.00");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","19.90 GB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","1990 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","4345 Mins");



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();   

		}

	}



	@Test(enabled=false,description="TC_04-Verify CS SME Advisor is able to see all the Billing details at Account level for a single CTN BAN with SME PAYM Voice")

	public static void tc04_SMEAdvisorAbleToSeeAccountLevelBillingDetails_singleCTN_SMEPaymVoice() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07931955745",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			accountDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			profilePannel.validateCustomerDetailsKeyValue(accountDetails_profilePannel,"Account type","SMALL LTD / PLC");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"AVG bill amount 3M","£0.00");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","19.90 GB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","1990 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","4345 Mins");



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC_05-Verify Retail Advisor IS NOT able to see Account level profile panel for a BAN with SME PAYM plan")

	public static void tc05_retailAdvisorAbleToSeeSubscriptionLevelBillingDetails_SMEPaym() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectRetailAdvisorFromDropDown(screenshotsPath,true);           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.retailNewCTNsearch("4033","163188918",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","0 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","0 Mins");



			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);



			//Capture data from Existing relationshiptable

			//smeMethods.captureDataFromExistingRelationshipTable(screenshotsPath, true);

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC_08-Verify CS SME Advisor is able to see customers 3 month average usage and the detailed usage through the pop-up  at the Account level for a BAN with SME PAYM 4G wifi")

	public static void tc08_SMEAdvisorAbleToSee3MonthAvgUsageAccountLevelBillingDetails_SMEMbb4GWifi() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07931955745",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","0 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","0 Mins");



			smeMethods.validateDetailedAverageUsagePopUp(screenshotsPath, true);

			boolean validate1=smeMethods.validateValueDetailedAverageUsageTable("Data Usage");

			boolean validate2=smeMethods.validateValueDetailedAverageUsageTable("Usage");

			boolean validate3=smeMethods.validateValueDetailedAverageUsageTable("SMS");



			if(validate1){

				reportDirectory.test.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

			}

			if(validate2){

				reportDirectory.test.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

			}

			if(!validate3){

				reportDirectory.test.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

			}





			/*    Thread.sleep(2000);

                  loginPage.driver.switchTo().defaultContent();

                  Thread.sleep(2000);

                genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                  Thread.sleep(5000);

            genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

            smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);

			 */

			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=false,description="TC_09-Verify CS SME Advisor is able to see customers 3 month average usage and the detailed usage through the pop-up  at the Account level for a BAN awith SME PAYM  voice")

	public static void tc09_SMEAdvisorAbleToSee3MonthAvgUsageAccountLevelBillingDetails_SMEPayMVoice() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07535574355",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","0 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","0 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","2 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","322 Mins");



			smeMethods.validateDetailedAverageUsagePopUp(screenshotsPath, true);

			boolean validate1=smeMethods.validateValueDetailedAverageUsageTable("Data Usage");

			boolean validate2=smeMethods.validateValueDetailedAverageUsageTable("Usage");

			//boolean validate3=smeMethods.validateValueDetailedAverageUsageTable("SMS");



			if(validate1){

				reportDirectory.test.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

			}

			if(validate2){

				reportDirectory.test.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

			}

			/*if(!validate3){

                        reportDirectory.test.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

                      reportDirectory.test_consolidated.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

                  }else {

                        reportDirectory.test.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

                      reportDirectory.test_consolidated.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

                  }*/





			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=false,description="TC_10-Verify SME Advisor is able to customers 3 month average usage and the detailed usage through the pop-up   at the Subscription level for SME PAYM 4G wifi CTN ")

	public static void tc10_SMEAdvisorAbleToSee3MonthAvgUsageSubscriptionLevelBillingDetails_SMEMbb4GWifi() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07931955745",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","32 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","0 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","0 Mins");



			smeMethods.validateDetailedAverageUsagePopUp(screenshotsPath, true);

			boolean validate1=smeMethods.validateValueDetailedAverageUsageTable("Data Usage");

			boolean validate2=smeMethods.validateValueDetailedAverageUsageTable("Usage");

			boolean validate3=smeMethods.validateValueDetailedAverageUsageTable("SMS");



			if(validate1){

				reportDirectory.test.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

			}

			if(validate2){

				reportDirectory.test.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

			}

			if(!validate3){

				reportDirectory.test.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

			}





			/*    Thread.sleep(2000);

                  loginPage.driver.switchTo().defaultContent();

                  Thread.sleep(2000);

                genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                  Thread.sleep(5000);

            genericKeywords.locateElement("smeExistingRelationShipBanHeader_xpath", loginPage.driver).sendKeys(Keys.ENTER);

            smeMethods.validateAccoutLevelProfilePanel(screenshotsPath, true);

			 */

			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC_11-Verify SME Advisor is able to customers 3 month average usage and the detailed usage through the pop-up   at the Subscription level for SME PAYM 4G voice CTN")

	public static void tc11_SMEAdvisorAbleToSee3MonthAvgUsageSubscriptionLevelBillingDetails_SMEPayMVoice() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                  System.out.println(requestDataSheetList);

                  String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                  System.out.println(request);

                  int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                  System.out.println(statuscode);

                  Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07535574355",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                 

			//eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                             

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                             

			usage_profilePannel=profilePannel.getPegasusUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));     

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","GOVERNMENT");

			//profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","22/12/2018 - 21/08/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill date","25/06/2020");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Last bill amount","£1138.58");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Avg bill amount","£25.94");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","0 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","0 MB");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Zero rated data","Yes");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"International 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Roaming 3m","0 Mins");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"SMS 3m","2 Sent");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"All voice 3m","322 Mins");



			smeMethods.validateDetailedAverageUsagePopUp(screenshotsPath, true);

			boolean validate1=smeMethods.validateValueDetailedAverageUsageTable("Data Usage");

			boolean validate2=smeMethods.validateValueDetailedAverageUsageTable("Usage");

			//boolean validate3=smeMethods.validateValueDetailedAverageUsageTable("SMS");



			if(validate1){

				reportDirectory.test.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Data usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Data usage section is not found inside Detailed Average Usage");

			}

			if(validate2){

				reportDirectory.test.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Usage section is present inside Detailed Average Usage");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Usage section is not found inside Detailed Average Usage");

			}

			/*if(!validate3){

                        reportDirectory.test.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

                      reportDirectory.test_consolidated.log(LogStatus.PASS, "SMS is not found inside Detailed Average Usage for Wifi plans");

                  }else {

                        reportDirectory.test.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

                      reportDirectory.test_consolidated.log(LogStatus.FAIL, "SMS is found inside Detailed Average Usage for Wifi plans");

                  }*/





			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=false,description="TC100_Verify that SME Advisor is able to add recommended devices and plans")

	public static void tc100_SMEAdvisorAbleToAddRecommendedDeviceAndPlans() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                        System.out.println(requestDataSheetList);

                        String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                        System.out.println(request);

                        int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                        System.out.println(statuscode);

                        Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07931573002",screenshotsPath,true);





			//Click Apply

			/*     loginPage.driver.switchTo().frame("PegaGadget2Ifr");

                        Thread.sleep(2000);

                  genericKeywords.locateElement("smeDetailsApplyBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                        loginPage.driver.switchTo().defaultContent();

                        Thread.sleep(5000);

			 */   

			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);

			//Thread.sleep(5000);

			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                 



			//Save tools Tab//

			compassPlusPage.selectSaveToolsTab(screenshotsPath,false);     



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Swappable Benefits - 1",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("SME Spend Cap",screenshotsPath,true);



			/*    //Trad-In Tab//              

                        compassPlusPage.selectTab("Trade In",screenshotsPath,false);

                     tradeInPage.selectTradeInDevice(screenshotsPath,true);

                        tradeInPage.captureDataFromTradeInTab();

                  genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                        Thread.sleep(3000);

			 */

			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                 

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);           

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);           

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//Deal builder Validation with basket Summary//

			for(String key_basketSummeryPageDescription: basketSummeryPageDescription.keySet()){

				System.out.println(key_basketSummeryPageDescription);

				ArrayList<String> values=basketSummeryPageDescription.get(key_basketSummeryPageDescription);

				values.remove(0);

			}

			System.out.println("Updated New Basket map: "+basketSummeryPageDescription);

			if(dealBuilderData.size() == basketSummeryPageDescription.size()) {

				if(dealBuilderData.keySet().equals(basketSummeryPageDescription.keySet())) {

					dealBuilderData.values().equals(basketSummeryPageDescription.values());



					reportDirectory.test.log(LogStatus.PASS, "Deal Builder Data and Basket Summery Data are identical");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Deal Builder Data and Basket Summery Data are identical");

				}else {

					reportDirectory.test.log(LogStatus.FAIL, "Deal Builder Data and Basket Summery Data are not identical");

					reportDirectory.test_consolidated.log(LogStatus.FAIL, "Deal Builder Data and Basket Summery Data are not identical");

				}

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Deal Builder Map and Basket Summery Map size are not identical");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Deal Builder Map and Basket Summery Map size are not identical");

			}





			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=true,description="TC106_TC106_Verify that SME Advisor is able to add AddOn to a SME customer only once for a selected AddOn(CTN level)")

	public static void tc106_SMEAdvisorAbleToAddAddOnsToASMECustomersOnce() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                        System.out.println(requestDataSheetList);

                        String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                        System.out.println(request);

                        int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                        System.out.println(statuscode);

                        Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07931573002",screenshotsPath,true);





			//Click Apply

			/*     loginPage.driver.switchTo().frame("PegaGadget2Ifr");

                        Thread.sleep(2000);

                  genericKeywords.locateElement("smeDetailsApplyBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                        loginPage.driver.switchTo().defaultContent();

                        Thread.sleep(5000);

			 */   

			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);

			//Thread.sleep(5000);

			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                 



			//Save tools Tab//

			compassPlusPage.selectSaveToolsTab(screenshotsPath,false);     



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Spend Cap",screenshotsPath,false);

			//compassPlusPage.selectAddOnsFromAddOnsTab("Swappable Benefits - 1",screenshotsPath,true);



			/*    //Trad-In Tab//              

                        compassPlusPage.selectTab("Trade In",screenshotsPath,false);

                     tradeInPage.selectTradeInDevice(screenshotsPath,true);

                        tradeInPage.captureDataFromTradeInTab();

                  genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                        Thread.sleep(3000);

			 */



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}    

	@Test(enabled=true,description="TC107_TC107_Verify that SME Advisor is able to add AddOn to a MBB customer only once for a selected AddOn")

	public static void tc107_SMEAdvisorAbleToAddAddOnsToASME_MBBCustomersOnce() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                 

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

			//System.out.println(excelData);



			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

                        System.out.println(requestDataSheetList);

                        String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

                        System.out.println(request);

                        int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

                        System.out.println(statuscode);

                        Assert.assertEquals(statuscode,200,"status code validation failed");*/



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);      

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);     



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07931955745",screenshotsPath,true);





			//Click Apply

			/*     loginPage.driver.switchTo().frame("PegaGadget2Ifr");

                        Thread.sleep(2000);

                  genericKeywords.locateElement("smeDetailsApplyBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                        loginPage.driver.switchTo().defaultContent();

                        Thread.sleep(5000);

			 */   

			//Select call Reason//

			compassPlusPage.selectSmeCallReason("Upgrade",screenshotsPath,true);

			//Thread.sleep(5000);

			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                 



			//Save tools Tab//

			compassPlusPage.selectSaveToolsTab(screenshotsPath,false);     



			//Add on Tab//



			compassPlusPage.selectAddOnsFromAddOnsTab("Swappable Benefits - 1",screenshotsPath,true);

			compassPlusPage.selectAddOnsFromAddOnsTab("SME Spend Cap",screenshotsPath,false);



			/*    //Trad-In Tab//              

                        compassPlusPage.selectTab("Trade In",screenshotsPath,false);

                     tradeInPage.selectTradeInDevice(screenshotsPath,true);

                        tradeInPage.captureDataFromTradeInTab();

                  genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

                        Thread.sleep(3000);

			 */



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}    



	@AfterMethod

	public void tearDown(ITestResult result) throws IOException {



		if(result.getStatus()==ITestResult.FAILURE){

			try {

				String timeStamp=Generics.getTimestamp();

				String fileName=nameOfTestMethode+"_"+timeStamp+".png";                       

				String directory=screenshotsPath;

				File SrcFile=((TakesScreenshot) loginPage.driver).getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(SrcFile, new File(directory + fileName));

				//String DestFile=directory + fileName;



				String pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				reportDirectory.test.log(LogStatus.FAIL, "After Class Executed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "After Class Executed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				System.out.println("Screenshot taken");



			}catch(Exception e) {

				e.printStackTrace();

			}

		}

		loginPage.driver.quit();

		reportDirectory.test.log(LogStatus.INFO, "End of Execution");

		reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");   

		reportDirectory.report.endTest(reportDirectory.test);                       

		reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		reportDirectory.report.flush();

		reportDirectory.report_consolidated.flush();

		reportDirectory.report.close();

		reportDirectory.report_consolidated.close();

	}

}