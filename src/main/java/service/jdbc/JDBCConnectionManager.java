package service.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionManager {


    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    private JDBCConnectionManager() {
        throw new IllegalStateException("Cannot instantiate util class");
    }

    public static Connection getConnection(String url, String username, String password) throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlEx) {
            System.err.println("Failed to create the database connection");
            throw sqlEx;
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found.");
            throw ex;
        }
    }

    public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/db_from_terminal";
        String username = "root";
        String password = "123";
//        System.out.println(MessageFormat.format("url = {0}", url));
        return JDBCConnectionManager.getConnection(url, username, password);
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getDBConnection();
        System.out.println("Success");
    }

}


