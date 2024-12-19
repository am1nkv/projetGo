package Appli;

import IHM.Cmd;
import IHM.IHMCommande;
import IHM.IHMPartie;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static IHM.Cmd.reponse;
import static IHM.Jeu.lancer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commande = scanner.nextLine().toLowerCase();
            List<String> l = Cmd.recuperer(commande);
            if(!l.isEmpty()){
                if(Objects.equals(l.get(0), "set_player")){
                    IHMPartie.partie(l);
                } else{
                    IHMCommande.protocole(l);
                }
            }
            System.out.println();

        }

    }
}