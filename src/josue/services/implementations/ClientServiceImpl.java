package josue.services.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import josue.entities.Client;
import josue.services.ClientService;
import josue.utils.Connexion;

public class ClientServiceImpl implements ClientService {

    @Override
    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM client";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setNom(resultSet.getString("nom"));
            client.setPrenom(resultSet.getString("prenom"));
            client.setTelephone(resultSet.getString("telephone"));
            clients.add(client);
        }
        connection.close();
        return clients;
    }

    @Override
    public Client getClientById(int idClient) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM client WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idClient);
        ResultSet resultSet = statement.executeQuery();
        Client client = null;
        if (resultSet.next()) {
            client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setNom(resultSet.getString("nom"));
            client.setPrenom(resultSet.getString("prenom"));
            client.setTelephone(resultSet.getString("telephone"));
        }
        connection.close();
        return client;


    } @Override
    public Client getClientByNom(String nom) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "SELECT * FROM client WHERE nom = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nom);
        ResultSet resultSet = statement.executeQuery();
        Client client = null;
        if (resultSet.next()) {
            client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setNom(resultSet.getString("nom"));
            client.setPrenom(resultSet.getString("prenom"));
            client.setTelephone(resultSet.getString("telephone"));
        }
        connection.close();
        return client;
    }


        @Override
    public void addClient(Client client) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "INSERT INTO client (nom, prenom, telephone) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getNom());
        statement.setString(2, client.getPrenom());
        statement.setString(3, client.getTelephone());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "UPDATE client SET nom = ?, prenom = ?, telephone = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getNom());
        statement.setString(2, client.getPrenom());
        statement.setString(3, client.getTelephone());
        statement.setInt(4, client.getId());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    public void deleteClient(int idClient) throws SQLException {
        Connection connection = Connexion.getConnection();
        String sql = "DELETE FROM client WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idClient);
        statement.executeUpdate();
        connection.close();
    }




}
