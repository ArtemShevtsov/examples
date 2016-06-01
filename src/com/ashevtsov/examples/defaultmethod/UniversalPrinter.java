package com.ashevtsov.examples.defaultmethod;

/**
 * Created by Artem_Shevtsov on 5/30/2016.
 */
public class UniversalPrinter implements CapsPrinter, LowerPrinter {
    @Override
    public void print(String s) {
        CapsPrinter.super.print(s);
    }

    public static void main(String[] args) {
        UniversalPrinter p = new UniversalPrinter();
        p.print("wwww");
    }
}
