package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;


public class Arbre2 {
/*
    private int infinie = Integer.MAX_VALUE;
    private int score = 0;
    private int xx;
    private int yy;

    public int minMax(Plateau p, int a, int b, IJoueur joueur, boolean j) {
        if (!p.aCaseVide()) {       //ou un joueur a gagner
            int score = note(p, joueur);
            return score;
        }
        int bestMove;

        if (j) { //joueur qu'on veut quil gagne
            score = -infinie;
            bestMove = score;
            for (int x = 0; x < p.getTaille(); x++) {
                for (int y = 0; y < p.getTaille(); y++) {
                    if (!p.getCase(x, y).isEmpty()) {
                        p.getCase(x, y).setPion(new Pion(joueur.getCouleur()));
                        int move = minMax(p, a, b, joueur, false);
                        p.getCase(x,y).removePion();
                        move.x = x;


                    }
                }


            }
        }
        return 0;
    }


    public int note(Plateau p, IJoueur joueur) {
        if (p.aGagner(joueur.getCouleur())) return infinie;
        else if (p.aGagner(joueur.getCouleurInverse())) return -infinie;

        return 0; //personne gagne
    }
*/

}