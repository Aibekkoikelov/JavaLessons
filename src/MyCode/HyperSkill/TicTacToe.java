package MyCode.HyperSkill;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean threeXs = false;
        boolean threeOs = false;
        boolean fieldFull = false;

        char[] line = new char[9];
        Arrays.fill(line, ' ');
        char[][] field = buildField(line);
        char move = 'X';


        printField(field);

        while (!fieldFull) {
            playerMove(sc, field);
            validateField(field);
//            buildField(line);
            printField(field);
        }

        GameStatement(threeXs, threeOs, fieldFull);
    }

    private static char[][] buildField(char[] line) {
        //todo convert 1d array to 2d
        char field[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = line[3 * i + j];
            }
        }
        return field;
    }

    private static boolean validateField(char[][] field) {
        //todo check that field is correct
        int countX = 0;
        int countO = 0;
        boolean fieldfull = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X') {
                    countX++;
                } else if (field[i][j] == 'O') {
                    countO++;
                }
            }
        }
        if (countO + countX == 9) {
            fieldfull = true;
        }
        return fieldfull;
    }


    private static void playerMove(Scanner sc, char[][] field) {
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
            field[3 - y][x - 1] = 'X';
            break;
        }
    }

    private static boolean GameStatement(boolean threeXs, boolean threeOs, boolean fieldFull) {
        if (threeOs) {
            System.out.println("O wins");
            return true;
        } else if (threeXs) {
            System.out.println("X wins");
            return true;
        } else if (fieldFull && (!threeOs || !threeXs)) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

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