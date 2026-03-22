package modele;

public class Plateau {
    private static final int NB_CASES = 30;

    private CaseSpeciale[] casesSpeciales;
    private Pirate[] pirates;

    public Plateau() {
        this.casesSpeciales = new CaseSpeciale[14];
        this.pirates = new Pirate[2];
        this.pirates[0] = new Pirate("Jack Le Borgne", Couleur.ROUGE);
        this.pirates[1] = new Pirate("Bill Jambe De Bois", Couleur.BLEU);

        int compteur = 0;
        int pos = 2;
        while (compteur < casesSpeciales.length) {
            pos += (int)(Math.random() * 2) + 1; // avance de 1 ou 2 cases
            if (pos < NB_CASES) {
                if (compteur % 2 == 0) {
                    casesSpeciales[compteur] = new CaseRetour(pos);
                } else {
                    casesSpeciales[compteur] = new CaseDe(pos);
                }
                compteur++;
            }
        }
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