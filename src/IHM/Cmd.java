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

    public static List<String> recuperer(String s) {
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
        int sz = 0 ;
        try {
            sz = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        if(sz < 5){
            System.out.println(reponse(false) + " board size outside engine's limits");
            return;
        }
        p = new Plateau(sz);
        estPremierCoupDuJeu = true;
        System.out.println(reponse(true));
    }

    public static void play(String couleur, String coord) {
        //Si le premier coup n'est pas le pion noir
        if (estPremierCoupDuJeu && !couleur.equals("black")) {
            System.out.println(reponse(false) + " premier coup doit etre noir");
            return;
        }
        Pion.Couleur color =
                couleur.equalsIgnoreCase("black") ? X : Pion.Couleur.O;

        String chiffres = coord.substring(1);
        int x = coord.charAt(0) - 'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);
        Case casee = p.getCase(x, y);

        if (!casee.isEmpty()) {
            System.out.print(reponse(false) + " illegal move");
            return;
        }
        casee.setPion(new Pion(color));
        System.out.print(reponse(true));

        estPremierCoupDuJeu = false;

        estGagnant(3 , color);
    }

    public static void clearboard() {
        p.clearPlateau();
        System.out.println(reponse(true));
    }

    public static void showboard() {
        System.out.println(reponse(true));
        p.toSrtring();
    }

    public static void genmove(String couleur) {
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
        estGagnant(3 , color );
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

    public static boolean alignement(int debutX, int debutY, int dx, int dy, Pion.Couleur c, int nb){
        int tmp = 0;
        for(int i = 0 ; i < nb; i++){
            int x = debutX + i * dx;
            int y = debutY + i * dy;
            if (x < 0 || x >= p.getTaille() || y < 0 || y >= p.getTaille()) {
                return false; // Invalid position, alignment broken
            }

            // Safely check for null cases and pion objects
            if (p.getCase(x, y) == null || p.getCase(x, y).getPion() == null) {
                return false; // No piece found, alignment broken
            }
            if(p.getCase(x,y).getPion().getCouleur() == c) {
                tmp++;
            }

        }

        if (tmp == nb) {
            return true;
        }
        return false;
    }
    public static boolean estAligner(int nb, Pion.Couleur c){
        for(int i=0 ; i < p.getTaille() ; i++){
            for(int y=0; y < p.getTaille() ; y++){
                if (alignement(i,y,1,0,c ,  nb)) {
                    return true;
                }
                if(alignement(i,y, 1 , 1, c, nb)) {
                    return true;
                }
                if (alignement(i,y, 0,1, c, nb)) {
                   return true;
                }
                if(alignement(i,y, -1 , 0 , c , nb )) {
                    return true;
                }
                if(alignement(i,y,-1,-1,c,nb )) {
                    return true;
                }
                if(alignement(i,y , 0, -1 , c , nb )){
                    return true;
                }
              
            }
        }
        return false;
    }

    public static void estGagnant(int nb , Pion.Couleur c){
        if(estAligner(nb , c)){
            System.out.println("Le joueur " + c + " a gagné");
            quit();
        }

    }

}