package app.solys.Model.dataObjects;

public class Employe extends AbstractObject {
    private int id;
    private String nom;
    private String prenom;
    private String poste;
    private float salaire;

    public Employe(int id, String nom, String prenom, String poste, float salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
    }
}
