package MyCode.HyperSkill.String;

import java.util.Scanner;

public class Compression {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = "";
        int i = 0;
        for (; i < str.length(); i++) {
            int count = 1;
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                    i++;
                }
            }
            newStr = newStr + str.charAt(i) + count;
        }
        System.out.println(newStr);
    }
}
