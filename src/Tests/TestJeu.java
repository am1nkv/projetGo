package Tests;

import Joueurs.Joueur;
import Plateau.Case;
import Plateau.Pion;
import Jeu.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static Jeu.Commande.boardsize;
import static Jeu.LogiqueJeu.estAligner;
import static Jeu.LogiqueJeu.recuperer;
import static Joueurs.Joueur.factoryJoueur;

public class TestJeu {
    @Test
    public void testInitialiser() {
        boardsize("5");
        Assertions.assertEquals(5, Commande.getP().getTaille());
        Jeu.lancer("black", "human", null);
        Jeu.lancer("white", "human", null);
        Assertions.assertEquals("human", Jeu.joueurActuel());
    }

    @Test
    public void testPlay() {
        boardsize("7");
        Commande.play("black", "D3");
        Assertions.assertEquals("X", Commande.getP().getCase(3, 4).toString());
        Commande.play("white", "F5");
        Assertions.assertEquals("O", Commande.getP().getCase(5, 2).toString());
        Commande.play("black", "D4");
        Commande.play("black", "D5");
        Commande.play("black", "D6");
        Assertions.assertFalse(estAligner(Pion.Couleur.X));
        Commande.play("black", "D7");
        Assertions.assertTrue(estAligner(Pion.Couleur.X));
    }


    @Test
    public void testClearBoard() {
        boardsize("5");
        Commande.play("black", "D3");
        Commande.play("white", "C5");
        Commande.clearboard();
        for (int i = 0; i < Commande.getP().getTaille(); i++) {
            for (int j = 0; j < Commande.getP().getTaille(); j++) {
                Assertions.assertTrue(Commande.getP().getCase(i, j).isEmpty());
            }
        }
    }

    @Test
    public void testRecuperer() {
        List<String> test = new ArrayList<>();
        test.add("white");
        test.add("D3");
        List<String> exemple = recuperer("white D3");
        Assertions.assertEquals(test, exemple);
    }


    @Test
    public void testHumanVsRandom() {
        Commande c = new Commande();
        boardsize("7");
        Jeu.lancer("black", "human", null);
        Jeu.lancer("white", "randomBot", null);
        c.play("black", "B2");
        Assertions.assertEquals(7, c.getP().getTaille());
        Case caseB2 = c.getP().getCase(1, 5);
        Assertions.assertFalse(caseB2.isEmpty(), "La case B2 doit être occupée.");
        Assertions.assertEquals(Pion.Couleur.X, caseB2.getPion().getCouleur(), "La case B2 doit contenir un pion noir.");
    }

    @Test
    public void testMiniMax() {
        boardsize("3");

        Joueur joueurBotMax = factoryJoueur("minimax", "white");
        Jeu.lancer("white", "minimax", "3");


        Commande.play("white", "B1");
        Commande.play("white", "B2");


        joueurBotMax.jouer();
        Assertions.assertEquals(Pion.Couleur.O, Commande.getP().getCase(1, 2).getPion().getCouleur());

    }


    @Test
    public void testMatchNul() {
        boardsize("3");


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String coord = (char) ('A' + i) + "" + (3 - j);
                String c = (i + j) % 2 == 0 ? "black" : "white";
                Commande.play(c, coord);
            }
        }
        Assertions.assertFalse(Commande.getP().aCaseVide());
        Assertions.assertFalse(LogiqueJeu.estAligner(Pion.Couleur.X));
        Assertions.assertFalse(LogiqueJeu.estAligner(Pion.Couleur.O));

    }

}