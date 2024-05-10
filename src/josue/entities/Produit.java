package josue.entities;

public class Produit {

    private int id;
    private String libelle;
    private String actif;

    public Produit() {
        this.id = id;
        this.libelle = libelle;
        this.actif = actif;
    }

    public Produit(String libelle, String actif) {
        this.libelle = libelle;
        this.actif = actif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }
}

