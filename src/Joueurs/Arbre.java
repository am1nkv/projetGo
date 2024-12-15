package Joueurs;

import Jeu.Case;
import Jeu.Pion;
import Jeu.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Arbre {
    private Plateau cp_plateau;
    private Pion.Couleur couleur;

    private List<Arbre> fils;

    public void setNvPion() {
        int x = 0 , y=0;
        Plateau a1 = cp_plateau;
        for (int i = 0; i < cp_plateau.getTaille(); i++) {
            for (int j = 0; j < cp_plateau.getTaille(); j++) {
                if (cp_plateau.getCase(i, j).isEmpty()) {
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        a1.getCase(x,y).setPion(new Pion(couleur));
    }



}
