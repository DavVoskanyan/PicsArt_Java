package Airport;

import java.util.Scanner;

public class AirportTest {
    public static void main(String[] args) {
        PlaneService tester = new PlaneService();
        Scanner s = new Scanner(System.in);
        Plane pl1 = new Plane();
        Plane pl2 = new Plane();
        Plane pl3 = new Plane();
        Plane pl4 = new Plane();
        Plane[] planes = {pl1, pl2, pl3, pl4};
        boolean isWorking = true;
        int i;
        System.out.println("Insert the number of function(1-8) or 9 to finish");
        while(isWorking) {
            i = s.nextInt();
            switch (i) {
                case 1:
                    tester.printSomeInfo(pl1);
                    break;

                case 2:
                    System.out.println(tester.returnNewerOne(pl1, pl2).getModel());
                    break;

                case 3:
                    tester.printCountryOfSmallestCountOfSeats(pl1, pl2, pl3);
                    break;

                case 4:
                    tester.printNotMilitary(planes);
                    break;

                case 5:
                    tester.printMilitaryAndMoreThan100Hours(planes);
                    break;

                case 6:
                    System.out.println(tester.printMinimalWeightPlane(planes).getModel());
                    break;

                case 7:
                    System.out.println(tester.printMinimalCostAndMilitary(planes).getModel());
                    break;

                case 8:
                    tester.printSortedPlanes(planes);
                    break;

                case 9:
                    isWorking = false;
            }
        }


    }
}