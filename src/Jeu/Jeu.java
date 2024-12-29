package Jeu;

import Joueurs.*;
import Plateau.Pion;
import java.util.Objects;
import static Jeu.LogiqueJeu.*;
import static Jeu.Commande.showboard;
import static Plateau.Pion.Couleur.*;
import static Joueurs.Joueur.factoryJoueur;

public class Jeu {
    private static Joueur j1; //Peut être un joueur humain ou un bot
    private static Joueur j2; //Peut être un joueur humain ou un bot
    private static Pion.Couleur AuTourDe;
    private static int profondeur;

    public static boolean lancer(String couleur, String typeJoueur, String pf) {
        if (pf != null) {
            int p = Integer.parseInt(pf);
            profondeur = p;
        }
        if (j1 != null) {
            if (factoryJoueur(typeJoueur, couleur) != null && !Objects.equals(j1.getCouleurNom(), couleur)) {
                j2 = factoryJoueur(typeJoueur, couleur);
                System.out.println(reponse(true));
            }

        } else if (factoryJoueur(typeJoueur, couleur) != null) {
            j1 = factoryJoueur(typeJoueur, couleur);
            System.out.println(reponse(true));

            return true;
        }

        if (j1 != null && j2 != null) {
            AuTourDe = X;
            return true;
        }

        return false;
    }

    public static int getProfondeur() {
        return profondeur;
    }


    public static void partie(String coord) {
        Joueur joueurActuel = (AuTourDe == j1.getCouleur()) ? j1 : j2;


        if (joueurActuel.getType().equals("human")) {
            if (coord == null) {
                joueurActuel.jouer();
            } else {
                joueurActuel.jouer(coord);
            }
        } else {
            if (coord == null) {
                joueurActuel.jouer();
            }
        }

        showboard();
        estGagnant(AuTourDe);
        finJeu();

        AuTourDe = (AuTourDe == Pion.Couleur.O) ? Pion.Couleur.X : Pion.Couleur.O;

        Joueur prochainJoueur = (AuTourDe == j1.getCouleur()) ? j1 : j2;
        if (!prochainJoueur.getType().equals("human")) {
            partie(null);
        }
    }

    public static Pion.Couleur getCouleurC(String couleur) {
        if (couleur.equalsIgnoreCase("black") || couleur.equalsIgnoreCase("B") || couleur.equalsIgnoreCase("b")) {
            return Pion.Couleur.X;
        } else if (couleur.equalsIgnoreCase("white") || couleur.equalsIgnoreCase("W") || couleur.equalsIgnoreCase("w")) {
            return Pion.Couleur.O;

        }
        return null;
    }

    public static String joueurActuel() {
        if (j1 == null || j2 == null) {
            System.out.println("Les joueurs n'ont pas été initialisés.");
        }
        String type = (AuTourDe == j1.getCouleur()) ? j1.getType() : j2.getType();
        return type;
    }
}