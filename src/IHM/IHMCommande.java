package IHM;

import Jeu.Commande;
import static Jeu.LogiqueJeu.reponse;
import java.util.List;

public class IHMCommande {
    public static void protocole(List<String> l ){

        switch (l.get(0)) {
            case "boardsize":
                Commande.boardsize(l.get(1));
                if(l.size() < 2)
                    System.out.println(reponse(false) + " board size outside engine's limit");

                break;
            case "play":
                if (l.size() > 2) {
                    Commande.play(l.get(1), l.get(2).toUpperCase());
                } else {
                    System.out.println(reponse(false) + " invalid vertex, illegal move");
                }
                break;
            case "clear_board":
                Commande.clearboard();
                break;
            case "showboard":
                Commande.showboard();
                break;
            case "genmove":
                if(l.size() > 1){
                    Commande.genmove(l.get(1));
                }
                else {
                    System.out.println(reponse(false) + " illegal move");
                }
                break;
            case "quit":
                Commande.quit();
                break;
            default:
                System.out.println("illegal move");
                break;
        }
    }
}
