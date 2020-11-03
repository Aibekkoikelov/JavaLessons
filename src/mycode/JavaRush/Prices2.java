package mycode.JavaRush;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        String oldString = "";
        int index = 0;
        for (String s : lines) {
            if (s.startsWith(args[1])) {
                oldString = s;
                index = lines.indexOf(s);
            }
        }
        if (args[0].equals("-u")) {
            Collections.replaceAll(lines, lines.get(index), getLine(args));
        } else {
            lines.remove(index);
            }
        clearFile(fileName);
        updateFile(lines, fileName);
        }

//        public static void replaceLine (String[] args, String oldString, String fileName) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        String line = reader.readLine();
//        String oldContent = "";
//        while (line != null) {
//            oldContent = oldContent + line + System.lineSeparator();
//            line = reader.readLine();
//        }
//
//        String newString = getLine(args);
//        String newContent = oldContent.replaceAll(oldString, newString);
//        FileWriter writer = new FileWriter(fileName);
//        writer.write(newContent);
//        reader.close();
//        writer.close();
//    }

    public  static void clearFile (String fileName) throws FileNotFoundException {
//        try {
//            FileWriter fstream1 = new FileWriter(fileName);// конструктор с одним параметром - для перезаписи
//            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
//            out1.write(""); // очищаем, перезаписав поверх пустую строку
//            out1.close(); // закрываем
//        } catch (Exception e)
//        {System.err.println("Error in file cleaning: " + e.getMessage());}
        new PrintWriter(fileName).close();
    }

    public static void updateFile (List<String> list, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (String s : list) {
            bw.newLine();
            bw.write(s);
        }
        bw.close();
    }
}

