package testSetup;

 

import java.io.File;

 

import java.io.File;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

 

import com.relevantcodes.extentreports.LogStatus;

 

public class readXmlFile {

             

              /*

              * Below function will read the XML file returns the value of element node

               * Return type is String

              * @param accepts 3 Parameters

               * @String fromFileName

              * String tagName

              * String elementName

              * @author  Akarshit Srivastava

              * @since   01-OCT-2020

              */

             

             

              public static String readXml(String fromFileName,String tagName,String elementName) {

                            

                             String valueOfNode = null;

                             try {

                                          

                                           File requestXml = new File(".\\SoapRequest\\"+fromFileName+".xml");

                                           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

                                           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                                           Document doc = dBuilder.parse(requestXml);

                                           doc.getDocumentElement().normalize();

 

                                           System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());

                                           NodeList nodes = doc.getElementsByTagName(tagName);

                                           System.out.println("==========================");

                                          

                                           for (int i = 0; i < nodes.getLength(); i++) {

                                           Node node = nodes.item(i);

                                           if (node.getNodeType() == Node.ELEMENT_NODE) {

                                           Element element = (Element) node;

                                           valueOfNode=getValue("msisdn", element);

                                          

                             //           reportDirectory.test.log(LogStatus.PASS, "Value of element "+elementName+" read from "+fromFileName+" is ="+valueOfNode);

                             //              reportDirectory.test_consolidated.log(LogStatus.PASS, "Value of element "+elementName+" read from "+fromFileName+" is ="+valueOfNode);

                                          

                                           /*System.out.println("msisdn: " + getValue("msisdn", element));

                                           System.out.println("upgradeFee: " + getValue("upgradeFee", element));

                                           System.out.println("Upgrade Date: " + getValue("upgradeDate", element));

                                           */

                                           }

                                           }

                                           } catch (Exception ex) {

                                           ex.printStackTrace();

                                           reportDirectory.test.log(LogStatus.FAIL, "Unable to read the "+fromFileName+" file");

                                           reportDirectory.test_consolidated.log(LogStatus.FAIL,  "Unable to read the "+fromFileName+" file");

                                          

                                           }

                             return valueOfNode;

                            

              }

             

             

              public static void main(String[] args) {

                            

                             String msisdn=readXml("getUpgradeFee_Response","message","msisdn");

                            

                             System.out.println("Msisdn="+msisdn);

                             /*try {

                                           File requestXml = new File(".\\SoapRequest\\getUpgradeFee_Response.xml");

                                           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

                                           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                                           Document doc = dBuilder.parse(requestXml);

                                           doc.getDocumentElement().normalize();

 

                                           System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());

                                           NodeList nodes = doc.getElementsByTagName("message");

                                           System.out.println("==========================");

                                          

                                           for (int i = 0; i < nodes.getLength(); i++) {

                                           Node node = nodes.item(i);

                                           if (node.getNodeType() == Node.ELEMENT_NODE) {

                                           Element element = (Element) node;

                                           System.out.println("msisdn: " + getValue("msisdn", element));

                                           System.out.println("upgradeFee: " + getValue("upgradeFee", element));

                                           System.out.println("Upgrade Date: " + getValue("upgradeDate", element));

                                           }

                                           }

                                           } catch (Exception ex) {

                                           ex.printStackTrace();

                                           }*/

                                           }

             

              public static String getValue(String tag, Element element) {

                                           NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();

                                           Node node = (Node) nodes.item(0);

                                           return node.getNodeValue();

                                           }

                                                         

              }