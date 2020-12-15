package mycode.JavaRush.JavaCollections.lvl1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WhatsInFolder extends SimpleFileVisitor<Path>  {

    private static WhatsInFolder whatsInFolder = new WhatsInFolder();
    private static int countFolders = 0;
    private static int countFiles = 0;
    private static int sizeOfFiles = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathStr = reader.readLine();
        Path dir = Paths.get(pathStr);

        if (!Files.isDirectory(dir)) {
            System.out.println(pathStr + " - не папка");
        } else {

            Files.walkFileTree(dir, whatsInFolder);
            System.out.println("Всего папок - " + (countFolders - 1));
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + sizeOfFiles);
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countFolders++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countFiles++;
            sizeOfFiles += attrs.size();
        return FileVisitResult.CONTINUE;
    }
}
