package org.example;

import java.util.Collections;
import java.util.List;

public class SortPrice implements Sort {
    @Override
    public void sort(List<Item> list) {
        Collections.sort(list, new PriceComparator());
    }
}
