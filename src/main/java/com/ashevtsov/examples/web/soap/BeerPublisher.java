package com.ashevtsov.examples.web.soap;

import javax.xml.ws.Endpoint;
import com.ashevtsov.examples.web.soap.services.BeerServiceImpl;

/**
 * Created by Artem_Shevtsov on 6/2/2016.
 */
public class BeerPublisher {
    public static void main(String[] args) {

        //Go by this link http://localhost:9999/ws/beer?wsdl
        //and you will see WSDL document
        Endpoint.publish("http://localhost:9999/ws/beer", new BeerServiceImpl());
    }
}
