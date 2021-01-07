package DAO;

import com.athet.*;

import java.sql.*;
import java.util.Scanner;

public class MySQLDAO implements IMyDAO {
    private static final String url = "jdbc:mysql://localhost:3306/musical_composition?useUnicode=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";
    private Connection connection;
    private Scanner in = new Scanner(System.in);

    public MySQLDAO() throws SQLException { connection = DriverManager.getConnection(url, user, password); }

    @Override
    public void add_collection(Collection collection) throws SQLException {
        PreparedStatement add = connection.prepareStatement("insert into collection(collection_id, name) values(?, ?)");
        add.setInt(1, collection.get_collection_id());
        add.setString(2, collection.get_name());
        add.executeUpdate();
        add.close();
    }

    @Override
    public void add_cell(Cell cell) throws SQLException {
        PreparedStatement add = connection.prepareStatement("insert into cell(cell_id, copies_number, collection_id) values(?, ?, ?)");
        add.setInt(1, cell.get_cell_id());
        add.setInt(2, cell.get_copies_number());
        add.setInt(3, cell.get_collection_id());
        add.executeUpdate();
        add.close();
    }

    @Override
    public void add_aria(Aria aria) throws SQLException {
        PreparedStatement add = connection.prepareStatement("insert into aria(aria_id, duration, opuses_number, compositor, song_kind, singer, verses_number, volume, pace, intonation, cell_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        add.setInt(1, aria.get_aria_id());
        add.setDouble(2, aria.get_duration());
        add.setInt(3, aria.get_opuses_number());
        add.setString(4, aria.get_compositor());
        add.setString(5, aria.get_song_kind());
        add.setString(6, aria.get_singer());
        add.setInt(7, aria.get_verses_number());
        add.setString(8, aria.get_volume());
        add.setString(9, aria.get_pace());
        add.setString(10, aria.get_intonation());
        add.setInt(11, aria.get_cell_id());
        add.executeUpdate();
        add.close();
    }

    @Override
    public void add_sonata(Sonata sonata) throws SQLException {
        PreparedStatement add = connection.prepareStatement("insert into sonata(sonata_id, duration, opuses_number, compositor, part_number, application, cell_id) values(?, ?, ?, ?, ?, ?, ?)");
        add.setInt(1, sonata.get_sonata_id());
        add.setDouble(2, sonata.get_duration());
        add.setInt(3, sonata.get_opuses_number());
        add.setString(4, sonata.get_compositor());
        add.setInt(5, sonata.get_part_number());
        add.setString(6, sonata.get_application());
        add.setInt(7, sonata.get_cell_id());
        add.executeUpdate();
        add.close();
    }

    @Override
    public void delete_collection(int id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("delete from collection where collection_id=?");
        delete.setInt(1,id);
        delete.executeUpdate();
        delete.close();
    }

    @Override
    public void delete_cell(int id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("delete from cell where cell_id=?");
        delete.setInt(1,id);
        delete.executeUpdate();
        delete.close();
    }

    @Override
    public void delete_aria(int id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("delete from aria where aria_id=?");
        delete.setInt(1,id);
        delete.executeUpdate();
        delete.close();
    }

    @Override
    public void delete_sonata(int id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("delete from sonata where sonata_id=?");
        delete.setInt(1,id);
        delete.executeUpdate();
        delete.close();
    }

    @Override
    public void update_collection(int id, int column) throws SQLException {
        PreparedStatement update;
        if (column == 2) {
            update = connection.prepareStatement("update collection set name = ? where collection_id = ?");
            System.out.print("Enter collection name: ");
            String name = in.nextLine();
            update.setString(1, name);
            update.setInt(2, id);
            update.executeUpdate();
            update.close();
        } else {
            System.out.println("You use incorrect column or row id!");
        }
    }

    @Override
    public void update_cell(int id, int column) throws SQLException {
        PreparedStatement update;
        switch (column) {
            case 2: {
                update = connection.prepareStatement("update cell set copies_number = ? where cell_id = ?");
                System.out.print("Enter copies_number: ");
                int copies_number = in.nextInt();
                update.setInt(1, copies_number);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 3: {
                update = connection.prepareStatement("update cell set collection_id = ? where cell_id = ?");
                System.out.print("Enter collection_id: ");
                int collection_id = in.nextInt();
                update.setInt(1, collection_id);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            default:
                System.out.println("You use incorrect column or row id!");
                break;
        }
    }

    @Override
    public void update_aria(int id, int column) throws SQLException {
        PreparedStatement update;
        switch (column) {
            case 2: {
                update = connection.prepareStatement("update aria set duration = ? where aria_id = ?");
                System.out.print("Enter duration: ");
                double duration = in.nextDouble();
                update.setDouble(1, duration);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 3: {
                update = connection.prepareStatement("update aria set opuses_number = ? where aria_id = ?");
                System.out.print("Enter opuses_number: ");
                int opuses_number = in.nextInt();
                update.setInt(1, opuses_number);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 4: {
                update = connection.prepareStatement("update aria set compositor = ? where aria_id = ?");
                System.out.print("Enter compositor: ");
                String compositor = in.nextLine();
                update.setString(1, compositor);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 5: {
                update = connection.prepareStatement("update aria set song_kind = ? where aria_id = ?");
                System.out.print("Enter song_kind: ");
                String song_kind = in.nextLine();
                update.setString(1, song_kind);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 6: {
                update = connection.prepareStatement("update aria set singer = ? where aria_id = ?");
                System.out.print("Enter singer: ");
                String singer = in.nextLine();
                update.setString(1, singer);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 7: {
                update = connection.prepareStatement("update aria set verses_number = ? where aria_id = ?");
                System.out.print("Enter verses_number: ");
                int verses_number = in.nextInt();
                update.setInt(1, verses_number);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 8: {
                update = connection.prepareStatement("update aria set volume = ? where aria_id = ?");
                System.out.print("Enter volume: ");
                String volume = in.nextLine();
                update.setString(1, volume);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 9: {
                update = connection.prepareStatement("update aria set pace = ? where aria_id = ?");
                System.out.print("Enter pace: ");
                String pace = in.nextLine();
                update.setString(1, pace);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 10: {
                update = connection.prepareStatement("update aria set intonation = ? where aria_id = ?");
                System.out.print("Enter intonation: ");
                String intonation = in.nextLine();
                update.setString(1, intonation);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 11: {
                update = connection.prepareStatement("update aria set cell_id = ? where aria_id = ?");
                System.out.print("Enter cell_id: ");
                int cell_id = in.nextInt();
                update.setInt(1, cell_id);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            default:
                System.out.println("You use incorrect column or row id!");
                break;
        }
    }

    @Override
    public void update_sonata(int id, int column) throws SQLException {
        PreparedStatement update;
        switch (column) {
            case 2: {
                update = connection.prepareStatement("update sonata set duration = ? where sonata_id = ?");
                System.out.print("Enter duration: ");
                double duration = in.nextDouble();
                update.setDouble(1, duration);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 3: {
                update = connection.prepareStatement("update sonata set opuses_number = ? where sonata_id = ?");
                System.out.print("Enter opuses_number: ");
                int opuses_number = in.nextInt();
                update.setInt(1, opuses_number);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 4: {
                update = connection.prepareStatement("update sonata set compositor = ? where sonata_id = ?");
                System.out.print("Enter compositor: ");
                String compositor = in.nextLine();
                update.setString(1, compositor);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 5: {
                update = connection.prepareStatement("update sonata set part_number = ? where sonata_id = ?");
                System.out.print("Enter part_number: ");
                int part_number = in.nextInt();
                update.setInt(1, part_number);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 6: {
                update = connection.prepareStatement("update sonata set application = ? where sonata_id = ?");
                System.out.print("Enter application: ");
                String application = in.nextLine();
                update.setString(1, application);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            case 7: {
                update = connection.prepareStatement("update sonata set cell_id = ? where sonata_id = ?");
                System.out.print("Enter cell_id: ");
                int cell_id = in.nextInt();
                update.setInt(1, cell_id);
                update.setInt(2, id);
                update.executeUpdate();
                update.close();
            }
            default:
                System.out.println("You use incorrect column or row id!");
                break;
        }
    }

    @Override
    public void search_collection(int id, String name) throws SQLException {
        String _id, _name;
        PreparedStatement search;
        ResultSet rs;

        if (id == 0) _id = "%";
        else _id = Integer.toString(id);

        if (name.equals("")) _name = "%";
        else _name = name;

        search = connection.prepareStatement("select * from collection where collection_id like ? and 'name' like ?");
        search.setString(1, _id);
        search.setString(2, _name);

        rs = search.executeQuery();

        while (rs.next()) {
            Collection c = new Collection(
                rs.getInt(1),
                rs.getString(2)
            );
            System.out.println(c);
        }
    }

    @Override
    public void search_cell(int id, int copies_number, int collection_id) throws SQLException {
        String _id, _collection_id, _copies_number;

        PreparedStatement search;
        ResultSet rs;

        if (id == 0) _id = "%";
        else _id = Integer.toString(id);

        if (copies_number == 0) _copies_number = "%";
        else _copies_number = Integer.toString(copies_number);

        if (collection_id == 0) _collection_id = "%";
        else _collection_id = Integer.toString(collection_id);

        search = connection.prepareStatement("select * from cell where cell_id like ? and copies_number like ? and collection_id like ?");
        search.setString(1, _id);
        search.setString(2, _copies_number);
        search.setString(3, _collection_id);

        rs = search.executeQuery();

        while (rs.next()) {
            Cell c = new Cell(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3)
            );
            System.out.println(c);
        }
    }

    @Override
    public void search_aria(int id, double duration, int opuses_number, String compositor, String song_kind, String singer, int verses_number, String volume, String pace, String intonation, int cell_id) throws SQLException {
        String _id, _duration, _opuses_number, _compositor, _song_kind, _singer, _verses_number, _volume, _pace, _intonation, _cell_id;

        PreparedStatement search;
        ResultSet rs;

        if (id == 0) _id = "%";
        else _id = Integer.toString(id);

        if (duration == 0) _duration = "%";
        else _duration = Double.toString(duration);

        if (opuses_number == 0) _opuses_number = "%";
        else _opuses_number = Integer.toString(opuses_number);

        if (compositor.equals("")) _compositor = "%";
        else _compositor = compositor;

        if (song_kind.equals("")) _song_kind = "%";
        else _song_kind = song_kind;

        if (singer.equals("")) _singer = "%";
        else _singer = singer;

        if (verses_number == 0) _verses_number = "%";
        else _verses_number = Integer.toString(verses_number);

        if (volume.equals("")) _volume = "%";
        else _volume = volume;

        if (pace.equals("")) _pace = "%";
        else _pace = pace;

        if (intonation.equals("")) _intonation = "%";
        else _intonation = intonation;

        if (cell_id == 0) _cell_id = "%";
        else _cell_id = Integer.toString(cell_id);

        search = connection.prepareStatement("select * from aria where aria_id like ? and duration like ? and opuses_number like ? and compositor like ? and song_kind like ? and singer like ? and verses_number like ? and volume like ? and pace like ? and intonation like ? and cell_id like ?");

        search.setString(1, _id);
        search.setString(2, _duration);
        search.setString(3, _opuses_number);
        search.setString(4, _compositor);
        search.setString(5, _song_kind);
        search.setString(6, _singer);
        search.setString(7, _verses_number);
        search.setString(8, _volume);
        search.setString(9, _pace);
        search.setString(10, _intonation);
        search.setString(11, _cell_id);

        rs = search.executeQuery();

        while (rs.next()) {
            Aria a = new Aria(
                    rs.getInt(1),
                    rs.getDouble(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getInt(11)
            );
            System.out.println(a);
        }
    }

    @Override
    public void search_sonata(int id, double duration, int opuses_number, String compositor, int part_number, String application, int cell_id) throws SQLException {
        String _id, _duration, _opuses_number, _compositor, _part_number, _application, _cell_id;

        if (id == 0) _id = "%";
        else _id = Integer.toString(id);

        if (duration == 0) _duration = "%";
        else _duration = Double.toString(duration);

        if (opuses_number == 0) _opuses_number = "%";
        else _opuses_number = Integer.toString(opuses_number);

        if (compositor.equals("")) _compositor = "%";
        else _compositor = compositor;

        if (part_number == 0) _part_number = "%";
        else _part_number = Double.toString(part_number);

        if (application.equals("")) _application = "%";
        else _application = application;

        if (cell_id == 0) _cell_id = "%";
        else _cell_id = Double.toString(cell_id);

        PreparedStatement search;
        ResultSet rs;

        search = connection.prepareStatement("select * from sonata where sonata_id like ? and duration like ? and opuses_number like ? and compositor like ? and part_number like ? and application like ? and cell_id like ?");

        search.setString(1, _id);
        search.setString(2, _duration);
        search.setString(3, _opuses_number);
        search.setString(4, _compositor);
        search.setString(5, _part_number);
        search.setString(6, _application);
        search.setString(7, _cell_id);

        rs = search.executeQuery();

        while (rs.next()) {
            Sonata s = new Sonata(
                    rs.getInt(1),
                    rs.getDouble(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getInt(7)
            );
            System.out.println(s);
        }
    }

    @Override
    public void get_collection() throws SQLException {
        PreparedStatement get = connection.prepareStatement("select * from collection");

        ResultSet rs = get.executeQuery();

        System.out.format("%5s%20s", "id", "name");
        System.out.println();

        while (rs.next()) {
            int a = rs.getInt(1);
            String b = rs.getString(2);
            System.out.format("%5d%20s", a, b);
            System.out.println();
        }
    }

    @Override
    public void get_cell() throws SQLException {
        PreparedStatement get = connection.prepareStatement("select * from cell");

        ResultSet rs = get.executeQuery();

        System.out.format("%5s%20s%10s", "id", "copies_number", "col_id");
        System.out.println();

        while (rs.next()) {
            int a = rs.getInt(1);
            int b = rs.getInt(2);
            int c = rs.getInt(3);
            System.out.format("%5d%20d%10d", a, b, c);
            System.out.println();
        }
    }

    @Override
    public void get_aria() throws SQLException {
        PreparedStatement get = connection.prepareStatement("select * from aria");

        ResultSet rs = get.executeQuery();

        System.out.format("%5s%10s%7s%15s%10s%10s%10s%10s%10s%10s%10s", "id", "duration", "op_num", "compositor", "song_kind", "singer", "ver_num", "volume", "pace", "intonation", "cell_id");
        System.out.println();

        while (rs.next()) {
            int a = rs.getInt(1);
            double b = rs.getDouble(2);
            int c = rs.getInt(3);
            String d = rs.getString(4);
            String e = rs.getString(5);
            String f = rs.getString(6);
            int g = rs.getInt(7);
            String h = rs.getString(8);
            String i = rs.getString(9);
            String j = rs.getString(10);
            int k = rs.getInt(11);

            System.out.format("%5d%10f%7d%15s%10s%10s%10d%10s%10s%10s%10d", a, b, c, d, e, f, g, h, i, j, k);
            System.out.println();
        }
    }

    @Override
    public void get_sonata() throws SQLException {

    }
}
