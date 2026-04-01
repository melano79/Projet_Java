
public class Satellite {
	private String nom, id, inclinaison;
	public Satellite(String nom, String id, String inclinaison) {
        this.nom = nom;
        this.id = id;
        this.inclinaison = inclinaison;
    }
	public String toString() {
        return "Nom: " + nom + " | ID: " + id + " | Inclinaison: " + inclinaison + "°";
    }
	public String getNom() { return nom; }
}
