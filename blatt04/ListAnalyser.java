import java.util.List;
import java.util.Arrays;

/**
 * Sample program for analysing a given list.
 *
 * @author Wolfgang Runte
 * @version 15.11.2010
 */
public class ListAnalyser {

    public static void main(String[] args) { 
      ListAnalyser la = new ListAnalyser();

      List<String> lst = Arrays.asList("0", "1", "2", "3");
      int[] aiResults = new int[0];

      la.analyseList(lst, aiResults);
    }

    /**
     * Method to analyse the elements of a given list of strings. The following
     * occurences in the list are counted: (1) elements that could be parsed to
     * a number (int value), (2) even numbers, (3) words (the remaining
     * elements) containing any characters, (4) words with an even number of
     * characters. Empty strings and 'null' are ignored.
     *
     * @param in_lstList list to be analysed
     * @param out_aiResults output array containing the results counted by the
     *        analysis: [1] numbers found, [2] even numbers found, [3] words
     *        found, [4] words with even number of characters found.
     * @return 'true' if the given list could be processed and the results are
     *         stored in the output array, 'false' otherwise
     */
    public boolean analyseList(List<String> in_lstList, int[] out_aiResults) {
        System.out.print("1 ");
        boolean bResult = false;

        if (in_lstList != null && !in_lstList.isEmpty()) {

          System.out.print("2 ");
            // initialize counters
            int iNumberCounter = 0;
            int iEvenNumberCounter = 0;
            int iWordCounter = 0;
            int iEvenWordCounter = 0;

            // go through all elements of the given list
            for (String strElement : in_lstList) {
                // ignore 'null' and empty strings
                if (strElement != null && !strElement.isEmpty()) {
                  System.out.print("3 ");
                    int iNumber = 0;
                    boolean bNumberFound = false;

                    // try to parse the current list element to an int value
                    try {
                      System.out.print("4 ");
                        iNumber = Integer.parseInt(strElement);
                      System.out.print("5 ");
                        bNumberFound = true;
                    } catch (NumberFormatException e) {
                        // do nothing
                    }

                    // check if a number was found
                    if (bNumberFound) {
                      System.out.print("6 ");
                        iNumberCounter++;
                        // check if number is even or odd
                        if (iNumber % 2 == 0) {
                          System.out.print("7 ");
                            iEvenNumberCounter++;
                            /* System.out.println(iEvenNumberCounter + */
                            /*         ". even number found: " + iNumber); */
                        } else {
                          System.out.print("8 ");
                            /* System.out.println(iNumberCounter + */
                            /*         ". number found: " + iNumber); */
                        } // end if
                    } else { // no number found
                      System.out.print("9 ");
                        iWordCounter++;
                        // check if the number of characters of the current
                        // list element is even or odd
                        if (strElement.length() % 2 == 0) {
                          System.out.print("10 ");
                            iEvenWordCounter++;
                            /* System.out.println(iEvenWordCounter + ". word " + */
                            /*         "with even number of characters found: " + */
                            /*         strElement); */
                        } else {
                          System.out.println("11 ");
                            /* System.out.println(iWordCounter + ". word found: " + */
                            /*         strElement); */
                        } // end if
                    } // end if
                } // end if
            } // end for

            // put the results into output array
            if (out_aiResults != null && out_aiResults.length >= 4) {
              System.out.println("12 ");
                out_aiResults[0] = iNumberCounter;     // numbers found
                out_aiResults[1] = iEvenNumberCounter; // even numbers found
                out_aiResults[2] = iWordCounter;       // words found
                out_aiResults[3] = iEvenWordCounter;   // words with even number
                bResult = true;                        // ...of characters found
            } // end if
        } // end if
        System.out.println("13 ");
        return bResult;
    }
}
