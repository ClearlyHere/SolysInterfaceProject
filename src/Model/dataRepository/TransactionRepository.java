package Model.dataRepository;

import Model.dataObjects.Client;

import java.util.ArrayList;

public class TransactionRepository extends AbstractRepository {
    private final String column1 = "ID_Client";
    private final String column2 = "Nom";
    private final String column3 = "Prénom";
    private final String column4 = "Adresse";
    private final String column5 = "Numéro_Téléphone";
    @Override
    protected String getPrimayKeyColumn() {
        return "ID_Client";
    }

    @Override
    protected String getNomTable() {
        return "Clients";
    }

    @Override
    protected Client Construire(ArrayList<Object> list) {
        return new Client(
                (int) list.get(0),
                (String) list.get(1),
                (String) list.get(2),
                (String) list.get(3),
                (String) list.get(4)
        );
    }
}
