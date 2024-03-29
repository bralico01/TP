/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

import java.util.Scanner;

/**
 *
 * @author r.hendrick
 */
public class Macon {

    public static void main(String[] arg) {

        // Récupération du code du corps
        Scanner scan = new Scanner(System.in);

        // Collect the number
        Util.out("=|=====================================================|=");
        Util.out("=| Macon amateur                                       |=");
        Util.out("=|=====================================================|=");

        /**
         * Collect la première longueur A (coté adjacent)
         */
        Util.out("Veuillez à spécifier le côté adjacent - longueur A [m] :");
        String numberStr = scan.next();
        Float A = 0f;
        try {
            A = Float.valueOf(numberStr);
        } catch (Exception er) {
            Util.out("/ ! \\ La longueur A doit être un nombre du type 123.0");
            return;
        }

        /**
         * Collect la deuxième longueur O (côté opposé)
         */
        Util.out("Veuillez à spécifier le côté opposé - longueur O [m] :");
        numberStr = scan.next();
        Float O = 0f;
        try {
            O = Float.valueOf(numberStr);
        } catch (Exception er) {
            Util.out("/ ! \\ La longueur O doit être un nombre du type 123.0");
            return;
        }

        /**
         * Présente le résultat
         */
        Float H = (float) Math.sqrt((A * A) + (O * O));
        Float Lfi = A + O + H; // Longueur de fil initial
        Util.out("L'hypoténuse nécessaire est de >> " + H + " m <<\n"
                + "La longeur de fil requise est de >> " + Lfi + " m <<");

        /**
         * Valide qu'il n'est pas nécessaire d'adapter les dimenssion par
         * rapport au fil
         */
        Util.out("=|=====================================================|=");
        Util.out("=| Voulez-vous adapter en fonction de la longueur du   |=");
        Util.out("=| fil : ex: Longuer fil = A ? + O? + H?               |=");
        Util.out("=| ?? 0 (pour non) et une valeur pour la longueur      |=");
        Util.out("=|=====================================================|=");
        numberStr = scan.next();
        Float Lf = 0f;
        try {
            Lf = Float.valueOf(numberStr);
        } catch (Exception er) {
            Util.out("/ ! \\ La longueur du fil doit être un nombre du type 123.0");
            return;
        }

        Float facteur = Lf / Lfi; // récupère le facteur de proportion

        Util.out("Pour une longueur de fil de " + Lf + " m au lieu de " + Lfi + " m, il vient : ");
        Util.out(" > A = " + (facteur * A) + " m");
        Util.out(" > O = " + (facteur * O) + " m");
        Util.out(" > H = " + (facteur * H) + " m");

    }
}
