import java.util.ArrayList;

public class HotelManager {
    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private int nextReservationId = 101;
    private int nextGuestId = 1;

    public HotelManager(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        initRooms();
    }

    private void initRooms() {
        rooms.add(new SingleRoom(101, 1500.0));
        rooms.add(new SingleRoom(102, 1500.0));
        rooms.add(new SingleRoom(103, 1800.0));

        rooms.add(new DoubleRoom(201, 2500.0));
        rooms.add(new DoubleRoom(202, 2500.0));
        rooms.add(new DoubleRoom(203, 2800.0));

        rooms.add(new TripleRoom(301, 3600.0));
        rooms.add(new TripleRoom(302, 3600.0));

        rooms.add(new FamilyRoom(401, 5000.0));
        rooms.add(new FamilyRoom(402, 5500.0));
    }

    public String getHotelName() {
        return hotelName;
    }

    public String nextGuestCode() {
        return "G" + (nextGuestId++);
    }

    public void showAllRooms() {
        System.out.println("\nRoom List:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public ArrayList<Room> searchAvailableRooms() {
        ArrayList<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                available.add(room);
            }
        }
        return available;
    }

    public ArrayList<Room> searchAvailableRooms(String category) {
        ArrayList<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isOccupied() && room.getCategory().equalsIgnoreCase(category.trim())) {
                available.add(room);
            }
        }
        return available;
    }

    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public Reservation bookRoom(Guest guest, int roomNumber, int nights) {
        return bookRoom(guest, roomNumber, nights, 0.0);
    }

    public Reservation bookRoom(Guest guest, int roomNumber, int nights, double discountPercent) {
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Room " + roomNumber + " not found.");
            return null;
        }
        if (room.isOccupied()) {
            System.out.println("Room " + roomNumber + " is already occupied.");
            return null;
        }
        if (nights <= 0) {
            System.out.println("Nights must be at least 1.");
            return null;
        }

        room.setOccupied(true);
        Reservation res = new Reservation(nextReservationId++, guest, room, nights, discountPercent);
        reservations.add(res);
        return res;
    }

    public void showActiveReservations() {
        System.out.println("\nActive Reservations:");
        boolean any = false;
        for (Reservation res : reservations) {
            if (!res.isCheckedOut()) {
                System.out.println(res);
                any = true;
            }
        }
        if (!any) {
            System.out.println("No active reservations found.");
        }
    }

    public void checkOut(int roomNumber) {
        for (Reservation res : reservations) {
            if (res.getRoom().getRoomNumber() == roomNumber && !res.isCheckedOut()) {
                res.markCheckedOut();
                res.getRoom().setOccupied(false);
                System.out.println("Checked out Room " + roomNumber + ".");
                System.out.println(res.generateReceipt());
                return;
            }
        }
        System.out.println("No active reservation found for Room " + roomNumber + ".");
    }

    public void showSummary() {
        int total = rooms.size();
        int occupied = 0;
        for (Room room : rooms) {
            if (room.isOccupied()) {
                occupied++;
            }
        }
        System.out.println("\n--- Hotel Summary ---");
        System.out.println("Total Rooms     : " + total);
        System.out.println("Available Rooms : " + (total - occupied));
        System.out.println("Occupied Rooms  : " + occupied);
        System.out.println("Total Bookings  : " + reservations.size());
    }
}
