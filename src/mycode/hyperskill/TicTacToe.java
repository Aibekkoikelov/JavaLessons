package mycode.hyperskill;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

//    private static final int[][] line = new int[][]{
//            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
//            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
//            {0, 4, 8}, {6, 4, 2},
//    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        char[] line = new char[9];
//        Arrays.fill(line, ' ');
//        char[][] field = buildField(line);
        char[][] field = new char [3][3];
        Arrays.stream(field).forEach(a -> Arrays.fill(a, ' '));
//        Arrays.fill(field,' ');
        char move = 'X';

        printField(field);

        while (!fullField(field)) {
            if (move == 'X') {
                playerMove(sc, field, move);
                move = 'O';
            } else {
                playerMove(sc, field, move);
                move = 'X';
            }
            printField(field);
//            gameOver(field);
            if (gameOver(field)) {
                break;
            }
        }

//        GameStatement(threeXs, threeOs, fieldFull);
    }

//    private static char[][] buildField(char[] line) {
//        //todo convert 1d array to 2d
//        char field[][] = new char[3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                field[i][j] = line[3 * i + j];
//            }
//        }
//        return field;
//    }

    private static boolean fullField (char[][] field) {
        //todo check that field is correct
        int count = 0;

        boolean fieldfull = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X' || field[i][j] == 'O') {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    private static boolean gameOver(char[][]field) {
        //todo
        for (int i = 0; i < 3; i++) {
            if (field[i][0] + field[i][1] + field[i][2] == 264 ||
                    field[0][i] + field[1][i] + field[2][i] == 264) {
//                printField(field);
                System.out.println("X wins");
                return true;
            }
            if (field[i][0] + field[i][1] + field[i][2] == 237) {
//                printField(field);
                System.out.println("O wins");
                return true;
            }
        }
        if (field[0][0] + field[1][1] + field[2][2] == 264 ||
                field[0][2] + field[1][1] + field[2][0] == 264) {
            System.out.println("X wins");
            return true;
        }
        if (field[0][0] + field[1][1] + field[2][2] == 237 ||
                field[0][2] + field[1][1] + field[2][0] == 237) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    private static void playerMove(Scanner sc, char[][] field,char move) {
        //todo input coordinates
        System.out.println("Enter the coordinates:");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.println("You should enter numbers!");
            }
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x > 3 || x < 1 || y > 3 || y< 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (field[3 - y][x - 1] == 'X' ||
                    field[3 - y][x - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            field[3 - y][x - 1] = move;
            break;
        }
    }

//    private static boolean GameStatement(boolean threeXs, boolean threeOs, boolean fieldFull) {
//        if (threeOs) {
//            System.out.println("O wins");
//            return true;
//        } else if (threeXs) {
//            System.out.println("X wins");
//            return true;
//        } else if (fieldFull && (!threeOs || !threeXs)) {
//            System.out.println("Draw");
//            return true;
//        }
//        return false;
//    }

    private static void printField(char[][] field) {
        //todo output field state
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}