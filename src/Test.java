import java.util.Scanner;

public class Test {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        //Dongusuz girdi ornekleri vererek oluşturma

        Bus bus = new LuxuryBus("01 AA 01");
        bus.showAvailableSeats();

        Bus bus2 = new RegularBus("01 AA 01");
        bus2.showAvailableSeats();


        double value = 0.3333;

        Person person1 = new Person("Yusuf", "Akyüz", (int) value * bus.getRow(), Gender.Male);
        Person person2 = new Person("Ali", "Akyüz", (int) value * bus.getRow(), Gender.Female);
        Person person3 = new Person("Mehmet", "Akyüz", (int) value * bus.getRow(), Gender.Male);


        Person [] personArr1 = {person1, person2, person3};
        Ticket ticket1 = new Ticket(personArr1, 200);
        bus.buyTicketAtRow(ticket1);

        value = 0.2222;

        Person person4 = new Person("Yusuf", "Akyüz", (int) value * bus.getRow(), Gender.Male);
        Person person5 = new Person("Ali", "Akyüz", (int) value * bus.getRow(), Gender.Male);
        Person person6 = new Person("Mehmet", "Akyüz", (int) value * bus.getRow(), Gender.Female);
        Person [] personArr2 = {person4, person5, person6};
        Ticket ticket2 = new Ticket(personArr2, 200);
        bus2.buyTicketAtRow(ticket2);

        Person person7 = new Person("Mehmet", "Akyüz", 1, Gender.Female);
        Person [] personArr3 = {person7};
        Ticket ticket3 = new Ticket(personArr3, 200);
        bus2.buyTicketAtRow(ticket3);
        bus2.showAvailableSeats();


        Bus busChoose = new LuxuryBus("01 AA 01");
        Bus busChoose2 = new RegularBus("01 AA 01");

        //Donguyle girdi ornekleri vererek oluşturma

        String liste = "1-Buy Ticket\n" +
                "2-Reset ALl Reservations\n" +
                "3-Reset Local Reservation\n" +
                "4-For Exit\n" +
                "Please Select: ";

        while(true) {

            System.out.print(liste);
            String continueSystem = scanner.nextLine();

            if(continueSystem.equals("4")) {
                break;
            } else if (continueSystem.equals("1")) {
                System.out.print("How many tickets will you buy?: ");
                int personNumber = scanner.nextInt();
                scanner.nextLine();
                Person [] personArrNew = new Person[personNumber];

                for (int i = 0; i < personArrNew.length; i++) {
                    Person person = new Person(); // yeni bir Person nesnesi oluşturulur
                    System.out.print((i + 1) + ". person name: ");
                    String name = scanner.nextLine();
                    person.setName(name);
                    System.out.print((i + 1) + ". person surname: ");
                    String surname = scanner.nextLine();
                    person.setSurname(surname);
                    System.out.print((i + 1) + ". person row(with comma): ");
                    double row = scanner.nextDouble();
                    scanner.nextLine();
                    row *= bus.getRow();
                    person.setRow((int) (row + 1));
                    System.out.print("Person gender : ");
                    String gender = scanner.nextLine();
                    if(gender.equals(Gender.Male)) {
                        person.gender = Gender.Male;
                    } else if (gender.equals(Gender.Female)) {
                        person.gender = Gender.Female;
                    } else {
                        person.gender = Gender.Male;
                    }
                    personArrNew[i] = person; // Oluşturduğumuz person nesnesi dizideki ilgili indekse atanır
                }

                //Otobüsü oluşturup satış işlemi yapıcaz


                while (true) {
                    System.out.print("Which type of bus do you prefer (Luxury Bus or Regular Bus): ");
                    String typeBus = scanner.nextLine();
                    if (typeBus.equals("Luxury Bus")) {

                        Ticket ticketChoose = new Ticket(personArrNew, 300);
                        busChoose.buyTicketAtRow(ticketChoose);
                        break;
                    } else if (typeBus.equals("Regular Bus")) {

                        Ticket ticketChoose = new Ticket(personArrNew, 200);
                        busChoose2.buyTicketAtRow(ticketChoose);
                        break;
                    }else {
                        System.out.println("Please enter the correct type of value!!  (Luxury Bus or Regular Bus)");
                        continue;
                    }

                }

                //Tüm rezervasyonları restleme işlemlerini yapıcağımız yer
            } else if (continueSystem.equals("2")) {
                while (true) {
                    System.out.println("Which bus do you want to reset? ");
                    String resetOption = scanner.nextLine();
                    if (resetOption.equals("Luxury Bus")) {
                        busChoose.makeAllSeatsAvailable();
                        break;
                    } else if (resetOption.equals("Regular Bus")) {
                        busChoose2.makeAllSeatsAvailable();
                        break;
                    } else {
                        System.out.println("Wrong Type..");
                    }
                }
            } else if (continueSystem.equals("3")) {
                while (true) {
                    System.out.println("Which bus do you want to reset? ");
                    String resetOption = scanner.nextLine();
                    if (resetOption.equals("Luxury Bus")) {
                        System.out.print("Which row: ");
                        int row = scanner.nextInt();
                        row -= 1;
                        scanner.nextLine();
                        System.out.print("Which column: ");
                        int column = scanner.nextInt();
                        column -= 1;
                        scanner.nextLine();
                        busChoose.cancelSeat(row, column);
                        break;
                    } else if (resetOption.equals("Regular Bus")) {
                        System.out.print("Which row: ");
                        int row = scanner.nextInt();
                        row -= 1;
                        System.out.print("Which column: ");
                        int column = scanner.nextInt();
                        column -= 1;
                        scanner.nextLine();
                        busChoose2.cancelSeat(row, column);
                        break;
                    } else {
                        System.out.println("Wrong Type..");
                    }
                }
            }else {
                System.out.println("Wrong Type");
            }


        }



    }

}

