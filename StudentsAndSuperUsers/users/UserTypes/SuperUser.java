package users.UserTypes;

import users.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.StringJoiner;

public class SuperUser extends User implements users.UserInterfaces.SuperUser {
    private String position;
    private int yearsOfWork = 0;


    //checkers
    private boolean positionChecker = false;
    private boolean yearsOfWorkChecker = false;


    //setter
    private void setPosition(String position) {
        if (position.toLowerCase().equals("teacher") ||
                position.toLowerCase().equals("else") ||
                position.toLowerCase().equals("ambion_keeper") ||
                position.toLowerCase().equals("vice_director") ||
                position.toLowerCase().equals("director")) {
            this.position = position;
            this.positionChecker = true;
        }
        else {
            System.out.println("Choose right position");
        }
    }
    private void setYearsOfWork(int yearsOfWork) {
        if(yearsOfWork >= 0 && yearsOfWork <= 50)  {
            this.yearsOfWork = yearsOfWork;
            this.yearsOfWorkChecker = true;
        }
        else {
            System.out.println("it is not possible");
        }
    }


    public SuperUser() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insert your first name");
        setFName(s.next());
        if(this.fNameChecker) {
            System.out.println("Insert your last name");
            setLName(s.next());
            if(this.lNameChecker) {
                System.out.println("Insert your age");
                setAge(s.nextInt());
                if(this.ageChecker) {
                    System.out.println("Insert your position (teacher/ambion_keeper/vice_director/director/else)");
                    setPosition(s.next());
                    if(this.positionChecker) {
                        System.out.println("Insert your work years");
                        setYearsOfWork(s.nextInt());
                        if(this.yearsOfWorkChecker) {
                            System.out.println("Insert password");
                            setPassword(s.next());
                            if(this.passwordChecker) {
                                StringJoiner sj = new StringJoiner("__");
                                sj.add(this.fName)
                                        .add(this.lName)
                                        .add(Integer.toString(this.age))
                                        .add(this.position)
                                        .add(Integer.toString(this.yearsOfWork))
                                        .add(this.password)
                                        .add("\n");
                                try {
                                    Files.write(Paths.get("super.txt"),
                                            sj.toString().getBytes(), StandardOpenOption.APPEND);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Super account is created successful");
                            }
                        }
                    }
                }
            }
        }
    }
}
