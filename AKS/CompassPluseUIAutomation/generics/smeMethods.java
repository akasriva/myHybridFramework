package generics;



import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;



import com.relevantcodes.extentreports.LogStatus;



import testSetup.reportDirectory;



public class smeMethods {

	/*

	 * Below function captures Existing relationship table data

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return LinkedHashMap<String,ArrayList<String>>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String,ArrayList<String>> captureDataFromExistingRelationshipTable(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>>  mapExistingRelationship=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listExistingRelationship;

		String key=null;



		try {

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

			//genericKeywords.locateElement("smeCtnLink_xpath", loginPage.driver).click();

			Thread.sleep(5000);

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[2]//tr"));

			//System.out.println("dealDataRows.size() "+dealDataRows.size());

			for(int i=2;i<=dealDataRows.size()+1;i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[2]//tr["+i+"]//td"));

				//System.out.println("dealDataNodes.size() "+dealDataNodes.size());

				listExistingRelationship=new ArrayList <String>();

				for(int n=0;n<dealDataNodes.size();n++) {

					String description=dealDataNodes.get(n).getText();

					//System.out.println("description"+description);

					if(n==0) {

						key=description;

					}else {

						listExistingRelationship.add(description); 

					}

				}

				mapExistingRelationship.put(key,listExistingRelationship);

			}

			System.out.println("intractHistExpandData: "+mapExistingRelationship);

			Thread.sleep(5000);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			e.printStackTrace();

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapInteractionHistory  :"+mapInteractionHistory);

		return mapExistingRelationship;

	}



	public static void validateAccoutLevelProfilePanel(String screenshotsPath,boolean screenshotToBeCaptured) {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		try {

			Thread.sleep(8000);

			String acc=genericKeywords.locateElement("smeProfilePanelValidateAccountLevelProfilePanel_xpath", loginPage.driver).getText();

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(acc.equalsIgnoreCase("ACCOUNT DETAILS")) {



				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Account level Profile Panel Validation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Account level Profile Panel Validation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Account level Profile Panel Validation Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Account level Profile Panel Validation Passed");

				}

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			e.printStackTrace();

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Account level Profile Panel Validation failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account level Profile Panel Validation failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

	}



	/*

	 * Below function captures Detailed Average Usage table data

	 * It accepts no parameters

	 * @param

	 * @return LinkedHashMap<String,ArrayList<String>>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String,ArrayList<String>> captureDataFromDetailedAverageUsageTable(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>>  mapDetailedAverageUsage=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listEDetailedAverageUsage;

		String key=null;

		try {

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("//div[@param_name='EXPANDEDSubSectionShowAvgUsageDataBBBBBBBB']/div/table//tr"));

			//System.out.println("dealDataRows.size() "+dealDataRows.size());

			for(int i=2;i<=dealDataRows.size()+1;i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("//div[@param_name='EXPANDEDSubSectionShowAvgUsageDataBBBBBBBB']/div/table//tr["+i+"]//td"));

				//System.out.println("dealDataNodes.size() "+dealDataNodes.size());

				listEDetailedAverageUsage=new ArrayList <String>();

				for(int n=0;n<dealDataNodes.size();n++) {

					String description=dealDataNodes.get(n).getText();

					//System.out.println("description"+description);

					if(n==0) {

						key=description;

					}else {

						listEDetailedAverageUsage.add(description); 

					}

				}

				mapDetailedAverageUsage.put(key,listEDetailedAverageUsage);

			}

			System.out.println("intractHistExpandData: "+mapDetailedAverageUsage);

			Thread.sleep(5000);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from Detailed Average Usage Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from Detailed Average Usage Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from Detailed Average Usage Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from Detailed Average Usage Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			e.printStackTrace();

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                                          reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                                          e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from Detailed Average Usage Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from Detailed Average Usage Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapInteractionHistory  :"+mapInteractionHistory);

		return mapDetailedAverageUsage;

	}



	/*

	 * Below function captures Detailed Average Usage table data

	 * It accepts no parameters

	 * @param

	 * @return LinkedHashMap<String,ArrayList<String>>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 21-May-2020

	 */

	public static boolean validateValueDetailedAverageUsageTable(String validateValue) throws IOException, InterruptedException {



		List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("//div[@param_name='EXPANDEDSubSectionShowAvgUsageDataBBBBBBBB']/div/table//tr"));

		for(int i=1;i<=dealDataRows.size();i++) {

			if(i==1 ||i==4) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("//div[@param_name='EXPANDEDSubSectionShowAvgUsageDataBBBBBBBB']/div/table//tr["+i+"]//th"));

				for(int n=0;n<dealDataNodes.size();n++) {

					String data=dealDataNodes.get(n).getText();

					if(data.equalsIgnoreCase(validateValue)) {

						return true;

					}

				}

			}else {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("//div[@param_name='EXPANDEDSubSectionShowAvgUsageDataBBBBBBBB']/div/table//tr["+i+"]//td"));

				for(int n=0;n<dealDataNodes.size();n++) {

					String data=dealDataNodes.get(n).getText();

					if(data.equalsIgnoreCase(validateValue)) {

						return true;

					}

				}

			}



		}

		return false;

	}



	/*

	 * Below function will validate the Detailed Average Usage table data

	 * @param

	 * @author Akarshit Srivastava

	 *@throws IOException

	 * @since 07-July-2020

	 */

	public static void validateDetailedAverageUsagePopUp(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			Thread.sleep(2000);

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(2000);

			genericKeywords.locateElement("smeProfilePanelUsageChargable3mLink_xpath",loginPage.driver).sendKeys(Keys.ENTER);

			Thread.sleep(3000);

			if(genericKeywords.locateElement("smeDetailAverageUsageHeader_xpath",loginPage.driver).isDisplayed() ) {

				System.out.println("Detailed average usage present");

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Detailed Average Usage popup displayed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Detailed Average Usage popup displayed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Detailed Average Usage popup displayed"+reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Detailed Average Usage popup displayed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}

			}

		}catch(Exception e) {

			e.printStackTrace();

			reportDirectory.test.log(LogStatus.FAIL, "Detailed Average Usage popup is not displayed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Detailed Average Usage popup is not displayed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			//e.printStackTrace();

		}

	}

	/*

	 * Below function will click on CTN number after validating number of CTN.

	 * @param String

	 * @author Akarshit Srivastava

	 *@throws IOException

	 *@since 22-March-2021

	 */

	public static void clickOnNumberOfCtn(LinkedHashMap<String, String> profilePannelCustomerDetails) {

		try {

			int noOfCtn=Integer.parseInt(profilePannelCustomerDetails.get("No of CTN"));

			if(noOfCtn>1) {

				System.out.println("Number of subscription associated with account is ="+noOfCtn);

				reportDirectory.test.log(LogStatus.PASS, "Number of subscription associated with account is ="+noOfCtn);

				reportDirectory.test_consolidated.log(LogStatus.PASS,"Number of subscription associated with account is ="+noOfCtn);

				Thread.sleep(2000);

				loginPage.driver.switchTo().defaultContent();

				Thread.sleep(5000);

				genericKeywords.locateElement("smeNoOfCtnLink_xpath", loginPage.driver).sendKeys(Keys.ENTER);

				//genericKeywords.locateElement("smeCtnLink_xpath", loginPage.driver).click();

				//Thread.sleep(5000);  

			}else {

				System.out.println("Only single subscription associated with account");

				reportDirectory.test.log(LogStatus.FAIL, "Only single subscription associated with account.");

				reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Only single subscription associated with account.");

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,"Unable to verify the number of subscription.");

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Unable to verify the number of subscription.");

			e.printStackTrace();



		}

	}



	/*

	 * Below function will click on Direct number.

	 * @param String

	 * @author Akarshit Srivastava

	 *@throws IOException

	 *@since 18-May-2021

	 */

	public static void clickOnDirectMatch() {

		try {

			boolean flag=false;

			//Save tools Tab//

			WebElement directMatch=genericKeywords.driver.findElement(By.xpath("//label[@class='chkbxCaptionRight']"));

			flag=genericKeywords.isElementPresent(directMatch)    ;

			if(flag)   {               

				directMatch.click();

				Thread.sleep(5000);

				reportDirectory.test.log(LogStatus.PASS, "Direct match is switch on");

				reportDirectory.test_consolidated.log(LogStatus.PASS,  "Direct match is switch on");

			}else {

				reportDirectory.test.log(LogStatus.FAIL,"Unable to switch the direct Match");

				reportDirectory.test_consolidated.log(LogStatus.FAIL,"Unable to switch the direct Match");

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,"Error in code");

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Error in code");

			e.printStackTrace();

		}

	}



	/*

	 * Below function will validate the Account Number from existing relationship table

	 * @param String

	 * @author Akarshit Srivastava

	 *@throws IOException

	 *@since 22-March-2021

	 */

	public static void validateAccountNumberFromExistingRelationshipTable(String expectedAccountNum,String screenshotsPath,boolean screenshotToBeCaptured) {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			genericKeywords.waitUntilElementIsDisplayed(10, genericKeywords.locateElement("smeExistingRelationWindowAccountNum_xpath", loginPage.driver));

			String actualAccountNum=genericKeywords.locateElement("smeExistingRelationWindowAccountNum_xpath", loginPage.driver).getText();

			System.out.println("actualAccountNum="+actualAccountNum);

			if(actualAccountNum.equals(expectedAccountNum)) {

				Thread.sleep(5000);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Account Number in Existing relation window is matched"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Account Number in Existing relation window is matched"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Account Number in Existing relation window is matched");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Account Number in Existing relation window is matched");

				}

			}                          

			else {

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.FAIL, "Account Number in Existing relation window is mismatched"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account Number in Existing relation window is mismatched"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.FAIL, "Account Number in Existing relation window is mismatched");

					reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account Number in Existing relation window is mismatched");

				}

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Account Number is not fetched");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account Number is not fetched");

		}

	}            



	/*

	 * Below function will validate the Account Number from existing relationship table

	 * @param String

	 * @author Akarshit Srivastava

	 *@throws IOException

	 *@since 22-March-2021

	 */

	public static void clickCtnNumberFromExistingRelationshipTable(String ctnToAdd,String screenshotsPath,boolean screenshotToBeCaptured) {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		try {

			List<WebElement> ctnListUi=loginPage.driver.findElements(By.xpath("(.//table[@id='bodyTbl_right'])[2]//tr//td[1]"));

			for(int i=2;i<ctnListUi.size();i++) {

				WebElement wbCtnUi= loginPage.driver.findElement(By.xpath("((.//table[@id='bodyTbl_right'])[2]//tr["+i+"]//td[1]//div[@class='field-item dataValueRead']/span)[1]"));          

				String ctnUi=wbCtnUi.getText();

				System.out.println("ctnUi="+ctnUi);

				if(ctnUi.equals(ctnToAdd)) {

					//loginPage.driver.findElement(By.xpath("((.//table[@id='bodyTbl_right'])[2]//tr["+i+"]//td[1]//div/input[@class='checkbox chkBxCtl'])[1]")).click();               

					WebElement ctnCheckbox=loginPage.driver.findElement(By.xpath("(//input[@id='IsTCVSubscriptionSelected"+i+"'])[1]"));

					genericKeywords.jsClick(ctnCheckbox);

					Thread.sleep(2000);

					WebElement ctnLink=loginPage.driver.findElement(By.xpath("(//a[contains(@name,'SBAccountsList("+i+")')])[1]"));

					//Thread.sleep(5000);

					genericKeywords.waitUntilElementIsClickable(3,ctnLink);

					genericKeywords.jsClick(ctnLink);

					Thread.sleep(10000);

				}

			}



		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Account Number is not fetched");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account Number is not fetched");

		}

	}



	/*

	 * Below function will capture all the data of Basket in a map based on the deal number

	 * @param int dealNum

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @author  Akarshit Srivastava

	 * @since   12-May-2021

	 */

	public static LinkedHashMap<String,ArrayList<String>> smecaptureBasketDataInMap(int dealNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>> mapBasketData=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList<String> listBasketPage ;

		String key=null;



		try {                                   

			Thread.sleep(2000);

			if(dealNum==1)

				genericKeywords.locateElement("smeBasketPageDeal1ExpandBtn_xpath", loginPage.driver).click();

			else

				genericKeywords.locateElement("smeBasksketPageDeal2ExpandBtn_xpath", loginPage.driver).click();             

			//System.out.println("Number of deals in the basket=  "+noOfDealsInBasket);

			//System.out.println("Deal Header :/n"+deal1Header); 

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[2]//tr[contains(@id,'$PWorkPage$pCart$pSBBasketList$l"+dealNum+"$pItems')]"));

			for(int i=2;i<dealDataRows.size();i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[2]//tr[contains(@id,'$PWorkPage$pCart$pSBBasketList$l"+dealNum+"$pItems')]/td["+i+"]"));

				listBasketPage=new ArrayList<String>();

				for(int n=0;n<dealDataNodes.size();n++) {

					String description=dealDataNodes.get(n).getText();

					//System.out.println("description"+description);

					if(n==0) {

						key=description;

					}else {

						listBasketPage.add(description);   

					}

				}

				mapBasketData.put(key,listBasketPage);

			}

			System.out.println("basketPageDataMap ="+mapBasketData);

			Thread.sleep(5000);

			//              genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapBasketData  :"+mapBasketData);

		return mapBasketData;

	}



	/*

	 * Below function will capture Upfront Cost and Mrc for Deal1 from Basket in a map and return the map.Call this function before expanding deal2 other wise it will not work

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   12-May-2021

	 */  

	public static LinkedHashMap<String,String> smeMapBasketPageDeal1UfMrc(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> deal1BasketPageUfMrc=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("smeBasketPageDeal1UpfrontCost", loginPage.driver).getText();

			deal1BasketPageUfMrc.put("Deal 1 Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("smeBasketPageDeal1Mrc", loginPage.driver).getText();

			deal1BasketPageUfMrc.put("Deal 1 Total MRC",totalMrc);





			System.out.println("basketUfMrc ="+deal1BasketPageUfMrc);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return deal1BasketPageUfMrc;  

	}

	/*

	 * Below function will capture Upfront Cost and Mrc for Deal1 from Basket in a map and return the map.Call this function after expanding deal 2 other wise it will not work

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   12-May-2021

	 */  

	public static LinkedHashMap<String,String> smeMapBasketPageDeal2UfMrc(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> deal2BasketPageUfMrc=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("smeBasketPageDeal2UpfrontCost", loginPage.driver).getText();

			deal2BasketPageUfMrc.put("Deal 2 Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("deal2BasketPageUfMrc", loginPage.driver).getText();

			deal2BasketPageUfMrc.put("Deal 2 Total MRC",totalMrc);



			System.out.println("Deal 2 basketUfMrc ="+deal2BasketPageUfMrc);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return deal2BasketPageUfMrc;  

	}



	/*

	 * Below function will capture  End Revenue ,Upfront Cost, Mrc and Budget from Basket in a map and return the map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   12-May-2021

	 */  

	public static LinkedHashMap<String,String> mapBasketPageUfMrcEndRevenueFooter(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue,maxBudget,budgetUsed;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("smeBasketPageUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("smeBasketPageMrc_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			endRevenue=genericKeywords.locateElement("smeBasketPageEndRevenue_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("End Revenue",endRevenue);

			maxBudget=genericKeywords.locateElement("smeBasketPageMaxBudget_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Max Budget",maxBudget);

			budgetUsed=genericKeywords.locateElement("smeBasketPageBudgetUsed_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("BudgetUsed",budgetUsed);



			System.out.println("basketUfMrcEndRevenue ="+basketPageUfMrcEndRevenue);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page total upfrontCost,mrc,EndRevneue,Max Budget and Budget operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page total upfrontCost,mrc,EndRevneue,Max Budget and Budget operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page total upfrontCost,mrc,EndRevneue,Max Budget and Budget operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page total upfrontCost,mrc,EndRevneue,Max Budget and Budget operation Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {



			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return basketPageUfMrcEndRevenue;  

	}



	/*

	 * Below function captures Basket Summery Page Header Details for deal 1

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return void

	 * @author Akarshit

	 * @throws InterruptedException

	 * @throws IOException

	 * @since 13-May-2021

	 */

	public static LinkedHashMap<String, ArrayList<String>> smeDeal1captureBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		ArrayList<String> list;    

		LinkedHashMap<String, ArrayList<String>> smeDeal1basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

		Thread.sleep(2000);

		try {

			loginPage.driver.switchTo().frame("PegaGadget2Ifr");

			Thread.sleep(2000);

			String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(outcome);

			smeDeal1basketSummeryPageHeaderData.put("Outcome", list);



			String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(ctn);

			smeDeal1basketSummeryPageHeaderData.put("CTN", list);



			String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[4]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(accountNumber);

			smeDeal1basketSummeryPageHeaderData.put("Account number", list);



			String endRevenue=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[2]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(endRevenue);

			smeDeal1basketSummeryPageHeaderData.put("End Revenue", list);

			System.out.println("Basket summery page header: "+smeDeal1basketSummeryPageHeaderData);  

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

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return smeDeal1basketSummeryPageHeaderData;

	}

	/*

	 * Below function captures Basket Summery Page Header Details for deal 2

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return void

	 * @author Akarshit Srivastava

	 * @throws InterruptedException

	 * @throws IOException

	 * @since 13-May-2021

	 */

	public static LinkedHashMap<String, ArrayList<String>> smeDeal2captureBasketSummeryPageHeader(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		ArrayList<String> list;    

		LinkedHashMap<String, ArrayList<String>> smeDeal2basketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

		Thread.sleep(2000);

		try {

			loginPage.driver.switchTo().frame("PegaGadget2Ifr");

			Thread.sleep(2000);

			String outcome=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[1]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(outcome);

			smeDeal2basketSummeryPageHeaderData.put("Outcome", list);



			String ctn=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[3]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(ctn);

			smeDeal2basketSummeryPageHeaderData.put("CTN", list);



			String accountNumber=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[4]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(accountNumber);

			smeDeal2basketSummeryPageHeaderData.put("Account number", list);



			String endRevenue=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content   layout-content-inline_middle content-inline_middle '])[2]/div[2]")).getText();

			list=new ArrayList<String>();

			list.add(endRevenue);

			smeDeal2basketSummeryPageHeaderData.put("End Revenue", list);

			System.out.println("Basket summery page header: "+smeDeal2basketSummeryPageHeaderData);  

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

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Header Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return smeDeal2basketSummeryPageHeaderData;

	}



	/*

	 * Below function captures Basket Summary Page Details based on deal number

	 * It accepts no parameters

	 * @param int dealNum

	 * @param

	 * @return void

	 * @author Akarshit Srivastava

	 * @throws InterruptedException

	 * @throws IOException

	 * @since 13-May-2021

	 */

	public static LinkedHashMap<String, ArrayList<String>> smeCaptureBasketSummeryPageDescription(int dealNum,String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String key = null;

		ArrayList<String> list;                   

		LinkedHashMap<String, ArrayList<String>> basketSummeryPageDescriptionData=new LinkedHashMap<String, ArrayList<String>>();



		try {

			List<WebElement> totalRowsUnderDeal1=loginPage.driver.findElements(By.xpath("//table[@class='gridTable ']//tr[contains(@id,'$PpyWorkPage$pCart$pSBBasketList$l"+dealNum+"')]"));

			for(int i=2;i<=totalRowsUnderDeal1.size();i++) {

				List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable ']//tr[contains(@id,'$PpyWorkPage$pCart$pSBBasketList$l"+dealNum+"')])["+i+"]"));

				list=new ArrayList<String>();

				for(int j=1; j<=noOfColumns.size(); j++) {

					try {

						String description=loginPage.driver.findElement(By.xpath("(//table[@class='gridTable ']//tr[contains(@id,'$PpyWorkPage$pCart$pSBBasketList$l"+dealNum+"')])["+i+"]/td["+j+"]")).getText();

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

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page Description Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}



		return basketSummeryPageDescriptionData;     

	}            



	/*

	 * Below function captures Basket Summery Page footer Details

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return void

	 * @author Akarshit Srivastava

	 * @throws InterruptedException

	 * @throws IOException

	 * @since 13-May-2021

	 */

	public static LinkedHashMap<String, ArrayList<String>> smeTotalcaptureBasketSummeryPageFooter(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		ArrayList<String> list;    

		LinkedHashMap<String, ArrayList<String>> smeTotalbasketSummeryPageHeaderData=new LinkedHashMap<String, ArrayList<String>>();

		Thread.sleep(2000);

		try {

			//loginPage.driver.switchTo().frame("PegaGadget2Ifr");

			//Thread.sleep(2000);

			String BasketUpfrontCost=loginPage.driver.findElement(By.xpath("//p[@name='$PpyWorkPage$pBasketUpfrontCost']")).getText();

			list=new ArrayList<String>();

			list.add(BasketUpfrontCost);

			smeTotalbasketSummeryPageHeaderData.put("Basket Upfront Cost", list);



			String BasketEndRevenue=loginPage.driver.findElement(By.xpath("//p[@name='$PpyWorkPage$pBasketEndRevenue']")).getText();

			list=new ArrayList<String>();

			list.add(BasketEndRevenue);

			smeTotalbasketSummeryPageHeaderData.put("Basket End Revenue",list);



			String BasketBudgetUsed=loginPage.driver.findElement(By.xpath("(//span[contains(.,'%')])[2]")).getText();

			list=new ArrayList<String>();

			list.add(BasketBudgetUsed);

			smeTotalbasketSummeryPageHeaderData.put("Basket Budget Used", list);



			String BasketMRC=loginPage.driver.findElement(By.xpath("//p[@name='$PpyWorkPage$pBasketMRC']")).getText();

			list=new ArrayList<String>();

			list.add(BasketMRC);

			smeTotalbasketSummeryPageHeaderData.put("Basket MRC", list);

			System.out.println("Basket summery page header: "+smeTotalbasketSummeryPageHeaderData);   

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			Thread.sleep(3000);

			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[text()='Close'])[1]")));

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page Header Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page footer Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page footer Header Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Summery Page footer Header Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Summery Page footer Header Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Summery Page footer Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Summery Page footer Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return smeTotalbasketSummeryPageHeaderData;

	}



	/*

	 * Below function will select the one option from dropdown for SME costumers

	 * It takes two parameters

	 * @param WebElement element

	 * @param String selectDealOptionFromDropDown-(Accept,Decline and Under Consideration)

	 * @param String selectReasonNumber-give index in string form

	 * @author  Akarshit Srivastava

	 * @since   18-May-2021

	 */

	public static void smeTakeActionOnParticularDeal(String selectDealOptionFromDropDown,String selectReasonNumber,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		WebElement dropDown = null;

		WebElement dropDown1= null;

		try {

			Thread.sleep(2000);

			try {

				dropDown=genericKeywords.locateElement("smeBasketPageDealOptionDrpDown_xpath", loginPage.driver);

				dropDown.click();

			}catch (Exception e) {

				dropDown1=genericKeywords.locateElement("basketPageDealOptionDropDownManualRegrade_xpath", loginPage.driver);

				dropDown1.click();

			}



			//WebElement reasonDropDown=genericKeywords.locateElement("basketPageDealOptionReasonsDropDown_xpath", loginPage.driver);





			switch (selectDealOptionFromDropDown) {



			case "Accept":

				genericKeywords.selectFromDropdown(dropDown, "visibleText", selectDealOptionFromDropDown);

				break;

			case "Accept Add Line":

				WebElement dropDownAddLine=genericKeywords.locateElement("deal2BasketPageDealOptionDropDown_xpath", loginPage.driver);

				genericKeywords.selectFromDropdown(dropDownAddLine, "visibleText", "Accept");

				break;

			case "Under Consideration" :

				genericKeywords.selectFromDropdown(dropDown, "visibleText", selectDealOptionFromDropDown);

				Thread.sleep(8000);

				WebElement acceptReasonDropDown=genericKeywords.locateElement("basketPageUnderConsiderationReasonsDropDown_xpath", loginPage.driver);

				genericKeywords.waitUntilElementIsDisplayed(5, acceptReasonDropDown);

				acceptReasonDropDown.click();

				genericKeywords.selectFromDropdown(acceptReasonDropDown,"index", selectReasonNumber);

				break;



			case "Decline" :

				genericKeywords.selectFromDropdown(dropDown, "visibleText", selectDealOptionFromDropDown);

				Thread.sleep(8000);

				WebElement dreasonDropDown=genericKeywords.locateElement("basketPageDeclineReasonsDropDown_xpath", loginPage.driver);

				genericKeywords.waitUntilElementIsDisplayed(5, dreasonDropDown);

				Thread.sleep(5000);

				dreasonDropDown.click();

				genericKeywords.selectFromDropdown(dreasonDropDown,"index", selectReasonNumber);               

				break;



			case "AcceptRetrieve" :

				WebElement retrieveDropDown=genericKeywords.locateElement("basketPageRetriveDealOptionDropDown_xpath", loginPage.driver);

				retrieveDropDown.click();

				genericKeywords.selectFromDropdown(retrieveDropDown, "visibleText", "Accept");

				break;



			case "DeclineRetrieve" :

				WebElement retrieveDropDown1=genericKeywords.locateElement("basketPageRetriveDealOptionDropDown_xpath", loginPage.driver);

				retrieveDropDown1.click();

				genericKeywords.selectFromDropdown(retrieveDropDown1, "visibleText", "Decline");



			}

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

	}            



	/*

	 * Below function will select the one option from (Edit,Delete,Close,Submit)

	 * It takes two parameters

	 * @param WebElement element

	 * @param String selectAction-Edit,Delete,Close,Submit

	 * @author  Akarshit Srivastava

	 * @since   18-May-2021

	 */

	public static String smeTakeActionOnBasket(String selectAction, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String dateTime=null;

		Thread.sleep(2000);



		try {



			Thread.sleep(1000);

			if(!(selectAction.equalsIgnoreCase("Edit"))) {

				genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//button[text()='"+selectAction+"'])[4]")),loginPage.driver);

				loginPage.driver.findElement(By.xpath("(//button[text()='"+selectAction+"'])[4]")).sendKeys(Keys.ENTER);

				Thread.sleep(5000);

				dateTime =genericKeywords.captureCurrentSystemDateTime();

				System.out.println("dateOfActionOnDeal ="+dateTime);

				Thread.sleep(1000);

				genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed");



			}else{

				genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//button[text()='"+selectAction+"'])[2]")),loginPage.driver);

				loginPage.driver.findElement(By.xpath("(//button[text()='"+selectAction+"'])[2]")).sendKeys(Keys.ENTER);     

				dateTime =genericKeywords.captureCurrentSystemDateTime();

				//System.out.println("dateOfActionOnDeal ="+dateTime);

				//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

				pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

				if(screenshotToBeCaptured==true) {

					reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

				}else {

					reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed");

				}

				Thread.sleep(5000);



			}

		}catch(Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectAction+" inside basket Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectAction+" inside basket Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return dateTime;

	}



	/*

	 * Below function captures Interaction History data of first row

	 * It accepts no parameters

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @throws IOException

	 * @throws InterruptedException

	 * @since 18-May-2021

	 */

	public static LinkedHashMap<String,String> smeCheckLastestTransInIntreactionHistoy(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException  {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		LinkedHashMap<String, String> interactionHistoryLatestUpdatedMap=new LinkedHashMap<String,String>();

		Thread.sleep(8000);

		try {

			genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).sendKeys(Keys.ENTER);        

			Thread.sleep(8000);

			//genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).click();

			List<WebElement> firstRowData=loginPage.driver.findElements(By.xpath("//table[@id='bodyTbl_right']//tr[2]//td"));

			for(int i=1;i<=firstRowData.size();i++) {

				String dealResponse=firstRowData.get(i+9).getText();

				interactionHistoryLatestUpdatedMap.put("Date", firstRowData.get(i).getText());

				interactionHistoryLatestUpdatedMap.put("CTN", firstRowData.get(i+1).getText());

				interactionHistoryLatestUpdatedMap.put("Accont", firstRowData.get(i+2).getText());

				interactionHistoryLatestUpdatedMap.put("Contact method", firstRowData.get(i+3).getText());

				interactionHistoryLatestUpdatedMap.put("Contact description", firstRowData.get(i+4).getText());

				interactionHistoryLatestUpdatedMap.put("Offer", firstRowData.get(i+5).getText());

				interactionHistoryLatestUpdatedMap.put("Type", firstRowData.get(i+6).getText());

				interactionHistoryLatestUpdatedMap.put("Received campaign", firstRowData.get(i+7).getText());

				interactionHistoryLatestUpdatedMap.put("Response", firstRowData.get(i+9).getText());

				interactionHistoryLatestUpdatedMap.put("Agent Id", firstRowData.get(i+10).getText());

				interactionHistoryLatestUpdatedMap.put("Action", firstRowData.get(i+11).getText());



				if((firstRowData.get(i+9).getText()).equalsIgnoreCase("Under Consideration")){

					loginPage.driver.findElement(By.xpath("//a[contains(@name,'RetrieveButton')]")).sendKeys(Keys.ENTER);

				}

				Thread.sleep(6000);

				break;

			}

			System.out.println("intractionHistoryLatestRow: "+interactionHistoryLatestUpdatedMap);

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Lastest data capturing operation in interaction History Latest Row Passed");

			//              reportDirectory.test_consolidated.log(LogStatus.PASS, "Lastest data capturing operation in interaction History Latest Row Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Lastest data capturing operation in interaction History Latest Row Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Lastest data capturing operation in interaction History Latest Row Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Lastest data capturing operation in interaction History Latest Row PassedCTN search Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Lastest data capturing operation in interaction History Latest Row Passed");

			}

			Thread.sleep(5000);



		}catch (Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Lastest data capturing operation in interaction History Latest Row Passed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Lastest data capturing operation in interaction History Latest Row Passed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Lastest data capturing operation in interaction History Latest Row Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Lastest data capturing operation in interaction History Latest Row Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return interactionHistoryLatestUpdatedMap;

	}



	/*

	 * Below function captures Interaction History data of Deal row

	 * It accepts no parameters

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @throws IOException

	 * @throws InterruptedException

	 * @since 18-May-2021

	 */

	public static LinkedHashMap<String,String> smeIntreactionHistoyDealRowData(int dealNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException  {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		LinkedHashMap<String, String> interactionHistoryLatestUpdatedMap=new LinkedHashMap<String,String>();

		Thread.sleep(8000);

		try {

			genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).sendKeys(Keys.ENTER);        

			Thread.sleep(8000);

			//genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).click();

			List<WebElement> firstRowData=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr[contains(@id,'MultiSubDealHistory$l"+dealNum+"')]/td"));

			for(int i=2;i<=firstRowData.size();i++) {

				//String dealResponse=firstRowData.get(i+9).getText();

				interactionHistoryLatestUpdatedMap.put("Deal#", firstRowData.get(i).getText());

				interactionHistoryLatestUpdatedMap.put("CTN", firstRowData.get(i+1).getText());

				interactionHistoryLatestUpdatedMap.put("Offer", firstRowData.get(i+3).getText());

				interactionHistoryLatestUpdatedMap.put("JourneyType", firstRowData.get(i+4).getText());



				Thread.sleep(2000);

				loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr[contains(@id,'MultiSubDealHistory$l"+dealNum+"')]/td/span")).sendKeys(Keys.ENTER);

				break;

			}

			System.out.println("intractionHistoryLatestRow: "+interactionHistoryLatestUpdatedMap);

			Thread.sleep(5000);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Deal row data captured"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Deal1 row data"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Deal row data captured");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Deal1 row data");

			}

			Thread.sleep(5000);

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Deal row Not captured"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Deal row Not captured"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return interactionHistoryLatestUpdatedMap;

	}            



	/*

	 * Below function captures Interaction History Deal data based on deal number.

	 * It accepts 1 parameters

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 18-May-2020

	 */

	public static LinkedHashMap<String,ArrayList<String>> captureDataFromInteractionHistoryDeal(int dealNum,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>>  mapInteractionHistory=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listInteractionHistory;

		String key=null;



		try {

			Thread.sleep(3000);

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[contains(@pl_prop_class,'-Offer')])["+dealNum+"]//tr"));

			//System.out.println("dealDataRows.size() "+dealDataRows.size());

			for(int i=2;i<=dealDataRows.size();i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[contains(@pl_prop_class,'-Offer')])["+dealNum+"]//tr["+i+"]/td"));

				//System.out.println("dealDataNodes.size() "+dealDataNodes.size());

				listInteractionHistory=new ArrayList <String>();

				for(int n=0;n<dealDataNodes.size();n++) {

					String description=dealDataNodes.get(n).getText();

					//System.out.println("description"+description);

					if(n==0) {

						key=description;

					}else {

						listInteractionHistory.add(description); 

					}

				}

				mapInteractionHistory.put(key,listInteractionHistory);

			}

			System.out.println("intractHistExpandData: "+mapInteractionHistory);

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");



			}

			Thread.sleep(5000);





		}catch(Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapInteractionHistory  :"+mapInteractionHistory);

		return mapInteractionHistory;

	}



	/*

	 * Below function captures Interaction History data of Total Upfront cost,Total MRC and End revenue

	 * It accepts no parameters

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 18-May-2021

	 */

	public static LinkedHashMap<String,String> mapInteractionHistoryFooter(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue,maxBudget,budgetUsed;

		LinkedHashMap<String,String>  mapInteractionHistory=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			maxBudget=genericKeywords.locateElement("smeInteractionHistoryMaxBudget_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Max Budget", maxBudget);

			budgetUsed=genericKeywords.locateElement("smeInteractionHistoryBudgetUsed_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Budget Used", budgetUsed);

			endRevenue=genericKeywords.locateElement("smeInteractionHistoryEndRevenue_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("End Revenue",endRevenue );

			totalUpfrontCost=genericKeywords.locateElement("smeInteractionHistoryUpfront_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total Upfront Cost", totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("smeInteractionHistoryMrc_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total MRC", totalMrc);





			System.out.println("intractHistUfMrcEndRevenue ="+mapInteractionHistory);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history footer Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history footer Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history footer Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history footer Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history footer Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history footer Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return mapInteractionHistory;

	}            



	public static void smeValidateDealBuildeWithBasketPage(LinkedHashMap<String,ArrayList<String>> dealBuilderData,LinkedHashMap<String, ArrayList<String>> basketPageData) {



		dealBuilderData.remove("Add to plan 1");

		basketPageData.remove("Add to plan 1");



		try {

			if(dealBuilderData.equals(basketPageData)) {;

			System.out.println("Basket Page data is same as Deal builder Data data");

			reportDirectory.test.log(LogStatus.PASS, "Basket Page data is same as Deal builder Data data");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Basket Page data is same as Deal builder Data data");

			}else {

				System.out.println("Basket Page data is mismatching with Deal builder data");

				reportDirectory.test.log(LogStatus.FAIL, "Basket Page data is mismatching with Deal builder data");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Basket Page data is mismatching with Deal builder data");

			}

		}catch(Exception e) {

			System.out.println("Basket Page data is mismatching with Deal builder data");

			reportDirectory.test.log(LogStatus.FAIL, "Basket Page data is mismatching with Deal builder data");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Basket Page data is mismatching with Deal builder data");

		}

	}



	/*

	 * Below function captures validate the Interaction History data of first row with data captured in Basket Summary

	 * It accepts 2 parameters

	 * @param  LinkedHashMap<String,String> intractionHistoryLatestRow

	 * @param  LinkedHashMap<String, ArrayList<String>> basketSummHeader

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 * @throws IOException

	 * @since 20-May-2021

	 */

	public static void smeValidationInteractionHistoryLatestRowWithBasketSummary(LinkedHashMap<String,String> intractionHistoryLatestRow,LinkedHashMap<String, ArrayList<String>> basketSummHeader,String dateOfActionOnDeal) {

		try {

			System.out.println(intractionHistoryLatestRow);

			System.out.println(basketSummHeader);

			String validateCustomerIdIntrHist=intractionHistoryLatestRow.get("CTN");

			String validateCustomerIdBaskSum=basketSummHeader.get("CTN").get(0);



			System.out.println("validateCtnIntrHist= "+validateCustomerIdIntrHist);

			System.out.println("validateCtnBaskSum= "+validateCustomerIdBaskSum);



			String validateResponseIntrHist=intractionHistoryLatestRow.get("Response");

			String validateOutcomeBaskSum=basketSummHeader.get("Outcome").get(0)+"ed";

			System.out.println("validateResponseIntrHist= "+validateResponseIntrHist);

			System.out.println("validateOutcomeBaskSum= "+validateOutcomeBaskSum);



			String validateDateIntrHist=intractionHistoryLatestRow.get("Date");

			//String validateDateBaskSum=basketSummHeader.get("Date").get(0);

			System.out.println("validateDateIntrHist= "+validateDateIntrHist);

			//System.out.println("validateDateBaskSum= "+validateDateBaskSum);



			/*String validateAccountNumIntrHist=intractionHistoryLatestRow.get("Accont");

                                           String validateAccountNumBaskSum=basketSummHeader.get("Account number").get(0);

                                           System.out.println("validateAccountNumIntrHist= "+validateAccountNumIntrHist);

                                           System.out.println("validateAccountNumBaskSum= "+validateAccountNumBaskSum);*/

			try {

				if(validateCustomerIdIntrHist.equalsIgnoreCase(validateCustomerIdBaskSum))

					System.out.println("CTN Validation successfully Expected="+validateCustomerIdIntrHist+" Actual "+validateCustomerIdBaskSum);

				reportDirectory.test.log(LogStatus.PASS, "CTN Validation successfully");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN Validation successfully");

			}catch (Exception e) {

				System.out.println("CTN Validation failed Expected="+validateCustomerIdIntrHist+" Actual "+validateCustomerIdBaskSum);             

				reportDirectory.test.log(LogStatus.FAIL, "CTN Validation successfully");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "CTN Validation successfully");

			}



			try {      



				if(validateResponseIntrHist.equalsIgnoreCase(validateOutcomeBaskSum)) {

					System.out.println("Response Validation successfully Expected="+validateResponseIntrHist+"  Actual "+validateOutcomeBaskSum);

					reportDirectory.test.log(LogStatus.PASS, "Response Validation successfully");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Response Validation successfully");

				}

			}catch (Exception e) {

				System.out.println("Response Validation failed Expected="+validateResponseIntrHist+" Actual "+validateOutcomeBaskSum);

				reportDirectory.test.log(LogStatus.FAIL, "Response Validation failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Response Validation failed");

			}

			try {                                     

				if(validateDateIntrHist.equalsIgnoreCase(dateOfActionOnDeal))

					System.out.println("Date Validation Passed Expected="+validateDateIntrHist+"  Actual "+dateOfActionOnDeal);

				else 

				{//System.out.println("Response Validation failed Expected="+validateDateIntrHist+"/n Actual "+dateOfActionOnDeal);

					genericKeywords.timeValidation(dateOfActionOnDeal,validateDateIntrHist);

				}

				reportDirectory.test.log(LogStatus.PASS, "Date Validation successfully");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Date Validation successfully");

			}catch (Exception e) {

				reportDirectory.test.log(LogStatus.FAIL, "Date Validation failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Date Validation failed");

			}

			/*try {

                                           if(validateAccountNumIntrHist.equalsIgnoreCase(validateAccountNumBaskSum)) {

                                                                        System.out.println("Account number Validation Passed Expected="+validateAccountNumIntrHist+"/n Actual "+validateAccountNumBaskSum);

                                                                        reportDirectory.test.log(LogStatus.PASS, "Account number Validation successfully");

                                                                        reportDirectory.test_consolidated.log(LogStatus.PASS, "Account number Validation successfully");

                                                          }

                                           }catch (Exception e) {

                                                          System.out.println("Account number Validation failed Expected="+validateAccountNumIntrHist+"/n Actual "+validateAccountNumBaskSum);

                                                          reportDirectory.test.log(LogStatus.FAIL, "Account number Validation failed");

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account number Validation failed");

                                           } */

		}catch (Exception e) {

			e.printStackTrace();

		}

	}



	public static void smeValidateIntractHistExpandDataWithBasketSummary(LinkedHashMap<String,ArrayList<String>> intractHistExpandData,LinkedHashMap<String, ArrayList<String>> basketSummeryPageDescription) {



		intractHistExpandData.remove("Add to plan 1");

		basketSummeryPageDescription.remove("Add to plan 1");



		try {

			if(intractHistExpandData.equals(basketSummeryPageDescription)) {;

			System.out.println("Basket Page data is same as Interaction History data");

			reportDirectory.test.log(LogStatus.PASS, "Basket Page data is same as Interaction History data");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Basket Page data is same as Interaction History data");

			}else {

				System.out.println("Basket Page data is different from Interaction History data");

				reportDirectory.test.log(LogStatus.FAIL, "Basket Page data is different from Interaction History data");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Basket Page data is different from Interaction History data");



			}

		}catch(Exception e) {

			System.out.println("Basket Page data is different from Interaction History data");

			reportDirectory.test.log(LogStatus.FAIL, "Basket Page data is different from Interaction History data");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Basket Page data is different from Interaction History data");

		}

	}



	public static void smeValidateIntratcHistFooterBasketPage(LinkedHashMap<String,String> basketUfMrcEndRevenu, LinkedHashMap<String,String> intractHistUfMrcEndRevenue) {



		try {

			if(basketUfMrcEndRevenu.equals(intractHistUfMrcEndRevenue)) {

				System.out.println("Footer:Total upfroncost,Total MRC and End Revenue are same in Basket and Interaction History");

				reportDirectory.test.log(LogStatus.PASS, "Footer:Total upfroncost,Total MRC and End Revenue are same in Basket and Interaction History");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Footer:Total upfroncost,Total MRC and End Revenue are same in Basket and Interaction History");

			}

		}catch (Exception e) {

			System.out.println("Footer:Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			reportDirectory.test.log(LogStatus.FAIL, "Footer:Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Footer:Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			e.printStackTrace();

		}

	}            



}