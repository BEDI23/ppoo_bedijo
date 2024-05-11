package josue.managedbeans;

import josue.entities.Souscription;
import josue.services.SouscriptionService;
import josue.services.implementations.SouscriptionServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class SouscriptionControleur {

    private SouscriptionService souscriptionService = new SouscriptionServiceImpl();

    public void addSouscription(Souscription souscription) throws SQLException {
        souscriptionService.addSouscription(souscription);
    }

    public void updateSouscription(Souscription souscription) throws SQLException {
        souscriptionService.updateSouscription(souscription);
    }

    public void deleteSouscription(int idSouscription) throws SQLException {
        souscriptionService.deleteSouscription(idSouscription);
    }

    public List<Souscription> getAllSouscriptions() throws SQLException {
        return souscriptionService.getAllSouscriptions();
    }

    public Souscription getSouscriptionById(int idSouscription) throws SQLException {
        return souscriptionService.getSouscriptionById(idSouscription);
    }
}
