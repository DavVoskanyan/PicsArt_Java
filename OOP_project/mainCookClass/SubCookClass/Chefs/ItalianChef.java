package mainCookClass.SubCookClass.Chefs;

import mainCookClass.SubCookClass.Chef;
import mainCookClass.SubCookClass.ChefsInterface;

import java.util.Scanner;

public class ItalianChef extends Chef{
    public ItalianChef() {
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
        System.out.println("I'm making risotto");
    }

    @Override
    public void makingDish2() {
        System.out.println("I'm making pizza");
    }

    @Override
    public void makingDish3() {
        System.out.println("I'm making pasta");
    }

}
