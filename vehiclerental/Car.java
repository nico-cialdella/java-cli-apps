package vehiclerental;

public class Car extends Vehicle {
    private int numberOfSeats;
    private int numberOfDoors;
    private CarType carType;
    private Transmission transmission;
    private boolean hasChildSeat;

    public Car(String licensePlate, String brand, String model, double dailyRate, double mileage, int numberOfSeats, int numberOfDoors, CarType carType, Transmission transmission) {
        super(licensePlate, brand, model, dailyRate, mileage);

        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.carType = carType;
        this.transmission = transmission;
        this.hasChildSeat = false;
    }

    public void addChildSeat() {
        if (!this.hasChildSeat) {
            this.hasChildSeat = true;
            double currentRate = this.getDailyRate();
            this.setDailyRate(currentRate + 5.0);

            System.out.println("Child seat added. Daily rate increased by 5.0.");
        } else {
            System.out.println("Error: This car already has a child seat!");
        }
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public CarType getCarType() {
        return this.carType;
    }

    public Transmission getTransmission() {
        return this.transmission;
    }

}
