package DAO;

import java.sql.SQLException;

public class DAOFactory {
    private static IMyDAO dao = null;
    public static IMyDAO getDAOInstance(TypeDAO type) throws SQLException{
        if(type == TypeDAO.MySQL){
            if(dao == null) {
                dao = new MySQLDAO();
            }
            return dao;
        }
        return null;
    }

}