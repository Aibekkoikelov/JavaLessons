package mycode.hyperskill.generics;

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getob() {
        return ob;
    }

    void showType() {
        System.out.println("T is a type of " + ob.getClass().getName());
    }
}

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb;

        iOb = new Gen<>(88);
        iOb.showType();
        int v = iOb.getob();
        System.out.println("Value: " + v);
        System.out.println();

        Gen<String> strOb = new Gen<String>("Generics text");
        strOb.showType();

        String str = strOb.getob();
        System.out.println("Value: " + str);
    }
}
