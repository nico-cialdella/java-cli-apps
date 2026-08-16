package smarthome;
import java.util.List;
import java.util.ArrayList;

public class Home {
    private List<Room> rooms;

    public Home() {
        this.rooms = new ArrayList<>();
    }

    public boolean addRoom(Room r) {

        if (getRoomByName(r.getName()) != null) {
            return false;
        }
        this.rooms.add(r);
        return true;
    }

    public boolean removeRoom(Room r) {

        if (!this.rooms.contains(r)) {
            return false;
        }
        this.rooms.remove(r);
        return true;
    }

    public double getTotalPowerConsumption() {

        double totalPowerConsumption = 0.0;

        for (Room r : this.rooms) {
            double currentRoomConsumption = r.getRoomPowerConsumption();
            totalPowerConsumption += currentRoomConsumption;
        }
        
        return totalPowerConsumption;
    }

    public Room getRoomByName(String roomName) {

        for (Room r: this.rooms) {
            String currentName = r.getName();

            if (currentName.equalsIgnoreCase(roomName)) {
                return r;
            }
        }
        return null;
    }

    public void turnOffAll() {

        for (Room r : this.rooms) {
            r.turnOffAll();
        }
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

}
