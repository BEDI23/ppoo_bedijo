package josue.managedbeans;

import josue.entities.Client;
import josue.entities.ClientParticulier;
import josue.services.ClientParticulierService;
import josue.services.implementations.ClientParticulierServiceImpl;
import josue.utils.Connexion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientParticulierControleur {

    private ClientParticulierService clientParticulierService = new ClientParticulierServiceImpl();
    ClientControleur clientControleur = new ClientControleur();

    public void addClientParticulier(ClientParticulier client) throws SQLException {
        Client client1 = clientControleur.getClientById(client.getId());
        if (client1 == null){
            System.out.println("Cet client pour cet identifiant n'existe pas ");
        }else {
            clientParticulierService.addClientParticulier(client);
        }
    }

    public void updateClientParticulier( int id,  ClientParticulier client) throws SQLException {
        client.setId(id);
        clientParticulierService.updateClientParticulier(client);
    }

    public void deleteClientParticulier( int id) throws SQLException {
        clientParticulierService.deleteClientParticulier(id);
    }

    public ClientParticulier getClientParticulier( int id) throws SQLException {
        return clientParticulierService.findClientParticulier(id);
    }

    public List<ClientParticulier> getClientParticulierList() throws SQLException {
        return clientParticulierService.getClientParticulierList();
    }

    public List<ClientParticulier> getAdultClientParticulierList() throws SQLException {
        return clientParticulierService.getAdultClientParticulierList();
    }

    public boolean checkAge( int id) throws SQLException {
        ClientParticulier client = clientParticulierService.findClientParticulier(id);
        return clientParticulierService.checkAge(client);
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
}
