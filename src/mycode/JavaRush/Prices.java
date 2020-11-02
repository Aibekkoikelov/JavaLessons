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

//        String str = "1";
//        int len = 8;
//        System.out.println(String.format("%-" + len + "s", str));

        switch (args[0]) {
            case "-c":
                addData(args, file);
            default:
                break;
        }
    }

    public static void addData(String[] args, String fileName) throws IOException {
        int id = findId(fileName) + 1;
//        String strID = String.format("%-8s", id);

        FileWriter fileWritter = new FileWriter(fileName,true);
        BufferedWriter bw = new BufferedWriter(fileWritter);
        List<String> list = new ArrayList<>();
        list.add(formatString(Integer.toString(id), 8));
        list.add(formatString(args[1], 30));
        list.add(formatString(args[2], 8));
        list.add(formatString(args[3], 4));

        bw.write("\n");
        for (String s : list) {
            bw.write(s);
        }
        bw.close();
    }

    public static String formatString(String str, int len) {
        if (str.length() > len) {
            str = str.substring(0, Math.min(str.length(), len));
            return str;
        } else if (str.length() < len) {
            str = String.format("%-" + len + "s", str);
            return str;
        }
        return str;
    }

    public static int findId(String fileName) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        FileInputStream inputStream = new FileInputStream(fileName);
        if (inputStream.available() == 0) {
            return 0;
        }
        String idString = "";
        String last = "";
        String line;
        int id = 0;
        while ((line = input.readLine()) != null) {
            last = line;
        }

        try {
            idString = last.substring(0, 8).trim();
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return id;
    }
}