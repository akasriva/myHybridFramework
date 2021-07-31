package generics;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;



import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import com.codoid.products.exception.FilloException;

import com.codoid.products.fillo.Connection;

import com.codoid.products.fillo.Fillo;

import com.codoid.products.fillo.Recordset;

import com.relevantcodes.extentreports.LogStatus;



import testSetup.reportDirectory;



public class excelReusablesUI {



	public static Workbook workBook;

	private static Sheet sheetname;

	private static Sheet sheet;

	static int numOfRows, numOfRows2;

	static int numOfCols;

	static int numrow;

	static int numCol;

	static ArrayList<String> arrayList_tcName, requestDataList;

	private static String str;

	public static String filepath="//DataSheet//";

	public static String filename1="UI_TcExecutionData.xlsx";

	private static ArrayList<String> entrydataList;

	private static LinkedHashMap entrydataMap;



	/*

	 * Below function accepts argument sheetname

	 * If available it returns TC Name

	 * @param sheetname

	 * @return ArrayList<String>

	 * @author  Devi Das

	 * @since   05-Dec-2019

	 */

	public static ArrayList<String> readTCNameFromExcel(String sheetname) throws IOException{                          



		File file=new File(System.getProperty("user.dir")+filepath+filename1);

		FileInputStream inputStream=new FileInputStream(file);

		workBook=new XSSFWorkbook(inputStream);

		sheet=workBook.getSheet(sheetname);

		numOfRows=sheet.getLastRowNum();  

		numOfCols=sheet.getRow(0).getPhysicalNumberOfCells();

		arrayList_tcName = new ArrayList<String>();                     

		for(int j=1; j<numOfRows+1; j++){

			String flagValue=sheet.getRow(j).getCell(0).getStringCellValue();

			if(flagValue.equals("Y")){

				str=sheet.getRow(j).getCell(1).getStringCellValue();                                                   

				arrayList_tcName.add(str);

			}

		}

		return arrayList_tcName;

	}



	/*

	 * Below function accepts argument sheetname

	 * @param sheetname

	 * @return requestDataList

	 * @author Devi Das

	 * @throws InterruptedException

	 * @throws FilloException

	 * @since 05-Dec-2019

	 */





	public static LinkedHashMap<String, String> read_entryDataSheetFromExcel

	(String testcasename)

			throws IOException, InterruptedException, FilloException{                



		Recordset rowWiseData = null;

		Connection connection = null;

		entrydataMap=new LinkedHashMap<>();

		String path = new File(System.getProperty("user.dir"))+filepath+filename1;

		Fillo fillo = new Fillo();



		try{                                    

			connection = fillo.getConnection(path);

			rowWiseData = connection.executeQuery("Select * from entryDataSheet where TestCaseName='"+testcasename+"'");



			while(rowWiseData.next()){

				entrydataMap.put("Flag", rowWiseData.getField("Flag"));

				entrydataMap.put("TestCaseName", rowWiseData.getField("TestCaseName"));

				entrydataMap.put("ScenarioType", rowWiseData.getField("ScenarioType"));

				entrydataMap.put("Browser", rowWiseData.getField("Browser"));

				entrydataMap.put("Url", rowWiseData.getField("Url"));

				entrydataMap.put("Username", rowWiseData.getField("Username"));

				entrydataMap.put("Password", rowWiseData.getField("Password"));

				entrydataMap.put("CompassPlusteam", rowWiseData.getField("CompassPlusteam"));

				entrydataMap.put("Ctn", rowWiseData.getField("Ctn"));

				entrydataMap.put("ManufacturerBrand", rowWiseData.getField("ManufacturerBrand"));

				entrydataMap.put("DeviceColor", rowWiseData.getField("DeviceColor"));

				entrydataMap.put("Row#_SelectPlan", rowWiseData.getField("Row#_SelectPlan"));

				entrydataMap.put("BasketPage_Deal1_Accept/Decline/UnderConsideration", rowWiseData.getField("BasketPage_Deal1_Accept/Decline/UnderConsideration"));

				entrydataMap.put("BasketPage_Deal2_Accept/Decline/UnderConsideration", rowWiseData.getField("BasketPage_Deal2_Accept/Decline/UnderConsideration"));

				entrydataMap.put("Reason#_Decline/UnderConsideration", rowWiseData.getField("Reason#_Decline/UnderConsideration"));

				entrydataMap.put("BasketPage_Submit/Close/Edit/Delete", rowWiseData.getField("BasketPage_Submit/Close/Edit/Delete"));

			}

		}catch(FilloException e){

			e.printStackTrace();

		}finally{

			rowWiseData.close();

			connection.close();

		}



		return entrydataMap;                 

	}

	/*

	 * Below function return the request parameters values by passing parameter name

	 * @param String sheetname

	 * @param String fileName

	 * @param String testcaseName

	 * @param String paramName

	 * @return StringValue

	 * @author Akarshit

	 * @throws InterruptedException

	 * @throws FilloException

	 * @since   20-Feb-2021

	 */

	public static  String readRestRequestParametes(String fileName, String sheetName,String testcasename,String paramName)

			throws IOException, InterruptedException, FilloException{                



		Recordset tcWiseData = null;

		Connection connection = null;

		String value=null;

		requestDataList=new ArrayList<String>();

		String path = new File(System.getProperty("user.dir"))+filepath+fileName+".xlsx";

		Fillo fillo = new Fillo();

		try{                                    

			connection = fillo.getConnection(path);

			tcWiseData = connection.executeQuery("Select * from "+sheetName+" where testCaseName='"+testcasename+"'");

			while(tcWiseData.next()){

				value=tcWiseData.getField(paramName);

			}

		}catch(FilloException e){

			e.printStackTrace();

		}finally{

			tcWiseData.close();

			connection.close();

		}

		return value;                   

	}



	/*

	 * Below function return the execution flag when user will pass testcase

	 * @param String testcaseName

	 * @return final boolean

	 * @author Akarshit

	 * @throws InterruptedException

	 * @throws FilloException

	 * @since   20-Feb-2021

	 */

	public static final boolean readFlag(String testcasename)

			throws IOException, InterruptedException, FilloException{                



		Recordset tcWiseData = null;

		Connection connection = null;

		String value = null;

		final boolean flagBoolean;

		requestDataList=new ArrayList<String>();

		String path = new File(System.getProperty("user.dir"))+filepath+"gwsRestAssuredRequestParameters.xlsx";

		Fillo fillo = new Fillo();

		try{                                    

			connection = fillo.getConnection(path);

			tcWiseData = connection.executeQuery("Select * from executionFlag where testCaseName='"+testcasename+"'");

			while(tcWiseData.next()){

				value=tcWiseData.getField("Flag");

			}

		}catch(FilloException e){

			e.printStackTrace();

		}finally{

			tcWiseData.close();

			connection.close();

		}

		flagBoolean=Boolean.parseBoolean(value);

		return flagBoolean;                     

	}



	/*

	 * Below function will insert the data in column if user will provide test case Name and column name to insert the value.

	 * @param String fileName

	 * @param String sheetName

	 * @param String testcasename

	 * @param String colmunName

	 * @param String value

	 * @return void

	 * @author  Akarshit

	 * @throws InterruptedException

	 * @throws FilloException

	 * @since   10-Feb-2021

	 */

	public static void insertResponseParametes(String fileName, String sheetName,String testcasename,String colmunName,String value)

			throws IOException, InterruptedException, FilloException{                



		//int tcWiseData = null;

		Connection connection = null;



		requestDataList=new ArrayList<String>();

		String path = new File(System.getProperty("user.dir"))+filepath+fileName+".xlsx";

		Fillo fillo = new Fillo();

		try{                                    

			connection = fillo.getConnection(path);

			//INSERT INTO sheetName(columnName)Values(value) where testCaseName='"+testcasename+"'"

			connection.executeUpdate("UPDATE "+sheetName+" Set "+colmunName+"="+value+" where testCaseName='"+testcasename+"'");

			System.out.println("Value inserted in the excel file");

			reportDirectory.test.log(LogStatus.PASS, "Value inserted in the excel file");

			reportDirectory.test_consolidated.log(LogStatus.PASS,"Value inserted in the excel file");

		}catch(FilloException e){

			System.out.println("Unable to insert the data to file");

			reportDirectory.test.log(LogStatus.FAIL, "Unable to insert the data to file");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to insert the data to file");

			e.printStackTrace();

		}/*finally{

                                           tcWiseData.close();

                                           connection.close();

                             }*/

	}

	/*



              /*

	 * Below function accepts argument sheetname

	 * If available it returns TC Name

	 * @param sheetname

	 * @return ArrayList<String>

	 * @author  Devi Das

	 * @since   05-Dec-2019

	 */

	public static ArrayList<String> getTCNameFromExcel(String fileName,String sheetname) throws IOException{                          



		File file=new File(System.getProperty("user.dir")+filepath+fileName);

		FileInputStream inputStream=new FileInputStream(file);

		workBook=new XSSFWorkbook(inputStream);

		sheet=workBook.getSheet(sheetname);

		numOfRows=sheet.getLastRowNum();  

		numOfCols=sheet.getRow(0).getPhysicalNumberOfCells();

		arrayList_tcName = new ArrayList<String>();                     

		for(int j=1; j<numOfRows+1; j++){

			String flagValue=sheet.getRow(j).getCell(0).getStringCellValue();

			str=sheet.getRow(j).getCell(1).getStringCellValue();                                                         

			arrayList_tcName.add(str);

		}



		return arrayList_tcName;

	}



}