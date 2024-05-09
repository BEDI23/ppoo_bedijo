package josue.entities;

public class Sms {

    private int id;
    private int idClient;
    private String libelle;
    private  boolean statue;

    public Sms(int id, int idClient, String libelle, boolean statue) {
        this.id = id;
        this.idClient = idClient;
        this.libelle = libelle;
        this.statue = statue;
    }

    public Sms(int idClient, String libelle, boolean statue) {
        this.idClient = idClient;
        this.libelle = libelle;
        this.statue = statue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isStatue() {
        return statue;
    }

    public void setStatue(boolean statue) {
        this.statue = statue;
    }
}
