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

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }
}
