package Joueurs;

import Jeu.Pion;

public class Joueur implements IJoueur {
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

    @Override
    public Pion.Couleur getCouleurInverse() {
        return (couleur == Pion.Couleur.X) ? Pion.Couleur.O : Pion.Couleur.X;
    }

    //Implémentation générique de la méthode 'jouer', mais spécifique à chaque type de joueur
    @Override
    public void jouer() {
        throw new UnsupportedOperationException("Cette méthode doit être implémentée dans les classes enfants.");
    }

    @Override
    public void jouer(String coord) {
        throw new UnsupportedOperationException("Cette méthode doit être implémentée dans les classes enfants.");
    }
}
