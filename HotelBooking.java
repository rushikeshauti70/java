import java.util.Scanner;

public class HotelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int floors = 3, rooms = 4; // 3 Floors, 4 Rooms per floor
        int[][] hotel = new int[floors][rooms]; // 0 = Available, 1 = Booked

        while (true) {
            System.out.println("\n🏨 Hotel Room Booking System");
            System.out.println("1. View Room Availability");
            System.out.println("2. Book a Room");
            System.out.println("3. Check Out from Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayRooms(hotel);
                    break;
                case 2:
                    bookRoom(hotel, sc);
                    break;
                case 3:
                    checkOut(hotel, sc);
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Booking System! 🏨");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // Display hotel room availability
    static void displayRooms(int[][] hotel) {
        System.out.println("\n🏢 Room Status (0 = Available, 1 = Booked)");
        for (int i = 0; i < hotel.length; i++) {
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < hotel[i].length; j++) {
                System.out.print(hotel[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // Book a room
    static void bookRoom(int[][] hotel, Scanner sc) {
        System.out.print("Enter Floor (1-" + hotel.length + "): ");
        int floor = sc.nextInt() - 1;
        System.out.print("Enter Room (1-" + hotel[0].length + "): ");
        int room = sc.nextInt() - 1;

        if (isValid(hotel, floor, room)) {
            if (hotel[floor][room] == 0) {
                hotel[floor][room] = 1;
                System.out.println("✅ Room booked successfully!");
            } else {
                System.out.println("❌ Room already booked.");
            }
        } else {
            System.out.println("❌ Invalid floor or room number.");
        }
    }

    // Check out from a room
    static void checkOut(int[][] hotel, Scanner sc) {
        System.out.print("Enter Floor (1-" + hotel.length + "): ");
        int floor = sc.nextInt() - 1;
        System.out.print("Enter Room (1-" + hotel[0].length + "): ");
        int room = sc.nextInt() - 1;

        if (isValid(hotel, floor, room)) {
            if (hotel[floor][room] == 1) {
                hotel[floor][room] = 0;
                System.out.println("✅ Checked out successfully!");
            } else {
                System.out.println("❌ Room is already available.");
            }
        } else {
            System.out.println("❌ Invalid floor or room number.");
        }
    }

    // Validate input
    static boolean isValid(int[][] hotel, int floor, int room) {
        return floor >= 0 && floor < hotel.length &&
               room >= 0 && room < hotel[0].length;
    }
}

/* ---------- SECOND CLASS (NOT PUBLIC) ---------- */

class SimpleHotelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] hotel = new int[2][3]; // 2 Floors, 3 Rooms each

        while (true) {
            System.out.println("\n🏨 Simple Hotel Booking");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Thank you! 🏨");
                break;
            } else if (choice == 1) {
                displayRooms(hotel);
            } else if (choice == 2) {
                bookRoom(hotel, sc);
            } else {
                System.out.println("❌ Invalid choice.");
            }
        }
        sc.close();
    }

    static void displayRooms(int[][] hotel) {
        for (int i = 0; i < hotel.length; i++) {
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < hotel[i].length; j++) {
                System.out.print(hotel[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void bookRoom(int[][] hotel, Scanner sc) {
        System.out.print("Enter Floor: ");
        int floor = sc.nextInt() - 1;
        System.out.print("Enter Room: ");
        int room = sc.nextInt() - 1;

        if (floor >= 0 && floor < hotel.length &&
            room >= 0 && room < hotel[0].length &&
            hotel[floor][room] == 0) {

            hotel[floor][room] = 1;
            System.out.println("✅ Room booked!");
        } else {
            System.out.println("❌ Invalid or already booked.");
        }
    }
}
