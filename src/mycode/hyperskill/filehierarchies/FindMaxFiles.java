package mycode.hyperskill.filehierarchies;

import java.io.File;
import java.util.Arrays;

public class FindMaxFiles {
    public static void main(String[] args) {
        File file = new File("E:\\basedir");
        File[] listFiles = file.listFiles();
        int max = 0;
        File maxDir = null;
        for (File fl : listFiles) {
            int currentLength = fl.listFiles().length;
            if (fl.isDirectory() && currentLength > max) {
                max = currentLength;
                maxDir = fl;
            }
        }
        System.out.println(maxDir + " " + max);
    }
}
