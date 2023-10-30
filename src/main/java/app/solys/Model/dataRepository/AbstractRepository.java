package app.solys.Model.dataRepository;

import app.solys.Model.conf.ConnectionManager;
import app.solys.Model.conf.DatabaseManager;
import app.solys.Model.dataObjects.*;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// EVERYTHING MIRACOULOUSLY WORKS JESUS CHRIST
abstract public class AbstractRepository implements ConnectionManager {
    String column1;
    abstract String getPrimayKeyColumn();

    abstract String getNomTable();

    abstract AbstractObject construire(ArrayList<Object> list);

    List<String> getColumns() {
        List<String> columnsArray = new ArrayList<>();
        Field[] attributs = this.getClass().getDeclaredFields();
        try {
            for (Field attribut : attributs) {
                attribut.setAccessible(true);
                Object valeur = attribut.get(this);
                columnsArray.add((String) valeur);
            }
        } catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        return columnsArray;
    }
    /**Returns the column names of the corresponding Repository.
     * columnsToString is meant to build SQL queries based
     * on the table we're manipulating to create dynamic SQL
     * queries on all tables. Set primaryKey value to true if you want the
     * function to return the primaryKey, else set primary key as false to return
     * all other columns without the primary key.
     * Return example : "ID_Client, Nom, Prénom, Adresse, Numéro_Téléphone"
     * @return The names of table columns as a String
     */
    private String columsToString(boolean primaryKey){
        StringBuilder columnsString = new StringBuilder();
        List<String> columnsArray = this.getColumns();
        int i;
        if (primaryKey) i = 0; else i = 1;
        for (; i < columnsArray.size(); i++){
            String column = columnsArray.get(i);
            columnsString.append(column);
            if (i < columnsArray.size() - 1) {
                columnsString.append(", ");
            }
        }
        return columnsString.toString();
    }

    /**Returns parameterized SQL indexes "?" based on the abstract
     * object passed as a parameter. It's intended to build dynamic
     * SQL queries to manipulate most tables in the database. Ignores
     * the first attribute as we don't modify the first column
     * which should be the primary key column. Return example :
     * "(?, ?, ?, ?)"
     * @param object The AbstractObject associated with the SQL query
     * @return Parameterized "?" indexes as a String
     */
    private String objectIndexToString(AbstractObject object){
        StringBuilder valuesIndex = new StringBuilder("(");
        Field[] attributs = object.getClass().getDeclaredFields();
        for (int i = 1; i < attributs.length; i++){
            valuesIndex.append("?");
            if (i < attributs.length - 1){
                valuesIndex.append(", ");
            }
        }
        valuesIndex.append(")");
        return valuesIndex.toString();
    }

    private String updateParameterizedString(){
        StringBuilder builder = new StringBuilder();
        List<String> columnList = this.getColumns();
        for (int i = 1; i < columnList.size(); i++){
            String columnName = columnList.get(i);
            builder.append(columnName).append(" = ?");
            if (i < columnList.size() - 1){
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    private static List<ArrayList<Object>> getObjectsFromResultSet(ResultSet resultSet) throws SQLException {
        List<ArrayList<Object>> resultArray = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnsCount = metaData.getColumnCount();
        while (resultSet.next()) {
            ArrayList<Object> rowArray = new ArrayList<>();
            for (int i = 1; i <= columnsCount; i++) {
                Object columnValue = resultSet.getObject(i);
                rowArray.add(columnValue);
            }
            resultArray.add(rowArray);
        }
        resultSet.close();
        return resultArray;
    }

    public List<AbstractObject> selectAll()
    {
        try {
            Connection connection = ConnectionManager.connection;
            String sqlQuery = "SELECT " + this.columsToString(true) + " FROM " + this.getNomTable() + ";";
            Statement queryStatement = connection.createStatement();
            ResultSet resultSet = queryStatement.executeQuery(sqlQuery);

            List<ArrayList<Object>> dataTable = getObjectsFromResultSet(resultSet);
            List<AbstractObject> objectList = new ArrayList<>();

            for (ArrayList<Object> objectArray : dataTable){
                objectList.add(construire(objectArray));
            }
            queryStatement.close();
            return objectList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AbstractObject select(int identifier){
        List<ArrayList<Object>> dataTable;
        String sqlQuery = "SELECT " + this.columsToString(true) + " FROM " + this.getNomTable()
                + " WHERE " + this.getPrimayKeyColumn() + " = ?;";
        try (Connection connection = DatabaseManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, identifier);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            dataTable = getObjectsFromResultSet(resultSet);

            if (dataTable.isEmpty()){
                throw new Exception("Data not found in " + this.getNomTable());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return construire(dataTable.get(0));
    }

    public boolean effacer(int identifier){
        String sqlDelete = "DELETE FROM " + this.getNomTable() + " WHERE " + this.getPrimayKeyColumn() + " = ?;";
        try (Connection connection = DatabaseManager.getConnection()) {
            //noinspection SqlSourceToSinkFlow
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, identifier);
            System.out.println(preparedStatement);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount < 1){
                throw new Exception("Data not found in " + this.getNomTable());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean sauvegarder(AbstractObject object) {
        String sqlQuery = "INSERT INTO " + this.getNomTable() + " (" + this.columsToString(false) + ")"
                + " VALUES " + this.objectIndexToString(object) + ";";

        try (Connection connection = DatabaseManager.getConnection()){
            //noinspection SqlSourceToSinkFlow
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            List<Object> objectTableArray = object.getTableArray();
            for (int i = 1; i <= objectTableArray.size() - 1; i++){
                preparedStatement.setObject(i, objectTableArray.get(i));
            }
            System.out.println(preparedStatement);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount < 1){
                throw new Exception("Data not found in " + this.getNomTable());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean mettreAjour(AbstractObject object) {
        // STRING EXAMPLE = "UPDATE TABLE SET COLUMN2 = VALUE2, COLUMN3 = VALUE3 WHERE COLUMN1 = VALUE1;
        // A METHOD THAT SOULD RETURN "COLUMN2 = ?, COLUMN3 = ?"

        String sqlQuery = "UPDATE " + this.getNomTable() + " SET " + this.updateParameterizedString() +
                " WHERE " + this.getPrimayKeyColumn() + " = ?;";
        try (Connection connection = DatabaseManager.getConnection()){
            //noinspection SqlSourceToSinkFlow
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            List<Object> objectTableArray = object.getTableArray();
            int i;
            for (i = 1; i <= objectTableArray.size() - 1; i++){
                preparedStatement.setObject(i, objectTableArray.get(i));
            }
            preparedStatement.setObject(i, object.getPrimaryKey());
            System.out.println(preparedStatement);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount < 1) {
                throw new Exception("Data not found in " + this.getNomTable());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static void transactionSommeArgent(int compteSource, int compteCible, float sommeArgent){
        try (Connection connection = DatabaseManager.getConnection()) {
            if (compteSource == compteCible){
                throw new Exception("Le compte source et le compte cible sont les mêmes : " + compteCible);
            }
            if (sommeArgent <= 0){
                throw new Exception("Votre somme d'argent est invalide : " + sommeArgent);
            }
            // Désactiver l'engistrement automatique des modifications
            connection.setAutoCommit(false);

            // On récupère le solde du compte source
            String sqlQuery = "SELECT Solde FROM comptes WHERE Numéro_Compte = ?";
            // Paramétrer la requête SQL
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, compteSource);
            // Récupération du solde à partur du resultSet
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new Exception("Le compte " + compteSource + " n'existe pas");
            }
            // On observe si la somme d'argent dépasse le solde
            float solde = resultSet.getFloat(1);
            if (sommeArgent > solde){
                throw new Exception("Votre somme d'argent : " + sommeArgent + " dépasse votre solde : " + solde);
            }

            // Retirer la somme d'argent au compte source
            String sqlRetirer = "UPDATE comptes SET Solde = Solde - ? WHERE Numéro_Compte = ?";
            // Paramétrer la requête SQL
            statement = connection.prepareStatement(sqlRetirer);
            statement.setDouble(1, sommeArgent);
            statement.setInt(2, compteSource);
            // On vérifie que le compte cible est affecté
            int rowCount = statement.executeUpdate();
            if (rowCount != 1){
                throw new Exception("Erreur en retirant " + sommeArgent + " à " + compteSource);
            }

            // Déposer l'argent dans le compte cible, on vérifie que celle-ci a été affecté
            String sqlDeposer = "UPDATE comptes SET Solde = Solde + ? WHERE Numéro_Compte = ?";
            // Paramétrer la requête SQL
            statement = connection.prepareStatement(sqlDeposer);
            statement.setDouble(1, sommeArgent);
            statement.setInt(2, compteCible);
            // On vérifie que le compte cible est affecté
            rowCount = statement.executeUpdate();
            if (rowCount != 1){
                throw new Exception("Le compte " + compteCible + " n'existe pas");
            }

            // On enregistre la transaction dans la table transactions
            String sqlTransaction = "INSERT INTO transactions (Numéro_Compte_Source, Numéro_Compte_Cible, Montant, Date_Transaction)" +
                    "VALUES (?,?,?,CURRENT_DATE)";
            // Paramétrer la requête SQL
            statement = connection.prepareStatement(sqlTransaction);
            statement.setInt(1, compteSource);
            statement.setInt(2, compteCible);
            statement.setDouble(3, sommeArgent);
            // On vérifie qu'on a inséré une ligne de données
            rowCount = statement.executeUpdate();
            if (rowCount != 1){
                throw new Exception("Erreur durant l'enregistrement de la transaction!");
            }

            connection.commit();
            connection.setAutoCommit(true);
            System.out.println("Transaction réussie!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteLocationByPrice(int price){
        try {
            Connection connection = DatabaseManager.getConnection();

            // Définition de la requête SQL avec placeholders
            String sqlDelete = "DELETE FROM locations WHERE Coût_Total > ?";
            // Création d'un PreparedStatement avec sqlDelete
            PreparedStatement deleteStatement = connection.prepareStatement(sqlDelete);
            // Paramétrage du data cout dans le placeholder
            deleteStatement.setDouble(1, price);
            // Execution de deleteStatement
            int rowCount = deleteStatement.executeUpdate();
            // On obsèrve combien de données ont été affectées
            if (rowCount > 0) {
                System.out.println("Effacement de données réussies, " + rowCount + " lignes ont été affectées");
            }

            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void callMiseAJourPrixVehicules(String brand, double price){
        try {
            Connection connection = DatabaseManager.getConnection();

            String sql = "CALL `MiseAJourPrixVehicules`(?, ?);";
            PreparedStatement procedureCall = connection.prepareStatement(sql);
            procedureCall.setString(1, brand);
            procedureCall.setDouble(2, price);
            int rowCount = procedureCall.executeUpdate();
            if (rowCount == 1) {
                System.out.println("Mise à jour avec succès, la location de " + brand + " est désormais à " + price + "€");
            }
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
