public class HeadPhones {
    public String name;
    public boolean bluetooth;
    private int battery;
    private int workHours;
    private String noBlConErrMess = "There is no bluetooth connection in this headphone";

    public String getBattery() {
        if(this.bluetooth == true) {
            return this.battery + " mAh";
        } else {
            return this.noBlConErrMess;
        }
    }

    public void setBattery(int battery) {
        if(this.bluetooth != true) {
            System.out.println(this.noBlConErrMess);
        } else {
            if(battery <= 0) {
                System.out.println("Invalid battery count mAh");
            } else {
                this.battery = battery;
            }
        }
    }

    public String getWorkHours() {
        if(this.bluetooth == true) {
            return this.workHours + " h";
        } else {
            return this.noBlConErrMess;
        }
    }

    public void setWorkHours(int workHours) {
        if(this.bluetooth != true) {
            System.out.println(this.noBlConErrMess);
        } else {
            if(workHours <= 0) {
                System.out.println("Invalid work hours count");
            } else {
                this.workHours = workHours;
            }
        }
    }
}
