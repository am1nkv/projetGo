import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String rep = sc.nextLine();
            ICommande cmd;
            if(rep.contains("boardsize")){
                cmd = new CmdBoardSize();
                cmd.recuperer(rep);
                System.out.println(cmd);
            }

        }
    }
}