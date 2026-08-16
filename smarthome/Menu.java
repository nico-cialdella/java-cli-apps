package smarthome;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Menu {
    private Home home;
    private Scanner scanner;

    public Menu(Home home) {
        this.home = home;
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US);
    }

    public void start() {

        boolean running = true;

        while (running) {
            System.out.print("\n\n\n");

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
                    System.out.print("   Type the name of the room you want to add: ");
                    String roomName = this.scanner.nextLine();

                    System.out.print("\n");
                    if (roomName.isBlank()) {
                        System.out.println("   Error: Cannot add a room with an empty name");
                        break;
                    }

                    Room newRoom = new Room(roomName);
                    if (this.home.addRoom(newRoom)) {
                        System.out.println("   " + roomName + " added successfully!");
                    } else {
                        System.out.println("   Error: Could not add the room");
                    }
                    break;

                case 3: 
                    System.out.print("   Type the name of the room you want to remove: ");
                    roomName = this.scanner.nextLine();

                    System.out.print("\n");
                    if (roomName.isBlank()) {
                        System.out.println("   Error: Cannot remove a room with an empty name");
                        break;
                    }

                    Room roomToBeRemoved = this.home.getRoomByName(roomName);
                    if (roomToBeRemoved == null) {
                        System.out.println("   Error: there is no room with this name in the home");
                        break;
                    }

                    if (this.home.removeRoom(roomToBeRemoved)) {
                        System.out.println("   " + roomName + " removed successfully!");
                    } else {
                        System.out.println("   Error: Could not remove the room");
                    }
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
                    System.out.print("   Type the name of the room you want to enter: ");
                    roomName = this.scanner.nextLine();

                    System.out.print("\n");
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
            System.out.println("   Currently, the home has no rooms");
            return;
        }

        char index = 'a';
        System.out.println("   --- List of rooms --- ");

        for (Room r : rooms) {
            System.out.println("   " + index + ") " + r.getName());
            index++;
        }
    }

    public void roomSubMenu(Room room) {

        boolean inRoom = true;
        List<SmartDevice> smartDevices = room.getDevices();
        String smartDeviceName;
        SmartDevice target;

        while (inRoom) {
            System.out.print("\n\n\n");

            System.out.println("\n   --- " + room.getName() + " management ---");
            System.out.println("\n");
            System.out.println("******************************************************************");
            System.out.println("*   1. Show the list of all smart devices in this room           *");
            System.out.println("*   2. Turn on/off a specific device                             *");
            System.out.println("*   3. Add a new device                                          *");
            System.out.println("*   4. Remove a device                                           *");
            System.out.println("*   0. Return to the main menu                                   *");
            System.out.println("******************************************************************");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    char index = 'a';

                    if (smartDevices.isEmpty()) {
                        System.out.println("   There are no smart devices in this room yet");
                        break;
                    }

                    for (SmartDevice d : smartDevices) {
                        System.out.print("   " + index + ") " + d.getDeviceName());
                        if (d.isOn()) {
                            System.out.print(" [ON]");
                        } else {
                            System.out.print(" [OFF]");
                        }

                        System.out.print("\n");
                        index++;
                    }
                    break;

                case 2:
                    if (smartDevices.isEmpty()) {
                        System.out.println("   There are no smart devices in this room yet");
                        break;
                    }

                    System.out.print("   Type the name of the smart device you want to turn on/off: ");
                    smartDeviceName = this.scanner.nextLine();

                    System.out.print("\n");
                    if (smartDeviceName.isBlank()) {
                        System.out.println("   Error: Cannot turn on/off a device with an empty name");
                        break;
                    }

                    target = room.getDeviceByName(smartDeviceName);

                    if (target == null) {
                        System.out.println("   Error: There is no device with this name in this room");
                        break;
                    }
                    
                    if (target.isOn()) {
                        target.turnOff();
                        System.out.println("   " + smartDeviceName + " turned off successfully!");
                    } else {
                        target.turnOn();
                        System.out.println("   " + smartDeviceName + " turned on successfully!");
                    }
                    break;
                
                case 3:
                    System.out.print("\n   Type 1 to add a Smart TV, 2 to add a Smart Light or 3 to add a Smart Thermostat: ");
                    String chosenNumber = this.scanner.nextLine();

                    System.out.print("\n");
                    
                    double powerConsumption = 0.0;

                    switch(chosenNumber) {
                        case "1":
                            System.out.print("   Type the name of the Smart TV: ");
                            String tvName = this.scanner.nextLine();

                            System.out.print("\n\n");
                            System.out.print("   Type the power consumption of the Smart TV: ");
                            powerConsumption = this.scanner.nextDouble();
                            this.scanner.nextLine();

                            System.out.print("\n\n");
                            SmartDevice newTv = new SmartTV(tvName, powerConsumption);

                            if (room.addDevice(newTv)) {
                                System.out.println("   Success: Smart TV Added!");
                            } else {
                                System.out.println("   Error: Could not add the device");
                            }
                            break;

                        case "2":
                            System.out.print("   Type the name of the Smart Light: ");
                            String lightName = this.scanner.nextLine();

                            System.out.print("\n\n");
                            System.out.print("   Type the power consumption of the Smart Light: ");
                            powerConsumption = this.scanner.nextDouble();
                            this.scanner.nextLine();

                            System.out.print("\n\n");
                            SmartDevice newLight = new SmartLight(lightName, powerConsumption);

                            if (room.addDevice(newLight)) {
                                System.out.println("   Success: Smart Light Added!");
                            } else {
                                System.out.println("   Error: Could not add the device");
                            }
                            break;

                        case "3":
                            System.out.print("   Type the name of the Smart Thermostat: ");
                            String thermostatName = this.scanner.nextLine();

                            System.out.print("\n\n");
                            System.out.print("   Type the power consumption of the Smart Thermostat: ");
                            powerConsumption = this.scanner.nextDouble();
                            this.scanner.nextLine();

                            System.out.print("\n\n");
                            SmartDevice newThermostat = new SmartThermostat(thermostatName, powerConsumption);

                            if (room.addDevice(newThermostat)) {
                                System.out.println("   Success: Smart Thermostat Added!");
                            } else {
                                System.out.println("   Error: Could not add the device");
                            }
                            break;

                        default:
                            System.out.println("   Invalid choice: you must type 1, 2 or 3");
                            break;
                    }
                    break;
                
                case 4:
                    if (smartDevices.isEmpty()) {
                        System.out.println("   There are no smart devices in this room yet");
                        break;
                    }

                    System.out.print("   Type the name of the smart device you want to remove: ");
                    smartDeviceName = this.scanner.nextLine();

                    System.out.print("\n");
                    if (smartDeviceName.isBlank()) {
                        System.out.println("   Error: Cannot remove a device with an empty name");
                        break;
                    }

                    target = room.getDeviceByName(smartDeviceName);

                    if (target == null) {
                        System.out.println("   Error: There is no device with this name in this room");
                        break;
                    }

                    if(room.removeDevice(target)) {
                        System.out.println("   " + smartDeviceName + " removed successfully!");
                    } else {
                        System.out.println("   Error: Could not remove the device");
                    }
                    break;
                
                case 0:
                    inRoom = false;
                    break;
            }
        }
    }
}
