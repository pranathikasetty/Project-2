package Project2;

public class Parking {
	static String mallName = "VANTAGE MALL";
    static double baseRatePerHour = 20.0;

    String vehicleNo;
    int hoursParked;
    double ratePerHour;

    public Parking() {
        vehicleNo = "XXXX";
        hoursParked = 0;
        ratePerHour = baseRatePerHour;
    }

    public Parking(String vehicleNo, int hoursParked) {
        this.vehicleNo = vehicleNo;
        this.hoursParked = hoursParked;
        this.ratePerHour = baseRatePerHour;
    }

    public Parking(String vehicleNo, int hoursParked, double ratePerHour) {
        this.vehicleNo = vehicleNo;
        this.hoursParked = hoursParked;
        this.ratePerHour = ratePerHour;
    }

    public double calculateFee() {
        return hoursParked * ratePerHour;
    }

    public String compareFee(Parking other) {
        double thisFee = this.calculateFee();
        double otherFee = other.calculateFee();

        if (thisFee > otherFee) {
            return this.vehicleNo;
        } else if (otherFee > thisFee) {
            return other.vehicleNo;
        } else {
            return "BOTH HAVE SAME FEE";
        }
    }

    public double calculateFee(double fine) {
        return calculateFee() + fine;
    }

    public static void sortByFee(Parking[] vehicles) {
        for (int i = 0; i < vehicles.length - 1; i++) {
            for (int j = 0; j < vehicles.length - i - 1; j++) {
                if (vehicles[j].calculateFee() > vehicles[j + 1].calculateFee()) {
                    Parking temp = vehicles[j];
                    vehicles[j] = vehicles[j + 1];
                    vehicles[j + 1] = temp;
                }
            }
        }
    }

    public static String getMallName() {
        return mallName;
    }

    public static double getBaseRatePerHr() {
        return baseRatePerHour;
    }

}
