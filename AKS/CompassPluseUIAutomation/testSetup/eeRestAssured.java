package testSetup;



import java.io.IOException;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.LinkedList;

import java.util.List;

import java.util.Map;



import com.codoid.products.exception.FilloException;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.relevantcodes.extentreports.LogStatus;



import generics.genericKeywords;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;



public class eeRestAssured {



	/*

	 * Below functiion will return the request in jason format

	 * It take parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   12-April-2021

	 */        

	public static HashMap<String,String> inLifePPUpsellRequest(String msisdn,String channel,String brand){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);



			reportDirectory.test.log(LogStatus.PASS, "inLifePPUpsellRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}







	/*

	 * Below function will return the StoreBookmarkItems request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,Object> storeBookmarkItemsRequest(String msisdn,String channel,String brand,

			String context,String id,String savedDateTime,String parentCEC){

		HashMap<String, Object> requestParams=new HashMap<String,Object>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("context",context);



			LinkedList<HashMap<String,Object>> bookMarkList=new LinkedList<HashMap<String,Object>>();

			HashMap<String, Object> bookMarkChild=new HashMap<String,Object>();

			bookMarkChild.put("type","Device");

			bookMarkChild.put("id",id);

			bookMarkChild.put("saveDateTime",savedDateTime);

			bookMarkChild.put("parentCEC",parentCEC);

			bookMarkList.add(bookMarkChild);



			LinkedList<HashMap<String,Object>> tariffsList=new LinkedList<HashMap<String,Object>>();

			HashMap<String, Object> tariffskChild=new HashMap<String,Object>();

			tariffskChild.put("id","X18I24H03");

			tariffskChild.put("savedDateTime",savedDateTime);

			tariffsList.add(tariffskChild);



			LinkedList<HashMap<String,Object>> addonsList=new LinkedList<HashMap<String,Object>>();

			HashMap<String, Object> addonsChild=new HashMap<String,Object>();

			addonsChild.put("id","YBCDT12GB");

			addonsChild.put("savedDateTime",savedDateTime);

			addonsList.add(addonsChild);

			tariffskChild.put("addons", addonsList);

			bookMarkChild.put("tariffs", tariffsList);

			requestParams.put("bookmarks",bookMarkList);



			//System.out.println("requestParams="+requestParams);

			reportDirectory.test.log(LogStatus.PASS, "getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+

					"<br />brand="+brand+"<br />context="+context+"<br />id="+id+"<br />savedDateTime="+savedDateTime+

					"<br />parentCEC="+parentCEC);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getRecommendationRequest parameters are <br />msisdn="+msisdn+

					"<br />channel="+channel+"<br />brand="+brand+"<br />context="+context+"<br />id="+id+

					"<br />savedDateTime="+savedDateTime+"<br />parentCEC="+parentCEC);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}



	/*

	 * Below functiion will return the request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   26-Feb-2021

	 */        

	public static HashMap<String,String> retriveBookmarks(String msisdn,String channel,String brand,String context){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("context",context);

			reportDirectory.test.log(LogStatus.PASS, "getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand+"<br />context="+context);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand+"<br />context="+context);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}



	/*

	 * Below functiion will return the request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,String> eufRequest(String msisdn,String channel,String brand,String sourceTrancId){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("sourceTransactionId",sourceTrancId);

			reportDirectory.test.log(LogStatus.PASS, "getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}

	/*

	 * Below function will return the GetAvgTopUp request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,String> getAvgTopUpRequest(String msisdn,String channel,String brand){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);



			reportDirectory.test.log(LogStatus.PASS, "getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getEarlyUpgradeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}



	/*

	 * Below function will return the getDeviceList request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,String> getDeviceList(String requestId,String channel,String brand){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("requestId",requestId);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);



			reportDirectory.test.log(LogStatus.PASS, "getDeviceList parameters are <br />msisdn="+requestId+"<br />channel="+channel+"<br />brand="+brand);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getDeviceList parameters are <br />msisdn="+requestId+"<br />channel="+channel+"<br />brand="+brand);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}



	/*

	 * Below function will return the getUpgradeFee              request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,String> getUpgradeFee(String msisdn,String channel,String brand,String upgradeType){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("upgradeType",upgradeType);

			reportDirectory.test.log(LogStatus.PASS, "getUpgradeFeeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand+"<br />upgradeType="+upgradeType);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getUpgradeFeeRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand+"<br />upgradeType="+upgradeType);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}



	/*

	 * Below functiion will return the getRecommendation request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,String> getRecommendationRequest(String msisdn,String channel,String brand,String sourceTrancId,String simo){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("sourceTransactionId",sourceTrancId);

			requestParams.put("simo",simo);

			reportDirectory.test.log(LogStatus.PASS, "getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand+"<br />simo="+simo);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />simo="+simo);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}

	public static HashMap<String,String> getRecommendationRequest1(String msisdn,String channel,String brand,String sourceTrancId,String simo,String selectedAtricleId){

		HashMap<String,String> requestParams=new HashMap<String,String>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("sourceTransactionId",sourceTrancId);

			requestParams.put("simo",simo);

			requestParams.put("selectedAtricleId",selectedAtricleId);

			reportDirectory.test.log(LogStatus.PASS, "getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />brand="+brand+"<br />simo="+simo);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+"<br />simo="+simo);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}



	/*

	 * Below functiion will return the captureResponse request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,Object> capturResponseRequest(String msisdn,String id,String outcome,String outcomeDateTime){

		HashMap<String, Object> requestParams=new HashMap<String,Object>() ;

		try {

			requestParams.put("msisdn",msisdn);

			HashMap<String, String> child=new HashMap<String,String>() ;

			child.put("id",id);

			child.put("outcome",outcome);

			child.put("outcomeDateTime",outcomeDateTime);

			requestParams.put("nextBestActions",child);

			//System.out.println("requestParams="+requestParams);

			reportDirectory.test.log(LogStatus.PASS, "getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />id="+id+"<br />outcome="+outcome);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />id="+id+"<br />outcome="+outcome);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}

	/*

	 * Below function will return the categoryListMap request

	 * It take 4 parameter

	 * @return LinkedList<HashMap<String,Object> request

	 * @author  Akarshit Srivastava

	 * @since   16-Feb-2021

	 */                       

	public static LinkedList<HashMap<String,Object>> categoryListMap(String HANDSET,String WATCH,String TABLET,String SIMO,String MBB){



		LinkedList<HashMap<String,Object>> childList=new LinkedList<HashMap<String,Object>>();



		HashMap<String,Object> childMap1= new HashMap<String,Object>() ;

		childMap1.put("category", HANDSET);

		childList.add(childMap1);

		HashMap<String,Object> childMap2= new HashMap<String,Object>() ;

		childMap2.put("category", WATCH);

		childList.add(childMap2);

		HashMap<String,Object> childMap3= new HashMap<String,Object>() ;

		childMap3.put("category", TABLET);

		childList.add(childMap3);

		HashMap<String,Object> childMap4= new HashMap<String,Object>() ;

		childMap4.put("category", SIMO);

		childList.add(childMap4);

		HashMap<String,Object> childMap5= new HashMap<String,Object>() ;

		childMap5.put("category", MBB);

		childList.add(childMap5);



		return childList;

	}

	/*

	 * Below function will return the rulesListMap request

	 * It take 4 parameter

	 * @return LinkedList<HashMap<String,Object> request

	 * @author  Akarshit Srivastava

	 * @since   16-Feb-2021

	 */                        

	public static LinkedList<HashMap<String,Object>> rulesListMap(String EssentialPlansOnly){



		LinkedList<HashMap<String,Object>> childList=new LinkedList<HashMap<String,Object>>();



		HashMap<String,Object> childMap1= new HashMap<String,Object>() ;

		childMap1.put("rule", EssentialPlansOnly);

		childList.add(childMap1);

		return childList;

	}

	/*

	 * Below function will return the final request request

	 * It take 6 parameter

	 * @return LinkedList<HashMap<String,Object> request

	 * @author  Akarshit Srivastava

	 * @since   16-Feb-2021

	 */                        

	public static HashMap<String,Object> maxNextBestAction(String msisdn,String channel,String brand,String sourceTransactionID,

			String journeyType,int remainingMRC,String manufacturer,String model,String selectedArticleId,String HANDSET,String WATCH,String TABLET,String SIMO,String MBB,int maxNextBestActions,int maxRelatedNextBestActions,

			String EssentialPlansOnly,String UpFrontCost,String CheapestPlanOnly,String SmartPlansOnly){



		HashMap<String,Object> finalRequest=new HashMap<String,Object>();

		LinkedList<HashMap<String,Object>> childList=rulesListMap(EssentialPlansOnly);

		LinkedList<HashMap<String,Object>> categoryListMap=categoryListMap(HANDSET,WATCH,TABLET,SIMO,MBB);



		finalRequest.put("msisdn", msisdn);

		finalRequest.put("brand", brand);

		finalRequest.put("channel", channel);

		finalRequest.put("sourceTransactionID", sourceTransactionID);

		finalRequest.put("journeyType", journeyType);

		finalRequest.put("remainingMRC", remainingMRC);

		HashMap<String,String> childMap=new HashMap<String,String>();

		childMap.put("manufacturer",manufacturer);

		childMap.put("model",model);

		childMap.put("selectedArticleId",selectedArticleId);

		finalRequest.put("deviceInformation", childMap);

		finalRequest.put("productCategories", categoryListMap);

		finalRequest.put("maxNextBestActions", maxNextBestActions);

		finalRequest.put("maxRelatedNextBestActions", maxRelatedNextBestActions);

		finalRequest.put("rules", childList);



		return finalRequest;

	}



	/*

	 * Below function will return the upgradeAddLineRecommendation request request

	 * It take 6 parameter

	 * @return LinkedList<HashMap<String,Object> request

	 * @author  Akarshit Srivastava

	 * @since   16-Feb-2021

	 */                        

	public static HashMap<String,Object> upgradeAddLineRecommendation(String msisdn,String channel,String brand,String sourceTransactionID,

			String journeyType,int remainingMRC,String manufacturer,String model,String selectedArticleId,String HANDSET,String WATCH,String TABLET,String SIMO,String MBB,int maxNextBestActions,int maxRelatedNextBestActions,

			String EssentialPlansOnly){



		HashMap<String,Object> finalRequest=new HashMap<String,Object>();

		LinkedList<HashMap<String,Object>> childList=rulesListMap(EssentialPlansOnly);

		LinkedList<HashMap<String,Object>> categoryListMap=categoryListMap(HANDSET,WATCH,TABLET,SIMO,MBB);



		finalRequest.put("msisdn", msisdn);

		finalRequest.put("brand", brand);

		finalRequest.put("channel", channel);

		finalRequest.put("sourceTransactionId", sourceTransactionID);

		finalRequest.put("journeyType", journeyType);

		finalRequest.put("remainingMRC", remainingMRC);

		HashMap<String,String> childMap=new HashMap<String,String>();

		childMap.put("manufacturer",manufacturer);

		childMap.put("model",model);

		childMap.put("selectedArticleId",selectedArticleId);

		finalRequest.put("deviceInformation", childMap);

		finalRequest.put("productCategories", categoryListMap);

		finalRequest.put("maxNextBestActions", maxNextBestActions);

		finalRequest.put("maxRelatedNextBestActions", maxRelatedNextBestActions);

		finalRequest.put("rules", childList);



		return finalRequest;

	}



	/*

	 * Below function will return the inlifeAddLineRecommendation request request

	 * It take 6 parameter

	 * @return LinkedList<HashMap<String,Object> request

	 * @author  Akarshit Srivastava

	 * @since   16-Feb-2021

	 */                        

	public static HashMap<String,Object> inlifeAddLineRecommendation(String msisdn,String channel,String brand,String sourceTransactionID,

			String journeyType,String HANDSET,String WATCH,String TABLET,String SIMO,String MBB,int maxNextBestActions,int maxRelatedNextBestActions,

			String EssentialPlansOnly){



		HashMap<String,Object> finalRequest=new HashMap<String,Object>();

		LinkedList<HashMap<String,Object>> childList=rulesListMap(EssentialPlansOnly);

		LinkedList<HashMap<String,Object>> categoryListMap=categoryListMap(HANDSET,WATCH,TABLET,SIMO,MBB);



		finalRequest.put("msisdn", msisdn);

		finalRequest.put("brand", brand);

		finalRequest.put("channel", channel);

		finalRequest.put("sourceTransactionId", sourceTransactionID);

		finalRequest.put("journeyType", journeyType);

		finalRequest.put("productCategories", categoryListMap);

		finalRequest.put("maxNextBestActions", maxNextBestActions);

		finalRequest.put("maxRelatedNextBestActions", maxRelatedNextBestActions);

		finalRequest.put("rules", childList);



		return finalRequest;

	}





	/*

	 * Below function will return the captureResponse request in jason format

	 * It take no parameter

	 * @return Hash map request

	 * @author  Akarshit Srivastava

	 * @since   05-Feb-2021

	 */        

	public static HashMap<String,Object> getTradeInValue(String msisdn,String channel,String brand,String imei,

			String make,String model,String memoryVariant,String deviceswitchOn,

			String damagetoCasing,String damagetoDisplay,String damagetoportsorButton){

		HashMap<String, Object> requestParams=new HashMap<String,Object>() ;

		try {

			requestParams.put("msisdn",msisdn);

			requestParams.put("channel",channel);

			requestParams.put("brand",brand);

			requestParams.put("imei",imei);

			requestParams.put("make",make);

			requestParams.put("model",model);

			requestParams.put("memoryVariant",memoryVariant);

			HashMap<String, String> child=new HashMap<String,String>();

			child.put("deviceswitchOn",deviceswitchOn);

			child.put("damagetoCasing",damagetoCasing);

			child.put("damagetoDisplay",damagetoDisplay);

			child.put("damagetoportsorButton",damagetoportsorButton);  

			requestParams.put("deviceconditionDetail",child);

			//System.out.println("requestParams="+requestParams);

			reportDirectory.test.log(LogStatus.PASS, "getRecommendationRequest parameters are <br />msisdn="+msisdn+"<br />channel="+channel+

					"<br />brand="+brand+"<br />imei="+imei+"<br />make="+make+"<br />model="+model+

					"<br />memoryVariant="+memoryVariant);

			reportDirectory.test_consolidated.log(LogStatus.PASS,"getRecommendationRequest parameters are <br />msisdn="+msisdn+

					"<br />channel="+channel+"<br />brand="+brand+"<br />imei="+imei+"<br />make="+make+

					"<br />model="+model+"<br />memoryVariant="+memoryVariant);



		}catch(Exception e){

			System.out.println(e.getStackTrace());  

			reportDirectory.test.log(LogStatus.FAIL, "Unable to create request");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to created request");



		}

		return requestParams;

	}





	/*

	 * Below function will convert map request into jason fromat

	 * It take no parameter

	 * @param Hash map request

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */        

	public static String convertMapToJson(HashMap<String,String> elements) {

		//public static void convertMapToJson() {

		String json=null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			json = objectMapper.writeValueAsString(elements);

			System.out.println(json);

			//reportDirectory.test.log(LogStatus.PASS, "Request converted to json successfully");

			//reportDirectory.test_consolidated.log(LogStatus.PASS,"Request converted to json successfully");



		} catch (JsonProcessingException e) {

			//reportDirectory.test.log(LogStatus.FAIL, "Unable to converted to json the request");

			//reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to converted to json the request");

			e.printStackTrace();

		}

		return json;

	}

	/*

	 * Below function will convert map request into jason fromat

	 * It take no parameter

	 * @param Hash map request

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */        

	public static String convertMapToJsonObject(HashMap<String,Object> elements) {

		//public static void convertMapToJson() {

		String json=null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			json = objectMapper.writeValueAsString(elements);

			System.out.println(json);

			//reportDirectory.test.log(LogStatus.PASS, "Request converted to json successfully");

			//reportDirectory.test_consolidated.log(LogStatus.PASS,"Request converted to json successfully");



		} catch (JsonProcessingException e) {

			//reportDirectory.test.log(LogStatus.FAIL, "Unable to converted to json the request");

			//reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to converted to json the request");

			e.printStackTrace();

		}

		return json;

	}



	/*

	 * Below method returns the response when json request and nextbest action is passed

	 * It take no parameter

	 * @param Hash map request

	 * @param String nextBestAction

	 * @return response

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */

	public static Response getRestResponse(HashMap<String,String> requestParams,String nextBestAction) {

		RestAssured.baseURI =https://pegasit2-advisor.nat.bt.com/prweb/PRRestService/Decisioning/v1/next-best-action;

			RequestSpecification request = RestAssured.given();

		Response response=null;

		try {

			response =RestAssured.given().auth().preemptive()

					.basic("extsystemuser", "rules").relaxedHTTPSValidation()

					.header("Accept", ContentType.JSON.getAcceptHeader())

					.contentType(ContentType.JSON)

					.body(requestParams)

					.post(nextBestAction)

					.then().extract().response();

			System.out.println("Response fetched");

			//reportDirectory.test.log(LogStatus.PASS, "Response generated successfully");

			//reportDirectory.test_consolidated.log(LogStatus.PASS,"Response generated successfully");

		}catch(Exception e) {

			System.out.println("Response is not fetched");

			//reportDirectory.test.log(LogStatus.FAIL, "Unable to fetch the Response");

			//reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to fetch the Response");

			e.printStackTrace();

		}

		return response;

	}



	/*

	 * Below method returns the response when json request and nextbest action is passed

	 * It take no parameter

	 * @param Hash map request

	 * @param String nextBestAction

	 * @return response

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */

	public static Response getRestResponseObj(HashMap<String,Object> requestParams,String nextBestAction) {

		RestAssured.baseURI =https://pegasit2-advisor.nat.bt.com/prweb/PRRestService/Decisioning/v1/next-best-action;

			RequestSpecification request = RestAssured.given();

		Response response=null;

		try {

			response =RestAssured.given().auth().preemptive()

					.basic("extsystemuser", "rules").relaxedHTTPSValidation()

					.header("Accept", ContentType.JSON.getAcceptHeader())

					.contentType(ContentType.JSON)

					.body(requestParams)

					.post(nextBestAction)

					.then().extract().response();

			System.out.println("Response fetched");

			//reportDirectory.test.log(LogStatus.PASS, "Response generated successfully");

			//reportDirectory.test_consolidated.log(LogStatus.PASS,"Response generated successfully");

		}catch(Exception e) {

			System.out.println("Response is not fetched");

			//reportDirectory.test.log(LogStatus.FAIL, "Unable to fetch the Response");

			//reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to fetch the Response");

			e.printStackTrace();

		}

		return response;

	}





	/*

	 * Below method will return single value form the Json.

	 * It take 2 parameter

	 * @param Response response

	 * @param String key

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */

	public static String fetchValueFromResponse(Response response,String key) {

		String value=null;

		try {

			value=response.jsonPath().getString(key);

			System.out.println("value fetched="+value);

			reportDirectory.test.log(LogStatus.PASS, "value fetched "+key+"="+value);

			reportDirectory.test_consolidated.log(LogStatus.PASS, "value fetched "+key+"="+value);

		}catch(Exception e) {

			System.out.println("Unable to fetch the value");

			reportDirectory.test.log(LogStatus.FAIL, "Unable to fetch the value");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to fetch the value");

			e.printStackTrace();

		}

		return value;

	}



	/*

	 * Below method will return single value form the Json.for child nodes by giving index

	 * It take 2 parameter

	 * @param Response response

	 * @param String parentNode

	 * @param String key

	 * @param index key

	 * @return String

	 * @author  Akarshit Srivastava

	 * @since   08-Feb-2021

	 */

	public static String fetchValueFromResponseArray(Response response,String parentNode,String key,int index) {

		List<Map<String,String>> child=response.jsonPath().getList(parentNode);

		String value=null;

		try {

			value=child.get(index).get(key);

			System.out.println("value fetched="+value);

			reportDirectory.test.log(LogStatus.PASS,key+"="+value);

			reportDirectory.test_consolidated.log(LogStatus.PASS, key+"="+value);



		}catch(Exception e) {

			System.out.println("unable to fetch the value");

			reportDirectory.test.log(LogStatus.FAIL, "Unable to fetch the value");

			reportDirectory.test_consolidated.log(LogStatus.FAIL, "Unable to fetch the value");

			e.printStackTrace();

		}

		return value;

	}





	public static void main(String[] args) throws IOException, InterruptedException, FilloException {

		//End point Url//+

		/*                         RestAssured.baseURI =https://pegasit2-advisor.nat.bt.com/prweb/PRRestService/Decisioning/v1/next-best-action;

                             RequestSpecification request = RestAssured.given();



                             //JSONObject is a class that represents a Simple JSON.

                             //We can add Key - Value pairs using the put method

                             //JSONObject requestParams = new JSONObject();



                             //Jason Request //

                             HashMap<String,String> requestParams=new HashMap<String,String>() ;

                             requestParams.put("msisdn", "447932091709");

                             requestParams.put("channel", "EE_SHOP");

                             requestParams.put("brand", "EE");

                             requestParams.put("sourceTransactionId", "34567ERTYUI");





                             //Fetch Response and Print in string format//

                             Response response =RestAssured.given().auth().preemptive()

                                                          .basic("extsystemuser", "rules").relaxedHTTPSValidation()

                                                          .header("Accept", ContentType.JSON.getAcceptHeader())

                                                          .contentType(ContentType.JSON)

                                                          .body(requestParams)

                                                          .post("/euf")

                                                          .then().extract().response();



                             //Fetch the status code//

                             int statusCode = response.getStatusCode();

                             System.out.println("The status code recieved: " + statusCode);

                             System.out.println("Response body: " + response.body().asString());

		 */

		String fileName="gwsRestAssuredRequestParameters";

		String sheetName="captureResponse";

		/*          String msisdn=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc2", "msisdn");

                  String channel=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc2", "channel");

                             String brand=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc2", "brand");

                             String std=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc2", "sourceTransactionId");

		 */         

		String msisdn=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc29_gwsCaptureResponse", "msisdn");

		String id=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc29_gwsCaptureResponse", "id");

		String outcome=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc29_gwsCaptureResponse", "outcome");

		String outcomeDateTime=generics.excelReusablesUI.readRestRequestParametes(fileName, sheetName, "tc29_gwsCaptureResponse", "outcomeDateTime");



		HashMap<String,Object> requestMap=capturResponseRequest(msisdn,id,outcome,outcomeDateTime);

		String jason=convertMapToJsonObject(requestMap);

		System.out.println("jason="+jason);





		//generics.genericKeywords.copyDataTofile("123","EERestRequest", "testfile1", "json", jason);

		Response rr=getRestResponseObj(requestMap,"/-3751363009996167495/history");

		int statusCode = rr.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + rr.body().asString());

		//List<Map<String,String>> nextBestActions = rr.jsonPath().getList("nextBestActions");

		//           System.out.println(nextBestActions.get(5).get("id"));







	}            



}