
package testCases;



import java.io.IOException;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.SessionId;

import org.testng.annotations.Test;



import generics.genericKeywords;

import generics.loginPage;

import testSetup.userExceptionMsg;



public class testTheIECode {





	static String path="D:\\Drivers\\";



	@Test

	public static void testIe() throws userExceptionMsg, IOException, InterruptedException {



		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

		capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);

		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

		capabilities.setCapability("ignoreZoomSetting", true);

		capabilities.setCapability("ignoreProtectedModeSettings", true);

		capabilities.setCapability("initialBrowserUrl",path);



		System.setProperty("webdriver.ie.driver", path+"IEDriverServer.exe");

		WebDriver driver = new InternetExplorerDriver();

		SessionId sessionid = ((InternetExplorerDriver)driver).getSessionId();

		System.out.println("sessionid="+sessionid);

		//System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");

		//WebDriver driver=new ChromeDriver();



		driver.get(https://pegasit2-advisor.nat.bt.com/);

			driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");



		generics.genericKeywords.sendTextValue(generics.genericKeywords.locateElement("loginPageUsernameid_css", driver),"612928716");

		generics.genericKeywords.sendTextValue(generics.genericKeywords.locateElement("loginPagePasswordid_css", driver),"rules");

		generics.genericKeywords.locateElement("loginPageSubmitButton_xpath", driver).click();

		Thread.sleep(5000);

		SessionId sessionid1 = ((InternetExplorerDriver)driver).getSessionId();

		System.out.println("sessionid1="+sessionid1);

		genericKeywords.locateElement("designerStudioPageOENBAA_xpath",driver).click();

		genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchApp_xpath",driver));

		Thread.sleep(5000);

		genericKeywords.mouseHoverJScript(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath",driver));

		Thread.sleep(5000);

		genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath",driver);

		Thread.sleep(5000);

		genericKeywords.jsClick(genericKeywords.locateElement("designerStudioPageOENBAADrpDwnlistSwitchAppAdvisor_xpath",driver));



	}



}