package com.athet;

public class MusicalComposition implements Comparable<MusicalComposition> {
    protected double duration;    //Длительность
    protected int opuses_number;  //Номер опуса
    protected String compositor;  //Коипозитор

    public MusicalComposition() {}

    public MusicalComposition(double d, int on, String c) {
        this.duration = d;
        this.opuses_number = on;
        this.compositor = c;
    }

    @Override
    public String toString() {
        return "MusicalComposition{" + "duration=" + duration +
                ", opuses_number=" + opuses_number +
                ", compositor='" + compositor + '\'' +
                '}';
    }

    public double get_duration() { return duration; }

    public int get_opuses_number() { return opuses_number; }

    public String get_compositor() { return compositor; }

    public void set_duration(double duration) { this.duration = duration; }

    public void set_compositor(String compositor) { this.compositor = compositor; }

    public void set_opuses_number(int opuses_number) { this.opuses_number = opuses_number; }

    public int compareTo(MusicalComposition obj) {
        double other_duration = obj.get_duration();
        return Double.compare(duration, other_duration);
    }
}
