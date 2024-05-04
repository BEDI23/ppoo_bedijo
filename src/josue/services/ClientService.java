package josue.services;

import josue.entities.Client;
import java.util.List;

public interface ClientService {
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(int idClient);
    List<Client> getAllClients();
    Client getClientById(int idClient);
}
