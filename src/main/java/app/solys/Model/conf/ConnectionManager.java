package app.solys.Model.conf;

import java.sql.Connection;
import java.sql.SQLException;

//TODO tHANKS TO THIS INTERFACE YOU CAN ACCESS TO THE CONNEXION INDEPENDENTLY OF THE CLASS
public interface ConnectionManager {
    Connection connection = DatabaseManager.getConnection();
    default void closeConnection() throws SQLException {
        connection.close();
    }
}
