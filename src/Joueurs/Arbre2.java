package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;

public class Arbre2 {
    private static final int infinie = Integer.MAX_VALUE;
    int x;
    int y;
    int score;

    public Arbre2() {
        this.x = -1;
        this.y = -1;
        this.score = Integer.MIN_VALUE;
    }
    public Arbre2(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }


    public static Arbre2 minMax(Plateau p, int a, int b, IJoueur joueur, boolean j) {
        if (!p.aCaseVide() || p.aGagner(joueur.getCouleur()) || p.aGagner(joueur.getCouleurInverse())) {
            int score = note(p, joueur);
            return new Arbre2(-1, -1, score);
        }
        Arbre2 bestMove = new Arbre2();

        if (j) { //joueur principal
            bestMove.score = -infinie;

            forLoop:
            for (int xx = 0; xx < p.getTaille(); xx++) {
                for (int yy = 0; yy < p.getTaille(); yy++) {
                    if (p.getCase(xx, yy).isEmpty()) {
                        p.getCase(xx, yy).setPion(new Pion(joueur.getCouleur()));
                        Arbre2 move = minMax(p, a, b, joueur, false);
                        p.getCase(xx, yy).removePion();

                        move.x = xx;
                        move.y = yy;


                        if (move.score > bestMove.score) {
                            bestMove = move;
                        }
                        a = Math.max(a, bestMove.score);
                        if (b <= a) {
                            break forLoop;
                        }
                    }
                }
            }
        } else { //adversaire
            bestMove.score = infinie;

            forLoop:
            for (int x = 0; x < p.getTaille(); x++) {
                for (int y = 0; y < p.getTaille(); y++) {
                    if (p.getCase(x, y).isEmpty()) {

                        p.getCase(x, y).setPion(new Pion(joueur.getCouleurInverse()));

                        Arbre2 move = minMax(p, a, b, joueur, true);

                        p.getCase(x, y).removePion();

                        move.x = x;
                        move.y = y;

                        if (move.score < bestMove.score) {
                            bestMove = move;
                        }


                        b = Math.min(b, bestMove.score);
                        if (b <= a) {
                            break forLoop;
                        }
                    }
                }
            }

        }
        return bestMove;
    }

    public static int note(Plateau p, IJoueur joueur) {
        if (p.aGagner(joueur.getCouleur()))
            return infinie;
        else if (p.aGagner(joueur.getCouleurInverse()))
            return -infinie;
        return 0; // Aucun gagne
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}