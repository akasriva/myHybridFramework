package generics;



import java.util.ArrayList;

import java.util.Iterator;

import java.util.LinkedHashMap;

import java.util.LinkedHashSet;

import java.util.LinkedList;

import java.util.Set;



import com.relevantcodes.extentreports.LogStatus;



import testSetup.modifyXmlFile;

import testSetup.postRequestAndFetchResponse;

import testSetup.reportDirectory;



public class validateWebserviceWithUi {



	public static String proxy_host="proxy.intra.bt.com",PORT="8080",baseURI=http://pegaccpdev-marketing-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/Services, baseURInew=http://pegasit2-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/Services;





		public static boolean validateStatusCode(String requestFileName,String endPointUrl) {

		int statusCode=0;

		statusCode=postRequestAndFetchResponse.getStatusCode(requestFileName,endPointUrl);

		if(statusCode!=200) {

			System.out.println("Error Response,Status code ="+statusCode);

			reportDirectory.test.log(LogStatus.FAIL, "Status code is="+statusCode);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Status code is="+statusCode);

			return false;



		}else {

			System.out.println("Correct Response,Status code ="+statusCode);

			reportDirectory.test.log(LogStatus.PASS, "Status code is="+statusCode);

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Status code is="+statusCode);

			return true;

		}

	}



	public static void             validateGetEarlyupgradeFeeWithUI(String responseFilename,String requestFilename,String endPointUrl,String earlyupgradeFeeFromUI){

		String earlyUpgradeFeeFromResponse=null;

		String tagname=null;

		boolean statusCode = validateStatusCode(requestFilename,endPointUrl);

		//It will fetch the response and write it to xmlfile

		postRequestAndFetchResponse.writeResponseToXmlfile(responseFilename,requestFilename,endPointUrl);



		//If status code is true/ flase read the response

		if(statusCode==false) {

			tagname=modifyXmlFile.getValueByTagNameFromXmlfile("getEarlyUpgradeFee_Response","soap:Fault","faultstring");

			reportDirectory.test.log(LogStatus.FAIL, "Error Response"+tagname);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Error Response"+tagname);



		}else {

			earlyUpgradeFeeFromResponse=modifyXmlFile.getValueByTagNameFromXmlfile("getEarlyUpgradeFee_Response","message","upgradeFeeInPence");



			if(earlyupgradeFeeFromUI.equalsIgnoreCase(earlyUpgradeFeeFromResponse)) {

				System.out.println("Early upgrade fee Validation is passed");

				reportDirectory.test.log(LogStatus.PASS, "Early upgrade fee of UI is same as the Early upgrade fee generated from getEarlyupgrade webservice ,EUF="+earlyUpgradeFeeFromResponse);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Early upgrade fee of UI is same as the Early upgrade fee generated from getEarlyupgrade webservice ,EUF="+earlyUpgradeFeeFromResponse);

			}else {

				System.out.println("Early upgrade fee Validation is failed");

				reportDirectory.test.log(LogStatus.FAIL, "Early upgrade fee in UI is different from generated from response,EUF_webservice="+earlyUpgradeFeeFromResponse+"EUF_UI="+earlyupgradeFeeFromUI);

				reportDirectory.test_consolidated.log(LogStatus.FAIL,"Early upgrade fee in UI is different from generated from response,EUF_webservice="+earlyUpgradeFeeFromResponse+"EUF_UI="+earlyupgradeFeeFromUI);

			}

		}

	}



	public static void             validateGetUpgradeFeeWithUI(String responseFilename,String requestFilename,String endPointUrl,String upgradeFeeFromUI){

		String upgradeFeeFromResponse=null;

		String tagname=null;

		boolean statusCode = validateStatusCode(requestFilename,endPointUrl);

		//It will fetch the response and write it to xmlfile

		postRequestAndFetchResponse.writeResponseToXmlfile(responseFilename,requestFilename,endPointUrl);



		//If status code is true/ flase read the response

		if(statusCode==false) {

			tagname=modifyXmlFile.getValueByTagNameFromXmlfile(responseFilename,"soap:Fault","faultstring");

			reportDirectory.test.log(LogStatus.FAIL, "Error Response "+tagname);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Error Response "+tagname);



		}else {

			upgradeFeeFromResponse=modifyXmlFile.getValueByTagNameFromXmlfile(responseFilename,"message","upgradeFee");

			if(upgradeFeeFromUI.equalsIgnoreCase(upgradeFeeFromResponse)) {

				System.out.println("Upgrade fee Validation is passed");

				reportDirectory.test.log(LogStatus.PASS, "Upgrade fee of UI is same as the upgrade fee generated from getupgrade webservice ,SUF="+upgradeFeeFromResponse);

				reportDirectory.test_consolidated.log(LogStatus.PASS, "Upgrade fee of UI is same as the upgrade fee generated from getupgrade webservice ,SUF="+upgradeFeeFromResponse);

			}else {

				System.out.println("Upgrade fee Validation is failed");

				reportDirectory.test.log(LogStatus.FAIL, "Upgrade fee in UI is different from generated from response,SUF_webservice="+upgradeFeeFromResponse+" ,EUF_UI="+upgradeFeeFromUI);

				reportDirectory.test_consolidated.log(LogStatus.FAIL, "Upgrade fee in UI is different from generated from response,SUF_webservice="+upgradeFeeFromResponse+" ,EUF_UI="+upgradeFeeFromUI);

			}

		}

	}



	public static void             validateGetDealWithUI(String responseFilename,String requestFilename,String endPointUrl,LinkedHashMap<String,ArrayList<String>> captureDataFromInteractionHistory){

		Set<String> offersNameFromService= new LinkedHashSet<String>();





		String offerNamefromUi=null;

		String tagname=null;

		boolean statusCode = validateStatusCode(requestFilename,endPointUrl);

		//captureDataFromInteractionHistory.remove("TradeIn Apple iPhone 6 64GB Value: £10 EUF discount Upfront discount Remainder");                                  

		LinkedList<String> uiOfferList=new LinkedList<String>();

		LinkedList<String> responseOfferList=new LinkedList<String>();

		//Converting key set into list//

		Set<String> keys = captureDataFromInteractionHistory.keySet();

		for(String s:keys) {

			uiOfferList.add(s);

		}

		System.out.println("uiOfferList="+uiOfferList);

		String uiTarrif=uiOfferList.get(0);

		String uiHandset=uiOfferList.get(1);

		String uiMobileAddOn=uiOfferList.get(2);

		String uiMobileDiscount=uiOfferList.get(3);

		String uiOffer=null;



		//It will fetch the response and write it to xmlfile

		postRequestAndFetchResponse.writeResponseToXmlfileGetDeal(responseFilename,requestFilename,endPointUrl);

		//If status code is true/ flase read the response

		if(statusCode==false) {

			tagname=modifyXmlFile.getValueByTagNameFromXmlfile(requestFilename,"soap:Fault","faultstring");

			reportDirectory.test.log(LogStatus.FAIL, "Error Response "+tagname);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Error Response "+tagname);

		}else {

			offersNameFromService=modifyXmlFile.getValueByTagNameGetDealFromXmlfile(responseFilename,"dealItem","offerName");

			for(String s:offersNameFromService) {

				responseOfferList.add(s);

			}

			System.out.println("responseOfferList="+responseOfferList);



			for(int j=0;j<responseOfferList.size();j++) {

				int flag=0;

				String responseOffer=responseOfferList.get(j).replace("and", "&");

				for(int i=0;i<uiOfferList.size();i++) {

					uiOffer=uiOfferList.get(i).replace("£", "");

					if(uiOffer.contains(responseOffer)) {

						System.out.println("Deal offer Validation is passed");

						reportDirectory.test.log(LogStatus.PASS, "Offer in UI is same as the offer fetched  from getDeal webservice ,offername="+responseOffer);

						reportDirectory.test_consolidated.log(LogStatus.PASS, "Offer in UI is same as the offer fetched  from getDeal webservice ,offername="+responseOffer);

						flag++;

						break;

					}

				}             if(flag==0) {

					System.out.println("offer Validation is failed");

					reportDirectory.test.log(LogStatus.FAIL, "Offer in UI is different form getDeal webservice ,ResponseOffername_="+responseOffer);

					reportDirectory.test_consolidated.log(LogStatus.FAIL, "Offer in UI is different form getDeal webservice ,ResponseOffername_="+responseOffer);

				}

			}

		}

		/*Iterator i = offersNameFromService.iterator();

                             while (i.hasNext()) {

                                           String offername=(String) i.next();          

                                           System.out.println(i.next());

                                           if(keys.contains(offername)) {

                                                          System.out.println("Deal offer Validation is passed");

                                                          reportDirectory.test.log(LogStatus.PASS, "Offer in UI is same as the offer fetched  from getDeal webservice ,offername="+offername);

                                                         reportDirectory.test_consolidated.log(LogStatus.PASS, "Offer in UI is same as the offer fetched  from getDeal webservice ,offername="+offername);

                                           }else {

                                                          System.out.println("offer Validation is failed");

                                                          reportDirectory.test.log(LogStatus.FAIL, "Offer in UI is different as the offer fetched  from getDeal webservice ,offername_="+offername);

                                                         reportDirectory.test_consolidated.log(LogStatus.FAIL, "Offer in UI is different from offer captured from response,offersNotFound="+offername);

                                           }

                             }*/

	}





	public static String validateGetDealListWithUI(String responseFilename,String requestFilename,String endPointUrl){

		String caseId =null;

		String tagname=null;



		boolean statusCode = validateStatusCode(requestFilename,endPointUrl);

		//It will fetch the response and write it to xmlfile

		postRequestAndFetchResponse.writeResponseToXmlfile(responseFilename,requestFilename,endPointUrl);



		//If status code is true/ flase read the response

		if(statusCode==false) {

			tagname=modifyXmlFile.getValueByTagNameFromXmlfile(requestFilename,"soap:Fault","faultstring");

			reportDirectory.test.log(LogStatus.FAIL, "Error Response "+tagname);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,"Error Response "+tagname);



		}else {

			caseId=modifyXmlFile.getValueByTagNameFromXmlfile(requestFilename,"message","caseId");

			System.out.println("Case id="+caseId);

			reportDirectory.test.log(LogStatus.PASS, "Case Id from getDeallist ,getDeallist="+caseId);

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Case Id from getDeallist ,getDeallist="+caseId);

			return caseId;

		}

		return caseId;

	}



	public static void main(String[] args) {



		LinkedHashMap<String,ArrayList<String>> captureDataFromInteractionHistory = new LinkedHashMap<String,ArrayList<String>>();

		ArrayList<String> ar1 = new ArrayList<String>();

		ArrayList<String> ar2 = new ArrayList<String>();

		ArrayList<String> ar3 = new ArrayList<String>();

		ArrayList<String> ar4 = new ArrayList<String>();

		ArrayList<String> ar5 = new ArrayList<String>();

		ar1.add("one");

		ar2.add("two");

		ar3.add("three");

		ar4.add("four");

		ar5.add("five");



		captureDataFromInteractionHistory.put("Ess Plan 1GB 17", ar1);

		captureDataFromInteractionHistory.put("GOOGLE PIXEL 3A XL", ar2);

		captureDataFromInteractionHistory.put("Spend Cap 20", ar3);

		captureDataFromInteractionHistory.put("offer4", ar4);

		captureDataFromInteractionHistory.put("offer5", ar5);



		//modifyParticularElementOfXmlfile("getUpgradeFee_Request","message","msisdn","447415982219");

		//Modify the Request XML

		//modifyXmlFile.modifyParticularElementOfXmlfile("getEarlyUpgradeFee_Request","message","msisdn","447510302073");

		//need to copy the new request in the test case folder.

		//validateStatusCode("getEarlyUpgradeFee_Request",baseURI);

		//validateGetUpgradeFeeWithUI("getUpgradeFee_Response","getUpgradeFee_Request",baseURInew,"0");

		validateGetDealWithUI("getDeal_Response","getDeal_Request",baseURInew,captureDataFromInteractionHistory);



	}



}