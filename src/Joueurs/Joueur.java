package Joueurs;

import Plateau.Pion;
import Jeu.*;

public class Joueur implements IJoueur {
    protected Pion.Couleur couleur;
    protected String type;

    public Joueur(String couleur, String type) {
        this.couleur = Jeu.getCouleurC(couleur);
        this.type = type;
    }

    public static Joueur factoryJoueur(String type , String couleur) {
        switch (type) {
            case "human":
                return new JoueurHumain(couleur , type );
            case "randombot":
                return new JoueurBotNaif(couleur, type );
            case "minimax":
                return new JoueurBotMax(couleur, type );
            default:
                return null;
        }
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
