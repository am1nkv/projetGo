import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String commande = scanner.nextLine().toLowerCase();
            if (commande.startsWith("boardsize")) {
                Cmd.boardsize(commande);
            } else if (commande.startsWith("play")) {
                List<String> liste = Cmd.recuperer(commande);
                Cmd.play(liste.get(0), liste.get(1).toUpperCase());
            } else if (commande.equals("clear_board")) {
                Cmd.clear_board();
            } else if (commande.equals("showboard")) {
               Cmd.showboard();
            } else if (commande.equals("quit")) {
                break;
            } else {
                System.out.println("Commande inconnue !");
            }
        }

        scanner.close();
    }
}