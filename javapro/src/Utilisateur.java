
public class Utilisateur {
	private String Pseudo;
	private String password;
	public Utilisateur(String pseudo, String motDePasse) {
        this.Pseudo = pseudo;
        this.password = motDePasse;
	}
	// Getters pour la vérification
    public String getPseudo() { return Pseudo; }
    public String getMotDePasse() { return password; }
}
