package org.example;

import java.util.*;

public class SortName implements Sort {
    @Override
    public void sort(List<Item> items) {
        Collections.sort(items, new NameComparator());
    }
}
