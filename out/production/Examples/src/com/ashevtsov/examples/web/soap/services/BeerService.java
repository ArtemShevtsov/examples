package com.ashevtsov.examples.web.soap.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.ashevtsov.examples.web.soap.beans.Beer;

/**
 * Created by Artem_Shevtsov on 6/2/2016.
 */
@WebService
public interface BeerService {

    @WebMethod
    Beer getBeer(String name);
}
