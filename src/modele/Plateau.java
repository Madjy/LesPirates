package modele;

public class Plateau {
    private static final int NB_CASES = 30;

    private CaseSpeciale[] casesSpeciales;
    private Pirate[] pirates;

    public Plateau() {
    	//Sert à créer et positionner les cases speciales
    	/*this.casesSpeciales = new CaseSpeciale[];
        this.casesSpeciales[0] = new CaseRetour();
        this.casesSpeciales[1] = new CaseDe();*/
        
        
        this.pirates = new Pirate[2];
        this.pirates[0] = new Pirate("Jack Le Borgne", Couleur.ROUGE);
        this.pirates[1] = new Pirate("Bill Jambe De Bois", Couleur.BLEU);
    }
    
    public CaseSpeciale getCaseSpeciale(int position) {
        for (int i = 0; i < casesSpeciales.length; i++) {
            if (casesSpeciales[i].getNumero() == position) {
                return casesSpeciales[i];
            }
        }
        return null;
    }

    public boolean estTerminee() {
        for (int i = 0; i < pirates.length; i++) {
            if (pirates[i].getPosition() >= NB_CASES || !pirates[i].estVivant()) {
                return true;
            }
        }
        return false;
    }

    public Pirate[] getPirates(){ 
    	return pirates; 
    	}
    public int getNbCases(){ 
    	return NB_CASES; 
    	}
}
