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



public class interactionHistoryPage {



	/**

	 * Below function captures Interaction Histroy data of first row

	 * It accepts no parameters

	 *

	 * @param

	 * @param

	 * @return LinkedHashMap<String,String>

	 *

	 * @author Akarshit Srivastava

	 * @return

	 * @throws IOException

	 * @throws InterruptedException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String,String> checkLastestTransInIntreactionHistoy(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException  {

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

				String dealResponse=firstRowData.get(i+8).getText();

				interactionHistoryLatestUpdatedMap.put("Date", firstRowData.get(i).getText());

				interactionHistoryLatestUpdatedMap.put("CTN", firstRowData.get(i+1).getText());

				interactionHistoryLatestUpdatedMap.put("Accont", firstRowData.get(i+2).getText());

				interactionHistoryLatestUpdatedMap.put("Contact method", firstRowData.get(i+3).getText());

				interactionHistoryLatestUpdatedMap.put("Contact description", firstRowData.get(i+4).getText());

				interactionHistoryLatestUpdatedMap.put("Offer", firstRowData.get(i+5).getText());

				interactionHistoryLatestUpdatedMap.put("Type", firstRowData.get(i+6).getText());

				interactionHistoryLatestUpdatedMap.put("Received campaign", firstRowData.get(i+7).getText());

				interactionHistoryLatestUpdatedMap.put("Response", firstRowData.get(i+8).getText());

				interactionHistoryLatestUpdatedMap.put("Agent Id", firstRowData.get(i+9).getText());

				interactionHistoryLatestUpdatedMap.put("Action", firstRowData.get(i+10).getText());



				if((firstRowData.get(i+8).getText()).equalsIgnoreCase("Under Consideration")){

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

	public static LinkedHashMap<String,String> checkAddLineLastestTransInIntreactionHistoy(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException  {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		LinkedHashMap<String, String> interactionHistoryLatestUpdatedMap=new LinkedHashMap<String,String>();

		Thread.sleep(6000);

		try {

			//genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).sendKeys(Keys.ENTER);        

			Thread.sleep(5000);

			//genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).click();

			List<WebElement> firstRowData=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right']//tr[4])[2]//td"));

			for(int i=1;i<=firstRowData.size();i++) {

				String dealResponse=firstRowData.get(i+8).getText();

				interactionHistoryLatestUpdatedMap.put("Date", firstRowData.get(i).getText());

				interactionHistoryLatestUpdatedMap.put("CTN", firstRowData.get(i+1).getText());

				interactionHistoryLatestUpdatedMap.put("Accont", firstRowData.get(i+2).getText());

				interactionHistoryLatestUpdatedMap.put("Contact method", firstRowData.get(i+3).getText());

				interactionHistoryLatestUpdatedMap.put("Contact description", firstRowData.get(i+4).getText());

				interactionHistoryLatestUpdatedMap.put("Offer", firstRowData.get(i+5).getText());

				interactionHistoryLatestUpdatedMap.put("Type", firstRowData.get(i+6).getText());

				interactionHistoryLatestUpdatedMap.put("Received campaign", firstRowData.get(i+7).getText());

				interactionHistoryLatestUpdatedMap.put("Response", firstRowData.get(i+8).getText());

				interactionHistoryLatestUpdatedMap.put("Agent Id", firstRowData.get(i+9).getText());

				interactionHistoryLatestUpdatedMap.put("Action", firstRowData.get(i+10).getText());



				if((firstRowData.get(i+8).getText()).equalsIgnoreCase("Under Consideration")){

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



	/**

	 * Below function captures Interaction Histroy data of first row

	 * It accepts no parameters

	 *

	 * @param

	 * @param

	 * @return LinkedHashMap<String,String>

	 *

	 * @author Akarshit Srivastava

	 * @return

	 * @throws IOException

	 * @throws InterruptedException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String,String> pegasusCheckLastestTransInIntreactionHistoy(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException  {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();



		LinkedHashMap<String, String> interactionHistoryLatestUpdatedMap=new LinkedHashMap<String,String>();

		Thread.sleep(6000);

		try {

			genericKeywords.locateElement("interactionHistoryPageCustomerIdClick_xpath", loginPage.driver).sendKeys(Keys.ENTER);        

			Thread.sleep(5000);

			//genericKeywords.locateElement("interactionHistoryPageCTNClick_xpath", loginPage.driver).click();

			List<WebElement> firstRowData=loginPage.driver.findElements(By.xpath("//table[@id='bodyTbl_right']//tr[2]//td"));

			for(int i=1;i<=firstRowData.size();i++) {

				//           String dealResponse=firstRowData.get(i+8).getText();

				interactionHistoryLatestUpdatedMap.put("Date", firstRowData.get(i).getText());

				interactionHistoryLatestUpdatedMap.put("Customer ID", firstRowData.get(i+1).getText());

				interactionHistoryLatestUpdatedMap.put("Contact method", firstRowData.get(i+2).getText());

				interactionHistoryLatestUpdatedMap.put("Contact description", firstRowData.get(i+3).getText());

				interactionHistoryLatestUpdatedMap.put("Response", firstRowData.get(i+4).getText());

				interactionHistoryLatestUpdatedMap.put("Agent Id", firstRowData.get(i+5).getText());

				interactionHistoryLatestUpdatedMap.put("Action", firstRowData.get(i+6).getText());



				if((firstRowData.get(i+4).getText()).equalsIgnoreCase("Under Consideration")){

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

	 * Below function captures Interaction History data of first row data after expanding the data

	 * It accepts no parameters

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String,ArrayList<String>> captureDataFromInteractionHistory(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>>  mapInteractionHistory=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listInteractionHistory;

		String key=null;



		try {

			Thread.sleep(6000);

			genericKeywords.locateElement("interactionHistoryPageLatestTransRowExpandBtn_xpath", loginPage.driver).click();

			Thread.sleep(8000);

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr"));

			//System.out.println("dealDataRows.size() "+dealDataRows.size());

			for(int i=2;i<=dealDataRows.size();i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]//td"));

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

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");



			}

			Thread.sleep(5000);





		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapInteractionHistory  :"+mapInteractionHistory);

		return mapInteractionHistory;

	}



	public static LinkedHashMap<String,ArrayList<String>> captureAddLineDataFromInteractionHistory(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>>  mapInteractionHistory=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listInteractionHistory;

		String key=null;



		try {

			Thread.sleep(6000);

			genericKeywords.locateElement("interactionHistoryPageLatestTransRowExpandBtn2_xpath", loginPage.driver).click();

			Thread.sleep(8000);

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr"));

			//System.out.println("dealDataRows.size() "+dealDataRows.size());

			for(int i=2;i<=dealDataRows.size();i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[3]//tr["+i+"]//td"));

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

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);



		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapInteractionHistory  :"+mapInteractionHistory);

		return mapInteractionHistory;

	}

	/**

	 * Below function captures Interaction History data of Total Upfront cost,Total MRC and End revenue

	 * It accepts no parameters

	 *

	 * @param

	 * @param

	 * @return LinkedHashMap<String,String>

	 *

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String,String> mapInteractionHistoryUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String>  mapInteractionHistory=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);      

			totalUpfrontCost=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalUpfrontCost_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total Upfront Cost", totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalMRC_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total MRC", totalMrc);

			endRevenue=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalEndRevenue_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("End Revenue",endRevenue );



			System.out.println("intractHistUfMrcEndRevenue ="+mapInteractionHistory);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return mapInteractionHistory;

	}

	public static LinkedHashMap<String,String> mapAddLine1InteractionHistoryUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String>  mapInteractionHistory=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);      

			totalUpfrontCost=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalUpfrontCostAddLine1_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total Upfront Cost", totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalMRCAddLine1_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total MRC", totalMrc);

			//endRevenue=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalEndRevenue_xpath", loginPage.driver).getText();

			//mapInteractionHistory.put("End Revenue",endRevenue );



			System.out.println("intractHistUfMrcEndRevenue ="+mapInteractionHistory);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return mapInteractionHistory;

	}



	public static LinkedHashMap<String,String> mapAddLine2InteractionHistoryUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String>  mapInteractionHistory=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);      

			totalUpfrontCost=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalUpfrontCostAddLine2_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total Upfront Cost", totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalMRCAddLine2_xpath", loginPage.driver).getText();

			mapInteractionHistory.put("Total MRC", totalMrc);

			//endRevenue=genericKeywords.locateElement("interactionHistoryPageLatestTransRowTotalEndRevenue_xpath", loginPage.driver).getText();

			//mapInteractionHistory.put("End Revenue",endRevenue );



			System.out.println("intractHistUfMrcEndRevenue ="+mapInteractionHistory);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return mapInteractionHistory;

	}





	/**

	 * Below function captures Interaction History data of Total Upfront cost,Total MRC and End revenue for Pegasus.

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 21-May-2020

	 */

	public static LinkedHashMap<String, ArrayList<String>> mapPegasusInteractionHistoryUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost=null,totalMrc=null,endRevenue=null;

		//LinkedHashMap<String,String>  mapInteractionHistory=new LinkedHashMap<String,String>();

		LinkedHashMap<String,ArrayList<String>>  mapInteractionHistory=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listInteractionHistory;

		String key=null;



		try {

			List<WebElement> row=loginPage.driver.findElements(By.xpath("//div[contains(@class,'flex  content   layout-content-inline content-inline  clearfix')]"));

			int temp=1;

			for(int i=9;i<=row.size();i++) {

				String fieldName=null;

				listInteractionHistory=new ArrayList <String>();

				List<WebElement> nodes=loginPage.driver.findElements(By.xpath("(//div[contains(@class,'flex  content   layout-content-inline content-inline  clearfix')])["+i+"]/div"));   

				for(int j=0;j<=nodes.size();j++) {

					if(j==nodes.size()) {

						for(int x=temp;x<=temp;x++) {

							totalUpfrontCost=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content  set-width-auto false layout-content-inline_middle content-inline_middle '])["+x+"]/div[3]/span")).getText();

							totalMrc=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content  set-width-auto false layout-content-inline_middle content-inline_middle '])["+x+"]/div[5]/span")).getText();

							listInteractionHistory.add(totalUpfrontCost);

							listInteractionHistory.add(totalMrc);

						}

						temp++;

						break;

					}

					fieldName=fieldName+" "+nodes.get(j).getText();

				}

				mapInteractionHistory.put(fieldName,listInteractionHistory);



			}

			System.out.println("pegasusIntractHistUfMrcEndRevenue= "+mapInteractionHistory);



			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return mapInteractionHistory;

	}

	public static LinkedHashMap<String, ArrayList<String>> mapHomeInteractionHistoryUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost=null,totalMrc=null,endRevenue=null;

		//LinkedHashMap<String,String>  mapInteractionHistory=new LinkedHashMap<String,String>();

		LinkedHashMap<String,ArrayList<String>>  mapInteractionHistory=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList <String> listInteractionHistory;

		String key=null;



		try {

			List<WebElement> row=loginPage.driver.findElements(By.xpath("//div[contains(@class,'flex  content   layout-content-inline content-inline  clearfix')]"));

			int temp=1;

			for(int i=5;i<=row.size();i++) {

				String fieldName=null;

				listInteractionHistory=new ArrayList <String>();

				List<WebElement> nodes=loginPage.driver.findElements(By.xpath("(//div[contains(@class,'flex  content   layout-content-inline content-inline  clearfix')])["+i+"]/div"));   

				for(int j=0;j<=nodes.size();j++) {

					if(j==nodes.size()) {

						for(int x=temp;x<=temp;x++) {

							totalUpfrontCost=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content  set-width-auto false layout-content-inline_middle content-inline_middle '])["+x+"]/div[3]/span")).getText();

							totalMrc=loginPage.driver.findElement(By.xpath("(//div[@class='flex  content  set-width-auto false layout-content-inline_middle content-inline_middle '])["+x+"]/div[5]/span")).getText();

							listInteractionHistory.add(totalUpfrontCost);

							listInteractionHistory.add(totalMrc);

						}

						temp++;

						break;

					}

					fieldName=fieldName+" "+nodes.get(j).getText();

				}

				mapInteractionHistory.put(fieldName,listInteractionHistory);



			}

			System.out.println("pegasusIntractHistUfMrcEndRevenue= "+mapInteractionHistory);



			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing data from interaction history Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing data from interaction history Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing data from interaction history Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return mapInteractionHistory;

	}



	/**

	 * Below function captures validate the Interaction History data of first row with data captured in Basket Summary

	 * It accepts 2 parameters

	 * @param  LinkedHashMap<String,String> intractionHistoryLatestRow

	 * @param  LinkedHashMap<String, ArrayList<String>> basketSummHeader

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 22-May-2020

	 */

	public static void validationInteractionHistoryRowWithBasketSummary(LinkedHashMap<String,String> intractionHistoryLatestRow,LinkedHashMap<String, ArrayList<String>> basketSummHeader,String dateOfActionOnDeal) {



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

	public static void validationHomeInteractionHistoryRowWithBasketSummary(LinkedHashMap<String,String> intractionHistoryLatestRow,LinkedHashMap<String, ArrayList<String>> basketSummHeader,String dateOfActionOnDeal) {



		try {

			System.out.println(intractionHistoryLatestRow);

			System.out.println(basketSummHeader);

			String validateCustomerIdIntrHist=intractionHistoryLatestRow.get("Customer ID");

			String validateCustomerIdBaskSum=basketSummHeader.get("Customer ID").get(0);



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



	/**

	 * Below function captures validate the Interaction History data of first row with data captured in Basket Summary

	 * It accepts 2 parameters

	 * @param  LinkedHashMap<String,String> intractionHistoryLatestRow

	 * @param  LinkedHashMap<String, ArrayList<String>> basketSummHeader

	 * @return LinkedHashMap<String,String>

	 * @author Akarshit Srivastava

	 * @return InterruptedException

	 *@throws IOException

	 * @since 22-May-2020

	 */

	public static void atpValidationInteractionHistoryRowWithBasketSummary(LinkedHashMap<String,String> intractionHistoryLatestRow,LinkedHashMap<String, ArrayList<String>> basketSummHeader,String dateOfActionOnDeal) {



		try {

			System.out.println(intractionHistoryLatestRow);

			System.out.println(basketSummHeader);

			String validateCtnIntrHist=intractionHistoryLatestRow.get("CTN");

			String validateCtnBaskSum=basketSummHeader.get("CTN").get(0);



			System.out.println("validateCtnIntrHist= "+validateCtnIntrHist);

			System.out.println("validateCtnBaskSum= "+validateCtnBaskSum);



			/*String validateResponseIntrHist=intractionHistoryLatestRow.get("Response");

                                           String validateOutcomeBaskSum=basketSummHeader.get("Outcome").get(0)+"ed";

                                           System.out.println("validateResponseIntrHist= "+validateResponseIntrHist);

                                           System.out.println("validateOutcomeBaskSum= "+validateOutcomeBaskSum);

			 */

			String validateDateIntrHist=intractionHistoryLatestRow.get("Date");

			//String validateDateBaskSum=basketSummHeader.get("Date").get(0);

			System.out.println("validateDateIntrHist= "+validateDateIntrHist);

			//System.out.println("validateDateBaskSum= "+validateDateBaskSum);



			String validateAccountNumIntrHist=intractionHistoryLatestRow.get("Accont");

			String validateAccountNumBaskSum=basketSummHeader.get("Account number").get(0);

			System.out.println("validateAccountNumIntrHist= "+validateAccountNumIntrHist);

			System.out.println("validateAccountNumBaskSum= "+validateAccountNumBaskSum);

			try {

				if(validateCtnIntrHist.equalsIgnoreCase(validateCtnBaskSum))

					System.out.println("CTN Validation successfully Expected="+validateCtnIntrHist+" Actual "+validateCtnBaskSum);

				reportDirectory.test.log(LogStatus.PASS, "CTN Validation successfully");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "CTN Validation successfully");

			}catch (Exception e) {

				System.out.println("CTN Validation failed Expected="+validateCtnIntrHist+" Actual "+validateCtnBaskSum);           

				reportDirectory.test.log(LogStatus.FAIL, "CTN Validation successfully");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "CTN Validation successfully");

			}



			/*try {  



                                              if(validateResponseIntrHist.equalsIgnoreCase(validateOutcomeBaskSum)) {

                                                                        System.out.println("Response Validation successfully Expected="+validateResponseIntrHist+"  Actual "+validateOutcomeBaskSum);

                                                                        reportDirectory.test.log(LogStatus.PASS, "Response Validation successfully");

                                                                        reportDirectory.test_consolidated.log(LogStatus.PASS, "Response Validation successfully");

                                                          }

                                           }catch (Exception e) {

                                                          System.out.println("Response Validation failed Expected="+validateResponseIntrHist+" Actual "+validateOutcomeBaskSum);

                                                          reportDirectory.test.log(LogStatus.FAIL, "Response Validation failed");

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Response Validation failed");

                                           }*/

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

			try {

				if(validateAccountNumIntrHist.equalsIgnoreCase(validateAccountNumBaskSum)) {

					System.out.println("Account number Validation Passed Expected="+validateAccountNumIntrHist+"/n Actual "+validateAccountNumBaskSum);

					reportDirectory.test.log(LogStatus.PASS, "Account number Validation successfully");

					reportDirectory.test_consolidated.log(LogStatus.PASS, "Account number Validation successfully");

				}

			}catch (Exception e) {

				System.out.println("Account number Validation failed Expected="+validateAccountNumIntrHist+"/n Actual "+validateAccountNumBaskSum);

				reportDirectory.test.log(LogStatus.FAIL, "Account number Validation failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Account number Validation failed");

			} 

		}catch (Exception e) {

			e.printStackTrace();

		}

	}



	public static void validateIntractHistExpandDataWithBasketSummary(LinkedHashMap<String,ArrayList<String>> intractHistExpandData,LinkedHashMap<String, ArrayList<String>> basketSummeryPageDescription) {



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



	public static void validateIntratcHistTotalBasketPage(LinkedHashMap<String,String> basketUfMrcEndRevenu, LinkedHashMap<String,String> intractHistUfMrcEndRevenue) {



		try {

			if(basketUfMrcEndRevenu.equals(intractHistUfMrcEndRevenue)) {

				System.out.println("Total upfroncost,Total MRC and End Revenue are same in Basket and Interaction History");

				reportDirectory.test.log(LogStatus.PASS, "Total upfroncost,Total MRC and End Revenue are same in Basket and Interaction History");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Total upfroncost,Total MRC and End Revenue are same in Basket and Interaction History");

			}

		}catch (Exception e) {

			System.out.println("Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			reportDirectory.test.log(LogStatus.FAIL, "Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			e.printStackTrace();

		}

	}



	public static void validatePegasusIntratcHistTotalBasketPage(LinkedHashMap<String,String> basketUfMrcEndRevenu, LinkedHashMap<String,ArrayList<String>> pegasusIntractHistUfMrcEndRevenue) {



		try {

			String totalIntractHistUf=pegasusIntractHistUfMrcEndRevenue.get(null+" Total inc discount Monthly cost for the duration of your offer 18 months").get(0);

			String totalIntractHistMrc=pegasusIntractHistUfMrcEndRevenue.get(null+" Total inc discount Monthly cost for the duration of your offer 18 months").get(1);

			String totalbasketUf=basketUfMrcEndRevenu.get("Total upfront cost");

			String totalbasketMrc=basketUfMrcEndRevenu.get("Total MRC");

			if(totalIntractHistUf.equals(totalbasketUf)) {

				System.out.println("Total upfrontcost is equal in Basket and Interaction History ,Total Upfront Cost="+totalIntractHistUf);

				reportDirectory.test.log(LogStatus.PASS, "Total upfrontcost is equal in Basket and Interaction History ,Total Upfront Cost="+totalIntractHistUf);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Total upfroncost is equal in Basket and Interaction History ,Total Upfront Cost="+totalIntractHistUf);

			}else {

				System.out.println("Total upfrontcost is different in Basket and Interaction History ,Total Upfront Cost Intraction History="+totalIntractHistUf+"Total Upfront Cost Basket="+totalbasketUf);

				reportDirectory.test.log(LogStatus.FAIL, "Total upfrontcost is different in Basket and Interaction History ,Total Upfront Cost Intraction History="+totalIntractHistUf+"Total Upfront Cost Basket="+totalbasketUf);

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Total upfrontcost is different in Basket and Interaction History ,Total Upfront Cost Intraction History="+totalIntractHistUf+"Total Upfront Cost Basket="+totalbasketUf);

			}

			if(totalIntractHistMrc.equals(totalbasketMrc)) {

				System.out.println("Total MRC is equal in Basket and Interaction History ,Total Upfront Cost="+totalIntractHistMrc);

				reportDirectory.test.log(LogStatus.PASS, "Total Total MRC is equal in Basket and Interaction History ,Total MRC="+totalIntractHistMrc);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Total upfroncost is equal in Basket and Interaction History ,Total MRC="+totalIntractHistUf);

			}else {

				System.out.println("Total MRC is different in Basket and Interaction History ,Total Upfront Cost Intraction History="+totalIntractHistUf+"Total MRC Basket="+totalbasketMrc);

				reportDirectory.test.log(LogStatus.FAIL, "Total MRC is different in Basket and Interaction History ,Total MRC Intraction History="+totalIntractHistMrc+"Total MRC Basket="+totalbasketMrc);

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Total MRC is different in Basket and Interaction History ,Total MRC Intraction History="+totalIntractHistMrc+"Total MRC Basket="+totalbasketMrc);

			}



		}catch (Exception e) {

			System.out.println("Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			reportDirectory.test.log(LogStatus.FAIL, "Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Total upfroncost,Total MRC and End Revenue are different  in Basket and Interaction History");

			e.printStackTrace();

		}

	}



	public static void validateDealBuilderTotalWithBasketPage(LinkedHashMap<String,String> basketUfMrcEndRevenu,LinkedHashMap<String,String> dealBuilderPageUfMrcEndRevenue) {



		try {

			if(basketUfMrcEndRevenu.equals(dealBuilderPageUfMrcEndRevenue)) {

				System.out.println("Total upfrontcost,Total MRC and End Revenue is same in basket page  and Deal builder" );

				reportDirectory.test.log(LogStatus.PASS, "Total upfrontcost,Total MRC and End Revenue is same in basket page  and Deal builder");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Total upfrontcost,Total MRC and End Revenue is same in basket page  and Deal builder");

			}else {

				System.out.println("Total upfrontcost,Total MRC and End Revenue in basket page is different from Deal builder");

				reportDirectory.test.log(LogStatus.FAIL, "Total upfrontcost,Total MRC and End Revenue in basket page is different from Deal builder");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Total upfrontcost,Total MRC and End Revenue in basket page is different from Deal builder");

			}



		}catch (Exception e) {

			System.out.println("Total upfrontcost,Total MRC and End Revenue in basket page is different from Deal builder");

			reportDirectory.test.log(LogStatus.FAIL, "Total upfrontcost,Total MRC and End Revenue in basket page is different from Deal builder");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Total upfrontcost,Total MRC and End Revenue in basket page is different from Deal builder");

			e.printStackTrace();

		}

	}



	public static void validateDealBuildeWithBasketPage(LinkedHashMap<String,ArrayList<String>> dealBuilderData,LinkedHashMap<String, ArrayList<String>> basketPageData) {



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

}