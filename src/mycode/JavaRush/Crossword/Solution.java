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
        List<Word> list = detectAllWords(crossword, "home", "same");
        for (Word words : list) {
            System.out.println(words.toString());
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
            String word = "";
            for (int j = 0; j < crossword[i].length; j++) {
                word += (char) crossword[i][j];
            }
            for (int k = 0; k < words.length; k++) {
                if (word.contains(words[k])) {
                    int startX = word.indexOf(words[k]);
                    int startY = i;
                    int endX = word.indexOf(words[k]) + words[k].length() - 1;
                    int endY = i;
                    list.add(new Word(words[k], startX, startY, endX, endY));
                }
            }
        }

        for (int i = 0; i < crossword.length; i++) {
            String word = "";
            for (int j = crossword[i].length - 1; j >= 0; j--) {
                word += (char) crossword[i][j];
            }
            for (int k = 0; k < words.length; k++) {
                if (word.contains(words[k])) {
                    int startX = word.indexOf(words[k]);
                    int startY = i;
                    int endX = word.indexOf(words[k]) + words[k].length() - 1;
                    int endY = i;
                    list.add(new Word(words[k], startX, startY, endX, endY));
                }
            }
        }

        for (int i = 0; i < crossword.length; i++) {
            int p = i;
            String word = "";
            for (int j = 0; j < crossword[i].length && p < crossword.length;  j++, p++) {
                word += (char) crossword[p][j];
            }
            for (int k = 0; k < words.length; k++) {
                if (word.contains(words[k])) {
                    int startX = word.indexOf(words[k]);
                    int startY = i;
                    int endX = word.indexOf(words[k]) + words[k].length() - 1;
                    int endY = i;
                    list.add(new Word(words[k], startX, startY, endX, endY));
                }
            }
        }




//        list.add(new Word ("same", 5, 3, 2, 0));

        return list;
    }

    public static class Word {

        public static List<Word> wordList = new ArrayList<>();

        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text, int startX, int startY, int endX, int endY) {
            this.text = text;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

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
