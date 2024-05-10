package josue.services;

import josue.entities.Souscription;

import java.sql.SQLException;
import java.util.List;

public interface SouscriptionService {

    void addSouscription(Souscription souscription) throws SQLException;

    void updateSouscription(Souscription souscription) throws SQLException;

    void deleteSouscription(int idSouscription) throws SQLException;

    List<Souscription> getAllSouscriptions() throws SQLException;

    Souscription getSouscriptionById(int idSouscription) throws SQLException;

}
