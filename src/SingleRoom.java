public class SingleRoom extends Room {
    public SingleRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String getCategory() {
        return "Single";
    }

    @Override
    public int getMaxCapacity() {
        return 1;
    }

    @Override
    public String getAmenities() {
        return "Single Bed, Wi-Fi, Desk";
    }

    @Override
    public double calculateRoomCost(int nights) {
        return getPricePerNight() * nights;
    }
}
