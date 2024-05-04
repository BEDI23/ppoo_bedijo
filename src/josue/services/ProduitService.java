package josue.services;

import josue.entities.Produit;
import java.util.List;

public interface ProduitService {

    void addProduit(Produit produit);
    void updateProduit(Produit produit);
    void deleteProduit(int idProduit);
    List<Produit> getAllProduits();
    Produit getProduitById(int idProduit);
}
