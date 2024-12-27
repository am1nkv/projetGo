package IHM;

import static IHM.Cmd.reponse;
import static IHM.Jeu.lancer;
import static IHM.Jeu.partie;

import java.util.List;

public class IHMCommande {
    public static void protocole(List<String> l ){

        switch (l.get(0)) {

            case "boardsize":
                /*System.out.println("je suis la");*/
                Cmd.boardsize(l.get(1));
                if(l.size() < 2)
                    System.out.println(reponse(false) + " board size outside engine's limit");

                break;
            case "play":
                if (l.size() > 2) {
                    Cmd.play(l.get(1), l.get(2).toUpperCase());
                } else {
                    System.out.println(reponse(false) + " invalid vertex, illegal move");
                }

                break;
            case "clear_board":
                Cmd.clearboard();
                break;
            case "showboard":
                Cmd.showboard();
                break;
            case "genmove":
                if(l.size() > 1){
                    Cmd.genmove(l.get(1));
                }
                else {
                    System.out.println(reponse(false) + " illegal move");
                }
                break;
            case "quit":
                Cmd.quit();
                break;
            default:
                System.out.println("Commande inconnue !");
                break;
        }
    }
}
