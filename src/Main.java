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


    // get input location to fill from user and validate.

    public static int[] getUserLoc(){
        int [] userloc = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter row number[1 to 3]: ");
        int row = scanner.nextInt();
        while (row<1 | row>3){
            System.out.println("Row must be in range of 1 to 3, please re-enter");
            row = scanner.nextInt();
        }
        System.out.println("please enter column number[1 to 3]: ");
        int col = scanner.nextInt();
        while (col<1 | col>3){
            System.out.println("Column must be in range of 1 to 3, please re-enter");
            col = scanner.nextInt();
        }
        userloc[0] = row;
        userloc[1] = col;
        return userloc;
    }




    // Check if matrix is full
    public static boolean isMatrixFull(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                if (cell == '_') {
                    return false;
                }
            }
        }
        return true;
    }





    // Main program
    public static void main(String[] args) {
        char[][] matrix = createMatrix(3);
        printMatrix(matrix);
        int[] user1loc = getUserLoc();
        System.out.println(Arrays.toString(user1loc));



    }
}