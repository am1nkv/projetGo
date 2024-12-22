package Jeu;

import IHM.Cmd;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<List<Case>> plateau;
    private int taille;


    public Plateau(int size) {
        this.taille = size;

        plateau = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Case> t = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                t.add(new Case(j, i));
            }
            plateau.add(t);
        }
    }

    public void clearPlateau() {
        for (List<Case> c : plateau) {
            for (Case cs : c) {
                cs.removePion();
            }
        }
    }

    public void toSrtring() {
        int ln = plateau.size();
        int cl = plateau.get(0).size();
        System.out.print("  ");
        for (int i = 0; i < cl; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < ln; i++) {
            System.out.print((ln - i) + " ");
            for (Case cs : plateau.get(i)) {
                System.out.print(cs.toString() + " ");
            }
            System.out.print((ln - i));


            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < cl; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

    }

    public Case getCase(int x, int y) {
        if (x < 0 || x >= taille || y < 0 || y >= taille) {
            throw new IndexOutOfBoundsException("Coordonnées hors limites : x = " + x + ", y = " + y + ", taille = " + taille);
        }
        return plateau.get(y).get(x);
    }

    public int getTaille() {
        return plateau.size();
    }

    public boolean aCaseVide() {
        for (List<Case> row : plateau) {
            for (Case c : row) {
                if (c.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean aGagner(Pion.Couleur c) {
        return Cmd.estAligner(c);
    }

}
