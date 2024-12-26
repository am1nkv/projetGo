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
    private static int profondeur;

    public static boolean lancer(String couleur, String typeJoueur, String pf) {
        int p = Integer.parseInt(pf);
        profondeur = p;
        if (j1 != null) {
            if(initialiserJoueur(couleur, typeJoueur) != null && !Objects.equals(j1.getCouleurNom(), couleur)){
                j2 = initialiserJoueur(couleur, typeJoueur);

            }
            else{
                System.out.println("dommage");
            }
        }else if(initialiserJoueur(couleur, typeJoueur) != null){
            j1 = initialiserJoueur(couleur, typeJoueur);
            return true;
        }

        if(j1 != null && j2 != null){
            AuTourDe = (couleur.equals("black")) ? Pion.Couleur.X : Pion.Couleur.O;

            /*clearboard();*/
            /*boardsize("3");*/
            return true;// Détermine qui commence selon la couleur
        }
        return false;
    }

    public static int getProfondeur(){
        return profondeur;
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
            return null;
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

            joueurActuel.jouer(); // Bot joue automatiquement

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

            partie(null); // Appel récursif pour faire jouer le bot

        }
        finJeu();
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
