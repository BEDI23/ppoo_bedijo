/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppoo_bedijo;

import josue.entities.Produit;
import josue.entities.Sms;
import josue.entities.Souscription;
import josue.managedbeans.ProduitControleur;
import josue.managedbeans.SmsControleur;
import josue.managedbeans.SouscriptionControleur;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BEDIN
 */
public class Ppoo_bedijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
      /*  try {
            // Récupération de la connexion
            Connection connexion = Connexion.getConnection();

            // Vérification de la réussite de la connexion
            if (connexion != null) {
                System.out.println("Connexion réussie à la base de données !");
            } else {
                System.out.println("La connexion à la base de données a échoué.");
            }

            // Fermeture de la connexion
            assert connexion != null;
            connexion.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
        */

        SmsControleur smsControleur = new SmsControleur();

        // Création d'un SMS
        Sms sms = new Sms(1, "Bonjour, ceci est un test de SMS !", true);

        // Envoi du SMS
        smsControleur.sendSms(sms);

        // Récupération de tous les SMS
        System.out.println("Tous les SMS : ");
        List<Sms> allSms = smsControleur.getAllSms();
        if (allSms != null) {
            for (Sms s : allSms) {
                System.out.println(s.getId() + ": " + s.getLibelle());
            }
        }

        // Récupération des SMS en attente
        System.out.println("SMS en attente : ");
        List<Sms> pendingSms = smsControleur.getPendingSms();
        if (pendingSms != null) {
            for (Sms s : pendingSms) {
                System.out.println(s.getId() + ": " + s.getLibelle());
            }
        }

        }
}
