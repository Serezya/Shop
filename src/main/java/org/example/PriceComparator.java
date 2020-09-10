package org.example;

import java.util.Comparator;

public class PriceComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getPrice() - item2.getPrice();
    }
}
