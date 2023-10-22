package Model.dataRepository;

import Model.dataObjects.Employe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EmployeRepository extends AbstractRepository {
    private final String column1 = "ID_Employé";
    private final String column2 = "Nom";
    private final String column3 = "Prénom";
    private final String column4 = "Poste";
    private final String column5 = "Salaire";

    @Override
    String getPrimayKeyColumn() {
        return this.column1;
    }

    @Override
    String getNomTable() {
        return "employés";
    }

    @Override
    Employe construire(ArrayList<Object> list) {
        BigDecimal decimal = (BigDecimal) list.get(4);
        float salaire = decimal.floatValue();
        return new Employe(
                (int) list.get(0),
                (String) list.get(1),
                (String) list.get(2),
                (String) list.get(3),
                salaire
        );
    }
}
