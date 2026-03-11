package vue;

import java.util.Scanner;
import modele.Jeu;
import modele.Pirate;

public class Affichage {

    private Scanner scanner;

    public Affichage() {
        this.scanner = new Scanner(System.in);
    }

    public void attendreTour(Pirate pirate) {
        System.out.println("=== Tour de " + pirate.getNom() + " ===");
        System.out.println("Appuyez sur Entree pour lancer les des...");
        scanner.nextLine();
    }

    public void afficherEtat(Jeu jeu) {
        Pirate[] pirates = jeu.getPlateau().getPirates();
        afficherPirate(pirates[0]);
        afficherPirate(pirates[1]);
    }

    public void afficherPirate(Pirate pirate) {
        System.out.println(pirate.getNom()
            + " | Position : " + pirate.getPosition()
            + " | Coeurs : " + pirate.getCoeurs());
    }

    public void afficherVainqueur(Pirate pirate) {
        System.out.println("=== " + pirate.getNom() + " a gagne ! ===");
    }
}