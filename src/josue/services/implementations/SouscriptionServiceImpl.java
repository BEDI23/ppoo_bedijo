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
        if (isClientParticulier(souscription.getIdClient())) {
            addSouscriptionClientParticulier(souscription);
        } else {
            addSouscriptionClient(souscription);
        }
    }

    private void addSouscriptionClientParticulier(Souscription souscription) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO souscription (dateHeureSous, actif, idClient, idProduit) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new java.sql.Date(souscription.getDateHeureSous().getTime()));
        statement.setString(2, souscription.getActif());
        statement.setInt(3, souscription.getIdClient());
        statement.setInt(4, souscription.getIdProduit());
        statement.executeUpdate();
        connection.close();
    }

    private void addSouscriptionClient(Souscription souscription) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO souscription (dateHeureSous, actif, idClient, idProduit) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new java.sql.Date(souscription.getDateHeureSous().getTime()));
        statement.setString(2, souscription.getActif());
        statement.setInt(3, souscription.getIdClient());
        statement.setInt(4, souscription.getIdProduit());
        statement.executeUpdate();
        connection.close();
    }

    public boolean isClientParticulier(int idClient) throws SQLException {
        boolean isParticulier = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Connexion.getConnection();
            String sql = "SELECT id_client FROM clientparticulier WHERE id_client = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idClient);
            resultSet = statement.executeQuery();

            // Si une ligne est retournée, le client est un client particulier
            isParticulier = resultSet.next();
        } finally {
            // Fermer les ressources JDBC dans le bloc finally pour éviter les fuites de ressources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return isParticulier;
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
