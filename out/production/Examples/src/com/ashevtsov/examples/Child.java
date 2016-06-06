package com.ashevtsov.examples;

/**
 * Created by Artem_Shevtsov on 6/25/2015.
 */
public class Child extends Parent {
    static {System.out.println("2a - Child's static initialization block ran.");}

    String c = verify("6  - Child's non-static class variable c initialized.");

    static String cstatic = verify("2b - Child's static class variable cstatic initialized.");

    {
        verify("NON Static block CHILD");
    }

    Child( ) {

        super( );   //providing super( ) won't change anything here

        System.out.println ("7  - Child constructor ran."); }



    public static void main(String[ ] args) {

        System.out.println("3  - Child's main(..) method ran. Invoking Child with new.");

        //Child C = new Child( );

        System.out.println("8  - The rest of main(..) was run.");  }
}
