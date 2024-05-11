package josue.managedbeans;

import josue.entities.Sms;
import josue.services.SmsService;
import josue.services.implementations.SmsServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class SmsControleur {

    private final SmsService smsService = new SmsServiceImpl();

    public void sendSms(Sms sms) {
        try {
            smsService.sendSms(sms);
            System.out.println("SMS envoyé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'envoi du SMS : " + e.getMessage());
        }
    }

    public List<Sms> getAllSms() {
        try {
            return smsService.getAllSms();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de tous les SMS : " + e.getMessage());
            return null;
        }
    }

    public List<Sms> getPendingSms() {
        try {
            return smsService.getPendingSms();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des SMS en attente : " + e.getMessage());
            return null;
        }
    }
}
