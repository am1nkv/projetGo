
import java.util.ArrayList;
import java.util.List;

public class Plateau {
    List<List<Case>> plateau;

    public Plateau(int size) {
        plateau = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            plateau.add(new ArrayList<>());
        }
    }

}
