package mycode.JavaRush;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/*
Прайсы 2
*/

public class Prices2 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        if (args.length > 0) {
            changeFile(args, file);
        }
    }

    private static String getLine(String[] args) throws IOException {
        String line = "";

        line += formatString(args[1], 8);
        line += formatString(args[2], 30);
        line += formatString(args[3], 8);
        line += formatString(args[4], 4);

        return line;
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

    private static void changeFile(String[] args, String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        int index = 0;
        for (String s : lines) {
            if (s.startsWith(args[1])) {
                index = lines.indexOf(s);
            }
        }
        if (args[0].equals("-u")) {
            Collections.replaceAll(lines, lines.get(index), getLine(args));
        } else {
            lines.remove(index);
        }
        updateFile(lines, fileName);
    }

    public static void updateFile(List<String> list, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (int i = 0; i < list.size() - 1; i++) {
            bw.write(list.get(i));
            bw.newLine();
        }
        bw.write(list.get(list.size() - 1));
        bw.close();
    }
}

