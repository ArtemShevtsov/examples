package com.ashevtsov.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Artem_Shevtsov on 5/30/2016.
 */
public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(10);
        strings.add("one");
        strings.add("one");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add("six");
        strings.add("seven");
        strings.add("eight");
        strings.add("nine");
        strings.add("ten");


        strings.stream().map(s -> s + "_").forEach(System.out::println);
        strings.stream().filter(s ->
                s.contains("one")
        ).forEach(System.out::println);
    }
}
