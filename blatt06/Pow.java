
/**
 * Stellt eine Methode zur Berechnung der n-ten Potenz zur Verfuegung.
 * 
 * @author Wolfgang Runte
 * @version 30.11.2010
 */
public class Pow {

    /**
     * Berechnung der n-ten Potenz.
     * 
     * @param x Basis
     * @param n Exponent
     * @return n-te Potenz zur Basis x
     */
    public static double pow(double x, int n) {

        double res = 1.0;
        int i;

        if (n < 0) {
            i = -n;
        } else {
            i = n;
        }

        while (i > 0) {
            res *= x;
            i--;
        }

        if (n < 0) {
            res = 1 / res;
        }

        return res;
    }
}
