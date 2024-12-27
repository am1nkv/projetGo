package Joueurs;

import Jeu.Pion;


public abstract class Joueur implements IJoueur {
    protected Pion.Couleur couleur;
    protected String type;

    public Joueur(String couleur, String type) {
        this.couleur = IHM.Jeu.getCouleurC(couleur);
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
    @Override
    public String getCouleurNom() {

        return couleur == Pion.Couleur.X ? "black" : "white";
    }

    public Pion.Couleur getCouleurInverse() {

        return (couleur == Pion.Couleur.X) ? Pion.Couleur.O : Pion.Couleur.X;
    }
}



