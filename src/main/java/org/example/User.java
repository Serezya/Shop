package org.example;

import java.util.List;

public class User {
    private String name;
    private String surname;
    private int id;
    private List<Item> cart;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.cart = null;
    }

    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.cart = null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }
}