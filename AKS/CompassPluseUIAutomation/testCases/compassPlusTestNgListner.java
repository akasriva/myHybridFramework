package testCases;

 

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import testSetup.reportDirectory;

public class compassPlusTestNgListner implements ITestListener {

 

              public static void main(String[] args) {

                             // TODO Auto-generated method stub

 

              }

 

              @Override

              public void onFinish(ITestContext arg0) {

                            

                             System.out.println("Compass Plus execution Fineshed");

                             reportDirectory.test.log(LogStatus.INFO, "Compass Plus execution is Fineshed");

                             reportDirectory.test_consolidated.log(LogStatus.INFO, "Compass Plus execution is Fineshed");

              }

 

              @Override

              public void onStart(ITestContext arg0) {

                             System.out.println("Compass Pluse UI Automation has started");

                             reportDirectory.test.log(LogStatus.INFO, "Compass Pluse UI Automation has started");

                             reportDirectory.test_consolidated.log(LogStatus.INFO, "Compass Pluse UI Automation has started");

              }

 

              @Override

              public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

                            

                            

              }

 

              @Override

              public void onTestFailure(ITestResult arg0) {

                             System.out.println(getMethodName(arg0)+" Test Case has failed");

                             reportDirectory.test.log(LogStatus.FAIL, getMethodName(arg0)+" Test Case has failed");

                             reportDirectory.test_consolidated.log(LogStatus.FAIL, getMethodName(arg0)+" Test Case has failed");

                            

              }

 

              @Override

              public void onTestSkipped(ITestResult arg0) {

                             System.out.println(getMethodName(arg0)+" Test Case has skipped");

                             reportDirectory.test.log(LogStatus.SKIP, getMethodName(arg0)+" Test Case has skipped");

              reportDirectory.test_consolidated.log(LogStatus.SKIP,getMethodName(arg0)+" Test Case has skipped");

              }

 

              @Override

              public void onTestStart(ITestResult arg0) {

                             System.out.println(getMethodName(arg0)+" Test has started");

                             reportDirectory.test.log(LogStatus.INFO, getMethodName(arg0)+" Test has started");

              reportDirectory.test_consolidated.log(LogStatus.INFO,getMethodName(arg0)+" Test has started");         

                             }

 

              @Override

              public void onTestSuccess(ITestResult arg0) {

                            

                             System.out.println("Test executed successfully");

                             reportDirectory.test.log(LogStatus.INFO, "Test executed successfully");

                             reportDirectory.test_consolidated.log(LogStatus.INFO, "Test executed successfully");

              }

              public static String getMethodName(ITestResult arg0) {

                             return arg0.getMethod().getConstructorOrMethod().getName();

              }

 

}