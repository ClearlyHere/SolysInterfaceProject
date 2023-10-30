package app.solys.Model.conf;

import java.sql.*;

public class DatabaseManager {
    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection == null){
            connection = getInstance();
        }
        return connection;
    }

    private static Connection getInstance(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(Conf.getUrl(), Conf.getUsername(), Conf.getPassword());

            System.out.println("Connexion à la base de données réussie!");

            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return connection;
        }
    }
}
