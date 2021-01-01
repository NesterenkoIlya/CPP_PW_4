package com.athet;

import java.util.Iterator;

public interface MyList extends Iterable {
    void add(Aria obj);
    void clear();
    boolean remove(Aria obj);
    Object[] toArray();
    int size();
    boolean contains(Aria obj);
    String toString();
    Iterator<Aria> iterator();
    boolean add(Aria obj, int index);
    void remove_first();
}
