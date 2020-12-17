package mycode.hyperskill.filehierarchies;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryDepth extends SimpleFileVisitor<Path> {
    private static String dirName = "";
    private static int deepFile = 0;
    private static int permDeep = 0;

    public DirectoryDepth() throws IOException {
    }

    public static void main(String[] args) throws IOException {
//        File file = new File("E:\\basedir");
//        String dir = getFiles(file);
//        System.out.println(dir);
        int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int code : message) {
            outputStream.write(code);
        }

        System.out.println(outputStream.toString());
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
