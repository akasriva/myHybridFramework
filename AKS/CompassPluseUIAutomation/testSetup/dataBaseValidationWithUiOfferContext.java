package testSetup;

 

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.LinkedHashMap;

 

import com.relevantcodes.extentreports.LogStatus;

 

public class dataBaseValidationWithUiOfferContext extends dbconnectionMethods {

              public static Connection conn=null;

              public static PreparedStatement pst=null;

              public static ResultSet rs=null;

 

              //public void dbValidationOfferContextWithUi() {

              public void dbValidationOfferContextWithUi(String ctn,String UiDealType,String UiOldDevice,String UiNewDevice) {

                             LinkedHashMap<Integer,ArrayList<String>> rowWiseDbResultMap=new LinkedHashMap<Integer,ArrayList<String>>();

                             String sql="select ID,contract_end_date_old,deal_type,handset_old,handset_new from PEGA_MKT_EXT_OWNER_CS2.offer_context where \r\n" +

                                                          "service_num = '"+ctn+"' and deal_type = 'UP' and ROWNUM<=2 order by create_date DESC";

                             System.out.println("before Try");

                             try {

 

                                           conn=connectOrecalDataBase("SRIVAA42","Kb_9ekGM8OU");

                                           rs=getResultFromQuery(conn,sql);

                                           rowWiseDbResultMap=tableData(rs);

                                           conn.close();

                                           //ArrayList<String> rowData=null;

                                           String dbdealtype=rowWiseDbResultMap.get(1).get(2);

                                           System.out.println("dealtype="+dbdealtype);

                                           String dbOldDevice=rowWiseDbResultMap.get(1).get(3);

                                           System.out.println("dbOldDevice="+dbOldDevice);

                                           String dbNewDevice=rowWiseDbResultMap.get(1).get(4);

                                           System.out.println("dbNewDevice="+dbNewDevice);

                                           if(UiDealType.equals(dbdealtype)) {

                                                          System.out.println("Deal type in Ui and data base is same, Deal type="+dbdealtype);

                                                         reportDirectory.test.log(LogStatus.PASS,"Deal type in Ui and data base is same, Deal type="+dbdealtype);

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Deal type in Ui and data base is same, Deal type="+dbdealtype);   

                                           }else {

                                                          System.out.println("Deal type is different in Ui and Data base, UidealType="+UiDealType+" DbDealtype="+dbdealtype);

                                                         reportDirectory.test.log(LogStatus.FAIL,"Deal type is different in Ui and Data base, UidealType="+UiDealType+" DbDealtype="+dbdealtype);

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Deal type is different in Ui and Data base, UidealType="+UiDealType+" DbDealtype="+dbdealtype);      

                                           }

                                           if(UiOldDevice.equalsIgnoreCase(dbOldDevice)) {

                                                          System.out.println("Old Device in Ui and data base is same, Deal type="+dbOldDevice);

                                                          reportDirectory.test.log(LogStatus.PASS, "Old Device in Ui and data base is same, Deal type="+dbOldDevice);

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Old Device in Ui and data base is same, Deal type="+dbOldDevice);

                                           }else {

                                                          System.out.println("Old Device is different in Ui and Data base, UiOldDevice="+UiOldDevice+" dbOldDevice="+dbOldDevice);

                                                         reportDirectory.test.log(LogStatus.FAIL,"Old Device is different in Ui and Data base, UiOldDevice="+UiOldDevice+" dbOldDevice="+dbOldDevice);

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Old Device is different in Ui and Data base, UiOldDevice="+UiOldDevice+" dbOldDevice="+dbOldDevice);  

 

                                           }

                                           if(UiNewDevice.contains(dbNewDevice)) {

                                                          System.out.println("New Device in Ui and data base is same, Deal type="+dbNewDevice);

                                                          reportDirectory.test.log(LogStatus.PASS, "New Device in Ui and data base is same, Deal type="+dbNewDevice);

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "New Device in Ui and data base is same, Deal type="+dbNewDevice);

                                           }else {

                                                          System.out.println("New Device is different in Ui and Data base, UiNewDevice="+UiNewDevice+" dbNewDevice="+dbNewDevice);

                                                         reportDirectory.test.log(LogStatus.FAIL,"New Device is different in Ui and Data base, UiNewDevice="+UiNewDevice+" dbNewDevice="+dbNewDevice);

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "New Device is different in Ui and Data base, UiNewDevice="+UiNewDevice+" dbNewDevice="+dbNewDevice);            

                                           }

 

                                           /*for(int i=1;i<rowWiseDbResultMap.size();i++) {

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

                                           }*/

 

                             }catch (Exception e) {

                                           System.out.println("Unable to see the data from table");

                                           reportDirectory.test.log(LogStatus.FAIL,"Unable to see the data from table");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to see the data from table");          

                                           e.printStackTrace();

                             }

              }

             

              public void TestdbValidationOfferContextWithUi(String ctn,String UiDealType,String UiOldDevice,String UiNewDevice) {

                             LinkedHashMap<Integer,ArrayList<String>> rowWiseDbResultMap=new LinkedHashMap<Integer,ArrayList<String>>();

                             String sql="select ID,contract_end_date_old,deal_type,handset_old,handset_new from PEGA_MKT_EXT_OWNER_CS2.offer_context where \r\n" +

                                                          "service_num = '"+ctn+"' and deal_type = 'UP' and ROWNUM<=2 order by create_date DESC";

                             try {

 

                                           conn=connectOrecalDataBase("SRIVAA42","Kb_9ekGM8OU");

                                           rs=getResultFromQuery(conn,sql);

                                           rowWiseDbResultMap=tableData(rs);

                                           conn.close();

                                           //ArrayList<String> rowData=null;

                                           String dbdealtype=rowWiseDbResultMap.get(1).get(2);

                                           System.out.println("dealtype="+dbdealtype);

                                           String dbOldDevice=rowWiseDbResultMap.get(1).get(3);

                                           System.out.println("dbOldDevice="+dbOldDevice);

                                           String dbNewDevice=rowWiseDbResultMap.get(1).get(4);

                                           System.out.println("dbNewDevice="+dbNewDevice);

                                           if(UiDealType.equals(dbdealtype)) {

                                                          System.out.println("Deal type in Ui and data base is same, Deal type="+dbdealtype);

                                                          }else {

                                                          System.out.println("Deal type is different in Ui and Data base, UidealType="+UiDealType+" DbDealtype="+dbdealtype);

                                                          }

                                           if(UiOldDevice.equalsIgnoreCase(dbOldDevice)) {

                                                          System.out.println("Old Device in Ui and data base is same, Deal type="+dbOldDevice);

                                                          }else {

                                                          System.out.println("Old Device is different in Ui and Data base, UiOldDevice="+UiOldDevice+" dbOldDevice="+dbOldDevice);

                                                                        }

                                           if(UiNewDevice.contains(dbNewDevice)) {

                                                          System.out.println("New Device in Ui and data base is same, Deal type="+dbNewDevice);

                                           }else {

                                                          System.out.println("New Device is different in Ui and Data base, UiNewDevice="+UiNewDevice+" dbNewDevice="+dbNewDevice);

                                           }

 

                                           /*for(int i=1;i<rowWiseDbResultMap.size();i++) {

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

                                           }*/

 

                             }catch (Exception e) {

                                           System.out.println("Unable to see the data from table");

                                           reportDirectory.test.log(LogStatus.FAIL,"Unable to see the data from table");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to see the data from table");          

                                           e.printStackTrace();

                             }

              }

 

              public static void main(String[] args) {

 

                             ArrayList<String> listUiData=new ArrayList<String>();

                             listUiData.add("5020");

                             listUiData.add("2020-11-10 00:00:00");

                             listUiData.add("UP");

                             listUiData.add("SAMSUNG GALAXY S8 G950F LTE");

                             listUiData.add("APPLE IPHONE 11 64GB Black");

 

                             dataBaseValidationWithUiOfferContext dbv=new dataBaseValidationWithUiOfferContext();

              dbv.TestdbValidationOfferContextWithUi("07415982219","UP","SAMSUNG GALAXY S8 G950F LTE","APPLE IPHONE 11 64GB Black");

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

                                                                        String id=rs3.getString("id");

                                                                        String contract_end_date_old=rs3.getString("contract_end_date_old");

                                                                        String deal_type=rs3.getString("deal_type");

                                                                        String handset_old=rs3.getString("handset_old");

                                                                        String handset_new=rs3.getString("handset_new");

                                                                        list.add(id);

                                                                        list.add(contract_end_date_old);

                                                                        list.add(deal_type);

                                                                        list.add(handset_old);

                                                                        list.add(handset_new);

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