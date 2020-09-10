package org.example;

public class Food extends Item {
    enum ItemsCategory {
        MILK,
        FRUITS,
        VEGETABLES,
        MEAT
    }

    public final ItemsCategory itemsCategory;

    public Food(String name, int price, int rating, ItemsCategory itemsCategory) {
        super(name, price, rating);
        this.itemsCategory = itemsCategory;
    }
}
