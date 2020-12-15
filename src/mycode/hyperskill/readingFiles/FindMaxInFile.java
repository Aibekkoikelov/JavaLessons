package mycode.hyperskill.readingFiles;

import java.io.*;
import java.util.*;

public class FindMaxInFile {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("dataset4.txt"));
            while (scan.hasNextInt()) {
                list.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list.get(0));
    }
}
