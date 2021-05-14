import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;

public class UserLogIn {

    private String fullName;
    private boolean fullNameBool = false;
    private String userName;
    private boolean userNameBool = false;
    private String email;
    private boolean emailBool = false;
    private String password;
    private boolean passwordBool = false;

    //constructor
    public UserLogIn() {
        Scanner sc = new Scanner(System.in);
        StringJoiner sj = new StringJoiner(",");
        System.out.println("Insert your full name (Name Surname)");
        setFullName(sc.nextLine());

        System.out.println("Insert your username");
        setUserName(sc.next());

        System.out.println("Insert your mail");
        setEmail(sc.next());

        System.out.println("Insert password");
        setPassword(sc.next());

        if(this.fullNameBool && this.userNameBool && this.emailBool && this.passwordBool) {
            sj.add(this.fullName)
              .add(this.userName)
              .add(this.email)
              .add(this.password)
              .add("\n ");
            try {
                Files.write(Paths.get("C:\\Users\\User\\Desktop\\Picsart\\regAndLog\\src\\database.txt"),
                        sj.toString().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("This username already is being used");
        }
    }

    //getter
    public String getFullName() {
        return fullName;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }


    //setter
    public void setFullName(String fullName) {
        if (fullName.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")) {
            this.fullName = fullName;
            this.fullNameBool = true;
        }
    }
    public void setUserName(String userName) {
        try {
            int counter = 0;
            ArrayList<String> users =
                    (ArrayList<String>) Files.readAllLines(
                            Paths.get("C:\\Users\\User\\Desktop\\Picsart\\regAndLog\\src\\database.txt"));
            for(int i = 0; i < users.size(); i++) {
                if(userName.equals(users.get(i).split(",")[1])) {
                    counter++;
                    break;
                }
            }
            if(counter == 0 && userName.length() > 10) {
                this.userName = userName;
                this.userNameBool = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setEmail(String email) {
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
            this.emailBool = true;
        }
    }
    public void setPassword(String password) {
        int countNums = 0, countUps = 0;
        for(int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                countUps++;
            }
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                countNums++;
            }
        }
        if(countNums >= 3 && countUps >= 2 && password.length() > 8) {
            this.password = password;
            this.passwordBool = true;
        }
    }
}
