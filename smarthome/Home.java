package smarthome;
import java.util.List;
import java.util.ArrayList;

public class Home {
    private List<Room> rooms;


    public void addRoom(Room r) {

        if (this.rooms.contains(r)) {
            System.out.println("Error: there is already a " + r.getName() + " in the home");
        } else {
            this.rooms.add(r);
            System.out.println(r.getName() + " successfully added to the home");
        }
    }

    public void removeRoom(Room r) {

        if (!this.rooms.contains(r)) {
            System.out.println("Error: there is no " + r.getName() + " in the home");
        } else {
            this.rooms.remove(r);
            System.out.println(r.getName() + " successfully removed from the home");
        }
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
