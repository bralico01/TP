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
public class PairImpair {
    
    public static void main(String[] arg) {

        // Récupération du code du corps
        Scanner scan = new Scanner(System.in);

        // Collect the number
        Util.out("=|=====================================================|=");
        Util.out("=| Pair ou Impair                                      |=");
        Util.out("=|=====================================================|=");

        //
        String numberStr = "";
        if (arg.length >= 1) {
            Util.out("Utilisation de la valeur en paramètre : " + arg[0]);
            numberStr = arg[0];
        } else {
            Util.out("Veuillez à spécifier un nombre uniquement : ");
            numberStr = scan.next();
        }
        
        Integer value = 0;
        try {
            value = Integer.valueOf(numberStr);
        } catch (NumberFormatException er) {
            Util.out("Vous devez spécifier un nombre entier svp ! Ex: 123"
                    + "\nErreur suivante : " + er.getMessage()
                    + "\nLigne erreur : " + er.getLocalizedMessage());
            return;
        }

        // Preparation mesure d'identification
        Integer vala = value / 2;
        Integer valb = (value + 1) / 2;
        Integer val = vala - valb;

        // Logique de présentation
        if (val == 0) {
            Util.out("Le nombre " + value + " est PAIR");
            Util.out(" > " + value + " / 2 = " + vala);
        } else {
            Util.out("Le nombre " + value + " est IMPAIR");
            Util.out(" > " + value + " / 2 = " + (value / 2f));
        }
        
    }
}
