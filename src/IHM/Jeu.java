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
                System.out.println(reponse(true));
            }

        }else if(initialiserJoueur(couleur, typeJoueur) != null){
            j1 = initialiserJoueur(couleur, typeJoueur);
            System.out.println(reponse(true));

            return true;
        }

        if(j1 != null && j2 != null){
            AuTourDe = X;

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

    public static void partie(String coord , String couleur ) {
        // Identifier le joueur actuel
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

        // Vérifier la victoire (arrête le programme si un gagnant est détecté)
        estGagnant(AuTourDe);

        // Passer au prochain joueur
        AuTourDe = (AuTourDe == Pion.Couleur.O) ? Pion.Couleur.X : Pion.Couleur.O;

        // Si le prochain joueur est un bot, il joue immédiatement
        Joueur prochainJoueur = (AuTourDe == j1.getCouleur()) ? j1 : j2;

        if (!Objects.equals(prochainJoueur.getType(), "human")) {
            partie(null , String.valueOf(AuTourDe)); // Appel récursif pour faire jouer le bot
        }

        // Vérifier si le jeu est terminé
        finJeu();
    }


    public static Pion.Couleur getCouleurC(String couleur){
        if(couleur.equalsIgnoreCase("black") || couleur.equalsIgnoreCase("B") || couleur.equalsIgnoreCase("b")){
            return Pion.Couleur.X;
        } else if (couleur.equalsIgnoreCase("white") || couleur.equalsIgnoreCase("W") || couleur.equalsIgnoreCase("w")) {
            return Pion.Couleur.O;

        }
        return null;
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
