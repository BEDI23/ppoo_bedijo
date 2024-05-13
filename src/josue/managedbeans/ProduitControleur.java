package josue.managedbeans;

import josue.entities.Produit;
import josue.services.ProduitService;
import josue.services.implementations.ProduitServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ProduitControleur {

    private ProduitService produitService = new ProduitServiceImpl();

    public void addProduit(Produit produit) throws SQLException {
        // Vérification de la valeur de l'attribut "actif"
        if (produit.getActif().equals("A") || produit.getActif().equals("N")) {
            // Vérification de la valeur de l'attribut "Libelle"
            if (produit.getLibelle().equals("Epargne") || produit.getLibelle().equals("Courant")) {
                produitService.addProduit(produit);
            } else {
                System.out.println("La valeur de l'attribut 'Libelle' doit être 'Epargne' ou 'Courant'.");
            }
        } else {
            // Si la valeur n'est ni "A" ni "N", afficher un message d'erreur
            System.out.println("La valeur de l'attribut 'actif' doit être 'A' pour actif ou 'N' pour non actif.");
        }
    }

    public List<Produit> getAllProduits() throws SQLException {
        return produitService.getAllProduits();
    }

    public Produit getProduitById(int idProduit)  throws SQLException {
        return produitService.getProduitById(idProduit);
    }

    public void updateProduit(Produit produit) throws SQLException {
        produitService.updateProduit(produit);
    }

    public void deleteProduit(int idProduit) throws SQLException {
        produitService.deleteProduit(idProduit);
    }
}
