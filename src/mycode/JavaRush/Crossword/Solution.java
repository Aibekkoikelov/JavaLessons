package mycode.JavaRush.Crossword;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
//        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//        };
        int[][] crossword = new int[][]{
                {'a', 'd', 's', 'r', 'l', 'k'},
                {'s', 'a', 'a', 'a', 'e', 'o'},
                {'l', 'n', 'm', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'e', 'r', 'h'},
                {'p', 'o', 's', 'a', 'e', 'e'}
        };
        detectAllWords(crossword, "home", "same");

        /*

Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        List<String> listOfWords = new ArrayList<>();

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                listOfWords = findLetter((char) crossword[i][j], words);
                findAllWords(listOfWords, crossword, i, j);
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

    public static List<Word> findAllWords(List<String> list, int[][] crossword, int i, int j) {
        List<Word> listOfAllWords = new ArrayList<>();
        Word woord;
        for (String word : list) {
             woord = plusHorizontal(i, j, word.length(), crossword);
            if (woord != null && word.equals(woord.text))
            {
                listOfAllWords.add(woord);
            }
            plusHorizontal(i, j, word.length(), crossword);
            minusHorizontal(i, j, word.length(), crossword);
            plusVertical(i, j, word.length(), crossword);
            minusVertical(i, j, word.length(), crossword);
        }
        return listOfAllWords;
    }


    public static Word plusHorizontal(int i, int j, int wordLength, int[][] crossword) {
        Word word;
        if (i + wordLength < crossword.length) {
            String word1 = "";
            for (int p = i; p < (i + wordLength); p++) {
                word1 += (char) crossword[p][j];
            }
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i + wordLength, j);
            return word;
        } else {
            return null;
        }
    }

    public static Word minusHorizontal(int i, int j, int wordLength, int[][] crossword) {
        Word word;
        if (i - wordLength >= 0) {
            String word1 = "";
            for (int p = i; p > (i - wordLength); p--) {
                word1 += (char) crossword[p][j];
            }
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i - wordLength, j);
            return word;
        } else {
            return null;
        }
    }

    public static Word plusVertical(int i, int j, int wordLength, int[][] crossword) {
        Word word;
        if (j + wordLength < crossword[i].length) {
            String word1 = "";
            for (int p = j; p < (j + wordLength); p++) {
                word1 += (char) crossword[i][p];
            }
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i, j + wordLength);
            return word;
        } else {
            return null;
        }
    }

    public static Word minusVertical(int i, int j, int wordLength, int[][] crossword) {
        Word word;
        if (j - wordLength <= 0) {
            String word1 = "";
            for (int p = j; p > (j - wordLength); p--) {
                word1 += (char) crossword[i][p];
            }
            word = new Word(word1);
            word.setStartPoint(i, j);
            word.setEndPoint(i, j - wordLength);
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
