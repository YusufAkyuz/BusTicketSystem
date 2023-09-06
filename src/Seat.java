class Seat {

    private boolean reserved;
    public int seatNumber;

    public Seat() {
        this.reserved = false;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        if (!reserved) {
            reserved = true;
            System.out.println("Seat reserved successfully.");
        } else {
            System.out.println("Seat already reserved.");
        }
    }

    public void cancel() {
        if (reserved) {
            reserved = false;
            System.out.println("Seat canceled.");
        } else {
            System.out.println("Seat is not reserved.");
        }
    }

    @Override
    public String toString() {
        return reserved ? "Full " : "Empty";
    }
}

