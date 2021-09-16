import java.util.ArrayList;

public class Joueur {
	
	private ArrayList<Carte> cartes;
	private int points;
	
	public Joueur() {
		this.cartes = new ArrayList<Carte>();
		this.points = 0;
	}

	public Carte tire() {
		if (this.cartes.isEmpty()) throw new Error("Pas de carte !");
		return this.cartes.remove(0);
	}
	
	public void ajoute(Carte carte) {
		this.cartes.add(carte);
	}

	public ArrayList<Carte> getCartes() {
		return this.cartes;
	}

	public int getPoints() {
		return this.points;
	}
	
	public void plusUnPoint() {
		this.points++;
	}
	
}
