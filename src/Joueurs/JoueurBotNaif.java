package Joueurs;

import static IHM.Cmd.*;

public class JoueurBotNaif extends Joueur {

    public JoueurBotNaif(String couleur, String type) {
        super(couleur, type);
    }

    @Override
    public void jouer() {
        System.out.println(couleur);
        genmove(getCouleurNom());
    }
    public void jouer(String coord) {
        throw new UnsupportedOperationException("Cette méthode n'est pas supportée pour ce type de joueur.");
    }
}
