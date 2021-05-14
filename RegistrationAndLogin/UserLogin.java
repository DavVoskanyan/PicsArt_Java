import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserLogin {
    private String userName;
    private String password;

    public UserLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("User name");
        setUserName(sc.next());
        System.out.println("Password");
        setPassword(sc.next());

        try {
            boolean suc = false;
            ArrayList<String> users =
                    (ArrayList<String>) Files.readAllLines(
                            Paths.get("database.txt"));
            for(String line: users) {
                if(line.split(",")[1].equals(this.userName) &&
                        line.split(",")[3].equals(this.password)) {
                    System.out.printf("Log in successful! Welcome back %s\n", line.split(",")[1]);
                    suc = true;
                    break;
                }
            }
            if(!suc) {
                System.out.println("Something has gone wrong. Check your username and password...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = PasswordCoder.md5(password);
    }
}
