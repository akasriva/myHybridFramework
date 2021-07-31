package generics;



import java.io.IOException;



import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;



import com.relevantcodes.extentreports.LogStatus;



import testSetup.reportDirectory;

import testSetup.userExceptionMsg;



public class designerStudioPage {

	/*

	 * Below function will select the ONEBA from switch application drop down list

	 * @return null

	 * @throws  IOException

	 * @author  Akarshit Srivastava

	 * @since   05-May-2020

	 */

	public static void  clickOnONEBAAandSelectValueFromDropDown(String screenshotsPath,boolean screenshotToBeCaptured)

			throws InterruptedException, IOException, userExceptionMsg {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver).click();

			}

			Thread.sleep(5000);

			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver);

				Thread.sleep(5000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				genericKeywords.jsClick(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver));

			}

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed");

			}

			//reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));



		}catch(Exception e) {     



			reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}



	}

	/*

	 * Below function will select the ONEBA for retail from switch application drop down list

	 * @return null

	 * @throws  IOException

	 * @author  Akarshit Srivastava

	 * @since   05-May-2020

	 */

	public static void  clickOnRetailONEBAAandSelectValueFromDropDown(String screenshotsPath,boolean screenshotToBeCaptured)

			throws InterruptedException, IOException, userExceptionMsg {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver).click();

			}

			Thread.sleep(5000);

			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchRetailAdvisor_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchRetailAdvisor_xpath", loginPage.driver);

				Thread.sleep(7000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				genericKeywords.jsClick(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchRetailAdvisor_xpath", loginPage.driver));

			}

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed");

			}

			//reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));



		}catch(Exception e) {     

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown "+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown "+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}



	}            





	/*

	 * Below function will select the Retail Advisor from switch application drop down list

	 * @return null

	 * @throws  IOException

	 * @author  Akarshit Srivastava

	 * @since   05-May-2020

	 */

	public static void  clickOnONEBAAandSelectRetailAdvisorFromDropDown(String screenshotsPath,boolean screenshotToBeCaptured)

			throws InterruptedException, IOException, userExceptionMsg {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver).click();

			}

			Thread.sleep(5000);

			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver);

				Thread.sleep(5000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				genericKeywords.jsClick(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchRetailAdvisor_xpath", loginPage.driver));

			}

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select Retail advisor from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select Retail advisor from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select Retail advisor from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select Retail advisor from DropDown Passed");

			}

			//reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));



		}catch(Exception e) {     

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select Retail advisor from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select Retail advisor from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}



	}

	/*

	 * Below function will select the OEMKT from switch application drop down list

	 * @return null

	 * @throws  IOException

	 * @author  Akarshit Srivastava

	 * @since   05-May-2020

	 */

	public static void  clickOnONEBAAandSelectOEMKTFromDropDown(String screenshotsPath,boolean screenshotToBeCaptured)

			throws InterruptedException, IOException, userExceptionMsg {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver).click();

			}

			Thread.sleep(5000);

			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppOEMKT_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppOEMKT_xpath", loginPage.driver));

			}



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppOEMKT_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppOEMKT_xpath", loginPage.driver);

				Thread.sleep(5000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				genericKeywords.jsClick(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppOEMKT_xpath", loginPage.driver));

			}

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed");

			}

			//reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));



		}catch(Exception e) {     

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		Thread.sleep(5000);

	}



	public static void retailClickOnOEMKT(String screenshotsPath) throws IOException {



		try {

			if(genericKeywords.waitUntilElementIsDisplayed(10,genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver))){

				genericKeywords.locateElement("designerStudioPageOENBAA_xpath", loginPage.driver).click();

			}

			Thread.sleep(8000);

			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver))){

				genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath", loginPage.driver));

			}



			/*if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("retailDesignerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

                                           genericKeywords.mouseHoverJScript(genericKeywords.locateElement("retailDesignerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver));

                                           }*/



			if(genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("retailDesignerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver))){

				genericKeywords.locateElement("retailDesignerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver);

				Thread.sleep(5000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				genericKeywords.jsClick(genericKeywords.locateElement("retailDesignerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath", loginPage.driver));

			}



			reportDirectory.test.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Click ONEBAA and Select value from DropDown Passed"+ reportDirectory.test.addScreenCapture(screenshotsPath));



		}catch(Exception e) {     

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click ONEBAA and Select value from DropDown Failed"+ reportDirectory.test.addScreenCapture(screenshotsPath));

			e.printStackTrace();

		}



















	}

}