package mainCookClass.SubCookClass.Chefs;

import mainCookClass.SubCookClass.Chef;
import mainCookClass.SubCookClass.ChefsInterface;

import java.util.Scanner;

public class FrenchChef extends Chef{
    public FrenchChef() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        setName(sc.next());
        System.out.println("Enter Age");
        setAge(sc.nextInt());
        System.out.println("Enter Work Experience");
        setWorkExperience(sc.nextInt());
    }

    @Override
    public void makingDish1() {
        System.out.println("I'm making croissant");
    }

    @Override
    public void makingDish2() {
        System.out.println("I'm making cassoulet");
    }

    @Override
    public void makingDish3() {
        System.out.println("I'm making boeuf bourguignon");
    }

}
