package com.athet;

public class Cell {
    private int cell_id;
    private int collection_id;
    private int copies_number;

    public Cell() {}
    public Cell(int ci, int cn, int coli) {
        this.cell_id = ci;
        this.collection_id = coli;
        this.copies_number = cn;
    }

    public int get_cell_id() {
        return cell_id;
    }

    public int get_collection_id() {
        return collection_id;
    }

    public int get_copies_number() {
        return copies_number;
    }

    public void set_cell_id(int cell_id) {
        this.cell_id = cell_id;
    }

    public void set_collection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public void set_copies_number(int copies_number) {
        this.copies_number = copies_number;
    }
}
