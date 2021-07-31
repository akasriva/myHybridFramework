package generics;



import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.LinkedHashMap;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;



import com.relevantcodes.extentreports.LogStatus;



import testSetup.reportDirectory;



public class profilePannel {



	public static LinkedHashMap<String, String> getCustomerDetails(String screenshotsPath) throws IOException {



		Object key=null;

		Object value=null;

		String text=null;

		LinkedHashMap<String, String> customerDetails_profilePannelPage=new LinkedHashMap<String, String>();

		ArrayList<String> arrayList=new ArrayList<String>();



		try {

			List<WebElement> totalRowsUnderCustomerDetails=loginPage.driver.findElements(By.xpath("(//div[@class='content-item content-layout item-2 remove-bottom-spacing remove-right-spacing flex flex-row'])[2]/div/div/div/div"));      

			for(int i=1; i<=totalRowsUnderCustomerDetails.size(); i++) {

				text=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-layout item-2 remove-bottom-spacing remove-right-spacing flex flex-row'])[2]/div/div/div/div["+i+"]")).getText();

				if(!text.isEmpty()) {

					arrayList.add(text);

				}

			}

			Iterator iterator = arrayList.iterator();

			while(iterator.hasNext()) {                                

				key=iterator.next();

				iterator.remove();                                 

				value=iterator.next();

				iterator.remove();

				customerDetails_profilePannelPage.put(key.toString(), value.toString());

			}                          

			System.out.println("customerDetails_profilePannel: "+customerDetails_profilePannelPage);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Capturing customer details from Profile Pannel Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing customer details from Profile Pannel Passed");

		}catch(Exception e) {

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Capturing customer details from Profile Pannel Failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing customer details from Profile Pannel Failed");

			e.printStackTrace();

		}

		return customerDetails_profilePannelPage;

	}

	public static LinkedHashMap<String, String> getAccountDetails(String screenshotsPath) throws IOException {



		Object key=null;

		Object value=null;

		String text=null;

		LinkedHashMap<String, String> accountDetails_profilePannelPage=new LinkedHashMap<String, String>();

		ArrayList<String> arrayList=new ArrayList<String>();



		try {

			List<WebElement> totalRowsUnderCustomerDetails=loginPage.driver.findElements(By.xpath("(//div[@class='content-item content-layout item-2 remove-bottom-spacing remove-right-spacing flex flex-row'])[2]/div/div/div/div"));      

			for(int i=1; i<=totalRowsUnderCustomerDetails.size(); i++) {

				text=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-layout item-2 remove-bottom-spacing remove-right-spacing flex flex-row'])[2]/div/div/div/div["+i+"]")).getText();

				if(!text.isEmpty()) {

					arrayList.add(text);

				}

			}

			Iterator iterator = arrayList.iterator();

			while(iterator.hasNext()) {                                

				key=iterator.next();

				iterator.remove();                                 

				value=iterator.next();

				iterator.remove();

				accountDetails_profilePannelPage.put(key.toString(), value.toString());

			}                          

			System.out.println("customerDetails_profilePannel: "+accountDetails_profilePannelPage);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Capturing customer details from Profile Pannel Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing customer details from Profile Pannel Passed");

		}catch(Exception e) {

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Capturing customer details from Profile Pannel Failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing customer details from Profile Pannel Failed");

			e.printStackTrace();

		}

		return accountDetails_profilePannelPage;

	}

	public static LinkedHashMap<String, String> getEligibilityDetails(String screenshotsPath) throws IOException {



		Object key=null;

		Object value=null;

		String text=null;

		LinkedHashMap<String, String> eligibility_profilePannelPage=new LinkedHashMap<String, String>();

		ArrayList<String> arrayList=new ArrayList<String>();



		try {



			List<WebElement> totalRowsUnderCustomerDetails=loginPage.driver.findElements(By.xpath("(//div[@class='content-item content-layout item-2 remove-all-spacing flex flex-row'])[2]/div/div/div/div"));       



			for(int i=1; i<=totalRowsUnderCustomerDetails.size(); i++) {

				text=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-layout item-2 remove-all-spacing flex flex-row'])[2]/div/div/div/div["+i+"]")).getText();



				if(!text.isEmpty()) {

					arrayList.add(text);

				}

			}                                         



			Iterator iterator = arrayList.iterator();

			while(iterator.hasNext()) {                                

				key=iterator.next();

				iterator.remove();                                  

				value=iterator.next();

				iterator.remove();

				eligibility_profilePannelPage.put(key.toString(), value.toString());

			}

			System.out.println("eligibility_profilePannel: "+eligibility_profilePannelPage);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Capturing eligibility details from Profile Pannel Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing eligibility details from Profile Pannel Passed");



		}catch(Exception e) {

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Capturing eligibility details from Profile Pannel Failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing eligibility details from Profile Pannel Failed");

			e.printStackTrace();

		}



		return eligibility_profilePannelPage;

	}

	public static LinkedHashMap<String, String> getProductHoldingDetails(String screenshotsPath) throws IOException {



		Object key=null;

		Object value=null;

		String text=null;

		LinkedHashMap<String, String> productHolding_profilePannelPage=new LinkedHashMap<String, String>();

		ArrayList<String> arrayList=new ArrayList<String>();



		try {

			List<WebElement> totalRowsUnderProductHolding=loginPage.driver.findElements(By.xpath("(//div[@class='content-item content-layout item-2 remove-all-spacing flex flex-row'])[3]/div/div/div/div"));       

			for(int i=1; i<=totalRowsUnderProductHolding.size(); i++) {

				text=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-layout item-2 remove-all-spacing flex flex-row'])[3]/div/div/div/div["+i+"]")).getText();

				if(!text.isEmpty()) {

					arrayList.add(text);

				}

			}                                         

			Iterator iterator = arrayList.iterator();

			while(iterator.hasNext()) {                                

				key=iterator.next();

				iterator.remove();                                 

				value=iterator.next();

				iterator.remove();

				productHolding_profilePannelPage.put(key.toString(), value.toString());

			}            

			System.out.println("productHolding_profilePannel: "+productHolding_profilePannelPage);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Capturing product holding details from Profile Pannel Passed");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Capturing product holding details from Profile Pannel Passed");



		}catch(Exception e) {

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Capturing product holding details from Profile Pannel Failed");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Capturing product holding details from Profile Pannel Failed");

			e.printStackTrace();

		}

		return productHolding_profilePannelPage;

	}

	public static LinkedHashMap<String, String> getUsageDetails(String screenshotsPath) throws IOException {



		Object key=null;

		Object value=null;

		String text=null;

		LinkedHashMap<String, String> usage_profilePannelPage=new LinkedHashMap<String, String>();

		ArrayList<String> arrayList=new ArrayList<String>();



		try {

			List<WebElement> totalRowsUnderUsage=loginPage.driver.findElements(By.xpath("(//div[@class='content-item content-layout item-2 remove-all-spacing flex flex-row'])[4]/div/div/div/div"));       

			for(int i=1; i<=totalRowsUnderUsage.size(); i++) {

				text=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-layout item-2 remove-all-spacing flex flex-row'])[4]/div/div/div/div["+i+"]")).getText();

				if(!text.isEmpty()) {

					arrayList.add(text);

				}

			}                                         

			Iterator iterator = arrayList.iterator();

			while(iterator.hasNext()) {                                

				key=iterator.next();

				iterator.remove();                                 

				value=iterator.next();

				iterator.remove();

				usage_profilePannelPage.put(key.toString(), value.toString());

			}

			System.out.println("usage_profilePannel: "+usage_profilePannelPage);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Fetched usage details from Profile Pannel");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Fetched usage details from Profile Pannel");



		}catch(Exception e) {

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Fetched usage details from Profile Pannel");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Fetched usage details from Profile Pannel");

			e.printStackTrace();

		}

		return usage_profilePannelPage;

	}

	public static LinkedHashMap<String, String> getPegasusUsageDetails(String screenshotsPath) throws IOException {



		Object key=null;

		Object value=null;

		String text=null;

		LinkedHashMap<String, String> usage_profilePannelPage=new LinkedHashMap<String, String>();

		ArrayList<String> arrayList=new ArrayList<String>();



		try {

			List<WebElement> totalRowsUnderUsage=loginPage.driver.findElements(By.xpath("(//div[@class='content-item content-layout item-3 remove-all-spacing flex flex-row'])[3]/div/div/div/div"));       

			for(int i=1; i<=totalRowsUnderUsage.size(); i++) {

				text=loginPage.driver.findElement(By.xpath("(//div[@class='content-item content-layout item-3 remove-all-spacing flex flex-row'])[3]/div/div/div/div["+i+"]")).getText();

				if(!text.isEmpty()) {

					arrayList.add(text);

				}

			}                                         

			Iterator iterator = arrayList.iterator();

			while(iterator.hasNext()) {                                

				key=iterator.next();

				iterator.remove();                                 

				value=iterator.next();

				iterator.remove();

				usage_profilePannelPage.put(key.toString(), value.toString());

			}

			System.out.println("usage_profilePannel: "+usage_profilePannelPage);

			Thread.sleep(5000);

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.PASS, "Fetched usage details from Profile Pannel");

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Fetched usage details from Profile Pannel");



		}catch(Exception e) {

			genericKeywords.captureScreenShots(loginPage.driver, screenshotsPath);

			reportDirectory.test.log(LogStatus.FAIL, "Fetched usage details from Profile Pannel");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Fetched usage details from Profile Pannel");

			e.printStackTrace();

		}

		return usage_profilePannelPage;

	}

	/**

	 * Below function  validate the Profile panel Product Holding Details with user input data

	 * It accepts 3 parameters

	 * @param  LinkedHashMap<String,String> profilePannelProductHoldingDetails

	 * @param  String key

	 * @param String expectedValue

	 * @return boolean

	 * @author Akarshit Srivastava

	 * @since 26-May-2020

	 */

	public static String validateProductHoldingDetailsKeyValue(LinkedHashMap<String, String> profilePannelProductHoldingDetails,String key,String expectedValue){

		String Contracteddevice=profilePannelProductHoldingDetails.get(key);

		try {



			if((profilePannelProductHoldingDetails.get(key)).equalsIgnoreCase(expectedValue)) {



				System.out.println( key+" is matched, value: "+expectedValue);

				reportDirectory.test.log(LogStatus.PASS, "Profile Panel Product holding "+key+" is matched, value: "+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Profile Panel Product holding "+key+" is matched, value: "+expectedValue);





			}else {

				System.out.println(key+" is mismatched, Actual value: "+profilePannelProductHoldingDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test.log(LogStatus.FAIL, "Profile Panel Product holding "+key+" is mismatched, Actual value: "+profilePannelProductHoldingDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Profile Panel Product holding "+key+" is mismatched, Actual value: "+profilePannelProductHoldingDetails.get(key)+"Expected vlaue="+expectedValue);



			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,key+" is not found in Profile Panel Product holding ");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, key+" is not found in Profile Panel Product holding ");

			e.printStackTrace();



		}

		return Contracteddevice;

	}



	/**

	 * Below function  validate the Profile panel Eligibility Details with user input data

	 * It accepts 3 parameters

	 * @param  LinkedHashMap<String,String> profilePannelEligibilityDetails

	 * @param  String key

	 * @param String expectedValue

	 * @return boolean

	 * @author Akarshit Srivastava

	 * @since 26-May-2020

	 */

	public static String validateEligibilityDetailsKeyValue(LinkedHashMap<String, String> profilePannelEligibilityDetails,String key,String expectedValue){

		try {

			if((profilePannelEligibilityDetails.get(key)).equalsIgnoreCase(expectedValue)) {

				System.out.println( key+" is matched, value: "+expectedValue);

				reportDirectory.test.log(LogStatus.PASS, "Profile Panel EligibilityD "+key+" is matched, value: "+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Profile Panel Eligibility "+key+" is matched, value: "+expectedValue);

				return profilePannelEligibilityDetails.get(key);

			}else {

				System.out.println(key+" is mismatched, Actual value: "+profilePannelEligibilityDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test.log(LogStatus.FAIL, "Profile Panel Eligibility "+key+" is mismatched, Actual value: "+profilePannelEligibilityDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Profile Panel Eligibility "+key+" is mismatched, Actual value: "+profilePannelEligibilityDetails.get(key)+"Expected vlaue="+expectedValue);

				return profilePannelEligibilityDetails.get(key);

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,key+" is not found in Profile Panel Eligibility ");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, key+" is not found in Profile Panel Eligibility ");

			e.printStackTrace();

		}

		return profilePannelEligibilityDetails.get(key);

	}

	/**

	 * Below function  validate the Profile panel Customer

	 * It accepts 3 parameters

	 * @param  LinkedHashMap<String,String> profilePannelCustomerDetails

	 * @param  String key

	 * @param String expectedValue

	 * @return boolean

	 * @author Akarshit Srivastava

	 * @since 26-May-2020

	 */

	public static boolean validateCustomerDetailsKeyValue(LinkedHashMap<String, String> profilePannelCustomerDetails,String key,String expectedValue){

		try {

			if((profilePannelCustomerDetails.get(key)).equalsIgnoreCase(expectedValue)) {

				System.out.println( key+" is matched, value: "+expectedValue);

				reportDirectory.test.log(LogStatus.PASS, "Profile Panel Customer Details "+key+" is matched, value: "+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Profile Panel Customer Details "+key+" is matched, value: "+expectedValue);

				return true;

			}else {

				System.out.println(key+" is mismatched, Actual value: "+profilePannelCustomerDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test.log(LogStatus.FAIL, "Profile Panel Customer Details "+key+" is mismatched, Actual value: "+profilePannelCustomerDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Profile Panel Customer Details "+key+" is mismatched, Actual value: "+profilePannelCustomerDetails.get(key)+"Expected vlaue="+expectedValue);

				return false;

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,key+" is not found in Profile Panel Customer Details ");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, key+" is not found in Profile Panel Customer Details ");

			e.printStackTrace();

			return false;

		}

	}



	/**

	 * Below function  validate the Profile panel Customer

	 * It accepts 3 parameters

	 * @param  LinkedHashMap<String,String> profilePannelCustomerDetails

	 * @param  String key

	 * @param String expectedValue

	 * @return boolean

	 * @author Akarshit Srivastava

	 * @since 26-May-2020

	 */

	public static boolean validateAccountDetailsKeyValue(LinkedHashMap<String, String> profilePannelAccountDetails,String key,String expectedValue){

		try {

			if((profilePannelAccountDetails.get(key)).equalsIgnoreCase(expectedValue)) {

				System.out.println( key+" is matched, value: "+expectedValue);

				reportDirectory.test.log(LogStatus.PASS, "Profile Panel Account Details "+key+" is matched, value: "+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Profile Panel Account Details "+key+" is matched, value: "+expectedValue);

				return true;

			}else {

				System.out.println(key+" is mismatched, Actual value: "+profilePannelAccountDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test.log(LogStatus.FAIL, "Profile Panel Account Details "+key+" is mismatched, Actual value: "+profilePannelAccountDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Profile Panel Account Details "+key+" is mismatched, Actual value: "+profilePannelAccountDetails.get(key)+"Expected vlaue="+expectedValue);

				return false;

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,key+" is not found in Profile Panel Account Details ");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, key+" is not found in Profile Panel Account Details ");

			e.printStackTrace();

			return false;

		}

	}

	/**

	 * Below function  validate the Usage Details with user input data

	 * It accepts 3 parameters

	 * @param  LinkedHashMap<String,String> profilePannelUsageDetails

	 * @param  String key

	 * @param String expectedValue

	 * @return boolean

	 * @author Akarshit Srivastava

	 * @since 26-May-2020

	 */

	public static boolean validateUsageDetailsKeyValue(LinkedHashMap<String, String> profilePannelUsageDetails, String key,String expectedValue){

		try {

			if((profilePannelUsageDetails.get(key)).equalsIgnoreCase(expectedValue)) {

				System.out.println( key+" is matched, value: "+expectedValue);

				reportDirectory.test.log(LogStatus.PASS, "Profile Panel Customer Details "+key+" is matched, value: "+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Profile Panel Customer Details "+key+" is matched, value: "+expectedValue);

				return true;

			}else {

				System.out.println(key+" is mismatched, Actual value: "+profilePannelUsageDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test.log(LogStatus.FAIL, "Profile Panel Usage "+key+" is mismatched, Actual value: "+profilePannelUsageDetails.get(key)+"Expected vlaue="+expectedValue);

				reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Profile Panel Usage "+key+" is mismatched, Actual value: "+profilePannelUsageDetails.get(key)+"Expected vlaue="+expectedValue);

				return false;

			}

		}catch (Exception e) {

			reportDirectory.test.log(LogStatus.FAIL,key+" is not found in Profile Panel Usage ");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, key+" is not found in Profile Panel Usage ");

			e.printStackTrace();

			return false;

		}

	}

}