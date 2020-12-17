package mycode.hyperskill.inputstreams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReverseText {
    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        reader.close();
//        System.out.println(new StringBuilder(reader.readLine()).reverse());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line.isBlank()) {
            System.out.println("0");
        } else {
            String[] lineArray = line.trim().split("\\s+");
            System.out.println(lineArray.length);
        }
        reader.close();
    }
}
