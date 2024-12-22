package Joueurs;

import Jeu.Pion;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurBotNaif {
    private static Pion.Couleur c;
    String type;

    public JoueurBotNaif(String c , String type) {
        this.c = c.equals("black") ? X : O;
        this.type = type;
    }


    public void jouer() {
        System.out.println(c);
        String s = c==X ? "black" : "white";
        genmove(s);
    }

    public static Pion.Couleur getCouleur() {
        return c;
    }


    public String getType(){
        return type;
    }
}