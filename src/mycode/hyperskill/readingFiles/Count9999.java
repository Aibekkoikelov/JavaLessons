package mycode.hyperskill.readingFiles;

import java.io.*;
import java.util.*;

public class Count9999 {
    public static void main(String[] args)  {

        LinkedHashMap<String, Long> map = new LinkedHashMap<>();
        long thisYearValue = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dataset3.txt"));
            reader.readLine();
            while (reader.ready()) {
                String[] line = reader.readLine().split("\\s+");
                thisYearValue = Long.parseLong(line[1].replaceAll(",",""));
                map.put(line[0], thisYearValue);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        findMaxDifference(map);
//        map.forEach((String, Long) -> System.out.println(String + " " + Long));

//        findYear(list);


        System.out.println();
    }

    private static void findMaxDifference(LinkedHashMap<String, Long> map) {
        List<Long> list = new ArrayList<>();
        list.addAll(map.values());
        long value = 0;
        long difference = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            long currentDiff = list.get(i) - list.get(i-1);
            if (currentDiff > difference) {
                value = list.get(i);
                difference = currentDiff;
            }
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                System.out.println(entry.getKey());
            }
        }
    }

}
