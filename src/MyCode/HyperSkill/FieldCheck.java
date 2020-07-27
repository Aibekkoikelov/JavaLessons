package MyCode.HyperSkill;

import java.util.Scanner;

public class FieldCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        for (int i = 0; i < 8; i++) {
            if (ch[line[i][0]] + ch[line[i][1]] + ch[line[i][2]] == 264) {
                threeXs = true;
            } if (ch[line[i][0]] + ch[line[i][1]] + ch[line[i][2]] == 237) {
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




//        if (ch[0] + ch[1] + ch[2] == 264 ||
//                ch[3] + ch[4] + ch[5] == 264 ||
//                ch[6] + ch[7] + ch[8] == 264 ||
//                ch[0] + ch[3] + ch[6] == 264 ||
//                ch[1] + ch[4] + ch[7] == 264 ||
//                ch[2] + ch[5] + ch[8] == 264 ||
//                ch[0] + ch[4] + ch[8] == 264 ||
//                ch[6] + ch[4] + ch[2] == 264) {
//            threeXs = true;
//        }
//        if (ch[0] + ch[1] + ch[2] == 237 ||
//                ch[3] + ch[4] + ch[5] == 237 ||
//                ch[6] + ch[7] + ch[8] == 237 ||
//                ch[0] + ch[3] + ch[6] == 237 ||
//                ch[1] + ch[4] + ch[7] == 237 ||
//                ch[2] + ch[5] + ch[8] == 237 ||
//                ch[0] + ch[4] + ch[8] == 237 ||
//                ch[6] + ch[4] + ch[2] == 237) {
//            threeOs = true;
//        }