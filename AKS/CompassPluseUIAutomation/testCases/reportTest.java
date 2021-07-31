package testCases;



import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

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

import generics.genericKeywords;

import generics.interactionHistoryPage;

import generics.loginPage;

import generics.tradeInPage;

import testSetup.reportDirectory;

import testSetup.userExceptionMsg;



public class reportTest {



	static ExtentReports extent;

	static ExtentTest test;

	static String timestampOfCreatedDirectory,dateOfActionOnDeal,nameOfTestMethode,screenshotsPath;

	static LinkedHashMap<String, ArrayList<String>> basketPageDataMap,intractHistExpandData,basketSummHeader,dealBuilderData,basketSummeryPageDescription,basketSummeryPageHeader;

	static LinkedHashMap<String, String> intractHistUfMrcEndRevenue,basketUfMrcEndRevenue,intractionHistoryLatestRow,customerDetails_profilePannel,eligibility_profilePannel,productHolding_profilePannel,usage_profilePannel,excelData;          

	public static  int flag;     

	@BeforeTest

	public static void setup() {

		reportDirectory.timestamp=Generics.getTimestamp();  

		reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+"Consolidated Regression Report_"+reportDirectory.timestamp+".html");

		reportDirectory.report_consolidated.loadConfig(new File(System.getProperty("user.dir")+"/consolidated-extent-config.xml"));

	}



	@Test() public static void testCase1() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		//reportDirectory.timestamp=Generics.getTimestamp();                             

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+"Consolidated Regression Report_"+reportDirectory.timestamp+".html");

		//reportDirectory.report_consolidated.loadConfig(new File(System.getProperty("user.dir")+"/consolidated-extent-config.xml"));

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";

		System.out.println("timestampOfCreatedDirectory "+timestampOfCreatedDirectory);

		//System.out.println("reportDirectory.report_consolidated "+reportDirectory.report_consolidated);

		try {

			test=reportDirectory.report.startTest("");



			int a=20,b=30,sum=a+b;



			if(sum>30)

			{                          

				reportDirectory.test.log(LogStatus.PASS, "Test case one Passsed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Test case one Passsed");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Test case one failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Test case one failed");

			}

			Thread.sleep(5000);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test()

	public static void testCase2() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                               

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";

		System.out.println("timestampOfCreatedDirectory "+timestampOfCreatedDirectory);

		//System.out.println("reportDirectory.report_consolidated "+reportDirectory.report_consolidated);

		try {

			test=reportDirectory.report.startTest("");

			int a=20,b=30,sum=a+b;



			if(sum>30)

			{                          

				reportDirectory.test.log(LogStatus.PASS, "Test case 2 Passsed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Test case 2 Passsed");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Test case 2 failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Test case 2 failed");

			}

			Thread.sleep(5000);



			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test()

	public static void testCase3() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                               

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";

		System.out.println("timestampOfCreatedDirectory "+timestampOfCreatedDirectory);

		System.out.println("reportDirectory.report_consolidated "+reportDirectory.report_consolidated);

		try {

			test=reportDirectory.report.startTest("");

			int a=20,b=30,sum=a+b;



			if(sum>30)

			{                          

				reportDirectory.test.log(LogStatus.PASS, "Test case 3 Passsed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Test case 3 Passsed");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Test case 3 failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Test case 3 failed");



			}

			Thread.sleep(5000);                    

			flag++;

			reportDirectory.report.endTest(test);

			reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);



		}catch(Exception e) {

			System.out.println("Catch block executedin upgrade test method");

			Assert.assertEquals(flag, 1);

			e.printStackTrace();

		}

	}

	@Test()

	public static void testCase4() throws InterruptedException, IOException, FilloException, userExceptionMsg {



		flag=0;

		nameOfTestMethode=new Throwable().getStackTrace()[0].getMethodName();

		reportDirectory.timestamp=Generics.getTimestamp();                               

		//reportDirectory.report_consolidated=new ExtentReports(reportDirectory.commonFilepath2+nameOfTestMethode+"_"+reportDirectory.timestamp+".html");

		timestampOfCreatedDirectory=reportDirectory.createDirectoryCaptureReportFilesInsideDirectoryUIAutomation(nameOfTestMethode);

		screenshotsPath=reportDirectory.commonFilepath2+nameOfTestMethode+timestampOfCreatedDirectory+"/"+"screenshots"+"/";

		System.out.println("timestampOfCreatedDirectory "+timestampOfCreatedDirectory);

		//System.out.println("reportDirectory.report_consolidated "+reportDirectory.report_consolidated);

		try {

			test=reportDirectory.report.startTest("");

			int a=20,b=30,sum=a+b;

			if(sum>30)

			{                          

				reportDirectory.test.log(LogStatus.PASS, "Test case 4 Passsed");

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Test case 4 Passsed");

			}else {

				reportDirectory.test.log(LogStatus.FAIL, "Test case 4 failed");

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Test case 4 failed");



			}

			Thread.sleep(5000);                    

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

	public void tearDown(ITestResult result) throws IOException, InterruptedException {



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

				//System.out.println("Screenshot taken");



			}catch(Exception e) {

				e.printStackTrace();

			}

		}

		//loginPage.driver.quit();

		reportDirectory.test.log(LogStatus.INFO, "End of Execution");

		reportDirectory.report.endTest(reportDirectory.test);   

		reportDirectory.report.flush();

		reportDirectory.test_consolidated.log(LogStatus.INFO, "End of Execution");      

		reportDirectory.report_consolidated.endTest(reportDirectory.test_consolidated);

		reportDirectory.report_consolidated.flush();

		//Thread.sleep(5000);

		//reportDirectory.report.close();//This line of extent report has some issue //

		//reportDirectory.report_consolidated.close();

	}







































}