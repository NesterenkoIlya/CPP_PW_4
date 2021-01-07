package com.athet;

import java.sql.*;
import java.util.*;
import DAO.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        //DB parametrs
        String url = "jdbc:mysql://localhost:3306/musical_composition?useUnicode=true&serverTimezone=UTC";
        String user = "root";
        String password = "";
        ResultSet rs;
        Scanner in = new Scanner(System.in);

        //Test program
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            System.out.println("Connection to musical_composition DB successful!");
//        } catch (SQLException throwables) {
//            System.out.println("Connection failed...");
//            throwables.printStackTrace();
//        }

        try {
            IMyDAO dao = DAOFactory.getDAOInstance(TypeDAO.MySQL);

//            dao.add_collection(new Collection(1, "Big Collection"));
//            dao.add_cell(new Cell(1, 12, 1));
//            dao.add_cell(new Cell(2, 16, 1));
//            dao.add_aria(new Aria(1, 2.2, 3, "Random", "Huiweb", "Kjgopiew", 4, "Kishjd", "Kdjwq", "Loiwef", 1));
//            dao.add_sonata(new Sonata(1, 3.4, 5, "Kihwe", 4, "Kijdio", 2));
//            dao.add_collection(new Collection(2, "Small Collection"));
//            dao.add_cell(new Cell(3, 52, 2));
//            dao.add_cell(new Cell(4, 25, 2));
//            dao.add_sonata(new Sonata(2, 3.2, 6, "Fsdh", 4, "Bwefw", 3));
//            dao.add_aria(new Aria(2, 4.2, 8, "Btrwes", "Qdfh", "Nehtr", 6, "Kishjd", "Kdjwq", "Loiwef", 4));
//            dao.add_cell(new Cell(5, 3, 2));
//            dao.add_aria(new Aria(3, 6.2, 6, "Kofjwpe", "Askoplf", "Moew", 4, "Lodsw", "Lcwet", "Lfnw", 4));

            dao.search_aria(3, 0, 0, "", "", "", 0, "", "", "", 0);
            dao.delete_aria(3);
            dao.get_aria();
            dao.update_aria(2, 3);
            dao.get_aria();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
