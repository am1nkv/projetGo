package IHM;

import java.util.List;

import static IHM.Cmd.showboard;

public class IHMPartie {

    public static void partie(List<String> l ) {
            switch (l.get(0)) {
                case "play":
                    if (Jeu.joueurActuel().equals("human")) {
                        IHM.Jeu.partie(l.get(1));
                        System.out.println("la humain ");
                    } else {
                        IHM.Jeu.partieB();
                        System.out.println("la robot");
                    }

                    break;

                case "genmove":
                    if (Jeu.joueurActuel().equals("human")) {
                        IHM.Jeu.partieG();
                    }
                    break;
                case "set_player":
                    Jeu.lancer(l.get(1), l.get(2));
                    System.out.println("c'est fait ");
                    break;
                default:
                    System.out.println("Commande inconnue");
                    break;
            }

    }
}
