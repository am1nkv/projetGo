import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cmd {
    private static Plateau p;

    private static String num;

    public static String getCptCmd() {
        return num;
    }

    public static void boardsize(String s) {
        String size = "";
        for (int i = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                size += Character.getNumericValue(s.charAt(i));
            }
        }
        int sz = Integer.parseInt(size);
        p = new Plateau(sz);
        System.out.println(reponse(true));
    }

    public static void setNum(String s) {
        try {
            // Essaie de convertir s en entier
            Integer.parseInt(s);
            num = s; // Si ça réussit, on l'assigne à num
        } catch (NumberFormatException e) {
            // Si ça échoue, on assigne une chaîne vide à num
            num = "";
        }
    }

    public static void clear_board() {
        p.clearPlateau();
        System.out.println(reponse(true));
    }
    public static void play(String couleur, String coord) {
        Pion.Couleur color;
        if (couleur.equalsIgnoreCase("black"))
            color = Pion.Couleur.X;
        else
            color = Pion.Couleur.O;

        String chiffres = coord.substring(1);
        int x = coord.charAt(0) - 'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);
        Case casee = p.getCase(x, y);
        if (!casee.isEmpty()) {
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        System.out.print(reponse(true));
        casee.setPion(new Pion(color));
    }


    public static void showboard(){
        System.out.println(reponse(true));
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
        return liste;
    }



    public Plateau getP(){
        return p;
    }

    public static void genmove(String couleur) {
        Random r = new Random();
        String coord;
        while (p.aCaseVide()) {
            coord = "";
            int y = r.nextInt(p.getTaille()) + 1;
            int x = r.nextInt(p.getTaille());
            char lettre = (char) ('A' + x);

            coord += lettre + "" + y;

            Case casee = p.getCase(x, y);

            if (casee.isEmpty()) {
                play(couleur, coord);
                System.out.println( " " +coord);
                return;
            }
        }
        System.out.println(reponse(false)+ "plateau rempli");
    }
    public static String reponse(boolean commande) {
//        if (num.equals(""))
//            return "";
        if (commande ) {
            return "=" + num;
        } else
            return "?" + num;
    }

}


