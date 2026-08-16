package smarthome;

public class Main {
    public static void main(String[] args) {
        Home home = new Home();

        Room bedroom = new Room("bedroom");
        Room kitchen = new Room("kitchen");
        Room lounge = new Room("lounge");
        Room bathroom = new Room("bathroom");
        Room office = new Room("office");

        home.addRoom(bedroom);
        home.addRoom(kitchen);
        home.addRoom(lounge);
        home.addRoom(bathroom);
        home.addRoom(office);

        SmartDevice tvLounge = new SmartTV("Samsung", 150.0);
        SmartDevice thermostatLounge = new SmartThermostat("Ecobee", 1300.0);
        lounge.addDevice(tvLounge);
        lounge.addDevice(thermostatLounge);

        SmartDevice lightOffice = new SmartLight("Philips Hue White", 10.0);
        office.addDevice(lightOffice);

        SmartDevice tvBedroom = new SmartTV("Sony", 130.0);
        SmartDevice thermostatBedroom = new SmartThermostat("Google Nest", 1500.0);
        bedroom.addDevice(tvBedroom);
        bedroom.addDevice(thermostatBedroom);

        SmartDevice tvKitchen = new SmartTV("TCL", 170.0);
        SmartDevice thermostatKitchen = new SmartThermostat("Tado", 1700.0);
        kitchen.addDevice(tvKitchen);
        kitchen.addDevice(thermostatKitchen);

        Menu menu = new Menu(home);

        menu.start();
    }
}
