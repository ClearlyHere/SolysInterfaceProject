package dataObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Location extends AbstractObject {
    private int id;
    private int id_client;
    private int id_vehicule;
    private int id_employe;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private float coutTotal;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Location(int id, int id_client, int id_vehicule, int id_employe, String dateDebut, String dateFin, float coutTotal) {
        this.id = id;
        this.id_client = id_client;
        this.id_vehicule = id_vehicule;
        this.id_employe = id_employe;
        this.dateDebut = LocalDate.parse(dateDebut, formatter);
        this.dateFin = LocalDate.parse(dateFin, formatter);
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

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = LocalDate.parse(dateDebut, formatter);
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = LocalDate.parse(dateFin, formatter);
    }

    public float getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(float coutTotal) {
        this.coutTotal = coutTotal;
    }
}
