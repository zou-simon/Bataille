
public class Carte {
	
	private String couleur;
	private int valeur;
	
	public Carte(String couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public int compare(Carte carte) {
		if (this.valeur < carte.valeur)
			return -1;
		else if (this.valeur > carte.valeur)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		if (this.valeur == 1)
			return "as de " + this.couleur;
		else if (this.valeur == 11)
			return "valet de " + this.couleur;
		else if (this.valeur == 12)
			return "dame de " + this.couleur;
		else if (this.valeur == 13)
			return "roi de " + this.couleur;
		else 
			return Integer.toString(this.valeur) + " de " + this.couleur;
	}

}
