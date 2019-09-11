package Controller;

import Model.BooleanMatrix;
import Model.BooleanMatrixOperations;

/**
 * Controller class with testing BooleanMatrrix
 * @author DaniilShkurski
 * @version 1.0.0
 */
public class Controller {
    /**
     * Method which starts testing
     */
    public static void start() {
        BooleanMatrix matrix1 = new BooleanMatrix(3,3);
        BooleanMatrix matrix2 = new BooleanMatrix(3,3);

        matrix1.print();
        System.out.println();

        matrix2.print();
        System.out.println();

        BooleanMatrixOperations.add(matrix1, matrix2).print();
        System.out.println();

        BooleanMatrixOperations.multiply(matrix1, matrix2).print();
        System.out.println();

        matrix1.inverse();
        System.out.println();

        matrix1.print();
        System.out.println();

        System.out.println(matrix1.countTrueElements());

    }
}
