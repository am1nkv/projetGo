package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurHumain extends Joueur {
    private static Pion.Couleur c;

    public JoueurHumain(String c) {
        super(c);
    }

    public Pion.Couleur getCouleur() {
        return c;
    }

    public void jouerHumain(Plateau p, String coord) {
        play(String.valueOf(c), coord);
    }

    public void jouer() {
        genmove(String.valueOf(c));
    }
}
