package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StupidTags2 {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String line = fileToLine(file);
//        System.out.println(line);
//        printTags(line, tag);
        findTags(line, args[0]);


    }

    public static String fileToLine(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = fileReader.readLine()) != null) {
            sb.append(line);
        }
        fileReader.close();
        return sb.toString();
    }

    public static void findTags(String line, String tag) {
        Pattern pattern = Pattern.compile("</?" + tag + ".*?>");
        Matcher matcher = pattern.matcher(line);

        Queue<Integer> openTag = new LinkedList<>();
        Stack<Integer> closeTag = new Stack<>();

        while (matcher.find()) {
            if (matcher.group(0).contains("<" + tag)) {
                openTag.offer(matcher.start());
            } else if (matcher.group(0).contains("</" + tag)) {
                closeTag.push(matcher.end());
            }
            if (openTag.size() == closeTag.size()) {
                System.out.println(line.substring(openTag.poll(), closeTag.pop()));
            }
        }
    }
}
