package Model.dataObjects;

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

    @Override
    public int getPrimaryKey() {
        return this.id;
    }

    public void setPrimaryKey(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String NumTelephone) {
        this.numTelephone = NumTelephone;
    }
}
