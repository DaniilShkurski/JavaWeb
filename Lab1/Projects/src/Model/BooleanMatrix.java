package Model;

import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Class which describes boolean matrix
 * @author Daniil Shkurski
 * @version 1.0.0
 */
public class BooleanMatrix {

    /**
     * amount of rows and columns
     */
    private int n,m;

    /**
     * matrix which store booleans
     */
    private boolean[][] matrix;

    /**
     *
     * @return amount of rows
     */
    public int getN() {
        return n;
    }

    /**
     *
     * @return amount of columns
     */
    public int getM() {
        return m;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    /**
     * Constructor of boolean matrix with random generation
     * @param n amount of rows
     * @param m amount of columns
     */
    public BooleanMatrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new boolean[n][m];
        Random rand = new Random();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                matrix[i][j] = rand.nextInt() % 2 == 0;
            }
        }

    }

    /**
     * Constructor with already generated matrix.
     * @param matrix_buff matrix of booleans
     * @param n amount of rows
     * @param m amount of columns
     */
    public BooleanMatrix(boolean[][] matrix_buff, int n, int m) {
        if(matrix_buff.length != n)
            throw new InvalidParameterException("Wrong parameters in matrix");
        for(int i = 0; i < n; i++) {
            if(matrix_buff[i].length != m)
                throw new InvalidParameterException("Wrong parameters in matrix");
        }

        matrix = matrix_buff;
        this.n = n;
        this.m = m;
    }


    /**
     * Function of boolean matrix inversion.
     * Inverses current matrix and saves the result in it.
     */
    public void inverse() {
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                matrix[i][j] = !matrix[i][j];
            }
        }
    }



    /**
     * Count the number of ones in boolean matrix
     * @return amount of ones
     */
    public int countTrueElements() {
        int counter = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if(matrix[i][j]) counter++;
            }
        }
        return counter;
    }

    /**
     * Print the matrix itself
     */
    public void print() {
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if(matrix[i][j]) System.out.print('1');
                else System.out.print('0');
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    /**
     *
     * @return matrix converted to String format
     */
    public String toString() {
        String res = "";
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if(matrix[i][j]) res += "1";
                else res += "0";
                res += " ";
            }
            res += "\n";
        }

        return res;
    }
}
