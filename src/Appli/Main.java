package Appli;


import IHM.IHMCommande;
import IHM.IHMPartie;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static Jeu.LogiqueJeu.recuperer;
import static Jeu.LogiqueJeu.reponse;
import static Jeu.Commande.*;
import static Jeu.Jeu.lancer;


public class Main {

    public static void main(String[] args) {
        boolean boardsize = false;
        boolean partieBot = false;
        boolean auto = true;
        int nbJoueur = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commande = scanner.nextLine().toLowerCase();
            List<String> l = recuperer(commande);
            if (!l.isEmpty()) {
                switch (l.get(0)) {
                    case "set_player" -> {
                        if (!boardsize) {
                            System.out.println(reponse(false) + " initialise le plateau d'abord !");
                            return;
                        }
                        if (l.get(1).equals("black") && l.get(2).equals("human")) {
                            auto = false;
                        }

                        if (l.size() > 3) {
                            if (Objects.equals(l.get(2), "minimax")) {
                                if (lancer(l.get(1), l.get(2), l.get(3))) {
                                    nbJoueur++;

                                }
                            }


                        } else if (Objects.equals(l.get(2), "minimax")) {
                            if (lancer(l.get(1), l.get(2), String.valueOf(Integer.MAX_VALUE))) {
                                nbJoueur++;

                            }
                        } else {
                            if (lancer(l.get(1), l.get(2), null)) {
                                nbJoueur++;

                            } else {
                                System.out.println(reponse(false) + " set_player n'a pas marché ! ");
                            }

                        }
                        if (!Objects.equals(l.get(2), "human")) {
                            partieBot = true;
                        }
                        if (nbJoueur == 2) {
                            if (auto)
                                IHMPartie.partie(l, true);
                        }
                    }
                    case "boardsize" -> {
                        boardsize(l.get(1));
                        boardsize = true;
                    }
                    case "name" -> System.out.println(reponse(true) + name());
                    case "protocol_version" -> System.out.println(reponse(true) + protocol_version());
                    case "version" -> System.out.println(reponse(true) + version());
                    case "list_commands" -> System.out.println(reponse(true) + list_commands());
                    case null, default -> {
                        if (partieBot) {
                            IHMPartie.partie(l, false);
                        } else {
                            IHMCommande.protocole(l);
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}