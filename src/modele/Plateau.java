package modele;

public class Plateau {
    private static final int NB_CASES = 30;

    private Case[] cases;
    private Pirate[] pirates;

    public Plateau() {
        this.cases = new Case[NB_CASES];
        for (int i = 0; i < NB_CASES; i++) {
            this.cases[i] = new Case(i + 1);
        }
        this.pirates = new Pirate[2];
        this.pirates[0] = new Pirate("Jack Le Borgne", Couleur.ROUGE);
        this.pirates[1] = new Pirate("Bill Jambe De Bois", Couleur.BLEU);
    }

    public boolean estTerminee() {
        for (int i = 0; i < pirates.length; i++) {
            if (pirates[i].getPosition() >= NB_CASES || !pirates[i].estVivant()) {
                return true;
            }
        }
        return false;
    }

    public Case getCaseAt(int index)  { return cases[index]; }
    public Pirate[] getPirates()      { return pirates; }
    public int getNbCases()           { return NB_CASES; }
