package bean;

public class Historique {
	
	private String joueur;
	private String partie;
	
	public String getJoueur() {
		return joueur;
	}
	public void setJoueur(String joueur) {
		this.joueur = joueur;
	}
	public String getPartie() {
		return partie;
	}
	public void setPartie(String partie) {
		this.partie = partie;
	}
	@Override
	public String toString() {
		return "Historique [joueur=" + joueur + ", partie=" + partie + "]";
	}

}
