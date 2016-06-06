package com.ashevtsov.examples.web.soap.services.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import com.ashevtsov.examples.web.soap.services.BeerService;

/**
 * Created by Artem_Shevtsov on 6/3/2016.
 */
public class BeerServiceClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9999/ws/beer?wsdl");
            QName beerServiceImplService = new QName("http://services.soap.web.examples.ashevtsov.com/", "BeerServiceImplService");
            Service service = Service.create(url, beerServiceImplService);
            BeerService beerService = service.getPort(BeerService.class);

            System.out.printf(beerService.getBeer("qqq").toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
