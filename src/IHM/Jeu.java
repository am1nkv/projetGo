package IHM;

import Jeu.Pion;
import Joueurs.JoueurBotNaif;
import Joueurs.JoueurHumain;
import Jeu.Plateau;

import java.util.Objects;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class Jeu {
    private static JoueurHumain jH;
    private static JoueurBotNaif jB;
    private static Pion.Couleur AuTourDe;
    private static Plateau p;
    private static int nb_alignemnts = 5;

    public static void lancer(String couleur, String type) {
        Pion.Couleur couleurEnum = couleur.equals("black") ? Pion.Couleur.X : Pion.Couleur.O;
        jH = new JoueurHumain(couleur, type);
        jB = new JoueurBotNaif(jH.getCouleur() == X ? "white" : "black" , "bot");
        AuTourDe = couleurEnum;
        clearboard();
        boardsize("5");
    }



    public static void partie(String coord){
        if(AuTourDe==jH.getCouleur()){
            jH.jouerHumain(coord);
            AuTourDe=AuTourDe==O?X:O;
            System.out.println("humain a jouer");
        }

        //System.out.println(p.toString());
        showboard();
        estGagnant(AuTourDe);
    }

    public static void partieB(){
        if(AuTourDe== jB.getCouleur()){
            jB.jouer();
            AuTourDe=AuTourDe==O?X:O;
            estGagnant(AuTourDe);
            System.out.println("le bot a joué");
        }
        else{
            System.out.println("a vous de jouer");
        }
        showboard();
    }

    public static void partieG(){
        if(AuTourDe==jH.getCouleur()){
            jH.jouer();
        }
        AuTourDe=AuTourDe==O?X:O;
        //System.out.println(p.toString());
        showboard();
        estGagnant(AuTourDe);
    }


    public static String joueurActuel() {
        if (jH == null || jB == null) {
            throw new IllegalStateException("Les joueurs n'ont pas été initialisés.");
        }
        String type = (AuTourDe == jH.getCouleur()) ? jH.getType() : jB.getType();
        System.out.println("Type du joueur actuel : " + type); // Debug
        return type;
    }



}
