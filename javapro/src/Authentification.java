import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Authentification {
		private ArrayList<Utilisateur> listeUtilisateurs;
		private final String NOM_FICHIER = "utilisateurs.txt"; //fichier de sauvegarde des mots de passe
		public Authentification() {
	        this.listeUtilisateurs = new ArrayList<>();
	        chargerDonnees();// On charge les comptes existants dès la création
		}
		// Créer un compte
	    public boolean inscrire(String pseudo, String mdp) {
	        for (Utilisateur u : listeUtilisateurs) {
	        	if(u.getPseudo().equals(pseudo)){ // verifie si le compte existe déjà
	        		System.out.println("Pseudo déjà existant");
	        		return false;
	        	}
	        }
	        Utilisateur nouveau = new Utilisateur(pseudo, mdp);
	       	listeUtilisateurs.add(nouveau);
	       	System.out.println("Compte créé pour " + pseudo);
	       	sauvegarderDonnees();
	       	return true;
	    }
	 // Vérifier la connexion
	    public Utilisateur connecter(String pseudo, String mdp) {
	        for (Utilisateur u : listeUtilisateurs) {
	            if (u.getPseudo().equals(pseudo) && u.getMotDePasse().equals(mdp)) {
	            	System.out.println("Bienvenue  "+u.getPseudo());
	                return u; // Connexion réussie, on renvoie l'utilisateur
	            }
	        }
	        return null; // Échec de connexion
	    }
	    //sauvegarder les comptes cree
	    void sauvegarderDonnees() {
	    	try (PrintWriter writer = new PrintWriter(new FileWriter(NOM_FICHIER))) {
	            for (Utilisateur u : listeUtilisateurs) {
	                // On écrit : pseudo,mdp
	                writer.println(u.getPseudo() + "," + u.getMotDePasse());
	            }
	        } catch (IOException e) {
	            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
	        }
	    }
	    private void chargerDonnees() {
	        File fichier = new File(NOM_FICHIER);
	        if (!fichier.exists()) return; // Si le fichier n'existe pas encore, on ne fait rien

	        try (Scanner reader = new Scanner(fichier)) {
	            while (reader.hasNextLine()) {
	                String ligne = reader.nextLine();
	                String[] parties = ligne.split(","); // On découpe la ligne à chaque virgule
	                
	                if (parties.length == 2) {
	                    Utilisateur u = new Utilisateur(parties[0], parties[1]);
	                    listeUtilisateurs.add(u);
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Fichier introuvable.");
	        }
	    }

}
