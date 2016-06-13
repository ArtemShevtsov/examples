package com.ashevtsov.examples.xml.sax.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Artem_Shevtsov on 6/1/2016.
 */
public class ParserHandler extends DefaultHandler {
    protected boolean isFirstName = false;
    protected boolean isLastName = false;
    protected boolean isNickName = false;
    protected boolean isMarks = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "student":
                System.out.printf("\nStudent\n----------------------\n\tRollNo: %s\n\tID: %s\n",
                        attributes.getValue("rollno"), attributes.getValue("id"));
                break;
            case "firstname":
                isFirstName = true;
                break;
            case "lastname":
                isLastName = true;
                break;
            case "nickname":
                isNickName = true;
                break;
            case "marks":
                isMarks = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "student":
                System.out.println("----------------------\n");
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);

        if(isFirstName) {
            System.out.printf("\t\tFirst Name: %s\n", text);
            isFirstName = false;
        }
        if(isLastName) {
            System.out.printf("\t\tLast Name: %s\n", text);
            isLastName = false;
        }
        if(isNickName) {
            System.out.printf("\t\tNick Name: %s\n", text);
            isNickName = false;
        }
        if(isMarks) {
            System.out.printf("\t\tMarks: %s\n", text);
            isMarks = false;
        }
    }
}
