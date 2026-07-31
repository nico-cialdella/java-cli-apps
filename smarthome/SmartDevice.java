package smarthome;

public abstract class SmartDevice {
    protected String name;
    protected boolean isOn; // Stato: acceso o no
    protected double powerConsumption; // Consumo in watt

    // Costruttore base che tutte le classi figlie dovranno chiamare
    public SmartDevice(String name, double powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.isOn = false;
    }

    // Metodi che tutti i dispositivi intelligenti (le classi figlie) possiederanno
    public void turnOn() {
        this.isOn = true; 
    }

    public void turnOff() {
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public String getDeviceName() {
        return this.name;
    }

    // Metodo astratto: qui viene soltanto dichiarato, ma la logica verrà scritta nelle classi figlie
    public abstract double getDailyConsumption();
}