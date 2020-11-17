package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StupidTags {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        String line = fileToLine(file);
        System.out.println(line);
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
        Pattern patternOT = Pattern.compile("<" + tag + ".*>");
        Pattern patternCT = Pattern.compile("</" + tag + ">");

        Matcher matcherOT = patternOT.matcher(line);
        Matcher matcherCT = patternCT.matcher(line);

        Stack<Integer> stackOpenTag = new Stack<>();
        Stack<Integer> stackCloseTag = new Stack<>();

        while (true) {
            if (line.contains(patternOT.toString())) {
                stackOpenTag.push(matcherOT.start());
            }
            if (line.contains(patternCT.toString())) {
                stackCloseTag.push(matcherCT.end());
                if (stackOpenTag.size() == stackCloseTag.size()) {
                    break;
                }
            }
        }
        System.out.println(line.substring(stackOpenTag.pop(), stackCloseTag.pop()));
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
