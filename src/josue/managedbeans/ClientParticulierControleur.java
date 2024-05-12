package josue.managedbeans;

import josue.entities.ClientParticulier;
import josue.services.ClientParticulierService;


import java.sql.SQLException;
import java.util.List;

public class ClientParticulierControleur {

    private ClientParticulierService clientParticulierService;

    public void ajouterClientParticulier( ClientParticulier client) throws SQLException {
        clientParticulierService.addClientParticulier(client);
    }

    public void modifierClientParticulier( int id,  ClientParticulier client) throws SQLException {
        client.setId(id);
        clientParticulierService.updateClientParticulier(client);
    }

    public void supprimerClientParticulier( int id) throws SQLException {
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
}
