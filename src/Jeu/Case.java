package Jeu;

public class Case {
    private int x;
    private int y;
    private Pion pion;     //Le pion présent sur la case, ou null si la case est vide.

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.pion = null;  //Par défaut, une case est vide.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEmpty() {
        return pion == null;
    }



    public Pion getPion() {
        return pion;
    }

    // Place un pion sur la case
    public void setPion(Pion pion) {
        if (pion == null) {
            throw new IllegalArgumentException("Un pion valide est requis.");
        }
        this.pion = pion;
        pion.setPosition(this);    //Mise à jour de la position du pion.
    }

    // supprime le pion
    public void removePion() {
        if (pion != null) {
            pion.setPosition(null); //Mise à jour de la position du pion.
            this.pion = null;       //Supprime le pion de la case.
        }
    }

    @Override
    public String toString() {
        if(!isEmpty()){
            return pion.toString();
        }
        return ".";
    }
}
