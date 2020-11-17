package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        Pattern pattern = Pattern.compile("</?" + tag + ".*?>");
//        Pattern patternOT = Pattern.compile("<" + tag + "(.*?)>");
//        Pattern patternCT = Pattern.compile("</" + tag + ">");
//
//        Matcher matcherOT = patternOT.matcher(line);
//        Matcher matcherCT = patternCT.matcher(line);

//        Stack<Integer> stackOpenTag = new Stack<>();
//        Stack<Integer> stackCloseTag = new Stack<>();
//        List<Integer> listOne = new ArrayList<>();
//        List<Integer> listTwo = new ArrayList<>();

//        while (matcherOT.find()) {
//            stackOpenTag.push(matcherOT.start());
//            listOne.add(matcherOT.start());
//            System.out.println("found open tag");
//        }

//        while (matcherCT.find()) {
//            stackCloseTag.push(matcherCT.end());
//            listTwo.add(matcherCT.end());
//            System.out.println("found closed tag");
//        }


//        System.out.println(listOne.toString());
//        System.out.println(listTwo.toString());
//        System.out.println(stackOpenTag.toString());
//        System.out.println(stackCloseTag.toString());

//        System.out.println(line.substring(listOne.get(0), listTwo.get(1)));
//        System.out.println(line.substring(listOne.get(1), listTwo.get(0)));
//        System.out.println(line.substring(listOne.get(2), listTwo.get(2)));
//        System.out.println(line.substring(listOne.get(3), listTwo.get(3)));
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

        static class Tag {
        private int start;
        private int end;

        public Tag(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public List<Tag> findTags(String line, String tag) {

            List<Tag> list = new ArrayList<>();
            return list;
        }

        public String tag(String line) {
            return line.substring(start, end);
        }

    }

}
