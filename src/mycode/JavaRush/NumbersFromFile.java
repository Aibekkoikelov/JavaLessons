package mycode.JavaRush;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumbersFromFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        String line = readFile(file1);
//        String newLine = line.replaceAll("^\\d+ | \\d+ | \\d+$" , "");
//        System.out.println(newLine);
        List<String> list = findDigits(line);
        writeFile(list, file2);
    }

    public static String readFile(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = fileReader.readLine()) != null) {
            sb.append(line);
        }
        fileReader.close();
        return sb.toString();
    }

    public static List<String> findDigits(String line) throws IOException {
        List<String> list = new ArrayList<>();
        String[] lineArr = line.split(" ");
        for (String s : lineArr) {
            if (s.matches("\\d+")) {
                list.add(s);
            }
        }
        return list;
    }

    public static void writeFile(List<String> list, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String line = "";
        for (int i = 0; i < list.size() - 1; i++) {
            line += list.get(i) + " ";
        }
        line += list.get(list.size() - 1);
        writer.write(line);
        writer.close();
    }
}
