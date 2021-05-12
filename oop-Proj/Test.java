import mainCookClass.Cook;
import mainCookClass.SubCookClass.Chef;
import mainCookClass.SubCookClass.SousChef;
import mainCookClass.SubCookClass.CommonCook;
import mainCookClass.SubCookClass.Chefs.JapanChef;
import mainCookClass.SubCookClass.Chefs.ItalianChef;
import mainCookClass.SubCookClass.Chefs.FrenchChef;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {
        FileWorkService fs = new FileWorkService();
        Scanner sc = new Scanner(System.in);
        boolean works = true;
        int num;
        StringJoiner s = new StringJoiner("\n");
        s.add("0. Create all files for easy hw check")
                .add("1. Write all chefs")
                .add("2. Write all sous-chefs")
                .add("3. Write all cooks")
                .add("4. Add new cook")
                .add("5. Add new sous-chef")
                .add("6. Add french chef")
                .add("7. Add italian chef")
                .add("8. Add japan chef");
        System.out.println(s.toString());
        while(works) {
            num = sc.nextInt();
            try {
                switch (num) {
                    case 0:
                        fs.prepareForTest();
                        break;
                    case 1:
                        System.out.println("Collecting all chefs data\n");
                        fs.read("Chef");
                        break;
                    case 2:
                        System.out.println("Collecting all sous-chefs data\n");
                        fs.read("SousChef");
                        break;
                    case 3:
                        System.out.println("Collecting all cooks data\n");
                        fs.read("Cook");
                        break;
                    case 4:
                        fs.write(new CommonCook());
                        break;
                    case 5:
                        fs.write(new SousChef());
                        break;
                    case 6:
                        fs.write(new FrenchChef());
                        break;
                    case 7:
                        fs.write(new ItalianChef());
                        break;
                    case 8:
                        fs.write(new JapanChef());
                        break;
                    case 9:
                        works = false;
                        break;
                }
            }
            catch (IOException e) {
                System.out.println("Something has gone wrong");
            }
        }
    }
}
