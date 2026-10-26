public abstract class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean occupied;

    public Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.occupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight > 0) {
            this.pricePerNight = pricePerNight;
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public abstract String getCategory();
    public abstract int getMaxCapacity();
    public abstract String getAmenities();
    public abstract double calculateRoomCost(int nights);

    @Override
    public String toString() {
        String status = occupied ? "Occupied" : "Available";
        return "Room " + roomNumber + " [" + getCategory() + "] | Capacity: " + getMaxCapacity()
                + " | Rs. " + pricePerNight + "/night | " + status + " | " + getAmenities();
    }
}
