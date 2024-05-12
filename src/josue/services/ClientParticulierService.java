package josue.services;

import josue.entities.ClientParticulier;

import java.sql.SQLException;
import java.util.List;

public interface ClientParticulierService {

    void addClientParticulier(ClientParticulier client) throws SQLException;

    void updateClientParticulier(ClientParticulier client) throws SQLException;

    void deleteClientParticulier(int idClient) throws SQLException;

    ClientParticulier findClientParticulier(int idClient) throws SQLException;

    boolean checkAge(ClientParticulier client) throws SQLException;

    List<ClientParticulier> getClientParticulierList() throws SQLException;

    List<ClientParticulier> getAdultClientParticulierList() throws SQLException;


}
