package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StupidTags {
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
        Pattern patternOT = Pattern.compile("<" + tag + "(.*?)>");
        Pattern patternCT = Pattern.compile("</" + tag + ">");

        Matcher matcherOT = patternOT.matcher(line);
        Matcher matcherCT = patternCT.matcher(line);

        Stack<Integer> stackOpenTag = new Stack<>();
        Stack<Integer> stackCloseTag = new Stack<>();

        while (true) {
            if (matcherOT.find()) {
                stackOpenTag.push(matcherOT.start());
                System.out.println("found open tag");
            }
            if (matcherCT.find()) {
                stackCloseTag.push(matcherCT.end());
                System.out.println("found closed tag");
//                if (stackOpenTag.size() == stackCloseTag.size()) {
//                    break;
//                }
            }
            if (stackCloseTag.size() == 4) {
                break;
            }
        }
        System.out.println(stackOpenTag.toString());
    }


    public static void printTags(String line, String tag) {
        Pattern pattern = Pattern.compile("<" + tag + "([\\s\\S]*)/" + tag + ">");
//        Pattern pattern = Pattern.compile("<span>([\\s\\S]*)</span>");

//        Pattern pattern = Pattern.compile("(\\<(/?[^\\>]+)\\>)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group(0));

        }
    }
}
