package testSetup;



import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;



import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.TransformerException;



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

import org.xml.sax.SAXException;



public class postRequestGetDeal {



	public static String proxy_host="proxy.intra.bt.com",PORT="8080",baseURI=http://pegaccpdev-marketing-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/Services, baseURInew=http://pegasit2-advisor.nat.bt.com/prweb/PRSOAPServlet/SOAP/EEServices/V2;



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

	public static int getStatusCode() {



		CloseableHttpResponse response=              postSoapRequest("getDeal_Request",baseURI);



		int statuseCode=response.getStatusLine().getStatusCode();

		System.out.println("statuseCode= "+statuseCode);

		//Assert.assertEquals(200,statuseCode);

		return statuseCode;

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



	public static String getStringResponse() {

		String responseStr=null;

		try {

			CloseableHttpResponse response=              postSoapRequest("getDeal_Request",baseURI);

			responseStr=EntityUtils.toString(response.getEntity(),"UTF-8");

			System.out.println("Response in String formate ="+responseStr);

		} catch (ParseException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return responseStr;



	}

	/*

	 * Below function will write the fetched String response into the XML file

	 * Return type no

	 * @param accepts 1 Parameter1

	 * @String requestXml

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */

	public static void writeResponseToXmlfile(String responseFileName) {

		try {

			FileWriter fw=new FileWriter(".\\SoapRequest\\"+responseFileName+".xml");   

			fw.write(getStringResponse());   

			fw.close();   

			System.out.println("File written successfully");

		} catch (IOException e) {



			e.printStackTrace();

		}



	}





	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {



		getStatusCode();

		String getResponseStr=getStringResponse();

		System.out.println("getResponseStr= "+getResponseStr);

		writeResponseToXmlfile("getDeal_Response");













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