import HousePackage.House;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        House[] houses = new House[5];
        houses[0] = new House(1, 101, 75.5, 3, 3, "Central Street");
        houses[1] = new House(2, 202, 90.0, 4, 4, "Post Street");
        houses[2] = new House(3, 303, 60.0, 2, 2, "Main Street");
        houses[3] = new House(4, 404, 110.5, 5, 5, "Garden Street");
        houses[4] = new House(5, 505, 70.0, 3, 3, "Park Street");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of additional apartments you want to add: ");
        int numAdditionalApartments = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numAdditionalApartments; i++) {
            System.out.println("\nEnter details for Apartment " + (houses.length + 1) + ":");
            System.out.print("Apartment Number: ");
            int apartmentNumber = scanner.nextInt();
            System.out.print("Area (sq. m): ");
            double area = scanner.nextDouble();
            System.out.print("Floor: ");
            int floor = scanner.nextInt();
            System.out.print("Number of Rooms: ");
            int numberOfRooms = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Street: ");
            String street = scanner.nextLine();

            houses = addHouse(houses, new House(i + houses.length + 1, apartmentNumber, area, floor, numberOfRooms, street));
        }

        boolean continueSorting = true;

        while (continueSorting) {

            System.out.println("\nList of Apartments:");
            for (House house : houses) {
                System.out.println(house);
            }

            System.out.println("\nEnter sorting criteria:");
            System.out.println("1. Number of Rooms");
            System.out.println("2. Floor Range");
            System.out.println("3. Minimum Area");
            System.out.print("\nEnter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter the number of rooms for filtering: ");
                    int numberOfRoomsToFilter = scanner.nextInt();
                    House.filterByNumberOfRooms(houses, numberOfRoomsToFilter);
                    break;
                case 2:
                    System.out.print("\nEnter the minimum floor: ");
                    int minFloor = scanner.nextInt();
                    System.out.print("Enter the maximum floor: ");
                    int maxFloor = scanner.nextInt();
                    System.out.print("Enter the number of rooms for filtering: ");
                    int numberOfRoomsToFilter2 = scanner.nextInt();
                    House.filterByRoomsAndFloor(houses, numberOfRoomsToFilter2, minFloor, maxFloor);
                    break;
                case 3:
                    System.out.print("\nEnter the minimum area: ");
                    double minArea = scanner.nextDouble();
                    House.filterByArea(houses, minArea);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.print("\nDo you want to continue sorting? (yes/no): ");
            String continueChoice = scanner.next();
            continueSorting = continueChoice.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    private static House[] addHouse(House[] houses, House newHouse) {
        House[] newArray = new House[houses.length + 1];
        System.arraycopy(houses, 0, newArray, 0, houses.length);
        newArray[houses.length] = newHouse;
        return newArray;
    }
}
