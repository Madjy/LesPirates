package application;

import modele.Jeu;
import modele.Pirate;
import modele.ResultatTour;
import vue.Affichage;
import vue.IAffichage;

public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        IAffichage affichage = new Affichage();

        while (!jeu.estTerminee()) {
            Pirate[] pirates = jeu.getPlateau().getPirates();
            affichage.afficherPirate(pirates[0].getNom(), pirates[0].getPosition(), pirates[0].getCoeurs());
            affichage.afficherPirate(pirates[1].getNom(), pirates[1].getPosition(), pirates[1].getCoeurs());
            affichage.afficherLigne();

            Pirate joueurActuel = pirates[jeu.getTour()];
            affichage.attendreTour(joueurActuel.getNom(), jeu.getPlateau().getNbCases() - joueurActuel.getPosition());

            ResultatTour resultat = jeu.jouerTour();
            affichage.afficherDes(jeu.getDe1(), jeu.getDe2());
            affichage.afficherResultatTour(joueurActuel.getNom(), joueurActuel.getPosition(), resultat);
            affichage.afficherLigne();
        }

        affichage.afficherVainqueur(jeu.getVainqueur().getNom());
    }
}