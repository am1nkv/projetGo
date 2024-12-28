package Joueurs;

import Jeu.Pion;
import Jeu.Plateau;

public class Arbre {
    private static final int infinie = Integer.MAX_VALUE;
    int x;
    int y;
    int score;
    int depth;

    public Arbre() {
        this.x = -1;
        this.y = -1;
        this.score = Integer.MIN_VALUE;
        this.depth = 0;
    }
    public Arbre(int x, int y, int score , int depth) {
        this.x = x;
        this.y = y;
        this.score = score;
        this.depth = depth;
    }


    public static Arbre minMax(Plateau p, int a, int b, IJoueur joueur, boolean j, int profondeurMax) {
        if (!p.aCaseVide() || p.aGagner(joueur.getCouleur()) || p.aGagner(joueur.getCouleurInverse()) || profondeurMax == 0) {
            int score = note(p, joueur);
            return new Arbre(-1, -1, score, 0); // Ajout du nombre de coups (0)
        }

        Arbre bestMove = new Arbre();

        if (j) { // Joueur principal
            bestMove.score = -infinie;
            bestMove.depth = Integer.MAX_VALUE; // Profondeur maximale pour minimiser

            for (int xx = 0; xx < p.getTaille(); xx++) {
                for (int yy = 0; yy < p.getTaille(); yy++) {
                    if (p.getCase(xx, yy).isEmpty()) {
                        p.getCase(xx, yy).setPion(new Pion(joueur.getCouleur()));
                        Arbre move = minMax(p, a, b, joueur, false, profondeurMax - 1);
                        p.getCase(xx, yy).removePion();

                        move.x = xx;
                        move.y = yy;
                        move.depth += 1; // Incrémenter le nombre de coups

                        if (move.score > bestMove.score || (move.score == bestMove.score && move.depth < bestMove.depth)) {
                            bestMove = move;
                        }

                        a = Math.max(a, bestMove.score);
                        // Pas de coupe Alpha-Beta pour tester toutes les possibilités
                    }
                }
            }
        } else { // Adversaire
            bestMove.score = infinie;
            bestMove.depth = Integer.MAX_VALUE; // Profondeur maximale pour minimiser

            for (int x = 0; x < p.getTaille(); x++) {
                for (int y = 0; y < p.getTaille(); y++) {
                    if (p.getCase(x, y).isEmpty()) {
                        p.getCase(x, y).setPion(new Pion(joueur.getCouleurInverse()));
                        Arbre move = minMax(p, a, b, joueur, true, profondeurMax - 1);
                        p.getCase(x, y).removePion();

                        move.x = x;
                        move.y = y;
                        move.depth += 1; // Incrémenter le nombre de coups

                        if (move.score < bestMove.score || (move.score == bestMove.score && move.depth < bestMove.depth)) {
                            bestMove = move;
                        }

                        b = Math.min(b, bestMove.score);
                        // Pas de coupe Alpha-Beta pour tester toutes les possibilités
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