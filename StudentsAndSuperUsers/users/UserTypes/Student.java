package users.UserTypes;

import users.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Student extends User implements users.UserInterfaces.Student{
    private int course;
    private int[] grades = new int[6];


    //checker
    private boolean courseChecker = false;
    private boolean gradesChecker = false;


    //constructor
    public Student() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insert student name");
        setFName(s.next());
        if(this.fNameChecker) {
            System.out.println("Insert student last name");
            setLName(s.next());
            if(this.lNameChecker) {
                System.out.println("Insert student age");
                setAge(s.nextInt());
                if(this.ageChecker) {
                    System.out.println("Insert student course");
                    setCourse(s.nextInt());
                    if(this.courseChecker) {
                        System.out.println("Insert student 6 grades");
                        setGrades();
                        if(this.gradesChecker) {
                            System.out.println("Insert password");
                            setPassword(s.next());
                            if(this.passwordChecker)
                            {
                                StringJoiner sj = new StringJoiner("__");
                                    sj.add(this.fName)
                                    .add(this.lName)
                                    .add(Integer.toString(this.age))
                                    .add(Integer.toString(this.course))
                                    .add(this.getGrades())
                                    .add(this.password)
                                    .add("\n");
                                try {
                                Files.write(Paths.get("student.txt"),
                                        sj.toString().getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                                System.out.println("Account is created successful");
                            }
                        }
                    }
                }
            }
        }
    }


    //setter
    private void setCourse(int course) {
            if(course < 1 || course > 4) {
                System.out.println("There is no such course (must be 1, 2, 3 or 4)");
            }
            else {
                this.course = course;
                this.courseChecker = true;
            }
    }
    private void setGrades() {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            this.grades[i] = sc.nextInt();
            if(this.grades[i] < 0 || this.grades[i] > 10) {
                System.out.println("this can't be a grade");
                break;
            }
            else {
                counter++;
            }
        }
        if(counter == 6) {
            this.gradesChecker = true;
        }
    }

    //getter
    private String getGrades() {
        StringJoiner s = new StringJoiner("");
        s.add("[");
        for(int i = 0; i < this.grades.length - 1; i++) {
            s.add(Integer.toString(this.grades[i]));
            s.add(", ");
        }
        s.add(Integer.toString(this.grades[this.grades.length - 1]));
        s.add("]");
        return s.toString();
    }



}
