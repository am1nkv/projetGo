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

    public static void lancer(String couleur, String type) {
        if (type.equalsIgnoreCase("human")) {
            jH = new JoueurHumain(couleur, type);
        } else if (type.equalsIgnoreCase("randomBot")) {
            jB = new JoueurBotNaif(couleur, type);
        }

        if (couleur.equals("black")) {
            AuTourDe = Pion.Couleur.X;
        } else {
            AuTourDe = Pion.Couleur.O;
        }

        clearboard();
        boardsize("5");
    }



    public static void partie(String coord) {
        if (AuTourDe == jH.getCouleur()) {
                jH.jouerHumain(coord); // Le coup est valide
                AuTourDe = AuTourDe == O ? X : O;
                System.out.println("Humain a joué.");
                showboard();
                partieB(); // Laissez le bot jouer immédiatement après.

        }

        estGagnant(AuTourDe);
    }



    public static void partieB() {
        if (AuTourDe == jB.getCouleur()) {
            jB.jouer();
            AuTourDe = AuTourDe == O ? X : O;
            estGagnant(AuTourDe);
            System.out.println("Le bot a joué.");
        } else {
            System.out.println("C'est au joueur humain de jouer.");
        }
        showboard();
    }



    public static void partieG(){
        if(AuTourDe==jH.getCouleur()){
            jH.jouer();
            AuTourDe=AuTourDe==O?X:O;
            showboard();
            partieB(); // Laissez le bot jouer immédiatement après.
        }

        //System.out.println(p.toString());
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
