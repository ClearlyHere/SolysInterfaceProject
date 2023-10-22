package Model.dataObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction extends AbstractObject {
    private int id;
    private int numCompteSource;
    private int numCompteCible;
    private float montant;
    private LocalDate dateTransaction;
    private static final  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static DateTimeFormatter getFormatter(){
        return formatter;
    }

    public Transaction(int id, int numCompteSource, int numCompteCible, float montant, String dateTransaction) {
        this.id = id;
        this.numCompteSource = numCompteSource;
        this.numCompteCible = numCompteCible;
        this.montant = montant;
        this.dateTransaction = LocalDate.parse(dateTransaction, formatter);
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

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = LocalDate.parse(dateTransaction, formatter);
    }
}
