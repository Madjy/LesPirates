package application;

import modele.Jeu;
import vue.Affichage;
import modele.ResultatTour;
import modele.Pirate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        Affichage affichage = new Affichage();
        Scanner scanner = new Scanner(System.in);

        while (!jeu.estTerminee()) {
            affichage.afficherEtat(jeu);
            Pirate joueurActuel = jeu.getPlateau().getPirates()[jeu.getTour()];
            affichage.afficherLigne();
            affichage.attendreTour(joueurActuel, jeu.getPlateau().getNbCases());
            scanner.nextLine();
            ResultatTour resultat = jeu.jouerTour();
            affichage.afficherDes(jeu);
            affichage.afficherResultatTour(joueurActuel, resultat);
        }

        affichage.afficherVainqueur(jeu.getVainqueur());
        scanner.close();
    }
}