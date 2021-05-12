package mainCookClass.SubCookClass;

import mainCookClass.Cook;

import java.util.Scanner;

public class SousChef extends Cook {

    public SousChef() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        setName(sc.next());
        System.out.println("Enter Age");
        setAge(sc.nextInt());
        System.out.println("Enter Work Experience");
        setWorkExperience(sc.nextInt());
        setPosition("SousChef");
        setFileName("SousChef");
    }

    @Override
    public void cookingMeal() {
        System.out.println("I'm not chef, but I can cook well too");
    }

}
