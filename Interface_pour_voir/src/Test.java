import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        // Toujours lancer l'interface graphique dans l'Event Dispatch Thread
        SwingUtilities.invokeLater(Test::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Création des fenêtres
        JFrame SeeStar_Page_Acceuil = new JFrame("SeeStar - Bienvenu");
        JFrame SeeStar_Page_Principal_BDD_Distante = new JFrame("SeeStar - Page principal");
        JFrame SeeStar_Page_Sat_Met = new JFrame("SeeStar - Satellites Météo");
        JFrame SeeStar_Page_Sat_StL = new JFrame("SeeStar - Satellites StarLink");
        JFrame SeeStar_Page_Sat_GPS = new JFrame("SeeStar - Satellites GPS");
        
        //Manière de fermer les fenêtres
        SeeStar_Page_Acceuil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeeStar_Page_Principal_BDD_Distante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeeStar_Page_Sat_Met.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeeStar_Page_Sat_StL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeeStar_Page_Sat_GPS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Taille de la fenêtre (longueur, largeur)
        SeeStar_Page_Acceuil.setSize(800, 300);
        SeeStar_Page_Principal_BDD_Distante.setSize(800, 500);
        SeeStar_Page_Sat_Met.setSize(800, 500);
        SeeStar_Page_Sat_StL.setSize(800, 500);
        SeeStar_Page_Sat_GPS.setSize(800, 500);
        
        
        // Centrer les fenêtres
        SeeStar_Page_Acceuil.setLocationRelativeTo(null);
        SeeStar_Page_Principal_BDD_Distante.setLocationRelativeTo(null);
        SeeStar_Page_Sat_Met.setLocationRelativeTo(null);
        SeeStar_Page_Sat_StL.setLocationRelativeTo(null);
        SeeStar_Page_Sat_GPS.setLocationRelativeTo(null);
        
        
        
        
        
        
        
        
        
        // Création des composants de la fenêtre d'acceuil
        JLabel Bienvenu = new JLabel("----- Bienvenu dans SeeStar -----", SwingConstants.CENTER);
        JLabel Pseudo_q = new JLabel("Quel est votre Pseudo ?", SwingConstants.CENTER);
        JTextField Pseudo_a = new JTextField();
        JButton Bonjour = new JButton("Bonjour");
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        JButton Entrer_ds_SeeStar_BDD_distant = new JButton("Utiliser une BDD Distante");

        // Organisation des composants de la fenêtre d'acceuil dans un layout
        SeeStar_Page_Acceuil.setLayout(new GridLayout(5, 1, 5, 5));
        							//(Lignes, Colonnes, espace_entre_lignes, espace_entre_colonnes)
        SeeStar_Page_Acceuil.add(Bienvenu);
        SeeStar_Page_Acceuil.add(Pseudo_q);
        SeeStar_Page_Acceuil.add(Pseudo_a);
        SeeStar_Page_Acceuil.add(Bonjour);
        SeeStar_Page_Acceuil.add(resultLabel);

        // Affichage de la fenêtre d'acceuil
        SeeStar_Page_Acceuil.setVisible(true);
        
        
     // Gestion de l'événement du bouton 1 de la fenêtre d'acceuil
        Bonjour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Pseudo_a.getText().trim();
                if (name.isEmpty()) {
                    resultLabel.setText("Veuillez entrer un Pseudo !");
                    resultLabel.setForeground(Color.RED);
                } else {
                  //On efface le contenu de la page précédente
                	SeeStar_Page_Acceuil.remove(Pseudo_q);
                    SeeStar_Page_Acceuil.remove(Pseudo_a);
                    SeeStar_Page_Acceuil.remove(Bonjour);
                    SeeStar_Page_Acceuil.remove(resultLabel);
                    SeeStar_Page_Acceuil.revalidate();
                    SeeStar_Page_Acceuil.repaint();
                    
                  //On remplit à nouveau
                    SeeStar_Page_Acceuil.add(new JLabel());
                    SeeStar_Page_Acceuil.add(resultLabel);
                    resultLabel.setText("Bonjour, " + name + " !");
                    resultLabel.setForeground(Color.BLUE);
                    SeeStar_Page_Acceuil.add(Bienvenu);
                    SeeStar_Page_Acceuil.add(Entrer_ds_SeeStar_BDD_distant);
                }
            }
        });
        
        
        
        
        
        
        
        
// Gestion de l'événement du bouton d'entrer dans une BDD distante de la fenêtre d'acceuil
        Entrer_ds_SeeStar_BDD_distant.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        	SeeStar_Page_Acceuil.setVisible(false);
        	SeeStar_Page_Principal_BDD_Distante.setVisible(true);
        
        
        
        	// Création des composants de la fenêtre d'acceuil de BDD distante
        	JLabel Choix_Type_Satellite = new JLabel("<html><div style='text-align: center;'>Choisissez le type "
        										   + "de satellite dont vous souhaitez obtenir des informations</div></html>",
        										   SwingConstants.CENTER);
        	JButton Sat_Météo = new JButton("Satellites météo");
        	JButton Sat_StarLink = new JButton("Satellites Starlink");
        	JButton Sat_GPS = new JButton("Satellites GPS");

        
        
        	// Organisation des composants de la fenêtre d'acceuil de BDD distante dans un layout
        	SeeStar_Page_Principal_BDD_Distante.setLayout(new GridLayout(2, 3, 10, 10));
        
        	//Ligne 1
        	JPanel top_Accuil_BDD_Distante = new JPanel(new GridLayout(1, 1));
        	top_Accuil_BDD_Distante.add(Choix_Type_Satellite);
        	//Ligne 2
        	JPanel bot_Accuil_BDD_Distante = new JPanel(new GridLayout(1, 3, 10, 0));
        	bot_Accuil_BDD_Distante.setBorder(new EmptyBorder(10, 10, 10, 10)); // espace au-dessus

        	bot_Accuil_BDD_Distante.add(Sat_Météo);
        	bot_Accuil_BDD_Distante.add(Sat_StarLink);
        	bot_Accuil_BDD_Distante.add(Sat_GPS);
    
        	//Rassemblement des lignes
        	SeeStar_Page_Principal_BDD_Distante.add(top_Accuil_BDD_Distante);
        	SeeStar_Page_Principal_BDD_Distante.add(bot_Accuil_BDD_Distante);

    

        
        
        
// Gestion de l'événement du bouton Météo de la fenêtre d'acceuil de BDD distante pour ouverture Zone Satellites météo
        	Sat_Météo.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		SeeStar_Page_Principal_BDD_Distante.removeAll();
        		SeeStar_Page_Principal_BDD_Distante.setVisible(false);
        		SeeStar_Page_Sat_Met.setVisible(true);

    
        
        
        
        		// Création des composants de la fenêtre d'acceuil
        		JLabel Pres_lst_sat_météo = new JLabel("<html><div style='text-align: center;'>Voici une liste d'éléments de la base sélectionné : météo</div></html>", SwingConstants.CENTER);
        		
        		// Sélection de l'URL selon le choix
        		String urlCible = "https://celestrak.org/NORAD/elements/weather.txt";
        		ArrayList<Satellite> liste = telecharger(urlCible);
        
        		// TABLEAU
        		String[] colonnes = {"Nom", "ID", "Inclinaison"};
        		DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        		JTable table_met = new JTable(model);

        		// Remplissage du tableau
        		for (Satellite sat : liste) {
        		    model.addRow(new Object[]{
        		        sat.getNom(),
        		        sat.getId(),
        		        sat.getInclinaison()
        		    });
        		}

        		// Scroll
        		JScrollPane scrollPane = new JScrollPane(table_met);
        		
        		// Style
        		table_met.setRowHeight(25);
        		table_met.setFont(new Font("Arial",Font.PLAIN, 14));
        		table_met.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        		// Centrer Nom + ID + Inclinaison
        		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        		center.setHorizontalAlignment(JLabel.CENTER);
       
        		table_met.getColumnModel().getColumn(0).setCellRenderer(center);
        		table_met.getColumnModel().getColumn(1).setCellRenderer(center);
        		table_met.getColumnModel().getColumn(2).setCellRenderer(center);
        		
        		// Tri auto des lignes en cliquant dessus
        		table_met.setAutoCreateRowSorter(true);

        
        
        		// Organisation des composants de la fenêtre d'acceuil dans un layout
        		SeeStar_Page_Sat_Met.setLayout(new GridLayout(2, 1, 10, 10));
     
        		//Ligne 1
        		JPanel top_SeeStar_Page_Sat_Met = new JPanel(new GridLayout(1, 1));
        		top_SeeStar_Page_Sat_Met.add(Pres_lst_sat_météo);

        		//Ligne 3
        		JPanel bot_SeeStar_Page_Sat_Met = new JPanel(new GridLayout(1, 1));
        		scrollPane.setBorder(BorderFactory.createCompoundBorder(
        			    BorderFactory.createEmptyBorder(5, 5, 5, 5),
        			    BorderFactory.createLineBorder(Color.LIGHT_GRAY)
        			));
        		bot_SeeStar_Page_Sat_Met.add(scrollPane, BorderLayout.CENTER);

        		//Rassemblement des lignes
        		SeeStar_Page_Sat_Met.add(top_SeeStar_Page_Sat_Met);
        		SeeStar_Page_Sat_Met.add(bot_SeeStar_Page_Sat_Met);

        		SeeStar_Page_Sat_Met.revalidate();
        		SeeStar_Page_Sat_Met.repaint();
        	}
        	});
//Fermeture Zone Satellites météo  
        
        
// Gestion de l'événement du bouton Météo de la fenêtre d'acceuil de BDD distante pour ouverture Zone Satellites StarLink
        	Sat_StarLink.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		SeeStar_Page_Principal_BDD_Distante.removeAll();
        		SeeStar_Page_Principal_BDD_Distante.setVisible(false);
        		SeeStar_Page_Sat_StL.setVisible(true);

    
        
        
        
        		// Création des composants de la fenêtre d'acceuil
        		JLabel Pres_lst_sat_StarLink = new JLabel("<html><div style='text-align: center;'>Voici une liste d'éléments de la base sélectionné : StarLink</div></html>", SwingConstants.CENTER);
        		
        		// Sélection de l'URL selon le choix
        		String urlCible = "https://celestrak.org/NORAD/elements/starlink.txt";
        		ArrayList<Satellite> liste = telecharger(urlCible);
        
        		// TABLEAU
        		String[] colonnes = {"Nom", "ID", "Inclinaison"};
        		DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        		JTable table_StL = new JTable(model);

        		// Remplissage du tableau
        		for (Satellite sat : liste) {
        		    model.addRow(new Object[]{
        		        sat.getNom(),
        		        sat.getId(),
        		        sat.getInclinaison()
        		    });
        		}

        		// Scroll
        		JScrollPane scrollPane = new JScrollPane(table_StL);

        		// STYLE
        		table_StL.setRowHeight(25);
        		table_StL.setFont(new Font("Arial", Font.PLAIN, 14));
        		table_StL.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        		// Centrer Nom + ID + Inclinaison
        		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        		center.setHorizontalAlignment(JLabel.CENTER);

        		table_StL.getColumnModel().getColumn(0).setCellRenderer(center);
        		table_StL.getColumnModel().getColumn(1).setCellRenderer(center);
        		table_StL.getColumnModel().getColumn(2).setCellRenderer(center);
        		
        		// Tri auto des lignes en cliquant dessus
        		table_StL.setAutoCreateRowSorter(true);

        		
        
        		// Organisation des composants de la fenêtre d'acceuil dans un layout
        		SeeStar_Page_Sat_StL.setLayout(new GridLayout(2, 1, 10, 10));
     
        		//Ligne 1
        		JPanel top_SeeStar_Page_Sat_StL = new JPanel(new GridLayout(1, 1));
        		top_SeeStar_Page_Sat_StL.add(Pres_lst_sat_StarLink);
        		//Ligne 2
        		JPanel bot_SeeStar_Page_Sat_StL = new JPanel(new BorderLayout());
        		scrollPane.setBorder(BorderFactory.createCompoundBorder(
        			    BorderFactory.createEmptyBorder(5, 5, 5, 5),
        			    BorderFactory.createLineBorder(Color.LIGHT_GRAY)
        			));
        		bot_SeeStar_Page_Sat_StL.add(scrollPane, BorderLayout.CENTER);
        		//Rassemblement des lignes
        		SeeStar_Page_Sat_StL.add(top_SeeStar_Page_Sat_StL);
        		SeeStar_Page_Sat_StL.add(bot_SeeStar_Page_Sat_StL);

        
        	}
        	});
//Fermeture Zone Satellites StarLink
        	
        	
// Gestion de l'événement du bouton Météo de la fenêtre d'acceuil de BDD distante pour ouverture Zone Satellites GPS
        	Sat_GPS.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		SeeStar_Page_Principal_BDD_Distante.removeAll();
        		SeeStar_Page_Principal_BDD_Distante.setVisible(false);
        		SeeStar_Page_Sat_GPS.setVisible(true);

        		// Création des composants de la fenêtre d'acceuil
        		JLabel Pres_lst_sat_GPS = new JLabel("<html><div style='text-align: center;'>Voici une liste d'éléments de la base sélectionné : GPS</div></html>", SwingConstants.CENTER);
        		
        		// Sélection de l'URL selon le choix
        		String urlCible = "https://celestrak.org/NORAD/elements/gps-ops.txt";
        		ArrayList<Satellite> liste = telecharger(urlCible);

        		// TABLEAU
        		String[] colonnes = {"Nom", "ID", "Inclinaison"};
        		DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        		JTable table_GPS = new JTable(model);

        		// Remplissage du tableau
        		for (Satellite sat : liste) {
        		    model.addRow(new Object[]{
        		        sat.getNom(),
        		        sat.getId(),
        		        sat.getInclinaison()
        		    });
        		}

        		// Scroll
        		JScrollPane scrollPane = new JScrollPane(table_GPS);

        		// STYLE
        		table_GPS.setRowHeight(25);
        		table_GPS.setFont(new Font("Arial", Font.PLAIN, 14));
        		table_GPS.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        		// Centrer Nom + ID + Inclinaison
        		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        		center.setHorizontalAlignment(JLabel.CENTER);

        		table_GPS.getColumnModel().getColumn(0).setCellRenderer(center);
        		table_GPS.getColumnModel().getColumn(1).setCellRenderer(center);
        		table_GPS.getColumnModel().getColumn(2).setCellRenderer(center);
        		
        		// Tri auto des lignes en cliquant dessus
        		table_GPS.setAutoCreateRowSorter(true);
        
        
        		// Organisation des composants de la fenêtre d'acceuil dans un layout
        		SeeStar_Page_Sat_GPS.setLayout(new GridLayout(2, 1, 10, 10));
     
        		//Ligne 1
        		JPanel top_SeeStar_Page_Sat_GPS = new JPanel(new GridLayout(1, 1));
        		top_SeeStar_Page_Sat_GPS.add(Pres_lst_sat_GPS);
        		// Ligne 2
        		JPanel bot_SeeStar_Page_Sat_GPS = new JPanel(new BorderLayout());
        		scrollPane.setBorder(BorderFactory.createCompoundBorder(
        			    BorderFactory.createEmptyBorder(5, 5, 5, 5),
        			    BorderFactory.createLineBorder(Color.LIGHT_GRAY)
        			));
        		bot_SeeStar_Page_Sat_GPS.add(scrollPane, BorderLayout.CENTER);
        
        		//Rassemblement des lignes
        		SeeStar_Page_Sat_GPS.add(top_SeeStar_Page_Sat_GPS);
        		SeeStar_Page_Sat_GPS.add(bot_SeeStar_Page_Sat_GPS);

        		SeeStar_Page_Sat_GPS.revalidate();
        		SeeStar_Page_Sat_GPS.repaint();
        	}
        	});
//Fermeture Zone Satellites GPS        	
        	
        	        	}
        });
//Fermeture Zone BDD distante
    
    
    }
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<Satellite> telecharger(String adresseUrl) {
        ArrayList<Satellite> listeSat = new ArrayList<>();

        try {
            URL url = new URI(adresseUrl).toURL();
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNextLine()) {
                String ligne0 = sc.nextLine().trim();
                if (!sc.hasNextLine()) break;
                String ligne1 = sc.nextLine();
                if (!sc.hasNextLine()) break;
                String ligne2 = sc.nextLine();

                String id = ligne1.substring(2, 7).trim();
                String inclinaison = ligne2.substring(8, 16).trim();

                listeSat.add(new Satellite(ligne0, id, inclinaison));
            }

            sc.close();
        } catch (Exception e) {
        	listeSat.add(new Satellite("Erreur de chargement de la base", "Erreur de chargement de la base", "Erreur de chargement de la base"));
            e.printStackTrace();
        }

        return listeSat;
    }


}