package modele;

public class Jeu {
    private Plateau plateau;
    private De de;
    private int tour;
    private int de1;
    private int de2;

    public Jeu() {
        this.plateau = new Plateau();
        this.de = new De();
        this.tour = 0;
        this.de1 = 0;
        this.de2  = 0;
    }

    public ResultatTour jouerTour() {
        Pirate pirate = plateau.getPirates()[this.tour];

        de.lancer();
        this.de1 = de.getValeur();
        de.lancer();
        this.de2 = de.getValeur();

        pirate.deplacer(this.de1 + this.de2);

        ResultatTour resultat = ResultatTour.RIEN;

        if (pirate.getPosition() > plateau.getNbCases()) {
            pirate.setPosition(plateau.getNbCases()-(pirate.getPosition()-plateau.getNbCases()));
            resultat = ResultatTour.RETOUR_ARRIERE;
        } else {
        	CaseSpeciale caseSpeciale = plateau.getCaseSpeciale(pirate.getPosition());
            if (caseSpeciale != null) {
                int coeurAvant = pirate.getCoeurs();
                int positionAvant = pirate.getPosition();
                caseSpeciale.appliquerEffet(pirate, de);
                if (pirate.getPosition() < positionAvant) {
                    resultat = ResultatTour.CASE_RETOUR;
                } else if (pirate.getCoeurs() < coeurAvant) {
                    resultat = ResultatTour.COEUR_PERDU;
                } else if (pirate.getCoeurs() > coeurAvant) {
                    resultat = ResultatTour.COEUR_GAGNE;
                }
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
        if (pirates[0].getPosition() == plateau.getNbCases()) {
        	return pirates[0];
        }
        if (pirates[1].getPosition() == plateau.getNbCases()) {
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
    public int getDe1()			{ return de1; }
    public int getDe2()			{ return de2; }
}
