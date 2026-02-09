package Project2;
import java.util.*;
public class ParkingDemo {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("-->>>> WELCOME TO " + Parking.getMallName() + " <<<<--");
        System.out.println("    Base Rate Per Hour: Rs. " + Parking.getBaseRatePerHr());
        System.out.println("--------------------------------------");

        System.out.print("ENTER NUMBER OF VEHICLES: ");
        int n = sc.nextInt();

        Parking[] vehicles = new Parking[n];

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.println("--- ENTER DETAILS OF VEHICLE NUMBER: " + (i + 1) + " ---");
            System.out.print("VEHICLE NUMBER: ");
            String vNo = sc.next();
            sc.nextLine();

            System.out.print("HOURS PARKED: ");
            int hours = sc.nextInt();

            System.out.print("RATE PER HOUR: ");
            double rate = sc.nextDouble();

            vehicles[i] = new Parking(vNo, hours, rate);
            System.out.println();
        }

        System.out.print("ENTER FINE AMOUNT: ");
        double fine = sc.nextDouble();

        System.out.println();

        //Parking Fee Details
        System.out.println("--------------- PARKING FEE DETAILS -------------");
        for (int i = 0; i < vehicles.length; i++) {
            Parking p = vehicles[i];
            System.out.println("VEHICLE NO        : " + p.vehicleNo);
            System.out.println("HOURS PARKED      : " + p.hoursParked);
            System.out.println("RATE PER HOUR RS. : " + p.ratePerHour);
            System.out.println("TOTAL FEE RS.     : " + p.calculateFee());
            System.out.println("FEE WITH FINE RS. : " + p.calculateFee(fine));
            System.out.println("-----------------------------------------------");
        }

        System.out.println();

        //sorting by Fee
        Parking.sortByFee(vehicles);

        System.out.println("---- VEHICLES SORTED BY FEE (LOW TO HIGH) ----");
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("VEHICLE: " + vehicles[i].vehicleNo + "     | FEE RS.: " + vehicles[i].calculateFee());
        }

        System.out.println();

        //highest fee of all vehicles
        if (n > 0) {
            double maxFee = vehicles[0].calculateFee();
            String highestVehicle = vehicles[0].vehicleNo;

            for (int i = 1; i < vehicles.length; i++) {
                double currentFee = vehicles[i].calculateFee();
                if (currentFee > maxFee) {
                    maxFee = currentFee;
                    highestVehicle = vehicles[i].vehicleNo;
                } 
            }

            System.out.println("HIGHEST FEE AMONG ALL VEHICLES: " + highestVehicle + "   | FEE RS.: " + maxFee);
        }

        System.out.println();
        System.out.println("       THANK YOU ");
        System.out.println("      FOR VISITING ");
        System.out.println(" -->>> " + Parking.getMallName() + " <<<--");

        sc.close();
    }

}
