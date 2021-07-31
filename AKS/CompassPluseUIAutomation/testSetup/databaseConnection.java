package testSetup;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.LinkedList;

import java.util.List;



public class databaseConnection  {



	public static Connection conn=null;

	public static PreparedStatement pst=null;

	public static ResultSet rs=null;





	public static void main(String[] args) {



		LinkedHashMap<String,LinkedList<String>> tableDataInMap=new LinkedHashMap<String,LinkedList<String>>();



		Connection conn=null;

		PreparedStatement pst=null;

		ResultSet rs=null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn=DriverManager.getConnection("jdbc:oracle:thin:@bct14722003-scan-oravip.dci.bt.com:61901/pega8t_any","SRIVAA42","Hb_9ekGM8OU");

			System.out.println("DataConnection Established Successfuly");

			String sql="select bill_accnt_num,service_id,service_num,product_code from CUS_OMNI_DATA_CS2.svoc_product_holding where rownum <=4";



			//String sql="select service_num from CUS_OMNI_DATA_CS2.svoc_product_holding where source_system ='EE'and PRODUCT_DESC like '%PAYM%' and bill_accnt_num='167680648'";

			pst=conn.prepareStatement(sql);

			rs=pst.executeQuery();

			// to get the Column count





			//List<databaseConnection> list=new ArrayList<databaseConnection>();

			databaseConnection data=null;



			LinkedHashMap<Integer,ArrayList<String>> rowWiseDbMap=new LinkedHashMap<Integer,ArrayList<String>>();

			ArrayList<String> list=null;

			int clmCount=rs.getMetaData().getColumnCount();

			System.out.println("Number of colums in the table="+clmCount);

			//int rowCount=rs.getInt(1);

			//System.out.println("Number of rows in the table="+rowCount);

			//To get the Row Count

			//rs.next();

			//rs.last();//this will move the record set to Last row

			int rowCount=rs.getRow();//this will reterive the current row number

			System.out.println("Number of colums in the table="+rowCount);

			//rs.beforeFirst();//this will bring us back to firt row



			//int i=1;

			while(rs.next()) {

				int rowNum=rs.getRow();



				for(int i=1;i<=4;i++)

				{

					list=new ArrayList<String>();      

					String ban=rs.getString("bill_accnt_num");

					String ser_id=rs.getString("service_id");

					String ser_num=rs.getString("service_num");

					String code=rs.getString("product_code");

					list.add(ban);

					list.add(ser_id);

					list.add(ser_num);

					list.add(code);

				}

				rowWiseDbMap.put(rowNum, list);



				//String data = rs.getString(columnName);

				//System.out.println("Fetching data by column index for row " + data);

				//System.out.println("Fetching data by column index for row " + rs.getRow() + " : " + data);

				//rs.relative(i);

				//data = rs.getString(columnName);

				//System.out.println("Fetching data by column name for row " + rs.getRow() + " : " + data);



				//System.out.println(rs.getInt(1));

				//conn.close();

			}

			System.out.println("Table map List"+rowWiseDbMap);

			conn.close();

		}catch (Exception e) {

			e.printStackTrace();

		}

	}



}