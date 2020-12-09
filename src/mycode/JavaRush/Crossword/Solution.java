package mycode.JavaRush.Crossword;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        int[][] crossword = new int[][]{
//                {'a', 'd', 's', 'r', 'e', 's'},
//                {'s', 'h', 'a', 'a', 'a', 'o'},
//                {'l', 'o', 'm', 'm', 'a', 'v'},
//                {'e', 'm', 'e', 'h', 's', 'h'},
//                {'p', 'e', 'm', 'a', 's', 'e'}
//        };
        List<Word> list = detectAllWords(crossword, "home", "same");
        for (Word w : list) {
            System.out.println(w);
        }


        /*

Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {

                for (String word : findLetter((char) crossword[i][j], words)) {
                    Word woord;
                    woord = plusHorizontal(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = minusHorizontal(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = plusVertical(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = minusVertical(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = diagonalTopRight(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = diagonalTopLeft(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = diagonalBottomRight(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                    woord = diagonalBottomLeft(i, j, word.length(), crossword);
                    if (woord != null && word.equals(woord.text)) {
                        list.add(woord);
                    }
                }
            }
        }
        return list;
    }

    public static List<String> findLetter(char firstChar, String[] words) {
        List<String> list = new ArrayList<>();
        for (int k = 0; k < words.length; k++) {
            if (words[k].charAt(0) == firstChar) {
                list.add(words[k]);

            }
        }
        return list;
    }

    public static Word plusHorizontal(int i, int j, int wordLength, int[][] crossword) {
        if (j + wordLength - 1 < crossword[i].length) {
            String word1 = "";
            for (int p = j; p < (j + wordLength); p++) {
                word1 += (char) crossword[i][p];
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i, j + wordLength - 1);
            return word;
        } else {
            return null;
        }
    }

    public static Word minusHorizontal(int i, int j, int wordLength, int[][] crossword) {
        if (j - wordLength + 1 >= 0) {
            String word1 = "";
            for (int p = i; p > (j - wordLength); p--) {
                word1 += (char) crossword[i][p];
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i, j - wordLength + 1);
            return word;
        } else {
            return null;
        }
    }

    public static Word plusVertical(int i, int j, int wordLength, int[][] crossword) {
        if (i - wordLength + 1 >= 0) {
            String word1 = "";
            for (int p = i; p > (i - wordLength); p--) {
                word1 += (char) crossword[p][j];
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i - wordLength + 1, j);
            return word;
        } else {
            return null;
        }
    }

    public static Word minusVertical(int i, int j, int wordLength, int[][] crossword) {
        if (i + wordLength - 1 < crossword.length) {
            String word1 = "";
            for (int p = i; p < (i + wordLength); p++) {
                word1 += (char) crossword[p][j];
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i + wordLength - 1, j);
            return word;
        } else {
            return null;
        }
    }

    public static Word diagonalTopRight(int i, int j, int wordLength, int[][] crossword) {
        if (i + wordLength - 1 < crossword.length && j + wordLength - 1 < crossword[i].length) {
            String word1 = "";
            for (int p = i; p < (i + wordLength); p++) {
                for (int l = j; l < (j + wordLength); l++) {
                    word1 += (char) crossword[p][l];
                }
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i + wordLength - 1, j + wordLength - 1);
            return word;
        } else {
            return null;
        }
    }

    public static Word diagonalTopLeft(int i, int j, int wordLength, int[][] crossword) {
        if (i + wordLength - 1 < crossword.length && j - wordLength >= 0) {
            String word1 = "";
            for (int p = i; p < (i + wordLength); p++) {
                for (int l = j; l > (j - wordLength); l--) {
                    word1 += (char) crossword[p][l];
                }
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i + wordLength - 1, j - wordLength + 1);
            return word;
        } else {
            return null;
        }
    }

    public static Word diagonalBottomRight(int i, int j, int wordLength, int[][] crossword) {
        if (i - wordLength >= 0 && j + wordLength - 1 < crossword[i].length) {
            String word1 = "";
            for (int p = i; p > (i - wordLength); p--) {
                for (int l = j; l < (j + wordLength); l++) {
                    word1 += (char) crossword[p][l];
                }
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i - wordLength + 1, j + wordLength - 1);
            return word;
        } else {
            return null;
        }
    }

    public static Word diagonalBottomLeft(int i, int j, int wordLength, int[][] crossword) {
        if (i - wordLength >= 0 && j - wordLength >= 0) {
            String word1 = "";
            for (int p = i; p > (i - wordLength); p--) {
                for (int l = j; l < (j - wordLength); l--) {
                    word1 += (char) crossword[p][l];
                }
            }
            Word word;
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i - wordLength + 1, j - wordLength + 1);
            return word;
        } else {
            return null;
        }
    }

    public static class Word {

        public static List<Word> wordList = new ArrayList<>();

        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

//        public Word(String text, int startX, int startY, int endX, int endY) {
//            this.text = text;
//            this.startX = startX;
//            this.startY = startY;
//            this.endX = endX;
//            this.endY = endY;
//        }

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
