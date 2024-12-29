package Jeu;

import Plateau.Case;
import Plateau.Pion;
import Plateau.Plateau;

import java.util.Random;

import static Jeu.LogiqueJeu.*;

public class Commande {

    private static Plateau p;
    private static LogiqueJeu aide;

    public static void boardsize(String s) {
        int sz = 0;
        try {
            sz = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(reponse(false) + "illegal move");
            return;
        }
        if (sz < 3) {
            System.out.println(reponse(false) + "illegal move");
            return;
        }
        p = new Plateau(sz);
        int nb = (sz > 4) ? 5 : 3;
        aide = new LogiqueJeu(nb);
        aide.setEstPremierCoupDuJeu(true);
        System.out.println(reponse(true));
    }


    public static void play(String couleur, String coord) {

        if (coord.length() < 2 || !Character.isLetter(coord.charAt(0)) || !Character.isDigit(coord.charAt(1))) {
            System.out.println(reponse(false) + "invalid vertex, bad format");
            return;
        }

        Pion.Couleur color = Jeu.getCouleurC(couleur);
        String chiffres = coord.substring(1);
        int x = Character.toUpperCase(coord.charAt(0)) - 'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);


        if (x < 0 || x >= p.getTaille() || y < 0 || y >= p.getTaille()) {
            System.out.println(reponse(false) + "invalid vertex, out of bounds");
            return;
        }

        Case casee = p.getCase(x, y);
        if (!casee.isEmpty()) {
            System.out.print(reponse(false) + "invalid vertex, illegal move");
            return;
        }

        casee.setPion(new Pion(color));
        System.out.println(reponse(true));
        aide.setEstPremierCoupDuJeu(false);
        estGagnant(color);
        finJeu();
    }


    public static void clearboard() {
        if (p == null) {
            System.out.println(reponse(false));
            return;
        }
        p.clearPlateau();
        System.out.println(reponse(true));
    }

    public static void showboard() {
        if (p == null) {
            System.out.println(reponse(false));
            return;
        }
        System.out.println(reponse(true));
        p.toSrtring();
    }

    public static void genmove(String couleur) {
        if (p == null) {
            System.out.println(reponse(false) + "illegal move");
            return;
        }
        Random r = new Random();
        String coord;
        Pion.Couleur color = Jeu.getCouleurC(couleur);
        boolean coupValide = false;

        while (!coupValide) {
            if (!p.aCaseVide()) {
                System.out.println(reponse(false) + "plateau rempli");
                return;
            }

            coord = "";
            int y = r.nextInt(p.getTaille()) + 1; // Ajustement pour les indices 1-based
            int x = r.nextInt(p.getTaille());
            char lettre = (char) ('A' + x);
            coord += lettre + "" + y;

            if (x < p.getTaille() && y <= p.getTaille()) {
                Case casee = p.getCase(x, p.getTaille() - y);
                if (casee.isEmpty()) {
                    play(couleur, coord);
                    System.out.println(" " + coord);
                    coupValide = true;
                }
            }
        }
        estGagnant(color);
        finJeu();
    }

    public static void minMax(String c , IJoueur j) {

        Arbre move = Arbre.minMax(p, Integer.MIN_VALUE, Integer.MAX_VALUE, j, true , Jeu.getProfondeur());
        if (move.getX() < 0 || move.getY() < 0 || move.getX() >= p.getTaille() || move.getY() >= p.getTaille()) {
            finJeu();
        }

        Pion.Couleur couleur = Jeu.getCouleurC(c);
        p.getCase(move.getX(), move.getY()).setPion(new Pion(couleur));
        p.toSrtring();
    }



    public static void quit() {
        System.out.println(reponse(true));
        System.exit(0);
    }

    public static Plateau getP() {
        return p;
    }

    public static String name() {
        return "NESRINE ALYA LEONA AMINA";
    }

    public static int protocol_version() {
        return 2;

    }

    public static int version() {
        return 1;
    }

    public static String list_commands() {
        return "boardsize \n" +
                "clear_board \n" +
                "genmove\n" +
                "name \n" +
                "play \n" +
                "protocol_version \n" +
                "quit \n" +
                "showboard\n" +
                "version";
    }
}