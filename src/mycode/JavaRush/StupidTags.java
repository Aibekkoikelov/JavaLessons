package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
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


    public static List<Tag> findTags(String line, String tag) {

        Pattern pattern = Pattern.compile("</?" + tag + ".*?>");
        Matcher matcher = pattern.matcher(line);
        List<Tag> list = new ArrayList<>();

        while (matcher.find()) {
            Tag fag = new Tag(matcher.start(), matcher.end(), line);
            System.out.println(fag.value);
            list.add(fag);
        }
        return list;

    }

    public static String findFirstTag(String line, List<Tag> tags) {
        Stack<Tag> stack = new Stack<>();
        for (Tag t : tags) {
            if (!t.isClosing()) {
                stack.push(t);
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                } else {
                    System.out.println(line.substring(stack.pop(), t));
                }
            }
        }

    }

    static class Tag {

        private int start;
        private int end;

        String value;

        public Tag(int start, int end, String line) {
            this.start = start;
            this.end = end;
            this.value = line.substring(start, end);
        }

        public boolean isClosing() {
            return value.startsWith("</");
        }

    }

}


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