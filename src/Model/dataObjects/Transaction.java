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

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCompteSource() {
        return numCompteSource;
    }

    public void setNumCompteSource(int numCompteSource) {
        this.numCompteSource = numCompteSource;
    }

    public int getNumCompteCible() {
        return numCompteCible;
    }

    public void setNumCompteCible(int numCompteCible) {
        this.numCompteCible = numCompteCible;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
