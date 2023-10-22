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
}
