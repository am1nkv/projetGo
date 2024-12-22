package Joueurs;

import Jeu.Case;
import Jeu.Pion;

import java.util.Random;

import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurBotMax  {
    Pion.Couleur c;
    public JoueurBotMax(String c) {

        this.c = c.equals("black") ? X : O;
    }


}
