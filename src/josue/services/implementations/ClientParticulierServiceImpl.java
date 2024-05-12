package josue.services.implementations;

import josue.entities.ClientParticulier;
import josue.services.ClientParticulierService;
import josue.utils.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientParticulierServiceImpl implements ClientParticulierService {

    @Override
    public void addClientParticulier(ClientParticulier client) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO client_particulier (nom, prenom, telephone, date_naissance, lieu_naissance) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getNom());
        statement.setString(2, client.getPrenom());
        statement.setString(3, client.getTelephone());
        statement.setDate(4, new java.sql.Date(client.getDateNaissance().getTime()));
        statement.setString(5, client.getLieuNaissance());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void updateClientParticulier(ClientParticulier client) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "UPDATE client_particulier SET nom = ?, prenom = ?, telephone = ?, date_naissance = ?, lieu_naissance = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getNom());
        statement.setString(2, client.getPrenom());
        statement.setString(3, client.getTelephone());
        statement.setDate(4, new java.sql.Date(client.getDateNaissance().getTime()));
        statement.setString(5, client.getLieuNaissance());
        statement.setInt(6, client.getId());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void deleteClientParticulier(int idClient) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "DELETE FROM client_particulier WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idClient);
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public ClientParticulier findClientParticulier(int idClient) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM client_particulier WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idClient);
        ResultSet resultSet = statement.executeQuery();
        ClientParticulier clientParticulier = null;
        if (resultSet.next()) {
            clientParticulier = new ClientParticulier();
            clientParticulier.setId(resultSet.getInt("id"));
            clientParticulier.setNom(resultSet.getString("nom"));
            clientParticulier.setPrenom(resultSet.getString("prenom"));
            clientParticulier.setTelephone(resultSet.getString("telephone"));
            clientParticulier.setDateNaissance(resultSet.getDate("date_naissance"));
            clientParticulier.setLieuNaissance(resultSet.getString("lieu_naissance"));
        }
        connection.close();
        return clientParticulier;
    }

    @Override
    public boolean checkAge(ClientParticulier client) throws SQLException {
        // Obtenez la date de naissance du client
        Date dateNaissance = client.getDateNaissance();

        // Calculez l'âge en années en utilisant la différence entre la date de naissance et la date actuelle
        LocalDate dateNaissanceLocal = dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateActuelle = LocalDate.now();
        int age = Period.between(dateNaissanceLocal, dateActuelle).getYears();

        // Vérifiez si l'âge est inférieur à 18 ans
        return age < 18;
    }


    @Override
    public List<ClientParticulier> getClientParticulierList() throws SQLException {
        List<ClientParticulier> clientsParticuliers = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM client_particulier";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ClientParticulier clientParticulier = new ClientParticulier();
            clientParticulier.setId(resultSet.getInt("id"));
            clientParticulier.setNom(resultSet.getString("nom"));
            clientParticulier.setPrenom(resultSet.getString("prenom"));
            clientParticulier.setTelephone(resultSet.getString("telephone"));
            clientParticulier.setDateNaissance(resultSet.getDate("date_naissance"));
            clientParticulier.setLieuNaissance(resultSet.getString("lieu_naissance"));
            clientsParticuliers.add(clientParticulier);
        }
        connection.close();
        return clientsParticuliers;
    }

    @Override
    public List<ClientParticulier> getAdultClientParticulierList() throws SQLException {
        List<ClientParticulier> adultClientsParticuliers = new ArrayList<>();

        // Connexion à la base de données et exécution de la requête SQL
        try (Connection connection = Connexion.getConnection()) {
            String sql = "SELECT * FROM client_particulier WHERE DATE_ADD(date_naissance, INTERVAL 18 YEAR) <= NOW()";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Parcours des résultats de la requête
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String telephone = resultSet.getString("telephone");
                Date dateNaissance = resultSet.getDate("date_naissance");
                String lieuNaissance = resultSet.getString("lieu_naissance");

                // Création d'un objet ClientParticulier à partir des données récupérées
                ClientParticulier clientParticulier = new ClientParticulier(id, nom, prenom, telephone, dateNaissance, lieuNaissance);
                adultClientsParticuliers.add(clientParticulier);
            }
        }

        return adultClientsParticuliers;
    }
}
