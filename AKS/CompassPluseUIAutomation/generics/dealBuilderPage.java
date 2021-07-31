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



public class dealBuilderPage extends genericKeywords {



	public static void jsClickOnSomewhere() throws InterruptedException {

		genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//img[@src='webwb/aquabasket_13045256237.png!!.png']")));

		Thread.sleep(5000);

	}



	public static void jsClickOnCloseButton() throws InterruptedException {

		genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//button[text()='Close']")));

		Thread.sleep(2000);

	}



	public static void jsClickOnAddToBasketButton() throws InterruptedException {

		genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[contains(.,'Add to basket')])[1]")));

	}



	public static void jsClickOnYellowBasketImage() throws InterruptedException {

		loginPage.driver.findElement(By.xpath("//img[@src='webwb/yellowbasket_1192536200.png!!.png']")).sendKeys(Keys.ENTER);

		//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//img[@src='webwb/yellowbasket_1192536200.png!!.png']")));

	}



	/**

	 * Below function captures creates directory

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return void

	 * @author Devi Das

	 * @throws IOException

	 * @since 19-May-2020

	 */



	public static LinkedHashMap<String, ArrayList<String>> captureDealBuilderData(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String key = null;

		ArrayList<String> list;

		LinkedHashMap<String, ArrayList<String>> dealBuilderData=new LinkedHashMap<String, ArrayList<String>>();

		try {

			Thread.sleep(5000);

			//List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr"));

			List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])//tr"));

			//List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("//table[@id='bodyTbl_right']//tr"));

			for(int i=2;i<=totalRowsUnderDealBuilderTable.size();i++) {

				List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])//tr["+i+"]/td"));

				//List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("//table[@id='bodyTbl_right']//tr["+i+"]/td"));

				list=new ArrayList<String>();

				for(int j=1; j<noOfColumns.size(); j++) {

					try {

						genericKeywords.waitUntilElementIsDisplayed(2, loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])//tr["+i+"]/td["+j+"]")));

						//Thread.sleep(5000);

						String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])//tr["+i+"]/td["+j+"]")).getText();

						//String dataUnderDealBuilder=noOfColumns.get(j).getText();

						if(j == 1) {

							key=dataUnderDealBuilder;

							if(key.contains("AKG"))

							{

								//genericKeywords.waitUntilElementIsDisplayed(2, noOfColumns.get(2));

								Thread.sleep(2000);

								noOfColumns.get(2).click();

								//String upfrontCost=loginPage.driver.findElement(By.xpath("(// div[@class='flex  content  set-width-auto  layout-content-grid_filter_panel content-grid_filter_panel '])[9]")).getText();

								String upfrontCost=noOfColumns.get(1).getText();

								list.add(upfrontCost);

								System.out.println("upfrontCost ="+upfrontCost);

								//Thread.sleep(2000);

								///noOfColumns.get(3).click();

								//Thread.sleep(2000);

								//genericKeywords.waitUntilElementIsDisplayed(2, noOfColumns.get(3));

								//Issue in this line

								String mrc;

								try {

									mrc=loginPage.driver.findElement(By.xpath("(// div[@class='flex  content  set-width-auto  layout-content-grid_filter_panel content-grid_filter_panel  clearfix '])["+(i-1)+"]")).getText();                       

								}catch (Exception e) {

									mrc       =noOfColumns.get(2).getText();                                          

								}

								//String mrc=noOfColumns.get(3).getText();

								System.out.println("mrc ="+mrc);

								list.add(mrc);

								break;

							}

							if(key.contains("Add to plan 1"))

							{

								list.add("£0.00");

								list.add("£0.00");

								break;

							}



						}else {

							list.add(dataUnderDealBuilder);

						}

					}catch(Exception e) {

						e.printStackTrace();

					}

				}

				dealBuilderData.put(key, list);

			}

			System.out.println("dealBuilderData= "+dealBuilderData);

			//Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//           reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			}

			Thread.sleep(5000);



		}catch(Exception e) {



			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return dealBuilderData;

	}



	public static LinkedHashMap<String, ArrayList<String>> newCaptureDealBuilderData(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String key = null;

		ArrayList<String> list;

		LinkedHashMap<String, ArrayList<String>> dealBuilderData=new LinkedHashMap<String, ArrayList<String>>();

		try {

			Thread.sleep(5000);

			List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr"));

			//List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("//table[@id='bodyTbl_right']//tr"));

			for(int i=2;i<=totalRowsUnderDealBuilderTable.size();i++) {

				List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]//td"));

				list=new ArrayList<String>();

				for(int j=1; j<noOfColumns.size(); j++) {

					try {

						genericKeywords.waitUntilElementIsDisplayed(2, loginPage.driver.findElement(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]/td["+j+"]")));

						//Thread.sleep(5000);

						String dataUnderDealBuilder=loginPage.driver.findElement

								(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]/td["+j+"]")).getText();

						//String dataUnderDealBuilder=noOfColumns.get(j).getAttribute("textContent");

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

			System.out.println("dealBuilderData= "+dealBuilderData);

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//           reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			//              reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			}

			Thread.sleep(5000);



		}catch(Exception e) {



			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return dealBuilderData;

	}





	public static LinkedHashMap<String, ArrayList<String>> testCaptureDealBuilderData(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String key = null;

		ArrayList<String> list;

		LinkedHashMap<String, ArrayList<String>> dealBuilderData=new LinkedHashMap<String, ArrayList<String>>();

		try {

			Thread.sleep(5000);

			List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr"));

			for(int i=2;i<=totalRowsUnderDealBuilderTable.size();i++) {

				List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]//td"));

				list=new ArrayList<String>();

				if(i>8) {

					for(int j=1; j<noOfColumns.size(); j++) {

						//String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("(//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]//td["+j+"]//span/span[contains(.,'£')])[1]")).getText();

						if(j == 1) {

							key=loginPage.driver.findElement(By.xpath("(//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]//td["+j+"]")).getText();

						}else {

							String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("(//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]//td["+j+"]//span/span[contains(.,'£')])[1]")).getText();

							list.add(dataUnderDealBuilder);

						}

					}

				}

				for(int j=1; j<noOfColumns.size(); j++) {

					try {

						String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("//div[@class='yui-skin-sam gPXAuto grid-responsive-default  floated ']/div/table//tr["+i+"]/td["+j+"]")).getText();

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

			System.out.println("dealBuilderData= "+dealBuilderData);

			Thread.sleep(5000);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			}

			Thread.sleep(5000);

		}catch(Exception e) {



			reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return dealBuilderData;

	}            



	public static LinkedHashMap<String, ArrayList<String>> indirectCaptureDealBuilderData(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String key = null;

		ArrayList<String> list;

		LinkedHashMap<String, ArrayList<String>> dealBuilderData=new LinkedHashMap<String, ArrayList<String>>();

		try {

			Thread.sleep(7000);

			List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[9]//tr"));

			for(int i=2;i<=totalRowsUnderDealBuilderTable.size();i++) {

				List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[9]//tr["+i+"]/td"));

				list=new ArrayList<String>();

				for(int j=1; j<noOfColumns.size(); j++) {

					try {

						//genericKeywords.waitUntilElementIsDisplayed(2, loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[9]//tr["+i+"]/td["+j+"]")));

						String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[9]//tr["+i+"]/td["+j+"]")).getText();

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

			System.out.println("dealBuilderData= "+dealBuilderData);

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			}

			Thread.sleep(5000);



		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return dealBuilderData;

	}

	public static LinkedHashMap<String, ArrayList<String>> vatCaptureDealBuilderData(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String key = null;

		ArrayList<String> list;

		LinkedHashMap<String, ArrayList<String>> dealBuilderData=new LinkedHashMap<String, ArrayList<String>>();

		try {

			Thread.sleep(7000);

			List<WebElement> totalRowsUnderDealBuilderTable=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[8]//tr"));

			for(int i=2;i<=totalRowsUnderDealBuilderTable.size();i++) {

				List<WebElement> noOfColumns=loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[8]//tr["+i+"]/td"));

				list=new ArrayList<String>();

				for(int j=1; j<noOfColumns.size(); j++) {

					try {

						//genericKeywords.waitUntilElementIsDisplayed(2, loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[9]//tr["+i+"]/td["+j+"]")));

						String dataUnderDealBuilder=loginPage.driver.findElement(By.xpath("(//table[@id='bodyTbl_right'])[8]//tr["+i+"]/td["+j+"]")).getText();

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

			System.out.println("dealBuilderData= "+dealBuilderData);

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Deal Builder Data Passed");

			}

			Thread.sleep(5000);



		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Deal Builder Data Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return dealBuilderData;

	}



	public static void jsClickOnAddToBasketButton(String screenshotsPath) throws InterruptedException, IOException {



		try {



			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[contains(.,'Add to basket')])[1]")));

			Thread.sleep(10000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Click Operation on Add To Basket btn Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation on Add To Basket btn Passed");



		}catch(Exception e) {



			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Click Operation on Add To Basket btn Failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation on Add To Basket btn Failed");

			e.printStackTrace();

		}

	}





	public static String jsClickOnSubmitButton(String screenshotsPath) throws InterruptedException, IOException {



		String dateTime=null;

		try {



			genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("(//button[contains(.,'Submit')])[2]")));

			dateTime =genericKeywords.captureCurrentSystemDateTime();

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Click Operation on Add To Basket btn Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Click Operation on Add To Basket btn Passed");



		}catch(Exception e) {



			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Click Operation on Add To Basket btn Failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click Operation on Add To Basket btn Failed");

			e.printStackTrace();

		}

		return dateTime;

	}

	public static void jsClickOnYellowBasketImage(String screenshotsPath) throws InterruptedException, IOException {

		try {

			loginPage.driver.switchTo().defaultContent();

			Thread.sleep(5000);

			WebElement basket=loginPage.driver.findElement(By.xpath("//img[@src='webwb/yellowbasket_1192536200.png!!.png']"));

			genericKeywords.waitUntilElementIsClickable(10, basket);

			//loginPage.driver.findElement(By.xpath("//img[@src='webwb/yellowbasket_1192536200.png!!.png']")).sendKeys(Keys.ENTER);

			//genericKeywords.jsClick(loginPage.driver.findElement(By.xpath("//img[@src='webwb/yellowbasket_1192536200.png!!.png']")));

			basket.sendKeys(Keys.ENTER);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Click operation on Yellow Basket Image inside Deal Builder Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Click operation on Yellow Basket Image inside Deal Builder Passed");



		}catch(Exception e) {



			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);



			reportDirectory.test.log(LogStatus.FAIL, "Click operation on Yellow Basket Image inside Deal Builder Failed");



			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Click operation on Yellow Basket Image inside Deal Builder Failed");



			e.printStackTrace();



		}



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

	 * @since 19-May-2020

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



			//System.out.println(dealBuilderData);



		}catch(Exception e) {

			e.printStackTrace();

		}



		return dealBuilderData;

	}



	/* Below function will capture  End Revenue ,Upfront Cost and Mrc from DealBuilder in a map and return the map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */  

	public static LinkedHashMap<String,String> mapDealBuilderUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> dealBuilderPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			//Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("dealBuilderPageTotalUpFrontCost", loginPage.driver).getText();

			dealBuilderPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("dealBuilderPageTotalMrc", loginPage.driver).getText();

			dealBuilderPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			endRevenue=genericKeywords.locateElement("dealBuilderPageTotalEndRevenue", loginPage.driver).getText();

			dealBuilderPageUfMrcEndRevenue.put("End Revenue",endRevenue);



			System.out.println("dealBuilderPageUfMrcEndRevenue ="+dealBuilderPageUfMrcEndRevenue);

			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Capturing DealBuilder Page data operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing DealBuilder Page data operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Capturing DealBuilder Page data operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing DealBuilder Page data operation Passed");

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

		return dealBuilderPageUfMrcEndRevenue;  

	}            



}