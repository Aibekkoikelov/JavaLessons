package MyCode.HyperSkill;

import java.util.Scanner;

public class FirstStepTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cells:");

        char[][] field = buildField(sc.next().replaceAll("_", " ").toCharArray());

        printField(field);


//        validateField(field);

        playerMove(sc, field);

        printField(field);
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

//    private static void validateField(char[][] field) {
//        //todo check that field is correct
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (field[i][j] == 'X') {
//                }
//            }
//        }
//    }

    private static void playerMove(Scanner sc, char[][] field) {
        //todo input coordinates
        System.out.println("Enter the coordinates:");
        while (sc.hasNext()) {
            char x = sc.next().charAt(0);
            char y = sc.next().charAt(0);
            if (!Character.isDigit(x) || !Character.isDigit(y)) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int xx = Character.getNumericValue(x);
            int yy = Character.getNumericValue(y);
            if (xx > 3 || xx < 1 || yy > 3 || yy < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (field[3 - yy][xx - 1] == 'X' ||
                    field[3 - yy][xx - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            field[3 - yy][xx - 1] = 'X';
            break;
        }
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
