package com.ashevtsov.examples.web.soap.services;

import javax.jws.WebService;
import com.ashevtsov.examples.web.soap.beans.Beer;

/**
 * Created by Artem_Shevtsov on 6/2/2016.
 */
@WebService(endpointInterface = "com.ashevtsov.examples.web.soap.services.BeerService")
public class BeerServiceImpl implements BeerService {

    @Override
    public Beer getBeer(String name) {
        return new Beer(name);
    }
}
