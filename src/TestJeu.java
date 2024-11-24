
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestJeu {

    @Test
    public void testBoardSize() {
        Cmd c = new Cmd();
        c.boardsize("boardersize 7");
        Assertions.assertEquals(7 , c.getP().getTaille());
    }

    @Test
    public void testShowBoard() {
        Cmd c = new Cmd();
    }

    @Test
    public void testPlay() {
        Cmd c = new Cmd();
        c.boardsize("boardersize 7");
        c.play("black" , "D3");
        Assertions.assertEquals("X " , c.getP().getCase(3 , 4).toString());
        c.play("white" , "F5");
        Assertions.assertEquals("O " , c.getP().getCase(5 , 2).toString());
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
        c.boardsize("boardersize 7");
        c.play("black" , "D3");
        Assertions.assertEquals("X " , c.getP().getCase(3 , 4).toString());
        c.play("white" , "F5");
        Assertions.assertEquals("O " , c.getP().getCase(5 , 2).toString());
        c.clear_board();
        Assertions.assertEquals(". " , c.getP().getCase(3 , 4).toString());
        Assertions.assertEquals(". " , c.getP().getCase(5 , 2).toString());
    }

}
