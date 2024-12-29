package IHM;

import Jeu.Jeu;
import java.util.List;

import static Jeu.Commande.quit;
import static Jeu.Commande.showboard;

public class IHMPartie {
    public static void partie(List<String> l , boolean debut) {

        if(debut){
            Jeu.partie(null );
            return;
        }
        switch (l.get(0)) {

            case "play":
                Jeu.partie( l.get(1) );

                break;

            case "genmove":
                if (Jeu.joueurActuel().equals("human")) {
                    Jeu.partie( null);

                }
                break;

            case "showboard":
                    showboard();
                    break;
            case "quit" :
                quit();
                break;
            default:
                System.out.println("illegal move ");
                break;
        }
    }

}
