package modele;

public class Plateau {
    private static final int NB_CASES = 30;

    private CaseSpeciale[] casesSpeciales;
    private Pirate[] pirates;

    public Plateau() {
    	//Sert à créer et positionner les cases speciales
        this.casesSpeciales[0] = new CaseRetour(4);
        this.casesSpeciales[1] = new CaseDe(7);
        this.casesSpeciales[2] = new CaseRetour(8);
        this.casesSpeciales[3] = new CaseDe(12);
        this.casesSpeciales[4] = new CaseRetour(16);
        this.casesSpeciales[5] = new CaseDe(20);
        this.casesSpeciales[6] = new CaseRetour(24);
        this.casesSpeciales[7] = new CaseDe(26);
        
        
       
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
