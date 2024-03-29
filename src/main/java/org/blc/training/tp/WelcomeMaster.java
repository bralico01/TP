/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

/**
 *
 * @author r.hendrick
 */
public class WelcomeMaster {

    /**
     * Point d'entre APP
     *
     * @param arg doit être [0] : "Prénom Nom" [1]: "Sa Fonction"
     */
    public static void main(String[] arg) {

        // Assure l'intégrité du nombre d'information fourni ! 
        if(arg.length != 2){
            System.out.println("Le nombre de paramètre saisie est de : " 
                        + arg.length + " ce qui est différente du nombre "
                                + "attentu de 2\n"
                                + "java WelcomeMaster \"Prenom Nom\" \"La Fonction\"");
            return;
        }
        
        
        System.out.println("AVE le plus grand « "
                + arg[1] + " » premier du nom « "
                + arg[0] + " !");
        
       
    }
}
