package josue.services;

import josue.entities.Client;
import josue.entities.ClientParticulier;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {

     List<Client> getAllClients() throws SQLException;

     Client getClientById(int idClient) throws SQLException;

     void addClient(Client client) throws SQLException;

     void updateClient(Client client) throws SQLException;

     void deleteClient(int idClient) throws SQLException;

}
