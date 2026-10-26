public class FamilyRoom extends Room {
    public FamilyRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String getCategory() {
        return "Family";
    }

    @Override
    public int getMaxCapacity() {
        return 5;
    }

    @Override
    public String getAmenities() {
        return "2 King Beds, Living Area, Breakfast Included";
    }

    @Override
    public double calculateRoomCost(int nights) {
        double total = getPricePerNight() * nights;
        if (nights >= 3) {
            return total * 0.90;
        }
        return total;
    }
}
