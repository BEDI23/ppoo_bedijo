package josue.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import josue.entities.Produit;
import josue.services.ProduitService;
import josue.utils.Connexion;

public class ProduitServiceImpl implements ProduitService {

    @Override
    public List<Produit> getAllProduits() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM Produit";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Produit produit = new Produit();
            produit.setId(resultSet.getInt("id"));
            produit.setLibelle(resultSet.getString("libelle"));
            produit.setActif(resultSet.getString("actif"));
            produits.add(produit);
        }
        connection.close();
        return produits;
    }

    @Override
    public Produit getProduitById(int idProduit)  throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM Produit WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idProduit);
        ResultSet resultSet = statement.executeQuery();
        Produit produit = null;
        if (resultSet.next()) {
            produit = new Produit();
            produit.setId(resultSet.getInt("id"));
            produit.setLibelle(resultSet.getString("libelle"));
            produit.setActif(resultSet.getString("actif"));
        }
        connection.close();
        return produit;
    }

    @Override
    public void addProduit(Produit produit) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO Produit (libelle, actif) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, produit.getLibelle());
        statement.setString(2, produit.getActif());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void updateProduit(Produit produit) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "UPDATE Produit SET libelle = ?, actif = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, produit.getLibelle());
        statement.setString(2, produit.getActif());
        statement.setInt(3, produit.getId());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void deleteProduit(int idProduit) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "DELETE FROM Produit WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idProduit);
        statement.executeUpdate();
        connection.close();
    }
}
