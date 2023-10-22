package Model.conf;

import java.sql.*;

public class DatabaseManager {
    public static Connection getConnection(){
        Connection connection = null;
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
