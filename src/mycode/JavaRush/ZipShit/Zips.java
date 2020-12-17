package mycode.JavaRush.ZipShit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.*;

public class Zips {
    public static void main(String[] args) throws IOException {


        // создаем архив
        FileOutputStream zipFile = new FileOutputStream("/home/fogma/archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        zip.putNextEntry(new ZipEntry("document.txt"));
        File file = new File("dataset3.txt");

        Files.copy(file.toPath(), zip);
        zip.close();
    }
}
