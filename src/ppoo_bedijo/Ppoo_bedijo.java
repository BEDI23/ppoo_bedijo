/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppoo_bedijo;

import josue.entities.*;
import josue.managedbeans.*;
import josue.utils.Connexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BEDIN
 */
public class Ppoo_bedijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        /*try {
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
        /*// Effectuer les souscriptions

        SouscriptionControleur souscriptionControleur = new SouscriptionControleur();

        // Souscription pour le produit "Epargne" pour un client de votre choix
        souscriptionControleur.addSouscription(new Souscription(1, new Date(), "A", 35, 35));
        // Souscription pour le produit "Courant" pour un autre client de votre choix
        souscriptionControleur.addSouscription(new Souscription(2, new Date(), "N", 35, 35));

        // Enregistrer les SMS de souscription*/
/*
        SmsControleur smsControleur = new SmsControleur();
*/
        /*List<Souscription> souscriptions = souscriptionControleur.getAllSouscriptions();
        for (Souscription souscription : souscriptions) {
            Sms sms = new Sms(souscription.getIdClient(), "Votre souscription a été traitée avec succès.", true);
            smsControleur.sendSms(sms);
        }*/

        // Afficher la liste des SMS
        /*List<Sms> sentSms = smsControleur.getAllSms();
        System.out.println("Liste des SMS déjà envoyés : ");
        for (Sms sms : sentSms) {
            System.out.println("ID: " + sms.getId() + ", Libellé: " + sms.getLibelle());
        }

        List<Sms> pendingSms = smsControleur.getPendingSms();
        System.out.println("\nListe des SMS en attente d'envoi : ");
        for (Sms sms : pendingSms) {
            System.out.println("ID: " + sms.getId() + ", Libellé: " + sms.getLibelle());
        }*/


       /* ClientParticulierControleur clientParticulierController = new ClientParticulierControleur();

        // Ajouter un client particulier
        ClientParticulier client1 = new ClientParticulier();
        client1.setId(35);
        client1.setDateNaissance(new Date(10/9/2022)); // Remplacez new Date() par la date de naissance souhaitée
        client1.setLieuNaissance("Paris");
        clientParticulierController.addClientParticulier(client1);*/

/*        // Lire un client particulier par son ID
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


        ClientParticulierControleur clientParticulierControleur = new ClientParticulierControleur();
        ClientControleur clientControleur = new ClientControleur();
        ProduitControleur produitControleur = new ProduitControleur();
        SouscriptionControleur souscriptionControleur = new SouscriptionControleur();
        SmsControleur smsControleur = new SmsControleur();
        Scanner scanner = new Scanner(System.in);

        // Boucle pour imposer d'ajouter des clients
       /* boolean ajoutClient = true;
        while (ajoutClient) {
            // Demander à l'utilisateur de saisir les informations du client
            System.out.println("Ajout d'un client :");
            System.out.println("Saisissez le nom du client :");
            String nom = scanner.nextLine();
            System.out.println("Saisissez le prénom du client :");
            String prenom = scanner.nextLine();
            System.out.println("Saisissez le téléphone du client :");
            String telephone = scanner.nextLine();

            // Ajouter le client
            try {
                clientControleur.addClient(new Client(nom, prenom, telephone));
                System.out.println("Client ajouté avec succès !");
                ajoutClient = false; // Sortir de la boucle après l'ajout réussi du client
            } catch (SQLException e) {
                System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
                System.out.println("Veuillez réessayer.");
            }
        }*/

        // Ajout d'un produit
        /*try {
            System.out.println("Ajout d'un produit :");
            System.out.println("Saisissez le libellé du produit (Epargne ou Courant) :");
            String libelleProduit = scanner.nextLine();
            if (!libelleProduit.equals("Epargne") && !libelleProduit.equals("Courant")) {
                throw new IllegalArgumentException("Le libellé du produit doit être 'Epargne' ou 'Courant'.");
            }

            System.out.println("Saisissez l'état du produit (A pour actif, N pour non actif) :");
            String etatProduit = scanner.nextLine();
            if (!etatProduit.equals("A") && !etatProduit.equals("N")) {
                throw new IllegalArgumentException("L'état du produit doit être 'A' pour actif ou 'N' pour non actif.");
            }

            produitControleur.addProduit(new Produit(libelleProduit, etatProduit));
            System.out.println("Produit ajouté avec succès !");
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
*/
/*

        // Ajout d'une souscription
        try {
            System.out.println("Ajout d'une souscription :");
            System.out.println("Saisissez l'ID du client :");
            int idClient = Integer.parseInt(scanner.nextLine());
            System.out.println("Saisissez l'ID du produit :");
            int idProduit = Integer.parseInt(scanner.nextLine());
            souscriptionControleur.addSouscription(new Souscription(new Date(), "A", idClient, idProduit));
            System.out.println("Souscription ajoutée avec succès !");
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erreur lors de l'ajout de la souscription : " + e.getMessage());
        }
*/
        // Recherche du client par son nom
        System.out.println("Entrez le nom du client que vous souhaitez transformer en client particulier :");
        String nomClient = scanner.nextLine();

        Client client = clientControleur.getClientByNom(nomClient);
        if (client == null) {
            System.out.println("Aucun client trouvé avec ce nom.");
        } else {
            // Afficher les informations du client trouvé
            System.out.println("Informations du client trouvé :");
            System.out.println("ID : " + client.getId());
            System.out.println("Nom : " + client.getNom());
            System.out.println("Prénom : " + client.getPrenom());
            System.out.println("Téléphone : " + client.getTelephone());

            // Demander les informations supplémentaires pour le client particulier
            System.out.println("Entrez la date de naissance du client (format: yyyy-MM-dd) :");
            String dateNaissanceStr = scanner.nextLine();
            System.out.println("Entrez le lieu de naissance du client :");
            String lieuNaissance = scanner.nextLine();

            // Conversion de la date de naissance en objet Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateNaissance = sdf.parse(dateNaissanceStr);

            // Création d'un nouvel objet ClientParticulier avec les informations supplémentaires
            ClientParticulier clientParticulier = new ClientParticulier(client.getId(), dateNaissance, lieuNaissance);

            // Appel de la méthode d'ajout du client particulier dans le contrôleur
            clientParticulierControleur.addClientParticulier(clientParticulier);
            System.out.println("Client particulier ajouté avec succès !");
        }


    }
}
