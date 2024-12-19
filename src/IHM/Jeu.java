package IHM;

import Jeu.Pion;
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
        boardsize("5");
    }


    public static void partie(String coord){
        if(AuTourDe==jH.getCouleur()){
            jH.jouerHumain(p , coord);
        }
        AuTourDe=AuTourDe==O?X:O;
        System.out.println(p.toString());
        estGagnant(AuTourDe);
    }

    public static void partieB(){
        if(AuTourDe==jB.getCouleur()){
            jB.jouer();
            AuTourDe=AuTourDe==O?X:O;
            estGagnant(AuTourDe);
        }
        else{
            System.out.println("a vous de jouer");
        }

    }

    public static void partieG(){
        if(AuTourDe==jH.getCouleur()){
            jH.jouer();
        }
        AuTourDe=AuTourDe==O?X:O;
        System.out.println(p.toString());
        estGagnant(AuTourDe);
    }


    public static String joueurActuel(){
        if(AuTourDe == jH.getCouleur()){
            return "human";
        }
        return "randomBot";

    }

}
