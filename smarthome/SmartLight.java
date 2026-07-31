package smarthome;

public class SmartLight extends SmartDevice {
    private int brightness;
    private String color;

    public SmartLight(String name, double powerConsumption) {
        super(name, powerConsumption);
        this.brightness = 100;
        this.color = "white";
    }

    public double getDailyConsumption() {
        if (!this.isOn) {
            return 0.0;
        }

        double dailyConsumption = this.powerConsumption * (this.brightness / 100.0);

        return dailyConsumption;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getColor() {
        return this.color;
    }

    public void setBrightness(int newBrightness) {
        if (newBrightness >= 0 && newBrightness <= 100) {
            this.brightness = newBrightness;
        } else {
            System.out.println("Invalid brightness. You must enter a value between 0 and 100.");
        }
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

}
