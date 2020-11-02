package mycode.JavaRush;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    /*
    Прайсы
    */

public class Prices {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        if (args.length > 0) {
            switch (args[0]) {
                case "-c":
                    addData(args, file);
                default:
                    break;
            }
        }
        reader.close();
    }

    private static void addData(String[] args, String fileName) throws IOException {
        int id = getMaxId(fileName) + 1;
        List<String> list = new ArrayList<>();
        list.add(formatString(Integer.toString(id), 8));
        list.add(formatString(args[1], 30));
        list.add(formatString(args[2], 8));
        list.add(formatString(args[3], 4));

        writeToFile(list, fileName);
    }

    private static void writeToFile(List<String> list, String fileName) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.newLine();
        for (String s : list) {
            bw.write(s);
        }
        bw.close();
    }

    private static String formatString(String str, int len) {
        int min = Math.min(str.length(), len);
        if (str.length() > len) {
            return str.substring(0, min);
        } else if (str.length() < len) {
            return String.format("%-" + len + "s", str);
        } else {
            return str;
        }
    }

    private static int getMaxId(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        List<Integer> ids = convert(lines);
        return Collections.max(ids);
    }

    private static List<Integer> convert(List<String> lines) {
        List<Integer> listOfInts = new ArrayList<>();
        for (String s : lines) {
            String idString = s.substring(0, 8).trim();
            listOfInts.add(Integer.parseInt(idString));
        }
        return listOfInts;
    }
}