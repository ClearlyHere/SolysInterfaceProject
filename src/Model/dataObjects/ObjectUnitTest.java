package Model.dataObjects;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectUnitTest extends AbstractObject {
    private Client client;
    private Compte compte;
    private Employe employe;
    private Location location;
    private Transaction transaction;
    private Vehicule vehicule;

    @BeforeEach
    void setUp() {
        client = new Client(15, "fName", "name", "address", "01-12-54-47-93");
        compte = new Compte(100001, "name", 5000.50F);
        employe = new Employe(10, "fName", "name", "post", 2500.50F);
        location = new Location(200, 10001, 123, 10004,
                "2023-10-21", "2023-11-25", 50.50F);
        transaction = new Transaction(50, 10001, 10004,
                500.12F, "1989-02-13");
        vehicule = new Vehicule(123, "BMW", "ABX",
                2004, "ABX-123", 100.50F);
    }

    @org.junit.jupiter.api.Test
    void testGetPrimaryKeyIsCorrectClient() {
        int pKey = client.getPrimaryKey();
        assertEquals(pKey, 15, "Clé primaire pas correct");
    }

    @org.junit.jupiter.api.Test
    void testGetTableArrayIsCorrectClient() {
        List<Object> listArray = client.getTableArray();
        List<Object> expectedListArray = new ArrayList<>();
        expectedListArray.add(15);
        expectedListArray.add("fName");
        expectedListArray.add("name");
        expectedListArray.add("address");
        expectedListArray.add("01-12-54-47-93");
        assertEquals(listArray, expectedListArray, "TableArray incorrect");
    }

    @org.junit.jupiter.api.Test
    void testToStringIsCorrectClient() {
        String string = client.toString();
        String expectedString = "Client{id='15', nom='fName', prenom='name', adresse='address', numTelephone='01-12-54-47-93'}\n";
        assertEquals(expectedString, string, "String ne sont pas égaux ");
    }

    @org.junit.jupiter.api.Test
    void testGetPrimaryKeyIsCorrectCompte() {
        int pKey = compte.getPrimaryKey();
        assertEquals(pKey, 100001, "Clé primaire pas correct");
    }


    @org.junit.jupiter.api.Test
    void testGetTableArrayIsCorrectCompte() {
        List<Object> listArray = compte.getTableArray();
        List<Object> expectedListArray = new ArrayList<>();
        expectedListArray.add(100001);
        expectedListArray.add("name");
        expectedListArray.add(5000.5F);
        assertEquals(listArray, expectedListArray, "TableArray incorrect");
    }

    @org.junit.jupiter.api.Test
    void testToStringIsCorrectCompte() {
        String string = compte.toString();
        String expectedString = "Compte{numCompte='100001', titulaire='name', solde='5000.5'}\n";
        assertEquals(expectedString, string, "String ne sont pas égaux ");
    }

    @org.junit.jupiter.api.Test
    void testGetPrimaryKeyIsCorrectEmploye() {
        int pKey = employe.getPrimaryKey();
        assertEquals(pKey, 10, "Clé primaire pas correct");
    }


    @org.junit.jupiter.api.Test
    void testGetTableArrayIsCorrectEmploye() {
        List<Object> listArray = employe.getTableArray();
        List<Object> expectedListArray = new ArrayList<>();
        expectedListArray.add(10);
        expectedListArray.add("fName");
        expectedListArray.add("name");
        expectedListArray.add("post");
        expectedListArray.add(2500.50F);
        assertEquals(listArray, expectedListArray, "TableArray incorrect");
    }

    @org.junit.jupiter.api.Test
    void testToStringIsCorrectEmploye() {
        String string = employe.toString();
        String expectedString = "Employe{id='10', nom='fName', prenom='name', poste='post', salaire='2500.5'}\n";
        assertEquals(expectedString, string, "String ne sont pas égaux ");
    }

    @org.junit.jupiter.api.Test
    void testGetPrimaryKeyIsCorrectLocation() {
        int pKey = location.getPrimaryKey();
        assertEquals(pKey, 200, "Clé primaire pas correct");
    }


    @org.junit.jupiter.api.Test
    void testGetTableArrayIsCorrectLocation() {
        List<Object> listArray = location.getTableArray();
        List<Object> expectedListArray = new ArrayList<>();
        expectedListArray.add(200);
        expectedListArray.add(10001);
        expectedListArray.add(123);
        expectedListArray.add(10004);
        expectedListArray.add(LocalDate.parse("2023-10-21", Location.getFormatter()));
        expectedListArray.add(LocalDate.parse("2023-11-25", Location.getFormatter()));
        expectedListArray.add(50.50F);
        assertEquals(listArray, expectedListArray, "TableArray incorrect");
    }

    @org.junit.jupiter.api.Test
    void testToStringIsCorrectLocation() {
        String string = location.toString();
        String expectedString = "Location{id='200', id_client='10001', id_vehicule='123'," +
                " id_employe='10004', dateDebut='2023-10-21', dateFin='2023-11-25', coutTotal='50.5'}\n";
        assertEquals(expectedString, string, "String ne sont pas égaux ");
    }

    @org.junit.jupiter.api.Test
    void testGetPrimaryKeyIsCorrectTransaction() {
        int pKey = transaction.getPrimaryKey();
        assertEquals(pKey, 50, "Clé primaire pas correct");
    }


    @org.junit.jupiter.api.Test
    void testGetTableArrayIsCorrectTransaction() {
        List<Object> listArray = transaction.getTableArray();
        List<Object> expectedListArray = new ArrayList<>();
        expectedListArray.add(50);
        expectedListArray.add(10001);
        expectedListArray.add(10004);
        expectedListArray.add(500.12F);
        expectedListArray.add(LocalDate.parse("1989-02-13", Transaction.getFormatter()));
        assertEquals(listArray, expectedListArray, "TableArray incorrect");
    }

    @org.junit.jupiter.api.Test
    void testToStringIsCorrectTransaction() {
        String string = transaction.toString();
        String expectedString = "Transaction{id='50', numCompteSource='10001'," +
                " numCompteCible='10004', montant='500.12', dateTransaction='1989-02-13'}\n";
        assertEquals(expectedString, string, "String ne sont pas égaux ");
    }

    @org.junit.jupiter.api.Test
    void testGetPrimaryKeyIsCorrectVehicule() {
        int pKey = vehicule.getPrimaryKey();
        assertEquals(pKey, 123, "Clé primaire pas correct");
    }


    @org.junit.jupiter.api.Test
    void testGetTableArrayIsCorrectVehicule() {
        List<Object> listArray = vehicule.getTableArray();
        List<Object> expectedListArray = new ArrayList<>();
        expectedListArray.add(123);
        expectedListArray.add("BMW");
        expectedListArray.add("ABX");
        expectedListArray.add(2004);
        expectedListArray.add("ABX-123");
        expectedListArray.add(100.50F);
        assertEquals(listArray, expectedListArray, "TableArray incorrect");
    }

    @org.junit.jupiter.api.Test
    void testToStringIsCorrectVehicule() {
        String string = vehicule.toString();
        String expectedString = "Vehicule{id='123', marque='BMW', modele='ABX', anneeFabrication='2004'," +
                " plaqueImmat='ABX-123', prixLocJournee='100.5'}\n";
        assertEquals(expectedString, string, "String ne sont pas égaux ");
    }
}