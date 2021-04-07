public class lesson4 {
    public static void main(String[] args) {
        HeadPhones hp1 = new HeadPhones();
        hp1.name = "AirPods";
        hp1.bluetooth = true;

        //setting invalid value for battery
        hp1.setBattery(-3000);

        //setting valid value for workHours
        hp1.setWorkHours(8);

        //setting valid value for battery
        hp1.setBattery(3500);

        System.out.println(hp1.getBattery());
        System.out.println(hp1.getWorkHours());

        HeadPhones hp2 = new HeadPhones();
        hp1.name = "Major III";
        hp2.bluetooth = false;

        //valid value, but no bluetooth
        hp2.setBattery(3000);
        hp2.setWorkHours(15);

        //getting massages
        System.out.println(hp2.getBattery());
        System.out.println(hp2.getWorkHours());

    }
}