package Model.dataObjects;

import java.sql.Date;

public class Transaction extends AbstractObject {
    private int id;
    private int numCompteSource;
    private int numCompteCible;
    private float montant;
    private Date dateTransaction;

    public Transaction(int id, int numCompteSource, int numCompteCible, float montant, Date dateTransaction) {
        this.id = id;
        this.numCompteSource = numCompteSource;
        this.numCompteCible = numCompteCible;
        this.montant = montant;
        this.dateTransaction = dateTransaction;
    }
}
