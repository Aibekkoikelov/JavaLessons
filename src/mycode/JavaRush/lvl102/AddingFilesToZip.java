package mycode.JavaRush.lvl102;

import java.io.*;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class AddingFilesToZip {

    private static final byte[] BUFFER = new byte[4096 * 1024];

    /**
     * copy input to output stream - available in several StreamUtils or Streams classes
     */
    public static void copy(InputStream input, OutputStream output) throws IOException {
        int bytesRead;
        while ((bytesRead = input.read(BUFFER)) != -1) {
            output.write(BUFFER, 0, bytesRead);
        }
    }

    public static void main(String[] args) throws Exception {
//        createZip();

        // read war.zip and write to append.zip
        ZipFile zf = new ZipFile("/home/fogma/archive.zip");
        ZipOutputStream append = new ZipOutputStream(new FileOutputStream("/home/fogma/archive1.zip"));

        // first, copy contents from existing war
        Enumeration<? extends ZipEntry> entries = zf.entries();
        while (entries.hasMoreElements()) {
            ZipEntry e = entries.nextElement();
            System.out.println("copy: " + e.getName());
            append.putNextEntry(e);
            if (!e.isDirectory()) {
                copy(zf.getInputStream(e), append);
            }
            append.closeEntry();
        }

        // now append some extra content
        ZipEntry e = new ZipEntry("new" + File.separator + "pswds1.txt");
        System.out.println("append: " + e.getName());
        append.putNextEntry(e);
//        append.write("42\n".getBytes());
        append.closeEntry();

        // close
        zf.close();
        append.close();
    }

//        public static void createZip () {
//        try {
//            FileOutputStream zipFile = new FileOutputStream("/home/fogma/archive1.zip");
//            ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(zipFile));
////кладем в него ZipEntry – «архивный объект»
//            zip.putNextEntry(new ZipEntry("new" + File.separator + "document.txt"));
//
////копируем файл «document-for-archive.txt» в архив под именем «document.txt»
//        File file = new File("/home/fogma/pswds1.txt");
//        Files.copy(file.toPath(), zip);
//
//// закрываем архив
//            zip.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
