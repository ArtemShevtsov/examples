package com.ashevtsov.examples.web.soap.beans;

/**
 * Created by Artem_Shevtsov on 6/2/2016.
 */
public class Beer {
    private String name;
    private int price = 20;
    private String currency = "dollar(s)";

    public Beer() {
    }

    public Beer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Here is your \"" + name + "\". " +
                price + " " + currency + " please!";
    }
}
