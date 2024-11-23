import java.util.ArrayList;
import java.util.List;

public class Cmd {
    private static Plateau p;

    public static void boardersize(String s) {
        String size = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                size += Character.getNumericValue(s.charAt(i));
            }
        }
        int sz = Integer.parseInt(size);
        p = new Plateau(sz);
    }

    public static void clear_bord() {
        p.clearPlateau();
    }

    public static void play(String couleur, String coord) {
        Pion.Couleur color;
        if (couleur.equalsIgnoreCase("black"))
            color = Pion.Couleur.X;
        else
            color = Pion.Couleur.O;

        String chiffres = coord.substring(1);
        int x = coord.charAt(0) -'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);

        Case casee = p.getCase(x,y);

        if (!casee.isEmpty()) {
            System.out.println("Case occupée, réessayez !");
            return;
        }

        casee.setPion(new Pion(color));
    }

    public static void showbord(){
        p.toSrtring();
    }

    public static List<String> recuperer(String s){
        String mot = "";
        List<String> liste = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i)  != ' '){
                mot += s.charAt(i);
            }
            else {
                liste.add(mot);
                mot = "";
            }
        }
        liste.add(mot);
        liste.remove(0);
        return liste;
    }
}


