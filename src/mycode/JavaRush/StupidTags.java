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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        String line = fileToLine(file);
        List<Tag> list = findTags(line, args[0]);
        List<TagValue> taglist = findFirstTag(line, list);
        Collections.sort(taglist);
        for (TagValue t : taglist) {
            System.out.println(t.value);
        }
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
//            System.out.println(fag.value);
            list.add(fag);
        }
        return list;
    }


    public static List<TagValue> findFirstTag(String line, List<Tag> tags) {
        Stack<Tag> stack = new Stack<>();
        List<TagValue> values = new ArrayList<>();
        for (Tag t : tags) {
            if (!t.isClosing()) {
                stack.push(t);
            } else {
                Tag start = stack.pop();
                String value = line.substring(start.start, t.end);
                values.add(new TagValue(start.start, value));
            }
        }
        return values;
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

    static class TagValue implements Comparable<TagValue>{
        private int start;
        private String value;

        public TagValue(int start, String value) {
            this.start = start;
            this.value = value;
        }


        @Override
        public int compareTo(TagValue o) {
           return Integer.compare(start, o.start);
        }
    }
}