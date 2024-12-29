package Joueurs;

import static Jeu.Commande.*;


public class JoueurBotMax  extends Joueur {

    public JoueurBotMax(String couleur ,String type) {
        super(couleur, type);
    }

    @Override
    public void jouer() {
      minMax(getCouleurNom() , this);
    }
    @Override
    public void jouer(String coord) {
        throw new UnsupportedOperationException("Cette méthode n'est pas supportée pour ce type de joueur.");
    }
}
