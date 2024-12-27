package IHM;

import Jeu.Case;
import Jeu.Pion;
import Jeu.Plateau;
import Joueurs.Arbre;
import Joueurs.IJoueur;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cmd {

    private static Plateau p;
    private static String num;
    private static boolean estPremierCoupDuJeu = true;
    private static int nb_alignemnts;


    public static List<String> recuperer(String s) {
        if (s.trim().isEmpty()) {      //Vérifie si la chaîne est vide ou null
            System.out.println(reponse(false));
            return new ArrayList<>();
        }

        String[] mots = s.split(" ");
        List<String> liste = new ArrayList<>();
        for (String mot : mots) {
            if (!mot.isEmpty()) {
                liste.add(mot);
            }
        }

        if (estNum(liste.get(0))) {
            num = liste.get(0);
            liste.remove(0);
        } else {
            num = "";
        }
        return liste;
    }

    public static void boardsize(String s) {
        int sz = 0;
        try {
            sz = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        if (sz < 3) {
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        p = new Plateau(sz);
        nb_alignemnts = (sz > 4) ? 5 : 3;

        estPremierCoupDuJeu = true;
        System.out.println(reponse(true));
    }

    ;

    public static void play(String couleur, String coord) {
        //System.out.println("Coordonnée reçue : " + coord); //Débogage

        if (coord.length() < 2 || !Character.isLetter(coord.charAt(0)) || !Character.isDigit(coord.charAt(1))) {
            System.out.println(reponse(false) + " invalid vertex, bad format");
            return;
        }

        Pion.Couleur color = Jeu.getCouleurC(couleur);
        String chiffres = coord.substring(1);
        int x = Character.toUpperCase(coord.charAt(0)) - 'A';
        int y = p.getTaille() - Integer.parseInt(chiffres);


        if (x < 0 || x >= p.getTaille() || y < 0 || y >= p.getTaille()) {
            System.out.println(reponse(false) + " invalid vertex, out of bounds");
            return;
        }

        Case casee = p.getCase(x, y);
        if (!casee.isEmpty()) {
            System.out.print(reponse(false) + " invalid vertex, illegal move");
            return;
        }

        casee.setPion(new Pion(color));
        System.out.println(reponse(true));

        estPremierCoupDuJeu = false;
        estGagnant(color);
        finJeu();
    }


    public static void clearboard() {
        if (p == null) {
            System.out.println(reponse(false));
            return;
        }
        p.clearPlateau();
        System.out.println(reponse(true));
    }

    public static void showboard() {
        if (p == null) {
            System.out.println(reponse(false));
            return;
        }
        System.out.println(reponse(true));
        p.toSrtring();
    }

    public static void genmove(String couleur) {
        if (p == null) {
            System.out.println(reponse(false) + " illegal move");
            return;
        }
        Random r = new Random();
        String coord;
        Pion.Couleur color = Jeu.getCouleurC(couleur);
        boolean coupValide = false;

        while (!coupValide) {
            if (!p.aCaseVide()) {
                System.out.println(reponse(false) + "plateau rempli");
                return;
            }

            coord = "";
            int y = r.nextInt(p.getTaille()) + 1; // Ajustement pour les indices 1-based
            int x = r.nextInt(p.getTaille());
            char lettre = (char) ('A' + x);
            coord += lettre + "" + y;

            if (x < p.getTaille() && y <= p.getTaille()) {
                Case casee = p.getCase(x, p.getTaille() - y);
                if (casee.isEmpty()) {
                    play(couleur, coord);
                    System.out.println(" " + coord);
                    coupValide = true;
                }
            }
        }
        estGagnant(color);
        finJeu();
    }


    public static void quit() {
        System.out.println(reponse(true));
        System.exit(0);
    }

    public Plateau getP() {
        return p;
    }

    public static String reponse(boolean commande) {
        if (commande) {
            return "=" + num;
        } else
            return "?" + num;
    }

    public static boolean estNum(String mot) {
        for (char c : mot.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean alignement(int debutX, int debutY, int dx, int dy, Pion.Couleur c) {
        int tmp = 0;
        for (int i = 0; i < nb_alignemnts; i++) {
            int x = debutX + i * dx;
            int y = debutY + i * dy;
            if (x < 0 || x >= p.getTaille() || y < 0 || y >= p.getTaille()) {
                return false;
            }

            if (p.getCase(x, y) == null || p.getCase(x, y).getPion() == null) {
                return false;
            }
            if (p.getCase(x, y).getPion().getCouleur() == c) {
                tmp++;
            }
        }
        return tmp == nb_alignemnts;
    }

    public static boolean estAligner(Pion.Couleur c) {
        for (int i = 0; i < p.getTaille(); i++) {
            for (int y = 0; y < p.getTaille(); y++) {
                if (alignement(i, y, 1, 0, c)) return true;
                if (alignement(i, y, 1, -1, c)) return true;
                if (alignement(i, y, 0, 1, c)) return true;
                if (alignement(i, y, -1, 0, c)) return true;
                if (alignement(i, y, -1, -1, c)) return true;
                if (alignement(i, y, 0, -1, c)) return true;
            }
        }
        return false;
    }

    public static void estGagnant(Pion.Couleur c) {
        if (estAligner(c)) {
            System.out.println(reponse(true) + " Le joueur " + c + " a gagné");
            /*showboard();*/
            /*System.exit(0);*/

        }
    }

    public static void minMax(String c , IJoueur j) {

        Arbre move = Arbre.minMax(p, Integer.MIN_VALUE, Integer.MAX_VALUE, j, true , Jeu.getProfondeur());
        if (move.getX() < 0 || move.getY() < 0 || move.getX() >= p.getTaille() || move.getY() >= p.getTaille()) {
            //System.out.println("Aucun coup valide trouvé dans minMax.");
            finJeu();
        }

        Pion.Couleur couleur = Jeu.getCouleurC(c);
        p.getCase(move.getX(), move.getY()).setPion(new Pion(couleur));
        p.toSrtring(); //
    }

    public static void finJeu() {
        if (!p.aCaseVide() && !estAligner(Pion.Couleur.X) && !estAligner(Pion.Couleur.O)) {
            System.out.println(reponse(true) + " Le jeu est terminé : match nul, le plateau est plein !");
            //showboard();
            //System.exit(0);
        }
    }

    public static String name(){
        return "NESRINE ALYA LEONA AMINA";
    }

   public static int protocol_version(){
        return 2;

   }
   public static int version(){
        return 1;
   }

   public static String list_commands(){
        return "boardsize \n" +
                "clear_board \n" +
                "genmove\n" +
                "name \n" +
                "play \n" +
                "protocol_version \n" +
                "quit \n" +
                "showboard\n" +
                "version";
   }
}