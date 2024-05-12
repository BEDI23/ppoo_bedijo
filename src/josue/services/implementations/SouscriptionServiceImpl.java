package josue.services.implementations;

import josue.entities.Souscription;
import josue.services.SouscriptionService;
import josue.utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SouscriptionServiceImpl implements SouscriptionService {

    @Override
    public void addSouscription(Souscription souscription) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO souscription (dateHeureSous, actif, idClient, idProduit) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new java.sql.Date(souscription.getDateHeureSous().getTime()));  // Convert to SQL Date
        statement.setString(2, souscription.getActif());
        statement.setInt(3, souscription.getIdClient());
        statement.setInt(4, souscription.getIdProduit());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void updateSouscription(Souscription souscription) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "UPDATE souscription SET dateHeureSous = ?, actif = ?, idClient = ?, idProduit = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new java.sql.Date(souscription.getDateHeureSous().getTime()));
        statement.setString(2, souscription.getActif());
        statement.setInt(3, souscription.getIdClient());
        statement.setInt(4, souscription.getIdProduit());
        statement.setInt(5, souscription.getId());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void deleteSouscription(int idSouscription) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "DELETE FROM souscription WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idSouscription);
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public List<Souscription> getAllSouscriptions() throws SQLException {
        List<Souscription> souscriptions = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM souscription";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Souscription souscription = new Souscription(
                    resultSet.getInt("id"),
                    resultSet.getDate("dateHeureSous"),
                    resultSet.getString("actif"),
                    resultSet.getInt("idClient"),
                    resultSet.getInt("idProduit")
            );
            souscriptions.add(souscription);
        }
        connection.close();
        return souscriptions;
    }

    @Override
    public Souscription getSouscriptionById(int idSouscription) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM souscription WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idSouscription);
        ResultSet resultSet = statement.executeQuery();
        Souscription souscription = null;
        if (resultSet.next()) {
            souscription = new Souscription(
                    resultSet.getInt("id"),
                    resultSet.getDate("dateHeureSous"),
                    resultSet.getString("actif"),
                    resultSet.getInt("idClient"),
                    resultSet.getInt("idProduit")
            );
        }
        connection.close();
        return souscription;
    }
}
