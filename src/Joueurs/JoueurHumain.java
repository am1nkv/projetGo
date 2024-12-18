package Joueurs;

import Jeu.Case;
import Jeu.Pion;
import Jeu.Plateau;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.O;
import static Jeu.Pion.Couleur.X;

public class JoueurHumain implements IJoueur {
    private static Pion.Couleur c;

    public JoueurHumain( String c ) {

        this.c = c=="black" ? X : O;
    }

    public Pion.Couleur getC() {
        return c;
    }

    public void jouerHumain(Plateau p , String coord) {
        if(p==null){
            System.out.println(reponse(false) +" invalid vertex, illegal move");
            return;
        }


        String chiffres = coord.substring(1);
        int x = coord.charAt(0) - 'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);
        Case casee = p.getCase(x, y);

        if (!casee.isEmpty()) {
            System.out.print(reponse(false) + " invalid vertex, illegal move");
            return;
        }
        casee.setPion(new Pion(c));
        System.out.print(reponse(true));


        estGagnant( c);
    }

    @Override
    public void jouer(Plateau p) {
        genmove(String.valueOf(c));
    }
}
