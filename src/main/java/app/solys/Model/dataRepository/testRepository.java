package app.solys.Model.dataRepository;

import app.solys.Model.dataObjects.*;

import java.sql.Date;

public class testRepository {
    public static void main(String[] args) {
        Date debLocDate = Date.valueOf("2023-10-21");
        Date finLocDate = Date.valueOf("2023-11-25");
        Date transDate = Date.valueOf("1989-02-13");

        ClientRepository clientRepo = new ClientRepository();
        CompteRepository compteRepo = new CompteRepository();
        EmployeRepository empRepo = new EmployeRepository();
        LocationRepository locRepo = new LocationRepository();
        TransactionRepository transRepo = new TransactionRepository();
        VehiculeRepository vehiculeRepo = new VehiculeRepository();

        Client client = new Client(2, "fName", "name", "adresse", "01-23-45-67-89");
        Compte compte = new Compte(100001, "name", 5000.50F);
        Employe employe = new Employe(2, "fName", "name", "post", 2500.50F);
        Location location = new Location(2, 10001, 123, 10004,
                debLocDate, finLocDate, 50.50F);
        Transaction transaction = new Transaction(2, 100001, 100004,
                500.12F, transDate);
        Vehicule vehicule = new Vehicule(2, "BMW", "ABX",
                2004, "ABX-123", 100.50F);

        System.out.println(vehiculeRepo.selectAll());
    }
}
