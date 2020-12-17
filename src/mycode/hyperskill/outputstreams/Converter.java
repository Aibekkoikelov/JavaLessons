package mycode.hyperskill.outputstreams;

import java.io.CharArrayWriter;
import java.io.IOException;

public class Converter {

    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter out = new CharArrayWriter();
        for (String word : words) {
            out.write(word);
        }
       return out.toCharArray();
    }
}