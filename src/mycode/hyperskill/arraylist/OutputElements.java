package mycode.hyperskill.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class OutputElements {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
    }
}
