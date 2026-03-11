package application;

import modele.Jeu;
import vue.Affichage;
import modele.ResultatTour;
import modele.Pirate;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        Affichage affichage = new Affichage();

        while (!jeu.estTerminee()) {
            affichage.afficherEtat(jeu);
            Pirate joueurActuel = jeu.getPlateau().getPirates()[jeu.getTour()];
            affichage.attendreTour(joueurActuel);
            ResultatTour resultat = jeu.jouerTour();
            affichage.afficherResultatTour(joueurActuel, resultat);
        }

        affichage.afficherVainqueur(jeu.getVainqueur());
    }
}