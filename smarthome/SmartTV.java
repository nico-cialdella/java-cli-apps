package smarthome;

public class SmartTV extends SmartDevice {
    private int currentChannel;
    private int volume;
    private int screenBrightness;

    public SmartTV(String name, double powerConsumption) {
        super(name, powerConsumption);
        this.currentChannel = 1;
        this.volume = 0;
        this.screenBrightness = 50;
    }

    public double getDailyConsumption() {
        if (!this.isOn) {
            return 0.0;
        }

        double dailyConsumption = this.powerConsumption * (this.screenBrightness / 100.0) + (this.volume / 100.0);

        return dailyConsumption;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getScreenBrightness() {
        return this.screenBrightness;
    }

    public void setCurrentChannel(int newCurrentChannel) {
        if (newCurrentChannel <= 0 || newCurrentChannel > 999) {
            System.out.println("Invalid channel. You must enter a value between 1 and 999.");
        } else {
            this.currentChannel = newCurrentChannel;
        }
    }

    public void setVolume(int newVolume) {
        if (newVolume < 0 || newVolume > 100) {
            System.out.println("Invalid volume. You must enter a value between 0 and 100.");
        } else {
            this.volume = newVolume;
        }
    }

    public void setScreenBrightness(int newScreenBrightness) {
        if (newScreenBrightness < 0 || newScreenBrightness > 100) {
            System.out.println("Invalid brightness. You must enter a value between 0 and 100.");
        } else {
            this.screenBrightness = newScreenBrightness;
        }
    }

}
