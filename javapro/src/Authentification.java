import java.sql.*;

public class Authentification {
		private String url = "jdbc:mysql://localhost:3306/sat_db"; //ouvrir XAMPP pour le fonctionnement de l'url
		private String user = "root";
		private String password = "";
		public Authentification() {}
		// Créer un compte
	    public void inscrire(String pseudo, String mdp) {
	    	String query = "INSERT INTO utilisateurs (pseudo, password) VALUES (?, ?)";
	        	try (Connection conn = DriverManager.getConnection(url, user, password);
	                    PreparedStatement pstmt = conn.prepareStatement(query)) {
	                   
	                   pstmt.setString(1, pseudo);
	                   pstmt.setString(2, mdp);
	                   pstmt.executeUpdate();
	                   
	                   System.out.println("Utilisateur enregistré sur le serveur SQL ");
	               } catch (SQLException e) {
	                   System.out.println("Erreur SQL : " + e.getMessage());
	               }
	    }
	 // Vérifier la connexion
	    public boolean connecter(String pseudo, String mdp) {
	    	String query = "SELECT * FROM utilisateurs WHERE pseudo = ? AND password = ?";

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             PreparedStatement pstmt = conn.prepareStatement(query)) {
	            
	            pstmt.setString(1, pseudo);
	            pstmt.setString(2, mdp);
	            ResultSet rs = pstmt.executeQuery();
	            if(rs.next()==false) {
	            	System.out.println("Users not found");
	            }
	            return rs.next(); // Renvoie true si un utilisateur correspond
	        } catch (SQLException e) {
	            System.out.println("Erreur de connexion : " + e.getMessage());
	            return false;
	        }
	    }
}
