import mainCookClass.Cook;
import mainCookClass.SubCookClass.Chef;
import mainCookClass.SubCookClass.SousChef;
import mainCookClass.SubCookClass.CommonCook;
import mainCookClass.SubCookClass.Chefs.JapanChef;
import mainCookClass.SubCookClass.Chefs.ItalianChef;
import mainCookClass.SubCookClass.Chefs.FrenchChef;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chef chef;

        chef = new FrenchChef();
        chef.makingDish1();
        chef = new ItalianChef();
        chef.makingDish2();

    }
}
