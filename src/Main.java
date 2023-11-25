import java.util.Arrays;
import java.util.Scanner;


public class Main {

    // Create empty matrix of chars with given size
    public static char[][] createMatrix(int size) {
        char[][] matrix = new char[size][size];
        for (char[] row : matrix) {
            Arrays.fill(row, '_');
        }
        return matrix;
    }


    // Print matrix
    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


    public static void main(String[] args) {
        char[][] matrix = createMatrix(3);
        printMatrix(matrix);

    }
}