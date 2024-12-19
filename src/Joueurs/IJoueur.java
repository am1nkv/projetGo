package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;

public interface IJoueur {
    public void jouer();

    Pion.Couleur getCouleur();

    Pion.Couleur getCouleurInverse();
}
