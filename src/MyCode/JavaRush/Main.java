package MyCode.JavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        double m = Double.parseDouble(reader.readLine());
//
//        double mt = m%5;
//        if (mt >= 3 && mt < 4) {
//            System.out.println("yellow");
//        }
//        else if (mt >= 4 && mt < 5) {
//            System.out.println("red");
//        }
//        else System.out.println("green");

        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());

        if (n1 == n2 && n2 == n3)
            System.out.println(n1+" "+n2+" "+n3);
        else if (n1 == n2)
            System.out.println(n1+" "+n2);
        else if (n1 == n3)
            System.out.println(n1+" "+n3);
        else if (n2 == n3)
            System.out.println(n2+" "+n3);
        else System.out.println("");

    }
}
