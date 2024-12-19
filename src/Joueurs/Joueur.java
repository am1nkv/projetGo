package Joueurs;

import Jeu.Pion;

import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public abstract class Joueur {
    private static Pion.Couleur c;
    private static Pion pC;

    public Joueur(String c) {
        this.c = c.equals("black") ? X : O;


    }

    public Pion getPionCouleur() {
        return pC;
    }

    public Pion.Couleur getCouleur() {
        return c;
    }

    public Pion.Couleur getCouleurInverse() {

        return (c == Pion.Couleur.X) ? Pion.Couleur.O : Pion.Couleur.X;
    }


}