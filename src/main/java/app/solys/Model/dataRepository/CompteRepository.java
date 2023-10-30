package app.solys.Model.dataRepository;

import app.solys.Model.dataObjects.Compte;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CompteRepository extends AbstractRepository {
    private final String column1 = "Numéro_Compte";
    private final String column2 = "Titulaire";
    private final String column3 = "Solde";

    @Override
    String getPrimayKeyColumn() {
        return this.column1;
    }

    @Override
    String getNomTable() {
        return "comptes";
    }

    @Override
    Compte construire(ArrayList<Object> list) {
        BigDecimal decimal = (BigDecimal) list.get(2);
        float solde = decimal.floatValue();
        return new Compte(
                (int) list.get(0),
                (String) list.get(1),
                solde
        );
    }
}
