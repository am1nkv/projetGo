package Joueurs;

import Jeu.Case;
import Jeu.Pion;
import Jeu.Plateau;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Arbre {
    private Plateau plateau;
    private Plateau cp_plateau;
    private Pion.Couleur  couleur;
    private List<Arbre> fils;

    public Arbre(Plateau cp_plateau, Pion.Couleur couleur) {
        fils = new ArrayList<>();
        this.plateau = cp_plateau;
        this.cp_plateau = cp_plateau;
        this.couleur = couleur;



    }

  /*  public void setNvPion(int x , int y) {
        Plateau a1 = cp_plateau;
        for (int i = 0; i < cp_plateau.getTaille(); i++) {
            for (int j = 0; j < cp_plateau.getTaille(); j++) {
                if (cp_plateau.getCase(i, j).isEmpty()) {

                }
            }
        }
        a1.getCase(x, y).setPion(new Pion(couleur));

    }*/
    public void AjtrNoead(Arbre root){

       for(int i = 0; i < plateau.getTaille(); i++){
           for(int j=0; j < plateau.getTaille(); j++){
               Plateau a1 = plateau;
               while(cp_plateau.aCaseVide() && a1.getCase(i, j).isEmpty()){
                   a1.getCase(i, j).setPion(new Pion(couleur));
                   cp_plateau.getCase(i, j).setPion(new Pion(couleur));
                   root.fils.add(new Arbre(a1, couleur));
                   a1.toSrtring();
               }
           }
       }
    }



}
