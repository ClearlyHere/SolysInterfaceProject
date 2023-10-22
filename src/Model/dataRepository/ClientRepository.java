package Model.dataRepository;
import Model.dataObjects.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends AbstractRepository {
    @Override
    protected String getPrimayKeyColumn() {
        return "ID_Client";
    }

    @Override
    protected String getNomTable() {
        return "Clients";
    }

    @Override
    protected List<String> getColumns() {
        List<String> columnsArray = new ArrayList<>();
        columnsArray.add(getPrimayKeyColumn());
        columnsArray.add("Nom");
        columnsArray.add("Prénom");
        columnsArray.add("Adresse");
        columnsArray.add("Numéro_Téléphone");
        return columnsArray;
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
