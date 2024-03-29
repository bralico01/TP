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
public class WelcomeScanner {
    
    /**
     * Point entrée APP
     * @param arg paramètre app - non utilisé
     */
    public static void main(String[] arg){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez insérer votre prénom : ");
        
        // Lecture du nom de la personne
        String prenom = scan.next();
        
        // Affichage du résultat
        System.out.println("Bienvenu " + prenom);
        
        
    }
}
