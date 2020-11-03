package mycode.JavaRush;

import java.io.*;

public class ReplaceLine {

    public static void main(String[] args) {

        modifyFile("1.txt", "85", "95");

        System.out.println("done");
    }

    static void modifyFile(String fileName, String oldString, String newString) {
        File file = new File(fileName);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(file);

            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources

                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

