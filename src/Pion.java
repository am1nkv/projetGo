public class Pion {
    public enum Couleur { N, B }

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
}