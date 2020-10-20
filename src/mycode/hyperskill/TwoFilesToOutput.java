package mycode.hyperskill;

import java.io.*;

/*
Последовательный вывод файлов
*/

public class TwoFilesToOutput {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = rdr.readLine();
            secondFileName = rdr.readLine();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join(); //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String fileName;
        private String fileToReturn = "";

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = reader.readLine()) != null) {
                    fileToReturn = fileToReturn + line + " ";

                }

                fileToReturn = fileToReturn.substring(0, fileToReturn.length() - 1);
                reader.close();
//                Thread.currentThread().interrupt();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {

            return fileToReturn;
        }
    }
}