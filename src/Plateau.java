
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
                t.add(new Case(i, j));
            }
            plateau.add(t);
        }
    }

    public int getTaille (){
        return taille;
    }

    public void clearPlateau() {
        for (List<Case> c : plateau){
            for (Case cs : c){
                cs.removePion();
            }
        }
    }


}
