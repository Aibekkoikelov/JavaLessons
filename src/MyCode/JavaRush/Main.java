package MyCode.JavaRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.SQLOutput;
//import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        double m = Double.parseDouble(reader.readLine());
//
//        double mt = m%5;
//        if (mt >= 3 && mt < 4) {
//            System.out.println("yellow");
//        }
//        else if (mt >= 4 && mt < 5) {
//            System.out.println("red");
//        }
//        else System.out.println("green");

//        int n1 = Integer.parseInt(reader.readLine());
//        int n2 = Integer.parseInt(reader.readLine());
//        int n3 = Integer.parseInt(reader.readLine());
//
//        if (n1 == n2 && n2 == n3)
//            System.out.println(n1+" "+n2+" "+n3);
//        else if (n1 == n2)
//            System.out.println(n1+" "+n2);
//        else if (n1 == n3)
//            System.out.println(n1+" "+n3);
//        else if (n2 == n3)
//            System.out.println(n2+" "+n3);
//        else System.out.println("");

//        int n = 476;
//        System.out.println(n % 10 + (n / 10) % 10 + n / 100);
//        System.out.println(n / 100);
//        System.out.println(n % 10);
//        System.out.println((n / 10) % 10);
//String str = "java";
//str.compareToIgnoreCase("h");
//        Scanner scan = new Scanner(System.in);
//        String str1 = scan.nextLine().replace(" ", "").trim();
//        String str2 = scan.nextLine().replace(" ", "").trim();
//        System.out.println(str1.equals(str2));

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double area = 0;
//        double area1 = 0;
//        double area2 = 0;
//        double resArea;
//        switch (new Scanner(System.in).nextLine()) {
//            case "rectangle":
//                int r1 = sc.nextInt();
//                int r2 = sc.nextInt();
//                area1 = r1 * r2;
//                System.out.print(area1);
//                break;
//            case "triangle":
//                int s1 = sc.nextInt();
//                int s2 = sc.nextInt();
//                int s3 = sc.nextInt();
//                area = (s1+s2+s3)/2.0d;
//                resArea = Math.sqrt(area* (area - s1) * (area - s2) * (area - s3));
//                System.out.print(resArea);
//                break;
//            case "circle":
//                int c1 = sc.nextInt();
//                area2 = Math.PI * (c1 * c1);
//                System.out.print(area2);
//                break;
//        }
//    }
//}