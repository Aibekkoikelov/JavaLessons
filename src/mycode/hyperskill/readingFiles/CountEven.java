package mycode.hyperskill.readingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountEven {
    public static void main(String[] args) {
        int number = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("dataset5.txt"));
            while (scan.hasNextInt()) {
                number = scan.nextInt();
                if (number == 0) {
                    break;
                } else if (number % 2 == 0 ){
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}