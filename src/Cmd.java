import java.util.ArrayList;
import java.util.List;
public class Cmd {
    private Plateau p;

    public void boardersize(String s) {
        int size=0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                size = Character.getNumericValue(s.charAt(i));
            }
        }
        p = new Plateau(size);
    }

    public void clear_board(){
        p.clearPlateau();
    }
}

