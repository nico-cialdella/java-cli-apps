package vehiclerental;

public class Main {
    public static void main(String[] args) {
        
        Car firstCar = new Car("AB123CD", "Fiat", "Panda", 30.0, 25000.5, 5, 5, CarType.HATCHBACK, Transmission.MANUAL);
        Car secondCar = new Car("EF45GH", "BMW", "X5", 120.0, 15200.0, 5, 5, CarType.SUV, Transmission.AUTOMATIC);
        Car thirdCar = new Car("LM789NO", "Volvo", "V60", 75.0, 45000.0, 5, 5, CarType.STATION_WAGON, Transmission.AUTOMATIC);

        Motorcycle firstMotorcycle = new Motorcycle("AA00000", "Honda", "SH150i", 25.0, 12000.0, 150, MotorcycleType.SCOOTER);
        Motorcycle secondMotorcycle = new Motorcycle("BB11111", "Ducati", "Multistrada V4", 90.0, 5500.0, 1158, MotorcycleType.TOURING);
        Motorcycle thirdMotorcycle = new Motorcycle("CC22222", "Yamaha", "R1", 110.0, 800.0, 1000, MotorcycleType.SPORT);

        System.out.println("===== TEST CASES (CLI App: Vehicle Rental) =====");


        System.out.println("\n01. Tests for Cars:");

        firstCar.rent();
        secondCar.rent();

        System.out.println("Current daily rate of the Fiat Panda: " + firstCar.getDailyRate());
        System.out.println("Cost for 7 days: " + firstCar.calculateRentalCost(7));
        firstCar.addChildSeat();
        System.out.println("New daily rate: " + firstCar.getDailyRate());
        // Expected Output: After adding the child seat, daily rate increased by 5.0. So, the rental cost should be increased by 35.0 (5x7)
        System.out.println("New cost for 7 days: " + firstCar.calculateRentalCost(7));

        System.out.println();

        // Expected Output: Error (You cannot insert negative values!)
        secondCar.returnVehicle(-2500.0);

        System.out.println();

        // Expected Output: Error (This vehicle hasn't been rented!)
        thirdCar.returnVehicle(1200.0);

        System.out.println();

        // Expected Output: Success (Vehicles returned successfully)
        firstCar.returnVehicle(500.0);
        secondCar.returnVehicle(300.5);


        System.out.println("\n\n02. Tests for Motorcycles:");

        firstMotorcycle.rent();
        secondMotorcycle.rent();

        System.out.println("Current daily rate of the Honda SH150i: " + firstMotorcycle.getDailyRate());
        System.out.println("Cost for 3 days: " + firstMotorcycle.calculateRentalCost(3));
        firstMotorcycle.addTopBox();
        System.out.println("New daily rate: " + firstMotorcycle.getDailyRate());
        // Expected Output: After adding the top box, daily rate increased by 5.0. So, the rental cost should be increased by 15.0 (5x3)
        System.out.println("New cost for 3 days: " + firstMotorcycle.calculateRentalCost(3));

        System.out.println();

        // Expected Output: First two succeed, the third one triggers an error
        firstMotorcycle.addHelmet();
        firstMotorcycle.addHelmet();
        firstMotorcycle.addHelmet();

        System.out.println();

        // Expected Output: Error (You cannot insert negative values!)
        secondMotorcycle.returnVehicle(-200.0);

        System.out.println();

        // Expected Output: Error (This vehicle hasn't been rented!)
        thirdMotorcycle.returnVehicle(320.0);

        System.out.println();

        // Expected Output: Success (Vehicles returned successfully)
        firstMotorcycle.returnVehicle(80.5);
        secondMotorcycle.returnVehicle(160.0);

        System.out.println("\n ***** END OF THE TEST CASES. BYE :) *****");
    }
}
