package modele;

public class Jeu {
	private Plateau plateau;
    private De de;
    private int tour; // 0 = Jack Le Borgne ; 1 = Bill Jambe De Bois
    
    public Jeu() {
    	this.plateau = new Plateau();
    	this.de = new De();
    	this.tour = 0;
    }
    
    public void jouerTour() {
        Pirate pirate = plateau.getPirates()[tour];
        
        de.lancer();
        int de1 = de.getValeur();
        
        de.lancer();
        int de2 = de.getValeur();
        
        pirate.deplacer(de1 + de2);
    }
}
