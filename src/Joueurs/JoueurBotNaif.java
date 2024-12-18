package Joueurs;

import IHM.Cmd;
import Jeu.Case;
import Jeu.Pion;
import Jeu.Plateau;

import java.util.Objects;
import java.util.Random;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurBotNaif implements IJoueur {
    private static Pion.Couleur c;


    public JoueurBotNaif( String c) {
        this.c = c=="black" ? X : O;

    }

    public Pion.Couleur getC() {
        return c;
    }

    public void jouer(Plateau p) {
        genmove(String.valueOf(c));
    }

}
