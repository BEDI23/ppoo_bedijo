package josue.managedbeans;

import josue.entities.ClientParticulier;
import josue.entities.Sms;
import josue.entities.Souscription;
import josue.services.SouscriptionService;
import josue.services.implementations.SouscriptionServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class SouscriptionControleur {

    private SouscriptionService souscriptionService = new SouscriptionServiceImpl();
    private SmsControleur smsControleur = new SmsControleur();
    private ClientParticulierControleur clientParticulierControleur = new ClientParticulierControleur();

    public void addSouscription(Souscription souscription) throws SQLException {
        boolean isParticulier = clientParticulierControleur.isClientParticulier(souscription.getIdClient());
        boolean isAdultParticulier = isParticulier && isAdultClientParticulier(souscription.getIdClient());

        if (!isAdultParticulier && souscription.getActif().equals("Epargne")) {
            System.out.println("Vous ne pouvez pas souscrire à l'épargne.");
        } else {
            souscriptionService.addSouscription(souscription);
            String libelleSms = "Souscription effectuée pour le produit " + souscription.getIdProduit();
            Sms sms = new Sms(souscription.getIdClient(), libelleSms, false); // Le statut du SMS est initialisé à "non envoyé"
            smsControleur.sendSms(sms);
            System.out.println("SMS envoyé avec succès !");
        }
    }

    private boolean isAdultClientParticulier(int idClient) throws SQLException {
        List<ClientParticulier> adultClientParticuliers = clientParticulierControleur.getAdultClientParticulierList();
        for (ClientParticulier clientParticulier : adultClientParticuliers) {
            if (clientParticulier.getId() == idClient) {
                return true;
            }
        }
        return false;
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
