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
        trouveLeNombreAleatoire();
    }

    public static void boucleWhileDo() {
        Integer A = 500;
        Integer B = 450;
        Integer i = 1;

        while (B < A) {
            out(i + " : " + B + " < " + A + " : ");
            B++; // incrémentation B de 1
            i++;
        }

//        do {
//
//        } while (B < A);
    }

    /**
     * 
     * Options : chance 
     *           avec limitation d'essai / 
     *           Limiter le nombre d'essai simultanée ! 
     * 
     * Options : Niveau difficulté
     *          Niveau 0 - 0...10
     *          Niveau 1 - 0...20
     *          Niveau 2 - 0...30
     *          ...
     * 
     * Options : Calculer le score de la personne
     *          Nombre pour atteindre un niveau
     * 
     * 
     */
    public static void trouveLeNombreAleatoire() {
        String yesno = "y";

        while (yesno.matches("y")) {
            out("=|=====================================================|=");
            out("=| Trouver un nombre ent 0 et n                        |=");
            out("=|=====================================================|=");

            Integer inconnu = (int) (Math.random() * 10);
            out("Essayer de retrouver le nombre caché compris entre 0 et 10 :");
            Scanner scan = new Scanner(System.in);

            Boolean isValueCorrect = false;
            while (!isValueCorrect) {
                // Récupérer la valuer
                Integer value = -1;
                try {
                    value = scan.nextInt();
                } catch (InputMismatchException erreur) {
                    out("Valeur renseignée ne peut être convertie"
                            + "\nErreur : " + erreur.getMessage());
                    return;
                }
                // Compare si le nombre fourni par l'utilisateur correspond à l'inconnu
                if (value > inconnu) {
                    out("Valeur fournie est trop grand !");
                } else if (value < inconnu) {
                    out("Valeur fournie est trop petite ! ");
                } else {
                    out("Bravo le nombre était : " + inconnu + " !");
                    isValueCorrect = true;
                }
            }

            yesno = "";
            while (!yesno.matches("y") && !yesno.matches("n")) {
                out("Voulez-vous recommencer ? y/n");
                try{
                    yesno = scan.next();
                }catch(NoSuchElementException  e){
                    out("Merci de specifier une information correct ! ");
                    yesno = "";
                }
                yesno = yesno.toLowerCase();
                out("YesNo tolowerCase :" + yesno + " >> " + yesno.toLowerCase());
            }
        }
        out("Merci d'avoir participer !");

    }

    public static void mainFactoriel() {
        Scanner scan = new Scanner(System.in);
        Integer value = 0;
        out("Insérer une valeur :");
        try {
            value = Integer.valueOf(scan.nextInt());
        } catch (NumberFormatException e) {
            out("Valeur de nombre attendu : " + e.getMessage());
            return;
        }
        out(value + "!=" + factoriel(value));

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
            out(i + " :" + value);
            i++;
        }
        return value;
    }

    public static void out(String msg) {
        System.out.println(msg);
    }
}
