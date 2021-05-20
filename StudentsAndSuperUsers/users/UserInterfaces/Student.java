package users.UserInterfaces;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public interface Student {
    static ArrayList<String> getUsers() throws IOException {
        ArrayList<String> users = (ArrayList<String>) Files.readAllLines(Paths.get("student.txt"));
        return users;
    }

    static void getAccountInfo(String name, String sName, String password) {
        try {
            ArrayList<String> users = getUsers();
            for(String user: users) {
                if(name.equals(user.split("__")[0]) &&
                        sName.equals(user.split("__")[1]) &&
                AdditionalInterface.md5(password).equals(user.split("__")[5])) {
                    System.out.printf("name: %s\nsurname: %s\nage: %s\ncourse: %s\ngrades: %s\npassword: %s\n",
                            name, sName, user.split("__")[2],
                            user.split("__")[3], user.split("__")[4], password);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void changeAccountInfo(String name, String sName, String password) {
        deleteAccount(name, sName, password);
        new users.UserTypes.Student();
    }
    static void getPaymentInfo(String name, String sName, String password) {
        try {
            ArrayList<String> users = getUsers();
            for(String user: users) {
                if(name.equals(user.split("__")[0]) &&
                        sName.equals(user.split("__")[1]) &&
                        AdditionalInterface.md5(password).equals(user.split("__")[5])) {
                    double num = 0;
                    for(int i = 0; i < 6; i++) {
                        num += Double.parseDouble(user.split("__")[4]
                                .substring(1,
                                user.split("__")[4].length() - 1)
                                .split(", ")[i]);
                    }
                    if(num / 6 < 7) {
                        System.out.println("You will not get any payment");
                    }
                    else {
                        System.out.printf("You will get %s drams every month\n", Double.toString(num * 150));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void deleteAccount(String name, String sName, String password) {
        try {
            ArrayList<String> users = getUsers();
            int index = 0;
            for(String user: users) {
                if(name.equals(user.split("__")[0]) &&
                        sName.equals(user.split("__")[1]) &&
                        AdditionalInterface.md5(password).equals(user.split("__")[5])) {
                    index = users.indexOf(user);
                    break;
                }
            }
            Files.delete(Paths.get("student.txt"));
            Files.createFile(Paths.get("student.txt"));
            for(int i = 0; i < users.size(); i++) {
                if(i == index) {
                    continue;
                }
                Files.write(Paths.get("student.txt"), (users.get(i) + "\n").getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
