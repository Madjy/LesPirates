package vue;

import modele.Jeu;
import modele.ResultatTour;
import modele.Pirate;

public interface IAffichage {

	    void afficherCasesRestantes(Pirate pirate, int nbCases);

	    void attendreTour(Pirate pirate, int nbCases);

	    void afficherEtat(Jeu jeu);

	    void afficherPirate(Pirate pirate);

	    void afficherVainqueur(Pirate pirate);
	    
	    void afficherLigne();
	    
	    void afficherDes();
	    
	    void afficherResultatTour(Pirate pirate, ResultatTour resultat);
	    }

