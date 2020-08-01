package MyCode.HyperSkill.String;

import java.util.Scanner;

public class ParseUrl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = "";
        String stupidProblem = "";
        newStr = str.substring(str.indexOf("?") + 1);
        String line = newStr.replaceAll("=&", "=not found&");
        String[] newLine = line.split("&");
        for (String s : newLine) {
            System.out.println(s.replace("=", " : "));
            if (s.contains("pass")) {
                stupidProblem = s.replaceAll("pass", "password");
            }
        }
        if (!"".equals(stupidProblem)) System.out.println(stupidProblem.replace("=", " : "));
    }
}
