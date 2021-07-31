package testSetup;



import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.LinkedHashMap;



public class dataBaseValidationWithUiIhDImAction extends dbconnectionMethods {



	public static Connection conn=null;

	public static PreparedStatement pst=null;

	public static ResultSet rs=null;



	//public void dbValidationOfferContextWithUi() {

	public void dbValidationWithUiIhDimAction(ArrayList<String> newSelectedDevice) {

		LinkedHashMap<Integer,ArrayList<String>> rowWiseDbResultMap=new LinkedHashMap<Integer,ArrayList<String>>();

		String sql="select pxcreatedatetime,pyissue,pygroup,pyname,pylabel from PEGA_DATA_OWNER_CS2.PR_DATA_IH_DIm_ACTION where pzid in (\r\n" +

                                                          "select distinct (pzactionid) from PEGA_DATA_OWNER_CS2.PR_DATA_IH_FACT where serviceproductidentifier='07415982219')\r\n" +

                                                          "and rownum<=2 order by pxcreatedatetime desc";

		try {

			conn=connectOrecalDataBase("SRIVAA42","Hb_9ekGM8OU");

			rs=getResultFromQuery(conn,sql);

			rowWiseDbResultMap=tableData(rs);

			conn.close();

			//ArrayList<String> rowData=null;

			String daa=rowWiseDbResultMap.get(1).get(0);

			System.out.println("daa="+daa);

			for(int i=1;i<rowWiseDbResultMap.size();i++) {

				//rowData=new ArrayList<String>();

				for(int j=0;j<newSelectedDevice.size();j++) {

					String dbData=rowWiseDbResultMap.get(i).get(j);

					String uiData=newSelectedDevice.get(j);

					if(dbData.equalsIgnoreCase(uiData))

					{

						System.out.println("Db data is matching with Ui data="+dbData);

					}else {

						System.out.println("Db data mismatching with Ui data="+uiData+" Db Data="+dbData);

					}

				}

				break;  

			}



		}catch (Exception e) {

			System.out.println("Unable to va the data from table");

			e.printStackTrace();

		}

	}



	public static void main(String[] args) {



		ArrayList<String> listUiData=new ArrayList<String>();

		listUiData.add("2019-08-23 08:16:44");

		listUiData.add("MobileDevices");

		listUiData.add("MobileDevicesEE");

		listUiData.add("GS10P");

		listUiData.add("SAMSUNG GALAXY S10 PLUS 128GB");



		dataBaseValidationWithUiIhDImAction dbv=new dataBaseValidationWithUiIhDImAction();

		dbv.dbValidationWithUiIhDimAction(listUiData);

	}

	public LinkedHashMap<Integer, ArrayList<String>> tableData(ResultSet rs3) {



		LinkedHashMap<Integer,ArrayList<String>> rowWiseDbMap=new LinkedHashMap<Integer,ArrayList<String>>();

		ArrayList<String> list=null;

		try {

			int clmCount=rs3.getMetaData().getColumnCount();

			System.out.println("Number of colums in the table="+clmCount);

			int rowCount=rs3.getRow();//this will reterive the current row number

			System.out.println("Number of colums in the table="+rowCount);

			while(rs.next()) {

				int rowNum=rs3.getRow();



				for(int i=1;i<=4;i++)

				{

					list=new ArrayList<String>();      

					String pxcreatedatetime=rs3.getString("pxcreatedatetime");

					String pyissue=rs3.getString("pyissue");

					String pygroup=rs3.getString("pygroup");

					String pyname=rs3.getString("pyname");

					String pylabel=rs3.getString("pylabel");

					list.add(pxcreatedatetime);

					list.add(pyissue);

					list.add(pygroup);

					list.add(pyname);

					list.add(pylabel);

				}

				rowWiseDbMap.put(rowNum, list);

			}

			System.out.println("Table map List"+rowWiseDbMap);

			//conn.close();

		}catch (Exception e) {

			System.out.println("Unable to fetch the data from table");

			e.printStackTrace();

		}

		return rowWiseDbMap;

	}



}