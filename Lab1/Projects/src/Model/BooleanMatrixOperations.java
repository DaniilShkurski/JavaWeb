package Model;

import java.security.InvalidParameterException;

public class BooleanMatrixOperations {
    /**
     * Function of adding two matrix.
     * @param matrix_a first boolean matrix to sum
     * @param matrix_b second boolean matrix to sum
     * @return sum of matrix
     */
    public static BooleanMatrix add(BooleanMatrix matrix_a, BooleanMatrix matrix_b) {
        if(matrix_a.getN() != matrix_b.getN() || matrix_a.getM() != matrix_b.getM())
            throw new InvalidParameterException("Wrong matrix");

        int n = matrix_a.getN();
        int m = matrix_a.getM();

        boolean[][] result = new boolean[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                result[i][j] = matrix_a.getMatrix()[i][j] || matrix_b.getMatrix()[i][j];
            }
        }
        return new BooleanMatrix(result, n, m);
    }

    /**
     * Function of multiplying two boolean matrix.
     * @param matrix_a first boolean matrix to multiply
     * @param matrix_b second boolean matrix to multiply
     * @return result of multiplying as new object of Model.BooleanMatrix class
     */
    public static BooleanMatrix multiply(BooleanMatrix matrix_a, BooleanMatrix matrix_b) {
        if(matrix_b.getN() != matrix_a.getM() || matrix_b.getM() != matrix_a.getN())
            throw new InvalidParameterException("Wrong matrix");
        int n = matrix_a.getN();
        int m = matrix_a.getM();

        boolean[][] matrix_buff = new boolean[n][n];
        for (int i=0; i<n; ++i)
            for (int j=0; j<n; ++j)
                for (int k=0; k<m; ++k)
                    matrix_buff[i][j] = matrix_buff[i][j] ||
                            (matrix_a.getMatrix()[i][k] && matrix_b.getMatrix()[k][j]);
        return new BooleanMatrix(matrix_buff, n, n);
    }

}
