import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManager hotel = new HotelManager("Sunrise Hotel");

        boolean running = true;
        while (running) {
            System.out.println("\n=== " + hotel.getHotelName() + " Management ===");
            System.out.println("1. View All Rooms");
            System.out.println("2. Search Available Rooms by Category");
            System.out.println("3. Book a Room");
            System.out.println("4. Book a Room with Discount");
            System.out.println("5. View Active Reservations");
            System.out.println("6. Check Out Guest");
            System.out.println("7. Occupancy Summary");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    hotel.showAllRooms();
                    break;

                case "2":
                    System.out.print("Enter category (Single/Double/Triple/Family): ");
                    String category = sc.nextLine().trim();
                    ArrayList<Room> available = hotel.searchAvailableRooms(category);
                    if (available.isEmpty()) {
                        System.out.println("No available rooms in category: " + category);
                    } else {
                        for (Room r : available) {
                            System.out.println(r);
                        }
                    }
                    break;

                case "3":
                case "4":
                    try {
                        System.out.print("Guest Name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Phone Number: ");
                        String phone = sc.nextLine().trim();
                        System.out.print("ID Proof Number: ");
                        String idProof = sc.nextLine().trim();
                        System.out.print("Room Number: ");
                        int roomNo = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Number of Nights: ");
                        int nights = Integer.parseInt(sc.nextLine().trim());

                        Guest guest = new Guest(hotel.nextGuestCode(), name, phone, idProof);
                        Reservation res;

                        if (choice.equals("4")) {
                            System.out.print("Discount %: ");
                            double discount = Double.parseDouble(sc.nextLine().trim());
                            res = hotel.bookRoom(guest, roomNo, nights, discount);
                        } else {
                            res = hotel.bookRoom(guest, roomNo, nights);
                        }

                        if (res != null) {
                            System.out.println("Booking created: " + res);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number entered.");
                    }
                    break;

                case "5":
                    hotel.showActiveReservations();
                    break;

                case "6":
                    try {
                        System.out.print("Enter Room Number to check out: ");
                        int roomNo = Integer.parseInt(sc.nextLine().trim());
                        hotel.checkOut(roomNo);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid room number.");
                    }
                    break;

                case "7":
                    hotel.showSummary();
                    break;

                case "0":
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
