package mycode.JavaRush;

import java.io.*;

public class FileToFileReverse {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[inputStream.available()];
        for (int i = buffer.length - 1; i >= 0; i--)
            outputStream.write(buffer[i]);
    }
}
