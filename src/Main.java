
import Entities.Reservations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Room number:");
        int roomNumber = sc.nextInt();
        sc.nextLine(); // limpa o \n pendente

        System.out.println("Check-in date (dd/MM/yyyy):");
        String checkInStr = sc.nextLine();
        LocalDate checkIn = LocalDate.parse(checkInStr, fmt);

        System.out.println("Check-out date (dd/MM/yyyy):");
        String checkOutStr = sc.nextLine();
        LocalDate checkOut = LocalDate.parse(checkOutStr, fmt);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-Out date must be after Check-In date");
        } else  {
            Reservations reservations = new Reservations(roomNumber, checkIn, checkOut);
            System.out.println("Reservation:" + reservations);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.println("Check-in date (dd/MM/yyyy):");
            checkInStr = sc.nextLine();
            checkIn = LocalDate.parse(checkInStr, fmt);

            System.out.println("Check-out date (dd/MM/yyyy):");
            checkOutStr = sc.nextLine();
            checkOut = LocalDate.parse(checkOutStr, fmt);

            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.isAfter(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                reservations.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservations);
            }
        }

        sc.close();
    }
}