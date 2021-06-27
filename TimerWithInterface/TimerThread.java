import java.util.Scanner;

public class TimerThread extends Thread{
    public static int sec;
    public static int min;
    public TimerThread(int nums) {
        this.sec = (nums / 10 % 10) * 10 + nums % 10;
        this.min = (nums / 1000) * 10 + nums / 100 % 10;
        if(this.sec >= 60) {
            this.min += this.sec / 60;
            this.sec %= 60;
        }
        if(this.min > 99) {
            this.min = 99;
            this.sec = 59;
        }
    }
    @Override
    public void run() {
        if(this.sec < 0 || this.min < 0) {
            System.out.println("Invalid time value");
        }
        else {
            while(this.min > 0 || this.sec > 0) {
                if(this.sec < 0) {
                    this.sec = 59;
                    this.min--;
                }
                if(this.min < 10 && this.sec >= 10) {
                    Panel.label.setText("0" + this.min + " : " + this.sec);
                    System.out.printf("0%d : %d\n", this.min, this.sec);
                }
                else if(this.min >= 10 && this.sec < 10) {
                    Panel.label.setText(this.min + " : 0" + this.sec);
                    System.out.printf("%d : 0%d\n", this.min, this.sec);
                }
                else if(this.min < 10 && this.sec < 10) {
                    Panel.label.setText("0" + this.min + " : 0" + this.sec);
                    System.out.printf("0%d : 0%d\n", this.min, this.sec);
                }
                else {
                    Panel.label.setText(this.min + " : " + this.sec);
                    System.out.printf("%d : %d\n", this.min, this.sec);
                }
                this.sec--;
                System.out.println();
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("00 : 00");
            Panel.label.setText("00 : 00");
            Panel.nums = 0;
            Panel.counter = 0;
        }

    }
}