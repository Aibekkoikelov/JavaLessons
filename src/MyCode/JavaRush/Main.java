package MyCode.JavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double m = Double.parseDouble(reader.readLine());
        double mt = m%5;
        if (mt >= 3 && mt < 4) {
            System.out.println("yellow");
        }
        else if (mt >= 4 && mt < 5) {
            System.out.println("red");
        }
        else System.out.println("green");

    }
}
