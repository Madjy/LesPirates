package modele;

public class De {
    private static final int NB_FACES = 6;
    private int valeur;

    public De() {
        this.valeur = 1;
    }

    public void lancer() {
        this.valeur = (int)(Math.random() * NB_FACES) + 1;
    }

    public int getValeur() {
        return valeur;
    }
}