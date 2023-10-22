package Model.dataRepository;

import Model.dataObjects.Location;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class LocationRepository extends AbstractRepository {
    private final String column1 = "ID_Location";
    private final String column2 = "ID_Client";
    private final String column3 = "ID_Véhicule";
    private final String column4 = "ID_Employé";
    private final String column5 = "Date_Début";
    private final String column6 = "Date_Fin";
    private final String column7 = "Coût_Total";

    @Override
    protected String getNomTable() {
        return "locations";
    }

    @Override
    protected Location construire(ArrayList<Object> list) {
        BigDecimal decimal = (BigDecimal) list.get(6);
        float coutTotal = decimal.floatValue();

        return new Location(
                (int) list.get(0),
                (int) list.get(1),
                (int) list.get(2),
                (int) list.get(3),
                (Date) list.get(4),
                (Date) list.get(5),
                coutTotal
        );
    }
}
