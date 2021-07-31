package testSetup;



import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.Reader;

import java.util.LinkedHashSet;

import java.util.Set;



import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;

import javax.xml.parsers.SAXParserFactory;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import javax.xml.ws.handler.Handler;





import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NamedNodeMap;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import org.xml.sax.Attributes;

import org.xml.sax.InputSource;

import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;



import com.relevantcodes.extentreports.LogStatus;



public class modifyXmlFile {



	/*

	 * Below function will modify the particular element node of the XML file

	 * Return type is void

	 * @param accepts 4 Parameters

	 * @String fileName

	 * String tagName

	 * String elementValueToModify

	 * String elementValue

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */

	public static void modifyParticularElementOfXmlfile(String fileName,String tagName,String elementValueToModify, String elementValue) {



		try {

			File requestXml = new File(".\\SoapRequest\\"+fileName+".xml");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse(requestXml);

			document.getDocumentElement().normalize();

			System.out.println("root of xml file" + document.getDocumentElement().getNodeName());



			Node message = document.getElementsByTagName(tagName).item(0);



			// loop the message node and update salary value, and delete a node

			NodeList nodes = message.getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {

				Node element = nodes.item(i);



				if (elementValueToModify.equals(element.getNodeName())) {

					element.setTextContent(elementValue);

				}



				// remove firstname

				/* if ("firstname".equals(element.getNodeName())) {

                             message.removeChild(element);

				 */

			}

			// write the DOM object to the file

			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();

			DOMSource domSource = new DOMSource(document);



			StreamResult streamResult = new StreamResult(new File(".\\SoapRequest\\"+fileName+".xml"));

			transformer.transform(domSource, streamResult);

			System.out.println("The XML File was Updated successfully");



			reportDirectory.test.log(LogStatus.PASS, "Value of element "+elementValueToModify+" modified to "+elementValue);

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Value of element "+elementValueToModify+" modified to "+elementValue);





		} catch (ParserConfigurationException pce) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to modify  the "+elementValueToModify);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to modify  the "+elementValueToModify);

			pce.printStackTrace();

		} catch (TransformerException tfe) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to modify  the "+elementValueToModify);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to modify  the "+elementValueToModify);

			tfe.printStackTrace();

		} catch (IOException ioe) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to modify  the "+elementValueToModify);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to modify  the "+elementValueToModify);

			ioe.printStackTrace();

		} catch (SAXException sae) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to modify  the "+elementValueToModify);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to modify  the "+elementValueToModify);

			sae.printStackTrace();

		}





	}



	/*

	 * Below function will modify the particular element node of the XML file

	 * Return type is void

	 * @param accepts 4 Parameters

	 * @String fileName

	 * String tagName

	 * String elementValueToModify

	 * String elementValue

	 * @author  Akarshit Srivastava

	 * @since   01-OCT-2020

	 */

	public static String getValueByTagNameFromXmlfile(String fileName,String startTag,String tagName) {

		String tagValue=null;

		try {



			File requestXml = new File(".\\SoapRequest\\"+fileName+".xml");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse(requestXml);

			document.getDocumentElement().normalize();



			//System.out.println("root of xml file" + document.getDocumentElement().getNodeName());



			//Node message = document.getElementsByTagName(tagName).item(0);

			//System.out.println(tagName+" value is="+message);

			NodeList nodes = document.getElementsByTagName(startTag);

			for (int i = 0; i < nodes.getLength(); i++) {

				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					//System.out.println("TagName is :" + element.getAttribute(tagName));

					//           System.out.println( tagName+": " + element.getElementsByTagName(tagName).item(0).getTextContent());

					tagValue=element.getElementsByTagName(tagName).item(0).getTextContent();



					//break;

				}

			}

			reportDirectory.test.log(LogStatus.PASS, "Value of "+tagName+" ="+tagValue);

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Value of "+tagName+" ="+tagValue);

			System.out.println("Value of "+tagName+" modified to "+tagValue);

		} catch (ParserConfigurationException pce) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to read data from "+tagName);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read data from "+tagName);

			pce.printStackTrace();

		} catch (IOException ioe) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to read data from "+tagName);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read data from "+tagName);

			ioe.printStackTrace();

		} catch (SAXException sae) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to read data from "+tagName);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read data from "+tagName);

			sae.printStackTrace();

		}

		return tagValue;

	}



	public static Set<String> getValueByTagNameGetDealFromXmlfile(String fileName,String startTag,String tagName) {

		String tagValue=null;

		Set<String> tagValueSet=new LinkedHashSet<>();

		try {



			File requestXml = new File(".\\SoapRequest\\"+fileName+".xml");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse(requestXml);

			document.getDocumentElement().normalize();





			//System.out.println("root of xml file" + document.getDocumentElement().getNodeName());



			//Node message = document.getElementsByTagName(tagName).item(0);

			//System.out.println(tagName+" value is="+message);

			NodeList nodes = document.getElementsByTagName(startTag);

			for (int i = 0; i < nodes.getLength(); i++) {

				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					//System.out.println("TagName is :" + element.getAttribute(tagName));

					System.out.println( tagName+": " + element.getElementsByTagName(tagName).item(0).getTextContent());

					tagValue=element.getElementsByTagName(tagName).item(0).getTextContent();

					tagValueSet.add(tagValue);

					//break;

				}

			}

			reportDirectory.test.log(LogStatus.PASS, "Value of "+tagName+" ="+tagValue);

			reportDirectory.test_consolidated.log(LogStatus.PASS, "Value of "+tagName+" ="+tagValue);

			System.out.println("Value set ="+tagValueSet);

		} catch (ParserConfigurationException pce) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to read data from "+tagName);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read data from "+tagName);

			pce.printStackTrace();

		} catch (IOException ioe) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to read data from "+tagName);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read data from "+tagName);

			ioe.printStackTrace();

		} catch (SAXException sae) {

			reportDirectory.test.log(LogStatus.FAIL, "Unable to read data from "+tagName);

			reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read data from "+tagName);

			sae.printStackTrace();

		}

		return tagValueSet;

	}







	/*public String getValueFromXmlUsingSax(boolean elementName) {



                             try  

                             { 

                             SAXParserFactory factory = SAXParserFactory.newInstance(); 

                             SAXParser saxParser = factory.newSAXParser(); 

                             DefaultHandler handler = new DefaultHandler()  

                             { 

                             boolean elementName = false; 



                             //parser starts parsing a specific element inside the document   

              /*          public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException  

                             { 

                             System.out.println("Start Element :" + qName); 

                             if(qName.equalsIgnoreCase("Id")) 

                             { 

                             elementName=true; 

                             } 

                             if (qName.equalsIgnoreCase("FIRSTNAME"))  

                             { 

                             firstname = true; 

                             } 

                             if (qName.equalsIgnoreCase("LASTNAME"))  

                             { 

                             lastname = true; 

                             } 

                             if (qName.equalsIgnoreCase("SUBJECT"))  

                             { 

                             subject = true; 

                             } 

                             if (qName.equalsIgnoreCase("MARKS"))  

                             { 

                             marks = true; 

                             } 

                             } 

                             //parser ends parsing the specific element inside the document 

                             public void endElement(String uri, String localName, String qName) throws SAXException  

                             { 

                             System.out.println("End Element:" + qName); 

                             } 

                             //reads the text value of the currently parsed element 

                             public void characters(char ch[], int start, int length) throws SAXException  

                             { 

                             if (id)  

                             { 

                             System.out.println("ID : " + new String(ch, start, length)); 

                             id = false; 

                             } 

                             if (firstname)  

                             { 

                             System.out.println("First Name: " + new String(ch, start, length)); 

                             firstname = false; 

                             } 

                             if (lastname)  

                             { 

                             System.out.println("Last Name: " + new String(ch, start, length)); 

                             lastname = false; 

                             } 

                             if (subject) 

                             { 

                             System.out.println("Subject: " + new String(ch, start, length)); 

                             subject = false; 

                             } 

                             if (marks)  

                             { 

                             System.out.println("Marks : " + new String(ch, start, length)); 

                             marks = false; 

                             } 

                             } 

                             }; 

                             saxParser.parse("F:\\XMLFile.xml", handler); 

                             }  

                             catch (Exception e)  

                             { 

                             e.printStackTrace(); 

                             } 

                             } 

                             } 











                             return null;        

              }*/



	public static void main(String[] args) {



		//modifyParticularElementOfXmlfile("getDeal_Request","message","msisdn","447415982219");

		//getValueByTagNameFromXmlfile("getDeal_Response","message","conversationId");

		getValueByTagNameGetDealFromXmlfile("getDeal_Response","dealItem","offerName");

		//getValueByTagNameFromXmlfile("getUpgradeFee_Response","message","upgradeFee");

	}            



}