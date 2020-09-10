package org.example;

import java.util.Comparator;

public class RatingComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getRating() - item2.getRating();
    }
}
