package com.ashevtsov.examples.defaultmethod;

/**
 * Created by Artem_Shevtsov on 5/30/2016.
 */
public interface CapsPrinter {
    default void print(String s){
        System.out.println(s.toUpperCase());
    }
}
