package mycode.hyperskill.filehierarchies;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryDepth extends SimpleFileVisitor<Path> {
    private static String dirName = "";
    private static int deepFile = 0;
    private static int permDeep = 0;

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\basedir");
        String dir = getFiles(file);
        System.out.println(dir);
    }

    public static String getFiles(File files) {
        for (File file : files.listFiles()) {
            if (file.isDirectory()) {
                permDeep++;
                getFiles(file);
                if (permDeep > deepFile) {
                    deepFile = permDeep;
                    dirName = file.getName();
                }
                permDeep--;
            } else {
                if (permDeep > deepFile) {
                    deepFile = permDeep;
                    dirName = file.getName();
                }
            }
        }
        return dirName;
    }
}
