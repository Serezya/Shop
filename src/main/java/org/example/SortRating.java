package org.example;

import java.util.Collections;
import java.util.List;

public class SortRating implements Sort {
    @Override
    public void sort(List<Item> list) {
        Collections.sort(list, new RatingComparator());
    }
}
