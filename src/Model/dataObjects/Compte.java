package Model.dataObjects;

public class Compte extends AbstractObject {
    private int numCompte;
    private String titulaire;
    private Float solde;

    public Compte(int numCompte, String titulaire, Float solde) {
        this.numCompte = numCompte;
        this.titulaire = titulaire;
        this.solde = solde;
    }
}
