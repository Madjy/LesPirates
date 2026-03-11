package vue;

import java.util.Scanner;
import modele.Jeu;
import modele.Pirate;
import modele.ResultatTour;

public class Affichage {

    private Scanner scanner;

    public Affichage() {
        this.scanner = new Scanner(System.in);
    }

    public void attendreTour(Pirate pirate) {
        System.out.println("##### Tour de " + pirate.getNom() + " #####");
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
            + " - Position : " + pirate.getPosition()
            + " - Coeurs : " + pirate.getCoeurs());
    }

    public void afficherVainqueur(Pirate pirate) {
        System.out.println("##### " + pirate.getNom() + " a gagne ! #####");
    }
    
    public void afficherResultatTour(Pirate pirate, ResultatTour resultat) {
        if (resultat == ResultatTour.CASE_RETOUR) {
            System.out.println("Case retour ! " + pirate.getNom() + " revient en case " + pirate.getPosition());
        } else if (resultat == ResultatTour.COEUR_PERDU) {
            System.out.println("Case malefique ! " + pirate.getNom() + " perd un coeur !");
        } else if (resultat == ResultatTour.COEUR_GAGNE) {
            System.out.println("Case benefique ! " + pirate.getNom() + " gagne un coeur !");
        }
    }
}