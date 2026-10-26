public class TripleRoom extends Room {
    public TripleRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String getCategory() {
        return "Triple";
    }

    @Override
    public int getMaxCapacity() {
        return 3;
    }

    @Override
    public String getAmenities() {
        return "3 Twin Beds, Wi-Fi, TV, Balcony";
    }

    @Override
    public double calculateRoomCost(int nights) {
        return (getPricePerNight() * nights) + 350.0;
    }
}
