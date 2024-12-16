package Tests;

import IHM.Cmd;
import Jeu.Pion;
import Jeu.Plateau;
import Joueurs.Arbre;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestJeu {

    @Test
    public void testBoardSize() {
        Cmd c = new Cmd();
        c.boardsize("7");
        Assertions.assertEquals(7 , c.getP().getTaille());
    }

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
    }

    @Test
    public void testRecuperer() {
        List<String> test = List.of(new String[]{"white", "D3"});
        List<String> exemple = Cmd.recuperer("play white D3");
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
    @Test
    public void TestArbre(){
        Plateau p = new Plateau(7);
        Arbre arbre = new Arbre(p, Pion.Couleur.O);
        arbre.AjtrNoead(arbre);


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
