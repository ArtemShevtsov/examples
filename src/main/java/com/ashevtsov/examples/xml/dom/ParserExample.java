package com.ashevtsov.examples.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Created by Artem_Shevtsov on 6/1/2016.
 *
 * Following are the steps used while parsing a document using DOM Parser.
 *
 * Import XML-related packages.
 * Create a DocumentBuilder
 * Create a Document from a file or stream
 * Extract the root element
 * Examine attributes
 * Examine sub-elements
 */
public class ParserExample {
    public static void main(String[] args) {
        File xmlFile = new File("resources/parser_example.xml");
        ParserExample parserExample = new ParserExample();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document parsedDocument = documentBuilder.parse(xmlFile);

            parserExample.runParseExample(parsedDocument);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }

    public void runParseExample(Document doc){
        Element element = doc.getDocumentElement();
        showAttributesOfElement(element);
        System.out.println("\n\n");
        showElementsByName(element, "student");
        System.out.println("\n\n");
        showElementsByName(element, "nickname");

        NodeList students = element.getElementsByTagName("students");
        for(int i = 0; i < students.getLength(); i++){
            if(((Element)students.item(i)).getAttribute("group").equals("B")){
                System.out.println("\n\n");
                showAllStudents((Element)students.item(i));
            }
        }
        System.out.println("\n\n");
        showAllStudents(element);
    }

    private void showAttributesOfElement(Element el){
        System.out.println("Attributes of \"" + el.getTagName() + "\":");
        NamedNodeMap attributes = el.getAttributes();
        for(int i = 0; i < attributes.getLength(); i++){
            Node attr = attributes.item(i);
            System.out.println("\t" + attr + "\n\t\t" +
                    String.join("\n\t\t",
                            "getParentNode => " + attr.getParentNode(),
                            "getNodeType => " + attr.getNodeType(),
                            "getLocalName => " + attr.getLocalName(),
                            "getTextContent" + " => " + attr.getTextContent(),
                            "getNodeName" +  " => " + attr.getNodeName(),
                            "getNodeValue" +  "=> " + attr.getNodeValue()
                    )
            );
        }
    }

    private void showElementsByName(Element el, String name){
        System.out.println("Element with name \"" + name + "\" of \"" + el.getTagName() + "\":");
        NodeList elements = el.getElementsByTagName(name);
        for(int i = 0; i < elements.getLength(); i++){
            Node node = elements.item(i);
            System.out.println("\t" + node + "\n\t\t" +
                    String.join("\n\t\t",
                            "getParentNode => " + node.getParentNode(),
                            "getNodeType => " + node.getNodeType(),
                            "getLocalName => " + node.getLocalName(),
                            "getTextContent" + " => " + node.getTextContent(),
                            "getNodeName" +  " => " + node.getNodeName(),
                            "getNodeValue" +  "=> " + node.getNodeValue()
                    )
            );
        }
    }

    private void showAllStudents(Element el){
        System.out.println("Root element: " + el.getTagName() + "\n------------------------\n");
        NodeList students = el.getElementsByTagName("student");
        for(int i = 0; i < students.getLength(); i++){
            Node node = students.item(i);
            System.out.println("\n\tCurrent Element: " + node.getNodeName());

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element studentEl = (Element) node;
                System.out.println("\t" +
                        String.join("\n\t",
                                "Student roll no: " + studentEl.getAttribute("rollno"),
                                "First Name: " + studentEl.getElementsByTagName("firstname").item(0).getTextContent(),
                                "Last Name: " + studentEl.getElementsByTagName("lastname").item(0).getTextContent(),
                                "Nick Name: " + studentEl.getElementsByTagName("nickname").item(0).getTextContent(),
                                "marks: " + studentEl.getElementsByTagName("marks").item(0).getTextContent()
                        )
                );
            }
        }
    }
}
