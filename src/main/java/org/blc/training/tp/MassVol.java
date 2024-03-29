/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

import java.util.Scanner;
import org.blc.training.tp.Util;

/**
 *
 * @author r.hendrick
 */
public class MassVol {

    /**
     * Point entrée application
     *
     * @param arg [0]: 3ième car dur corps du matériaux (facultatif), [1]: Etat
     * (facultatif et au scanner)
     */
    public static void main(String[] arg) {

        // Récupération du code du corps
        Scanner scan = new Scanner(System.in);

        // Collete code du corps en 3 caractères
        Util.out("Insérer le code (3ième lettres du matériaux) : ");
        String name = scan.next();
        Util.checkLength(name, 3,
                "Le code inscrit être uniquement de 3 caractères ###");

        // Converti l'entrée en minuscule
        name = name.toLowerCase();

        // Définit la prise en compte de l'état
        Util.out("Voulez-vous spécifier l'état du corps ? y/n");
        String choice = scan.next();
        Util.checkLength(choice,
                "Vous devez répondre y ou n respectivement yes ou no !");

        // Récupère si nécessaire l'état du corps
        String etat = "";
        if (choice.toLowerCase().matches("y")) {
            Util.out("Insérer l'état souhaité ? l(liquide)/s(solide)/g(gaz)/a(tous)");
            etat = scan.next();
            Util.checkLength(etat, "Vous devez répondre parmi la liste "
                    + "de choix (l, s, g, a) ci-dessus !");
        }

        // Creation des différent résultat
        String eau = "eau > liquide > 1 000 kg/m³";
        String eaus = "eau > s > 917 kg/m³";
        String essence = "essence > liquide > 750 kg/m³";
        String glace = "glace à 0°C > solide > 917 kg/m³";
        String fer = "fer > solide > 7 900 kg/m³";
        String alu = "aluminium > solide > 2 700 kg/m³";
        String liege = "liège > solide > 250 kg/m³";
        String poly = "polystyrène expansé > solide > 15 kg/m³";
        String beton = "béton > solide > 2 500 kg/m³";
        String sable = "sable > solide > 1 600 kg/m³";

        // Gestion de l'état
        if (choice.toLowerCase().matches("y")) { // Etat à prendre en compte
            if (name.matches("eau")) {
                if (etat.matches("l") || etat.matches("a")) {
                    Util.out(eau);
                }
                if (etat.matches("s") || etat.matches("a")) {
                    Util.out(eaus);
                }
                if (!etat.matches("l") && !etat.matches("s") && !etat.matches("a")) {
                    Util.out("Votre matériaux " + name + " n'exite pas encore ou sous cet état ! ");
                }
            } else if (name.matches("ess") && (etat.matches("l") || etat.matches("a"))) {
                Util.out(essence);
            } else if (name.matches("gla") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(glace);
            } else if (name.matches("fer") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(fer);
            } else if (name.matches("alu") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(alu);
            } else if (name.matches("lie") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(liege);
            } else if (name.matches("pol") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(poly);
            } else if (name.matches("bet") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(beton);
            } else if (name.matches("sab") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(sable);
            } else if (name.matches("eau") && (etat.matches("s") || etat.matches("a"))) {
                Util.out(eaus);
            } else {
                Util.out("Votre matériaux " + name + " n'exite pas encore ou sous cet état ! ");
            }
        } else if (choice.toLowerCase().matches("n")) {// sans état
            if (name.matches("eau")) {
                Util.out(eau);
                Util.out(eaus);
            } else if (name.matches("ess")) {
                Util.out(essence);
            } else if (name.matches("gla")) {
                Util.out(glace);
            } else if (name.matches("fer")) {
                Util.out(fer);
            } else if (name.matches("alu")) {
                Util.out(alu);
            } else if (name.matches("lie")) {
                Util.out(liege);
            } else if (name.matches("pol")) {
                Util.out(poly);
            } else if (name.matches("bet")) {
                Util.out(beton);
            } else if (name.matches("sab")) {
                Util.out(sable);
            }  else {
                Util.out("Votre matériaux " + name + " n'exite pas encore ! ");
            }
        } else {
            Util.out("Votre état " + choice.toLowerCase() + " n'est pas connu ! Attentu y ou n");
        }

    }

}
