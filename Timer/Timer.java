import java.util.Scanner;

public class Timer extends Thread{
    private int sec;
    private int min;
    public Timer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert minutes");
        this.min = sc.nextInt();
        System.out.println("Insert seconds");
        this.sec = sc.nextInt();
        if(this.sec >= 60) {
            this.min += this.sec / 60;
            this.sec %= 60;
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
                    System.out.printf("0%d : %d\n", this.min, this.sec);
                }
                else if(this.min >= 10 && this.sec < 10) {
                    System.out.printf("%d : 0%d\n", this.min, this.sec);
                }
                else if(this.min < 10 && this.sec < 10) {
                    System.out.printf("0%d : 0%d\n", this.min, this.sec);
                }
                else {
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
        }

    }
}
