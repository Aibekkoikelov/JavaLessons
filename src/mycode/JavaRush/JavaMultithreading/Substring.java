package mycode.JavaRush.JavaMultithreading;

public class Substring {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {

        try {
            String[] line = string.split(" ");
            return String.join(" ", line[1], line[2], line[3], line[4]);
        } catch (RuntimeException e) {
            throw new TooShortStringException(e);
        }
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(Throwable cause) {
            super(cause);
        }
    }
}
