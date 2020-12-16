package mycode.JavaRush.lvl102;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AddingFilesToZip {
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream zipFile = new FileOutputStream("e:/archive.zip");
            ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(zipFile));
//кладем в него ZipEntry – «архивный объект»
            zip.putNextEntry(new ZipEntry("new" + File.separator + "document.txt"));

//копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        File file = new File("e:/deleted.txt");
        Files.copy(file.toPath(), zip);

// закрываем архив
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}