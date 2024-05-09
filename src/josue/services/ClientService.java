package josue.services;

import josue.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface  ClientService {
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(int idClient);
    List<Client> getAllClients() throws SQLException;
    Client getClientById(int idClient);
}
