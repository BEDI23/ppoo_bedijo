package josue.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static final String URL = "jdbc:mysql://localhost:3306/dash";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Eurreur de connection a la base de donnee: " + e.getMessage());
            }
        }
        return connection;
    }

}
