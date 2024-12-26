package Appli;

import IHM.Cmd;
import IHM.IHMCommande;
import IHM.IHMPartie;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static IHM.Cmd.boardsize;


public class Main {

    public static void main(String[] args) {
        /*boolean debut= true;*/
         boolean partieBot = false;
         boolean auto = true;
         int nbJoueur = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commande = scanner.nextLine().toLowerCase();
            List<String> l = Cmd.recuperer(commande);
            if (!l.isEmpty()) {

                if (Objects.equals(l.get(0), "set_player")) {
                        if(l.get(1).equals("black") && l.get(2).equals("human")) {
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
                            System.out.println(auto);
                            /*System.out.println("tes la ou pas ma star ?");*/
                            if(auto)
                                IHMPartie.partie(l, true);
                        }

                }
                else if(Objects.equals(l.get(0), "boardsize")){
                    boardsize(l.get(1));
                }
                else{
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
