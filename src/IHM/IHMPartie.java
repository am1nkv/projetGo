package IHM;

import java.util.List;

import static IHM.Cmd.boardsize;
import static IHM.Cmd.showboard;
import static IHM.Jeu.partie;

public class IHMPartie {
    public static void partie(List<String> l , boolean debut) {

        if(debut){
            Jeu.partie(null , null );
            return;
        }
        switch (l.get(0)) {

            case "play":
                Jeu.partie( l.get(2) ,l.get(1) ); // La logique du bot est déjà incluse
                /*System.out.println("play fait");*/
                break;

            case "genmove":
                if (Jeu.joueurActuel().equals("human")) {
                    try{
                        Jeu.partie( null ,l.get(1));
                    }
                    catch(Exception e){
                        Jeu.partie(null , l.get(1));
                    }
                }
                break;

                case "showboard":
                    showboard();
                    break;

            default:
                System.out.println("Commande inconnue.");
                break;
        }
    }

}
