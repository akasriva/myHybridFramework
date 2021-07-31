package generics;



import java.io.IOException;

import java.util.LinkedHashMap;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;



import com.relevantcodes.extentreports.LogStatus;



import testSetup.reportDirectory;



public class tradeInPage {



	public static void selectTradeInDevice(String screenshotsPath,boolean screenshotToBeCaptured ) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		try {

			Thread.sleep(8000);

			List<WebElement> dataNode=loginPage.driver.findElements(By.xpath("//div[@class=' layout-body clearfix']/table//tr[2]//td"));          

			for(int i=0;i<dataNode.size();i++) {

				WebElement selectManufacturer=genericKeywords.locateElement("tradeInPageManufacturerDrpDwn_xpath",loginPage.driver);

				selectManufacturer.click();

				genericKeywords.selectFromDropdown(selectManufacturer, "visibleText", "Apple");

				Thread.sleep(5000);

				genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("tradeInPageModelDrpDwn_xpath",loginPage.driver));

				WebElement model=genericKeywords.locateElement("tradeInPageModelDrpDwn_xpath",loginPage.driver);

				model.click();

				genericKeywords.selectFromDropdown(model, "visibleText", "iPhone 6");

				Thread.sleep(5000);

				genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("tradeInPageMemoryDrpDwn_xpath",loginPage.driver));

				WebElement memory=genericKeywords.locateElement("tradeInPageMemoryDrpDwn_xpath",loginPage.driver);

				memory.click();

				genericKeywords.selectFromDropdown(memory, "visibleText", "64");

				Thread.sleep(5000);

				genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("tradeInPageConditionDrpDwn_xpath",loginPage.driver));

				WebElement condition=genericKeywords.locateElement("tradeInPageConditionDrpDwn_xpath",loginPage.driver);

				condition.click();

				genericKeywords.selectFromDropdown(condition, "visibleText", "Display");

				Thread.sleep(5000);

				//reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				break;

			}

			Thread.sleep(5000);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed");



			}

			Thread.sleep(5000);



		}catch (Exception e) {

			e.printStackTrace();

			reportDirectory.test.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

		}

	}



	public static void selectTradeInDeviceUpgradeAnytime(String screenshotsPath,boolean screenshotToBeCaptured ) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		try {

			Thread.sleep(6000);

			List<WebElement> dataNode=loginPage.driver.findElements(By.xpath("//div[@class=' layout-body clearfix']/table//tr[2]//td"));          

			for(int i=0;i<dataNode.size();i++) {

				//              genericKeywords.hilightElement(dataNode.get(1), loginPage.driver);

				dataNode.get(1).click();

				dataNode.get(1).sendKeys(Keys.TAB);

				dataNode.get(2).click();

				List<WebElement> options=loginPage.driver.findElements(By.xpath("//select[@name='$PpyWorkPage$pUACSDeviceCondition']/option"));

				for(int o=0;o<options.size();o++)

				{

					options.get(1).click();

					break;

				}

				/*Thread.sleep(2000);

                                                         //genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("tradeInPageUpgradeAnytimeDeviceDrpDwn",loginPage.driver));

                                                          WebElement device=genericKeywords.locateElement("tradeInPageUpgradeAnytimeDeviceDrpDwn",loginPage.driver);

                                               device.click();

                                                         genericKeywords.selectFromDropdown(device, "index", "3");*/

				Thread.sleep(7000);





				//reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				break;



			}

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed");



			}

			Thread.sleep(5000);





		}catch (Exception e) {

			/*e.printStackTrace();

                                           reportDirectory.test.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			 */

			reportDirectory.test.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();



		}



	}

	public static void selectTradeInAnnualUpgrade(String screenshotsPath,boolean screenshotToBeCaptured ) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		try {

			Thread.sleep(4000);

			List<WebElement> dataNode=loginPage.driver.findElements(By.xpath("//div[@class=' layout-body clearfix']/table//tr[2]//td"));          

			for(int i=0;i<dataNode.size();i++) {

				//              genericKeywords.hilightElement(dataNode.get(1), loginPage.driver);

				dataNode.get(1).click();

				dataNode.get(1).sendKeys(Keys.TAB);

				dataNode.get(2).click();

				List<WebElement> options=loginPage.driver.findElements(By.xpath("//select[@name='$PpyWorkPage$pAUCSDeviceCondition']/option"));

				for(int o=0;o<options.size();o++)

				{

					options.get(1).click();

					break;

				}

				/*Thread.sleep(2000);

                                                         //genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("tradeInPageUpgradeAnytimeDeviceDrpDwn",loginPage.driver));

                                                          WebElement device=genericKeywords.locateElement("tradeInPageUpgradeAnytimeDeviceDrpDwn",loginPage.driver);

                                               device.click();

                                                         genericKeywords.selectFromDropdown(device, "index", "3");*/

				Thread.sleep(4000);



				//reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

				break;



			}

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Trade In selection Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In selection Passed");

			}

			Thread.sleep(5000);

		}catch (Exception e) {

			/*e.printStackTrace();

                                           reportDirectory.test.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			 */                       reportDirectory.test.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			 reportDirectory.test_consolidated.log(LogStatus.FAIL, "Trade In selection failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			 e.printStackTrace();

		}

	}



	public static LinkedHashMap<String,String> captureDataFromTradeInTab() throws IOException {

		try {

			Thread.sleep(4000);

			LinkedHashMap<String,String> mapDataTradeIn=new LinkedHashMap<String,String>() ;



			mapDataTradeIn.put(genericKeywords.locateElement("tradeInPageTradInValueHeader_xpath",loginPage.driver).getText(),

					genericKeywords.locateElement("tradeInPageTradInValue_xpath",loginPage.driver).getText());



			mapDataTradeIn.put(genericKeywords.locateElement("tradeInPageEufDiscountHeader_xpath",loginPage.driver).getText(),

					genericKeywords.locateElement("tradeInPageEufDiscountValue_xpath",loginPage.driver).getText());



			mapDataTradeIn.put(genericKeywords.locateElement("tradeInPageUpFrontDiscountHeader_xpath",loginPage.driver).getText(),

					genericKeywords.locateElement("tradeInPageUpFrontDiscountValue_xpath",loginPage.driver).getText());



			mapDataTradeIn.put(genericKeywords.locateElement("tradeInPageRemainderHeader_xpath",loginPage.driver).getText(),

					genericKeywords.locateElement("tradeInPageRemainderValue_xpath",loginPage.driver).getText());



			reportDirectory.test.log(LogStatus.PASS, "Trade In value captured Pass");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Trade In value captured Pass");

			return mapDataTradeIn;

		}

		catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Trade In value captured failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Trade In value captured failed");

			e.printStackTrace();

			return null;

		}



	}



}