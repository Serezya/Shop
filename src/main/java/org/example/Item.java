package org.example;

public class Item {
    public String name;
    public int price;
    public int rating;

    public Item(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return this.getName() + "\n- стоимость: " + this.getPrice() + " у.е.\n- рейтинг: " + this.getRating();
    }
}
