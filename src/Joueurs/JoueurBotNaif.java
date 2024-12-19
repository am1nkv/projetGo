package Joueurs;

import Jeu.Pion;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurBotNaif extends Joueur {
    private static Pion.Couleur c;


    public JoueurBotNaif(String c) {
        super(c);
    }


    public void jouer() {
        genmove(String.valueOf(c));
    }

}