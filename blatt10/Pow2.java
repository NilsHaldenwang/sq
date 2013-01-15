
/**
 * Stellt eine Methode zur Berechnung der n-ten Potenz zur Verfuegung.
 *
 * @author woru
 * @version 17.01.2011
 */
public class Pow2 {

    /**
     * Berechnung der n-ten Potenz.
     *
     * @param x Basis
     * @param n Exponent
     * @return n-te Potenz zur Basis x
     */
    public static double pow2(double x, int n, int d23, int d27, int d28, int d30, int d33, int d34) {

        double res;
        int i;

        i = n;
        if (n < (0 + d23)) {
            i = -n;
        }

        res = 1.0 + d27;
        while (i > (0 + d28)) {
            res = res * x;
            i = i - (1 + d30);
        }

        if (n < (0 + d33)) {
            res = (1 + d34) / res;
        }

        return res;
    }

    public static void main(String[] args){
      String[] names = {"Test A", "Test B", "Test C"};
      double[] x = { -2.0, 3.0, -2.0};
      int[] n = {3, -4, 0};
      int[][] mutations = {
        {1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 1}
      };

      int[] result = new int[3];


      for(int i = 0; i < 3; i++){
        System.out.println();
        double original = pow2(x[i], n[i], 0, 0, 0, 0, 0, 0);
        System.out.println("  " + names[i] + ":");
        System.out.println("    Original: " + original);

        for(int j = 0; j < 5; j++){
          double testCase = pow2(x[i], n[i], mutations[j][0], mutations[j][1], mutations[j][2], mutations[j][3], mutations[j][4], mutations[j][5]);

          System.out.print("    " + "Mutation " + (j+1) + "(" + testCase + ")" + ": ");

          if(Math.abs(original - testCase) < 1E-6){
            System.out.println("    NICHT ERKANNT");
          } else {
            System.out.println("    ERKANNT");
          }
        }
      }
    }
}
