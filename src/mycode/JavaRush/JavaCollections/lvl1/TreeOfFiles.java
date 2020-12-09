package mycode.JavaRush.JavaCollections.lvl1;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/

public class TreeOfFiles {
    public static void main(String[] args) throws IOException {
        String path = args[0];

        File source = new File(args[1]);
        File dest = new File(source.getParent() + "/allFilesContent.txt");
        Files.move(source.toPath(), dest.toPath());


        List<File> listOfFiles = listOfFiles(path);
        Collections.sort(listOfFiles, new FileComparator());
        System.out.println(listOfFiles);
        writeToFile(dest, listOfFiles);
    }


    public static List<File> listOfFiles(String path) {
        File dir = new File(path);
        List<File> fileList = new ArrayList<>();
        File[] fList = dir.listFiles();
        fileList.addAll(Arrays.asList(fList));

        for (int i = 0; i < fileList.size(); i++) {
            if (fileList.get(i).isDirectory()) {
                fileList.addAll(Arrays.asList(fileList.get(i).listFiles()));
            }
        }

        for (Iterator<File> it = fileList.iterator(); it.hasNext(); ) {
            File file = it.next();
            String fileName = file.getName();
            if (!fileName.endsWith(".txt")) {
                it.remove();
            }
            if (file.isFile() && file.length() > 50) {
                it.remove();
            }
        }
        return fileList;
    }

    public static void writeToFile(File file, List<File> list) throws IOException {

        FileOutputStream fos = new FileOutputStream(file, true);

        for (File fl : list) {
            FileInputStream fis = new FileInputStream(fl);
            while (fis.available() > 0) {
                fos.write(fis.read());
            }
            fis.close();
            fos.write((byte) '\n');
        }
        fos.close();
    }

    static class FileComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

