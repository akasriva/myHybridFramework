package generics;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.List;



import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;



import com.relevantcodes.extentreports.LogStatus;



import components.Generics;

import testSetup.reportDirectory;



public class basketPage {



	/*

	 * Below function will capture  all the data of Basket in a map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 *

	 * @throws  IOException

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */

	public static LinkedHashMap<String,ArrayList<String>> captureBasketDataInMap(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>> mapBasketData=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList<String> listBasketPage ;

		String key=null;



		try {                                  

			Thread.sleep(2000);

			int noOfDealsInBasket=genericKeywords.locateElements("basketPageAllDeals_xpath", loginPage.driver).size();

			//System.out.println("Number of deals in the basket=  "+noOfDealsInBasket);

			if(noOfDealsInBasket<2) {

				String deal1Header=genericKeywords.locateElement("basketPageAllDealHeader_xpath",loginPage.driver).getText();

				//System.out.println("Deal Header :/n"+deal1Header); 

				List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[1]//tr"));

				for(int i=2;i<dealDataRows.size();i++) {

					List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[1]//tr["+i+"]//td"));

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

			}

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

	public static LinkedHashMap<String,ArrayList<String>> deal1CaptureBasketDataInMap(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>> mapBasketData=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList<String> listBasketPage ;

		String key=null;

		Thread.sleep(5000);

		try {

			String deal1Header=genericKeywords.locateElement("basketPageAllDealHeader_xpath",loginPage.driver).getText();

			//System.out.println("Deal Header :/n"+deal1Header); 

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[1]//tr"));

			for(int i=2;i<dealDataRows.size();i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[1]//tr["+i+"]//td"));

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



			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		//System.out.println("mapBasketData  :"+mapBasketData);

		return mapBasketData;

	}



	public static LinkedHashMap<String,ArrayList<String>> deal2CaptureBasketDataInMap(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {



		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		LinkedHashMap<String,ArrayList<String>> mapBasketData=new LinkedHashMap<String,ArrayList<String>>();

		ArrayList<String> listBasketPage ;

		String key=null;



		try {                                  

			List<WebElement> dealDataRows= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr"));

			for(int i=2;i<dealDataRows.size();i++) {

				List<WebElement> dealDataNodes= loginPage.driver.findElements(By.xpath("(//table[@id='bodyTbl_right'])[2]//tr["+i+"]//td"));

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



			System.out.println("basketPageDataMap2 ="+mapBasketData);

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

	 * Below function will capture  End Revenue ,Upfront Cost and Mrc from Basket in a map and return the map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */  

	public static LinkedHashMap<String,String> mapBasketPageUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("basketPageTotalUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("basketPageTotalMRC_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			endRevenue=genericKeywords.locateElement("basketPageTotalEndRevenue_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("End Revenue",endRevenue);



			System.out.println("basketUfMrcEndRevenue ="+basketPageUfMrcEndRevenue);

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

		return basketPageUfMrcEndRevenue;  

	}

	/*

	 * Below function will capture  End Revenue ,Upfront Cost and Mrc from Basket in a map and return the map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */  

	public static LinkedHashMap<String,String> mapHomeBasketPageUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("basketPageHomeTotalUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("basketHomePageTotalMRC_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			endRevenue=genericKeywords.locateElement("basketPageTotalEndRevenue_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("End Revenue",endRevenue);



			System.out.println("basketUfMrcEndRevenue ="+basketPageUfMrcEndRevenue);

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

		return basketPageUfMrcEndRevenue;  

	}

	public static LinkedHashMap<String,String> addLineDeal1mapBasketPageUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("deal1BasketPageTotalUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("deal1BasketPageTotalMRC_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			System.out.println("basketUfMrcEndRevenue1 ="+basketPageUfMrcEndRevenue);





			Thread.sleep(1000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing Basket Page data operation Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Deal 1:Capturing Basket Page data operation Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Deal 1:Capturing Basket Page data operation Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Deal 1:Capturing Basket Page data operation Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Deal 1:Capturing Basket Page data operation Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Deal 1:Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Deal 1:Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return basketPageUfMrcEndRevenue;  

	}

	public static LinkedHashMap<String,String> addLineDeal2mapBasketPageUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();

		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("newdeal2BasketPageTotalUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("newdeal2BasketPageTotalMRC_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			System.out.println("basketUfMrcEndRevenue2 ="+basketPageUfMrcEndRevenue);



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

		return basketPageUfMrcEndRevenue;  

	}

	/*

	 * Below function will capture ,Upfront Cost and Mrc from Basket in a map and return the map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */  

	public static LinkedHashMap<String,String> mapBasketPageRetailUfMrc(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(5000);

			totalUpfrontCost=genericKeywords.locateElement("basketPageRetailTotalUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("basketPageRetailTotalMRC_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			/*endRevenue=genericKeywords.locateElement("basketPageTotalEndRevenue_xpath", loginPage.driver).getText();

                                           basketPageUfMrcEndRevenue.put("End Revenue",endRevenue);

			 */

			System.out.println("basketUfMrcEndRevenue ="+basketPageUfMrcEndRevenue);

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

		return basketPageUfMrcEndRevenue;  

	}





	/*

	 * Below function will capture  End Revenue ,Upfront Cost and Mrc from Basket in a map and return the map

	 * Return type is LinkedHashMap<String,ArrayList<String>>

	 *

	 * @throws  IOException

	 * @return LinkedHashMap<String,String>

	 * @author  Akarshit Srivastava-

	 * @since   18-May-2020

	 */  

	public static LinkedHashMap<String,String> mapBasketPageRetrieveUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {

			Thread.sleep(2000);

			//genericKeywords.scrollDown(genericKeywords.locateElement("basketPageRetriveTotalUpfrontCost_xpath", loginPage.driver), loginPage.driver);

			totalUpfrontCost=genericKeywords.locateElement("basketPageRetriveTotalUpfrontCost_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("basketPageRetriveTotalMRC_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			endRevenue=genericKeywords.locateElement("basketPageTotalEndRevenue_xpath", loginPage.driver).getText();

			basketPageUfMrcEndRevenue.put("End Revenue",endRevenue);



			System.out.println("basketUfMrcEndRevenue ="+basketPageUfMrcEndRevenue);

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

			/*              genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return basketPageUfMrcEndRevenue;  

	}

	public static LinkedHashMap<String,String> indirectMapBasketPageRetrieveUfMrcEndRevenue(String screenshotsPath,boolean screenshotToBeCaptured) throws IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String totalUpfrontCost,totalMrc,endRevenue;

		LinkedHashMap<String,String> basketPageUfMrcEndRevenue=new LinkedHashMap<String,String>();



		try {



			Thread.sleep(2000);

			//genericKeywords.scrollDown(genericKeywords.locateElement("basketPageRetriveTotalUpfrontCost_xpath", loginPage.driver), loginPage.driver);

			totalUpfrontCost=genericKeywords.locateElement("basketPageRetriveTotalUpfrontCost_xpath", loginPage.driver).getAttribute("textContent");

			basketPageUfMrcEndRevenue.put("Total upfront cost",totalUpfrontCost);

			totalMrc=genericKeywords.locateElement("basketPageRetriveTotalMRC_xpath", loginPage.driver).getAttribute("textContent");

			basketPageUfMrcEndRevenue.put("Total MRC",totalMrc);

			endRevenue=genericKeywords.locateElement("basketPageTotalEndRevenue_xpath", loginPage.driver).getAttribute("textContent");

			basketPageUfMrcEndRevenue.put("End Revenue",endRevenue);



			System.out.println("basketUfMrcEndRevenue ="+basketPageUfMrcEndRevenue);

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

			reportDirectory.test.log(LogStatus.FAIL, "CCapturing Basket Page data operation Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing Basket Page data operation Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

		return basketPageUfMrcEndRevenue;  

	}

	/*

	 * Below function will select the one option from (Edit,Delete,Close,Submit)

	 * It takes two parameters

	 * @param WebElement element

	 * @param String selectAction-Edit,Delete,Close,Submit

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */

	public static String takeActionOnBasket(String selectAction, String screenshotsPath,boolean screenshotToBeCaptured) throws InterruptedException, IOException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		String dateTime=null;

		Thread.sleep(2000);



		try {



			Thread.sleep(1000);

			if(!(selectAction.equalsIgnoreCase("Edit"))) {

				genericKeywords.hilightElement(loginPage.driver.findElement(By.xpath("(//button[text()='"+selectAction+"'])[2]")),loginPage.driver);

				loginPage.driver.findElement(By.xpath("(//button[text()='"+selectAction+"'])[2]")).sendKeys(Keys.ENTER);

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

				//reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed");

				//reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectAction+" inside basket Passed");

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

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectAction+" inside basket Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectAction+" inside basket Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectAction+" inside basket Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectAction+" inside basket Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}



		return dateTime;

	}



	/*

	 * Below function will select the one option from dropdown

	 * It takes two parameters

	 * @param WebElement element

	 * @param String selectDealOptionFromDropDown-(Accept,Decline and Under Consideration)

	 * @param String selectReasonNumber-give index in string form

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */

	public static void takeActionOnParticularDeal(String selectDealOptionFromDropDown,String selectReasonNumber,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		WebElement dropDown = null;

		WebElement dropDown1= null;

		try {

			Thread.sleep(2000);

			try {

				dropDown=genericKeywords.locateElement("basketPageDealOptionDropDown_xpath", loginPage.driver);

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

			case "Accept Manual Regrade" :

				genericKeywords.selectFromDropdown(dropDown1, "visibleText", "Accept");

				Thread.sleep(8000);

				WebElement uCreasonDropDown=genericKeywords.locateElement("basketPageAcceptReasonsManualRegradeDropDown_xpath", loginPage.driver);

				genericKeywords.waitUntilElementIsDisplayed(5, uCreasonDropDown);

				uCreasonDropDown.click();

				genericKeywords.selectFromDropdown(uCreasonDropDown,"index", selectReasonNumber);

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

			//reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

	}

	public static void addLinetakeActionOnParticularDeal(String objectKey,String selectDealOptionFromDropDown,String selectReasonNumber,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		WebElement dropDown = null;



		try {

			Thread.sleep(2000);

			dropDown=genericKeywords.locateElement(objectKey, loginPage.driver);

			dropDown.click();



			//WebElement reasonDropDown=genericKeywords.locateElement("basketPageDealOptionReasonsDropDown_xpath", loginPage.driver);



			switch (selectDealOptionFromDropDown) {



			case "Accept":

				genericKeywords.selectFromDropdown(dropDown, "visibleText", selectDealOptionFromDropDown);

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

				Thread.sleep(4000);

				WebElement dreasonDropDown=genericKeywords.locateElement("basketPageDeclineReasonsDropDown_xpath", loginPage.driver);

				genericKeywords.waitUntilElementIsDisplayed(5, dreasonDropDown);

				Thread.sleep(3000);

				dreasonDropDown.click();

				genericKeywords.selectFromDropdown(dreasonDropDown,"index", selectReasonNumber);               

				break;

			}

			Thread.sleep(3000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			}

			Thread.sleep(5000);



		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

	}

	/*

	 * Below function will select the one option from dropdown

	 * It takes two parameters

	 * @param WebElement element

	 * @param String selectDealOptionFromDropDown-(Accpt,Decline and Under Consideration)

	 * @author  Akarshit Srivastava

	 * @since   18-May-2020

	 */

	public static void retrieveTakeActionOnParticularDeal(String selectDealOptionFromDropDown,String screenshotsPath,boolean screenshotToBeCaptured) throws IOException, InterruptedException {

		String pathOfScreenshot = null;

		String fileName=new Throwable().getStackTrace()[0].getMethodName();

		try {

			Thread.sleep(2000);

			WebElement retrieveDropDown=genericKeywords.locateElement("basketPageRetriveDealOptionDropDown_xpath", loginPage.driver);



			switch (selectDealOptionFromDropDown) {



			case "Accept":



				retrieveDropDown.click();

				genericKeywords.selectFromDropdown(retrieveDropDown, "visibleText", selectDealOptionFromDropDown);

				break;



			case "Decline" :

				retrieveDropDown.click();

				genericKeywords.selectFromDropdown(retrieveDropDown, "visibleText", selectDealOptionFromDropDown);



			}

			Thread.sleep(5000);

			//genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

			//reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			if(screenshotToBeCaptured==true) {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			}else {

				reportDirectory.test.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Selecting "+selectDealOptionFromDropDown+" from DropDown Passed");

			}

			Thread.sleep(5000);





		}catch(Exception e) {

			/*genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

                                           reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed");

                                           e.printStackTrace();*/

			reportDirectory.test.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Selecting "+selectDealOptionFromDropDown+" from DropDown Failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

			e.printStackTrace();

		}

	}

}