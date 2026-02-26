package modele;

public class Pirate {
    private static final int NB_COEURS = 5;

    private String nom;
    private Couleur couleur;
    private int coeurs;
    private int position;
    private int positionPrecedente=0;

    public Pirate(String nom, Couleur couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.coeurs = NB_COEURS;
        this.position = 0;
    }

    public void deplacer(int nbCases) {
    	this.positionPrecedente = this.position;
        this.position += nbCases;
    }

    public void perdreCoeur() {
        if (this.coeurs > 0) {
            this.coeurs--;
        }
    }
    
    public void gagnerCoeur() {
    	if (this.coeurs < 6) {
    		this.coeurs++;
    	}
    }
    
    public int getPositionPrecedente() { return positionPrecedente; }

    public boolean estVivant() {
        return this.coeurs > 0;
    }

    public String getNom()      { return nom; }
    public Couleur getCouleur() { return couleur; }
    public int getCoeurs()      { return coeurs; }
    public int getPosition()    { return position; }
    public void setPosition(int position) { this.position = position; }
}