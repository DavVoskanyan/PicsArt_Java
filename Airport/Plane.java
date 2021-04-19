package Airport;


import java.util.Scanner;

public class Plane {
    private String model;
    private String country;
    private int year;
    private int hours;
    public boolean  isMilitary;
    public int weight;
    private int topSpeed;
    private int seats;
    public double cost;

    public Plane() {
        Scanner s = new Scanner(System.in);
        System.out.println("Model");
        setModel(s.next());
        System.out.println("Country");
        setCountry(s.next());
        System.out.println("Yaer");
        setYear(s.nextInt());
        System.out.println("Hours");
        setHours(s.nextInt());
        System.out.println("Is Military?(Y/N)");
        setMilitary(s.next());
        System.out.println("Weight");
        setWeight(s.nextInt());
        System.out.println("Top Speed");
        setTopSpeed(s.nextInt());
        System.out.println("Count of Seats");
        setSeats(s.nextInt());
        System.out.println("Cost");
        setCost(s.nextDouble());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model != "") {
            this.model = model;
        }
        else {
            System.out.println("Please enter the name of plane...");
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(model != "") {
            this.country = country;
        }
        else {
            System.out.println("Please enter the name of country...");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year < 1903) {
            this.year = 1903;
        }
        else if(year > 2020) {
            this.year = 2020;
        }
        else {
            this.year = year;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(hours < 0) {
            this.hours = 0;
        }
        else if(hours > 10000) {
            this.hours = 10000;
        }
        else {
            this.hours = hours;
        }
    }

    public String isMilitary() {
        if (isMilitary) {
            return "Yes";
        }
        return "No";
    }

    public void setMilitary(String military) {
        if(military == "Y") {
            isMilitary = true;
        }
        else {
            isMilitary = false;
        }
    }

    public String getWeight() {
        return weight + " kg";
    }

    public void setWeight(int weight) {
        if(weight < 1000) {
            this.weight = 1000;
        }
        else if(weight > 160000) {
            weight = 160000;
        }
        else {
            this.weight = weight;
        }
    }

    public String getTopSpeed() {
        return topSpeed + "km/h";
    }

    public void setTopSpeed(int topSpeed) {
        if(topSpeed < 0) {
            System.out.println("impossible value");
        }
        else{
            this.topSpeed = topSpeed;
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if(seats < 0) {
            System.out.println("impossible value");
        }
        else {
            this.seats = seats;
        }
    }

    public String getCost() {
        return cost + "$";
    }

    public void setCost(double cost) {
        if(cost < 0) {
            System.out.println("impossible value");
        }
        else{
            this.cost = cost;
        }
    }
}
