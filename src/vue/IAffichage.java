package vue;

import modele.ResultatTour;

public interface IAffichage {
    void attendreTour(String nomPirate, int casesRestantes);
    void afficherPirate(String nomPirate, int position, int coeurs);
    void afficherDes(int de1, int de2);
    void afficherResultatTour(String nomPirate, int position, ResultatTour resultat);
    void afficherVainqueur(String nomPirate);
    void afficherLigne();
}
