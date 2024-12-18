package IHM;

import Jeu.Pion;
import Joueurs.IJoueur;
import Joueurs.JoueurBotNaif;
import Joueurs.JoueurHumain;
import Jeu.Plateau;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class Jeu {
    private static JoueurHumain jH;
    private static JoueurBotNaif jB;
    private static Pion.Couleur AuTourDe = X;
    private static Plateau p;
    private static int nb_alignemnts = 5;

    public static void lancer(String couleur , String typeHumain){
        if(typeHumain.equals("human")){
            jH = new JoueurHumain(couleur);

        }
        else if(typeHumain.equals("randomBot")){

                jB = new JoueurBotNaif(couleur);

        }

        creationPlateau("5");
    }

    public static void creationPlateau(String s) {
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
        System.out.println(reponse(true));
    }


    public static void partie(String coord){
        if(AuTourDe==jH.getC()){
            jH.jouerHumain(p , coord);
        }
        estGagnant(AuTourDe);
        AuTourDe=AuTourDe==O?X:O;
        System.out.println(p.toString());
    }

    public static void partieB(){
        if(AuTourDe==jB.getC()){
            jB.jouer(p);
        }
        else{
            System.out.println("a vous de jouer");
        }

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
