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

    public boolean addDevice(SmartDevice device) {
        if (this.devices.contains(device)) {
            return false;
        }
        this.devices.add(device);
        return true;
    }

    public boolean removeDevice(SmartDevice device) {
       return this.devices.remove(device); 
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

    public SmartDevice getDeviceByName(String deviceName) {
        for (SmartDevice d : this.devices) {
            String currentDeviceName = d.getDeviceName();
            
            if (currentDeviceName.equalsIgnoreCase(deviceName)) {
                return d;
            }
        }
        return null;
    }

    public void setName(String newRoomName) {
        this.name = newRoomName;
    }

}

