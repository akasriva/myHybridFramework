package testSetup;



import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.StringReader;

import java.io.StringWriter;

import java.io.InputStream;





import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;

import javax.xml.transform.Source;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import javax.xml.transform.stream.StreamSource;



import org.apache.http.HttpEntity;

import org.apache.http.ParseException;

import org.apache.http.auth.AuthScope;

import org.apache.http.auth.UsernamePasswordCredentials;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.CredentialsProvider;

import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.BufferedHttpEntity;

import org.apache.http.entity.InputStreamEntity;

import org.apache.http.impl.client.BasicCredentialsProvider;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

import org.apache.xmlbeans.xml.stream.BufferedXMLInputStream;

import org.testng.Assert;

import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;

import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;



import com.google.api.client.http.HttpResponse;



import io.restassured.response.Response;



public class postRequestAndFetchResponse {







	public static String proxy_host="proxy.intra.bt.com",PORT="8080",baseURI=http://pegaccpdev-marketing-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/Services, baseURInew=http://pegasit2-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/Services;





		/*

		 * Below function will be used to provide username and Password for authentication purpose

		 * Return type is CredentialsProvider

		 * @param accepts 2 Parameters

		 * @String userName

		 * String password

		 * @author  Akarshit Srivastava

		 * @since   01-OCT-2020

		 */

		public static CredentialsProvider basicAuthentication(String userName,String password) {



		CredentialsProvider provider = new BasicCredentialsProvider();

		UsernamePasswordCredentials credentials= new UsernamePasswordCredentials(userName,password);

		provider.setCredentials(AuthScope.ANY, credentials);



		return provider;



	}



	/*

	 * Below function will return the SOAP response from the SOAP request hit on http client

	 * Return type is CloseableHttpResponse

	 * @param accepts 1 Parameters

	 * @String requestXml

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */

	public static CloseableHttpResponse postSoapRequest(String requestXml,String baseURI) {

		CloseableHttpResponse response = null;

		try {

			File requestFile=new File(".\\SoapRequest\\"+requestXml+".xml");

			CredentialsProvider provider=basicAuthentication("extsystemuser","rules");

			CloseableHttpClient client= HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

			HttpPost request=new HttpPost(baseURI);

			request.addHeader("Content-Type", "text/xml");

			HttpEntity entity=new InputStreamEntity(new FileInputStream(requestFile));

			BufferedHttpEntity bEntity=new BufferedHttpEntity(entity);

			request.setEntity(bEntity);

			response=client.execute(request);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return response;



	}

	/*

	 * Below function will return Status code of SOAP response

	 * Return type is integer Status

	 * @param accepts 3 Parameters

	 * @String requestXml

	 * @String userName

	 * String password

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */

	public static int getStatusCode(String requestXmlFileName,String endPointUrl) {



		//CloseableHttpResponse response=              postSoapRequest("getUpgradeFee_Request",baseURI);

		CloseableHttpResponse response=              postSoapRequest(requestXmlFileName,endPointUrl);

		int statuseCode=response.getStatusLine().getStatusCode();

		System.out.println("statuseCode= "+statuseCode);

		//Assert.assertEquals(200,statuseCode);baseUri

		return statuseCode;

	}

	public static String prettyFormat(String input, String indent) {

		Source xmlInput = new StreamSource(new StringReader(input));

		StringWriter stringWriter = new StringWriter();

		try {

			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");

			transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", indent);

			transformer.transform(xmlInput, new StreamResult(stringWriter));



			return stringWriter.toString().trim();

		} catch (Exception e) {

			throw new RuntimeException(e);

		}

	}



	public static String format(String input) {

		return prettyFormat(input, "2");

	}



	/*

	 * Below function will fetch the response in String format

	 * Return type is String

	 * @param accepts no Parameters

	 * @String requestXml

	 * @String userName

	 * String password

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */



	public static String getStringResponse(String requestXmlFileName,String endPointUrl) {

		String responseStr=null;

		String formatedResponse=null;

		try {

			//CloseableHttpResponse response=              postSoapRequest("getUpgradeFee_Request",baseURI);

			CloseableHttpResponse response=              postSoapRequest(requestXmlFileName,endPointUrl);

			responseStr=EntityUtils.toString(response.getEntity(),"UTF-8");

			System.out.println("Response Captured in String formate.");

			formatedResponse=format(responseStr);



		} catch (ParseException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return formatedResponse;



	}

	public static String getStringResponseGetDeal(String requestXmlFileName,String endPointUrl) {

		String responseStr=null;

		String formatedResponse=null;

		String newResponseStr1=null;

		String newResponseStr2=null;

		try {

			//CloseableHttpResponse response=              postSoapRequest("getUpgradeFee_Request",baseURI);

			CloseableHttpResponse response=              postSoapRequest(requestXmlFileName,endPointUrl);

			responseStr=EntityUtils.toString(response.getEntity(),"UTF-8");

			System.out.println("Response Captured in String formate.");

			//newResponseStr1=responseStr.replace("Friends &amp; Family 30% Discount", "Friends and Family 30% Discount");

			newResponseStr1=responseStr.replaceAll("&amp;", "and");

			newResponseStr2=newResponseStr1.replaceAll("£", "");

			formatedResponse=format(newResponseStr2);



		} catch (ParseException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return formatedResponse;



	}





	/*

	 * Below function will write the fetched String response into the XML file

	 * Return type no

	 * @param accepts 1 Parameter1

	 * @String requestXml

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */

	public static void writeResponseToXmlfile(String responseFileName,String requestXmlFileName,String endPointUrl) {

		try {

			FileWriter fw=new FileWriter(".\\SoapRequest\\"+responseFileName+".xml");   

			fw.write(getStringResponse(requestXmlFileName,endPointUrl));   

			fw.close();   

			System.out.println("File written successfully");

		} catch (IOException e) {



			e.printStackTrace();

		}



	}



	public static void writeResponseToXmlfileGetDeal(String responseFileName,String requestXmlFileName,String endPointUrl) {

		try {

			FileWriter fw=new FileWriter(".\\SoapRequest\\"+responseFileName+".xml");   

			fw.write(getStringResponseGetDeal(requestXmlFileName,endPointUrl));   

			fw.close();   

			System.out.println("File written successfully");

		} catch (IOException e) {



			e.printStackTrace();

		}



	}



	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {



		getStatusCode("getDeal_Request",baseURInew);

		String getResponseStr=getStringResponseGetDeal("getDeal_Request",baseURInew);

		System.out.println("getResponseStr= "+getResponseStr);

		writeResponseToXmlfileGetDeal("getDeal_Response","getDeal_Request",baseURInew);











		/*         

                             File requestFile=new File(".\\SoapRequest\\getUpgradeFee_Request.xml");

                             //for Basic Authentication//

                             CredentialsProvider provider = new BasicCredentialsProvider();

                             UsernamePasswordCredentials credentials= new UsernamePasswordCredentials("extsystemuser","rules");

                             provider.setCredentials(AuthScope.ANY, credentials);



                             CloseableHttpClient client= HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

                             HttpPost request=new HttpPost(baseURI);

                             request.addHeader("Content-Type", "text/xml");

                             HttpEntity entity=new InputStreamEntity(new FileInputStream(requestFile));

                             BufferedHttpEntity bEntity=new BufferedHttpEntity(entity);

                             request.setEntity(bEntity);

                             CloseableHttpResponse response=client.execute(request);

                                int statuseCode=response.getStatusLine().getStatusCode();

                                           System.out.println("statuseCode= "+statuseCode);

                                           Assert.assertEquals(200,statuseCode);



                                           String responseStr=EntityUtils.toString(response.getEntity(),"UTF-8");

                                           System.out.println("Response in String formate ="+responseStr);



                                           FileWriter fw=new FileWriter(".\\SoapRequest\\getUpgradeFee_Response.xml");   

                         fw.write(responseStr);    

                         fw.close();   

                         System.out.println("File written successfully");



                                 Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response.toString())));

		 */



		/* NodeList nodes = doc.getElementsByTagName("message");

                                 for (int i = 0; i < nodes.getLength(); i++) {

                                                          Node node = nodes.item(i);

                                                          if (node.getNodeType() == Node.ELEMENT_NODE) {

                                                          Element element = (Element) node;

                                                          System.out.println("msisdn: " + readXmlFile.getValue("msisdn", element));

                                                          System.out.println("channel: " + readXmlFile.getValue("channel", element));

                                                          System.out.println("brand: " + readXmlFile.getValue("brand", element));

                                                          }*/

		/*if(nodes.getLength()>0) {

                                          Element element=(Element)nodes.item(0);

                                           String msisdn=element.getElementsByTagName("msisdn").item(0).getTextContent();

                                           System.out.println("Printing from XML="+msisdn);

                                 }*/

		// create the xml file

		//transform the DOM Object to an XML File

		/* TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            DOMSource domSource = new DOMSource(doc);

            StreamResult streamResult = new StreamResult(new File(".\\SoapRequest\\getUpgradeFee_Response.xml"));

		 */

		// If you use

		// StreamResult result = new StreamResult(System.out);

		// the output will be pushed to the standard output ...

		// You can use that for debugging



		//transformer.transform(domSource, streamResult);



		//System.out.println("Done creating XML File");

	}        







}