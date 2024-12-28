package Tests;

import IHM.Cmd;
import Jeu.Pion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import IHM.Jeu;
import Jeu.Case;

public class TestJeu {
    /*@Test
    public void testHumanVsRandom() {
        Cmd c = new Cmd();
        c.boardsize("7");
        Jeu.lancer("black", "human", null);
        Jeu.lancer("white", "randomBot", null);
        c.play("black", "B2");
        Assertions.assertEquals(7 , c.getP().getTaille());
        Case caseB2 = c.getP().getCase(1, 5);
        Assertions.assertFalse(caseB2.isEmpty(), "La case B2 doit être occupée.");
        Assertions.assertEquals(Pion.Couleur.X, caseB2.getPion().getCouleur(), "La case B2 doit contenir un pion noir.");
    }*/

    @Test
    public void testShowBoard() {
        Cmd c = new Cmd();
    }

    @Test
    public void testPlay() {
        Cmd c = new Cmd();
        c.boardsize("7");
        c.play("black" , "D3");
        Assertions.assertEquals("X" , c.getP().getCase(3 , 4).toString());
        c.play("white" , "F5");
        Assertions.assertEquals("O" , c.getP().getCase(5 , 2).toString());
        c.play("black","D4");
        c.play("black","D5");
        c.play("black","D6");
        Assertions.assertEquals(false,c.estAligner( Pion.Couleur.X));
        c.play("black" , "D7");
        Assertions.assertEquals(true,c.estAligner( Pion.Couleur.X));
    }

    @Test
    public void testRecuperer() {
        List<String> test = new ArrayList<>();
        test.add("white");
        test.add("D3");
        List<String> exemple = Cmd.recuperer("white D3");
        Assertions.assertEquals(test, exemple);
    }

    @Test
    public void testClearBoard() {
        Cmd c = new Cmd();
        c.boardsize("7");
        c.play("black" , "D3");
        Assertions.assertEquals("X" , c.getP().getCase(3 , 4).toString());
        c.play("white" , "F5");
        Assertions.assertEquals("O" , c.getP().getCase(5 , 2).toString());
        c.clearboard();
        Assertions.assertEquals("." , c.getP().getCase(3 , 4).toString());
        Assertions.assertEquals("." , c.getP().getCase(5 , 2).toString());
    }



    /*@Test
    public void testGenmoveRempli() {
        IHM.Cmd c = new IHM.Cmd();
        c.boardsize("boardersize 2");
        c.play("black" , "A1");
        System.out.println();
        c.play("black" , "A2");
        System.out.println();
        c.play("white" , "B1");
        System.out.println();
        c.play("white" , "B2");
        System.out.println();
        Assertions.assertEquals("?6 illegal move" , c.genmove("white"));
    }*/
}
