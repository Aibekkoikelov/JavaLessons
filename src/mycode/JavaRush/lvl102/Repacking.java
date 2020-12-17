package mycode.JavaRush.lvl102;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Repacking {
    private static Map<String, byte[]> map = new HashMap<>();

    public static void main(String[] args) {
        String archiveName = args[1];
//        String file = args[0];
        File file = new File(args[0]);
        String newFile = file.getName();

        zipToMap(archiveName, newFile);
        mapToZip(archiveName, newFile);

    }

    private static void mapToZip(String archiveName, String file) {
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(archiveName))) {
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                String name = entry.getKey();
                byte[] content = entry.getValue();
                zip.putNextEntry(new ZipEntry(name));
                zip.write(content);
                zip.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipToMap(String archive, String file) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(archive))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                String name = entry.getName();
                if (entry.isDirectory()) {
                    map.put(name, new byte[0]);
                } else if (!name.contains(file)) {
                    byte[] entryContent = new byte[(int) entry.getSize()];
                    zin.read(entryContent);
                    map.put(name, entryContent);
                    zin.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, byte[]> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(new String(e.getValue()));
        }
    }
    
    
    
    
}
