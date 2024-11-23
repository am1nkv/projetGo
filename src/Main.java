import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String commande = scanner.nextLine().toLowerCase();

            if (commande.startsWith("boardersize")) {
                Cmd.boardersize(commande);
            } else if (commande.startsWith("play")) {
                List<String> liste = Cmd.recuperer(commande);
                Cmd.play(liste.get(0), liste.get(1).toUpperCase());
            } else if (commande.equals("clear_bord")) {
                Cmd.clear_bord();
            } else if (commande.equals("showbord")) {
               Cmd.showbord();
            } else if (commande.equals("quit")) {
                break;
            } else {
                System.out.println("Commande inconnue !");
            }
        }

        scanner.close();
    }
}