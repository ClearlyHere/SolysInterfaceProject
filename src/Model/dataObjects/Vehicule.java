package Model.dataObjects;

public class Vehicule extends AbstractObject {
    private int id;
    private String marque;
    private String modele;
    private int anneeFabrication;
    private String plaqueImmat;
    private float prixLocJournee;

    public Vehicule(int id, String marque, String modele, int anneeFabrication, String plaqueImmat, float prixLocJournee) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.anneeFabrication = anneeFabrication;
        this.plaqueImmat = plaqueImmat;
        this.prixLocJournee = prixLocJournee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public String getPlaqueImmat() {
        return plaqueImmat;
    }

    public void setPlaqueImmat(String plaqueImmat) {
        this.plaqueImmat = plaqueImmat;
    }

    public float getPrixLocJournee() {
        return prixLocJournee;
    }

    public void setPrixLocJournee(float prixLocJournee) {
        this.prixLocJournee = prixLocJournee;
    }
}
