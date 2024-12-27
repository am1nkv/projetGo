package Appli;

import IHM.Cmd;
import IHM.IHMCommande;
import IHM.IHMPartie;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import static IHM.Cmd.*;

public class Main {

    public static void main(String[] args) {
        //boolean debut= true;
        boolean partieBot = false;
        boolean auto = true;
        int nbJoueur = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commande = scanner.nextLine().toLowerCase();
            List<String> l = Cmd.recuperer(commande);
            if (!l.isEmpty()) {
                switch(l.get(0)){
                    case "set_player":
                        if((l.get(1).equals("black") || l.get(1).equals("b") || l.get(1).equals("B")) && l.get(2).equals("human")) {
                            auto = false;
                        }
                        try{
                            if(IHM.Jeu.lancer(l.get(1), l.get(2), l.get(3))){
                                nbJoueur++;
                            }
                        }
                        catch (Exception e){
                            if(IHM.Jeu.lancer(l.get(1), l.get(2) , String.valueOf(Integer.MAX_VALUE))) {
                                nbJoueur++;
                            }
                        }
                        if (!Objects.equals(l.get(2), "human")) {
                            partieBot = true;
                        }
                        if (nbJoueur == 2) {
                            //System.out.println(auto);
                            //System.out.println("tes la ou pas ma star ?");
                            if(auto)
                                IHMPartie.partie(l, true);
                        }
                        break;
                    case "boardsize":
                        boardsize(l.get(1));
                        break;
                    case "name":
                        System.out.println(reponse(true) + " " + name());
                        break;
                    case "protocol_version":
                        System.out.println(reponse(true) + " " + protocol_version());
                        break;
                    case "version":
                        System.out.println(reponse(true) + " " + version());
                        break;
                    case "list_commands":
                        System.out.println(reponse(true) + " " + list_commands());
                        break;
                    default:
                        if (partieBot) {
                            IHMPartie.partie(l, false);
                        }
                        else {
                            IHMCommande.protocole(l);
                        }
                }
            }
            System.out.println();
        }
    }
}
