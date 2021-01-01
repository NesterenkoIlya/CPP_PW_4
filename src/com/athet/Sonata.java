package com.athet;

public class Sonata extends MusicalComposition {
    protected int sonata_id;
    protected int part_number;    //Количество частей
    protected String application; //Применение
    protected int cell_id;

    public Sonata(int si, double d, int on, String c, int pn, String a, int ci) {
        this.sonata_id = si;
        this.duration = d;
        this.opuses_number = on;
        this.compositor = c;
        this.part_number = pn;
        this.application = a;
        this.cell_id = ci;
    }

    @Override
    public String toString() {
        return "Sonata{" + "sonata_id=" + sonata_id + '\'' +
                ", duration=" + duration + '\'' +
                ", opuses_number=" + opuses_number + '\'' +
                ", compositor='" + compositor + '\'' +
                ", part_number=" + part_number + '\'' +
                ", application='" + application + '\'' +
                ", cell_id='" + cell_id + '\'' +
                '}';
    }

    public void set_part_number(int part_number) { this.part_number = part_number; }

    public void set_application(String application) { this.application = application; }

    public void set_sonata_id(int sonata_id) { this.sonata_id = sonata_id; }

    public void set_cell_id(int cell_id) { this.cell_id = cell_id; }

    public int get_part_number() { return part_number; }

    public String get_application() { return application; }

    public int get_sonata_id() { return sonata_id; }

    public int get_cell_id() { return cell_id; }
}
