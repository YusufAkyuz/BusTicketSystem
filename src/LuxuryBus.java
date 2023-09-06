public class LuxuryBus extends Bus{
    public LuxuryBus(String plateNumber) {
        super("Luxury Bus", plateNumber, 14, 3, 7, new Seat[14][3]);
    }
    @Override
    public void showBusInfo() {
        System.out.println("Bus Type: Luxury Bus");
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Seat Count: " + (getRow() * getColumn() - 2));
        System.out.println("Available Seat Count: " + getAvailableSeatCount());

    }

    @Override
    public void buyTicketAtRow(Ticket ticket) {

        for (int i = 0; i < ticket.person.length; i++) {


            if (ticket.person[i].getRow() < 0 || ticket.person[i].getRow() >= getRow()) {
                System.out.println("Invalid row number.");
                return;
            }

            boolean found = false;

            for (int j = 0; j < getColumn(); j++) {
                if (!this.seatLayout[ticket.person[i].getRow()][j].isReserved()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No available seats in row " + (ticket.person[i].getRow() + 1) + ".");
                return;
            }


            Random random = new Random();
            int randomColumn;
            do {
                randomColumn = random.nextInt(getColumn());
            } while (this.seatLayout[ticket.person[i].getRow()][randomColumn].isReserved());

            this.seatLayout[ticket.person[i].getRow()][randomColumn].setReserved(true);
            setAvailableSeatCount(getAvailableSeatCount() - 1);
            System.out.println("Ticket Sold : Row " + (ticket.person[i].getRow() + 1)  + ", Column " + (randomColumn + 1));
        }
        showAvailableSeats();

        showBusInfo();
    }
}
