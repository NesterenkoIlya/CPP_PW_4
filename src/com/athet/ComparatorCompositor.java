package com.athet;

import java.util.Comparator;

public class ComparatorCompositor implements Comparator<MusicalComposition> {
    public int compare (MusicalComposition obj_1, MusicalComposition obj_2) {
        return obj_1.get_compositor().compareTo(obj_2.get_compositor());
    }

}
