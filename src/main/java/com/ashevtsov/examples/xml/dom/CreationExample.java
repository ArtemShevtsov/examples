package com.ashevtsov.examples.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by Artem_Shevtsov on 6/1/2016.
 */
public class CreationExample {
    public static void main(String[] args) {
        File file = new File("resources/created_from_code.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        CreationExample creationExample = new CreationExample();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            creationExample.runCreationExample(document, file);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public void runCreationExample(Document doc, File file) throws TransformerException {
        Comment comment = doc.createComment("Created from Java Code");
        Element allCars = doc.createElement("allCars");
        allCars.setAttribute("type", "all");

        Element sportCarsEl = doc.createElement("sportcars");
        sportCarsEl.setAttribute("type", "sport");
        Element regularCarsEl = doc.createElement("regularcars");
        regularCarsEl.setAttribute("type", "regular");

        allCars.appendChild(sportCarsEl);
        allCars.appendChild(regularCarsEl);

        doc.appendChild(comment);
        doc.appendChild(allCars);

        DOMSource domSource = new DOMSource(doc);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(domSource, new StreamResult(System.out));
        transformer.transform(domSource, new StreamResult(file));
    }
}
