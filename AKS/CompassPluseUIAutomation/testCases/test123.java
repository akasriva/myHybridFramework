package testCases;

 

import java.io.IOException;

import java.util.HashMap;

import java.util.LinkedList;

import java.util.List;

 

import com.codoid.products.exception.FilloException;

 

public class test123 {

 

              public static HashMap<String,String> requestMap(String param1,String param2 ,String param3,String val1,String val2 ,String val3){

                             HashMap<String,String> req=new  HashMap<String,String>();

                             try {

                                           req.put(param1,val1);

                                           req.put(param2, val2);

                                           req.put(param3, val3);

                             }catch(Exception e) {

                                           e.getStackTrace();

                             }

                             return req;

 

              }

 

              public static HashMap<String,Object> childMap(String param1,String param2 ,String param3,String val1,String val2 ,String val3){

                             HashMap<String,Object> req=new  HashMap<String,Object>();

                             try {

                                           req.put(param1,val1);

                                           req.put(param2, val2);

                                           req.put(param3, val3);

                             }catch(Exception e) {

                                           e.getStackTrace();

                             }

                             return req;

              }

             

              public static HashMap<String,Object> requestMapReuse(){

                             HashMap<String,Object>            req =new  HashMap<String,Object>();

                             try {

                                           req.put("msisdn", "447777777777");

                                           List<HashMap<String,Object>> childList=new LinkedList<HashMap<String,Object>>();

                                           HashMap<String,Object> map1=childMap("id","Outcome"," outcomeDateTime","A_3456789", "Accepted" ,"2020-08-24T18:50:00Z");

                                           childList.add(map1);

                                           HashMap<String,Object> map2=childMap("id","Outcome"," outcomeDateTime","A_3456789", "Accepted" ,"2020-08-24T18:50:00Z");

                                           childList.add(map2);

                                           HashMap<String,Object> map3=childMap("id","Outcome"," outcomeDateTime","A_3456789", "Accepted" ,"2020-08-24T18:50:00Z");

                                           childList.add(map3);

                                           req.put("nextBestActions", childList);

 

              }catch(Exception e) {

                                           e.getStackTrace();

                             }

                             return req;

 

              }

             

             

             

 

             

              public static HashMap<String,Object> requestMap1(){

                             HashMap<String,Object>            req =new  HashMap<String,Object>();

                             try {

                                           req.put("msisdn", "447777777777");

                                           List<HashMap<String,Object>> childList=new LinkedList<HashMap<String,Object>>();

                                           HashMap<String,Object> map1=new  HashMap<String,Object>();

                                           map1.put("id", "A_3456789");

                                           map1.put("Outcome", "Accepted");

                                           map1.put("outcomeDateTime", "2020-08-24T18:50:00Z");

                                           childList.add(map1);

                                           HashMap<String,Object> map2=new  HashMap<String,Object>();

                                           map2.put("id1", "value1");

                                           map2.put("id2", "value2");

                                           map2.put("id3", "value3");

                                           map2.put("id4", "value4");

                                           childList.add(map2);

                                          

                                           HashMap<String,Object> map3=new  HashMap<String,Object>();

                                           map3.put("id1", "value1");

                                           map3.put("id2", "value2");

                                           map3.put("id3", "value3");

                                           map3.put("id4", "value4");

                                           childList.add(map3);

                                          

                                           req.put("nextBestActions", childList);

 

 

                             }catch(Exception e) {

                                           e.getStackTrace();

                             }

                             return req;

 

              }            

             

              public static HashMap<String,Object> bookMarkReq(){

                             HashMap<String,Object>            req =new  HashMap<String,Object>();

                             try {

                                           req.put("msisdn", "447777777777");

                                           req.put("Brand", "EE");

                                           req.put("Channel", "EE_SHOP");

                                           req.put("context", "Upgracde");

                                           HashMap<String,Object> childaddons=new  HashMap<String,Object>();                      

                                           childaddons.put("id","SW3456");

                                           childaddons.put("saveDateTime","2020-08-25T17:15:00");

                                          

                                           HashMap<String,Object> childTariffs=new  HashMap<String,Object>();

                                           childTariffs.put("id","X2078654");

                                           childTariffs.put("saveDateTime","2020-08-25T17:15:00");

                                           childTariffs.put("addons", childaddons);

                                          

                                           HashMap<String,Object> childBookMarks=new  HashMap<String,Object>();

                                           childBookMarks.put("type","Device");

                                           childBookMarks.put("id","000000000300000355");

                                           childBookMarks.put("saveDateTime", "2020-08-25T17:15:00");

                                           childBookMarks.put("parentCEC", "A51");

                                           childBookMarks.put("tariffs", childTariffs);

                            

                                           req.put("bookmarks", childBookMarks);

 

                             }catch(Exception e) {

                                           e.getStackTrace();

                             }

                             return req;

 

              }            

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

public static void main(String[] args) throws IOException, InterruptedException, FilloException {

 

//System.out.println(generics.excelReusablesUI.getTCNameFromExcel(fileName, sheetname));

              String value=generics.excelReusablesUI.readRestRequestParametes("gwsRestAssuredRequestParameters.xlsx","reqParam","tc1","simo");

              System.out.println("value="+value);

 

}

 

}