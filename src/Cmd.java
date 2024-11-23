public class Cmd {
    private static Plateau p;

    public static void boardersize(String s) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                size = Character.getNumericValue(s.charAt(i));
            }
        }
        p = new Plateau(size);
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

        int x = coord.charAt(0) -'A';
        int y = p.getTaille() - Character.getNumericValue(coord.charAt(1));

        Case casee= p.getCase(x,y);

        if (!casee.isEmpty())
            throw new IllegalStateException("illegal move");

        casee.setPion(new Pion(color));
    }

    public static void showbord(){
        p.toSrtring();
    }
}


