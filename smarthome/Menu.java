package smarthome;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Home home;
    private Scanner scanner;

    public Menu(Home home) {
        this.home = home;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("   WELCOME TO THIS BEAUTIFUL, BRAND-NEW HOME! WHAT WOULD YOU LIKE TO DO?   ");
            System.out.println("\n");
            System.out.println("*********************************************");
            System.out.println("*   1. Show the list of all rooms           *");
            System.out.println("*   2. Add a new room                       *");
            System.out.println("*   3. Remove a room                        *");
            System.out.println("*   4. View total consumption               *");
            System.out.println("*   5. Master switch (turn off all)         *");
            System.out.println("*   6. Enter a room                         *");
            System.out.println("*   0. Exit                                 *");
            System.out.println("*********************************************");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showRooms();
                    break;
                
                case 2:
                    System.out.println("   Type the name of the room you want to add: ");
                    String roomName = this.scanner.nextLine();

                    if (roomName.isBlank()) {
                        System.out.println("   Error: Cannot add a room with an empty name");
                        break;
                    }

                    Room newRoom = new Room(roomName);
                    this.home.addRoom(newRoom);
                    break;

                case 3: 
                    System.out.println("   Type the name of the room you want to remove: ");
                    roomName = this.scanner.nextLine();

                    if (roomName.isBlank()) {
                        System.out.println("   Error: Cannot remove a room with an empty name");
                        break;
                    }

                    Room roomToBeRemoved = this.home.getRoomByName(roomName);
                    if (roomToBeRemoved == null) {
                        System.out.println("   Error: there is no room with this name in the home");
                        break;
                    }

                    this.home.removeRoom(roomToBeRemoved);
                    break;

                case 4:
                    double totalConsumption = this.home.getTotalPowerConsumption();
                    System.out.println("   Total consumption: " + totalConsumption);
                    break;

                case 5:
                    this.home.turnOffAll();
                    System.out.println("   All the smart devices in the home have been turned off.");
                    break;

                case 6:
                    System.out.println("   Type the name of the room you want to enter: ");
                    roomName = this.scanner.nextLine();

                    if (roomName.isBlank()) {
                        System.out.println("   Error: Cannot enter a room with an empty name");
                        break;
                    }

                    Room roomToEnter = this.home.getRoomByName(roomName);
                    if (roomToEnter == null) {
                        System.out.println("   Error: there is no room with this name in the home");
                        break;
                    }
                    
                    roomSubMenu(roomToEnter);
                    break;

                case 0: 
                    running = false;
                    break;
            }
        }
    }

    public void showRooms() {
        List<Room> rooms = this.home.getRooms();

        if (rooms.isEmpty()) {
            System.out.println("Currently, the home has no rooms");
            return;
        }

        char index = 'a';
        System.out.println("--- List of rooms ---");

        for (Room r : rooms) {
            System.out.println(index + ") " + r.getName());
            index++;
        }
    }

    public void roomSubMenu(Room room) {
        
    }
    

}
