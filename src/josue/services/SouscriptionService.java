package josue.services;

import josue.entities.Souscription;

import java.util.List;

public interface SouscriptionService {

    void addSouscription(Souscription souscription);
    void updateSouscription(Souscription souscription);
    void deleteSouscription(int idSouscription);
    List<Souscription> getAllSouscriptions();
    Souscription getSouscriptionById(int idSouscription);
}
