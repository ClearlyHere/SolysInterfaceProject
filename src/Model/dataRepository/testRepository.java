package Model.dataRepository;

import Model.dataObjects.*;

import java.sql.Date;

public class testRepository {
    public static void main(String[] args) {
        ClientRepository clientRepo = new ClientRepository();
        CompteRepository compteRepo = new CompteRepository();
        EmployeRepository empRepo = new EmployeRepository();
        LocationRepository locRepo = new LocationRepository();
        TransactionRepository transRepo = new TransactionRepository();
        VehiculeRepository vehiculeRepo = new VehiculeRepository();

        Date debLocDate = Date.valueOf("2023-10-21");
        Date finLocDate = Date.valueOf("2023-11-25");
        Date transDate = Date.valueOf("1989-02-13");

        Client client = new Client(1, "fName", "name", "adresse", "01-23-45-67-89");
        Compte compte = new Compte(100001, "name", 5000.50F);
        Employe employe = new Employe(10, "fName", "name", "post", 2500.50F);
        Location location = new Location(200, 10001, 123, 10004,
                debLocDate, finLocDate, 50.50F);
        Transaction transaction = new Transaction(50, 100001, 100004,
                500.12F, transDate);
        Vehicule vehicule = new Vehicule(123, "BMW", "ABX",
                2004, "ABX-123", 100.50F);
    }
}
