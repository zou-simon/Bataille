import java.util.ArrayList;

public class Bataille {
	
	final static String[] COULEURS = {"Coeur", "Carreau", "Trêfle", "Pique"};

	public static void main(String[] args) {
		// Créer deux joueurs
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		
		// Initialiser un paquet de cartes
		ArrayList<Carte> paquet = new ArrayList<>();
		for (int i = 1; i < 14; i++) {
			for (int y = 0; y < COULEURS.length; y++) {
				paquet.add(new Carte(COULEURS[y], i));
			}
		}
		
		// Distribuer les cartes aléatoirement
		while (!paquet.isEmpty()) {
			j1.ajoute(paquet.remove((int) Math.floor(Math.random() * paquet.size())));
			j2.ajoute(paquet.remove((int) Math.floor(Math.random() * paquet.size())));
		}
		
		// Effectuer une boucle de jeu
		Carte carteJ1, carteJ2;
		ArrayList<Carte> tapisJeu = new ArrayList<>();
		int tours = 1;
		while (!j1.getCartes().isEmpty() && !j2.getCartes().isEmpty()) {
			System.out.println("Tour n°" + tours++);
			// Chaque joueur pose une carte sur le tapis de jeu
			carteJ1 = j1.tire();
			tapisJeu.add(carteJ1);
			System.out.println("JOUEUR 1(" + j1.getPoints() + ") pose le " + carteJ1);
			carteJ2 = j2.tire();
			tapisJeu.add(carteJ2);
			System.out.println("JOUEUR 2(" + j2.getPoints() + ") pose le " + carteJ2);
			
			// LA BATAILLE (les cartes face cachée) !
			if (carteJ1.compare(carteJ2) == 0 && !j1.getCartes().isEmpty() && !j2.getCartes().isEmpty()) {
				tapisJeu.add(j1.tire());
				tapisJeu.add(j2.tire());
			}
			// JOUEUR 1 gagne le tour
			else if (carteJ1.compare(carteJ2) == 1) {
				while (!tapisJeu.isEmpty()) {
					j1.ajoute(tapisJeu.remove(0));
					j1.plusUnPoint();
				}
			}
			// JOUEUR 2 gagne le tour
			else if (carteJ1.compare(carteJ2) == -1) {
				while (!tapisJeu.isEmpty()) {
					j2.ajoute(tapisJeu.remove(0));
					j2.plusUnPoint();
				}
			}
		}
		
		// Afficher le vainqueur de la partie
		if (j1.getCartes().isEmpty()) {
			System.out.println("Le JOUEUR 2 est le vainqueur avec " + j2.getPoints() + " points contre " + j1.getPoints() + " !");
		}
		else if (j2.getCartes().isEmpty()) {
			System.out.println("Le JOUEUR 1 est le vainqueur avec " + j1.getPoints() + " points contre " + j2.getPoints() + " !");
		}

	}

}
