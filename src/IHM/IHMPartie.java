package IHM;

import java.util.List;

import static IHM.Cmd.boardsize;
import static IHM.Cmd.showboard;
import static IHM.Jeu.partie;

public class IHMPartie {
    public static void partie(List<String> l , boolean debut) {

        if(debut){
            Jeu.partie(null);
            return;
        }
        switch (l.get(0)) {

            case "play":
                Jeu.partie(l.get(1)); // La logique du bot est déjà incluse
                /*System.out.println("play fait");*/
                break;

            case "genmove":
                if (Jeu.joueurActuel().equals("human")) {
                    try{
                        Jeu.partie(l.get(1));
                    }
                    catch(Exception e){
                        Jeu.partie(null);
                    }
                }
                break;

            /*case "set_player":
                Jeu.lancer(l.get(1), l.get(2));
                System.out.println("C'est fait.");
                break;

             */
           /* case "minimax":
                Jeu.partie(l.get(1));
                break;*/
            default:
                System.out.println("Commande inconnue.");
                break;
        }
    }

}
