package generics;

 

import java.io.IOException;

import java.util.List;

 

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

 

import com.relevantcodes.extentreports.LogStatus;

 

import testSetup.reportDirectory;

 

public class deneverMethods {

 

              /*

              * Below function will select the incom range from the dropdown list and submit it

              * It accepts 1 parameters

              * @param String indexOfIncome

              * @return void

              * @author Akarshit Srivastava

              * @throws InterruptedException

               * @throws IOException

               * @since 04-June-2021

              */        

              public static void selectIncomRangefromDropdown(String indexOfIncome,String screenshotsPath,boolean screenshotToBeCaptured ) {

 

                             String pathOfScreenshot = null;

                             String fileName=new Throwable().getStackTrace()[0].getMethodName();

                             try {

                                           WebElement incomeDropDown=genericKeywords.locateElement("denverIncomeSelectDropDown_xpath",loginPage.driver);

                                           genericKeywords.selectFromDropdown(incomeDropDown, "index", indexOfIncome);

                                           WebElement submitBtn=genericKeywords.locateElement("denverIncomCheckSubmitBtn_xpath",loginPage.driver);

                             pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

                                           genericKeywords.clickElement(submitBtn);

                                           Thread.sleep(3000);

                                           loginPage.driver.switchTo().alert().accept();

                                           Thread.sleep(5000);

                             pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

                                           if(screenshotToBeCaptured==true) {

                                                          reportDirectory.test.log(LogStatus.PASS, "Income Check Passed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Income Check Passed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

                                           }else {

                                                          reportDirectory.test.log(LogStatus.PASS, "Income Check Passed");

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Income Check Passed");

                                           }

                                           Thread.sleep(7000);

                             }catch(Exception e) {

 

                                           reportDirectory.test.log(LogStatus.FAIL, "Income Check Failed Please try after one month"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Income Check Failed Please try after one month"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

                                           e.printStackTrace();

                             }

              }

              /*

              * Below function will select the Loan Repay method range from loan

              * It accepts 1 parameters

              * @param String indexOfIncome

              * @return void

              * @author Akarshit Srivastava

              * @throws InterruptedException

               * @throws IOException

               * @since 07-June-2021

              */        

              public static void selectLoanRepayFromLoanTab(String indexOfIncom,String screenshotsPath,boolean screenshotToBeCaptured ) {

 

                             String pathOfScreenshot = null;

                             String fileName=new Throwable().getStackTrace()[0].getMethodName();

                             try {

                                           List<WebElement> row=loginPage.driver.findElements(By.xpath("(//table[@class='gridTable '])[1]//tr[2]/td"));

                                           for(int i=1;i<row.size();i++) {

                                                          WebElement upFrontCost=genericKeywords.locateElement("denverLoanTabUpfrontCostDropDown_xpath",loginPage.driver);

                                                         genericKeywords.selectFromDropdown(upFrontCost, "index",indexOfIncom);

                                                          WebElement payCashPrice=genericKeywords.locateElement("denverLoanTabPayAsCashPriceCheckBox_xpath",loginPage.driver);             

                                                          genericKeywords.jsClick(payCashPrice);

                                                          Thread.sleep(5000);

                                           pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

                                                          WebElement confirmBtn=genericKeywords.locateElement("denverLoanTabConfirmBtn_xpath",loginPage.driver);

                                                          genericKeywords.jsClick(confirmBtn);

 

 

                                           }

                                           Thread.sleep(3000);

                                           if(screenshotToBeCaptured==true) {

                                                          reportDirectory.test.log(LogStatus.PASS, "Loan Repay Submitted Successfully"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Loan Repay Submitted Successfully"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

                                           }else {

                                                          reportDirectory.test.log(LogStatus.PASS, "Loan Repay Submitted Successfully");

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Loan Repay Submitted Successfully");

                                           }

                                          

                             }catch(Exception e) {

 

                                           reportDirectory.test.log(LogStatus.FAIL, "Loan Repay not submitted"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Loan Repay not submitted"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

                                           e.printStackTrace();

                             }

              }

 

              /*

              * Below function will select the incom range from the dropdown list and submit it

              * It accepts 1 parameters

              * @param String indexOfIncome

              * @return void

              * @author Akarshit Srivastava

              * @throws InterruptedException

               * @throws IOException

               * @since 04-June-2021

              */        

              public static void loanRepayAlertAccept(String screenshotsPath,boolean screenshotToBeCaptured ) {

 

                             String pathOfScreenshot = null;

                             String fileName=new Throwable().getStackTrace()[0].getMethodName();

                             try {

                                           WebElement noBtn=genericKeywords.locateElement("denverLoanRepayAlertWindowNoBtn_xpath",loginPage.driver);

                                           genericKeywords.clickElement(noBtn);

                                           Thread.sleep(3000);

                                           WebElement submitBtn=genericKeywords.locateElement("denverLoanRepayAlertWindowSubmitBtn_xpath",loginPage.driver);

                             pathOfScreenshot=genericKeywords.captureScreenShots_new(loginPage.driver,screenshotsPath,fileName);

                                           genericKeywords.clickElement(submitBtn);

                                           Thread.sleep(5000);

                                           if(screenshotToBeCaptured==true) {

                                                          reportDirectory.test.log(LogStatus.PASS, "Loan Repay agreement Accepted"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Loan Repay agreement Accepted"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

                                           }else {

                                                          reportDirectory.test.log(LogStatus.PASS, "Loan Repay agreement Accepted");

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Loan Repay agreement Accepted");

                                           }

                                           Thread.sleep(7000);

                             }catch(Exception e) {

                                           reportDirectory.test.log(LogStatus.FAIL, "Loan Repay agreement failed"+ reportDirectory.test.addScreenCapture(pathOfScreenshot));

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Loan Repay agreement failed"+ reportDirectory.test_consolidated.addScreenCapture(pathOfScreenshot));

                                           e.printStackTrace();

                             }

              }

 
}

 