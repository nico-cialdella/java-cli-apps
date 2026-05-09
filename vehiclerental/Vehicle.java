package vehiclerental;

public class Vehicle {
    private String licensePlate;
    private String brand;
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Vehicle(String licensePlate, String brand, String model, double dailyRate) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        // A car just purchased by the agency is not already rented, so we set isRented to false by default.
        this.isRented = false;
    }

    public void rent() {
        if (this.isRented) {
            System.out.println("Error: The vehicle " + this.brand + " " + this.model + " is already rented!");
        } else {
            this.isRented = true;
            System.out.println("Vehicle rented successfully!");
        }
    }

    public void returnVehicle() {
        if (!this.isRented) {
            System.out.println("Error: The vehicle " + this.brand + " " + this.model + " is not currently rented!");
        } else {
            this.isRented = false;
            System.out.println("Vehicle returned successfully!");
        }
    }

    public double calculateRentalCost(int days) {
        if (days <= 0) {
            System.out.println("Error: The number of days must be greater than zero.");
            return 0.0;
        }
        return this.dailyRate * days;
    }



}
