package Model.dataRepository;

import Model.dataObjects.Vehicule;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VehiculeRepository extends AbstractRepository {
    private final String column1 = "ID_Véhicule";
    private final String column2 = "Marque";
    private final String column3 = "Modèle";
    private final String column4 = "Année_Fabrication";
    private final String column5 = "Plaque_Immatriculation";
    private final String column6 = "Prix_Loc_Journée";

    @Override
    protected String getNomTable() {
        return "véhicules";
    }

    @Override
    protected Vehicule construire(ArrayList<Object> list) {
        BigDecimal decimal = (BigDecimal) list.get(5);
        float prixLoc = decimal.floatValue();
        return new Vehicule(
                (int) list.get(0),
                (String) list.get(1),
                (String) list.get(2),
                (int) list.get(3),
                (String) list.get(4),
                prixLoc
        );
    }
}
