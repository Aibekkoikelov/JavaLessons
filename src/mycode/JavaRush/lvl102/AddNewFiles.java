package mycode.JavaRush.lvl102;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class AddNewFiles {

    public static void main(String[] args) throws Exception {

        ZipFile zf = new ZipFile("/home/fogma/archive1.zip");
        ZipOutputStream append = new ZipOutputStream(new FileOutputStream("/home/fogma/archive.zip"));

        ZipEntry e = new ZipEntry("new" + File.separator + "pswds1.txt");
        System.out.println("append: " + e.getName());
        append.putNextEntry(e);
        append.write("42\n".getBytes());
        append.closeEntry();


        append.close();
    }
}

