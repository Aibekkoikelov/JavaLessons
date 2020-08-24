package mycode.hyperskill;

public class InputClass {

    int hours = 12;
    int minutes = 0;

    public void next() {
        if (minutes < 59) {
            minutes++;
        } else
            minutes = 0;
        hours++;
        if (hours == 12 && minutes == 59) {
            hours = 1;
            minutes = 0;
        }
    }

}


