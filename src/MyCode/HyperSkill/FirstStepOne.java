package MyCode.HyperSkill;

import java.awt.*;
import java.util.*;

public class FirstStepOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // added sout for cells
        System.out.println("Enter cells:");

        String str = sc.next();
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        System.out.println("---------");
        System.out.println("| " + ch[0] + " " + ch[1] + " " + ch[2] + " |");
        System.out.println("| " + ch[3] + " " + ch[4] + " " + ch[5] + " |");
        System.out.println("| " + ch[6] + " " + ch[7] + " " + ch[8] + " |");
        System.out.println("---------");

        boolean threeXs = false;
        boolean threeOs = false;

        int[][] line = new int[][]{
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {6, 4, 2},
        };

        // added sout for coords
        System.out.println("Enter the coordinates:");
        while (sc.hasNext()) {
            char x = sc.next().charAt(0);
            char y = sc.next().charAt(0);
            if (!Character.isDigit(x) || !Character.isDigit(y)) {
                System.out.println("You should enter numbers!");
            } else if (Character.getNumericValue(x) > 3 || Character.getNumericValue(x) < 1 ||
                    Character.getNumericValue(y) > 3 || Character.getNumericValue(y) < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
            else if  (ch[line[Character.getNumericValue(x)-1][Character.getNumericValue(y)-1]] == 'X'|| ch[line[Character.getNumericValue(x)-1][Character.getNumericValue(y)-1]] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            }
            else break;
        }



//        int[] input = inputDigit();

        for (int i = 0; i < 8; i++) {
            if (ch[line[i][0]] + ch[line[i][1]] + ch[line[i][2]] == 264) {
                threeXs = true;
            }
            if (ch[line[i][0]] + ch[line[i][1]] + ch[line[i][2]] == 237) {
                threeOs = true;
            }
        }

        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 9; i++) {
            if (ch[i] == 'X') {
                countX++;
            } else if (ch[i] == 'O') {
                countO++;
            }
        }

        boolean impossible = false;
        boolean fieldFull = false;

        if (Math.abs(countX - countO) > 1) {
            impossible = true;
        }

        if (countO + countX == 9) {
            fieldFull = true;
        }

        GameResult(threeXs, threeOs, impossible, fieldFull);
    }

//    private static int[] inputDigit() {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            if (sc.hasNext()) {
//                String in = sc.next();
//                String[] nums = in.split(" ");
//                int x = Integer.parseInt(nums[0]);
//                int y = Integer.parseInt(nums[1]);
//                if (x > 0  && x < 4 && y > 0 && y < 4) {
//                    return new int[] {x, y};
//                } else {
//                    System.out.println("Coordinates should be from 1 to 3!");
//                }
//            } else if (sc.hasNext()) {
//                System.out.println("You should enter numbers!");
//            }
//        }
//    }

    private static void GameResult(boolean threeXs, boolean threeOs, boolean impossible, boolean fieldFull) {
        if (impossible) {
            System.out.println("Impossible");
        } else if (threeOs && threeXs) {
            System.out.println("Impossible");
        } else if (threeOs) {
            System.out.println("O wins");
        } else if (threeXs) {
            System.out.println("X wins");
        } else if (fieldFull && (!threeOs || !threeXs)) {
            System.out.println("Draw");
        } else if (!fieldFull && (!threeOs || !threeXs)) {
            System.out.println("Game not finished");
        }
    }
}

