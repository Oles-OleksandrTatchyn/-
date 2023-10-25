package HousePackage;

public class House {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int numberOfRooms;
    private String street;

    public House(int id, int apartmentNumber, double area, int floor, int numberOfRooms, String street) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setValue(int apartmentNumber, double area, int floor, int numberOfRooms, String street) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", floor=" + floor +
                ", numberOfRooms=" + numberOfRooms +
                ", street='" + street + '\'' +
                '}';
    }

    public static void filterByNumberOfRooms(House[] houses, int numberOfRooms) {
        boolean foundApartments = false;
        for (House house : houses) {
            if (house.numberOfRooms == numberOfRooms) {
                System.out.println(house);
                foundApartments = true;
            }
        }
        if (!foundApartments) {
            System.out.println("No apartments found that match the criteria.");
        }
    }

    public static boolean filterByRoomsAndFloor(House[] houses, int numberOfRooms, int minFloor, int maxFloor) {
        boolean foundApartments = false;
        for (House house : houses) {
            if (house.numberOfRooms == numberOfRooms && house.floor >= minFloor && house.floor <= maxFloor) {
                System.out.println(house);
                foundApartments = true;
            }
        }
        if (!foundApartments) {
            System.out.println("No apartments found that match the criteria.");
        }
        return foundApartments;
    }

    public static void filterByArea(House[] houses, double minArea) {
        boolean foundApartments = false;
        for (House house : houses) {
            if (house.area > minArea) {
                System.out.println(house);
                foundApartments = true;
            }
        }
        if (!foundApartments) {
            System.out.println("No apartments found that match the criteria.");
        }
    }
}