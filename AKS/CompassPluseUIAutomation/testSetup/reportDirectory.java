package testSetup;



import java.io.File;

import java.io.IOException;

import java.nio.file.Paths;



import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;

import com.codoid.products.exception.FilloException;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;



import components.Generics;



public class reportDirectory {



	public static ExtentTest test,test_consolidated;

	public static ExtentReports report,report_consolidated;

	public static ExtentHtmlReporter htmlReports;

	public static String timestamp,timestamp2;

	public static File file;

	public static String commonFilepath2=System.getProperty("user.dir")+"./ReportUIAutomation/";

	private static String timestamp2Bereffered;

	private static File file_screenshot;





	/**



	 * Below function captures creates directory

	 * It accepts no parameters

	 * @param

	 * @param

	 * @return void

	 * @author Devi Das

	 * @throws IOException

	 * @since 17-MArch-2020

	 */



	public static String createDirectoryUIAutomation(String tcName) {



		String k = null;



		try {



			timestamp2=Generics.getTimestamp();



			k=timestamp2;



			file=new File(commonFilepath2+tcName+timestamp2);



			file.mkdir();



			try {



				if(isFileDirectoryExists(file)) {



					file_screenshot=new File(commonFilepath2+tcName+timestamp2+"/"+"screenshots");



					file_screenshot.mkdir();



				}



			}catch(Exception e) {



				System.out.println("Error in creating screenshot directory");



				test.log(LogStatus.INFO, "Error in creating screenshot directory");



				test_consolidated.log(LogStatus.INFO, "Error in creating screenshot directory");



				e.printStackTrace();



			}



		}catch(Exception e){



			System.out.println("Error in creating directory");



			test.log(LogStatus.INFO, "Error in creating directory");



			test_consolidated.log(LogStatus.INFO, "Error in creating directory");



			e.printStackTrace();



		}



		return k;



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



	public static String createDirectoryCaptureReportFilesInsideDirectoryUIAutomation



	(String tcName) {





		try {



			timestamp2Bereffered=createDirectoryUIAutomation(tcName);



			System.out.println("----------- TEST CASE EXECUTION STARTS -------------");



			report=new ExtentReports(commonFilepath2+tcName+timestamp2+"/Report_"+tcName+".html");

			report.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));

			test_consolidated=report_consolidated.startTest(tcName);



			test=report.startTest(tcName);



			initializeExtentTestCommandsForReportingsForUIAutomation(test,test_consolidated);



			//test.log(LogStatus.PASS, "");



			//           test_consolidated.log(LogStatus.PASS, "");





		}catch(Exception e) {



			e.printStackTrace();



		}



		return timestamp2Bereffered;



	}



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



	public static boolean isFileDirectoryExists(File path) {



		if(file.exists()) {



			return true;



		}else {



			return false;



		}



	}





	public static boolean isDirectoryExists(String directoryPath) {



		if(!Paths.get(directoryPath).toFile().isDirectory()) {



			return false;



		}



		return true;



	}









}