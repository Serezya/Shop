package org.example;

public class ForHome extends Item {
    enum ItemsCategory {
        CLEAN_AGENT,
        KITCHEN_APPLIENCES
    }

    public final ItemsCategory itemsCategory;

    public ForHome(String name, int price, int rating, ItemsCategory category) {
        super(name, price, rating);
        this.itemsCategory = category;
    }
}
