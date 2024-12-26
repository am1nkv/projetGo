package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;

public interface IJoueur {
    void jouer();

   void jouer(String coord) ;

    Pion.Couleur getCouleur();

    Pion.Couleur getCouleurInverse();

    String getType();
    String getCouleurNom() ;
}
