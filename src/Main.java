import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String commande = scanner.nextLine().toLowerCase();
            List<String> l= Cmd.recuperer(commande);
            Cmd.setNum(l.get(0));

            if (commande.contains("boardsize")) {
                Cmd.boardsize(commande);
            } else if (commande.contains("play")) {
                List<String> liste = Cmd.recuperer(commande);
                Cmd.play(liste.get(2), liste.get(3).toUpperCase());
                System.out.println();
            } else if (commande.contains("clear_board")) {
                Cmd.clear_board();
            } else if (commande.contains("showboard")) {
               Cmd.showboard();
            } else if (commande.contains("genmove")) {
                List<String> liste = Cmd.recuperer(commande);
                Cmd.genmove(liste.get(1));
                //System.out.println(Cmd.genmove(liste.get(0)));

            } else if (commande.equals("quit")) {
                break;
            } else {
                System.out.println("Commande inconnue !");
            }
            System.out.println();
        }

        scanner.close();
    }
}