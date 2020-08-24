package mycode.hyperskill;

public class CommandLine {

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int[] intLine = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            intLine[i - 1] = Integer.parseInt(args[i]);
        }

        String operator = args[0];
        if ("MAX".equals(operator)) {
            System.out.println(maxValue(max, intLine));
        }
        if ("MIN".equals(operator)) {
            System.out.println(minValue(min, intLine));
        }
        if ("SUM".equals(operator)) {
            System.out.println(summary(sum, intLine));
        }
    }

    public static int maxValue(int max, int[] intLine) {
        int result = max;
        for (int i : intLine) {
            if (i > max) {
                result = i;
            }
        }
        return result;
    }

    public static int minValue(int min, int[] intLine) {
        int result = min;
        for (int i : intLine) {
            if (i < result) {
                result = i;
            }
        }
        return result;
    }

    public static int summary(int sum, int[] intLine) {
        int result = sum;
        for (int i : intLine) {
            result += i;
        }
        return result;
    }
}


