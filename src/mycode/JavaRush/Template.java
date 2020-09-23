package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Template {
    public static void main(String[] args) throws Exception {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rdr.readLine());
        int b = Integer.parseInt(rdr.readLine());
        int c = Integer.parseInt(rdr.readLine());
        if (a != b && a != c && b == c) {
            System.out.println("1");
        } else if (a == c && a != b) {
            System.out.println("2");
        } else if (a == b && a != c) {
            System.out.println("3");
        } else if (a != b && b != c) {
        }
    }
}
