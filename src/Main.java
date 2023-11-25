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

    public static int[] getUserLoc() {
        int[] userloc = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter row number[0 to 2]: ");
        int row = scanner.nextInt();
        while (row < 0 | row > 2) {
            System.out.println("Row must be in range of 0 to 2, please re-enter");
            row = scanner.nextInt();
        }
        System.out.println("please enter column number[0 to 2]: ");
        int col = scanner.nextInt();
        while (col < 0 | col > 2) {
            System.out.println("Column must be in range of 0 to 2, please re-enter");
            col = scanner.nextInt();
        }
        userloc[0] = row;
        userloc[1] = col;
        return userloc;
    }


    // check if matrix location is empty
    public static boolean isLocEmpty(int[] loc, char[][] matrix) {
        return ((matrix[loc[0]][loc[1]]) == '_');
    }


    // User X,O to choose location to fill +validate
    public static void setXO(char XO, char[][] matrix) {
        System.out.println("User " + XO + " - it is your turn");
        int[] loc = getUserLoc();
        while (!isLocEmpty(loc, matrix)) {
            System.out.println("location ia not empty, please try again");
            loc = getUserLoc();
        }
        matrix[loc[0]][loc[1]] = XO;
        printMatrix(matrix);

    }


    // check if user X or O has met win condition - return boolean True or False
    public static boolean checkWinXO(char XO, char[][] matrix) {
        return ((matrix[0][0] == XO) && (matrix[0][1] == XO) && (matrix[0][2] == XO)) |
                ((matrix[1][0] == XO) && (matrix[1][1] == XO) && (matrix[1][2] == XO)) |
                ((matrix[2][0] == XO) && (matrix[2][1] == XO) && (matrix[2][2] == XO)) |
                ((matrix[0][0] == XO) && (matrix[1][0] == XO) && (matrix[2][0] == XO)) |
                ((matrix[0][1] == XO) && (matrix[1][1] == XO) && (matrix[2][1] == XO)) |
                ((matrix[0][2] == XO) && (matrix[1][2] == XO) && (matrix[2][2] == XO)) |
                ((matrix[0][0] == XO) && (matrix[1][1] == XO) && (matrix[2][2] == XO)) |
                ((matrix[0][2] == XO) && (matrix[1][1] == XO) && (matrix[2][0] == XO));

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
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;
        while (runAgain) {
            char[][] matrix = createMatrix(3);
            System.out.println("Welcome to the TicTacToe game, Let's get started");
            printMatrix(matrix);
            while (!isMatrixFull(matrix)) {
                setXO('X', matrix);
                if (checkWinXO('X', matrix)) {
                    System.out.println("X - you are the winner !!!");
                    break;
                }
                if (isMatrixFull(matrix)) {
                    System.out.println("Matrix is full - No winner, we have a tie.");
                    break;
                }
                setXO('O', matrix);
                if (checkWinXO('O', matrix)) {
                    System.out.println("O - you are the winner !!!");
                    break;
                }
                if (isMatrixFull(matrix)) {
                    System.out.println("Matrix is full - No winner, we have a tie.");
                    break;
                }
            }
            System.out.println("Do you want to play again[Y/N]?");
            char c = scanner.next().charAt(0);
            if (c == 'N' | c == 'n') {
                runAgain = false;
            }
        }
    }
}