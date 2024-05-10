package josue.managedbeans;

import josue.entities.Client;
import josue.services.ClientService;
import josue.services.implementations.ClientServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ClientControleur {

    private ClientService clientService =  new ClientServiceImpl();

    public void addClient(Client client) throws SQLException {
        clientService.addClient(client);
    }

    public List<Client> getAllClients() throws SQLException {
      return   clientService.getAllClients();
    }


    }
