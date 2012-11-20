
/**
 * Sample program for the multiplication of a matrix with a scalar.
 *
 * @author Wolfgang Runte
 * @version 24.11.2010
 */
public class MatrixScalarMultiplication {

    /**
     * Compares two matrices: Checks if a given matrix B has the same or
     * greater dimensions as/than a given matrix A. Additionally it is checked
     * if matrix A is well-formed (constant number of columns).
     *
     * @param in_aiMatrixA matrix A to check
     * @param in_aiMatrixB matrix B to check
     * @return 'true' if matrix B has the same or greater dimensions as/than
     *         matrix A and matrix A is well-formed, 'false' otherwise
     */
    public static boolean greaterOrEqualDimensions(int[][] in_aiMatrixA,
            int[][] in_aiMatrixB) {
        boolean bResult = true;
        // check if matrices are not 'null'
        if (in_aiMatrixA != null && in_aiMatrixB != null
                // check number of lines: B has to be the same as A or greater
                && in_aiMatrixB.length >= in_aiMatrixA.length) {
            int iColumns = in_aiMatrixA[0].length;
            // go through the lines of the given matrices
            for (int i = 0; i < in_aiMatrixA.length; i++) {
                // check number of columns
                if (in_aiMatrixA[i].length != iColumns
                        || in_aiMatrixB[i].length < iColumns) {
                    bResult = false;
                    break;
                }
            }
        } else {
            bResult = false;
        }
        return bResult;
    }

    /**
     * Method to multiplicate a given input matrix with a given scalar. Returns
     * the result in a given output matrix. The output matrix has to be of the
     * same or greater dimensions as/than the input matrix.
     *
     * @param in_iScalar scalar to multiplicate the matrix
     * @param in_aiMatrixA matrix to multiplicate
     * @param out_aiMatrixB matrix containing the result of the multiplication
     * @return 'true' if multiplication was successful, 'false' otherwise
     */
    public static boolean multMatrixScalar(int in_iScalar, int[][] in_aiMatrixA,
            int[][] out_aiMatrixB) {
        boolean bResult = false;
        // check if the given matrices are not 'null' and the output matrix has
        // the same or greater dimensions as/than the input matrix
        if (in_aiMatrixA != null && out_aiMatrixB != null
                && greaterOrEqualDimensions(in_aiMatrixA, out_aiMatrixB)) {
            // go through the lines of the input matrix
            for (int i = 0; i < in_aiMatrixA.length; i++) {
                // go through the columns of the input matrix and multiplicate
                for (int j = 0; j < in_aiMatrixA[i].length; j++) {
                    out_aiMatrixB[i][j] = in_iScalar * in_aiMatrixA[i][j];
                }
            }
            bResult = true;
        }
        return bResult;
    }
}

