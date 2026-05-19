package vehiclerental;

public class Vehicle {
    private String licensePlate;
    private String brand;
    private String model;
    private double dailyRate;
    private double mileage;
    private boolean isRented;

    public Vehicle(String licensePlate, String brand, String model, double dailyRate, double mileage) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.mileage = mileage;
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

    public void returnVehicle(double newKilometers) {
        if (!this.isRented) {
            System.out.println("Error: The vehicle " + this.brand + " " + this.model + " is not currently rented!");
            return;
        }

        if (newKilometers < 0) {
            System.out.println("Error: You cannot add negative kilometers!");
            return;
        }

        this.isRented = false;
        this.mileage += newKilometers;

        System.out.println("Vehicle returned successfully! New total mileage: " + this.mileage);
    }

    public double calculateRentalCost(int days) {
        if (days <= 0) {
            System.out.println("Error: The number of days must be greater than zero.");
            return 0.0;
        }
        return this.dailyRate * days;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public double getDailyRate() {
        return this.dailyRate;
    }

    public double getMileage() {
        return this.mileage;
    }

    public boolean isRented() {
        return this.isRented;
    }

    public void setDailyRate(double newDailyRate) {
        if (newDailyRate <= 0.0) {
            System.out.println("Error: Daily Rate must be greater than zero.");
        } else {
            this.dailyRate = newDailyRate;
        }
    }

}
