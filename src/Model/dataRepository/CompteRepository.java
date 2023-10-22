package Model.dataRepository;

import Model.dataObjects.Compte;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CompteRepository extends AbstractRepository {
    private final String column1 = "Numéro_Compte";
    private final String column2 = "Titulaire";
    private final String column3 = "Solde";

    @Override
    protected String getNomTable() {
        return "comptes";
    }

    @Override
    protected Compte construire(ArrayList<Object> list) {
        int key = Integer.parseInt((String) list.get(0));
        BigDecimal decimal = (BigDecimal) list.get(2);
        float solde = decimal.floatValue();
        return new Compte(
                key,
                (String) list.get(1),
                solde
        );
    }
}
