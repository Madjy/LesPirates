package modele;

public class Plateau {
    private static final int NB_CASES = 30;

    private CaseSpeciale[] casesSpeciales;
    private Pirate[] pirates;

    public Plateau() {
        this.casesSpeciales = new CaseSpeciale[14];
        this.casesSpeciales[0] = new CaseRetour(2);
        this.casesSpeciales[1] = new CaseDe(5);
        this.casesSpeciales[2] = new CaseRetour(7);
        this.casesSpeciales[3] = new CaseDe(10);
        this.casesSpeciales[4] = new CaseRetour(12);
        this.casesSpeciales[5] = new CaseDe(14);
        this.casesSpeciales[6] = new CaseRetour(15);
        this.casesSpeciales[7] = new CaseDe(17);
        this.casesSpeciales[8] = new CaseRetour(20);
        this.casesSpeciales[9] = new CaseDe(21);
        this.casesSpeciales[10] = new CaseRetour(23);
        this.casesSpeciales[11] = new CaseDe(25);
        this.casesSpeciales[12] = new CaseRetour(27);
        this.casesSpeciales[13] = new CaseDe(29);

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

    public Pirate[] getPirates() { return pirates; }
    public int getNbCases()      { return NB_CASES; }
}