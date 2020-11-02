package mycode.JavaRush;

import java.io.*;
import java.util.ArrayList;
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
    }

    private static void addData(String[] args, String fileName) throws IOException {
        int id = getId(fileName) + 1;
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
        bw.write("\n");
        for (String s : list) {
            bw.write(s);
        }
        bw.close();
    }

    private static String formatString(String str, int len) {
        if (str.length() > len) {
            str = str.substring(0, Math.min(str.length(), len));
            return str;
        } else if (str.length() < len) {
            str = String.format("%-" + len + "s", str);
            return str;
        }
        return str;
    }

    private static int getId(String fileName) throws IOException {

        FileInputStream inputStream = new FileInputStream(fileName);
        if (inputStream.available() == 0) {
            return 0;
        }
        return findMaxId(fileName);
    }
    private static int findMaxId(String fileName) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        int id = 0;
        int maxID = 0;
        String idString = "";
        String line;
        while ((line = input.readLine()) != null) {
            try {
                idString = line.substring(0, 8).trim();
                id = Integer.parseInt(idString);
                if (id > maxID) {
                    maxID = id;
                }
            } catch (NumberFormatException e) {
//            e.printStackTrace();
            }
        }
        return maxID;
    }

}