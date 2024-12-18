package Appli;

import IHM.Cmd;

import java.util.List;
import java.util.Scanner;

import static IHM.Cmd.reponse;
import static IHM.Jeu.lancer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commande = scanner.nextLine().toLowerCase();
            List<String> l = Cmd.recuperer(commande);
            Boolean jeu = false;
            if(!l.isEmpty()){
                switch (l.get(0)) {
                    case "boardsize":
                        if (l.size() > 1) {
                            Cmd.boardsize(l.get(1));
                        } else {
                            System.out.println(reponse(false) + " board size outside engine's limit");
                        }
                        break;
                    case "play":
                        if(l.size() ==2){
                            IHM.Jeu.partie(l.get(1));
                        }
                        if (l.size() > 2) {
                            Cmd.play(l.get(1), l.get(2).toUpperCase());
                        } else {
                            System.out.println(reponse(false) + " invalid vertex, illegal move");
                        }

                        break;
                    case "clearboard":
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
                    case "set_player":
                        jeu = true;
                        lancer(l.get(1), l.get(2));
                        break;
                    default:
                        if(jeu){
                            IHM.Jeu.partieB();
                        }
                        System.out.println("Commande inconnue !");
                        break;
                }
            }


            System.out.println();

        }

    }
}