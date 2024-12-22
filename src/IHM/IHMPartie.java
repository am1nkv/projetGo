package IHM;

import java.util.List;

import static IHM.Cmd.showboard;

public class IHMPartie {

    public static void partie(List<String> l) {
        switch (l.get(0)) {
            case "play":
                Jeu.partie(l.get(1)); // La logique du bot est déjà incluse
                break;

            case "genmove":
                if (Jeu.joueurActuel().equals("human")) {
                    Jeu.partieG();
                }
                break;

            case "set_player":
                Jeu.lancer(l.get(1), l.get(2));
                System.out.println("C'est fait.");
                break;

            default:
                System.out.println("Commande inconnue.");
                break;
        }
    }

}
