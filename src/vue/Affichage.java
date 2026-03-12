package vue;

import modele.Jeu;
import modele.Pirate;
import modele.ResultatTour;

public class Affichage implements IAffichage{

    public void afficherCasesRestantes(Pirate pirate, int nbCases) {
    	System.out.println(pirate.getNom() + " doit faire exactement " + (nbCases - pirate.getPosition()) + " pour gagner !");
    }

    public void attendreTour(Pirate pirate, int nbCases) {
        System.out.println("##### Tour de " + pirate.getNom() + " #####");
        afficherCasesRestantes(pirate, nbCases);
        System.out.println("Appuyez sur Entree pour lancer les dés");
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
    
    public void afficherLigne() {
    	System.out.println("------------------------------------------------------------------");
    }
    
    public void afficherDes(Jeu jeu) {
    	System.out.println("Resultat dés : " + (jeu.getDe1()+jeu.getDe2()));
    }
    
    public void afficherResultatTour(Pirate pirate, ResultatTour resultat) {
        if (resultat == ResultatTour.CASE_RETOUR) {
            System.out.println("|||||| Case retour ! |||||" + pirate.getNom() + " revient en case " + pirate.getPosition());
        } else if (resultat == ResultatTour.COEUR_PERDU) {
            System.out.println("|||||Case malefique ! |||||" + pirate.getNom() + " perd un coeur !");
        } else if (resultat == ResultatTour.COEUR_GAGNE) {
            System.out.println("|||||Case benefique ! ||||| " + pirate.getNom() + " gagne un coeur !");
        } else if (resultat == ResultatTour.RETOUR_ARRIERE) {
        	System.out.println(pirate.getNom() + " est parti trop loin ! Il revient en case " + pirate.getPosition() + " !");
        }
    }

	@Override
	public void afficherDes() {
		// TODO Auto-generated method stub
		
	}
}