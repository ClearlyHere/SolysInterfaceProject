package app.solys.Model.dataObjects;

public class Client extends AbstractObject {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String numTelephone;

    public Client(int id, String nom, String prenom, String adresse, String numTelephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numTelephone = numTelephone;
    }
}
