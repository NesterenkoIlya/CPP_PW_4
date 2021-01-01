package com.athet;

import java.util.Comparator;

public class ComparatorOpusesNumber implements Comparator<MusicalComposition>{
    public int compare (MusicalComposition obj_1, MusicalComposition obj_2) {
        return Integer.compare(obj_1.get_opuses_number(), obj_2.get_opuses_number());
    }
}
