package IHM;

import Jeu.Case;
import Jeu.Pion;
import Jeu.Plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Jeu.Pion.Couleur.X;

public class Cmd {

    private static Plateau p;
    private static String num;
    private static boolean estPremierCoupDuJeu = true;
    private static int nb_alignemnts;


    public static List<String> recuperer(String s) {
        if (s.trim().isEmpty()) { // Vérifie si la chaîne est vide ou null
           System.out.println(reponse(false));
           return new ArrayList<>();
        }

        String[] mots = s.split(" ");
        List<String> liste = new ArrayList<>();
        for (String mot : mots) {
            if (!mot.isEmpty()) {
                liste.add(mot);
            }
        }

        if (estNum(liste.get(0))) {
            num = liste.get(0);
            liste.remove(0);
        } else {
            num = "";
        }
        return liste;
    }

    public static void boardsize(String s) {
        int sz = 0;
        try {
            sz = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        if(sz < 3){
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        p = new Plateau(sz);
        nb_alignemnts = (sz > 4) ? 5 : 3;

        estPremierCoupDuJeu = true;
        System.out.println(reponse(true));
    }

    ;

    public static void play(String couleur, String coord) {
        //Si le premier coup n'est pas le pion noir
        if (estPremierCoupDuJeu && !couleur.equals("black") && !couleur.equals("white")) {
            System.out.println(reponse(false) + " invalid vertex, illegal move");
            return;
        }

        if(p==null){
            System.out.println(reponse(false) +" invalid vertex, illegal move");
            return;
        }
        Pion.Couleur color =
                couleur.equalsIgnoreCase("black") ? X : Pion.Couleur.O;

        String chiffres = coord.substring(1);
        int x = coord.charAt(0) - 'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);
        Case casee = p.getCase(x, y);

        if (!casee.isEmpty()) {
            System.out.print(reponse(false) + " invalid vertex, illegal move");
            return;
        }
        casee.setPion(new Pion(color));
        System.out.print(reponse(true));

        estPremierCoupDuJeu = false;

        estGagnant( color);
    }

    public static void clearboard() {
        if(p==null){
            System.out.println(reponse(false));
            return;
        }
        p.clearPlateau();
        System.out.println(reponse(true));
    }

    public static void showboard() {
        if(p == null){
            System.out.println(reponse(false));
            return;
        }
        System.out.println(reponse(true));
        p.toSrtring();
    }

    public static void genmove(String couleur) {
        if(p==null){
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        Random r = new Random();
        String coord;
        Pion.Couleur color =
                couleur.equalsIgnoreCase("black") ? X : Pion.Couleur.O;
        while (p.aCaseVide()) {
            coord = "";
            int y = r.nextInt(p.getTaille()) + 1;
            int x = r.nextInt(p.getTaille());
            char lettre = (char) ('A' + x);

            coord += lettre + "" + y;

            Case casee = p.getCase(x, y);

            if (casee.isEmpty()) {
                play(couleur, coord);
                System.out.println(" " + coord);
                return;
            }
        }
        estGagnant( color);
        System.out.println(reponse(false) + "plateau rempli");
    }

    public static void quit() {
        System.out.println(reponse(true));
        System.exit(0);
    }

    public Plateau getP() {
        return p;
    }

    public static String reponse(boolean commande) {
        if (commande) {
            return "=" + num;
        } else
            return "?" + num;
    }

    public static boolean estNum(String mot) {
        for (char c : mot.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean alignement(int debutX, int debutY, int dx, int dy, Pion.Couleur c) {
        int tmp = 0;
        for (int i = 0; i < nb_alignemnts; i++) {
            int x = debutX + i * dx;
            int y = debutY + i * dy;
            if (x < 0 || x >= p.getTaille() || y < 0 || y >= p.getTaille()) {
                return false;
            }

            if (p.getCase(x, y) == null || p.getCase(x, y).getPion() == null) {
                return false;
            }
            if (p.getCase(x, y).getPion().getCouleur() == c) {
                tmp++;
            }

        }

        return tmp == nb_alignemnts;
    }

    public static boolean estAligner(Pion.Couleur c) {
        for (int i = 0; i < p.getTaille(); i++) {
            for (int y = 0; y < p.getTaille(); y++) {
                if (alignement(i, y, 1, 0, c)) return true;
                if (alignement(i, y, 1, -1, c)) return true;
                if (alignement(i, y, 0, 1, c)) return true;
                if (alignement(i, y, -1, 0, c)) return true;
                if (alignement(i, y, -1, -1, c)) return true;
                if (alignement(i, y, 0, -1, c)) return true;
            }
        }
        return false;
    }

    public static void estGagnant(Pion.Couleur c) {
        if (estAligner(c)) {
            System.out.println(" Le joueur " + c + " a gagné");
            System.exit(0);
        }
    }

}