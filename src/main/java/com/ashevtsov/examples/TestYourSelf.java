package com.ashevtsov.examples;

/**
 * Created by Artem_Shevtsov on 6/25/2015.
 */
public class TestYourSelf {
    public static void main(String[] args) {
        new Child();
    }

    static class Parent {
        Parent() {
            foo();
        }

        void foo() {
            //empty method
        }
    }

    static class Child extends Parent {
        private static String x = "hello-buddy";

        @Override
        void foo() {
            System.out.println(x.length());
        }
    }
}
