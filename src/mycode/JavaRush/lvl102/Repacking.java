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

    public static void main(String[] args) throws IOException {

        zipToMap(args[1]);

        FileOutputStream fos = new FileOutputStream(args[1]);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fos);

        File file = new File(args[0]);
        zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
        Files.copy(file.toPath(), zipOutputStream);

        for (Map.Entry<String, byte[]> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(new String(e.getValue()));
            if (!e.equals("new/" + file.getName())) {
                ZipEntry zipEntry = new ZipEntry(e.getKey());
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(e.getValue());
                zipOutputStream.closeEntry();
            }
        }
        zipOutputStream.close();
    }

    private static void mapToZip(String archiveName) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(archiveName))) {
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

    public static void zipToMap(String archive) throws IOException {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(archive))) {
            ZipEntry entry;
            byte[] buffer = new byte[1024];
            while ((entry = zin.getNextEntry()) != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length;
                while ((length = zin.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                map.put(entry.getName(), outputStream.toByteArray());
                zin.closeEntry();
            }
        }
    }
}
