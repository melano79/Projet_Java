import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lecteurClavier = new Scanner(System.in);
		System.out.println("--- Bienvenue dans SATviewer ---");
        System.out.println("Choisissez un groupe : 1. Météo | 2. Starlink | 3. GPS");
        int choix = lecteurClavier.nextInt();
        String urlCible = "";
        
     // Sélection de l'URL selon le choix
        switch(choix) {
        case 1: urlCible = "https://celestrak.org/NORAD/elements/weather.txt"; break;
        case 2: urlCible = "https://celestrak.org/NORAD/elements/starlink.txt"; break;
        case 3: urlCible = "https://celestrak.org/NORAD/elements/gps-ops.txt"; break;
        default: urlCible = "https://celestrak.org/NORAD/elements/stations.txt";
        }
        telechargerEtAfficher(urlCible);
	}

	public static void telechargerEtAfficher(String adresseUrl) {
        try {
			URL url = new URI(adresseUrl).toURL();
            Scanner sc = new Scanner(url.openStream());
            ArrayList<Satellite> listeSat = new ArrayList<>();
         // Notre PARSEUR TLE : on lit 3 lignes par 3 lignes
            while (sc.hasNextLine()) {
                String ligne0 = sc.nextLine().trim(); // Nom
                if (!sc.hasNextLine()) break;
                String ligne1 = sc.nextLine();        // Ligne 1 TLE
                if (!sc.hasNextLine()) break;
                String ligne2 = sc.nextLine();        // Ligne 2 TLE
             // Extraction simple : 
                // ID est souvent entre l'index 2 et 7 de la ligne 1
                String id = ligne1.substring(2, 7).trim();
                // Inclinaison est souvent entre l'index 8 et 16 de la ligne 2
                String inclinaison = ligne2.substring(8, 16).trim();

                listeSat.add(new Satellite(ligne0, id, inclinaison));
        }
            
         // Affichage des 10 premiers pour tester
            for (int i = 0; i < 10 && i < listeSat.size(); i++) {
                System.out.println(listeSat.get(i));
            }
            System.out.println(listeSat.size());
            sc.close();
        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
	}
}
