package com.athet;

public class Aria extends Song {
    protected int aria_id;
    protected String volume;      //Объем
    protected String pace;        //Темп
    protected String intonation;  //Интонация
    protected int cell_id;

    public Aria() {
        this.duration = 0;
        this.opuses_number = 0;
        this.compositor = "";
        this.song_kind = "";
        this.singer = "";
        this.verses_number = 0;
        this.volume = "";
        this.pace = "";
        this.intonation = "";
    }

    public Aria(int ai, double d, int on, String c, String sk, String s, int vn, String v, String p, String i, int ci) {
        this.aria_id = ai;
        this.duration = d;
        this.opuses_number = on;
        this.compositor = c;
        this.song_kind = sk;
        this.singer = s;
        this.verses_number = vn;
        this.volume = v;
        this.pace = p;
        this.intonation = i;
        this.cell_id = ci;
    }

    @Override
    public String toString() {
        return "Aria{" +
                "aria_id=" + aria_id + '\'' +
                ", duration=" + duration + '\'' +
                ", opuses_number=" + opuses_number + '\'' +
                ", compositor='" + compositor + '\'' +
                ", song_kind='" + song_kind + '\'' +
                ", singer='" + singer + '\'' +
                ", verses_number=" + verses_number +
                ", volume='" + volume + '\'' +
                ", pace=" + pace + '\'' +
                ", intonation='" + intonation + '\'' +
                ", cell_id='" + cell_id + '\'' +
                '}';
    }

    public void set_volume(String volume) { this.volume = volume; }

    public void set_pace(String pace) { this.pace = pace; }

    public void set_intonation(String intonation) { this.intonation = intonation; }

    public void set_aria_id(int aria_id) { this.aria_id = aria_id; }

    public void set_cell_id(int cell_id) { this.cell_id = cell_id; }

    public String get_volume() { return volume; }

    public String get_pace() { return pace; }

    public String get_intonation() { return intonation; }

    public int get_aria_id() { return aria_id; }

    public int get_cell_id() { return cell_id; }
}
