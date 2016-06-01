package com.ashevtsov.examples;

import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        varrrar(5,23,3,1,4);

        String str = "This is String , split by StringTokenizer, created by mkyong";

//        System.out.println("---- Split by comma ',' ------");
        StringTokenizer st2 = new StringTokenizer(str, ",s");

        Properties props = new Properties();
        props.setProperty("first", "first_val");
        props.setProperty("second", "second_val");
        props.setProperty("third", "third_val");

//        try {
//            props.load(System.in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        while (st2.hasMoreElements()) {
            System.out.println(st2.nextElement());
        }

        try {
            props.store(System.out, "comments");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
