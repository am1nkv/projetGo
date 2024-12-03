import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commande = scanner.nextLine().toLowerCase();
            List<String> l = Cmd.recuperer(commande);

            if (l.get(0).equals("boardsize")) {
                Cmd.boardsize(l.get(1));
            } else if (l.get(0).equals("play")) {
                Cmd.play(l.get(1), l.get(2).toUpperCase());
                System.out.println();
            } else if (l.get(0).equals("clearboard")) {
                Cmd.clearboard();
            } else if (l.get(0).equals("showboard")) {
                Cmd.showboard();
            } else if (l.get(0).equals("genmove")) {
                Cmd.genmove(l.get(1));
            } else if (l.get(0).equals("quit")) {
                Cmd.quit();
            } else {
                System.out.println("Commande inconnue !");
            }
            System.out.println();
        }
    }
}