package testCases;



import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

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



public class smeUpgradeJourney {





	static ExtentReports extent;

	static ExtentTest test;

	static String timestampOfCreatedDirectory,dateOfActionOnDeal,nameOfTestMethode,screenshotsPath;

	static LinkedHashMap<String, ArrayList<String>> basketPageDataMap,basketPageDataMap2,intractHistExpandData,intractHistExpandData2,basketSummHeader,dealBuilderData,dealBuilderData2,basketSummeryPageDescription,basketSummeryPageDescription2,basketSummeryPageDescriptionFooter,basketSummeryPageHeader,basketSummeryPageHeader2,pegasusIntractHistUfMrcEndRevenue;

	static LinkedHashMap<String, String> intractHistUfMrcEndRevenue,intractHistfooter,dealBuilderPageUfMrcEndRevenue,basketUfMrcEndRevenue,basketUfMrcEndRevenue2,basketUfMrcEndRevenueFooter,intractionHistoryLatestRow,intractionHistoryDeal1Row,intractionHistoryDeal2Row,intractionHistoryLatestRow2,customerDetails_profilePannel,eligibility_profilePannel,productHolding_profilePannel,usage_profilePannel,excelData;           

	public static  int flag;

	static final boolean runTestCase=false;

	static final boolean runTestCaseDemo=true;



	//static final boolean runTestCase1=true;

	@BeforeTest

	public static void setup() {

		reportDirectory.timestamp=Generics.getTimestamp();  

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+"Consolidated Regression Report_"+reportDirectory.timestamp+".html");

		reportDirectory.report_consolidated.loadConfig(new File(System.getProperty("user.dir")+"/consolidated-extent-config.xml"));

	}

	@Test(priority=1,enabled=true,description="Below function will perform upgrade journey for sme customer")

	public static void smeUpgradejourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                               

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07432724464",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

			profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","SMALL LTD / PLC");





			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			smeMethods.clickOnDirectMatch();

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);



			/*          try {

                                                                        compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                                          }catch(Exception e){

                                                                        loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                                        compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                                          }*/



			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);



			Thread.sleep(2000);



			//Existing Relation ship window//

			smeMethods.clickOnNumberOfCtn(customerDetails_profilePannel);

			smeMethods.validateAccountNumberFromExistingRelationshipTable("69411545", screenshotsPath, true);

			smeMethods.clickCtnNumberFromExistingRelationshipTable("07432724462", screenshotsPath, true);



			//Adding new device for other Ctn//



			reportDirectory.test.log(LogStatus.INFO,"Adding another  device and plan to basket for different ctn ");

			reportDirectory.test_consolidated.log(LogStatus.INFO,"Adding another device and plan to basket for different ctn ");



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//



			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);



			//Dealbuilder of Second

			dealBuilderData2=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			System.out.println("dealBuilderData2="+dealBuilderData2);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page Capture data,Take Action On Deal and Submit//



			basketPageDataMap=smeMethods.smecaptureBasketDataInMap(1,screenshotsPath,true);                                          

			basketUfMrcEndRevenue=smeMethods.smeMapBasketPageDeal1UfMrc(screenshotsPath,true);

			basketPageDataMap2=smeMethods.smecaptureBasketDataInMap(2,screenshotsPath,true);                                          

			basketUfMrcEndRevenue2=smeMethods.smeMapBasketPageDeal2UfMrc(screenshotsPath,true);

			basketUfMrcEndRevenueFooter=smeMethods.mapBasketPageUfMrcEndRevenueFooter(screenshotsPath,true);

			smeMethods.smeTakeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=smeMethods.smeTakeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=smeMethods.smeDeal1captureBasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageHeader2=smeMethods.smeDeal2captureBasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageDescription=smeMethods.smeCaptureBasketSummeryPageDescription(1,screenshotsPath,true);

			basketSummeryPageDescription2=smeMethods.smeCaptureBasketSummeryPageDescription(2,screenshotsPath,true);

			basketSummeryPageDescriptionFooter=smeMethods.smeTotalcaptureBasketSummeryPageFooter(screenshotsPath,true);



			//Search the Same CTN Again to Navigate into Interaction history//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07432724464");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction history//

			intractionHistoryLatestRow=smeMethods.smeCheckLastestTransInIntreactionHistoy(screenshotsPath,true);

			intractionHistoryDeal1Row=smeMethods.smeIntreactionHistoyDealRowData(1,screenshotsPath,false);

			intractHistExpandData=smeMethods.captureDataFromInteractionHistoryDeal(1,screenshotsPath,true);

			intractionHistoryDeal2Row=smeMethods.smeIntreactionHistoyDealRowData(2,screenshotsPath,false);

			intractHistExpandData2=smeMethods.captureDataFromInteractionHistoryDeal(2,screenshotsPath,true);

			intractHistfooter=smeMethods.mapInteractionHistoryFooter(screenshotsPath,false);                            



			//Validation Starts//

			reportDirectory.test.log(LogStatus.INFO, "UI validation Srarts for Deal 1");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "UI validation Srarts 1");

			smeMethods.smeValidateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			smeMethods.smeValidationInteractionHistoryLatestRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader2,dateOfActionOnDeal);

			reportDirectory.test.log(LogStatus.INFO, "Basket validation with deal builder deal 2");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "Basket validation with deal builder deal 2");

			smeMethods.smeValidateDealBuildeWithBasketPage(dealBuilderData2,basketPageDataMap2);

			smeMethods.smeValidateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketSummeryPageDescription);

			smeMethods.smeValidateIntractHistExpandDataWithBasketSummary(intractHistExpandData2,basketSummeryPageDescription2);

			smeMethods.smeValidateIntratcHistFooterBasketPage(basketUfMrcEndRevenueFooter,intractHistfooter);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}            

	@Test(priority=2,enabled=true,description="Below function will perform Add line journey for sme customer")

	public static void smeAddLinejourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                               

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");



			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Inbound Reactive Retention SB", screenshotsPath);



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07432724464",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

			profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Customer type","SMALL LTD / PLC");





			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Add Line",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			smeMethods.clickOnDirectMatch();

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);



			/*          try {

                                                                        compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                                          }catch(Exception e){

                                                                        loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                                        compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                                          }*/



			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);



			Thread.sleep(2000);



			//Existing Relation ship window//

			smeMethods.clickOnNumberOfCtn(customerDetails_profilePannel);

			smeMethods.validateAccountNumberFromExistingRelationshipTable("69411545", screenshotsPath, true);

			smeMethods.clickCtnNumberFromExistingRelationshipTable("07432724462", screenshotsPath, true);



			//Adding new device for other Ctn//



			reportDirectory.test.log(LogStatus.INFO,"Adding another  device and plan to basket for different ctn ");

			reportDirectory.test_consolidated.log(LogStatus.INFO,"Adding another device and plan to basket for different ctn ");



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectSmeRecommedDeviceFromDeviceTab("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectSMEPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//



			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);



			//Dealbuilder of Second

			dealBuilderData2=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			System.out.println("dealBuilderData2="+dealBuilderData2);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page Capture data,Take Action On Deal and Submit//



			basketPageDataMap=smeMethods.smecaptureBasketDataInMap(1,screenshotsPath,true);                                          

			basketUfMrcEndRevenue=smeMethods.smeMapBasketPageDeal1UfMrc(screenshotsPath,true);

			basketPageDataMap2=smeMethods.smecaptureBasketDataInMap(2,screenshotsPath,true);                                          

			basketUfMrcEndRevenue2=smeMethods.smeMapBasketPageDeal2UfMrc(screenshotsPath,true);

			basketUfMrcEndRevenueFooter=smeMethods.mapBasketPageUfMrcEndRevenueFooter(screenshotsPath,true);

			smeMethods.smeTakeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=smeMethods.smeTakeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=smeMethods.smeDeal1captureBasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageHeader2=smeMethods.smeDeal2captureBasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageDescription=smeMethods.smeCaptureBasketSummeryPageDescription(1,screenshotsPath,true);

			basketSummeryPageDescription2=smeMethods.smeCaptureBasketSummeryPageDescription(2,screenshotsPath,true);

			basketSummeryPageDescriptionFooter=smeMethods.smeTotalcaptureBasketSummeryPageFooter(screenshotsPath,true);



			//Search the Same CTN Again to Navigate into Interaction history//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07432724464");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction history//

			intractionHistoryLatestRow=smeMethods.smeCheckLastestTransInIntreactionHistoy(screenshotsPath,true);

			intractionHistoryDeal1Row=smeMethods.smeIntreactionHistoyDealRowData(1,screenshotsPath,false);

			intractHistExpandData=smeMethods.captureDataFromInteractionHistoryDeal(1,screenshotsPath,true);

			intractionHistoryDeal2Row=smeMethods.smeIntreactionHistoyDealRowData(2,screenshotsPath,false);

			intractHistExpandData2=smeMethods.captureDataFromInteractionHistoryDeal(2,screenshotsPath,true);

			intractHistfooter=smeMethods.mapInteractionHistoryFooter(screenshotsPath,false);                            



			//Validation Starts//

			reportDirectory.test.log(LogStatus.INFO, "UI validation Srarts for Deal 1");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "UI validation Srarts 1");

			smeMethods.smeValidateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			smeMethods.smeValidationInteractionHistoryLatestRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader2,dateOfActionOnDeal);

			reportDirectory.test.log(LogStatus.INFO, "Basket validation with deal builder deal 2");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "Basket validation with deal builder deal 2");

			smeMethods.smeValidateDealBuildeWithBasketPage(dealBuilderData2,basketPageDataMap2);

			smeMethods.smeValidateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketSummeryPageDescription);

			smeMethods.smeValidateIntractHistExpandDataWithBasketSummary(intractHistExpandData2,basketSummeryPageDescription2);

			smeMethods.smeValidateIntratcHistFooterBasketPage(basketUfMrcEndRevenueFooter,intractHistfooter);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}                          

	@Test(enabled=runTestCase,priority=3,description="This testcase will perform VAT joureny by accepting the deal")

	public static void serviceSalesToolJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";

		System.out.println("timestampOfCreatedDirectory "+timestampOfCreatedDirectory);

		System.out.println("reportDirectory.report_consolidated "+reportDirectory.report_consolidated);

		try {

			test=reportDirectory.report.startTest("");

			//excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

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

			compassPlusPage.newCTNsearch("07432724464",screenshotsPath,true);



			//Profile Panel//

			/* genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","06/07/2018 - 10/11/2020");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","Essential 4G 500MB GBP17- 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");

			 */                       

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Service Sales Tool",screenshotsPath,true);



			//Add Line Tab//

			compassPlusPage.selectTab("Add Line",screenshotsPath,false);

			compassPlusPage.vatSelectAddLineTile("Device",screenshotsPath,true);



			//Upgrade Tab//

			compassPlusPage.selectTab("Upgrade",screenshotsPath,false);

			//compassPlusPage.vatSelectUpgradeTileTile(screenshotsPath,true);                                          



			/*          //Tariff Value Tab//

                                           compassPlusPage.selectTab("Tariff Value",screenshotsPath,false);

                                           compassPlusPage.vatSelectAddLineTile("Tariff value",screenshotsPath,true);

			 */

			//Add on Tab//

			compassPlusPage.selectTab("VAT Add ons",screenshotsPath,false);

			compassPlusPage.vatSelectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			compassPlusPage.vatSelectEffectiveDate("17","Oct","2021",screenshotsPath,false);



			/*          try {

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }catch(Exception e){

                                                         loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }*/



			//Deal Builder//

			dealBuilderData=dealBuilderPage.vatCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dateOfActionOnDeal=dealBuilderPage.jsClickOnSubmitButton(screenshotsPath);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureAddToPlanBasketSummeryPageHeader(screenshotsPath,true);                                          

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//Deal builder Validation with basket Summary//

			/*          for(String key_basketSummeryPageDescription: basketSummeryPageDescription.keySet()){

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

                                           }*/



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07772150419");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			interactionHistoryPage.atpValidationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			//interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			/*s         intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

                             intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

                             intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

                             interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

                             interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

                             interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);

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

	@Test(enabled=runTestCase,priority=4,description="This testcase will perform Early Upgrade Retail SME joureny by accepting the deal")

	public static void smeEarlyUpgradeRetailJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";

		System.out.println("timestampOfCreatedDirectory "+timestampOfCreatedDirectory);

		System.out.println("reportDirectory.report_consolidated "+reportDirectory.report_consolidated);

		try {

			test=reportDirectory.report.startTest("");

			//excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

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

			designerStudioPage.clickOnRetailONEBAAandSelectValueFromDropDown(screenshotsPath,true);             

			designerStudioPage.retailClickOnOEMKT(screenshotsPath);





			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			//compassPlusPage.newCTNsearch("07415982219",screenshotsPath,true);

			compassPlusPage.newRetailNewCTNsearch("R165","07535574355","1",screenshotsPath,true);



			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","06/07/2018 - 10/11/2020");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","Essential 4G 500MB GBP17- 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Early Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.retailSelectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.retailSelectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			//dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(3000);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));

			Thread.sleep(2000);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageRetailUfMrc(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureRetailPaymBasketSummeryPageHeader(screenshotsPath,true);                            

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//Deal builder Validation with basket Summary//

			/*          for(String key_basketSummeryPageDescription: basketSummeryPageDescription.keySet()){

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

                                           }*/



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver).sendKeys("R165");;

			genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver),"07535574355");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			WebElement dropDown=genericKeywords.locateElement("retailCompassPlusPageSelectedProfile_xpath", loginPage.driver);

			genericKeywords.selectFromDropdown(dropDown,"index","1");

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(3000);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}





}