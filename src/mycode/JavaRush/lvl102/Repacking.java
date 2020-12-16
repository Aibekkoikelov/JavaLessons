package mycode.JavaRush.lvl102;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Repacking {
    private static Map<String, ByteArrayOutputStream> map = new HashMap<>();

    public static void main(String[] args) {
        String file = "E:\\archive.zip";
        zipToMap(file);
    }

    public static void zipToMap (String fileName) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("E:\\archive.zip"))) {
            ZipEntry entry;
            String name;
            byte[] buffer = new byte[4096];
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(entry.getName()));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int bytes = 0;
                while ((bytes = bis.read(buffer, 0, buffer.length)) > 0) {
                    baos.write(buffer, 0, bytes);
                }
                map.put(name, baos);
                baos.close();
                zin.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(map.toString());
        System.out.println(map.size());
    }
}