/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppoo_bedijo;

import josue.entities.*;
import josue.managedbeans.*;

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

            // Initialisation des contrôleurs
       /* // Ajouter les clients
        ClientControleur clientControleur = new ClientControleur();
        clientControleur.addClient(new Client("Jean", "Dupont", "1234567890"));
        clientControleur.addClient(new Client("Alice", "Martin", "9876543210"));
        clientControleur.addClient(new Client("Pierre", "Durand", "4567890123"));
        clientControleur.addClient(new Client("Sophie", "Lefevre", "7890123456"));
*/
        // Ajouter les produits
      /*  ProduitControleur produitControleur = new ProduitControleur();
        produitControleur.addProduit(new Produit("Epargne", "A"));
        produitControleur.addProduit(new Produit("Courant", "N"));
*/
        // Effectuer les souscriptions

        SouscriptionControleur souscriptionControleur = new SouscriptionControleur();

        // Souscription pour le produit "Epargne" pour un client de votre choix
        souscriptionControleur.addSouscription(new Souscription(1, new Date(), "A", 35, 35));
        // Souscription pour le produit "Courant" pour un autre client de votre choix
        souscriptionControleur.addSouscription(new Souscription(2, new Date(), "N", 35, 35));

        // Enregistrer les SMS de souscription
        SmsControleur smsControleur = new SmsControleur();
        List<Souscription> souscriptions = souscriptionControleur.getAllSouscriptions();
        for (Souscription souscription : souscriptions) {
            Sms sms = new Sms(souscription.getIdClient(), "Votre souscription a été traitée avec succès.", true);
            smsControleur.sendSms(sms);
        }

        // Afficher la liste des SMS
        List<Sms> sentSms = smsControleur.getAllSms();
        System.out.println("Liste des SMS déjà envoyés : ");
        for (Sms sms : sentSms) {
            System.out.println("ID: " + sms.getId() + ", Libellé: " + sms.getLibelle());
        }

        List<Sms> pendingSms = smsControleur.getPendingSms();
        System.out.println("\nListe des SMS en attente d'envoi : ");
        for (Sms sms : pendingSms) {
            System.out.println("ID: " + sms.getId() + ", Libellé: " + sms.getLibelle());
        }


       /* ClientParticulierControleur clientParticulierController = new ClientParticulierControleur();

        // Ajouter un client particulier
        ClientParticulier client1 = new ClientParticulier();
        client1.setId(30);
        client1.setDateNaissance(new Date(10/9/2022)); // Remplacez new Date() par la date de naissance souhaitée
        client1.setLieuNaissance("Paris");
        clientParticulierController.addClientParticulier(client1);

        // Lire un client particulier par son ID
        ClientParticulier client = clientParticulierController.getClientParticulier(30);
        System.out.println("Client lu : " + client.getLieuNaissance());

        // Mettre à jour un client particulier
        ClientParticulier clientToUpdate = clientParticulierController.getClientParticulier(30);
        clientToUpdate.setNom("Jane");
        clientToUpdate.setPrenom("Doe");
        clientParticulierController.updateClientParticulier(30, clientToUpdate);

        // Supprimer un client particulier
        clientParticulierController.deleteClientParticulier(30);

        // Lister tous les clients particuliers
        List<ClientParticulier> clients = clientParticulierController.getClientParticulierList();
        System.out.println("Liste des clients particuliers : " + clients);

        // Lister tous les clients particuliers adultes
        List<ClientParticulier> adultClients = clientParticulierController.getAdultClientParticulierList();
        System.out.println("Liste des clients particuliers adultes : " + adultClients);*/
    }
}
