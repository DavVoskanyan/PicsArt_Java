package Airport;

public class PlaneService {
    //~~~~~~~~  1  ~~~~~~~
    public void printSomeInfo(Plane pl) {
        if(pl.isMilitary() == "Yes") {
            System.out.printf("cost: %s \ntop speed: %s", pl.getCost(), pl.getTopSpeed());
        }
        else {
            System.out.printf("model: %s \ncountry: %s", pl.getModel(), pl.getCountry());
        }
    }


    //~~~~~~~~  2  ~~~~~~~
    public Plane returnNewerOne(Plane pl1, Plane pl2) {
        if(pl1.getYear() >= pl2.getYear()) {
            return pl1;
        }
        return pl2;
    }


    //~~~~~~~~~~  3  ~~~~~~~~~~~
    public void printCountryOfSmallestCountOfSeats(Plane pl1, Plane pl2, Plane pl3) {
        Plane pl = pl1;
        if(pl2.getSeats() < pl.getSeats()) {
            pl = pl2;
        }
        if(pl3.getSeats() < pl.getSeats()) {
            pl = pl3;
        }
        System.out.println(pl.getCountry());
    }


    //~~~~~~~~~~~  4  ~~~~~~~~~~~
    public void printNotMilitary(Plane[] planes) {
        for (Plane plane : planes) {
            if(!plane.isMilitary) {
                System.out.printf("%s, ", plane.getModel());
            }
        }
    }


    //~~~~~~~~~  5  ~~~~~~~~~~~~
    public void printMilitaryAndMoreThan100Hours(Plane[] planes) {
        for (Plane plane : planes) {
            if(plane.isMilitary && plane.getHours() > 100) {
                System.out.printf("%s, ", plane.getModel());
            }
        }
    }


    //~~~~~~~~~~  6  ~~~~~~~~~~~
    public Plane printMinimalWeightPlane(Plane[] planes) {
        Plane minWeightPlane = planes[0];
        for (int i = 1; i < planes.length; i++) {
            if(planes[i].weight <= minWeightPlane.weight) {
                minWeightPlane = planes[i];
            }
        }
        return minWeightPlane;
    }


    //~~~~~~~~~  7  ~~~~~~~~~
    public Plane printMinimalCostAndMilitary(Plane[] planes) {
        Plane minCostMilitary = planes[0];
        int index = 0;
        for (int i = 1;i < planes.length; i++) {
            if(planes[i].isMilitary) {
                minCostMilitary = planes[i];
                index = i;
                break;
            }
        }
        for(int i = index + 1; i < planes.length; i++) {
            if(planes[i].isMilitary &&  minCostMilitary.cost < planes[i].cost) {
                minCostMilitary = planes[i];
            }
        }
        return minCostMilitary;
    }


    //~~~~~~~~~~~~  8  ~~~~~~~~~~~~
    public void printSortedPlanes(Plane[] planes) {
        Plane temp;
        for(int i = 0; i < planes.length; i++) {
            for(int j = 1; j < planes.length - i; j++) {
                if(planes[j - 1].getYear() > planes[j].getYear()) {
                    temp = planes[j - 1];
                    planes[j - 1] = planes[j];
                    planes[j] = temp;
                }
            }
        }
        for(Plane plane : planes) {
            System.out.print(plane.getModel());
        }
    }
}
