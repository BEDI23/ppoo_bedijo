package josue.services;

import josue.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitService {

         void addProduit(Produit produit) throws SQLException;

         void updateProduit(Produit produit) throws SQLException;

         void deleteProduit(int idProduit) throws SQLException;

         List<Produit> getAllProduits() throws SQLException;

         Produit getProduitById(int idProduit) throws SQLException;


    }
