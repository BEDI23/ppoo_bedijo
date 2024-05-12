package josue.entities;

import java.util.Date;

public class ClientParticulier extends  Client {

    private int idClient;
    private Date dateNaissance;
    private String lieuNaissance;

    public ClientParticulier(int id, String nom, String prenom, String telephone, Date dateNaissance, String lieuNaissance) {
        super(nom, prenom, telephone); // Appel au constructeur de la classe mère
        this.setId(id); // Définition de l'ID
        this.dateNaissance = dateNaissance; // Définition de la date de naissance
        this.lieuNaissance = lieuNaissance; // Définition du lieu de naissance
    }

    public ClientParticulier() {

        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    public ClientParticulier(int idClient, Date dateNaissance, String lieuNaissance) {
        this.idClient = idClient;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }



    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }
}
