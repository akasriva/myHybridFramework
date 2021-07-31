package generics;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.util.Date;

import java.util.Enumeration;

import java.util.List;

import java.util.NoSuchElementException;

import java.util.Properties;

import java.util.Set;

import java.util.concurrent.TimeUnit;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.NoSuchFrameException;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.GeckoDriverInfo;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;



import components.Generics;

import testSetup.masterSet;

import testSetup.userExceptionMsg;



public class genericKeywords {

	private static final String Null = null;

	public static Properties pro;

	public static WebDriver driver;  

	public static WebElement element;

	public static List <WebElement> listOfelements;





	/*

	 * Below function reads the data form Properties file

	 * It does not take any parameters

	 *

	 * @param

	 * @param

	 * @author  Akarshit Srivastava

	 * @since   14-Feb-2020

	 */        



	public static void propertiesFile() throws IOException

	{

		try{

			pro = new Properties();

			FileInputStream datafile = new FileInputStream(System.getProperty("user.dir")+\\data.properties);

			pro.load(datafile);

		}

		catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}



	/*

	 * Below function iterates over keys from Properties file and gives locator type

	 * It does not take any parameters

	 * @param

	 * @param

	 * @author  Akarshit Srivastava

	 * @since   14-Feb-2020

	 */        



	public static  String readKeyvalueFromPropertiesfile() throws IOException

	{

		String locatorType = null;

		propertiesFile();

		Enumeration<String> enums = (Enumeration<String>) pro.propertyNames();

		while (enums.hasMoreElements())

		{

			String key=enums.nextElement();



			String[] splitKey=key.split("_");

			locatorType=splitKey[1];

			System.out.println("locatorType = "+locatorType   );

		}

		return locatorType;

	}



	/*

	 * Below function returns all the key from the from Properties file 

	 * It does not take any parameters

	 * @param

	 * @param

	 * @author  Akarshit Srivastava

	 * @since   14-Feb-2020

	 */        

	public static Set<Object> getAllKeysFromPropertiesFile() throws IOException

	{

		propertiesFile();

		Set<Object> keys = pro.keySet();

		return keys;

	}            

	/*

	 * Below function returns the Locator type and Locator Value

	 * It takes one parameters

	 *

	 * @param String key

	 *

	 *

	 * @author  Akarshit Srivastava

	 * @since   19-Feb-2020

	 */        

	public static String getLocatorTypeFromPropertiesfile(String key) throws IOException

	{

		propertiesFile();



		String locatorType=Null;

		String[] splitKey=key.split("_");

		locatorType = splitKey[1];

		// System.out.println("locatorType = "+locatorType   );

		// String locatorValue=pro.getProperty(key);       

		return locatorType;

	}



	/*

	 * Below function selects the particular browser

	 * It take two parameter

	 * @param String Browser

	 * @param String Key

	 * @author  Akarshit Srivastava

	 * @since   14-Feb-2020

	 */        



	public static WebDriver selectBrowser(String browser,String key) throws InterruptedException, IOException

	{

		String path="D:\\Drivers\\";

		propertiesFile();



		String Url=pro.getProperty(key);



		switch (browser)

		{

		case "chrome" :              

			System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");

			driver=new ChromeDriver();

			//System.out.println("url is"+pro.getProperty(key));

			break;



		case "geckodriver" :

			System.setProperty("webdriver.gecko.driver", path+"geckodriver.exe");

			driver= (WebDriver) new FirefoxDriver();

			break;

		case "edge" :

			System.setProperty("webdriver.edge.driver", path+"MicrosoftWebDriver.exe");

			driver=  new EdgeDriver();

			break;



		case "ie":

			//System.setProperty("webdriver.ie.driver", path+"IEDriverServer.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();



			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");

			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

			System.setProperty("webdriver.ie.driver", path+"IEDriverServer.exe");



			driver = new InternetExplorerDriver();

			//driver=new InternetExplorerDriver();

			// Setting IE to clean session

			/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

                             capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

                                           driver =new InternetExplorerDriver(capabilities);*/

			break;

		}



		//System.out.println("url is :"+key);

		//driver.get(key);

		//driver.get(http://www.google.com);



		System.out.println("url is :"+Url);

		driver.get(Url);

		driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");

		//System.out.println("url is :"+Url);

		driver.manage().window().maximize();

		return driver;



	}







	public static WebElement locateElement(String key,WebDriver driver) throws IOException

	{

		String locatorType=getLocatorTypeFromPropertiesfile(key);

		String locatorValue=pro.getProperty(key);

		//System.out.println("locatorType = "+locatorType   );

		//System.out.println("locatorValue = "+locatorValue  );

		switch (locatorType)

		{

		case "id":

			element =driver.findElement(By.id(locatorValue));

			//System.out.println("locatorType = Id"+locatorType);

			break;

		case "className":

			element=driver.findElement(By.className(locatorValue));

			//           System.out.println("locatorType = className"+locatorType);

			break;

		case "linkText":

			element=driver.findElement(By.linkText(locatorValue));

			//System.out.println("locatorType = linkText"+locatorType);

			break;

		case "name":

			element=driver.findElement(By.name(locatorValue));

			//System.out.println("locatorType = name"+locatorType);

			break;

		case "xpath":

			element=driver.findElement(By.xpath(locatorValue));

			//System.out.println("locatorType = xpath"+locatorType);

			break;



		case "css":

			element=driver.findElement(By.cssSelector(locatorValue));

			//           System.out.println("locatorType = CSS"+locatorType);

			break;



		}

		return element;

	}



	/*

	 * Below function returns the List of webelements

	 * It takes two parameters

	 * @param String key

	 * @param Webdriver driver

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */        



	public static List<WebElement> locateElements(String key,WebDriver driver) throws IOException

	{

		String locatorType=getLocatorTypeFromPropertiesfile(key);

		String locatorValue=pro.getProperty(key);

		//System.out.println("locatorType = "+locatorType   );

		//System.out.println("locatorValue = "+locatorValue  );

		switch (locatorType)

		{

		case "id":

			listOfelements =driver.findElements(By.id(locatorValue));

			//System.out.println("locatorType = Id"+locatorType);

			break;

		case "className":

			listOfelements=driver.findElements(By.className(locatorValue));

			//System.out.println("locatorType = className"+locatorType);

			break;

		case "linkText":

			listOfelements=driver.findElements(By.linkText(locatorValue));

			//System.out.println("locatorType = linkText"+locatorType);

			break;

		case "name":

			listOfelements=driver.findElements(By.name(locatorValue));

			//System.out.println("locatorType = name"+locatorType);

			break;

		case "xpath":

			listOfelements=driver.findElements(By.xpath(locatorValue));

			//System.out.println("locatorType = xpath"+locatorType);

			break;



		}

		return listOfelements;



	}

	/*

	 * Below function sends text to the textbox t 

	 * It takes two parameters

	 * @param WebElement element

	 * @param String text

	 * @author  Akarshit Srivastava

	 * @since   19-Feb-2020

	 */        



	public static void sendTextValue(WebElement element,String text)throws userExceptionMsg

	{

		try{

			element.sendKeys(text);

			//throw new userExceptionMsg("Unable to sent to write text in" +element);

		}

		catch(Exception e)

		{

			System.out.println(e.getMessage());

		}

	}

	/*

	 * Below function click on the webelement 

	 * It takes one parameters

	 *

	 * @param WebElement element

	 *

	 * @author  Akarshit Srivastava

	 * @since   19-Feb-2020

	 */        

	public static void clickElement(WebElement element)

	{

		try{

			element.click();



			try{

				WebDriverWait wait = new WebDriverWait(driver, 5);

				wait.until(ExpectedConditions.elementToBeClickable(element));

			}

			catch(Exception e1){

				System.out.println(e1.getMessage());

			}}

		catch(Exception e2){

			element.click();

		}





	}

	/*

	 * Below function will wait for the webelement to be visible 

	 * It takes two parameters

	 *

	 * @param WebElement element

	 * @param integer time

	 *

	 * @author  Akarshit Srivastava

	 * @since   19-Feb-2020

	 */        

	public static void waitExplicit(WebElement element,int time)

	{

		WebDriverWait wait = new WebDriverWait(driver,time);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}



	public static void waitExplicitUntilTextVisibl(int time,WebElement element,String matchingText)

	{

		WebDriverWait wait = new WebDriverWait(driver,time);

		wait.until(ExpectedConditions.textToBePresentInElement(element,matchingText));

	}



	public static boolean waitUntilElementIsDisplayed(int time,WebElement element)

	{

		WebDriverWait wait = new WebDriverWait(driver,time);

		//wait.until(ExpectedConditions.elementToBeSelected(element));

		boolean status=element.isDisplayed();

		return status;

	}



	public static boolean waitUntilElementIsClickable(int time,WebElement element)

	{

		WebDriverWait wait = new WebDriverWait(driver,time);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		boolean status=wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();

		return status;

	}

	/*

	 * Below function will select the one option from dropdpwn based on the selection type (value/visibleText/index) 

	 * It takes three parameters

	 * @param WebElement element

	 * @param String selectionType-(value/visibleText/index)

	 * @param String selectionValue-Should be String in all the cases

	 * @author  Akarshit Srivastava

	 * @since   19-Feb-2020

	 */



	public static void selectFromDropdown(WebElement element,String selectionType,String selectionValue)

	{

		Select s = new Select(element); 

		try{

			switch (selectionType)

			{

			case "value" :

				s.selectByValue(selectionValue);

				break;

			case "visibleText" :

				s.selectByVisibleText(selectionValue);

				break;

			case "index" :

				int valueIndex=Integer.parseInt(selectionValue);

				s.selectByIndex(valueIndex);

				break;

				//throw new userExceptionMsg("Unable to select the option from drop down");

			}



		}

		catch(Exception e)

		{

			System.out.println(e.getMessage());      



		}



	}



	/*

	 * Below function will return true if the webelement is present and false if webelement is not present

	 * @param WebElement element

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */



	public static boolean isElementPresent(WebElement element) {

		boolean flag = false;

		try {

			if (element.isDisplayed()|| element.isEnabled())

				flag = true;

		} catch (NoSuchElementException e) {

			flag = false;

		} catch (StaleElementReferenceException e) {

			flag = false;

		}

		return flag;

	}



	/*

	 * Below function will do mouse hover to the element which is passed as the parameter

	 * @param WebElement element

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */

	public static void mouseHoverJScript(WebElement element) {

		try {

			if (isElementPresent(element)) {



				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";



				((JavascriptExecutor) driver).executeScript(mouseOverScript,

						element);



			} else {

				System.out.println("Element was not visible to hover " + "\n");



			}

		} catch (StaleElementReferenceException e) {

			System.out.println("Element with " + element

					+ "is not attached to the page document"

                                                                        + e.getStackTrace());

		} catch (NoSuchElementException e) {

			System.out.println("Element " + element + " was not found in DOM"

                                                                        + e.getStackTrace());

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println("Error occurred while hovering"

                                                                        + e.getStackTrace());

		}

	}            

	/*

	 * Below function will give no of frames in the webpage

	 *

	 * @param WebElement element

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */



	public static int noOfFrames(WebElement element)

	{

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframeResult"));

		return iframeElements.size();

	}



	/*

	 * Below function will switch to frame based on the switch type i.e index/id in the webpage

	 * @param String switchBy

	 * @param String indexId

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */

	public static void swithFrames(String switchBy, String indexId)

	{

		switch(switchBy){

		case "index" :

			int frameIndex=Integer.parseInt(indexId);

			try {

				driver.switchTo().frame(frameIndex);

			} catch (NoSuchFrameException e) {

				System.out.println("Unable to locate frame with index " + frameIndex+ e.getStackTrace());

			} catch (Exception e) {

				System.out.println("Unable to navigate to frame with id " + frameIndex+ e.getStackTrace());

			}

			break;

		case "id" :

			try {

				driver.switchTo().frame(indexId);

			} catch (NoSuchFrameException e) {

				System.out.println("Unable to locate frame with id " + indexId + e.getStackTrace());

			} catch (Exception e) {

				System.out.println("Unable to navigate to frame with id " + indexId+ e.getStackTrace());

			}

			break;

		}



	}





	public static void swithFrames(WebElement frameElement)

	{

		try {

			if (isElementPresent(frameElement)) {

				driver.switchTo().frame(frameElement);

				System.out.println("Navigated to frame with element "+ frameElement);

			} else {

				System.out.println("Unable to navigate to frame with element "+ frameElement);

			}

		} catch (NoSuchFrameException e) {

			System.out.println("Unable to locate frame with element " + frameElement + e.getStackTrace());

		} catch (StaleElementReferenceException e) {

			System.out.println("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());

		} catch (Exception e) {

			System.out.println("Unable to navigate to frame with element " + frameElement + e.getStackTrace());

		}

	}



	/*

	 * Below function will click the webelement using javaScript

	 * @param WebElement element

	 * @param String indexId

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */

	public static void jsClick(WebElement element)

	{

		JavascriptExecutor executor = (JavascriptExecutor)driver;

		executor.executeScript("arguments[0].click();", element);



	}



	/*

	 * Below function will hilight the webelement using javaScript

	 * @param WebElement element

	 * @author  Akarshit Srivastava

	 * @since   25-Feb-2020

	 */

	public static void hilightElement(WebElement element,WebDriver driver)

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	}



	/*

	 * Below function will return current system date and time

	 * @param

	 * @return String

	 * @author  Akarshit Srivastava

	 * @since   25-05-2020

	 */

	public static String captureCurrentSystemDateTime() {

		String dateTimeOfAction = null;

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm a"); 

		Date date = new Date(); 

		dateTimeOfAction=formatter.format(date);

		System.out.println(formatter.format(date));

		return dateTimeOfAction;

	}



	/*

	 * Below function will return current system date and time

	 *

	 * @param String dateOfActionOnDeal

	 * @param String validateDateIntrHist

	 * @return void

	 * @author  Akarshit Srivastava

	 * @since   27-05-2020

	 */

	public static void timeValidation(String date1, String date2) {

		try {

			//date captured from interaction history validateDateIntrHist

			String splitter2[]=date2.split(" ");

			String time2=splitter2[1];

			String timeSplit2[]=time2.split(":");

			int hour2=Integer.parseInt(timeSplit2[0]);

			int min2=Integer.parseInt(timeSplit2[1]);

			System.out.println("hour2="+hour2+" Min2="+min2);

			//date captured after clicking on submit validateDateIntrHist      

			String splitter1[]=date1.split(" ");

			String time1=splitter1[1];

			System.out.println(time1);

			String timeSplit1[]=time1.split(":");

			int hour1=Integer.parseInt(timeSplit1[0]);

			int min1=Integer.parseInt(timeSplit1[1]);

			System.out.println("hour1="+hour1+" Min1="+min1 );

			int diffHour=hour2-hour1;

			int diffMin=min2-min1;



			if(diffHour<=1){

				System.out.println("Proceed to check min= "+diffHour);

				if(diffMin<=2)  

					System.out.println("Date validation Passed="+date1);

				else

					System.out.println("Date validation Failed excepted date ="+date1+" Actual date="+date2);

			}else

				System.out.println("Intraction history is not updeted excepted date ="+date1+" Actual date="+date2);

		}catch (Exception e) {

			e.printStackTrace();

		}

	}



	public static void captureScreenShots(WebDriver driver,String fileWithPath) throws IOException {





		TakesScreenshot scrShot =((TakesScreenshot) driver);



		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);



		File DestFile=new File(fileWithPath);



		FileUtils.copyFileToDirectory(SrcFile, DestFile);



	}





	/*

	 * Below function will capture the screenshot wherever its called

	 * @param WebDriver

	 * @param String fileWithPath

	 * @param String nameOfThe screenshot

	 * @author  Devi Das

	 * @since   29-May-2020

	 */

	public static String captureScreenShots_new(WebDriver driver,String fileWithPath,String fileName) throws IOException {



		String timeStamp=Generics.getTimestamp();

		fileName=fileName+"_"+timeStamp+".png";

		String directory=fileWithPath;

		File SrcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(SrcFile, new File(directory + fileName));

		String DestFile=directory + fileName;



		return DestFile;

	}



	public static void scrollDown(WebElement element,WebDriver driver) {



		JavascriptExecutor je = (JavascriptExecutor) driver;

		je.executeScript("arguments[0].scrollIntoView(true);",element);

	}

	/*

	 * Below function will copy the file with string data to given folder.This method accept 4 parameters

	 * @param folderName

	 * @param String fileName

	 * @param String fileType

	 * @param String dataToBeWritten

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */

	public static void copyDataTofile(String filePath,String folderName,String fileName,String fileType,String dataToBeWritten ) {

		try {

			FileWriter fw=new FileWriter(".\\"+filePath+"\\"+folderName+"\\"+fileName+"."+fileType);  



			fw.write(dataToBeWritten);   

			fw.close();   

			System.out.println("File written successfully");

		} catch (IOException e) {

			System.out.println("Unable to write the file");

			System.out.println(e.getStackTrace());

		}

	}



	/*

	 * Below function will return the method name in String format

	 * @param String dataToBeWritten

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */

	public static String getMethodName() {

		String nameofCurrMethod = new Exception()

				.getStackTrace()[0]

						.getMethodName();



		System.out.println("Name of current method: "+ nameofCurrMethod);

		return nameofCurrMethod;



	}





}