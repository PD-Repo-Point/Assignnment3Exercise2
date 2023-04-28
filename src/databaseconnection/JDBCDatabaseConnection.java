package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDatabaseConnection {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;

    public static Connection getConnection(String url,
                                           String user,
                                           String password)
            throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }




}
