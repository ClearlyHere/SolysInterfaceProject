package Model.dataRepository;

import Model.dataObjects.Transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class TransactionRepository extends AbstractRepository {
    private final String column1 = "ID_Transaction";
    private final String column2 = "Numéro_Compte_Source";
    private final String column3 = "Numéro_Compte_Cible";
    private final String column4 = "Montant";
    private final String column5 = "Date_Transaction";

    @Override
    String getPrimayKeyColumn() {
        return this.column1;
    }

    @Override
    String getNomTable() {
        return "transactions";
    }

    @Override
    Transaction construire(ArrayList<Object> list) {
        int compteSource = Integer.parseInt((String) list.get(1));
        int compteCible = Integer.parseInt((String) list.get(2));
        BigDecimal decimal = (BigDecimal) list.get(3);
        float montant = decimal.floatValue();
        return new Transaction(
                (int) list.get(0),
                compteSource,
                compteCible,
                montant,
                (Date) list.get(4)
        );
    }
}
