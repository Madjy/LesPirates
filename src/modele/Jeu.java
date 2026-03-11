package modele;

public class Jeu {
    private Plateau plateau;
    private De de;
    private int tour;

    public Jeu() {
        this.plateau = new Plateau();
        this.de = new De();
        this.tour = 0;
    }

    public ResultatTour jouerTour() {
        Pirate pirate = plateau.getPirates()[this.tour];

        de.lancer();
        int de1 = de.getValeur();
        de.lancer();
        int de2 = de.getValeur();

        pirate.deplacer(de1 + de2);

        if (pirate.getPosition() >= plateau.getNbCases()) {
            pirate.setPosition(plateau.getNbCases());
        }

        ResultatTour resultat = ResultatTour.RIEN;
        CaseSpeciale caseSpeciale = plateau.getCaseSpeciale(pirate.getPosition());
        if (caseSpeciale != null) {
            int coeurAvant = pirate.getCoeurs();
            caseSpeciale.appliquerEffet(pirate, de);
            if (pirate.getPosition() == pirate.getPositionPrecedente()) {
                resultat = ResultatTour.CASE_RETOUR;
            } else if (pirate.getCoeurs() < coeurAvant) {
                resultat = ResultatTour.COEUR_PERDU;
            } else if (pirate.getCoeurs() > coeurAvant) {
                resultat = ResultatTour.COEUR_GAGNE;
            }
        }

        this.tour = (this.tour + 1) % 2;
        return resultat;
    }

    public boolean estTerminee() {
        return plateau.estTerminee();
    }

    public Pirate getVainqueur() {
        Pirate[] pirates = plateau.getPirates();
        if (pirates[0].getPosition() >= plateau.getNbCases()) {
        	return pirates[0];
        }
        if (pirates[1].getPosition() >= plateau.getNbCases()) {
        	return pirates[1];
        }
        if (!pirates[0].estVivant()) {
        	return pirates[1];
        }
        if (!pirates[1].estVivant()) {
        	return pirates[0];
        }
        return null;
    }

    public Plateau getPlateau() { return plateau; }
    public int getTour()        { return tour; }
    public De getDe()           { return de; }
}
