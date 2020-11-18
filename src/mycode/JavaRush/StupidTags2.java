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

        List<Integer> listOne = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int count = 0;

        while (matcher.find()) {
            if (matcher.group(0).contains("<" + tag)) {
                listOne.add(matcher.start());
                count++;
            } else {
                if (matcher.group(0).contains("</" + tag) && count == 1) {
                    System.out.println(line.substring(listOne.get(0), matcher.end()));
                    listOne.remove(0);
                    count--;
                } else if (count > 1){
                    count--;
                    stack.push(matcher.end());
                }
            }
        }
    }
}
