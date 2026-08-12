package smarthome;
import java.util.List;
import java.util.ArrayList;

public class Room {
    private String name;
    private List<SmartDevice> devices;

    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        if (!this.devices.contains(device)) {
            this.devices.add(device);
            System.out.println("Smart Device added successfully");
        } else {
            System.out.println("Error: this device already exists in this room");
        }
    }

    public void removeDevice(SmartDevice device) {
        if (!this.devices.contains(device)) {
            System.out.println("Error: this device doesn't exist in this room");
        } else {
            this.devices.remove(device);
            System.out.println("Smart Device removed successfully");
        }
    }

    public double getRoomPowerConsumption() {
        double total = 0.0;

        for (SmartDevice d : this.devices) {
            double currentDeviceConsumption = d.getDailyConsumption();
            total = total + currentDeviceConsumption;
        }

        return total;
    }

    public void turnOffAll() {
        for (SmartDevice d : this.devices) {
            d.turnOff();
        }
    }

    public String getName() {
        return this.name;
    }

    public List<SmartDevice> getDevices() {
        return this.devices;
    }

    public void setName(String newRoomName) {
        this.name = newRoomName;
    }

}

