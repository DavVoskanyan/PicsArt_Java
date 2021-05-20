package users;

import users.UserInterfaces.AdditionalInterface;


public abstract class User {
    protected String fName;
    protected String lName;
    protected int age = 18;
    protected String password;


    //checkers
    protected boolean fNameChecker = false;
    protected boolean lNameChecker = false;
    protected boolean ageChecker = false;
    protected boolean passwordChecker = false;


    //setters
    protected void setFName(String fName) {
        if(fName.matches("^[A-Za-z]+$")) {
            this.fName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
            fNameChecker = true;
        }
        else {
            System.out.println("This is not a name");
        }
    }
    protected void setLName(String lName) {
        if(lName.matches("^[A-Za-z]+$")) {
            this.lName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();
            lNameChecker = true;
        }
        else {
            System.out.println("This is not a surname");
        }
    }
    protected void setAge(int age) {
        if(age > 14 && age < 90) {
            this.age = age;
            ageChecker = true;
        }
        else {
            System.out.println("This can't be an age");
        }
    }
    protected void setPassword(String password) {
        int countNums = 0, countUps = 0, countLows = 0;
        for(int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                countUps++;
            }
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                countNums++;
            }
            if(password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                countLows++;
            }
        }
        if(countNums >= 1 && countUps >= 1 && countLows >= 0 && password.length() >= 8) {
            this.password = AdditionalInterface.md5(password);
            this.passwordChecker = true;
        }
        else {
            System.out.println("1 upper case, 1 lower case, 1 number and min length 8");
        }
    }
}
