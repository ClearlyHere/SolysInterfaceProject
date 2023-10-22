package Model.dataRepository;

import Model.conf.DatabaseManager;
import Model.dataObjects.*;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract public class AbstractRepository {
    protected String column1;

    protected abstract String getNomTable();

    protected abstract AbstractObject construire(ArrayList<Object> list);

    protected String getPrimayKeyColumn() {
        return this.column1;
    }

    protected List<String> getColumns() {
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

    private String columsToString(){
        StringBuilder columnsString = new StringBuilder();
        List<String> columnsArray = this.getColumns();
        for (int i = 0; i < columnsArray.size(); i++){
            String column = columnsArray.get(i);
            columnsString.append(column);
            if (i < columnsArray.size() - 1) {
                columnsString.append(", ");
            }
        }
        return columnsString.toString();
    }
    public List<AbstractObject> selectAll()
    {
        try {
            Connection connection = DatabaseManager.getConnection();
            String sqlQuery = "SELECT " + this.columsToString() + " FROM " + this.getNomTable() + ";";
            Statement queryStatement = connection.createStatement();
            ResultSet resultSet = queryStatement.executeQuery(sqlQuery);

            List<ArrayList<Object>> dataTable = getObjectsFromResultSet(resultSet);
            List<AbstractObject> objectList = new ArrayList<>();

            for (ArrayList<Object> objectArray : dataTable){
                objectList.add(construire(objectArray));
            }
            connection.close();
            queryStatement.close();
            return objectList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
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
    public static void selectLocation(int id_client){
        try {
            Connection connection = DatabaseManager.getConnection();

            // Définir la requête SQL paramétrée
            String sqlQuery = "SELECT ID_Location, ID_Véhicule, ID_Employé, Date_Début, " +
                    "Date_Fin, Coût_Total FROM locations WHERE ID_client = ?";
            // On créé un PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            // Paramétrage de l'identifiant du client
            preparedStatement.setInt(1, id_client);
            // Execution de la requête, on enregistre les données dans un ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // On appelle la méthode getResultSet
            getObjectsFromResultSet(resultSet);

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insertClient(String nom, String prenom, String adresse, String num_tel) {
        try {
            // Création d'une connexion
            Connection connection = DatabaseManager.getConnection();

            // Définition de la requête SQL paramétrée
            String sqlInsert = "INSERT INTO clients (Nom, Prénom, Adresse, Numéro_Téléphone) " +
                    "VALUES (?,?,?,?)";
            // On créé un PreparedStatement à partir de la requête SQL
            PreparedStatement InsertStatement = connection.prepareStatement(sqlInsert);
            // On paramètre nos données à nos placeholders
            InsertStatement.setString(1,nom);
            InsertStatement.setString(2, prenom);
            InsertStatement.setString(3,adresse);
            InsertStatement.setString(4,num_tel);
            // On exécute la requête SQL et on vérifie que les m
            int rowCount = InsertStatement.executeUpdate();
            if (rowCount == 1) {
                System.out.println("Insertion des données réussies : "
                        + nom + ", "  + prenom + ", " + adresse + ", " + num_tel);
            }
            connection.close();
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

            connection.close();
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
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
