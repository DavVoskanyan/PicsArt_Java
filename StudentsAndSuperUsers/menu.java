import users.UserTypes.Student;
import users.UserTypes.SuperUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;

public class menu {
    public static void main(String[] args) {
        if(!Files.exists(Paths.get("super.txt"))) {
            try {
                Files.createFile(Paths.get("super.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!Files.exists(Paths.get("student.txt"))) {
            try {
                Files.createFile(Paths.get("student.txt"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        while(true) {
            System.out.println("Login/Registration(l/r)");
            Scanner lr = new Scanner(System.in);
            String ch = lr.next();
            String name, sName;
            if(ch.toLowerCase().equals("l")) {
                System.out.println("super user/student(sup/stud)");
                String loginUser = lr.next();
                if(loginUser.equals("stud")) {
                    System.out.println("Insert name");
                    String fN = lr.next();
                    System.out.println("Insert surname");
                    String lN = lr.next();
                    System.out.println("Insert password");
                    String psw = lr.next();
                    int n = 0;
                    boolean lgin = true;
                    StringJoiner sj = new StringJoiner("");
                    sj.add("0 -- log out\n")
                            .add("1 -- get account info\n")
                            .add("2 -- change account info\n")
                            .add("3 -- get payment info\n")
                            .add("4 -- delete account");
                    System.out.println(sj.toString());
                    while(lgin) {
                        n = lr.nextInt();
                        switch (n) {
                            case 0:
                                lgin = false;
                                break;
                            case 1:
                                users.UserInterfaces.Student.getAccountInfo(fN, lN, psw);
                                break;
                            case 2:
                                users.UserInterfaces.Student.changeAccountInfo(fN, lN, psw);
                                lgin = false;
                                break;
                            case 3:
                                users.UserInterfaces.Student.getPaymentInfo(fN, lN, psw);
                                break;
                            case 4:
                                users.UserInterfaces.Student.deleteAccount(fN, lN, psw);
                                lgin = false;
                                break;
                        }
                    }
                }
                else if(loginUser.equals("sup")) {
                    System.out.println("Insert name");
                    String fN = lr.next();
                    System.out.println("Insert surname");
                    String lN = lr.next();
                    System.out.println("Insert password");
                    String psw = lr.next();
                    int n = 0;
                    boolean lgin = true;
                    StringJoiner sj = new StringJoiner("");
                    sj.add("0 -- log out\n")
                            .add("1 -- get account info\n")
                            .add("2 -- change account info\n")
                            .add("3 -- delete account\n")
                            .add("4 -- create new user\n")
                            .add("5 -- delete super user\n")
                            .add("6 -- delete student\n")
                            .add("7 -- get all students\n")
                            .add("8 -- get one student\n")
                            .add("9 -- get all super users\n")
                            .add("10 -- get one super user\n")
                            .add("11 -- change student info");
                    System.out.println(sj.toString());
                    while(lgin) {
                        n = lr.nextInt();
                        switch (n) {
                            case 0:
                                lgin = false;
                                break;
                            case 1:
                                users.UserInterfaces.SuperUser.getAccountInfo(fN, lN, psw);
                                break;
                            case 2:
                                users.UserInterfaces.SuperUser.changeAccountInfo(fN, lN, "super");
                                lgin = false;
                                break;
                            case 3:
                                users.UserInterfaces.SuperUser.deleteUser("super", fN, lN);
                                lgin = false;
                                break;
                            case 4:
                                System.out.println("super/student(sup/stud)");
                                users.UserInterfaces.SuperUser.createNewUser(lr.next());
                                break;
                            case 5:
                                System.out.println("Insert user name");
                                name = lr.next();
                                System.out.println("Insert last name");
                                sName = lr.next();
                                users.UserInterfaces.SuperUser.deleteUser("super", name, sName);
                                break;
                            case 6:
                                System.out.println("Insert user name");
                                name = lr.next();
                                System.out.println("Insert last name");
                                sName = lr.next();
                                users.UserInterfaces.SuperUser.deleteUser("student", name, sName);
                                break;
                            case 7:
                                users.UserInterfaces.SuperUser.getAllUsers("student");
                                break;
                            case 8:
                                System.out.println("Insert name");
                                name = lr.next();
                                System.out.println("Insert surname");
                                sName = lr.next();
                                users.UserInterfaces.SuperUser.getUser(name, sName, "student");
                                break;
                            case 9:
                                users.UserInterfaces.SuperUser.getAllUsers("super");
                                break;
                            case 10:
                                System.out.println("Insert name");
                                name = lr.next();
                                System.out.println("Insert surname");
                                sName = lr.next();
                                users.UserInterfaces.SuperUser.getUser(name, sName, "super");
                                break;
                            case 11:
                                System.out.println("Insert name");
                                name = lr.next();
                                System.out.println("Insert surname");
                                sName = lr.next();
                                users.UserInterfaces.SuperUser.changeAccountInfo(name, sName, "student");
                                break;

                        }
                    }
                }
            }
            else if(ch.toLowerCase().equals("r")) {
                System.out.println("super/student(sup/stud)");
                String admOrStud = lr.next();
                if(admOrStud.toLowerCase().equals("sup")) {
                    new SuperUser();
                }
                else if(admOrStud.toLowerCase().equals("stud")) {
                    new Student();
                }
                else {
                    System.out.println("Invalid Choose");
                }
            }
            else {
                System.out.println("Program closed");
            }
        }

    }
}
