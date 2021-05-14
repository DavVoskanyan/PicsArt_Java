import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file = new File("database.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner sc = new Scanner(System.in);
        boolean work = true;
        String ch;
        System.out.println("Insert 'r' to register, 'l' to login, and anything else to finish");
        while(work) {
            ch = sc.next();
            if(ch.equals("l")) {
                new UserLogin();
            }
            else if (ch.equals("r")) {
                new UserReg();
            }
            else {
                work = false;
            }
        }
    }
}
