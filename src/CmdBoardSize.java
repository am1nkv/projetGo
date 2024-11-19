
public class CmdBoardSize implements ICommande {
    private int size;
    private final char[] tabPossibilities;

    public CmdBoardSize() {
        this.size = 0;
        this.tabPossibilities = new char[]{'5', '6', '7', '8', '9' /*, "11", "13", "15", "17", "19"*/};
    }
    @Override
    public void execute() {

    }

    @Override
    public void recuperer(String ligne) {
            for(int i=0 ; i < ligne.length() ; i++) {
                for (char tabPossibility : tabPossibilities) {
                    if (ligne.charAt(i) == tabPossibility) {
                        size = Integer.parseInt(String.valueOf(ligne.charAt(i)));
                        break;
                    }
                }

            }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString(){
       return String.valueOf(size);
    }
}
