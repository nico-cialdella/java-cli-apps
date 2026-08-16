package smarthome;

public class SmartThermostat extends SmartDevice {
    private double currentTemperature;
    private double desiredTemperature;

    public SmartThermostat(String name, double powerConsumption) {
        super(name, powerConsumption);
        this.currentTemperature = 18.0;
        this.desiredTemperature = 22.0;
    }

    public double getDailyConsumption() {

        if (!this.isOn) {
            return 0.0;
        }
        
        double difference = Math.abs(this.currentTemperature - this.desiredTemperature);
        double dailyConsumption = this.powerConsumption * difference;
        
        return dailyConsumption;
    }

    public double getCurrentTemperature() {
        return this.currentTemperature;
    }

    public double getDesiredTemperature() {
        return this.desiredTemperature;
    }

    public void setCurrentTemperature(double newCurrentTemperature) {
        if (newCurrentTemperature < 10.0 || newCurrentTemperature > 30.0) {
            System.out.println("Invalid temperature. You must enter a value between 10.0 and 30.0");
        } else {
            this.currentTemperature = newCurrentTemperature;
        }
    }

    public void setDesiredTemperature(double newDesiredTemperature) {
        if (newDesiredTemperature < 10.0 || newDesiredTemperature > 30.0) {
            System.out.println("Invalid temperature. You must enter a value between 10.0 and 30.0");
        } else {
            this.desiredTemperature = newDesiredTemperature;
        }
    }

    

}
