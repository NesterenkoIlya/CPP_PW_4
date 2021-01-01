package com.athet;

public class Collection {
    int collection_id;
    String name;

    public Collection(int ci, String n) {
        this.collection_id = ci;
        this.name = n;
    }

    @Override
    public String toString() {
        return "Collection{" + "collection_id=" + collection_id +
                ", name='" + name + '\'' +
                '}';
    }

    public int get_collection_id() {
        return collection_id;
    }

    public String get_name() {
        return name;
    }

    public void set_collection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public void set_name(String name) {
        this.name = name;
    }
}
