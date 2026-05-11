import java.awt.Color;
import java.sql.*;

import javax.swing.JLabel;

public class Authentification {
		private String url = "jdbc:mysql://localhost:3306/sat_db"; //ouvrir XAMPP pour le fonctionnement de l'url
		private String user = "root";
		private String password = "";
		public Authentification() {}
		// Créer un compte
	    public boolean inscrire(String pseudo, String mdp, JLabel error) {
	    	String query = "INSERT INTO utilisateurs (pseudo, password) VALUES (?, ?)";
	        	try (Connection conn = DriverManager.getConnection(url, user, password);
	                    PreparedStatement pstmt = conn.prepareStatement(query)) {
	                   
	                   pstmt.setString(1, pseudo);
	                   pstmt.setString(2, mdp);
	                   pstmt.executeUpdate();
	                   
	                   return true;
	               } catch (SQLException e) {
	            	   System.out.println("Erreur SQL : " + e.getMessage());
	                   error.setText("Erreur SQL : " + e.getMessage());
	                   error.setForeground(Color.RED);
	                   return false;
	               }
	    }
	 // Vérifier la connexion
	    public boolean connecter(String pseudo, String mdp,JLabel error ) {
	    	String query = "SELECT * FROM utilisateurs WHERE pseudo = ? AND password = ?";

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             PreparedStatement pstmt = conn.prepareStatement(query)) {
	            
	            pstmt.setString(1, pseudo);
	            pstmt.setString(2, mdp);
	            ResultSet rs = pstmt.executeQuery();
	            if(rs.next()) {
	            	return true;
	            }else {
	            	error.setText("Users not found or wrong password ");
	            	error.setForeground(Color.RED);
	            	return false;
	            }
	        } catch (SQLException e) {
                error.setText("Erreur SQL : " + e.getMessage());
                error.setForeground(Color.RED);
	            return false;
	        }
	    }
}
