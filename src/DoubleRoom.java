public class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String getCategory() {
        return "Double";
    }

    @Override
    public int getMaxCapacity() {
        return 2;
    }

    @Override
    public String getAmenities() {
        return "Queen Bed, Wi-Fi, TV, Mini Fridge";
    }

    @Override
    public double calculateRoomCost(int nights) {
        return (getPricePerNight() * nights) + 200.0;
    }
}
