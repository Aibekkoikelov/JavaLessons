package mycode.JavaRush.lvl102;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Repacking {
    private static Map<String, byte[]> map = new HashMap<>();

    public static void main(String[] args) {
        String archiveName = "E:\\archive.zip";
        String file = "deleted.txt";
        zipToMap(archiveName, file);

    }

    public static void zipToMap(String archive, String file) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("E:\\archive.zip"))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                String name;
                name = entry.getName();

                if (entry.isDirectory()) {
                    map.put(name, null);
                } else if (!name.contains(file)) {
                    InputStream inputStream = new FileInputStream(name);
                    byte[] fileContent = inputStream.readAllBytes();
                    map.put(name, fileContent);
                    inputStream.close();
                    zin.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(map.toString());
        System.out.println(map.size());
    }
}