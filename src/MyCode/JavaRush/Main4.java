package MyCode.JavaRush;

// Iterating over arrays
// Right Rotation (hard) problem

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int rotation = sc.nextInt();
        String[] newStr = new String[str.length];
//        int[] b = new int[str.length];
        for (int i = 0; i < str.length; i++) {
//            a[i] = Integer.parseInt(str[i]);
            newStr[(i + rotation) % str.length] = str[i];
        }
        for (String i : newStr) {
            System.out.print(i + " ");
        }
    }
}
