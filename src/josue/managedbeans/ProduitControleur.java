package josue.managedbeans;

import josue.entities.Produit;
import josue.services.ProduitService;
import josue.services.implementations.ProduitServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ProduitControleur {

    private ProduitService produitService = new ProduitServiceImpl();

    public void addProduit(Produit produit) throws SQLException {
        produitService.addProduit(produit);
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
