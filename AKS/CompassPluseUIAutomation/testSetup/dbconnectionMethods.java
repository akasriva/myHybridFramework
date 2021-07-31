package testSetup;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.List;



import com.relevantcodes.extentreports.LogStatus;



public abstract class dbconnectionMethods {

	public static Connection connectOrecalDataBase(String dbuserName,String dbpassword) throws SQLException, ClassNotFoundException {

		Connection connect=null;

		try {

			//ClassLoader.getSystemClassLoader().setPackageAssertionStatus("oracle.jdbc.driver", false);   

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connect=DriverManager.getConnection("jdbc:oracle:thin:@bct14722003-scan-oravip.dci.bt.com:61901/pega8t_any",dbuserName,dbpassword);

			System.out.println("Data base Connected");

			///reportDirectory.test.log(LogStatus.PASS,"Data Base Connection Established");

			//reportDirectory.test_consolidated.log(LogStatus.PASS, "Data Base Connection Established");    



		}catch (Exception e) {

			System.out.println("Unable to connect database");

			//reportDirectory.test.log(LogStatus.FAIL,"Unable to connect database");

			//              reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to connect database");      

			e.printStackTrace();

		}

		return connect;

	}



	public static ResultSet getResultFromQuery(Connection connect,String sql) throws ClassNotFoundException, SQLException {

		PreparedStatement pst1=null;

		ResultSet rs1=null;

		try {

			//Connection connect= connectOrecalDataBase("SRIVAA42","Hb_9ekGM8OU");

			pst1=connect.prepareStatement(sql);

			rs1=pst1.executeQuery();

		}catch(Exception e) {

			System.out.println("Unable to fetch the result database");

			e.printStackTrace();

		}

		return rs1;   

	}

	public abstract LinkedHashMap<Integer,ArrayList<String>> tableData(ResultSet rs3);            





}