package IHM;

import Joueurs.*;
import Jeu.Pion;

import java.util.Objects;

import static IHM.Cmd.*;
import static Jeu.Pion.Couleur.*;

public class Jeu {
    private static Joueur j1; // Peut être un joueur humain ou un bot
    private static Joueur j2; // Peut être un joueur humain ou un bot
    private static Pion.Couleur AuTourDe;

    public static void lancer(String couleur, String typeJoueur) {
        if (j1 != null) {
            j2 = initialiserJoueur(couleur, typeJoueur);
            return;
        }
        j1 = initialiserJoueur(couleur, typeJoueur);

        // Détermine qui commence selon la couleur
        AuTourDe = (couleur.equals("black")) ? Pion.Couleur.X : Pion.Couleur.O;

        /*clearboard();*/
        boardsize("4");
    }

    private static Joueur initialiserJoueur(String couleur, String type) {
        Joueur joueur = null;

        if (type.equalsIgnoreCase("human")) {
            joueur = new JoueurHumain(couleur, "human");
        } else if (type.equalsIgnoreCase("randomBot")) {
            joueur = new JoueurBotNaif(couleur, "randomBot");
        } else if (type.equalsIgnoreCase("minimax")) {
            joueur = new JoueurBotMax(couleur, "minimax");
        } else {
            System.out.println("Type de joueur non valide.");
        }

        return joueur;
    }

    public static void partie(String coord) {
        Joueur joueurActuel = (AuTourDe == j1.getCouleur()) ? j1 : j2;

        // Le joueur actuel joue
        if (Objects.equals(joueurActuel.getType(), "human")) {
            if (coord == null) {
                joueurActuel.jouer(); // Joueur humain joue sans coordonnées
            } else {
                joueurActuel.jouer(coord); // Joueur humain joue avec des coordonnées
            }
        } else {
            System.out.println("encore la ");
            joueurActuel.jouer(); // Bot joue automatiquement
            System.out.println("on est sortie de la gav");
        }

        // Afficher le plateau
        showboard();

        // Vérifier la victoire (arrête le programme si estGagnant détecte un gagnant)
       estGagnant(AuTourDe);

        // Passer au prochain joueur
        AuTourDe = (AuTourDe == Pion.Couleur.O) ? Pion.Couleur.X : Pion.Couleur.O;

        // Si le prochain joueur est un bot, il joue immédiatement
        Joueur prochainJoueur = (AuTourDe == j1.getCouleur()) ? j1 : j2;
        System.out.println(prochainJoueur.getType());
        if (!Objects.equals(prochainJoueur.getType(), "human") ) {
            System.out.println("on est dans la viande");
            partie(null); // Appel récursif pour faire jouer le bot
            System.out.println("on a quitté la viande");
        }
    }





    public static String joueurActuel() {
        if (j1 == null || j2 == null) {
            throw new IllegalStateException("Les joueurs n'ont pas été initialisés.");
        }
        String type = (AuTourDe == j1.getCouleur()) ? j1.getType() : j2.getType();
       /* System.out.println("Type du joueur actuel : " + type);*/
        return type;
    }
}
