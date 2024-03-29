package org.blc.training.tp;

/**
 *
 * @author r.hendrick
 */
public class Util {

    public static void out(String msg) {
        System.out.println(msg);
    }

    /**
     * checkLength
     *
     * Contrôle que la taille de l'argument correspond à la size sinon retourne
     * un message erreur avant de quitter
     *
     * @param arg
     * @param size
     * @param msg
     */
    public static void checkLength(String arg, int size, String msg) {
        if (arg.length() != size) {
            Util.out(msg);
            System.exit(0);
        }
        
    }

    /**
     * CheckLength
     *
     * Contrôle que seul un paramètre est défini
     *
     * @param arg argument de longueur à comparer
     * @param msg message à inscrire
     */
    public static void checkLength(String arg, String msg) {
        checkLength(arg, 1, msg);
    }

}
