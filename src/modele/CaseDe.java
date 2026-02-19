package modele;

public class CaseDe extends CaseSpeciale {

    public CaseDe(int numero) {
        super(numero);
    }
    
    @Override
    public void appliquerEffet(Pirate pirate, De de) {
    	de.lancer();
    	if (de.getValeur() <= 3) {
    		pirate.perdreCoeur();
    	} else {
    		pirate.gagnerCoeur();
    	}
	}
}
