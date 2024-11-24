public class Pion {
    public enum Couleur { X, O } // X(Noir)  O(Blanc)

    private Couleur couleur;
    private Case position;

    public Pion(Couleur couleur) {
        this.couleur = couleur;
        this.position = null;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    @Override
    public String toString() {
        if(couleur==Couleur.X){
            return "X";
        }
        return "O";
    }
}
