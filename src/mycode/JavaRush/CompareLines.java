package mycode.JavaRush;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompareLines {

    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> listFromFileOne = getLinesFromFile(reader.readLine());
        List<String> listFromFileTwo = getLinesFromFile(reader.readLine());
        reader.close();
        compareLists(listFromFileOne, listFromFileTwo);
        System.out.println(lines.toString());
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type.toString() + this.line;
        }
    }

    public static List<String> getLinesFromFile(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = fileReader.readLine()) != null) {
            list.add(line);
        }
        fileReader.close();
        return list;
    }

    public static void compareLists(List<String> listOne, List<String> listTwo) {
        int j = 0;
        for (int i = 0; i < listOne.size(); i++) {
            if (listOne.get(i).equals(listTwo.get(j))) {
                lines.add(new LineItem(Type.SAME, listOne.get(i)));
                j++;
            } else if (listOne.get(i + 1).equals(listTwo.get(j))) {
                lines.add(new LineItem(Type.REMOVED, listOne.get(i)));
            } else {
                lines.add(new LineItem(Type.ADDED, listTwo.get(j)));
                j++;
            }
        }
//        for (int i = 0; i < listOne.size() - 1; i++) {
//            if (listOne.get(i).equals(listTwo.get(i))) {
//                lines.add(new LineItem(Type.SAME, listOne.get(i)));
//            } else if (listOne.get(i + 1).equals(listTwo.get(i))) {
//                lines.add(new LineItem(Type.REMOVED, listOne.get(i)));
//            } else {
//                lines.add(new LineItem(Type.ADDED, listOne.get(i)));
//            }
//        }
    }
}
