
abstract class Bus {
    private String busType;
    private String plateNumber;
    private int row;
    private int column;
    private int midDoor;
    private int availableSeatCount;
    protected Seat [][] seatLayout;

    public Bus(String busType, String plateNumber, int row, int column, int midDoor, Seat [][] seatLayout) {
        this.busType = busType;
        this.plateNumber = plateNumber;
        this.row = row;
        this.column = column;
        this.midDoor = midDoor;
        this.availableSeatCount = row * column -2;
        this.seatLayout = seatLayout;

    int forSeatNumber = 1;
 	for (int i = 0; i < row; i++) {
        for (int j = 0; j < column; j++) {
            this.seatLayout[i][j] = new Seat();
            this.seatLayout[i][j].seatNumber = forSeatNumber;
        }
    }
}
    //abstract methods ---> override edilecek
    public abstract void showBusInfo();

    public abstract void buyTicketAtRow(Ticket ticket);


    public void showAvailableSeats() {
        System.out.println("Available Seats:");
        for (int row = 0; row < seatLayout.length; row++) {
            for (int col = 0; col < seatLayout[row].length; col++) {
                if (!seatLayout[row][col].isReserved() && row != midDoor) {
                    System.out.print("X");
                } else if (row == midDoor) {
                    if(column == 4) {
                        System.out.print("XX");
                    }else {
                        System.out.print("X");
                    }
                    break;
                } else if (seatLayout[row][col].isReserved()) {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    //Tümünü boşaltma işlemini her ikisinde de kullanacağım için superclassta yazdık
    public void makeAllSeatsAvailable() {
        for (int row = 0; row < seatLayout.length; row++) {
            for (int col = 0; col < seatLayout[row].length; col++) {
                seatLayout[row][col].setReserved(false);
            }
        }
        availableSeatCount = row * column;
        System.out.println("All seats made available.");
        showAvailableSeats();
    }


    //oturulan koltkları boşalt superde yazacaz
    public void cancelSeat(int row, int col) {
        if (seatLayout[row][col].isReserved()) {
            seatLayout[row][col].setReserved(false);
            availableSeatCount++;
            System.out.println("Seat canceled successfully.");
        } else {
            System.out.println("Seat is not reserved.");
        }

        showAvailableSeats();
    }

    public String getBusType() {
        return busType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getAvailableSeatCount() {
        return availableSeatCount;
    }

    public void setAvailableSeatCount(int availableSeatCount) {
        this.availableSeatCount = availableSeatCount;
    }

    public Seat[][] getSeatLayout() {
        return seatLayout;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}



}
