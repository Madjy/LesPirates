package application;

import modele.Jeu;
import vue.Affichage;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        Affichage affichage = new Affichage();

        while (!jeu.estTerminee()) {
            affichage.afficherEtat(jeu);
            affichage.attendreTour(jeu.getPlateau().getPirates()[jeu.getTour()]);
            jeu.jouerTour();
        }

        affichage.afficherVainqueur(jeu.getVainqueur());
    }
}