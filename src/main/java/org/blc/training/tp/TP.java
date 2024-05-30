package org.blc.training.tp;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author r.hendrick
 */
public class TP {

    public static void main(String[] args) {
//        trouveLeNombreAleatoireOptions();
        trouverLaSuiteDuNombre();
    }

    /**
     * Vous devez retrouver la suite d'une séquence de couleur. Les couleurs
     * possible sont (rouge, vert, bleu, orange, marron, noire). La séquence
     * peut être répétitive. L'utilisateur devra spécifier la séquence des
     * couleurs.
     * <p>
     * Un système de niveau permet de démarrer à une séquence de 3 couleurs à
     * retrouver
     * <p>
     * L'utilisateur pasera au niveau suivant dès que la séquence est trouvée.
     * Le niveau suivant sera incrément d'une séquence complémentaire.
     * <p>
     * Un score sera attribué en fonction du nombre d'essai effecuté au niveau.
     * <p>
     * Un nombre chance max permet à l'utilisateur de continuer le jeux.
     * <p>
     * Bien évidement l'utilisateur peu arrêter à tout instant le jeux.
     * <p>
     * Il peut également poursuivre (recommencer)
     * <p>
     * Example :
     * <p>
     * Niveau 1 : le système gènre la séquence
     * <p>
     * | x | x | x | correspondant à | b | v | o |
     * <p>
     * L'utilisateur propose la séquence séparer comme suit v; n;r
     * <p>
     * Vous devez lui répondre | 1 | x | x | : le 1 permet d'indiquer une valeur
     * bonne mais mal positionnée<p>
     * Essai suivant l'utilisateur indique o;v;m >> | 1 | v | x | ...
     * <p>
     * si résultat ok >> | b | v | o |
     * <p>
     * Niveau 2 : le système gènere la séquence du niveau
     * <p>
     * | x | x | x | x | correspondant à | m | o | n | v |
     * <p>
     * ...
     *
     * <p>
     * Astuces : utilisation de tableau argc[] >> TypeVariable n[tailleTableau];
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void trouverLaSuiteDuNombre() {
        //        out("|");
        //        int i = 0;
        //        while (i <= 3 + 0) {
        //            out(" x |");
        //            i++;
        //        }
        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

}

/**
 *
 * Options : chance
 * <p>
 * avec limitation d'essai : On octroie en démarrant le jeu un nombre défini de
 * chance et ce nombre n'est pas renouvlable entre les essais.
 *
 * Options : Niveau difficulté
 * <p>
 * Niveau 0 - 0...10
 * <p>
 * Niveau 1 - 0...20
 * <p>
 * Niveau 2 - 0...30 ...
 *
 * Options : Calculer le score de la personne Nombre pour atteindre un niveau
 *
 * On gagne des points en fonction du nombre de chances définies exempté du
 * nombre d'essai échoué au préalable au multiple du niveau. Exemple : nombre de
 * chance prédéfinie est de 6. Je suis au niveau 2. Je réalise un succès au
 * 2ième essai sachant que mon score au premier niveau était de 3. Il vient que
 * mon nouveau score = 3 + (6-1)*2 = 13.
 *
 *
 *
 */
public static void trouveLeNombreAleatoireOptions() {
        String yesno = "y";

        /**
         * Terminaison ou non de l'application
         */
        while (yesno.matches("y")) {
            /**
             * Niveau de difficulté logiciel
             */
            Integer level = 1;
            Integer chanceMax = 5;
            Integer chance = chanceMax;
            Integer score = 0;
            Scanner scan = new Scanner(System.in);
            Boolean isQuit = false;
            while (!isQuit && chance > 0) {// Passage de niveau

                outn("=|=====================================================|=");
                outn("=| Niveau : " + level + " >> vous avez " + chance + " chances     |=");
                outn("=|=====================================================|=");

                Integer inconnu = (int) (Math.random() * (10 * level));
                outn("Essayer de retrouver le nombre caché compris entre 0 et " + (level * 10) + " :");

                Boolean isValueCorrect = false;
                while (!isValueCorrect && !isQuit && chance > 0) { // Niveau en cours
                    // Récupérer la valuer
                    Integer value = -1;
                    Boolean isCorrectInput = false;
                    while (!isCorrectInput && !isQuit) { // Parce que les informatiosn saisie ne sont pas cohérente par rapport à un nombre ou à quitter
                        out("Entrer un nombre de 0 à " + (10 * level) + " : ");
                        try {
                            value = scan.nextInt();
                            isCorrectInput = true;
                        } catch (InputMismatchException erreur) {
                            String str = scan.next();
                            String msgError = "Vous devez renseigner un nombre ou \"q\" pour quitter";
                            if (str != null) {
                                if (str.toLowerCase().substring(0, 1).matches("q")) {
                                    isQuit = true;
                                } else {
                                    outn(msgError);
                                }
                            } else {
                                outn(msgError);
                            }
                        }
                    }

                    if (!isQuit) { // Only if user want to continue
                        // Compare si le nombre fourni par l'utilisateur correspond à l'inconnu
                        if (value == inconnu) {
                            out("Bravo le nombre était : " + inconnu + " ! ");
                            isValueCorrect = true;
                            score += ((chanceMax - (chanceMax - chance)) * level);
                            // Inrémenter le passage de niveau
                            level++;
                        } else {
                            chance--;
                            if (value > inconnu) {
                                out("Valeur fournie est trop grande ! ");
                            } else if (value < inconnu) {
                                out("Valeur fournie est trop petite ! ");
                            }
                            out("Il vous reste " + chance + " chances");
                        }
                        outn(" Score actuel : " + score);
                    } else {// condition if pour quitter
                        out("=| Vous avez souhaitez quitter au niveau " + level + " avec un score de "
                                + score + " pour un nombre de chance restant de " + chance);
                        outn("=|=====================================================|=");
                    }
                }// if info correct
            }// if niveau

            /**
             * Vous avez perdu vous êtes informé
             */
            if (chance <= 0) {
                outn("Désoler, vous avez perdu ! Vous n'avez plus de chance.");
            }

            /**
             * C'est recommencer depuis le début our arrêter
             */
            yesno = "";
            while (!yesno.matches("y") && !yesno.matches("n")) {
                outn("Voulez-vous recommencer ? y/n");
                try {
                    yesno = scan.next();
                } catch (NoSuchElementException e) {
                    outn("Merci de specifier une information correct ! ");
                    yesno = "";
                }
                yesno = yesno.toLowerCase();
                outn("YesNo tolowerCase :" + yesno + " >> " + yesno.toLowerCase());
            }
        }
        outn("Merci d'avoir participer !");

    }

    /**
     *
     * Options : chance avec limitation d'essai / Limiter le nombre d'essai
     * simultanée !
     *
     * Options : Niveau difficulté Niveau 0 - 0...10 Niveau 1 - 0...20 Niveau 2
     * - 0...30 ...
     *
     * Options : Calculer le score de la personne Nombre pour atteindre un
     * niveau
     *
     *
     */
    public static void trouveLeNombreAleatoire() {
        String yesno = "y";

        while (yesno.matches("y")) {
            outn("=|=====================================================|=");
            outn("=| Trouver un nombre ent 0 et n                        |=");
            outn("=|=====================================================|=");

            Integer inconnu = (int) (Math.random() * 10);
            outn("Essayer de retrouver le nombre caché compris entre 0 et 10 :");
            Scanner scan = new Scanner(System.in);

            Boolean isValueCorrect = false;
            while (!isValueCorrect) {
                // Récupérer la valuer
                Integer value = -1;
                try {
                    value = scan.nextInt();
                } catch (InputMismatchException erreur) {
                    outn("Valeur renseignée ne peut être convertie"
                            + "\nErreur : " + erreur.getMessage());
                    return;
                }
                // Compare si le nombre fourni par l'utilisateur correspond à l'inconnu
                if (value > inconnu) {
                    outn("Valeur fournie est trop grand !");
                } else if (value < inconnu) {
                    outn("Valeur fournie est trop petite ! ");
                } else {
                    outn("Bravo le nombre était : " + inconnu + " !");
                    isValueCorrect = true;
                }
            }

            yesno = "";
            while (!yesno.matches("y") && !yesno.matches("n")) {
                outn("Voulez-vous recommencer ? y/n");
                try {
                    yesno = scan.next();
                } catch (NoSuchElementException e) {
                    outn("Merci de specifier une information correct ! ");
                    yesno = "";
                }
                yesno = yesno.toLowerCase();
                outn("YesNo tolowerCase :" + yesno + " >> " + yesno.toLowerCase());
            }
        }
        outn("Merci d'avoir participer !");

    }

    public static void boucleWhileDo() {
        Integer A = 500;
        Integer B = 450;
        Integer i = 1;

        while (B < A) {
            outn(i + " : " + B + " < " + A + " : ");
            B++; // incrémentation B de 1
            i++;
        }

//        do {
//
//        } while (B < A);
    }

    public static void mainFactoriel() {
        Scanner scan = new Scanner(System.in);
        Integer value = 0;
        outn("Insérer une valeur :");
        try {
            value = Integer.valueOf(scan.nextInt());
        } catch (NumberFormatException e) {
            outn("Valeur de nombre attendu : " + e.getMessage());
            return;
        }
        outn(value + "!=" + factoriel(value));

    }

    /**
     *
     *
     * ex: n = 6! = 1 x (2) *(3) *(4) *(5) * (6) => 6! = (6-0) * (6-1) * (6-2) *
     * (6-3) * (6-4) * (6-5)
     *
     * @param n nombre a factorizé
     */
    public static Integer factoriel(Integer n) {
        int i = 1;
        Integer value = n;
        while (i < n) {
            value = value * (n - i);
            outn(i + " :" + value);
            i++;
        }
        return value;
    }

    public static void outn(String msg) {
        System.out.println(msg);
    }

    public static void out(String msg) {
        System.out.print(msg);
    }
}
