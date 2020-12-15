package mycode.hyperskill.filehierarchies;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmptyDirs {
    public static void main(String[] args) {
//        Path path = Paths.get("E:\\basedir");
        List<String> emptyFolders = new ArrayList<>();
        File dir = new File("E:\\basedir");
        File[] files = dir.listFiles();
//        for (File file : files) {
//            if (file.isDirectory() && file.listFiles().length == 0) {
//                System.out.println(file.getName());
//            }
//        }
        seekEmpty(dir, emptyFolders);
        System.out.println(emptyFolders.toString());
    }

    private static void seekEmpty(File dir, List<String> emptyFolders) {

        // Populate an array with files/folders in the directory
        File[] folderContents = dir.listFiles();
        if (folderContents.length == 0) {
            // we are empty, add us.
            emptyFolders.add(dir.getName());
        }

        // Iterate through every file/folder
        for (File content : folderContents) {
            // Disregard files, acquire folders
            if (content.isDirectory()) {
                // check if this folder is empty
                seekEmpty(content, emptyFolders);
            }
        }
    }
}
