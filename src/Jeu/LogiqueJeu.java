package Jeu;

import Plateau.Pion;

import java.util.ArrayList;
import java.util.List;

import static Jeu.Commande.*;

public class LogiqueJeu {

    private static String num = " ";
    private static int nb_alignemnts;
    private static boolean estPremierCoupDuJeu;

    public LogiqueJeu(int nb){
        nb_alignemnts = nb;
        estPremierCoupDuJeu = true;
    }

    public void setEstPremierCoupDuJeu(boolean b) {
        estPremierCoupDuJeu = b;
    }
    public static List<String> recuperer(String s) {
        if (s.trim().isEmpty()) {      //Vérifie si la chaîne est vide ou null
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
        }
        return liste;
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

    public static boolean estAligner(Pion.Couleur c) {
        for (int i = 0; i < getP().getTaille(); i++) {
            for (int y = 0; y < getP().getTaille(); y++) {
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
            showboard();
            System.out.println(reponse(true) + " Le joueur " + c + " a gagner ! ");
           quit();

        }
    }

    public static void finJeu() {
        if (!getP().aCaseVide() && !estAligner(Pion.Couleur.X) && !estAligner(Pion.Couleur.O)) {
            showboard();
            System.out.println(reponse(true) + " Le jeu est terminé : match nul, le plateau est plein !");
            quit();
        }
    }

    public static boolean alignement(int debutX, int debutY, int dx, int dy, Pion.Couleur c) {
        int tmp = 0;
        for (int i = 0; i < nb_alignemnts; i++) {
            int x = debutX + i * dx;
            int y = debutY + i * dy;
            if (x < 0 || x >= getP().getTaille() || y < 0 || y >= getP().getTaille()) {
                return false;
            }

            if (getP().getCase(x, y) == null || getP().getCase(x, y).getPion() == null) {
                return false;
            }
            if (getP().getCase(x, y).getPion().getCouleur() == c) {
                tmp++;
            }
        }
        return tmp == nb_alignemnts;
    }
}
