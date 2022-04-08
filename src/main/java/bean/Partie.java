package bean;

public class Partie {
	private String DateDebut;
	private String DateFin;
	private String mode;
	private String score;
	private String resultat;
	public String getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(String dateDebut) {
		DateDebut = dateDebut;
	}
	public String getDateFin() {
		return DateFin;
	}
	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "Partie [DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", mode=" + mode + "]";
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	

}
