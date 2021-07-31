package generics;

public class compassPlusPage {

	package generics;

	import java.awt.AWTException;

	import java.io.File;

	import java.io.IOException;

	import java.util.ArrayList;

	import java.util.HashMap;

	import java.util.LinkedHashMap;

	import java.util.List;

	import java.util.Map;

	import java.util.Set;

	import java.util.concurrent.TimeUnit;



	import org.apache.commons.collections4.map.HashedMap;

	import org.openqa.selenium.By;

	import org.openqa.selenium.Keys;

	import org.openqa.selenium.WebElement;

	import org.openqa.selenium.interactions.Actions;

	import org.openqa.selenium.remote.server.handler.SendKeys;



	import com.codoid.products.exception.FilloException;

	import com.relevantcodes.extentreports.ExtentReports;

	import com.relevantcodes.extentreports.ExtentTest;

	import com.relevantcodes.extentreports.LogStatus;

	import components.Generics;

	import testSetup.reportDirectory;

	import testSetup.userExceptionMsg;



	public class compassPlusPage {



		/*public static ExtentTest test,test_consolidated;

	              public static ExtentReports report,report_consolidated;

	              static String timestamp,timestamp2;

	              static File file;

	              public static String commonFilepath2=System.getProperty("user.dir")+"./ReportUIAutomation/";



	              static LinkedHashMap<String, ArrayList<String>> dealBuilderData, basketSummeryPageDescription, basketSummeryPageHeader;*/



		public static void selectCompassPlusTeam(String selectTeam, String screenshotsPath) throws IOException, InterruptedException {



			try {

				Thread.sleep(4000);

				String currentTeam=genericKeywords.locateElement("compassPlusPageTeamCurrentTeamNew_xpath", loginPage.driver).getText();

				//System.out.println("currentTeam" +currentTeam);

				if(!currentTeam.equalsIgnoreCase(selectTeam)) {

					genericKeywords.waitExplicit(genericKeywords.locateElement("compassPlusPageloginedUserName_xpath", loginPage.driver), 10);

					genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageloginedUserName_xpath", loginPage.driver));

					Thread.sleep(3000);

					genericKeywords.mouseHoverJScript(genericKeywords.locateElement("compassPlusPagechangeTeam_xpath", loginPage.driver));

					Thread.sleep(3000);

					WebElement teamToSelect= loginPage.driver.findElement(By.xpath("//span[contains(@class,'menu-item-title-wrap')]/span[text()='"+selectTeam+"']"));

					Thread.sleep(3000);

					genericKeywords.jsClick(teamToSelect);

					Thread.sleep(5000);

					String text= genericKeywords.locateElement("compassPlusPageTeamModalWindow_xpath", loginPage.driver).getText();

					//System.out.println("Active text"+text);

					Thread.sleep(6000);

					genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

					genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageTeamModalWindowConfirmBtn_xpath", loginPage.driver));

					//Thread.sleep(6000);//



				}else {

					Thread.sleep(5000);

					if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver))){

						genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).click();

						//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

					}

				}

				Thread.sleep(6000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Team selection by user Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Team selection by user Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Team selection by user Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Team selection by user Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				e.printStackTrace();

			}

			Thread.sleep(2000);

		}



		public static void newCTNsearch(String ctn, String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, userExceptionMsg, InterruptedException {



			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				//Thread.sleep(5000);

				/*if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver))){

	                                           genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).click();

	                                           //genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

	                                           }*/



				/*genericKeywords.hilightElement(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver), loginPage.driver);

	                             genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).sendKeys(Keys.ENTER);*/                                     



				Thread.sleep(4000);

				loginPage.driver.switchTo().frame("PegaGadget1Ifr");

				Thread.sleep(3000);



				if(genericKeywords.waitUntilElementIsClickable(10,genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver))){

					genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver);

					genericKeywords.sendTextValue(genericKeywords.locateElement("compassPlusPageCTNTextBox_xpath", loginPage.driver),ctn);

				}



				if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver))){

					genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

					//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

					genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

					Thread.sleep(5000);

				}

				loginPage.driver.switchTo().defaultContent();

				Thread.sleep(2000);



				//reportDirectory.test.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "CTN search Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {                                  

				reportDirectory.test.log(LogStatus.FAIL, "CTN search Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "CTN search Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void retailNewCTNsearch(String storeCode,String ctn, String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, userExceptionMsg, InterruptedException {



			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(5000);

				if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver))){

					genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).click();

					//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

				}

				/*genericKeywords.hilightElement(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver), loginPage.driver);

	                             genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).sendKeys(Keys.ENTER);*/                                     

				//Thread.sleep(5000);

				loginPage.driver.switchTo().frame("PegaGadget1Ifr");

				Thread.sleep(5000);

				if(genericKeywords.waitUntilElementIsClickable(10,genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver))){

					genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver);

					genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver),storeCode);

					Thread.sleep(5000);

				}

				if(genericKeywords.waitUntilElementIsClickable(10,genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver))){

					genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver);

					genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver),ctn);

				}



				if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver))){

					genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

					//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

					genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

					Thread.sleep(5000);

				}

				loginPage.driver.switchTo().defaultContent();

				Thread.sleep(2000);



				//reportDirectory.test.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "CTN search Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed");

					Thread.sleep(5000);

				}

			}catch(Exception e) {     

				e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, "CTN search Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "CTN search Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				//e.printStackTrace();

			}

		}



		public static void newRetailNewCTNsearch(String storeCode,String ctn,String index, String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, userExceptionMsg, InterruptedException {



			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(5000);

				if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver))){

					genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).click();

					//genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver));

				}

				/*genericKeywords.hilightElement(genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver), loginPage.driver);

	                             genericKeywords.locateElement("compassPlusPageClickNewCustomer_xpath", loginPage.driver).sendKeys(Keys.ENTER);*/                                     

				//Thread.sleep(5000);

				loginPage.driver.switchTo().frame("PegaGadget1Ifr");

				Thread.sleep(5000);

				if(genericKeywords.waitUntilElementIsClickable(10,genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver))){

					genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver);

					genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageStoreCode_xpath", loginPage.driver),storeCode);

					Thread.sleep(5000);

				}

				if(genericKeywords.waitUntilElementIsClickable(10,genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver))){

					genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver);

					genericKeywords.sendTextValue(genericKeywords.locateElement("retailCompassPlusPageCTNTextBox_xpath", loginPage.driver),ctn);

				}

				if(genericKeywords.waitUntilElementIsClickable(10,genericKeywords.locateElement("retailCompassPlusPageSelectedProfile_xpath", loginPage.driver))){

					WebElement dropDown=genericKeywords.locateElement("retailCompassPlusPageSelectedProfile_xpath", loginPage.driver);

					genericKeywords.selectFromDropdown(dropDown,"index",index);

				}



				if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver))){

					genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver);

					//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

					genericKeywords.jsClick(genericKeywords.locateElement("compassPlusPageCTNSearchBtn_xpath", loginPage.driver));

					Thread.sleep(5000);

				}

				loginPage.driver.switchTo().defaultContent();

				Thread.sleep(2000);



				//reportDirectory.test.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "CTN search Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN search Passed");

					Thread.sleep(5000);

				}

			}catch(Exception e) {     

				e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, "CTN search Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "CTN search Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				//e.printStackTrace();

			}

		}



		public static void selectCallReason(String callreason, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(1000);

				WebElement clickCallRes=loginPage.driver.findElement(By.xpath("(//span[contains(.,'"+callreason+"')]//self :: a[@class='Simple'])[1]"))         ;

				genericKeywords.hilightElement(clickCallRes, loginPage.driver);

				genericKeywords.jsClick(clickCallRes);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On"+callreason+" call reason Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");



				}



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}



		public static void selectPegasusCallReason(String callreason, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(1000);

				//WebElement clickCallRes=loginPage.driver.findElement(By.xpath("(//a[text()='"+callreason+"'])[7]"))              ;

				WebElement clickCallRes=loginPage.driver.findElement(By.xpath("(//button[text()='"+callreason+"'])[7]"))              ;

				genericKeywords.hilightElement(clickCallRes, loginPage.driver);

				genericKeywords.jsClick(clickCallRes);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On"+callreason+" call reason Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");



				}



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void selectSmeCallReason(String callreason, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(1000);

				WebElement clickCallRes=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+callreason+"')])[1]"));

				genericKeywords.jsClick(clickCallRes);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On"+callreason+" call reason Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

				}

			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}



		public static void selectIndirectCallReason(String callreason, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(1000);

				//WebElement clickCallRes=loginPage.driver.findElement(By.xpath("(//span[contains(.,'"+callreason+"')]//self :: a[@class='Simple'])[2]"))         ;

				WebElement clickCallRes=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+callreason+"')])[8]"))              ;

				genericKeywords.jsClick(clickCallRes);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On"+callreason+" call reason Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation On "+callreason +" call reason Passed");



				}

				Thread.sleep(5000);

			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed");

	                                           e.printStackTrace();

				 */

				reportDirectory.test.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation On "+callreason+" call reason Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}



		public static void errorMessageValidation(String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(5000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				String errorMessage=loginPage.driver.findElement(By.xpath("(.//div//span[contains(.,'Upgrade option not available ')])[5]")).getText()   ;

				System.out.println("errorMessage="+errorMessage);

				if(errorMessage.equalsIgnoreCase("Upgrade option not available at this time. Please check Excalibur"))

				{

					if(screenshotToBeCaptured==true) {

						reportDirectory.test.log(LogStatus.PASS,errorMessage+" Error message Validation Passed "+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

						reportDirectory.test_consolidated.log(LogStatus.PASS, errorMessage+" Error message Validation Passed "+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

					}else {

						reportDirectory.test.log(LogStatus.PASS,errorMessage+" Error message Validation Passed ");

						reportDirectory.test_consolidated.log(LogStatus.PASS,errorMessage+" Error message Validation Passed ");



					}

				}else {

					reportDirectory.test.log(LogStatus.FAIL, errorMessage+" Error message Validation failed "+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.FAIL, errorMessage+" Error message Validation failed "+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}

			}catch(Exception e) {

				reportDirectory.test.log(LogStatus.FAIL, "Something went wrong"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Something went wrong"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		//Sink issue

		public static void selectTab(String tabName, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException

		{

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();



			WebElement tabElement;

			try{

				Thread.sleep(6000);

				switch (tabName)

				{

				case "Recs & Promos" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					//tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[2]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Devices" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Plans" :

					try {

						tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[3]"));

						genericKeywords.waitExplicit(tabElement, 20);

						genericKeywords.jsClick(tabElement)  ;

					}catch(Exception e){

						tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

						genericKeywords.waitExplicit(tabElement, 20);

						genericKeywords.jsClick(tabElement)  ; 

					}

					break;

				case "Save tools" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Add ons" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Accessories" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[3]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Add to plan" :

					//tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[3]"));

					//1 Enable

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Trade In" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					System.out.println("Working as timeout");

					break;

				case "Packs & Addons" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					System.out.println("Working as timeout");

					break;

				case "Payg Devices" :

					//tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[4]"));

					tabElement=loginPage.driver.findElement(By.xpath("//button[@name='Devices_pyWorkPage_62']"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Flex Plans" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					Thread.sleep(3000);

					break;

				case "Add Line" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Upgrade" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "ATP" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Tariff Value" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'"+tabName+"')])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "VAT Add ons" :

					tabElement=loginPage.driver.findElement(By.xpath("(//button[contains(.,'Add ons')])[5]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;







				}



				Thread.sleep(5000);

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Click On "+tabName+" tab Passed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Click On "+tabName+" tab Passed");*/

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);



				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Click On "+tabName+" tab Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click On "+tabName+" tab Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Click On "+tabName+" tab Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Click On "+tabName+" tab Passed");



				}

				Thread.sleep(5000);



			}catch (Exception e) {

				e.printStackTrace();

				//loginPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				Thread.sleep(5000);

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Click On "+tabName+" tab Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click On "+tabName+" tab Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Click On "+tabName+" tab Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click On "+tabName+" tab Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}



		public static void selectDevice() throws IOException, InterruptedException

		{

			try

			{

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

				String wb;

				String deviceCost;

				String minUpfrontCost;



				for(int i=1;i<deviceTabRow.size();i++)

				{

					int j=i+1;

					try

					{

						Thread.sleep(5000);

						wb=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[5]//div[@class='field-item dataValueRead']//span")).getText();

						System.out.println("Device Color="+wb);



					}

					catch (Exception e) {

						wb=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[5]//div[@class='field-item dataValueRead']//span")).getText();

						System.out.println("Device Color="+wb);

					}

					if(wb!=null)

					{

						try

						{

							Thread.sleep(3000);

							deviceCost=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[7]//self :: div")).getText();

							System.out.println("deviceCost="+deviceCost);

						}

						catch (Exception e) {

							Thread.sleep(2000);

							deviceCost=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[7]/div")).getText();

							System.out.println("deviceCost="+deviceCost);

						}

						try

						{

							Thread.sleep(5000);

							minUpfrontCost=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[8]//div")).getText();

						}

						catch (Exception e) {

							Thread.sleep(5000);

							minUpfrontCost=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[8]//div")).getText();

						}

						if((deviceCost.contains("N/A"))  && (minUpfrontCost.contains("N/A")) )

						{

							try

							{

								Thread.sleep(5000);

								genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[9]//div//button")));

								break;

							}

							catch (Exception e) {

								Thread.sleep(5000);

								genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td[9]//div//button")));

								break;

							}

						}

					}

				}

			}

			catch (Exception e) {

				e.printStackTrace();

			}

		}



		public static void selectDeviceFromDeviceTab(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);     

				String valOfNodes = null;



				for(int i=2; i<deviceTabRow.size(); i++) {

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));



					for(int n=0; n<deviceTabNodes.size(); n++) {

						if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {



							valOfNodes=deviceTabNodes.get(n+1).getText();

							System.out.println("valOfNodes="+valOfNodes);

							WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[7]//span//button"));

							genericKeywords.jsClick(addBtn);

							break;

						}                             

					}

					break;

				}



				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Selecting Device from Device tab Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Device from Device tab Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Selecting Device from Device tab Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Device from Device tab Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Selecting Device from Device tab Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Device from Device tab Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Selecting Device from Device tab Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Device from Device tab Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Selecting Device from Device tab Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Device from Device tab Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}



		public static void selectDeviceFromDeviceTabDenver() throws IOException, InterruptedException

		{

			List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

			String valOfNodes = null;

			String deviceCost = null;

			String minUpfrontCost = null;

			String addButton = null;

			boolean status;



			for(int i=1; i<deviceTabRow.size(); i++){



				int j=i+1;

				List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+j+"]//td"));

				{

					for(int n=4; n<deviceTabNodes.size(); n++){

						/*try {

	                                  Thread.sleep(10000);

	                                  } catch(InterruptedException ex) {

	                                  Thread.currentThread().interrupt();

	                                  }*/

						//genericKeywords.waitExplicitUntilTextVisibl(5, deviceTabNodes.get(n), "Black");

						status=genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n));

						if(status) {

							valOfNodes=deviceTabNodes.get(n).getText();

							System.out.println("valOfNodes="+valOfNodes);

						}

						/*try {

	                                  Thread.sleep(10000);

	                                  } catch(InterruptedException ex) {

	                                  Thread.currentThread().interrupt();

	                                  }*/

						//genericKeywords.waitExplicitUntilTextVisibl(5, deviceTabNodes.get(n+2), "N/A");

						status=genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n+2));

						if(status) {

							deviceCost=deviceTabNodes.get(n+2).getText();

							System.out.println("deviceCost="+deviceCost);

						}

						/*try {

	                                  Thread.sleep(10000);

	                                  } catch(InterruptedException ex) {

	                                  Thread.currentThread().interrupt();

	                                  }*/

						//genericKeywords.waitExplicitUntilTextVisibl(5, deviceTabNodes.get(n+3), "N/A");

						status=genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n+3));

						if(status) {

							minUpfrontCost=deviceTabNodes.get(n+3).getText();

							System.out.println("minUpfrontCost="+minUpfrontCost);

						}

						/*    try {

	                                  Thread.sleep(10000);

	                                  } catch(InterruptedException ex) {

	                                  Thread.currentThread().interrupt();

	                                  }*/

						//genericKeywords.waitExplicitUntilTextVisibl(5, deviceTabNodes.get(n+4), "Add");

						status=genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n+4));

						if(status) {

							addButton=deviceTabNodes.get(n+4).getText();

							System.out.println("addButton="+addButton);

						}

						if(valOfNodes.equalsIgnoreCase("Black"))

						{

							if((deviceCost.equalsIgnoreCase("N/A")) && (minUpfrontCost.equalsIgnoreCase("N/A")))

							{

								if(addButton.equalsIgnoreCase("Add"))

								{

									/*try {

	                                                    Thread.sleep(10000);

	                                                    } catch(InterruptedException ex) {

	                                                    Thread.currentThread().interrupt();

	                                                    }*/



									//genericKeywords.jsClick(deviceTabNodes.get(8));

									//deviceTabNodes.get(8).click();



									Actions actions =new Actions (loginPage.driver);

									genericKeywords.waitExplicit(deviceTabNodes.get(8), 20);

									WebElement a=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[7]//span//button"));

									actions.doubleClick(a).perform();

									System.out.println("Device added successfully to deal builder");

									/*try {                                              

	                                                    genericKeywords.waitExplicit(deviceTabNodes.get(8), 20);

	                                                    actions.doubleClick(deviceTabNodes.get(8)).perform();

	                                                    System.out.println("Device added successfully to deal builder");

	                                              }

	                                              catch (Exception e) {

	                                                    loginPage.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	                                                    WebElement a=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[4]//td[9]//div//button"));

	                                                    genericKeywords.mouseHoverJScript(a);

	                                                    Thread.sleep(100000);



	                                              //((JavascriptExecutor)loginPage.driver).executeScript("arguments[0].doubleClick();",a);

	                                                    //actions.doubleClick(a).perform();

	                                                    a.click();

	                                                    a.click();

	                                                    Thread.sleep(1000);

	                                              }

	                                              loginPage.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	                                              WebElement a=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable'])[1]//tr[2]//td[7]//div//button"));

	                                              //genericKeywords.mouseHoverJScript(a);

	                                              a.click();

	                                              a.click();

	                                        ((JavascriptExecutor)loginPage.driver).executeScript("arguments[0].doubleClick();",deviceTabNodes.get(8));*/

									break;

								}

							}

						}

					}

				}

				break;

			}

		}



		public static void selectPlanFromPlanTab_old(int rowNum, String screenshotsPath) throws IOException, InterruptedException {



			ArrayList<String> listValue=new ArrayList<String>();

			Map<String,ArrayList<String>> planAddedMap=new HashedMap<String,ArrayList<String>>();

			List<WebElement> planTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

			System.out.println("planTabRow : "+planTabRow.size());

			String plan = null;

			boolean status;



			try {

				for(int i=rowNum+1; i<planTabRow.size(); i++){



					List<WebElement> planTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					System.out.println("deviceTabNodes : "+planTabNodes.size());



					for(int n=0;n<planTabNodes.size();n++) {

						plan=planTabNodes.get(n).getText();

						System.out.println("plan Selected : "+plan);



						for(int temp=n;temp<planTabNodes.size()-3;temp++) {

							listValue.add(planTabNodes.get(temp+1).getText());

						}

						System.out.println("PlanlistValue  : "+listValue);

						planAddedMap.put(planTabNodes.get(n).getText(), listValue);

						System.out.println("PlansAdded Map  :  "+planAddedMap);



						if(genericKeywords.waitUntilElementIsDisplayed(10, planTabNodes.get(5))) {

							Thread.sleep(5000);

							WebElement addPlan=genericKeywords.locateElement("compassPlusPagePlansTabAddBtn_xapath",loginPage.driver);



							try {

								//genericKeywords.jsClick(addPlan);

								genericKeywords.hilightElement(addPlan, loginPage.driver);

								addPlan.sendKeys(Keys.ENTER);

							}



							catch (Exception e) {

								planTabNodes.get(n+1).click();

								planTabNodes.get(n+1).sendKeys(Keys.TAB);

								planTabNodes.get(n).sendKeys(Keys.TAB);

								genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[8]//span//button")), loginPage.driver);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[8]//span//button")).sendKeys(Keys.ENTER);

							}

							break;

						}

					}

					break;

				}



				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

				e.printStackTrace();

			}

		}



		public static void selectPlanFromPlanTab(int rowNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String plan = null;

			boolean status;

			ArrayList<String> listValue=new ArrayList<String>();

			Map<String,ArrayList<String>> planAddedMap=new HashedMap<String,ArrayList<String>>();

			List<WebElement> planTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);



			try {

				for(int i=rowNum+1; i<=planTabRow.size(); i++){

					List<WebElement> planTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					//System.out.println("deviceTabNodes : "+planTabNodes.size());

					for(int n=0;n<planTabNodes.size();n++) {

						plan=planTabNodes.get(n).getText();

						//System.out.println("plan Selected : "+plan);

						for(int temp=n;temp<planTabNodes.size()-3;temp++) {

							listValue.add(planTabNodes.get(temp+1).getText());

						}

						//System.out.println("PlanlistValue  : "+listValue);



						planAddedMap.put(planTabNodes.get(n).getText(), listValue);

						//System.out.println("PlansAdded Map  :  "+planAddedMap);



						if(genericKeywords.waitUntilElementIsDisplayed(10, planTabNodes.get(5))) {

							Thread.sleep(5000);

							WebElement addPlan=genericKeywords.locateElement("compassPlusPagePlansTabAddBtn_xapath",loginPage.driver);



							try {

								//genericKeywords.jsClick(addPlan);

								//genericKeywords.hilightElement(addPlan, loginPage.driver);

								//addPlan.sendKeys(Keys.ENTER);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")).sendKeys(Keys.ENTER);

								//System.out.println("Try block add button selected");

							}catch (Exception e) {

								System.out.println("Catch block add button selected");

								planTabNodes.get(n+1).click();

								planTabNodes.get(n+1).sendKeys(Keys.TAB);

								planTabNodes.get(n).sendKeys(Keys.TAB);

								genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")), loginPage.driver);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")).sendKeys(Keys.ENTER);

							}

							break;

						}

					}

					break;

				}



				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void selectAddLinePlanFromPlanTab(int rowNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String plan = null;

			boolean status;

			ArrayList<String> listValue=new ArrayList<String>();

			Map<String,ArrayList<String>> planAddedMap=new HashedMap<String,ArrayList<String>>();

			List<WebElement> planTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);



			try {

				for(int i=rowNum+1; i<=planTabRow.size(); i++){

					List<WebElement> planTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					//System.out.println("deviceTabNodes : "+planTabNodes.size());

					for(int n=0;n<planTabNodes.size();n++) {

						plan=planTabNodes.get(n).getText();

						//System.out.println("plan Selected : "+plan);

						for(int temp=n;temp<planTabNodes.size()-3;temp++) {

							listValue.add(planTabNodes.get(temp+1).getText());

						}

						//System.out.println("PlanlistValue  : "+listValue);



						planAddedMap.put(planTabNodes.get(n).getText(), listValue);

						//System.out.println("PlansAdded Map  :  "+planAddedMap);



						if(genericKeywords.waitUntilElementIsDisplayed(10, planTabNodes.get(5))) {

							Thread.sleep(5000);

							WebElement addPlan=genericKeywords.locateElement("compassPlusPagePlansTabAddBtn_xapath",loginPage.driver);



							try {

								//genericKeywords.jsClick(addPlan);

								//genericKeywords.hilightElement(addPlan, loginPage.driver);

								//addPlan.sendKeys(Keys.ENTER);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[9]//span//button")).sendKeys(Keys.ENTER);

								//System.out.println("Try block add button selected");

							}catch (Exception e) {

								System.out.println("Catch block add button selected");

								planTabNodes.get(n+1).click();

								planTabNodes.get(n+1).sendKeys(Keys.TAB);

								//planTabNodes.get(n).sendKeys(Keys.TAB);

								genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[9]//span//button")), loginPage.driver);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[9]//span//button")).sendKeys(Keys.ENTER);

							}

							break;

						}

					}

					break;

				}



				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void selectPegasusPlanFromPlanTab(int rowNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String plan = null;

			boolean status;

			ArrayList<String> listValue=new ArrayList<String>();

			Map<String,ArrayList<String>> planAddedMap=new HashedMap<String,ArrayList<String>>();

			List<WebElement> planTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

			try {

				for(int i=rowNum+1; i<=planTabRow.size(); i++){

					List<WebElement> planTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					//System.out.println("deviceTabNodes : "+planTabNodes.size());

					for(int n=0;n<planTabNodes.size();n++) {

						plan=planTabNodes.get(n).getText();

						//System.out.println("plan Selected : "+plan);

						for(int temp=n;temp<planTabNodes.size()-3;temp++) {

							listValue.add(planTabNodes.get(temp+1).getText());

						}

						//System.out.println("PlanlistValue  : "+listValue);



						planAddedMap.put(planTabNodes.get(n).getText(), listValue);

						//System.out.println("PlansAdded Map  :  "+planAddedMap);



						if(genericKeywords.waitUntilElementIsDisplayed(10, planTabNodes.get(7))) {

							//Thread.sleep(5000);

							//WebElement addPlan=genericKeywords.locateElement("compassPlusPagePlansTabAddBtn_xapath",loginPage.driver);



							try {

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")).sendKeys(Keys.ENTER);

								//System.out.println("Try block add button selected");

							}catch (Exception e) {

								System.out.println("Catch block add button selected");

								planTabNodes.get(n+1).click();

								planTabNodes.get(n+1).sendKeys(Keys.TAB);

								planTabNodes.get(n).sendKeys(Keys.TAB);

								genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")), loginPage.driver);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")).sendKeys(Keys.ENTER);

							}

							break;

						}

					}

					break;

				}



				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void retailSelectPlanFromPlanTab(int rowNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String plan = null;

			boolean status;

			ArrayList<String> listValue=new ArrayList<String>();

			Map<String,ArrayList<String>> planAddedMap=new HashedMap<String,ArrayList<String>>();

			List<WebElement> planTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

			try {

				for(int i=rowNum+1; i<=planTabRow.size(); i++){

					List<WebElement> planTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					//System.out.println("deviceTabNodes : "+planTabNodes.size());

					for(int n=0;n<planTabNodes.size();n++) {

						plan=planTabNodes.get(n).getText();

						//System.out.println("plan Selected : "+plan);

						for(int temp=n;temp<planTabNodes.size()-3;temp++) {

							listValue.add(planTabNodes.get(temp+1).getText());

						}

						//System.out.println("PlanlistValue  : "+listValue);



						planAddedMap.put(planTabNodes.get(n).getText(), listValue);

						//System.out.println("PlansAdded Map  :  "+planAddedMap);



						if(genericKeywords.waitUntilElementIsDisplayed(10, planTabNodes.get(7))) {

							//Thread.sleep(5000);

							//WebElement addPlan=genericKeywords.locateElement("compassPlusPagePlansTabAddBtn_xapath",loginPage.driver);



							try {

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[7]//span//button")).sendKeys(Keys.ENTER);

								//System.out.println("Try block add button selected");

							}catch (Exception e) {

								System.out.println("Catch block add button selected");

								planTabNodes.get(n+1).click();

								planTabNodes.get(n+1).sendKeys(Keys.TAB);

								planTabNodes.get(n).sendKeys(Keys.TAB);

								genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")), loginPage.driver);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[7]//span//button")).sendKeys(Keys.ENTER);

							}

							break;

						}

					}

					break;

				}



				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}





		public static void selectSMEPlanFromPlanTab(int rowNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String plan = null;

			boolean status;

			ArrayList<String> listValue=new ArrayList<String>();

			Map<String,ArrayList<String>> planAddedMap=new HashedMap<String,ArrayList<String>>();

			List<WebElement> planTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);



			try {

				for(int i=rowNum+1; i<=planTabRow.size(); i++){

					List<WebElement> planTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					//System.out.println("deviceTabNodes : "+planTabNodes.size());

					for(int n=0;n<planTabNodes.size();n++) {

						plan=planTabNodes.get(n).getText();

						//System.out.println("plan Selected : "+plan);

						for(int temp=n;temp<planTabNodes.size()-3;temp++) {

							listValue.add(planTabNodes.get(temp+1).getText());

						}

						//System.out.println("PlanlistValue  : "+listValue);



						planAddedMap.put(planTabNodes.get(n).getText(), listValue);

						//System.out.println("PlansAdded Map  :  "+planAddedMap);



						if(genericKeywords.waitUntilElementIsDisplayed(10, planTabNodes.get(5))) {

							Thread.sleep(5000);

							WebElement addPlan=genericKeywords.locateElement("compassPlusPagePlansTabAddBtn_xapath",loginPage.driver);



							try {

								//genericKeywords.jsClick(addPlan);

								//genericKeywords.hilightElement(addPlan, loginPage.driver);

								//addPlan.sendKeys(Keys.ENTER);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[9]//span//button")).sendKeys(Keys.ENTER);

								//System.out.println("Try block add button selected");

							}catch (Exception e) {

								System.out.println("Catch block add button selected");

								planTabNodes.get(n+1).click();

								planTabNodes.get(n+1).sendKeys(Keys.TAB);

								planTabNodes.get(n).sendKeys(Keys.TAB);

								genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[8]//span//button")), loginPage.driver);

								loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td[9]//span//button")).sendKeys(Keys.ENTER);

							}

							break;

						}

					}

					break;

				}



				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Adding One Plan to deal builder Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Adding One Plan to deal builder Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}





		public static ArrayList<String> selectSaveToolsTab(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> saveToolsTabList=new ArrayList<String>();



			try {

				WebElement membershipDiscountsplusBnt=genericKeywords.locateElement("(//div[@class='content-item content-field item-1   dataValueRead flex flex-row '])[1]/span/button",loginPage.driver);

				genericKeywords.jsClick(membershipDiscountsplusBnt);

				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Save Tools Tab click operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Save Tools Tab click operation Passed");



			}catch (Exception e) {

				Thread.sleep(5000);

				System.out.println("Save tools elements are disabled goto Addon tab");



				try {

					Thread.sleep(5000);

					//System.out.println("Button is disabled Proceed to select the next Element");

					//loginPage.driver.findElement(By.xpath("((//button[contains(.,'Save tools')])[1]/preceding::tbody)[11]")).click();

					//System.out.println("cLICKED");

					//loginPage.driver.findElement(By.xpath("((//button[contains(.,'Save tools')])[1]/preceding::tbody)[11]")).sendKeys(Keys.TAB);

					//System.out.println("Tab1");

					try {

						loginPage.driver.findElement(By.xpath("(//button[contains(.,'Recs & Promos')])[1]")).sendKeys(Keys.TAB);

						//System.out.println("Tab2");

						loginPage.driver.findElement(By.xpath("(//button[contains(.,'Device')])[1]")).sendKeys(Keys.TAB);

						loginPage.driver.findElement(By.xpath("(//button[contains(.,'Plans')])[3]")).sendKeys(Keys.TAB);

					}catch (Exception e2) {

						loginPage.driver.findElement(By.xpath("(//button[contains(.,'Device')])[1]")).sendKeys(Keys.TAB);

						loginPage.driver.findElement(By.xpath("(//button[contains(.,'Plans')])[3]")).sendKeys(Keys.TAB);



					}

					//System.out.println("Tab3");

					loginPage.driver.findElement(By.xpath("(//button[contains(.,'Save tools')])[1]")).sendKeys(Keys.TAB);

					//System.out.println("Tab4");

					genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//button[contains(.,'Add ons')])[1]")), loginPage.driver);

					Thread.sleep(7000);

					loginPage.driver.findElement(By.xpath("(//button[contains(.,'Add ons')])[1]")).sendKeys(Keys.ENTER);

					//System.out.println("Add ond Executed");



					Thread.sleep(7000);      

					//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

					//reportDirectory.test.log(LogStatus.PASS, "Save Tools Tab click operation Passed");

					//reportDirectory.test_consolidated.log(LogStatus.PASS, "Save Tools Tab click operation Passed");

					if(screenshotToBeCaptured==true) {

						reportDirectory.test.log(LogStatus.PASS, "Save Tools Tab click operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

						reportDirectory.test_consolidated.log(LogStatus.PASS, "Save Tools Tab click operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

					}else {

						reportDirectory.test.log(LogStatus.PASS, "Save Tools Tab click operation Passed");

						reportDirectory.test_consolidated.log(LogStatus.PASS, "Save Tools Tab click operation Passed");



					}

					Thread.sleep(5000);

				}

				catch (Exception e1) {

					/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                                          reportDirectory.test.log(LogStatus.FAIL, "Save Tools Tab click operation Failed");

	                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Save Tools Tab click operation Failed");

	                                                          e1.getStackTrace();*/

					reportDirectory.test.log(LogStatus.FAIL, "Save Tools Tab click operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.FAIL, "Save Tools Tab click operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

					e.printStackTrace();

				}

			}

			return saveToolsTabList;

		}



		public static void selectSaveToolsHomeMove(String saveToolsHeader,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException{



			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			Map<String , Integer> addOnsTypeSelection=new HashedMap<String,Integer>();

			addOnsTypeSelection.put("Discount-1", 1);

			addOnsTypeSelection.put("Discount-2", 2);

			addOnsTypeSelection.put("Discount-3", 3);

			addOnsTypeSelection.put("Call Add on Discounts", 1);

			addOnsTypeSelection.put("Plan Discounts", 2);

			addOnsTypeSelection.put("Plan Discounts1", 1);

			addOnsTypeSelection.put("Set Up Fee Discounts", 3);

			addOnsTypeSelection.put("Pegasus Plan Discounts", 1);

			addOnsTypeSelection.put("Pegasus Set Up Fee Discounts", 2);



			try {

				int index=addOnsTypeSelection.get(saveToolsHeader);

				Thread.sleep(5000);

				//String addOnHeader=loginPage.driver.findElement(By.xpath("(//h2[contains(.,'"+addOnHederType+"')])[1]")).getText();

				//loginPage.driver.findElement(By.xpath("(//h2[contains(.,'Swappable Benefits - 1')])[1]")).click();

				//System.out.println("Print addOn heade ="+addOnHeader);

				Thread.sleep(6000);

				List<WebElement> addOnRows=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr/td"));

				for(int i=2;i<addOnRows.size();i++) {

					List<WebElement>addOnNodes=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr["+i+"]/td"));



					for(int j=0;j<addOnNodes.size();j++) {



						String addOnOptions=addOnNodes.get(j).getText();

						//System.out.println("Value of all the nodes ="+addOnOptions);

						genericKeywords.hilightElement(addOnNodes.get(j), loginPage.driver);

						Thread.sleep(5000);

						genericKeywords.hilightElement(addOnNodes.get(j+2), loginPage.driver);

						Thread.sleep(8000);

						addOnNodes.get(j+2).click();

						Thread.sleep(2000);



						try {

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							// addOnNodes.get(j).click();

							//System.out.println("Try block Click Executed");

							//System.out.println(saveToolsHeader+" Add ons Item added to deal builder ");



						}catch(Exception e) {

							Thread.sleep(2000);

							addOnNodes.get(j+2).click();

							addOnNodes.get(j+2).sendKeys(Keys.TAB);

							Thread.sleep(2000);

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							//System.out.println("Catch block Click Executed");

							//System.out.println(saveToolsHeader+" Add ons Item added to deal builder ");

						}

						break;

					}

					break;

				}

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, saveToolsHeader+" click operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, saveToolsHeader+" click operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, saveToolsHeader+" click operation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, saveToolsHeader+" click operation Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, saveToolsHeader+" click operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, saveToolsHeader+" click operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void changeTier(String selectTier,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException{



			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();



			try {

				/*List<WebElement> tierDrpDwn=loginPage.driver.findElements(By.xpath("//select[@class='dealbuilderdropdown']"));

	                                           for(int i=2;i<tierDrpDwn.size();i++) {

	                                           List<WebElement>option=loginPage.driver.findElements(By.xpath("//select[@class='dealbuilderdropdown']/option"));

	                                                          for(int j=0;j<option.size();j++) {

	                                                          String selectOption=option.get(j).getText();

	                                                         if(selectOption.equalsIgnoreCase(selectTier)) {

	                                                          option.get(j).click();

	                                                          }

	                                           break;

	                                           }

	                                           break;

	                                           }*/

				WebElement changeTierObj=loginPage.driver.findElement(By.xpath("//select[@class='dealbuilderdropdown']"));

				changeTierObj.click();

				genericKeywords.selectFromDropdown(changeTierObj, "visibleText", selectTier);

				Thread.sleep(5000);

				genericKeywords.waitExplicit(loginPage.driver.findElement(By.xpath("//button[text()='Change Tier']")), 5);

				loginPage.driver.findElement(By.xpath("//button[text()='Change Tier']")).click();

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, selectTier+" click operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, selectTier+" click operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, selectTier+" click operation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, selectTier+" click operation Passed");

				}

				Thread.sleep(5000);

			}

			catch(Exception e) {

				reportDirectory.test_consolidated.log(LogStatus.FAIL, selectTier+" click operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, selectTier+" click operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}







		public static void selectSaveToolsDiscount(String saveToolsHeader,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException{



			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			Map<String , Integer> saveToolTypeSelection=new HashedMap<String,Integer>();

			saveToolTypeSelection.put("Discount 1", 1);

			saveToolTypeSelection.put("Dicount 2", 1);

			saveToolTypeSelection.put("Discount 3", 1);

			saveToolTypeSelection.put("Call Add on Discounts", 1);

			saveToolTypeSelection.put("Plan Discounts", 2);

			saveToolTypeSelection.put("Plan Discounts1", 1);

			saveToolTypeSelection.put("Set Up Fee Discounts", 3);

			saveToolTypeSelection.put("Pegasus Plan Discounts", 1);

			saveToolTypeSelection.put("Pegasus Set Up Fee Discounts", 2);



			try {

				int index=saveToolTypeSelection.get(saveToolsHeader);

				Thread.sleep(5000);

				//String addOnHeader=loginPage.driver.findElement(By.xpath("(//h2[contains(.,'"+addOnHederType+"')])[1]")).getText();

				//loginPage.driver.findElement(By.xpath("(//h2[contains(.,'Swappable Benefits - 1')])[1]")).click();

				//System.out.println("Print addOn heade ="+addOnHeader);

				Thread.sleep(6000);

				List<WebElement> addOnRows=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr/td"));

				for(int i=2;i<addOnRows.size();i++) {

					List<WebElement>addOnNodes=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr["+i+"]/td"));



					for(int j=0;j<addOnNodes.size();j++) {



						String addOnOptions=addOnNodes.get(j).getText();

						//System.out.println("Value of all the nodes ="+addOnOptions);

						genericKeywords.hilightElement(addOnNodes.get(j), loginPage.driver);

						Thread.sleep(5000);

						genericKeywords.hilightElement(addOnNodes.get(j+2), loginPage.driver);

						Thread.sleep(8000);

						addOnNodes.get(j+2).click();

						Thread.sleep(2000);



						try {

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							// addOnNodes.get(j).click();

							//System.out.println("Try block Click Executed");

							//System.out.println(saveToolsHeader+" Add ons Item added to deal builder ");



						}catch(Exception e) {

							Thread.sleep(2000);

							addOnNodes.get(j+2).click();

							addOnNodes.get(j+2).sendKeys(Keys.TAB);

							Thread.sleep(2000);

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							//System.out.println("Catch block Click Executed");

							//System.out.println(saveToolsHeader+" Add ons Item added to deal builder ");

						}

						break;

					}

					break;

				}

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, saveToolsHeader+" click operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, saveToolsHeader+" click operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, saveToolsHeader+" click operation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, saveToolsHeader+" click operation Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, saveToolsHeader+" click operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, saveToolsHeader+" click operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}





		public static void selectAddOnsFromAddOnsTab(String addOnHederType,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			Map<String , Integer> addOnsTypeSelection=new HashedMap<String,Integer>();

			addOnsTypeSelection.put("Add On 1", 1);

			addOnsTypeSelection.put("Add On 2", 2);

			addOnsTypeSelection.put("Add On 3", 3);

			addOnsTypeSelection.put("Add On 4", 4);

			addOnsTypeSelection.put("Add On 5", 5);

			addOnsTypeSelection.put("Add On 6", 6);

			addOnsTypeSelection.put("Payg Add On 1", 1);

			addOnsTypeSelection.put("Payg Add On 2", 2);

			addOnsTypeSelection.put("Payg Add On 3", 3);



			addOnsTypeSelection.put("Swappable Benefits - 1", 1);

			addOnsTypeSelection.put("Spend Cap", 1);

			addOnsTypeSelection.put("SME Spend Cap", 3);

			addOnsTypeSelection.put("Insurance", 4);

			addOnsTypeSelection.put("Insurance1", 3);

			addOnsTypeSelection.put("Content", 4);

			addOnsTypeSelection.put("SME Content", 5);

			addOnsTypeSelection.put("Calling Abroad", 5);

			addOnsTypeSelection.put("Packs", 6);

			addOnsTypeSelection.put("VAS", 7);

			addOnsTypeSelection.put("Visual Voicemail", 8);

			addOnsTypeSelection.put("Call Add Ons 1", 1);

			addOnsTypeSelection.put("Call Add Ons 2",         2);

			addOnsTypeSelection.put("Pegasus Chargeable Add Ons", 3);

			addOnsTypeSelection.put("Pegasus Assign databoost", 4);

			addOnsTypeSelection.put("Chargeable Add Ons", 3);

			addOnsTypeSelection.put("Pegasus Add ons 3", 5);

			addOnsTypeSelection.put("Pegasus Add ons 4", 7);

			addOnsTypeSelection.put("Assign databoost", 4);



			try {

				int index=addOnsTypeSelection.get(addOnHederType);

				//Thread.sleep(5000);

				//String addOnHeader=loginPage.driver.findElement(By.xpath("(//h2[contains(.,'"+addOnHederType+"')])[1]")).getText();

				//loginPage.driver.findElement(By.xpath("(//h2[contains(.,'Swappable Benefits - 1')])[1]")).click();

				//System.out.println("Print addOn heade ="+addOnHeader);

				//Thread.sleep(5000);

				/*WebElement mrc=loginPage.driver.findElement(By.xpath("//table[@id='headTbl_right11']//th[3]/div/div/div"));

	          genericKeywords.hilightElement(mrc, loginPage.driver);

	          Thread.sleep(2000);*/



				List<WebElement> addOnRows=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr/td"));



				for(int i=2;i<addOnRows.size();i++) {

					List<WebElement>addOnNodes=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr["+i+"]/td"));



					for(int j=0;j<addOnNodes.size();j++) {



						String addOnOptions=addOnNodes.get(j).getText();

						//System.out.println("Value of all the nodes ="+addOnOptions);

						genericKeywords.hilightElement(addOnNodes.get(j), loginPage.driver);

						Thread.sleep(1000);

						genericKeywords.hilightElement(addOnNodes.get(j+2), loginPage.driver);

						//Thread.sleep(2000);

						addOnNodes.get(j+2).click();

						//           Thread.sleep(2000);



						try {

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							// addOnNodes.get(j).click();

							System.out.println("Try block Click Executed");

							System.out.println(addOnHederType+" Add ons Item added to deal builder ");



						}catch(Exception e) {

							//Thread.sleep(2000);

							addOnNodes.get(j+2).click();

							addOnNodes.get(j+2).sendKeys(Keys.TAB);

							//Thread.sleep(2000);

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							System.out.println("Catch block Click Executed");

							System.out.println(addOnHederType+" Add ons Item added to deal builder ");

						}

						break;

					}

					break;

				}

				//Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		public static void vatSelectAddOnsFromAddOnsTab(String addOnHederType,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			Map<String , Integer> addOnsTypeSelection=new HashedMap<String,Integer>();

			addOnsTypeSelection.put("Add On 1", 1);

			addOnsTypeSelection.put("Add On 2", 3);

			addOnsTypeSelection.put("Add On 3", 5);

			addOnsTypeSelection.put("Add On 4", 6);

			addOnsTypeSelection.put("Add On 5", 7);



			try {

				int index=addOnsTypeSelection.get(addOnHederType);

				//Thread.sleep(5000);

				//String addOnHeader=loginPage.driver.findElement(By.xpath("(//h2[contains(.,'"+addOnHederType+"')])[1]")).getText();

				//loginPage.driver.findElement(By.xpath("(//h2[contains(.,'Swappable Benefits - 1')])[1]")).click();

				//System.out.println("Print addOn heade ="+addOnHeader);

				Thread.sleep(7000);

				/*WebElement mrc=loginPage.driver.findElement(By.xpath("//table[@id='headTbl_right11']//th[3]/div/div/div"));

	          genericKeywords.hilightElement(mrc, loginPage.driver);

	          Thread.sleep(2000);*/



				List<WebElement> addOnRows=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr/td"));



				for(int i=2;i<addOnRows.size();i++) {

					List<WebElement>addOnNodes=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr["+i+"]/td"));



					for(int j=0;j<addOnNodes.size();j++) {



						String addOnOptions=addOnNodes.get(j).getText();

						//System.out.println("Value of all the nodes ="+addOnOptions);

						genericKeywords.hilightElement(addOnNodes.get(j), loginPage.driver);

						Thread.sleep(2000);

						genericKeywords.hilightElement(addOnNodes.get(j+2), loginPage.driver);

						Thread.sleep(2000);

						addOnNodes.get(j+2).click();

						Thread.sleep(2000);



						try {

							loginPage.driver.findElement(By.xpath("((//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//i/img)[2]")).sendKeys(Keys.ENTER);

							// addOnNodes.get(j).click();

							System.out.println("Try block Click Executed");

							System.out.println(addOnHederType+" Add ons Item added to deal builder ");



						}catch(Exception e) {

							Thread.sleep(2000);

							addOnNodes.get(j+2).click();

							addOnNodes.get(j+2).sendKeys(Keys.TAB);

							Thread.sleep(2000);

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])["+index+"]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							System.out.println("Catch block Click Executed");

							System.out.println(addOnHederType+" Add ons Item added to deal builder ");

						}

						break;

					}

					break;

				}

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}



		public static void selectFlexPaygPlan(int planNumber,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(7000);

				List<WebElement> addOnRows=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr/td"));



				for(int i=planNumber+1;i<addOnRows.size();i++) {

					List<WebElement>addOnNodes=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td"));



					for(int j=0;j<addOnNodes.size();j++) {



						String addOnOptions=addOnNodes.get(j).getText();



						//System.out.println("Value of all the nodes ="+addOnOptions);

						genericKeywords.hilightElement(addOnNodes.get(j), loginPage.driver);

						//Thread.sleep(2000);

						genericKeywords.hilightElement(addOnNodes.get(j+2), loginPage.driver);

						//Thread.sleep(2000);

						addOnNodes.get(j+2).click();

						//Thread.sleep(2000);



						try {

							generics.genericKeywords.waitUntilElementIsClickable(5, loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr[2]/td[1]//span//button")));

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							// addOnNodes.get(j).click();

							//System.out.println("Try block Click Executed");

							//System.out.println(addOnHederType+" Add ons Item added to deal builder ");



						}catch(Exception e) {

							Thread.sleep(2000);

							addOnNodes.get(j+2).click();

							addOnNodes.get(j+2).sendKeys(Keys.TAB);

							Thread.sleep(2000);

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr[2]/td[1]//span//button")).sendKeys(Keys.ENTER);

							//System.out.println("Catch block Click Executed");

							//System.out.println(addOnHederType+" Add ons Item added to deal builder ");

						}

						break;

					}

					break;

				}

				Thread.sleep(7000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, addOnHederType+" click operation Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS," Flex PayG plan added to deal builder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS," Flex PayG plan added to deal builder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS," Flex PayG plan added to deal builder");

					reportDirectory.test_consolidated.log(LogStatus.PASS," Flex PayG plan added to deal builder");



				}

				Thread.sleep(6000);

			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, addOnHederType+" click operation Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, " Flex PayG plan is not added to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL,"Flex PayG plan is not added to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

		}

		/*

		 * Below function will accept plan from Add To Plan

		 * @param String headerType

		 * @author  Akarshit Srivastava

		 * @since   09-Sepetember-2020

		 */



		public static Map<String,String> acceptPlanFromAddToPlanTab(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			Map<String,String> planAddedfromAddToPlan=null;



			try {      

				Thread.sleep(5000);

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

				for(int i=2; i<deviceTabRow.size(); i++) {

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					for(int n=1; n<deviceTabNodes.size(); n++) {

						/*planAddedfromAddToPlan=new HashMap<String,String>();

	                                                                        planAddedfromAddToPlan.put("Manufacturer", deviceTabNodes.get(n).getText());

	                                                                        planAddedfromAddToPlan.put("Name", deviceTabNodes.get(n+1).getText());

	                                                                        planAddedfromAddToPlan.put("Category", deviceTabNodes.get(n+2).getText());

	                                                                        planAddedfromAddToPlan.put("Upfront cost", deviceTabNodes.get(n+3).getText());

	                                                                        planAddedfromAddToPlan.put("MRC", deviceTabNodes.get(n+4).getText());

	                                                                        planAddedfromAddToPlan.put("Colour", deviceTabNodes.get(n+5).getText());*/



						deviceTabNodes.get(0).click();

						//genericKeywords.hilightElement(deviceTabNodes.get(0),loginPage.driver);

						deviceTabNodes.get(0).sendKeys(Keys.TAB);

						//genericKeywords.hilightElement(deviceTabNodes.get(n+1),loginPage.driver);

						deviceTabNodes.get(n+1).sendKeys(Keys.TAB);

						//genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]/td[9]//span//button")), loginPage.driver);

						Thread.sleep(3000);

						genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("((//table[@class='gridTable '])[1]//tr["+i+"]/td[8]//button)[3]")));

						break;

					}

					break;

				}

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Plan selection from AddToPlan Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Plan selection from AddToPlan Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

				}

				Thread.sleep(5000);

			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Plan selection from AddToPlan Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Plan selection from AddToPlan failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Plan selection from AddToPlan failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Plan selection from AddToPlan failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			return planAddedfromAddToPlan;

		}



		/*

		 * Below function will select plan from Add To Plan

		 * @param String headerType

		 * @author  Akarshit Srivastava

		 * @since   09-Sepetember-2020

		 */



		public static Map<String,String> selectPlanFromAddToPlanTab(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			Map<String,String> planAddedfromAddToPlan=null;



			try {      

				Thread.sleep(5000);

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver);

				for(int i=2; i<deviceTabRow.size(); i++) {

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					for(int n=1; n<deviceTabNodes.size(); n++) {

						/*planAddedfromAddToPlan=new HashMap<String,String>();

	                                                                        planAddedfromAddToPlan.put("Manufacturer", deviceTabNodes.get(n).getText());

	                                                                        planAddedfromAddToPlan.put("Name", deviceTabNodes.get(n+1).getText());

	                                                                        planAddedfromAddToPlan.put("Category", deviceTabNodes.get(n+2).getText());

	                                                                        planAddedfromAddToPlan.put("Upfront cost", deviceTabNodes.get(n+3).getText());

	                                                                        planAddedfromAddToPlan.put("MRC", deviceTabNodes.get(n+4).getText());

	                                                                        planAddedfromAddToPlan.put("Colour", deviceTabNodes.get(n+5).getText());*/



						deviceTabNodes.get(0).click();

						//genericKeywords.hilightElement(deviceTabNodes.get(0),loginPage.driver);

						deviceTabNodes.get(0).sendKeys(Keys.TAB);

						//genericKeywords.hilightElement(deviceTabNodes.get(n+1),loginPage.driver);

						deviceTabNodes.get(n+1).sendKeys(Keys.TAB);

						//genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]/td[9]//span//button")), loginPage.driver);

						Thread.sleep(3000);

						genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]/td[9]//span//button")));

						break;

					}

					break;

				}

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Plan selection from AddToPlan Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Plan selection from AddToPlan Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Plan selection from AddToPlan Passed");

				}

				Thread.sleep(5000);

			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Plan selection from AddToPlan Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Plan selection from AddToPlan failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Plan selection from AddToPlan failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Plan selection from AddToPlan failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			return planAddedfromAddToPlan;

		}



		/*

		 * Below function will select the  filter header from device tab on users choice .It takes the header as argument.

		 *

		 * @param String headerType

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void selectFilter(String headerType, String screenshotsPath ) throws IOException{

			WebElement tabElement;

			try{

				Thread.sleep(8000);

				switch (headerType){

				case "Manufacturer" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[1]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Manufacturer2" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[2]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Model" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[2]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Memory" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[3]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Speed" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[4]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;



				case "Device cost" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[5]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;



				}



				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Selecting Filter operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Filter operation Passed");

			}

			catch (Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Selecting Filter operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Filter operation Failed");

				e.printStackTrace();

			}

		}



		/*

		 * Below function will select the  filter header from device tab on users choice .It takes the header as argument.

		 *

		 * @param String headerType

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void paygsSlectFilter(String headerType, String screenshotsPath ) throws IOException{

			WebElement tabElement;

			try{

				Thread.sleep(5000);

				switch (headerType){

				case "Manufacturer" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[7]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Manufacturer2" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[2]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Model" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[8]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Memory" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[9]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Upfront cost" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[10]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				case "Speed" :

					tabElement=loginPage.driver.findElement(By.xpath("(//a[@id='pui_filter'])[11]"));

					genericKeywords.waitExplicit(tabElement, 20);

					genericKeywords.jsClick(tabElement)  ;

					break;

				}



				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Selecting Filter operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Filter operation Passed");

			}

			catch (Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Selecting Filter operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Filter operation Failed");

				e.printStackTrace();

			}

		}

		/*

		 * Below function will select the  Manufacturer from filter from device tab on users choice .It takes the devicManufacturere as argument.

		 * @param String devicManufacturere

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void selectManufacturereNameFromFilter(String devicManufacturere,String screenshotsPath) throws IOException {



			try {

				List<WebElement> filterRow=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr"));

				for(int i=2;i<=filterRow.size();i++ ) {

					List<WebElement> filternode=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td"));

					for(int n=0;n<filternode.size();n++ ) {

						String manuName=filternode.get(n).getText();

						if(manuName.equalsIgnoreCase(devicManufacturere)) {

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td[2]")).click();

							Thread.sleep(5000);

							WebElement checkBox = loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td[1]"));

							//genericKeywords.waitExplicit(checkBox, 20);

							checkBox.click();

							//genericKeywords.jsClick(checkBox);

							Thread.sleep(5000);

							genericKeywords.locateElement("compassPlusPageDeviceTabFilterApplyBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

							//genericKeywords.locateElement("compassPlusPageDeviceTabFilterApplyBtn_xpath", loginPage.driver).click();

							break;

						}

					}

				}

				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Selecting Manufracturer Type from Filter operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Manufracturer Type from Filter operation Passed");       



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Selecting Manufracturer Type from Filter operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Manufracturer Type from Filter operation Failed");

				e.printStackTrace();

			}

		}

		/*

		 * Below function will select the  Device Cost from filter from device tab on users choice .It takes the Device cost as argument.

		 * @param String devicManufacturere

		 * @author  Akarshit Srivastava

		 * @since   01-June-2021

		 */

		public static void selectDeviceCostFromFilter(String deviceCost,String screenshotsPath) throws IOException {



			try {

				List<WebElement> filterRow=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr"));

				for(int i=2;i<=filterRow.size();i++ ) {

					List<WebElement> filternode=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td"));

					for(int n=0;n<filternode.size();n++ ) {

						String manuName=filternode.get(n).getText();

						if(manuName.equalsIgnoreCase(deviceCost)) {

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td[2]")).click();

							Thread.sleep(5000);

							WebElement checkBox = loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td[1]"));

							//genericKeywords.waitExplicit(checkBox, 20);

							checkBox.click();

							//genericKeywords.jsClick(checkBox);

							Thread.sleep(5000);

							genericKeywords.locateElement("compassPlusPageDeviceTabFilterApplyBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

							//genericKeywords.locateElement("compassPlusPageDeviceTabFilterApplyBtn_xpath", loginPage.driver).click();

							break;

						}

					}

				}

				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Selecting Manufracturer Type from Filter operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Manufracturer Type from Filter operation Passed");       



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Selecting Manufracturer Type from Filter operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Manufracturer Type from Filter operation Failed");

				e.printStackTrace();

			}

		}

		/*

		 * Below function will select the  Manufacturer from filter from device tab on users choice .It takes the devicManufacturere as argument.

		 * @param String devicManufacturere

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void paygSelectManufacturereNameFromFilter(String devicManufacturere,String screenshotsPath) throws IOException {



			try {

				List<WebElement> filterRow=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[4]//tr"));

				for(int i=2;i<=filterRow.size();i++ ) {

					List<WebElement> filternode=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[4]//tr["+i+"]//td"));

					for(int n=0;n<filternode.size();n++ ) {

						String manuName=filternode.get(n).getText();

						if(manuName.equalsIgnoreCase(devicManufacturere)) {

							loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[4]//tr["+i+"]//td[2]")).click();

							Thread.sleep(5000);

							WebElement checkBox = loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[4]//tr["+i+"]//td[1]"));

							//genericKeywords.waitExplicit(checkBox, 20);

							checkBox.click();

							//genericKeywords.jsClick(checkBox);

							Thread.sleep(2000);

							genericKeywords.locateElement("compassPlusPageDeviceTabFilterApplyBtn_xpath", loginPage.driver).sendKeys(Keys.ENTER);

							break;

						}

					}

				}

				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Selecting Manufracturer Type from Filter operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting Manufracturer Type from Filter operation Passed");       



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Selecting Manufracturer Type from Filter operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting Manufracturer Type from Filter operation Failed");

				e.printStackTrace();

			}

		}



		/*

		 * Below function will select the  Device from device tab from device tab on users choice .It takes the device colour as argument.

		 * @param String deviceColour

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void selectDeviceFromDeviceTab2(String deviceColour, String screenshotsPath) throws IOException, InterruptedException {



			String valOfNodes = null;



			try {

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver); 



				for(int i=2; i<deviceTabRow.size(); i++){

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));



					for(int n=0; n<deviceTabNodes.size(); n++){



						try {

							Thread.sleep(3000);

							loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]")).click();

							WebElement selectColourDrpDwn=loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]"));

							Thread.sleep(3000);

							genericKeywords.selectFromDropdown(selectColourDrpDwn,"index",deviceColour);

							Thread.sleep(3000);

							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[7]//span//button"));

								genericKeywords.jsClick(addBtn);

								Thread.sleep(1000);

								break;

							}                                             



						}catch (Exception e) {

							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								valOfNodes=deviceTabNodes.get(n+1).getText();

								System.out.println("valOfNodes="+valOfNodes);

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[7]//span//button"));

								genericKeywords.jsClick(addBtn);

								break;

							}

						}

					}

					break;

				}



				Thread.sleep(8000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				e.printStackTrace();

			}

		}

		public static void retailSelectDeviceFromDeviceTab2(String deviceColour, String screenshotsPath) throws IOException, InterruptedException {



			String valOfNodes = null;



			try {

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver); 



				for(int i=2; i<deviceTabRow.size(); i++){

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));



					for(int n=0; n<deviceTabNodes.size(); n++){



						try {

							loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]")).click();

							WebElement selectColourDrpDwn=loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]"));

							genericKeywords.selectFromDropdown(selectColourDrpDwn,"index",deviceColour);



							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[6]//span//button"));

								genericKeywords.jsClick(addBtn);

								Thread.sleep(1000);

								break;

							}                                             



						}catch (Exception e) {

							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								valOfNodes=deviceTabNodes.get(n+1).getText();

								System.out.println("valOfNodes="+valOfNodes);

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[6]//span//button"));

								genericKeywords.jsClick(addBtn);

								break;

							}

						}

					}

					break;

				}



				Thread.sleep(8000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				e.printStackTrace();

			}

		}





		public static void selectAddLineDeviceFromDeviceTab(String deviceColour, String screenshotsPath) throws IOException, InterruptedException {



			String valOfNodes = null;



			try {

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver); 



				for(int i=2; i<deviceTabRow.size(); i++){

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));



					for(int n=0; n<deviceTabNodes.size(); n++){



						try {

							loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]")).click();

							WebElement selectColourDrpDwn=loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]"));

							genericKeywords.selectFromDropdown(selectColourDrpDwn,"visibleText",deviceColour);



							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[8]//span//button"));

								genericKeywords.jsClick(addBtn);

								Thread.sleep(1000);

								break;

							}                                             

						}catch (Exception e) {

							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								//valOfNodes=deviceTabNodes.get(n+1).getText();

								//System.out.println("valOfNodes="+valOfNodes);

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[8]//span//button"));

								genericKeywords.jsClick(addBtn);

								break;

							}

						}

					}

					break;

				}

				Thread.sleep(8000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				e.printStackTrace();

			}

		}





		/*

		 * Below function will select the  Device from device tab from device tab on users choice .It takes the device colour as argument.

		 * @param String deviceColour

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void paygSelectDeviceFromDeviceTab(String deviceColour, String screenshotsPath) throws IOException, InterruptedException {



			String valOfNodes = null;



			try {

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTabPayg_xpath", loginPage.driver); 



				for(int i=2; i<deviceTabRow.size(); i++){

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[2]//tr["+i+"]//td"));



					for(int n=0; n<deviceTabNodes.size(); n++){



						try {

							loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(8+i)+"]")).click();

							WebElement selectColourDrpDwn=loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(8+i)+"]"));

							genericKeywords.selectFromDropdown(selectColourDrpDwn,"index",deviceColour);



							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[2]//tr[i]//td[8]//span//button"));

								genericKeywords.jsClick(addBtn);

								Thread.sleep(1000);

								break;

							}                                              



						}catch (Exception e) {

							if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

								valOfNodes=deviceTabNodes.get(n+1).getText();

								System.out.println("valOfNodes="+valOfNodes);

								WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[2]//tr[2]//td[8]//span//button"));

								genericKeywords.jsClick(addBtn);

								break;

							}

						}

					}

					break;

				}



				Thread.sleep(8000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				e.printStackTrace();

			}

		}



		/*

		 * Below function will select the  Device from device tab from device tab on users choice .It takes the device colour as argument.

		 * @param String deviceColour

		 * @author  Akarshit Srivastava

		 * @since   15-March-2020

		 */

		public static void selectSmeRecommedDeviceFromDeviceTab(String deviceColour,String screenshotsPath) throws IOException, InterruptedException {



			String valOfNodes = null;



			try {

				List<WebElement> deviceTabRow= genericKeywords.locateElements("compassPlusPageNumOfRowsInDivceTab_xpath", loginPage.driver); 



				for(int i=2; i<deviceTabRow.size(); i++){

					List<WebElement> deviceTabNodes=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr["+i+"]//td"));

					for(int n=0; n<=deviceTabNodes.size(); n++){

						String node=deviceTabNodes.get(n).getText();

						if(node.equalsIgnoreCase("Recommended")) {

							try {

								loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]")).click();

								WebElement selectColourDrpDwn=loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i-1)+"]"));

								Thread.sleep(3000);

								genericKeywords.selectFromDropdown(selectColourDrpDwn,"index",deviceColour);

								Thread.sleep(3000);

								if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

									WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[8]//span//button"));

									genericKeywords.jsClick(addBtn);

									Thread.sleep(1000);

									break;

								}                                             



							}catch (Exception e) {

								if(genericKeywords.waitUntilElementIsDisplayed(10, deviceTabNodes.get(n))) {

									valOfNodes=deviceTabNodes.get(n+1).getText();

									System.out.println("valOfNodes="+valOfNodes);

									WebElement addBtn=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable '])[1]//tr[2]//td[8]//span//button"));

									genericKeywords.jsClick(addBtn);

									break;

								}

							}

						}

					}

					break;

				}



				Thread.sleep(8000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Device Adding to Deal builder operation Passed");



			}catch(Exception e) {

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Device Adding to Deal builder operation Failed");

				e.printStackTrace();

			}

		}





		/**

		 * Below function captures Basket Summery Page Header Details

		 * It accepts no parameters

		 * @param

		 * @param

		 * @return void

		 * @author Devi Das

		 * @throws InterruptedException

		 * @throws IOException

		 * @since 19-May-2020

		 */

		public static LinkedHashMap<String, ArrayList<String>> captureBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(2000);

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(2000);

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(ctn);

				basketSummeryPageHeaderData.put("CTN", list);



				String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-field item-2 remove-bottom-spacing remove-right-spacing   dataValueRead flex flex-row '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				String endRevenue=loginPage.driver.findElement(By.xpath("(//p[@name='$PpyWorkPage$pBasketEndRevenue'])[1]")).getText();

				list=new ArrayList<String>();

				list.add(endRevenue);

				basketSummeryPageHeaderData.put("End Revenue", list);

				System.out.println("Basket summery page header: "+basketSummeryPageHeaderData);     

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageHeaderData;

		}



		public static LinkedHashMap<String, ArrayList<String>> captureAddLineBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(2000);

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(2000);

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				/*          String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

	                                           list=new ArrayList<String>();

	                                           list.add(ctn);

	                                           basketSummeryPageHeaderData.put("CTN", list);

				 */

				String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				/*String endRevenue=loginPage.driver.findElement(By.xpath("(//p[@name='$PpyWorkPage$pBasketEndRevenue'])[1]")).getText();

	                                           list=new ArrayList<String>();

	                                           list.add(endRevenue);

	                                           basketSummeryPageHeaderData.put("End Revenue", list);

				 */

				System.out.println("Basket summery page header:1 "+basketSummeryPageHeaderData);  

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(2000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}





			return basketSummeryPageHeaderData;

		}

		public static LinkedHashMap<String, ArrayList<String>> captureAddLine2BasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(2000);

			try {

				//loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(2000);

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[4]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				/*          String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

	                                           list=new ArrayList<String>();

	                                           list.add(ctn);

	                                           basketSummeryPageHeaderData.put("CTN", list);

				 */

				String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[6]//span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				/*String endRevenue=loginPage.driver.findElement(By.xpath("(//p[@name='$PpyWorkPage$pBasketEndRevenue'])[1]")).getText();

	                                           list=new ArrayList<String>();

	                                           list.add(endRevenue);

	                                           basketSummeryPageHeaderData.put("End Revenue", list);

				 */

				System.out.println("Basket summery page header2: "+basketSummeryPageHeaderData);  

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(2000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}





			return basketSummeryPageHeaderData;

		}





		public static LinkedHashMap<String, ArrayList<String>> captureRetailPaymBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(2000);

			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(2000);

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(ctn);

				basketSummeryPageHeaderData.put("CTN", list);



				String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-field item-2 remove-bottom-spacing remove-right-spacing   dataValueRead flex flex-row '])[2]//span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				/*String endRevenue=loginPage.driver.findElement(By.xpath("(//p[@name='$PpyWorkPage$pBasketEndRevenue'])[1]")).getText();

	                                           list=new ArrayList<String>();

	                                           list.add(endRevenue);

	                                           basketSummeryPageHeaderData.put("End Revenue", list);

	                                           System.out.println("Basket summery page header: "+basketSummeryPageHeaderData);     

				 */

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageHeaderData;

		}





		public static LinkedHashMap<String, ArrayList<String>> captureUnderConsiderationBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(2000);

			try {

				loginPage.driver.switchTo().frame("PegaGadget3Ifr");

				Thread.sleep(2000);

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(ctn);

				basketSummeryPageHeaderData.put("CTN", list);



				String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-field item-2 remove-bottom-spacing remove-right-spacing   dataValueRead flex flex-row '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				String endRevenue=loginPage.driver.findElement(By.xpath("(//p[@name='$PpyWorkPage$pBasketEndRevenue'])[1]")).getText();

				list=new ArrayList<String>();

				list.add(endRevenue);

				basketSummeryPageHeaderData.put("End Revenue", list);

				System.out.println("Basket summery page header: "+basketSummeryPageHeaderData);     

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageHeaderData;

		}





		/**

		 * Below function captures Basket Summery Page Header Details

		 * It accepts no parameters

		 * @param

		 * @param

		 * @return void

		 * @author Devi Das

		 * @throws InterruptedException

		 * @throws IOException

		 * @since 19-May-2020

		 */

		public static LinkedHashMap<String, ArrayList<String>> captureAddToPlanBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(2000);

			try {

				String ctn=loginPage.driver.findElement(By.xpath("//div[@class='flex  content   layout-content-inline_grid_double content-inline_grid_double ']/div[2]/span")).getText();

				list=new ArrayList<String>();

				list.add(ctn);

				basketSummeryPageHeaderData.put("CTN", list);



				String accountNumber=loginPage.driver.findElement(By.xpath("//div[@class='flex  content   layout-content-inline_grid_double content-inline_grid_double ']/div[4]/span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				/*String totalMrc=loginPage.driver.findElement(By.xpath("//p[@name='$PpyWorkPage$pTotalMRC']")).getText();

	                                           list=new ArrayList<String>();

	                                           list.add(accountNumber);

	                                           basketSummeryPageHeaderData.put("totalMrc", list);

				 */

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageHeaderData;

		}





		/**

		 * Below function captures Basket Summery Page Header Details

		 * It accepts no parameters

		 *

		 * @param

		 * @param

		 * @return void

		 *

		 * @author Devi Das

		 * @throws InterruptedException

		 * @throws IOException

		 * @since 19-May-2020

		 */

		public static LinkedHashMap<String, ArrayList<String>> captureRetailBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

			Thread.sleep(6000);

			try {

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]//span")).getText();

				list=new ArrayList<String>();

				list.add(ctn);

				basketSummeryPageHeaderData.put("CTN", list);



				String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-field item-2 remove-bottom-spacing remove-right-spacing   dataValueRead flex flex-row '])[2]//span")).getText();

				list=new ArrayList<String>();

				list.add(accountNumber);

				basketSummeryPageHeaderData.put("Account number", list);



				String endRevenue=loginPage.driver.findElement(By.xpath("//p[@name='$PpyWorkPage$pBasketEndRevenue']")).getText();

				list=new ArrayList<String>();

				list.add(endRevenue);

				basketSummeryPageHeaderData.put("End Revenue", list);

				System.out.println("Basket summery page header: "+basketSummeryPageHeaderData);     

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageHeaderData;

		}



		/**

		 * Below function captures Basket Summery Page Header Details for Pegasus journey

		 * It accepts no parameters

		 *

		 * @param

		 * @param

		 * @return void

		 *

		 * @author Devi Das

		 * @throws InterruptedException

		 * @throws IOException

		 * @since 19-May-2020

		 */

		public static LinkedHashMap<String, ArrayList<String>> pegasusCaptureBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			ArrayList<String> list;    

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();



			try {

				loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				Thread.sleep(2000);

				String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]//span")).getText();

				list=new ArrayList<String>();

				list.add(outcome);

				basketSummeryPageHeaderData.put("Outcome", list);



				String customerId=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content  false layout-content-inline_grid_70_30 content-inline_grid_70_30 '])[2]//div/span")).getText();

				list=new ArrayList<String>();

				list.add(customerId);

				basketSummeryPageHeaderData.put("Customer ID", list);



				String endRevenue=loginPage.driver.findElement(By.xpath("//p[@name='$PpyWorkPage$pBasketEndRevenue']")).getText();

				list=new ArrayList<String>();

				list.add(endRevenue);

				basketSummeryPageHeaderData.put("End Revenue", list);

				System.out.println("Basket summery page header: "+basketSummeryPageHeaderData);     

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageHeaderData;

		}



		/**

		 * Below function captures Basket Summery Page Details

		 * It accepts no parameters

		 *

		 * @param

		 * @param

		 * @return void

		 *

		 * @author Devi Das

		 * @throws InterruptedException

		 * @throws IOException

		 * @since 18-May-2020

		 */

		public static LinkedHashMap<String, ArrayList<String>> captureBasketSummeryPageDescription(String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String key = null;

			ArrayList<String> list;                   

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageDescriptionData=new LinkedHashMap<String, ArrayList<String>>();



			try {

				List<WebElement> totalRowsUnderDeal1=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr"));



				for(int i=2;i<=totalRowsUnderDeal1.size();i++) {



					List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td"));

					list=new ArrayList<String>();



					for(int j=1; j<=noOfColumns.size(); j++) {



						try {

							String description=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td["+j+"]")).getText();

							if(j == 1) {

								key=description;

							}else {

								list.add(description);                                                              

							}

						}catch(Exception e) {

							e.printStackTrace();

						}

					}



					basketSummeryPageDescriptionData.put(key, list);        

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				}

				Thread.sleep(3000);

				//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[text()='Close']")));

				genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[text()='Close'])[1]")));

				System.out.println("Basket summery page description: "+basketSummeryPageDescriptionData);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageDescriptionData;     

		}

		public static LinkedHashMap<String, ArrayList<String>> addLine1CaptureBasketSummeryPageDescription(String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String key = null;

			ArrayList<String> list;                   

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageDescriptionData=new LinkedHashMap<String, ArrayList<String>>();



			try {

				List<WebElement> totalRowsUnderDeal1=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr"));



				for(int i=2;i<=totalRowsUnderDeal1.size();i++) {



					List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td"));

					list=new ArrayList<String>();



					for(int j=1; j<=noOfColumns.size(); j++) {



						try {

							String description=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td["+j+"]")).getText();

							if(j == 1) {

								key=description;

							}else {

								list.add(description);                                                              

							}

						}catch(Exception e) {

							e.printStackTrace();

						}

					}



					basketSummeryPageDescriptionData.put(key, list);        

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				}

				Thread.sleep(3000);

				//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[text()='Close']")));

				//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[text()='Close'])[1]")));

				System.out.println("Basket summery page description1: "+basketSummeryPageDescriptionData);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageDescriptionData;     

		}

		public static LinkedHashMap<String, ArrayList<String>> captureAddLine2BasketSummeryPageDescription(String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			String key = null;

			ArrayList<String> list;                   

			LinkedHashMap<String, ArrayList<String>> basketSummeryPageDescriptionData=new LinkedHashMap<String, ArrayList<String>>();



			try {

				List<WebElement> totalRowsUnderDeal1=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr"));



				for(int i=2;i<=totalRowsUnderDeal1.size();i++) {



					List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]/td"));

					list=new ArrayList<String>();



					for(int j=1; j<=noOfColumns.size(); j++) {



						try {

							String description=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]/td["+j+"]")).getText();

							if(j == 1) {

								key=description;

							}else {

								list.add(description);                                                              

							}

						}catch(Exception e) {

							e.printStackTrace();

						}

					}



					basketSummeryPageDescriptionData.put(key, list);        

					pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				}

				Thread.sleep(3000);

				//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[text()='Close']")));

				genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[text()='Close'])[1]")));

				System.out.println("Basket summery page description2: "+basketSummeryPageDescriptionData);

				Thread.sleep(5000);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Description Passed");



				}

				Thread.sleep(5000);



			}catch(Exception e) {

				/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

	                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed");

	                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed");

	                                           e.printStackTrace();*/

				reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}



			return basketSummeryPageDescriptionData;     

		}



		/*

		 * Below function perform Line checker operation

		 * It accepts 3 parameters

		 *

		 * @param postCode

		 * @param screenshotsPath

		 * @param screenshotToBeCaptured

		 * @return void

		 * @author Akarshit

		 * @throws IOException

		 * @since 17-June-2020

		 */

		public static void lineCheckerHomeJourney(String postCode,String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(3000);

				//loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				//genericKeywords.locateElement("homeMoveLineCheckerPostCode_xpath", loginPage.driver).click();

				genericKeywords.locateElement("homeMoveLineCheckerPostCode_xpath", loginPage.driver).sendKeys(postCode);

				genericKeywords.locateElement("homeMoveLineCheckerPostCodeSearchIcon_xpath", loginPage.driver).sendKeys(Keys.ENTER);

				//genericKeywords.jsClick(genericKeywords.locateElement("homeMoveLineCheckerPostCodeSearchIcon_xpath", loginPage.driver));

				Thread.sleep(3000);

				genericKeywords.waitUntilElementIsClickable(2, genericKeywords.locateElement("homeMoveLineCheckerSelectAdressDrpDwn_id", loginPage.driver));

				genericKeywords.clickElement(genericKeywords.locateElement("homeMoveLineCheckerSelectAdressDrpDwn_id", loginPage.driver));

				genericKeywords.selectFromDropdown(genericKeywords.locateElement("homeMoveLineCheckerSelectAdressDrpDwn_id", loginPage.driver), "index", "2");

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				genericKeywords.clickElement(genericKeywords.locateElement("homeMoveLineCheckerSubmitBtn_xpath", loginPage.driver));



				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Line Checker Validation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Line Checker Validation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Line Checker Validation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Line Checker Validation Passed");

				}

				Thread.sleep(5000);



			}catch (Exception e) {

				//e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, "Line Checker Validation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Line Checker Validation Falied"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			Thread.sleep(5000);

		}

		/*

		 * Below function captures Basket Summery Page Details

		 * It accepts no parameters

		 *

		 * @param

		 * @param

		 * @return void

		 *

		 * @author Devi Das

		 * @throws InterruptedException

		 * @throws IOException

		 * @since 18-May-2020

		 */

		public static LinkedHashMap<String, ArrayList<String>> captureDealBuilderData() {



			String key = null;

			ArrayList<String> list;                   

			LinkedHashMap<String, ArrayList<String>> dealBuilderData=new LinkedHashMap<String, ArrayList<String>>();



			try {

				List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr"));



				for(int i=2;i<=totalRowsUnderDealBuilderTable.size();i++) {



					List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td"));

					list=new ArrayList<String>();



					for(int j=1; j<noOfColumns.size(); j++) { 



						try {

							String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]/td["+j+"]")).getText();

							if(j == 1) {

								key=dataUnderDealBuilder;

							}else {

								list.add(dataUnderDealBuilder);                                                         

							}

						}catch(Exception e) {

							e.printStackTrace();

						}

					}



					dealBuilderData.put(key, list);   

				}



				System.out.println(dealBuilderData);



			}catch(Exception e) {

				e.printStackTrace();

			}



			return dealBuilderData;

		}



		public static void vatSelectAddLineTile(String tileHeader,String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(3000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				//genericKeywords.locateElement("homeMoveLineCheckerPostCode_xpath", loginPage.driver).click();

				List<WebElement> tile=loginPage.driver.findElements(By.xpath("//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//button[contains(.,'Accept')]"));



				for(int i=1;i<=tile.size();i++) {

					String tileName=loginPage.driver.findElement(By.xpath("(//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//h2)["+i+"]")).getText();

					if(tileName.equalsIgnoreCase(tileHeader))             

					{

						//genericKeywords.hilightElement(tile.get(i-1), loginPage.driver);

						tile.get(i-1).sendKeys(Keys.ENTER);

						break;

					}

				}



				//genericKeywords.clickElement(genericKeywords.locateElement("homeMoveLineCheckerSubmitBtn_xpath", loginPage.driver));



				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, tileHeader+"Added to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, tileHeader+"Added to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, tileHeader+"Added to dealbuilder");

					reportDirectory.test_consolidated.log(LogStatus.PASS, tileHeader+"Added to dealbuilder");

				}

				Thread.sleep(3000);

			}catch (Exception e) {

				//e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, tileHeader+"unable to add to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, tileHeader+"unable to add to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			Thread.sleep(5000);

		}



		public static void vatSelectUpgradeTileTile(String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(3000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				loginPage.driver.findElements(By.xpath("(//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//button[contains(.,'Accept')])[1]"));

				loginPage.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Upgrade added to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Upgrade added to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Upgrade added to dealbuilder");

					reportDirectory.test_consolidated.log(LogStatus.PASS,"Upgrade added to dealbuilder");

				}

				Thread.sleep(3000);



			}catch (Exception e) {

				//e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, "Unable to add upgrade"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL,"Unable to add upgrade"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			Thread.sleep(5000);

		}



		public static void vatSelectTarrifValueTile(String tileHeader,String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(3000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				//genericKeywords.locateElement("homeMoveLineCheckerPostCode_xpath", loginPage.driver).click();

				List<WebElement> tile=loginPage.driver.findElements(By.xpath("//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//button[contains(.,'Accept')]"));



				for(int i=1;i<=tile.size();i++) {

					String tileName=loginPage.driver.findElement(By.xpath("(//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//h2)["+i+"]")).getText();

					if(tileName.equalsIgnoreCase(tileHeader))             

					{

						genericKeywords.hilightElement(tile.get(i), loginPage.driver);

						tile.get(i-1).sendKeys(Keys.ENTER);

						break;

					}

				}



				//genericKeywords.clickElement(genericKeywords.locateElement("homeMoveLineCheckerSubmitBtn_xpath", loginPage.driver));



				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, tileHeader+"Added to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, tileHeader+"Added to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, tileHeader+"Added to dealbuilder");

					reportDirectory.test_consolidated.log(LogStatus.PASS, tileHeader+"Added to dealbuilder");

				}

				Thread.sleep(3000);

			}catch (Exception e) {

				//e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, tileHeader+"unable to add to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, tileHeader+"unable to add to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			Thread.sleep(5000);

		}



		public static void recsPromosSelectAddLineTile(String tileHeader,int tileNum,String deviceColour,String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				Thread.sleep(3000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//loginPage.driver.switchTo().frame("PegaGadget2Ifr");

				//genericKeywords.locateElement("homeMoveLineCheckerPostCode_xpath", loginPage.driver).click();

				List<WebElement> tile=loginPage.driver.findElements(By.xpath("//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//button[contains(.,'Add')]"));



				for(int i=tileNum;i<=tile.size();i++) {

					String tileName=loginPage.driver.findElement(By.xpath("(//div[@class='content    flex  layout-content-inline_grid_quadruple content-inline_grid_quadruple ']/div//h2)["+i+"]")).getText();

					if(tileName.equalsIgnoreCase(tileHeader))             

					{

						try {

							loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i)+"]")).click();

							WebElement selectColourDrpDwn=loginPage.driver.findElement(By.xpath("(//select[@id='SelectedColour'])["+(i)+"]"));

							genericKeywords.selectFromDropdown(selectColourDrpDwn,"index",deviceColour);

							tile.get(i-1).sendKeys(Keys.ENTER);

							Thread.sleep(1000);

							break;                                    



						}catch (Exception e) {

							tile.get(i-1).sendKeys(Keys.ENTER);

							break;

						}

					}

				}



				//genericKeywords.clickElement(genericKeywords.locateElement("homeMoveLineCheckerSubmitBtn_xpath", loginPage.driver));



				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, tileHeader+"Added to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, tileHeader+"Added to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, tileHeader+"Added to dealbuilder");

					reportDirectory.test_consolidated.log(LogStatus.PASS, tileHeader+"Added to dealbuilder");

				}

				Thread.sleep(3000);

			}catch (Exception e) {

				//e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, tileHeader+"unable to add to dealbuilder"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, tileHeader+"unable to add to dealbuilder"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			Thread.sleep(5000);

		}





		/**

		 * Below function select the Effective date from Add-ons Tab

		 * It accepts 3 parameters

		 * @param

		 * @param

		 * @param

		 * @return void

		 * @author Akarshit Srivastava

		 * @throws IOException

		 * @since 14-Setember-2020

		 */

		public static void vatSelectEffectiveDate(String day,String month,String year,String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException {

			String pathOfScreenshot = null;

			String fileName=new Throwable().getStackTrace()[0].getMethodName();

			try {

				genericKeywords.locateElement("vatSelectEffectiveDateCalander_xpath", loginPage.driver).click();

				Thread.sleep(3000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				Thread.sleep(3000);

				genericKeywords.locateElement("vatSelectMonthTextBox_xpath", loginPage.driver).sendKeys("Oct");

				Thread.sleep(3000);

				genericKeywords.locateElement("vatSelectYearTextBox_xpath", loginPage.driver).sendKeys("2021");

				Thread.sleep(3000);



				List<WebElement> tile=loginPage.driver.findElements(By.xpath("//table[@id='Pega_Cal_Cont']//tr/td/a"));



				for(int i=1;i<=tile.size();i++) {

					String text=tile.get(i).getText();



					if(text.equalsIgnoreCase(day))  

					{

						genericKeywords.hilightElement(tile.get(i), loginPage.driver);

						tile.get(i).sendKeys(Keys.ENTER);

						Thread.sleep(5000);

						break;

					}

				}

				WebElement submitBtn=genericKeywords.locateElement("vatDateSubmitBtn_xpath", loginPage.driver);

				genericKeywords.waitExplicit(submitBtn, 8);

				submitBtn.sendKeys(Keys.ENTER);





				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Date Selected"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Date Selected"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Date Selected");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Date Selected");

				}

				Thread.sleep(3000);

			}catch (Exception e) {

				//e.printStackTrace();

				reportDirectory.test.log(LogStatus.FAIL, "Date not Selected"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Date not Selected"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				e.printStackTrace();

			}

			Thread.sleep(5000);

		}







		/**

		 * Below function captures creates directory

		 * It accepts no parameters

		 *

		 * @param

		 * @param

		 * @return void

		 *

		 * @author Devi Das

		 * @throws IOException

		 * @since 17-MArch-2020

		 */

		/*public static void createDirectoryUIAutomation(String tcName) {



	                             try {

	                                           timestamp2=Generics.getTimestamp();                                                                         

	                                           file=new File(commonFilepath2+tcName+timestamp2);

	                                           file.mkdir();

	                             }catch(Exception e){

	                                           System.out.println("Error in creating directory");

	                                           test.log(LogStatus.INFO, "Error in creating directory");

	                                           test_consolidated.log(LogStatus.INFO, "Error in creating directory");

	                                           e.printStackTrace();

	                             }

	              }*/



		/**

		 * Below function is for initialise reporting

		 * It accepts 2 parameters

		 *

		 * @param test

		 * @param test_consolidated

		 *

		 * @author  Devi Das

		 * @since   13-May-2020

		 */

		public static void initializeExtentTestCommandsForReportingsForUIAutomation

		(ExtentTest test,ExtentTest test_consolidated) {



			test.log(LogStatus.INFO, "Start of Execution");

			test_consolidated.log(LogStatus.INFO, "Start of Execution");

		}



		/**

		 * Below function creates a directory,

		 * directory name is according to the timestamp,

		 * then it captures request and response into file

		 * It accepts 1 parameters

		 *

		 * @param String

		 * @return void

		 *

		 * @author Devi Das

		 * @throws IOException

		 * @throws FilloException

		 * @throws InterruptedException

		 * @since 13-May-2020

		 */

		/*public static void createDirectoryCaptureReportFilesInsideDirectoryUIAutomation

	              (String tcName) {



	                             try {

	                                           createDirectoryUIAutomation(tcName);

	                                           System.out.println("----------- TEST CASE EXECUTION STARTS -------------");

	                                           report=new ExtentReports(commonFilepath2+tcName+timestamp2+"/Report_"+tcName+".html");

	                                           test_consolidated=report_consolidated.startTest(tcName);

	                                           test=report.startTest(tcName);               

	                             initializeExtentTestCommandsForReportingsForUIAutomation(test,test_consolidated);

	                                           test.log(LogStatus.PASS, "");

	                                           test_consolidated.log(LogStatus.PASS, "");



	                             }catch(Exception e) {

	                                           e.printStackTrace();

	                             }                          

	              }*/



		/**

		 * Below function executes the whole UI functionalities

		 * It accepts 1 parameters

		 *

		 * @param String

		 * @return void

		 *

		 * @author Devi Das

		 * @throws IOException

		 * @since 13-May-2020

		 */

		public static void execute(String currMethodName) {



			/*timestamp=Generics.getTimestamp();                            

	                             report_consolidated=new ExtentReports(commonFilepath2+currMethodName+"_"+timestamp+".html");                                          

	              createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(currMethodName);



	                             try {

	                                           ArrayList<String> excelData=excelReusablesUI.read_RequestDataFromExcel("upgradeJourney");

	                                           System.out.println(excelData);



	                                           loginPage.loginToCompassPlus(excelData.get(3), excelData.get(4), excelData.get(5), excelData.get(6));

	                             //loginPage.loginToCompassPlus("ie","New_SIT_URL","613112916","rules");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Login To CompassPlus successful");

	                                           test_consolidated.log(LogStatus.PASS, "Login To CompassPlus successful");



	                                       designerStudioPage.clickOnONEBAAandSelectValueFromDropDown();

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Click On ONEBAA and Selected value from DropDown successful");

	                                           test_consolidated.log(LogStatus.PASS, "Click On ONEBAA and Selected value from DropDown successful");



	                                           compassPlusPage.newCTNsearch(excelData.get(7));

	                                           //compassPlusPage.newCTNsearch("07415982219");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "New CTN search successful");

	                                           test_consolidated.log(LogStatus.PASS, "New CTN search successful");



	                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW MORE')]")));

	                                           Thread.sleep(5000);



	                                           LinkedHashMap<String, String> customerDetails_profilePannel=profilePannel.getCustomerDetails();

	                                           System.out.println("customerDetails_profilePannel: "+customerDetails_profilePannel);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Fetched customer details from Profile Pannel");

	                                           test_consolidated.log(LogStatus.PASS, "Fetched customer details from Profile Pannel");



	                                           LinkedHashMap<String, String> eligibility_profilePannel=profilePannel.getEligibilityDetails();

	                                           System.out.println("eligibility_profilePannel: "+eligibility_profilePannel);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Fetched eligibility details from Profile Pannel");

	                                           test_consolidated.log(LogStatus.PASS, "Fetched eligibility details from Profile Pannel");



	                                           LinkedHashMap<String, String> productHolding_profilePannel=profilePannel.getProductHoldingDetails();

	                                           System.out.println("productHolding_profilePannel: "+productHolding_profilePannel);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Fetched product holding details from Profile Pannel");

	                                           test_consolidated.log(LogStatus.PASS, "Fetched product holding details from Profile Pannel");



	                                           LinkedHashMap<String, String> usage_profilePannel=profilePannel.getUsageDetails();

	                                           System.out.println("usage_profilePannel: "+usage_profilePannel);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Fetched usage details from Profile Pannel");

	                                           test_consolidated.log(LogStatus.PASS, "Fetched usage details from Profile Pannel");



	                             genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[contains(.,'SHOW LESS')]")));

	                                           Thread.sleep(5000);



	                                           compassPlusPage.selectCallReason("Upgrade");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Click On Upgrade call reason successful");

	                                           test_consolidated.log(LogStatus.PASS, "Click On Upgrade call reason successful");



	                                           //Sink issue

	                                           compassPlusPage.selectTab("Devices");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Click On Devices tab successful");

	                                           test_consolidated.log(LogStatus.PASS, "Click On Devices tab successful");



	                                           compassPlusPage.selectDeviceFromDeviceTab();

	                                           Thread.sleep(5000);



	                                           compassPlusPage.selectPlanFromPlanTab();

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Selected one Device successful");

	                                           test_consolidated.log(LogStatus.PASS, "Selected one Device successful");



	                                           compassPlusPage.selectSaveToolsTab();

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Selected Save Tools Tab successfully");

	                                           test_consolidated.log(LogStatus.PASS, "Selected Save Tools Tab successfully");



	                                           compassPlusPage.selectAddOnsFromAddOnsTab("Swappable Benefits - 1");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Swappable Benefits clicked successfully");

	                                           test_consolidated.log(LogStatus.PASS, "Swappable Benefits clicked successfully");



	                                           compassPlusPage.selectAddOnsFromAddOnsTab("Spend Cap");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Spend Cap clicked successfully");

	                                           test_consolidated.log(LogStatus.PASS, "Spend Cap clicked successfully");



	                                           compassPlusPage.selectTab("Add to plan");

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Click On Devices tab successful");

	                                           test_consolidated.log(LogStatus.PASS, "Click On Devices tab successful");



	                                           compassPlusPage.selectPlanFromAddToPlanTab();

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Plan selected from AddToPlan");

	                                           test_consolidated.log(LogStatus.PASS, "Plan selected from AddToPlan");



	                                           dealBuilderData=dealBuilderPage.captureDealBuilderData();

	                                           System.out.println("Deal builder data: "+dealBuilderData);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Deal Builder Data got captured");

	                                           test_consolidated.log(LogStatus.PASS, "Deal Builder Data got captured");



	                                           dealBuilderPage.jsClickOnAddToBasketButton();

	                                           Thread.sleep(10000);

	                                           test.log(LogStatus.PASS, "Yellow Basket Image inside Deal Builder");

	                                           test_consolidated.log(LogStatus.PASS, "Yellow Basket Image inside Deal Builder");



	                                           dealBuilderPage.jsClickOnYellowBasketImage();

	                                           Thread.sleep(10000);

	                                           test.log(LogStatus.PASS, "Yellow Basket Image inside Deal Builder");

	                                           test_consolidated.log(LogStatus.PASS, "Yellow Basket Image inside Deal Builder");



	                                           basketPage.takeActionOnParticularDeal("Accept", null);

	                                           Thread.sleep(5000);

	                                           basketPage.takeActionOnBasket("Submit");

	                                           Thread.sleep(5000);



	                             basketSummeryPageHeader=compassPlusPage.captureBasketSummeryPageHeader();

	                                           System.out.println("Basket summery page header: "+basketSummeryPageHeader);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Basket Summery Page Header");

	                                           test_consolidated.log(LogStatus.PASS, "Basket Summery Page Header");



	                             basketSummeryPageDescription=compassPlusPage.captureBasketSummeryPageDescription();

	                                           System.out.println("Basket summery page description: "+basketSummeryPageDescription);

	                                           Thread.sleep(5000);

	                                           test.log(LogStatus.PASS, "Basket Summery Page Description");

	                                           test_consolidated.log(LogStatus.PASS, "Basket Summery Page Description");



	                                           System.out.println("deal Builder Data size: "+dealBuilderData.size());

	                                           System.out.println("basket Summery Page Description size: "+basketSummeryPageDescription.size());



	                                           for(String key_basketSummeryPageDescription: basketSummeryPageDescription.keySet()){

	                                                         System.out.println(key_basketSummeryPageDescription);



	                                                          ArrayList<String> values=basketSummeryPageDescription.get(key_basketSummeryPageDescription);

	                                                          values.remove(0);

	                                           }



	                                           System.out.println("Updated New Basket map: "+basketSummeryPageDescription);



	                                           if(dealBuilderData.size() == basketSummeryPageDescription.size()) {



	                                           if(dealBuilderData.keySet().equals(basketSummeryPageDescription.keySet())) {



	                                                          dealBuilderData.values().equals(basketSummeryPageDescription.values());

	                                                                        test.log(LogStatus.PASS, "Deal Builder Data and Basket Summery Data are identical");

	                                                                        test_consolidated.log(LogStatus.PASS, "Deal Builder Data and Basket Summery Data are identical");

	                                                          }

	                                           }



	                             }catch(Exception e) {

	                                           e.printStackTrace();

	                             }



	                             test.log(LogStatus.INFO, "End of Execution");

	                             test_consolidated.log(LogStatus.INFO, "End of Execution");             

	                             report.endTest(test);                                               

	                             report_consolidated.endTest(test_consolidated);

	                             report.flush();

	                             report_consolidated.flush();*/

		}



	}

}
