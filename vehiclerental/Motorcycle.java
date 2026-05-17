package vehiclerental;

public class Motorcycle extends Vehicle {
    private int engineCapacity;
    private int includedHelmets;
    private MotorcycleType motorcycleType;
    private boolean hasTopBox;

    public Motorcycle(String licensePlate, String brand, String model, double dailyRate, double mileage, int engineCapacity, MotorcycleType motorcycleType) {
        super(licensePlate, brand, model, dailyRate, mileage);

        this.engineCapacity = engineCapacity;
        this.includedHelmets = 0;
        this.motorcycleType = motorcycleType;
        this.hasTopBox = false;
    }

    public void addHelmet() {
        if (this.includedHelmets < 2) {
            this.includedHelmets++;

            System.out.println("Helmet added.");
        } else {
            System.out.println("Error: This motorcycle already has two helmets!");
        }
    }

    public void addTopBox() {
        if (!this.hasTopBox) {
            this.hasTopBox = true;
            double currentRate = this.getDailyRate();
            this.setDailyRate(currentRate + 5.0);

            System.out.println("Top box added. Daily rate increased by 5.0.");
        } else {
            System.out.println("Error: This motorcycle already has a top box!");
        }
    }

    public int getEngineCapacity() {
        return this.engineCapacity;
    }

    public int getIncludedHelmets() {
        return this.includedHelmets;
    }

    public MotorcycleType getMotorcycleType() {
        return this.motorcycleType;
    }

}
