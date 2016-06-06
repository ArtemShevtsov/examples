package com.ashevtsov.examples.xml.sax.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Artem_Shevtsov on 6/1/2016.
 */
public class QueryWithIdHandler extends ParserHandler {
    private Integer id;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "student":
                if(attributes.getValue("id") == null){
                    id = null;
                } else {
                    id = Integer.valueOf(attributes.getValue("id"));
                }
            default:
                if (id != null) {
                    super.startElement(uri, localName, qName, attributes);
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            default:
                if (id != null) {
                    super.endElement(uri, localName, qName);
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (id != null) {
            super.characters(ch, start, length);
        }
    }
}
