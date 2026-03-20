package PackAClass;
import java.math.BigInteger;


public class Corps_Celeste {
	String nom;
	//int masse;
	String type;
	BigInteger circonference;
	
	
	
	
	
	
	public Corps_Celeste(String nom, String type, BigInteger circonference) {
		super();
		this.nom = nom;
		this.type = type;
		this.circonference = circonference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigInteger getCirconference() {
		return circonference;
	}
	public void setCirconference(BigInteger circonference) {
		this.circonference = circonference;
	}

	
}
