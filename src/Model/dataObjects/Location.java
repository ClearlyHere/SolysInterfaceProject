package Model.dataObjects;

import java.sql.Date;

public class Location extends AbstractObject {
    private int id;
    private int id_client;
    private int id_vehicule;
    private int id_employe;
    private Date dateDebut;
    private Date dateFin;
    private float coutTotal;

    public Location(int id, int id_client, int id_vehicule, int id_employe, Date dateDebut, Date dateFin, float coutTotal) {
        this.id = id;
        this.id_client = id_client;
        this.id_vehicule = id_vehicule;
        this.id_employe = id_employe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.coutTotal = coutTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(float coutTotal) {
        this.coutTotal = coutTotal;
    }

}
