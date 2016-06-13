package com.ashevtsov.examples.xml.sax.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Artem_Shevtsov on 6/2/2016.
 */
public class ModifyHandler extends DefaultHandler {
    private int numberLines;
    private String[] displayText = new String[100];
    private String indentation;

    private String currentElName;
    private boolean skipElement = false;

    public int getNumberLines() {
        return numberLines;
    }

    public String[] getDisplayText() {
        return displayText;
    }

    @Override
    public void startDocument() throws SAXException {
        displayText[0] = "<?xml version=\"1.0\" encoding=\"UTF-8" + "\"?>";
        numberLines = 0;
        indentation = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(skipElement){
            return;
        }

        if(qName.toLowerCase().trim().equals("student") && attributes != null && attributes.getValue("id") != null){
            if(attributes.getValue("id").equals(String.valueOf(59))) {
                skipElement = true;
                return;
            }
        }

        numberLines ++;
        displayText[numberLines] = indentation;
        currentElName = qName;
        indentation += "    ";

        displayText[numberLines] += "<" + qName;
        if(attributes != null){
            int attrCount = attributes.getLength();
            for(int i = 0; i< attrCount; i++){
                displayText[numberLines] += " " +
                        attributes.getQName(i) + "=\"" +
                        attributes.getValue(i) + "\"";
            }
        }
        displayText[numberLines] += ">";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.toLowerCase().trim().equals("student") && skipElement){
            skipElement = false;
            return;
        }
        if(skipElement){
            return;
        }

        indentation = indentation.substring(0, indentation.length() - 4);
        if(!qName.equals(currentElName)){
            numberLines++;
            displayText[numberLines] = indentation;
        }
        displayText[numberLines] += "</" + qName + ">";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if(str.length() > 0){
            displayText[numberLines] += str.trim();
        }
    }
}
