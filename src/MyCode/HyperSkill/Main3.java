package MyCode.HyperSkill;
// Iterating over arrays
// Alphabetical order (hard)  problem

import java.util.*;

class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean alphabet = false;
        String[] str = sc.nextLine().split(" ");

        for (int i = 0; i < str.length-1; i++) {
            if (str[i].compareTo(str[i+1]) <= 0) {
                alphabet = true;
            }   else alphabet = false;
        }
        System.out.println(alphabet);

    }
}