/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

/**
 *
 * @author r.hendrick
 */
public class Loop {

    public static void main(String argc[]) {
        /**
         * Générer une matrice de 3x3 de nombre aléatoire correspondant au
         * segment opposé d'un triangle rectangle (sin) et une du (cos). 
         * Générer en suite la matrice fournissant les hypoténuses. 
         * 
         * Présenter le résultat.
         */
        
        Double [][] sin = new Double [3][3];
        Double [][] cos = new Double [3][3];
        Double [][] hyp = new Double [3][3];
        
        /**
         * Fill random sin
         */
        
        System.out.println("========  SIN       ================");
        for(int i = 0; i < sin.length; i++){
            for(int j = 0; j < cos.length; j++){
                sin[i][j] = Math.random()*20.0;
                System.out.print(sin[i][j] + " \t");
            }
            System.out.println("");
        }
        System.out.println("===================================");
        
        
        /**
         * Fill random cos
         */
        System.out.println("========  COS       ================");
        for(int i = 0; i < sin.length; i++){
            for(int j = 0; j < cos.length; j++){
                cos[i][j] = Math.random()*20.0;
                System.out.print(cos[i][j] + " \t");
            }
            System.out.println("");
        }
        System.out.println("===================================");
        
        
        /**
         * Hyp 
         */
        System.out.println("========  HYP       ================");
        for(int i = 0; i < sin.length; i++){
            for(int j = 0; j < cos.length; j++){
                hyp[i][j] = Math.sqrt((sin[i][j]*sin[i][j]) + (cos[i][j]*cos[i][j]));
                System.out.print(hyp[i][j] + " \t");
            }
            System.out.println("");
        }
        System.out.println("===================================");
        
        
        
        
        /**
         * Affichage
         */
        
        
        
        
        
        
    }
    
    

    private void pairImpairVector() {
        /**
         * Classer dans un tableau les nombres pair dans la première colonne et
         * impair dans la deuxième. A partir de 50 jusqu'à 150. Imprimer ensuite
         * la pair comme suite (index):[pair0; impair0]
         */

        /**
         * Répartitiion et génération du tableau
         */
        Integer from = 4;
        Integer to = 9;
        /**
         * 0: 4; 5 1: 6; 7 2: 8; 9 3: 10; null
         *
         * (to-from)/2 => 3 ligne (to-from) % 2 = 0
         *
         * 0: 4; 5 1: 6; 7 2: 8; 9
         *
         * (to-from)/2 => 2.5 (3) ligne (to-from) % 2 = 1
         *
         *
         *
         */
//        int row = ((to - from) / 2) + (((to-from)%2 == 0) ? 1:0);
        int row = ((to - from) / 2) + 1;
        System.out.println("row = " + row);
//        if ((to - from) % 2 == 0) {
//            row++;
//        }
        Integer[][] pairImpair = new Integer[row][2];

        // Boucle d'analyse de plage
        int cursorPair = 0;
        int cursorImpair = 0;
        for (int i = from; i <= to; i++) {
            // Gestion nombre pair
            if (i % 2 == 0) {
                pairImpair[cursorPair][0] = i;
                cursorPair++;
            } // Gestion nombre impair
            else {
                pairImpair[cursorImpair][1] = i;
                cursorImpair++;
            }
        }

        /**
         * Affichage du tableau
         */
        for (int lgn = 0; lgn < pairImpair.length; lgn++) {
            System.out.println("(" + lgn + ") : [" + pairImpair[lgn][0]
                    + "; " + pairImpair[lgn][1] + "]");
        }
    }

    private void forOnTable() {
        /**
         * Création d'un tableau à 2 dimenssions.
         */
        String[][] map = new String[30][2];

        /**
         * Boucle sur le vecteur
         */
        for (int indiceVecteur = 0;
                indiceVecteur < map.length;
                indiceVecteur++) {
            // Remplissage de la colonne 0
            map[indiceVecteur][0]
                    = "F(" + (indiceVecteur + 1) + ") = "
                    + (indiceVecteur + 1) + "!";

            // Remplissage de la colonne 1
            int result = 1;
            for (int j = 0; j < (indiceVecteur + 1); j++) {
                result = result * (j + 1);
            }
            map[indiceVecteur][1] = "" + result;
        }

        System.out.print("Map(5) : " + map[4][0] + " = " + map[4][1] + " ? 120");

    }

    private void diffWhileAndDoWhile() {
        int i = 10;
        while (i < 10) {
            System.out.println("i = " + i);
            i++;
        }

        i = 10;
        do {
            System.out.println("do i = " + i);
            i++;
        } while (i < 10);
    }
}
