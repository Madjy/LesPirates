package modele;

public abstract class CaseSpeciale extends Case {

    public CaseSpeciale(int numero) {
        super(numero);
    }

    public abstract void appliquerEffet(Pirate pirate, De de);
}