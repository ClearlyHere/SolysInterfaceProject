package Model.dataRepository;

public class testRepository {
    public static void main(String[] args) {
        ClientRepository clientRepo = new ClientRepository();
        CompteRepository compteRepo = new CompteRepository();
        EmployeRepository empRepo = new EmployeRepository();
        LocationRepository locRepo = new LocationRepository();
        TransactionRepository transRepo = new TransactionRepository();
        VehiculeRepository vehiculeRepo = new VehiculeRepository();
        System.out.println(vehiculeRepo.selectAll());
    }
}
