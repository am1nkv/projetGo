package Joueurs;

import static Jeu.Commande.*;

public class JoueurHumain extends Joueur {

    public JoueurHumain(String couleur, String type) {
        super(couleur, type);
    }

    @Override
    public void jouer(String coord) {
        play(getCouleurNom(), coord);
    }

    @Override
    public void jouer() {
        genmove(getCouleurNom());
    }
}
