package testCases;

import static org.testng.Assert.assertEquals;



import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.LinkedList;

import java.util.List;

import java.util.Set;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



import com.codoid.products.exception.FilloException;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;



import components.ExcelReusables;

import components.Generics;

import components.ResponseReusables;

import generics.basketPage;

import generics.compassPlusPage;

import generics.dealBuilderPage;

import generics.deneverMethods;

import generics.designerStudioPage;

import generics.excelReusablesUI;

import generics.genericKeywords;

import generics.interactionHistoryPage;

import generics.loginPage;

import generics.profilePannel;

import generics.tradeInPage;

import generics.validateWebserviceWithUi;

import testSetup.dataBaseValidationWithUiOfferContext;

import testSetup.modifyXmlFile;

import testSetup.reportDirectory;

import testSetup.userExceptionMsg;



public class regression {



	static ExtentReports extent;

	static ExtentTest test;

	static String timestampOfCreatedDirectory,dateOfActionOnDeal,nameOfTestMethode,screenshotsPath;

	static LinkedHashMap<String, ArrayList<String>> basketPageDataMap,basketPageDataMap2,intractHistExpandData,intractHistExpandData2,basketSummHeader,dealBuilderData,dealBuilderData2,basketSummeryPageDescription,basketSummeryPageDescription2,basketSummeryPageHeader,basketSummeryPageHeader2,pegasusIntractHistUfMrcEndRevenue;

	static LinkedHashMap<String, String> intractHistUfMrcEndRevenue,intractHistUfMrcEndRevenue2,dealBuilderPageUfMrcEndRevenue,basketUfMrcEndRevenue,basketUfMrcEndRevenue2,intractionHistoryLatestRow,intractionHistoryLatestRow2,customerDetails_profilePannel,eligibility_profilePannel,productHolding_profilePannel,usage_profilePannel,excelData;          

	public static  int flag;

	static final boolean runTestCase=false;

	static final boolean runTestCaseDemo=false;



	//static final boolean runTestCase1=true;

	@BeforeTest

	public static void setup() {

		reportDirectory.timestamp=Generics.getTimestamp();  

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+"Consolidated Regression Report_"+reportDirectory.timestamp+".html");

		reportDirectory.report_consolidated.loadConfig(new File(System.getProperty("user.dir")+"/consolidated-extent-config.xml"));

	}



	@Test(enabled=runTestCase,priority=5,groups = { "demo" },description="This testcase will perform Upgrade joureny by accepting the deal")

	public static void upgrade_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			//String windowHandle2=loginPage.driver.getWindowHandle();

			//System.out.println("windowHandle2="+windowHandle2);



			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);                

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);                            



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07415982219",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);             

			profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

			//productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);

			//String UiOldDevice=profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Contracted device","SAMSUNG GALAXY S8 G950F LTE");

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));



			/*eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","06/07/2018 - 10/11/2020");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","Essential 4G 500MB GBP17- 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");

			 */           

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//



			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

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



			//Trad-In Tab//                             

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDevice(screenshotsPath,true);

			tradeInPage.captureDataFromTradeInTab();

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(3000);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//dealBuilderPageUfMrcEndRevenue=dealBuilderPage.mapDealBuilderUfMrcEndRevenue(screenshotsPath, true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);

			//interactionHistoryPage.validateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			//interactionHistoryPage.validateDealBuilderTotalWithBasketPage(basketUfMrcEndRevenue, dealBuilderPageUfMrcEndRevenue);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);                            

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07415982219");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            



			interactionHistoryPage.validateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			interactionHistoryPage.validateDealBuilderTotalWithBasketPage(basketUfMrcEndRevenue, dealBuilderPageUfMrcEndRevenue);



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			// interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketSummeryPageDescription);

			//                         interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);







			reportDirectory.test.log(LogStatus.INFO, "UI validation Ends");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "UI validation Ends");



			//getUpgradeFee response Validation from UI//

			reportDirectory.test.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");



			//Modify the request file as per the testcase//



			modifyXmlFile.modifyParticularElementOfXmlfile("getUpgradeFee_Request","message","msisdn","447415982219");

			//validateWebserviceWithUi.validateStatusCode("getEarlyUpgradeFee_Request",validateWebserviceWithUi.baseURInew)              ;

			validateWebserviceWithUi.validateGetUpgradeFeeWithUI("getUpgradeFee_Response","getUpgradeFee_Request",validateWebserviceWithUi.baseURInew,"0");



			reportDirectory.test.log(LogStatus.INFO, "getDeal validation from Ui");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "getDeal validation from Ui");



			//getDeal response Validation//

			modifyXmlFile.modifyParticularElementOfXmlfile("getDeal_Request","message","msisdn","447415982219");

			validateWebserviceWithUi.validateGetDealWithUI("getDeal_Response","getDeal_Request",validateWebserviceWithUi.baseURInew,intractHistExpandData);

			//DataBase Validation Starts//



			/*                         reportDirectory.test.log(LogStatus.INFO, "Data base validation from Ui");

                                           reportDirectory.test_consolidated.log(LogStatus.INFO, "Data base validation from Ui");



                                           LinkedList<String> uiOfferList=new LinkedList<String>();

                                           Set<String> keys = intractHistExpandData.keySet();

                                           for(String s:keys) {

                                                          uiOfferList.add(s);

                                           }

                                           //String UiNewDevice=uiOfferList.get(0);

                             dataBaseValidationWithUiOfferContext d=new dataBaseValidationWithUiOfferContext();

                             //d.dbValidationOfferContextWithUi("07415982219","UP",UiOldDevice,UiNewDevice);

                                         d.dbValidationOfferContextWithUi("07415982219","UP","SAMSUNG GALAXY S8 G950F LTE","APPLE IPHONE 11 64GB Black");



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



	@Test(enabled=runTestCase,priority=2,description="This Test case will perform early upgrade Journey by accepting the deal")

	public static void dbTest() throws InterruptedException {



		dataBaseValidationWithUiOfferContext d=new dataBaseValidationWithUiOfferContext();

		//d.dbValidationOfferContextWithUi("07415982219","UP",UiOldDevice,UiNewDevice);

		d.TestdbValidationOfferContextWithUi("07415982219","UP","SAMSUNG GALAXY S8 G950F LTE","APPLE IPHONE 11 64GB Black");



	}



	@Test(enabled=runTestCase,priority=5,groups = { "demo" },description="This Test case will perform early upgrade Journey by accepting the deal")

	public static void early_Upgrade_Journey() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07932091709",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			//customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

			//profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");



			eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                            

			//String euFee=profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"EU fee","£11.44");

			//productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);

			//String UiOldDevice=profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Contracted device","SAMSUNG GALAXY S8 G950F LTE");

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));





			// productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

			//usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);





			//String euFee=profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"EU fee","£11.44");

			//profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","Essential - 10GB £30 - 24M");

			//profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","2.82 GB");

			//           System.out.println("euFee="+euFee);



			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Early Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Samsung",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Trad-In Tab//                             

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDevice(screenshotsPath,true);

			tradeInPage.captureDataFromTradeInTab();

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(3000);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07932091709");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);             



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);





			reportDirectory.test.log(LogStatus.INFO, "UI validation Ends");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "UI validation Ends");



			//getUpgradeFee response Validation from UI//

			/*                         reportDirectory.test.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");

                                           reportDirectory.test_consolidated.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");



                                           //getEarlyUpgradeFee response Validation from UI//



                                           //Modify the request file as per the testcase//

                             modifyXmlFile.modifyParticularElementOfXmlfile("getEarlyUpgradeFee_Request","message","msisdn","447932091709");

                             //validateWebserviceWithUi.validateStatusCode("getEarlyUpgradeFee_Request",validateWebserviceWithUi.baseURInew)              ;

                             validateWebserviceWithUi.validateGetEarlyupgradeFeeWithUI("getEarlyUpgradeFee_Response","getEarlyUpgradeFee_Request",validateWebserviceWithUi.baseURInew,euFee);



                                           reportDirectory.test.log(LogStatus.INFO, "getDeal validation from Ui");

                                           reportDirectory.test_consolidated.log(LogStatus.INFO, "getDeal validation from Ui");



                                           //getDeal response Validation//

                             modifyXmlFile.modifyParticularElementOfXmlfile("getDeal_Request","message","msisdn","07932091709");

                             validateWebserviceWithUi.validateGetDealWithUI("getDeal_Response","getDeal_Request",validateWebserviceWithUi.baseURInew,intractHistExpandData);

                                           //DataBase Validation Starts//



                                           /*reportDirectory.test.log(LogStatus.INFO, "Data base validation from Ui");

                                           reportDirectory.test_consolidated.log(LogStatus.INFO, "Data base validation from Ui");

                                           LinkedList<String> uiOfferList=new LinkedList<String>();

                                           Set<String> keys = intractHistExpandData.keySet();

                                           for(String s:keys) {

                                                          uiOfferList.add(s);

                                           }

                                           String UiNewDevice=uiOfferList.get(0);

                                           dataBaseValidationWithUiOfferContext dbv=new dataBaseValidationWithUiOfferContext();

                             dbv.dbValidationOfferContextWithUi("07932091709","EU",UiOldDevice,UiNewDevice);

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



	@Test(enabled=runTestCase,priority=1,description="This Test case will perform upgrade Anytime Journey by accepting the deal")

	public static void upgradeAnyTimeJourney() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07961597033",screenshotsPath,true);



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

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","5.56 GB");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Upgrade Anytime",screenshotsPath,true);



			//Device Tab//

			//compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Samsung",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(2,screenshotsPath,true);                                          



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[3]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Trade In Tab//

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDeviceUpgradeAnytime(screenshotsPath,true);

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);



			//Add To Plan Tab//

			/*compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

                                    compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);

			 */

			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Under Consideration","2",screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);                            

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07961597033");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History-Retrive//

			//intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath);

			interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);

			//Thread.sleep(4000);

			loginPage.driver.switchTo().frame("PegaGadget3Ifr");

			Thread.sleep(3000);

			//loginPage.driver.findElement(By.xpath("//img[@name='IntentSelection_pyWorkPage_26']")).sendKeys(Keys.ENTER);



			//Basket Page//

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageRetrieveUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.retrieveTakeActionOnParticularDeal("Accept",screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureUnderConsiderationBasketSummeryPageHeader(screenshotsPath,true);                            

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//Deal Builder and Basket Summary Validation

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



			//CTN Search to Navigate Interaction History//

			String currentWindowHanel1=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel1);

			loginPage.driver.switchTo().window(currentWindowHanel1);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07961597033");

			Thread.sleep(5000);

			//genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History Validation with Basket Page/Basket Summary //

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			//Journey Complete//

			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}



	}



	@Test(enabled=runTestCase,priority=4,description="This Test case will perform Annual upgrade Journey by accepting the deal")

	public static void annual_Upgrade_Journey() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07508202442",screenshotsPath,true);



			//Profile Panel//

			/* genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","01/01/1970 - 01/01/1970");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","*Special* Essential - 10GB £38 - 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","1.33 GB");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Annual Upgrade",screenshotsPath,true);



			//Device Tab//

			//compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(2,screenshotsPath,true);                                          



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsDiscount("Discount 1",screenshotsPath,true);          

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//facing problem in Add ons Tab

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

			//compassPlusPage.selectAddOnsFromAddOnsTab("Insurance",screenshotsPath,true);



			//Trade In Tab//

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInAnnualUpgrade(screenshotsPath,true);

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07508202442");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);

			//Journey Complete//

			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}



	}



	@Test(enabled=runTestCase,priority=4,description="This testcase will perform Upgrade Retail Mbb joureny by accepting the deal")

	public static void upgrade_Retail_Mbb_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			designerStudioPage.clickOnRetailONEBAAandSelectValueFromDropDown(screenshotsPath,false);             

			designerStudioPage.retailClickOnOEMKT(screenshotsPath);





			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			//compassPlusPage.newCTNsearch("07415982219",screenshotsPath,true);

			compassPlusPage.retailNewCTNsearch("R165","07415982219",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Upgrade",screenshotsPath,true);



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

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[3]")).click();

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver),"07415982219");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(3000);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));

			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

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



	@Test(enabled=runTestCase,priority=6,description="This testcase will perform Upgrade TMUK voice joureny by accepting the deal")

	public static void upgrade_Tmuk_Voice_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07940565787",screenshotsPath,true);



			//Profile Panel//

			/* genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Brand","TMUK");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Upg eligible date","Eligible Now");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","12MYFS07");

                                    profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","4.02 GB");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//              compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//



			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			/*try {

                                           compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }catch (Exception e) {

                                                         loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);          

                                           }*/



			//Trad-In Tab//                             

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDevice(screenshotsPath,true);

			tradeInPage.captureDataFromTradeInTab();

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(3000);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07940565787");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



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



	@Test(enabled=runTestCase,priority=7,description="This testcase will perform Early Upgrade Retail voice joureny by accepting the deal")

	public static void early_Upgrade_Retail_Voice_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.retailNewCTNsearch("R165","07932091709",screenshotsPath,true);



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

			genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver),"07932091709");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

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



	@Test(enabled=runTestCase,priority=8,description="This testcase will perform Upgradeanytime Retail voice joureny by accepting the deal")

	public static void upgrade_AnyTime_Retail_Voice_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.retailNewCTNsearch("R165","07772150419",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Upgrade Anytime",screenshotsPath,true);



			//Device Tab//

			//compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.retailSelectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.retailSelectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,true);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Trade In Tab//

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDeviceUpgradeAnytime(screenshotsPath,true);

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);





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

			genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver).sendKeys("R165");

			genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver),"07772150419");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

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



	@Test(enabled=runTestCase,priority=9,description="This testcase will perform Payg Upgrade joureny by accepting the deal")

	public static void payg_Upgrade_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//              reportDirectory.timestamp=Generics.getTimestamp();                              

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

			compassPlusPage.selectCompassPlusTeam("Outbound Proactive Retention PAYG", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07497864503",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("PAYG Upgrade",screenshotsPath,true);

			//compassPlusPage.selectTab("Packs & Addons",screenshotsPath,false);

			//Device Tab//

			//compassPlusPage.selectTab("Payg Devices",screenshotsPath,false);

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.paygsSlectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.paygSelectManufacturereNameFromFilter("Samsung",screenshotsPath);

			compassPlusPage.paygSelectDeviceFromDeviceTab("1",screenshotsPath);





			//Packs & Addons Tabs//                                        

			//compassPlusPage.selectTab("Packs & Addons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,true);

			Thread.sleep(3000);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

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



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07497864503");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			flag++;

			//reportDirectory.report.endTest(test);

			//reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=runTestCaseDemo,priority=1,groups = { "demo" },description="This testcase will perform Flex Upgrade for Pay as you go ,Tmuk joureny by accepting the deal")

	public static void payg_Flex_Upgrade_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Outbound Proactive Retention PAYG", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07866085524",screenshotsPath,true);



			//Profile Panel//

			/* genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Pay As You Go");

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Brand","TMUK");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Customer tenure","0 Years and 8 Months");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","PAYG Standard Rates");

                                    profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Data 3m","0 MB");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Flex Upgrade",screenshotsPath,true);

			//compassPlusPage.selectTab("Packs & Addons",screenshotsPath,false);

			//Device Tab//

			compassPlusPage.selectTab("Flex Plans",screenshotsPath,true);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,true);





			Thread.sleep(3000);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

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



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07866085524");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			flag++;

			//reportDirectory.report.endTest(test);

			//reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=runTestCaseDemo,priority=2,description="This testcase will perform negative Payg error message")

	public static void paygNegativeScenario() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Outbound Proactive Retention PAYG", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07432635984",screenshotsPath,true);



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

			//Error message Vlidation//

			compassPlusPage.errorMessageValidation(screenshotsPath,true);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=runTestCase,priority=12,description="This testcase will perform indirect early Upgrade joureny by accepting the deal")

	public static void indirectEarlyupgradeJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



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

			compassPlusPage.selectCompassPlusTeam("Retail_Care_Early_Upgrade", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			compassPlusPage.newCTNsearch("07932091709",screenshotsPath,true);



			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","31/07/2019 - 27/08/2020");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","*Special* 4GEE 10GB £42.99 - 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");

			 */

			//Select call Reason//

			compassPlusPage.selectIndirectCallReason("Carphone Warehouse", screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Add ons Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[3]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);



			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.indirectMapBasketPageRetrieveUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);                            

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

                                           }

			 */

			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07932091709");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



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



	@Test(enabled=runTestCaseDemo,priority=13,description="This testcase will perform Paym Data upsell journey by accepting the deal")

	public static void paymDataUpsellJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07807002373",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Data Upsell",screenshotsPath,true);



			//Plans Tab//

			compassPlusPage.selectTab("Plans",screenshotsPath,false);

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[3]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			System.out.println("dealBuilderData="+dealBuilderData);

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

			/*          if(dealBuilderData.size() == basketSummeryPageDescription.size()) {

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07807002373");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			//interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=runTestCase,priority=14,description="This testcase will perform ATP journey")

	public static void addToPlanJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.retailNewCTNsearch("R165","07772150419",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Add To Plan",screenshotsPath,true);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			compassPlusPage.acceptPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.indirectCaptureDealBuilderData(screenshotsPath,true);

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

			genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver).sendKeys("R165");;

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07772150419");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(3000);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));

			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			interactionHistoryPage.atpValidationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			//interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=runTestCase,priority=15,description="This testcase will perform VAT joureny by accepting the deal")

	public static void vatJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("SERVICE_UNIVERSAL_NBA", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07772150419",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Value Add Tool",screenshotsPath,true);



			//Add Line Tab//

			compassPlusPage.selectTab("Add Line",screenshotsPath,false);

			compassPlusPage.vatSelectAddLineTile("Device",screenshotsPath,true);



			//Upgrade Tab//

			compassPlusPage.selectTab("Upgrade",screenshotsPath,false);

			compassPlusPage.vatSelectUpgradeTileTile(screenshotsPath,true);                                          



			//ATP Tab//

			compassPlusPage.selectTab("ATP",screenshotsPath,false);

			compassPlusPage.acceptPlanFromAddToPlanTab(screenshotsPath,true);



			//Tariff Value Tab//

			compassPlusPage.selectTab("Tariff Value",screenshotsPath,false);

			compassPlusPage.vatSelectAddLineTile("Tariff value",screenshotsPath,true);



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



	@Test(enabled=runTestCase,priority=16,description="This testcase will perform Add Line joureny by Adding more than one Line and accepting the deal")

	public static void addLineJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07415982219",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Add Line",screenshotsPath,true);



			//Add 1st Line//



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer2", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.selectAddLineDeviceFromDeviceTab("Gold",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectAddLinePlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//              compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);



			//Add ons Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[3]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);



			//Add 2nd Line//



			//Add Recs and Promos//           

			compassPlusPage.recsPromosSelectAddLineTile("Add Line SIMO",1,"1",screenshotsPath,true);



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                       

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[3]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

			/*try {

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }catch(Exception e){

                                                         loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }*/

			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//       compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData2=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);



			//Click On Basket//

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page Add Line 1//

			basketPageDataMap=basketPage.deal1CaptureBasketDataInMap(screenshotsPath,true);             

			basketUfMrcEndRevenue=basketPage.addLineDeal1mapBasketPageUfMrcEndRevenue(screenshotsPath,true);



			//basketPage.addLinetakeActionOnParticularDeal("deal1BasketPageDealOptionDropDown_xpath","Accept",null,screenshotsPath,true);



			//Basket Page Add Line 2//

			basketPageDataMap2=basketPage.deal2CaptureBasketDataInMap(screenshotsPath,true);

			//this objects needs to be checked//

			basketUfMrcEndRevenue2=basketPage.addLineDeal2mapBasketPageUfMrcEndRevenue(screenshotsPath,true);

			//basketPage.addLinetakeActionOnParticularDeal("deal2BasketPageDealOptionDropDown_xpath","Accept",null,screenshotsPath,true);



			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader2=compassPlusPage.captureAddLineBasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageHeader=compassPlusPage.addLine1CaptureBasketSummeryPageDescription(screenshotsPath,true);



			//basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			basketSummeryPageHeader2=compassPlusPage.captureAddLine2BasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageDescription2=compassPlusPage.captureAddLine2BasketSummeryPageDescription(screenshotsPath,true);



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



			//Deal builder Validation with basket Summary//

			/*          for(String key_basketSummeryPageDescription: basketSummeryPageDescription.keySet()){

                                                         System.out.println(key_basketSummeryPageDescription);

                                                          ArrayList<String> values=basketSummeryPageDescription2.get(key_basketSummeryPageDescription);

                                                          values.remove(0);

                                           }

                                           System.out.println("Updated New Basket map: "+basketSummeryPageDescription2);

                                           if(dealBuilderData2.size() == basketSummeryPageDescription2.size()) {

                                           if(dealBuilderData2.keySet().equals(basketSummeryPageDescription2.keySet())) {

                                                          dealBuilderData2.values().equals(basketSummeryPageDescription2.values());



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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07415982219");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			//Add Line 2//

			intractionHistoryLatestRow2=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);

			intractHistExpandData2=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);

			intractHistUfMrcEndRevenue2=interactionHistoryPage.mapAddLine2InteractionHistoryUfMrcEndRevenue(screenshotsPath,false);

			loginPage.driver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[2]//td[1]/span")).click();



			//Add line 1//

			intractionHistoryLatestRow=interactionHistoryPage.checkAddLineLastestTransInIntreactionHistoy(screenshotsPath,true);

			intractHistExpandData=interactionHistoryPage.captureAddLineDataFromInteractionHistory(screenshotsPath,true);

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapAddLine1InteractionHistoryUfMrcEndRevenue(screenshotsPath,false);

			loginPage.driver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[4]//td[1]/span")).click();



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow2,basketSummeryPageHeader2,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData2,basketPageDataMap2);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue2,intractHistUfMrcEndRevenue2);



			//getDealList response Validation from UI//



			//Modify the request file as per the testcase//

			modifyXmlFile.modifyParticularElementOfXmlfile("getDealList_Request","message","ban","20034115");

			//validateWebserviceWithUi.validateStatusCode("getEarlyUpgradeFee_Request",validateWebserviceWithUi.baseURInew)              ;

			String caseId=validateWebserviceWithUi.validateGetDealListWithUI("getDealList_Response","getDealList_Request",validateWebserviceWithUi.baseURInew);



			//getDeal response Validation//

			modifyXmlFile.modifyParticularElementOfXmlfile("getDeal_Request","message","msisdn",null);

			modifyXmlFile.modifyParticularElementOfXmlfile("getDeal_Request","message","caseId",caseId);

			validateWebserviceWithUi.validateGetDealWithUI("getDeal_Response","getDeal_Request",validateWebserviceWithUi.baseURInew,intractHistExpandData);





			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	@Test(enabled=runTestCase,priority=17,description="This Test case will perform upgrade Journey by changing the Tiers in Save tools Tab")

	public static void changeTierJourney() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07772100960",screenshotsPath,true);



			//Profile Panel//

			/* genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","01/01/1970 - 01/01/1970");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","Essential - 10GB £30 - 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","2.82 GB");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Early Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Samsung",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			compassPlusPage.changeTier("Tier 2",screenshotsPath,true);

			compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			compassPlusPage.selectSaveToolsTab(screenshotsPath,true);    



			//Add on Tab//

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);



			//Trad-In Tab//                             

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDevice(screenshotsPath,true);

			tradeInPage.captureDataFromTradeInTab();

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(3000);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07772100960");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



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



	@Test(enabled=runTestCase,priority=18,description="This testcase will perform In life upsell joureny by accepting the deal")

	public static void inLifeUpsellJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("SERVICE_UNIVERSAL_NBA", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07772150419",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Value Add Tool",screenshotsPath,true);



			//Add Line Tab//

			compassPlusPage.selectTab("Add Line",screenshotsPath,false);

			compassPlusPage.vatSelectAddLineTile("Device",screenshotsPath,true);



			//Upgrade Tab//

			compassPlusPage.selectTab("Upgrade",screenshotsPath,false);

			compassPlusPage.vatSelectUpgradeTileTile(screenshotsPath,true);                                          



			//ATP Tab//

			compassPlusPage.selectTab("ATP",screenshotsPath,false);

			compassPlusPage.acceptPlanFromAddToPlanTab(screenshotsPath,true);



			//Tariff Value Tab//

			compassPlusPage.selectTab("Tariff Value",screenshotsPath,false);

			compassPlusPage.vatSelectAddLineTile("Tariff value",screenshotsPath,true);



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



	@Test(enabled=runTestCase,priority=19,description="This testcase will perform adding more than one deal and accepting the deals")

	public static void multidealBasketJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07415982219",screenshotsPath,true);



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

			compassPlusPage.selectPegasusCallReason("Add Line",screenshotsPath,true);



			//Add 1st Line//



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer2", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.selectAddLineDeviceFromDeviceTab("Gold",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectAddLinePlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			//              compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);



			//Add To Plan Tab//

			//           compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//       compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);



			//Add 2nd Line//



			//Add Recs and Promos//           

			compassPlusPage.recsPromosSelectAddLineTile("Add line SIMO",1,"1",screenshotsPath,true);



			//Save tools Tab//

			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);



			//Add on Tab//

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);                        

			//compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);

			/*try {

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }catch(Exception e){

                                                         loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }*/

			//Add To Plan Tab//

			compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData2=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);



			//Click On Basket//

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page Add Line 1//

			basketPageDataMap=basketPage.deal1CaptureBasketDataInMap(screenshotsPath,true);             

			//add print Statement

			basketUfMrcEndRevenue=basketPage.addLineDeal1mapBasketPageUfMrcEndRevenue(screenshotsPath,true);

			//basketPage.addLinetakeActionOnParticularDeal("deal1BasketPageDealOptionDropDown_xpath","Accept",null,screenshotsPath,true);



			//Basket Page Add Line 2//

			basketPageDataMap2=basketPage.deal2CaptureBasketDataInMap(screenshotsPath,true);

			basketUfMrcEndRevenue2=basketPage.addLineDeal2mapBasketPageUfMrcEndRevenue(screenshotsPath,true);

			//basketPage.addLinetakeActionOnParticularDeal("deal2BasketPageDealOptionDropDown_xpath","Accept",null,screenshotsPath,true);



			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.addLine1CaptureBasketSummeryPageDescription(screenshotsPath,true);

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			basketSummeryPageHeader2=compassPlusPage.captureAddLine2BasketSummeryPageHeader(screenshotsPath,true);

			basketSummeryPageDescription2=compassPlusPage.captureAddLine2BasketSummeryPageDescription(screenshotsPath,true);



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



			//Deal builder Validation with basket Summary//

			/*          for(String key_basketSummeryPageDescription: basketSummeryPageDescription.keySet()){

                                                         System.out.println(key_basketSummeryPageDescription);

                                                          ArrayList<String> values=basketSummeryPageDescription2.get(key_basketSummeryPageDescription);

                                                          values.remove(0);

                                           }

                                           System.out.println("Updated New Basket map: "+basketSummeryPageDescription2);

                                           if(dealBuilderData2.size() == basketSummeryPageDescription2.size()) {

                                           if(dealBuilderData2.keySet().equals(basketSummeryPageDescription2.keySet())) {

                                                          dealBuilderData2.values().equals(basketSummeryPageDescription2.values());



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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07415982219");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			//Add Line 2//

			intractionHistoryLatestRow2=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);

			intractHistExpandData2=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);

			intractHistUfMrcEndRevenue2=interactionHistoryPage.mapAddLine2InteractionHistoryUfMrcEndRevenue(screenshotsPath,false);

			loginPage.driver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[2]//td[1]/span")).click();



			//Add line 1//

			intractionHistoryLatestRow=interactionHistoryPage.checkAddLineLastestTransInIntreactionHistoy(screenshotsPath,true);

			intractHistExpandData=interactionHistoryPage.captureAddLineDataFromInteractionHistory(screenshotsPath,true);

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapAddLine1InteractionHistoryUfMrcEndRevenue(screenshotsPath,false);

			loginPage.driver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[4]//td[1]/span")).click();



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow2,basketSummeryPageHeader2,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData2,basketPageDataMap2);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue2,intractHistUfMrcEndRevenue2);





			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	//Home Scenarios //



	@Test(enabled=runTestCase,priority=20,description="This Test case will perform Pegasus home move Journey")

	public static void pegasusHomeMoveJoureny() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



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

			reportDirectory.test.log(LogStatus.INFO, "-----------Home Regression Scenarios Started------------");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "-----------Home Regression Scenarios Started------------");

			//Login to Compass Plus//

			loginPage.loginToCompassPlus("ie","SIT2_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);                

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);                            



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("CA Fibre Upsell", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("BBEU10952616",screenshotsPath,true);



			//Profile Panel//

			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Home");

                             //profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Price rise","Y");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"HBB","Other");

                                 //profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Add on net price","£0.00");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Home Move",screenshotsPath,true);

			Thread.sleep(5000);

			//Line checker//

			compassPlusPage.lineCheckerHomeJourney("LS19 7UY", screenshotsPath,true);



			//Plans Tab//

			compassPlusPage.selectTab("Plans",screenshotsPath,false);

			compassPlusPage.selectPegasusPlanFromPlanTab(2,screenshotsPath,true);                            



			//Add-ons Tab//

			//compassPlusPage.selectTab("Add ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 1",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Chargeable Add Ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Assign databoost",screenshotsPath,true);



			//Save tools Tab//

			compassPlusPage.selectTab("Save tools",screenshotsPath,false);

			//compassPlusPage.selectSaveToolsHomeMove("Pegasus Plan Discounts",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsHomeMove("Pegasus Set Up Fee Discounts",screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapHomeBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.pegasusCaptureBasketSummeryPageHeader(screenshotsPath,true);                            

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



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"BBEU10952616");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.pegasusCheckLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			pegasusIntractHistUfMrcEndRevenue=interactionHistoryPage.mapPegasusInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationHomeInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validatePegasusIntratcHistTotalBasketPage(basketUfMrcEndRevenue,pegasusIntractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=runTestCase,priority=21,description="This Test case will perform Regrade Journey")

	public static void pegasusRegradeJoureny() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			///excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

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

			compassPlusPage.selectCompassPlusTeam("CA Fibre Upsell", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("BBEU10952616",screenshotsPath,true);



			//Profile Panel//

			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Home");

                             //profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Price rise","Y");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"HBB","Other");

                                 //profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Add on net price","£0.00");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Regrade",screenshotsPath,true);

			Thread.sleep(5000);



			//Plans Tab//

			compassPlusPage.selectTab("Plans",screenshotsPath,false);

			compassPlusPage.selectPegasusPlanFromPlanTab(2,screenshotsPath,true);             



			//Add-ons Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 1",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Chargeable Add Ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Assign databoost",screenshotsPath,true);





			//Save tools Tab//

			compassPlusPage.selectTab("Save tools",screenshotsPath,false);

			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsHomeMove("Discount-2",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsHomeMove("Set Up Fee Discounts",screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.pegasusCaptureBasketSummeryPageHeader(screenshotsPath,true);                            

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

                                           }

			 */

			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"BBEU10952616");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.pegasusCheckLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			pegasusIntractHistUfMrcEndRevenue=interactionHistoryPage.mapPegasusInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationHomeInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validatePegasusIntratcHistTotalBasketPage(basketUfMrcEndRevenue,pegasusIntractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=runTestCaseDemo,priority=3,groups = { "demo" },description="This Test case will perform home move Journey")

	public static void home_Move_Joureny() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



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

			compassPlusPage.selectCompassPlusTeam("CA Fibre Upsell", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("01132029376",screenshotsPath,true);



			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Home");

                             //profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Price rise","Y");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"HBB","Other");

                                 //profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Add on net price","£0.00");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Home Move",screenshotsPath,true);

			Thread.sleep(5000);

			//Line checker//

			compassPlusPage.lineCheckerHomeJourney("LS19 7UY", screenshotsPath,true);



			//Plans Tab//

			compassPlusPage.selectTab("Plans",screenshotsPath,false);

			compassPlusPage.selectPegasusPlanFromPlanTab(2,screenshotsPath,true);                            



			//Add-ons Tab//

			//compassPlusPage.selectTab("Add ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 1",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Chargeable Add Ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Assign databoost",screenshotsPath,true);



			//Save tools Tab//

			compassPlusPage.selectTab("Save tools",screenshotsPath,false);

			//compassPlusPage.selectSaveToolsHomeMove("Pegasus Plan Discounts",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsHomeMove("Pegasus Set Up Fee Discounts",screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.pegasusCaptureBasketSummeryPageHeader(screenshotsPath,true);                            

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

                                           }

			 */

			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"01132029376");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.pegasusCheckLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			pegasusIntractHistUfMrcEndRevenue=interactionHistoryPage.mapPegasusInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationHomeInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			// interactionHistoryPage.validatePegasusIntratcHistTotalBasketPage(basketUfMrcEndRevenue,pegasusIntractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=runTestCase,priority=23,description="This Test case will perform Home Move Journey")

	public static void regradeJoureny() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			///excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

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

			compassPlusPage.selectCompassPlusTeam("CA Fibre Upsell", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("01132029376",screenshotsPath,true);



			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Home");

                             //profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Price rise","Y");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"HBB","Other");

                                 //profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Add on net price","£0.00");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Regrade",screenshotsPath,true);

			Thread.sleep(5000);



			//Plans Tab//

			compassPlusPage.selectTab("Plans",screenshotsPath,false);

			compassPlusPage.selectPegasusPlanFromPlanTab(2,screenshotsPath,true);             



			//Add-ons Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 1",screenshotsPath,false);         

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Chargeable Add Ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Assign databoost",screenshotsPath,true);



			//Save tools Tab//

			compassPlusPage.selectTab("Save tools",screenshotsPath,false);

			/*compassPlusPage.selectSaveToolsHomeMove("Call Add on Discounts",screenshotsPath,true);

                                           compassPlusPage.selectSaveToolsHomeMove("Plan Discounts",screenshotsPath,true);

                                           compassPlusPage.selectSaveToolsHomeMove("Set Up Fee Discounts",screenshotsPath,true);

			 */

			//Deal Builder//

			dealBuilderData=dealBuilderPage.testCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.pegasusCaptureBasketSummeryPageHeader(screenshotsPath,true);                            

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

                                           }

			 */

			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"01132029376");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.pegasusCheckLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			pegasusIntractHistUfMrcEndRevenue=interactionHistoryPage.mapHomeInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationHomeInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			// interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			// interactionHistoryPage.validatePegasusIntratcHistTotalBasketPage(basketUfMrcEndRevenue,pegasusIntractHistUfMrcEndRevenue);





			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test(enabled=runTestCase,priority=24,description="This Test case will perform Manual Regrade Journey")

	public static void manualRegradeJoureny() throws InterruptedException {

		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			test=reportDirectory.report.startTest("");

			///excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeJourney");

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

			compassPlusPage.selectCompassPlusTeam("CA Fibre Upsell", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("01132029376",screenshotsPath,true);



			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Home");

                             //profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Price rise","Y");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"HBB","Other");

                                 //profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Add on net price","£0.00");

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Manual Regrade",screenshotsPath,true);

			Thread.sleep(5000);



			//Plans Tab//

			//compassPlusPage.selectTab("Plans",screenshotsPath,false);

			compassPlusPage.selectPlanFromPlanTab(2,screenshotsPath,true);             



			//Add-ons Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 1",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Call Add Ons 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Chargeable Add Ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Pegasus Assign databoost",screenshotsPath,true);



			//Save tools Tab//

			compassPlusPage.selectTab("Save tools",screenshotsPath,false);

			/*compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,false);

                                           compassPlusPage.selectSaveToolsHomeMove("Discount-2",screenshotsPath,false);

                                           compassPlusPage.selectSaveToolsHomeMove("Discount-3",screenshotsPath,true);

			 */

			//Deal Builder//

			dealBuilderData=dealBuilderPage.newCaptureDealBuilderData(screenshotsPath,true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept Manual Regrade","3",screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.pegasusCaptureBasketSummeryPageHeader(screenshotsPath,true);                            

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

                                           }

			 */        

			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"01132029376");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.pegasusCheckLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			pegasusIntractHistUfMrcEndRevenue=interactionHistoryPage.mapPegasusInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            

			interactionHistoryPage.validationHomeInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validatePegasusIntratcHistTotalBasketPage(basketUfMrcEndRevenue,pegasusIntractHistUfMrcEndRevenue);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}



	//Denver Scenario//



	@Test(enabled=true,priority=5,groups = { "demo" },description="This testcase will perform Denver joureny by accepting the deal")

	public static void denver_upgrade_Journey() throws InterruptedException, IOException, FilloException, userExceptionMsg {

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

			//String windowHandle2=loginPage.driver.getWindowHandle();

			//System.out.println("windowHandle2="+windowHandle2);



			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);                

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);                            



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R Denver", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07504694266",screenshotsPath,true);



			//Profile Panel//

			/*genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

                             customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);             

                             profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"Split subscription","Yes");

                             eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Split sale eligible","Yes");

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));

			 */

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Device cost", screenshotsPath);

			compassPlusPage.selectDeviceCostFromFilter("£1,062.00",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);             



			//Income Affordability//

			deneverMethods.selectIncomRangefromDropdown("11", screenshotsPath, true);

			deneverMethods.selectLoanRepayFromLoanTab("4", screenshotsPath, true);



			//Add on Tab//

			compassPlusPage.selectTab("Add ons",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 1",screenshotsPath,false);         

			//loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[2]")).click();

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Add On 2",screenshotsPath,true);



			/*          try {

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }catch(Exception e){

                                                         loginPage.driver.findElement(By.xpath("(//i[@class='icon icon-openclose'])[4]")).click();

                                                         compassPlusPage.selectAddOnsFromAddOnsTab("Add On 3",screenshotsPath,true);

                                           }*/



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//dealBuilderPageUfMrcEndRevenue=dealBuilderPage.mapDealBuilderUfMrcEndRevenue(screenshotsPath, true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);





			//Loan Repay Alert//

			deneverMethods.loanRepayAlertAccept(screenshotsPath, true);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);

			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);

			//interactionHistoryPage.validateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			//interactionHistoryPage.validateDealBuilderTotalWithBasketPage(basketUfMrcEndRevenue, dealBuilderPageUfMrcEndRevenue);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);                            

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07415982219");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            



			//interactionHistoryPage.validateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			//interactionHistoryPage.validateDealBuilderTotalWithBasketPage(basketUfMrcEndRevenue, dealBuilderPageUfMrcEndRevenue);



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketSummeryPageDescription);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);







			reportDirectory.test.log(LogStatus.INFO, "UI validation Ends");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "UI validation Ends");



			//getUpgradeFee response Validation from UI//

			reportDirectory.test.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");



			//Modify the request file as per the testcase//

			modifyXmlFile.modifyParticularElementOfXmlfile("getUpgradeFee_Request","message","msisdn","447415982219");

			//validateWebserviceWithUi.validateStatusCode("getEarlyUpgradeFee_Request",validateWebserviceWithUi.baseURInew)              ;

			validateWebserviceWithUi.validateGetUpgradeFeeWithUI("getUpgradeFee_Response","getUpgradeFee_Request",validateWebserviceWithUi.baseURInew,"0");



			reportDirectory.test.log(LogStatus.INFO, "getDeal validation from Ui");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "getDeal validation from Ui");



			//getDeal response Validation//

			modifyXmlFile.modifyParticularElementOfXmlfile("getDeal_Request","message","msisdn","447415982219");

			validateWebserviceWithUi.validateGetDealWithUI("getDeal_Response","getDeal_Request",validateWebserviceWithUi.baseURInew,intractHistExpandData);

			//DataBase Validation Starts//



			/*reportDirectory.test.log(LogStatus.INFO, "Data base validation from Ui");

                                           reportDirectory.test_consolidated.log(LogStatus.INFO, "Data base validation from Ui");



                                           LinkedList<String> uiOfferList=new LinkedList<String>();

                                           Set<String> keys = intractHistExpandData.keySet();

                                           for(String s:keys) {

                                                          uiOfferList.add(s);

                                           }

                                           //String UiNewDevice=uiOfferList.get(0);

                             //           dataBaseValidationWithUiOfferContext d=new dataBaseValidationWithUiOfferContext();

                             //d.dbValidationOfferContextWithUi("07415982219","UP",UiOldDevice,UiNewDevice);

                                      //d.dbValidationOfferContextWithUi("07415982219","UP","SAMSUNG GALAXY S8 G950F LTE","APPLE IPHONE 11 64GB Black");

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

				reportDirectory.test.log(LogStatus.FAIL, "Test case execution is incomplete,Please refer screenshot attached for more details"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Test case execution is incomplete,Please refer screenshot attached for more details"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				System.out.println("Screenshot taken");



			}catch(Exception e) {

				e.printStackTrace();

			}

		}

		loginPage.driver.quit();

		reportDirectory.test.log(LogStatus.INFO, "End of Execution");

		reportDirectory.report.endTest(reportDirectory.test);   

		reportDirectory.report.flush();

		reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");      

		reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		reportDirectory.report_consolidated.flush();



		/*loginPage.driver.quit();

                             reportDirectory.test.log(LogStatus.INFO, "End of Execution");

                             reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");      

                             reportDirectory.report.endTest(reportDirectory.test);                                              

              reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

                             reportDirectory.report.flush();

                             reportDirectory.report_consolidated.flush();

                             reportDirectory.report.close();//This line of extent report has some issue //

                             reportDirectory.report_consolidated.close();

		 */

	}



	//Sme Upgrade//



	@Test(enabled=runTestCase,priority=5,groups ={"demo"},description="This testcase will perform Upgrade joureny by accepting the deal")

	public static void sme_upgradeJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			//String windowHandle2=loginPage.driver.getWindowHandle();

			//System.out.println("windowHandle2="+windowHandle2);



			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);                

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectValueFromDropDown(screenshotsPath,true);                           



			//Change Team//

			compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);



			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

			compassPlusPage.newCTNsearch("07415982219",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);             

			profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

			//productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);

			//String UiOldDevice=profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Contracted device","SAMSUNG GALAXY S8 G950F LTE");

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));



			/*eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

                             productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

                                      usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

                             profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","06/07/2018 - 10/11/2020");

                             profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","Essential 4G 500MB GBP17- 24M");

                             profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");

			 */           

			//Select call Reason//

			compassPlusPage.selectPegasusCallReason("Upgrade",screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			//compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			//compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("1",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//



			//compassPlusPage.selectSaveToolsHomeMove("Discount-1",screenshotsPath,true);

			//compassPlusPage.selectSaveToolsTab(screenshotsPath,false);

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



			//Trad-In Tab//                             

			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDevice(screenshotsPath,true);

			tradeInPage.captureDataFromTradeInTab();

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(3000);



			//Add To Plan Tab//

			//compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			//compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);



			//Deal Builder//

			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			//dealBuilderPageUfMrcEndRevenue=dealBuilderPage.mapDealBuilderUfMrcEndRevenue(screenshotsPath, true);

			//System.out.println("dealBuilderData="+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);



			//Basket Page//

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);                                          

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);

			//interactionHistoryPage.validateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			// interactionHistoryPage.validateDealBuilderTotalWithBasketPage(basketUfMrcEndRevenue, dealBuilderPageUfMrcEndRevenue);



			//Basket Summary//

			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);                            

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);



			//CTN Search//

			//Enter the same CTN number used to proceed  the journy//

			String currentWindowHanel=loginPage.driver.getWindowHandle();

			System.out.println("currentWindowHanel :"+currentWindowHanel);

			loginPage.driver.switchTo().window(currentWindowHanel);

			Thread.sleep(5000);

			loginPage.driver.switchTo().frame("PegaGadget1Ifr");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"07415982219");

			Thread.sleep(5000);

			genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

			genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

			Thread.sleep(5000);

			loginPage.driver.switchTo().defaultContent();



			//Interaction History//

			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);                                          

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);                                          

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);                            



			//interactionHistoryPage.validateDealBuildeWithBasketPage(dealBuilderData,basketPageDataMap);

			//interactionHistoryPage.validateDealBuilderTotalWithBasketPage(basketUfMrcEndRevenue, dealBuilderPageUfMrcEndRevenue);



			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			//interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketSummeryPageDescription);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



			reportDirectory.test.log(LogStatus.INFO, "UI validation Ends");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "UI validation Ends");



			//getUpgradeFee response Validation from UI//

			reportDirectory.test.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "GetUpgradeFee validation from Ui");



			//Modify the request file as per the testcase//

			modifyXmlFile.modifyParticularElementOfXmlfile("getUpgradeFee_Request","message","msisdn","447415982219");

			//validateWebserviceWithUi.validateStatusCode("getEarlyUpgradeFee_Request",validateWebserviceWithUi.baseURInew)              ;

			validateWebserviceWithUi.validateGetUpgradeFeeWithUI("getUpgradeFee_Response","getUpgradeFee_Request",validateWebserviceWithUi.baseURInew,"0");



			reportDirectory.test.log(LogStatus.INFO, "getDeal validation from Ui");

			reportDirectory.test_consolidated.log(LogStatus.INFO, "getDeal validation from Ui");



			//getDeal response Validation//

			modifyXmlFile.modifyParticularElementOfXmlfile("getDeal_Request","message","msisdn","447415982219");

			validateWebserviceWithUi.validateGetDealWithUI("getDeal_Response","getDeal_Request",validateWebserviceWithUi.baseURInew,intractHistExpandData);

			//DataBase Validation Starts//



			//Just for Practice//

			/*WebElement wb=genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver);

                                 wb.click();

                                 genericKeywords.clickElement(wb);

                                 boolean flag= genericKeywords.waitUntilElementIsDisplayed(10,wb);



                                 genericKeywords.swithFrames("index", "0");

                                 genericKeywords.jsClick(wb);

                                 genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			 */

			/*reportDirectory.test.log(LogStatus.INFO, "Data base validation from Ui");

                                           reportDirectory.test_consolidated.log(LogStatus.INFO, "Data base validation from Ui");



                                           LinkedList<String> uiOfferList=new LinkedList<String>();

                                           Set<String> keys = intractHistExpandData.keySet();

                                           for(String s:keys) {

                                                          uiOfferList.add(s);

                                           }

                                           //String UiNewDevice=uiOfferList.get(0);

                             //           dataBaseValidationWithUiOfferContext d=new dataBaseValidationWithUiOfferContext();

                             //d.dbValidationOfferContextWithUi("07415982219","UP",UiOldDevice,UiNewDevice);

                                      //d.dbValidationOfferContextWithUi("07415982219","UP","SAMSUNG GALAXY S8 G950F LTE","APPLE IPHONE 11 64GB Black");

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





}