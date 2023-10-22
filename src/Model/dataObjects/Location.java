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
}
