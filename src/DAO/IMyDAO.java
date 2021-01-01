package DAO;

import java.sql.SQLException;
import com.athet.*;

public interface IMyDAO {

    //add

    public void add_collection(Collection collection) throws SQLException;
    public void add_cell(Cell cell) throws SQLException;
    public void add_aria(Aria aria) throws SQLException;
    public void add_sonata(Sonata sonata) throws SQLException;

    //delete

    public void delete_collection(int id) throws SQLException;
    public void delete_cell(int id) throws SQLException;
    public void delete_aria(int id) throws SQLException;
    public void delete_sonata(int id) throws SQLException;

    //update

    public void update_collection(int id, int column) throws SQLException;
    public void update_cell(int id, int column) throws SQLException;
    public void update_aria(int id, int column) throws SQLException;
    public void update_sonata(int id, int column) throws SQLException;

    //search

    public void search_collection(int id, String name) throws SQLException;
    public void search_cell(int id, int copies_number, int collection_id) throws SQLException;
    public void search_aria(int id, double duration, int opuses_number, String compositor, String song_kind, String singer, int verses_number, String volume, String pace, String intonation, int cell_id) throws SQLException;
    public void search_sonata(int id, double duration, int opuses_number, String compositor, int part_number, String application, int cell_id) throws SQLException;

    public void get_collection() throws SQLException;
    public void get_cell() throws SQLException;
    public void get_aria() throws SQLException;
    public void get_sonata() throws SQLException;

}
