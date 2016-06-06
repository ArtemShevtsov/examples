package com.ashevtsov.examples.xml.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import com.ashevtsov.examples.xml.sax.handlers.ParserHandler;
import com.ashevtsov.examples.xml.sax.handlers.QueryWithIdHandler;
import org.xml.sax.SAXException;

/**
 * Created by Artem_Shevtsov on 6/1/2016.
 */
public class ParserExample {
    public static void main(String[] args) {
        ParserExample parserExample = new ParserExample();
        File file = new File("resources/parser_example.xml");
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
//            saxParser.parse(file, new ParserHandler());
            saxParser.parse(file, new QueryWithIdHandler());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
