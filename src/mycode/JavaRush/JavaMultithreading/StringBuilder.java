package mycode.JavaRush.JavaMultithreading;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StringBuilder {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        List<String> words = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(fileName));
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                String[] arrayWords = currentLine.split(" ");
                List<String> temp = Arrays.asList(arrayWords);
                words.addAll(temp);
            }
        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }
        Set<String> set = new HashSet<>();
        for (String str : words) {
            String reverse = new StringBuilder(str).reverse().toString();
            if (set.contains(reverse)) {
                result.add(new Pair(str, reverse));
                set.remove(str);
            } else {
                set.add(str);
            }
        }
        System.out.println(result);
    }


    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

