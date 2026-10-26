import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation implements Billable {
    private int reservationId;
    private Guest guest;
    private Room room;
    private int nights;
    private double discountPercent;
    private String checkInDate;
    private boolean checkedOut;

    public Reservation(int reservationId, Guest guest, Room room, int nights, double discountPercent) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.nights = nights;
        this.discountPercent = discountPercent;
        this.checkInDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.checkedOut = false;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void markCheckedOut() {
        this.checkedOut = true;
    }

    @Override
    public double calculateSubtotal() {
        double baseCost = room.calculateRoomCost(nights);
        double discount = baseCost * (discountPercent / 100.0);
        return baseCost - discount;
    }

    @Override
    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    @Override
    public double calculateFinalBill() {
        return calculateSubtotal() + calculateTax();
    }

    @Override
    public String generateReceipt() {
        double baseCost = room.calculateRoomCost(nights);
        double discount = baseCost * (discountPercent / 100.0);

        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Hotel Bill Receipt ---\n");
        sb.append("Reservation ID : ").append(reservationId).append("\n");
        sb.append("Check-In Date  : ").append(checkInDate).append("\n");
        sb.append("Guest          : ").append(guest.getDetails()).append("\n");
        sb.append("Room           : #").append(room.getRoomNumber())
          .append(" (").append(room.getCategory()).append(")\n");
        sb.append("Nights         : ").append(nights).append("\n");
        sb.append(String.format("Room Charges   : Rs. %.2f\n", baseCost));
        if (discountPercent > 0) {
            sb.append(String.format("Discount (%.0f%%) : -Rs. %.2f\n", discountPercent, discount));
        }
        sb.append(String.format("Subtotal       : Rs. %.2f\n", calculateSubtotal()));
        sb.append(String.format("Tax (12%%)      : Rs. %.2f\n", calculateTax()));
        sb.append(String.format("Total Amount   : Rs. %.2f\n", calculateFinalBill()));
        sb.append("--------------------------\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        String status = checkedOut ? "Checked Out" : "Active";
        return String.format("Booking #%d [%s] | Room %d (%s) | Guest: %s | %d night(s) | Total: Rs. %.2f",
                reservationId, status, room.getRoomNumber(), room.getCategory(),
                guest.getName(), nights, calculateFinalBill());
    }
}
