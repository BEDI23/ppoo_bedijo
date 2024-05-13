package josue.managedbeans;

import josue.entities.Client;
import josue.services.ClientService;
import josue.services.implementations.ClientServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ClientControleur {

    private ClientService clientService = new ClientServiceImpl();

    public void addClient(Client client) throws SQLException {
        clientService.addClient(client);
    }

    public List<Client> getAllClients() throws SQLException {
        return clientService.getAllClients();
    }

    public Client getClientById(int idClient) throws SQLException {
        return clientService.getClientById(idClient);

    }

    public Client getClientByNom(String nom) throws SQLException {
        return clientService.getClientByNom(nom);

    }

    public void updateClient(Client client) throws SQLException {
        clientService.updateClient(client);
    }

    public void deleteClient(int idClient) throws SQLException {
        clientService.deleteClient(idClient);
    }
}
