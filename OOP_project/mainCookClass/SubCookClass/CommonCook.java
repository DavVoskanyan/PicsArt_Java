package mainCookClass.SubCookClass;

import mainCookClass.Cook;

import java.util.Scanner;

public class CommonCook extends Cook {
    public CommonCook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        setName(sc.next());
        System.out.println("Enter Age");
        setAge(sc.nextInt());
        System.out.println("Enter Work Experience");
        setWorkExperience(sc.nextInt());
    }

    @Override
    public void cookingMeal() {
        System.out.println("I'm cooking something delicious...");
    }

}
