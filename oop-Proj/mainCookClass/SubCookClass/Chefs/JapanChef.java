package mainCookClass.SubCookClass.Chefs;

import mainCookClass.SubCookClass.Chef;
import mainCookClass.SubCookClass.ChefsInterface;

import java.util.Scanner;

public class JapanChef extends Chef{
    public JapanChef() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        setName(sc.next());
        System.out.println("Enter Age");
        setAge(sc.nextInt());
        System.out.println("Enter Work Experience");
        setWorkExperience(sc.nextInt());
        setPosition("Japan-Chef");
        setFileName("Chef");
    }

    @Override
    public void makingDish1() {
        System.out.println("I'm making sushi");
    }

    @Override
    public void makingDish2() {
        System.out.println("I'm making sashimi");
    }

    @Override
    public void makingDish3() {
        System.out.println("I'm making ramen");
    }

}