package testCases;



import java.io.BufferedReader;

import java.io.ByteArrayOutputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.net.HttpURLConnection;

import java.net.URISyntaxException;

import java.net.URL;

import java.net.URLConnection;

import java.util.ArrayList;

import java.util.LinkedHashMap;



import org.apache.commons.io.FileUtils;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.InputStreamEntity;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;

import org.apache.poi.xwpf.usermodel.Document;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import org.w3c.dom.NodeList;



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

import generics.stubUpdateforExistingCtn;

import generics.tradeInPage;

import io.restassured.RestAssured;

import io.restassured.config.EncoderConfig;

import io.restassured.http.ContentType;

import io.restassured.path.xml.XmlPath;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

import testSetup.reportDirectory;

import testSetup.userExceptionMsg;



public class HomeRegression {

	static ExtentReports extent;

	static ExtentTest test;

	private static Response response;

	private static String proxy_host="proxy.intra.bt.com",PORT="8080",baseURI=http://pegasit1-marketing-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/BTServices/Services/BTServices, baseURIold=http://pegabtz2nbt1.nat.bt.com:61001/prweb/PRSOAPServlet/SOAP/BTServices/Services/BTServices;

		static String timestampOfCreatedDirectory,dateOfActionOnDeal,nameOfTestMethode,screenshotsPath;

	static LinkedHashMap<String, ArrayList<String>> basketPageDataMap,intractHistExpandData,basketSummHeader,dealBuilderData,basketSummeryPageDescription,basketSummeryPageHeader,pegasusIntractHistUfMrcEndRevenue;

	static LinkedHashMap<String, String> intractHistUfMrcEndRevenue, basketUfMrcEndRevenue,intractionHistoryLatestRow,customerDetails_profilePannel,eligibility_profilePannel,productHolding_profilePannel,usage_profilePannel,excelData;          

	public static  int flag;

	static final boolean runTestCase=true;



	@BeforeTest

	public static void setup() {

		reportDirectory.timestamp=Generics.getTimestamp();  

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+"Consolidated Regression Report_"+reportDirectory.timestamp+".html");

		reportDirectory.report_consolidated.loadConfig(new File(System.getProperty("user.dir")+"/consolidated-extent-config.xml"));

	}



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

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);                            

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

	@Test(enabled=runTestCase,priority=22,description="This Test case will perform home move Journey")

	public static void homeMoveJoureny() throws InterruptedException {

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



	@Test(enabled=true,priority=23,description="This Test case will perform Home Move Journey")

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

			genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),"01132027917");

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

	@Test(enabled=true,priority=24,description="This Test case will perform Manual Regrade Journey")

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



	@Test(enabled=false,description="update the stub")

	public static void stubUptadeGetSubscriberDetails(){

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

			loginPage.loginToCompassPlus("ie","New_SIT_URL","613022604","rules",screenshotsPath,true);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);                

			//loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);



			//Designer Studio Page//

			designerStudioPage.clickOnONEBAAandSelectOEMKTFromDropDown(screenshotsPath,true);             

			genericKeywords.locateElement("designerStudioStubSearch_xpath", loginPage.driver).sendKeys("old:setresponse_stub");

			genericKeywords.locateElement("designerStudioStubSearch_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			stubUpdateforExistingCtn.selectStub("getSubscriberDetailsService", screenshotsPath, false);

			stubUpdateforExistingCtn.searchCtnForUpdate("447711286685",screenshotsPath, false);

		}catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test(enabled=false)

	public static void getUpgradeFeeSoapRequest() throws URISyntaxException, ClientProtocolException, IOException {



		//Devi Code//

		File requestFile=new File(".\\SoapRequest\\getUpgradeFee_Request.xml");

		System.setProperty("http.proxyHost",proxy_host);

		System.setProperty("http.proxyPort",PORT);

		RequestSpecification requestSpecification=RestAssured.given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("text/xml", ContentType.TEXT)));

		response=requestSpecification.given().header("Content-Type","text/xml;charset=UTF-8").body(requestFile).when().post(baseURIold);              







		CloseableHttpClient client= HttpClients.createDefault();

		HttpPost request=new HttpPost(http://pegasit1-marketing-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/Services);

			request.addHeader("Content-Type", "text/xml");

		request.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));

		//to store into response//

		CloseableHttpResponse response=client.execute(request);

		int statuseCode=response.getStatusLine().getStatusCode();

		System.out.println("statuseCode= "+statuseCode);

		Assert.assertEquals(200,statuseCode);

		String responseString=EntityUtils.toString(response.getEntity());

		System.out.println("responseString= "+responseString);

		XmlPath xmlPath=new XmlPath(responseString);            

		String msisdn=xmlPath.getString("getUpgradeFeeResponse.msisdn");

		System.out.println("msisdn= "+msisdn);





	}            

	@Test(enabled=false)

	public static void upgradeAnytimeRetailMbbJourney() throws InterruptedException {



		String nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                               

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		String screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";



		try {

			excelData=excelReusablesUI.read_entryDataSheetFromExcel("upgradeAnytimeJourney");

			System.out.println(excelData);

			/*ArrayList<String> requestDataSheetList=ExcelReusables.read_RequestDataSheetFromExcel_UpgradeJourney(excelData.get(1));

              System.out.println(requestDataSheetList);

              String request=ResponseReusables.fetchDataFromExcelAndMapTo_UpgradeJourneyRequest(requestDataSheetList);

              System.out.println(request);

              int statuscode=ResponseReusables.getStatusCode_UpgradeJourney();

              System.out.println(statuscode);

              Assert.assertEquals(statuscode,200,"status code validation failed");*/

			loginPage.loginToCompassPlus(excelData.get("Browser"),excelData.get("Url"),excelData.get("Username"),excelData.get("Password"),screenshotsPath,true);

			//loginPage.loginToCompassPlus("ie","New_SIT_URL","retailtester","rules",screenshotsPath);

			//loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6), screenshotsPath);                

			designerStudioPage.retailClickOnOEMKT(screenshotsPath);                     

			//compassPlusPage.selectCompassPlusTeam("Blended 5 Tiers U&R", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);

			compassPlusPage.retailNewCTNsearch("4033","07961597033",screenshotsPath,true);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

			eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

			usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         



			/*profilePannelCustomerDetails=profilePannel.getCustomerDetails(screenshotsPath);

              System.out.println("profilePannelCustomerDetails "+profilePannelCustomerDetails);

profilePannelEligibilityDetails=profilePannel.getEligibilityDetails(screenshotsPath);

              System.out.println("profilePannelEligibilityDetails "+profilePannelEligibilityDetails);

profilePannelProductHoldingDetails=profilePannel.getProductHoldingDetails(screenshotsPath);

              System.out.println("profilePannelProductHoldingDetails "+profilePannelProductHoldingDetails);

profilePannelUsageDetails=profilePannel.getUsageDetails(screenshotsPath);

              System.out.println("profilePannelUsageDetails "+profilePannelUsageDetails);*/             



			profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

			profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","31/07/2019 - 27/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","*Special* 4GEE 10GB £42.99 - 24M");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");

			compassPlusPage.selectCallReason("Upgrade Anytime",screenshotsPath,true);



			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Apple",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("Gold",screenshotsPath);

			//issue in this function

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          

			//compassPlusPage.selectSaveToolsTab(screenshotsPath);                                      

			compassPlusPage.selectAddOnsFromAddOnsTab("Swappable Benefits - 1",screenshotsPath,false);                    

			compassPlusPage.selectAddOnsFromAddOnsTab("Spend Cap",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Insurance",screenshotsPath,true);

			compassPlusPage.selectTab("Add to plan",screenshotsPath,false);

			compassPlusPage.selectPlanFromAddToPlanTab(screenshotsPath,true);             



			compassPlusPage.selectTab("Trade In",screenshotsPath,false);

			tradeInPage.selectTradeInDevice(screenshotsPath,true);

			tradeInPage.captureDataFromTradeInTab();

			genericKeywords.locateElement("tradeInPageAddTradeInBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);



			dealBuilderData=dealBuilderPage.captureDealBuilderData(screenshotsPath,true);

			System.out.println("dealBuilderData= "+dealBuilderData);

			dealBuilderPage.jsClickOnAddToBasketButton(screenshotsPath);

			dealBuilderPage.jsClickOnYellowBasketImage(screenshotsPath);

			basketPageDataMap=basketPage.captureBasketDataInMap(screenshotsPath,true);             

			System.out.println("basketPageDataMap= "+basketPageDataMap);

			basketUfMrcEndRevenue=basketPage.mapBasketPageUfMrcEndRevenue(screenshotsPath,true);             

			System.out.println("basketUfMrcEndRevenue= "+basketUfMrcEndRevenue);

			basketPage.takeActionOnParticularDeal("Accept",null,screenshotsPath,true);

			dateOfActionOnDeal=basketPage.takeActionOnBasket("Submit",screenshotsPath,false);



			basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader(screenshotsPath,true);             

			System.out.println("basketSummeryPageHeader= "+basketSummeryPageHeader);

			basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription(screenshotsPath,true);

			System.out.println("basketSummeryPageDescription= "+basketSummeryPageDescription);



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



			//Enter the same CTN number used to proceed  the journey

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



			intractionHistoryLatestRow=interactionHistoryPage.checkLastestTransInIntreactionHistoy(screenshotsPath,true);

			System.out.println("intractionHistoryLatestRow= "+intractionHistoryLatestRow);

			intractHistExpandData=interactionHistoryPage.captureDataFromInteractionHistory(screenshotsPath,true);             

			System.out.println("intractHistExpandData= "+intractHistExpandData);

			intractHistUfMrcEndRevenue=interactionHistoryPage.mapInteractionHistoryUfMrcEndRevenue(screenshotsPath,false);             

			System.out.println("intractHistUfMrcEndRevenue= "+intractHistUfMrcEndRevenue);

			interactionHistoryPage.validationInteractionHistoryRowWithBasketSummary(intractionHistoryLatestRow,basketSummeryPageHeader,dateOfActionOnDeal);

			interactionHistoryPage.validateIntractHistExpandDataWithBasketSummary(intractHistExpandData,basketPageDataMap);

			interactionHistoryPage.validateIntratcHistTotalBasketPage(basketUfMrcEndRevenue,intractHistUfMrcEndRevenue);



		}catch(Exception e) {

			e.printStackTrace();

		}



		reportDirectory.test.log(LogStatus.INFO, "End of Execution");

		reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");      

		reportDirectory.report.endTest(reportDirectory.test);                                              

		reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		reportDirectory.report.flush();

		reportDirectory.report_consolidated.flush();

		Thread.sleep(50000);

		loginPage.driver.close();



	}

	@Test(enabled=false,priority=3,description="This testcase will perform indirect early Upgrade joureny by accepting the deal")

	public static void indirectEarlyupgradeJourney() throws InterruptedException, IOException, FilloException, userExceptionMsg {



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

			compassPlusPage.selectCompassPlusTeam("Retail_Care_Early_Upgrade", screenshotsPath);

			//compassPlusPage.newCTNsearch(excelData.get(8),screenshotsPath);             



			//CTN Search//

			compassPlusPage.newCTNsearch("07932091709",screenshotsPath,true);



			//Profile Panel//

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));     

			customerDetails_profilePannel=profilePannel.getCustomerDetails(screenshotsPath);                                          

			eligibility_profilePannel=profilePannel.getEligibilityDetails(screenshotsPath);                                                                       

			productHolding_profilePannel=profilePannel.getProductHoldingDetails(screenshotsPath);                                                                       

			usage_profilePannel=profilePannel.getUsageDetails(screenshotsPath);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));         

			profilePannel.validateCustomerDetailsKeyValue(customerDetails_profilePannel,"User type","Consumer");

			profilePannel.validateEligibilityDetailsKeyValue(eligibility_profilePannel,"Contract dates","31/07/2019 - 27/08/2020");

			profilePannel.validateProductHoldingDetailsKeyValue(productHolding_profilePannel,"Plan","*Special* 4GEE 10GB £42.99 - 24M");

			profilePannel.validateUsageDetailsKeyValue(usage_profilePannel,"Chargeable 3m","40.55 GB");



			//Select call Reason//

			compassPlusPage.selectIndirectCallReason("Carphone Warehouse", screenshotsPath,true);



			//Device Tab//

			compassPlusPage.selectTab("Devices",screenshotsPath,false);

			compassPlusPage.selectFilter("Manufacturer", screenshotsPath);

			compassPlusPage.selectManufacturereNameFromFilter("Sony",screenshotsPath);

			compassPlusPage.selectDeviceFromDeviceTab2("Black",screenshotsPath);



			//Plans Tab//

			compassPlusPage.selectPlanFromPlanTab(1,screenshotsPath,true);                                          



			//Save tools Tab//

			compassPlusPage.selectAddOnsFromAddOnsTab("Swappable Benefits - 1",screenshotsPath,false);                    

			compassPlusPage.selectAddOnsFromAddOnsTab("Spend Cap",screenshotsPath,false);

			compassPlusPage.selectAddOnsFromAddOnsTab("Insurance",screenshotsPath,true);



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

		reportDirectory.report.endTest(reportDirectory.test);   

		reportDirectory.report.flush();

		reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");      

		reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		reportDirectory.report_consolidated.flush();



		/*reportDirectory.test.log(LogStatus.INFO, "End of Execution");

                             reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");      

                             reportDirectory.report.endTest(reportDirectory.test);                                              

              reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

                             reportDirectory.report.flush();

                             reportDirectory.report_consolidated.flush();

                             reportDirectory.report.close();

                             reportDirectory.report_consolidated.close();*/

	}



}