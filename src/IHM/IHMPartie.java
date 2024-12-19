package IHM;

import java.util.List;

public class IHMPartie {

    public static void partie(List<String> l ){
        switch (l.get(0)){
            case "play":
                if(Jeu.joueurActuel().equals("human")){
                    IHM.Jeu.partie(l.get(1));
                }
                else{
                    IHM.Jeu.partieB();
                }
                break;

            case "genmove" :
                if(Jeu.joueurActuel().equals("human")){
                    IHM.Jeu.partieG();
                }
                break;
            case "set_player":
                Jeu.lancer(l.get(0), l.get(1));
                break;
            default:
                System.out.println("Commande inconnue");
                break;
        }
    }
}
