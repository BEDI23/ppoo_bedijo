package josue.managedbeans;

import josue.entities.Client;
import josue.entities.ClientParticulier;
import josue.services.ClientParticulierService;
import josue.services.implementations.ClientParticulierServiceImpl;


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
}
