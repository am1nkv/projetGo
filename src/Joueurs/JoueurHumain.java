package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurHumain  {
    private static Pion.Couleur c;
    String type;

    public JoueurHumain(String c , String type) {
        this.c = c.equals("black") ? X : O;
        this.type = type;
    }

    public Pion.Couleur getCouleur() {
        return c;
    }

    public void jouerHumain(String coord) {
        play(c == Pion.Couleur.X ? "black" : "white", coord);
    }

    public void jouer() {
        genmove(String.valueOf(c));
    }
    public String getType(){
        return type;
    }
}
