package Joueurs;

import Jeu.Pion;


public abstract class Joueur implements IJoueur {
    protected Pion.Couleur couleur;
    protected String type;

    public Joueur(String couleur, String type) {
        this.couleur = couleur.equalsIgnoreCase("black") ? Pion.Couleur.X : Pion.Couleur.O;
        this.type = type;
    }

    @Override
    public Pion.Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String getType() {
        return type;
    }

    protected String getCouleurNom() {
        return couleur == Pion.Couleur.X ? "black" : "white";
    }

    public Pion.Couleur getCouleurInverse() {

        return (couleur == Pion.Couleur.X) ? Pion.Couleur.O : Pion.Couleur.X;
    }
}



