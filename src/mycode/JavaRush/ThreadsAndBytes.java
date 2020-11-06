package mycode.JavaRush;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ThreadsAndBytes {

    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void Run() throws IOException {
            FileInputStream fileInputStream = new FileInputStream(currentThread().getName());
            int[] buffer = new int[128];
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                buffer[i]++;
            }
            fileInputStream.close();
            int max = 0;
            for (int j = 0; j < buffer.length; j++) {
                if (buffer[j] > buffer[max]) {
                    max = j;
                }
            }
            resultMap.put(fileName, max);
        }
    }
}
