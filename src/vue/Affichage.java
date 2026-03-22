package vue;

import java.util.Scanner;
import modele.ResultatTour;

public class Affichage implements IAffichage {

    private Scanner scanner;

    public Affichage() {
        this.scanner = new Scanner(System.in);
    }

    public void attendreTour(String nomPirate, int casesRestantes) {
        System.out.println("##### Tour de " + nomPirate + " #####");
        System.out.println(nomPirate + " doit faire exactement " + casesRestantes + " pour gagner !");
        System.out.println("Appuyez sur Entree pour lancer les des...");
        scanner.nextLine();
    }

    public void afficherPirate(String nomPirate, int position, int coeurs) {
        System.out.println(nomPirate + " - Position : " + position + " - Coeurs : " + coeurs);
    }

    public void afficherDes(int de1, int de2) {
        System.out.println("Resultat des : " + de1 + " + " + de2 + " = " + (de1 + de2));
    }

    public void afficherResultatTour(String nomPirate, int position, ResultatTour resultat) {
        if (resultat == ResultatTour.CASE_RETOUR) {
            System.out.println("|||||| Case retour ! |||||| " + nomPirate + " revient en case " + position);
        } else if (resultat == ResultatTour.COEUR_PERDU) {
            System.out.println("||||| Case malefique ! ||||| " + nomPirate + " perd un coeur !");
        } else if (resultat == ResultatTour.COEUR_GAGNE) {
            System.out.println("||||| Case benefique ! ||||| " + nomPirate + " gagne un coeur !");
        } else if (resultat == ResultatTour.RETOUR_ARRIERE) {
            System.out.println(nomPirate + " est parti trop loin ! Il revient en case " + position + " !");
        }
    }

    public void afficherVainqueur(String nomPirate) {
        System.out.println("##### " + nomPirate + " a gagne ! #####");
    }

    public void afficherLigne() {
        System.out.println("------------------------------------------------------------------");
    }
}