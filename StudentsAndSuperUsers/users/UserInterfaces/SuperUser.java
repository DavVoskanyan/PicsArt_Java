package users.UserInterfaces;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public interface SuperUser extends Student{
    static ArrayList<String> getUsers(String p) throws IOException {
        return (ArrayList<String>) Files.readAllLines(Paths.get(p + ".txt"));
    }


    static void getAccountInfo(String name, String sName, String password) {
        try {
            ArrayList<String> users = getUsers("super");
            for(String user: users) {
                if(name.equals(user.split("__")[0]) &&
                        sName.equals(user.split("__")[1]) &&
                        AdditionalInterface.md5(password).equals(user.split("__")[5])) {
                    System.out.printf("name: %s\nsurname: %s\nage: %s\nposition: %s\nyears of work: %s\npassword: %s\n",
                            name, sName, user.split("__")[2],
                            user.split("__")[3], user.split("__")[4], password);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void changeAccountInfo(String name, String sName, String mod) {
        if(mod.equals("student")) {
            deleteUser("student", name, sName);
            new users.UserTypes.Student();
        }
        else if(mod.equals("super")) {
            deleteUser("super", name, sName);
            new users.UserTypes.SuperUser();
        }
    }
    static void createNewUser(String ch) {
        if(ch.toLowerCase().equals("sup")) {
            new users.UserTypes.SuperUser();
        }
        else if(ch.toLowerCase().equals("stud")) {
            new users.UserTypes.Student();
        }
    }
    static void deleteUser(String path, String name, String sName) {
        try {
            ArrayList<String> users = getUsers(path);
            int index = -1;
            for(String user: users) {
                if(name.equals(user.split("__")[0]) &&
                        sName.equals(user.split("__")[1])) {
                    index = users.indexOf(user);
                    break;
                }
            }
            if(index < 0) {
                System.out.println("There is no such user");
            }
            else {
                Files.delete(Paths.get(path + ".txt"));
                Files.createFile(Paths.get(path + ".txt"));
                for(int i = 0; i < users.size(); i++) {
                    if(i == index) {
                        continue;
                    }
                    Files.write(Paths.get(path + ".txt"),
                            (users.get(i) + "\n").getBytes(), StandardOpenOption.APPEND);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void getAllUsers(String c) {
        ArrayList<String> users = null;
        try {
            users = getUsers(c);
            if(users.size() == 0) {
                System.out.println("Ther are no users yet");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String user: users) {
            System.out.println(user + "\n");
        }
    }
    static void getUser(String name, String sName, String c) {
        ArrayList<String> users = null;
        boolean notFound = true;
        try {
            users = getUsers(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String user: users) {
            if(name.equals(user.split("__")[0]) & sName.equals(user.split("__")[1])) {
                System.out.println(user);
                notFound = false;
                break;
            }
        }
        if(notFound) {
            System.out.println("There is no such user");
        }
    }
}
