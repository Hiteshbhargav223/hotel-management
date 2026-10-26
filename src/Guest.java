public class Guest extends Person {
    private String guestId;
    private String idProof;

    public Guest(String guestId, String name, String phoneNumber, String idProof) {
        super(name, phoneNumber);
        this.guestId = guestId;
        this.idProof = idProof;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getIdProof() {
        return idProof;
    }

    @Override
    public String getDetails() {
        return guestId + " - " + getName() + " (Phone: " + getPhoneNumber() + ", ID: " + idProof + ")";
    }
}
