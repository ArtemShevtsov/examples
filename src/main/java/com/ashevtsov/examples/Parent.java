package com.ashevtsov.examples;

/**
 * Created by Artem_Shevtsov on 6/25/2015.
 */
public class Parent {
    String p = verify("4  - Parent's non-static class variable p initialized.");

    static String pstatic = verify("1a - Parent's static class variable pstatic initialized.");

    {
        verify("NON Static block PARENT");
    }

    static {System.out.println("1b - Parent's static initialization block ran.");}

    static String verify(String s) {System.out.println(s);  return s;}



    Parent( ) {

        System.out.println("5  - Parent constructor ran.");
    }
}
