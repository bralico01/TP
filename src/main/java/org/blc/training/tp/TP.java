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
        trouveLeNombreAleatoireOptions();
    }

    /**
     *
     * Options : chance
     * <p>
     * avec limitation d'essai : On octroie en démarrant le jeu un nombre défini
     * de chance et ce nombre n'est pas renouvlable entre les essais.
     *
     * Options : Niveau difficulté
     * <p>
     * Niveau 0 - 0...10
     * <p>
     * Niveau 1 - 0...20
     * <p>
     * Niveau 2 - 0...30 ...
     *
     * Options : Calculer le score de la personne Nombre pour atteindre un
     * niveau
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
            Integer chance = 5;
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
                        out("Entrer un nombre de 0 à " + (10*level) + " : ");
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
                            outn("Bravo le nombre était : " + inconnu + " !");
                            isValueCorrect = true;
                            // Inrémenter le passage de niveau
                            level++;
                        } else {
                            chance--;
                            if (value > inconnu) {
                                out("Valeur fournie est trop grande !");
                            } else if (value < inconnu) {
                                out("Valeur fournie est trop petite !");
                            }
                            outn("Il vous reste " + chance + " chances");
                        }
                    }
                }
            }

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
