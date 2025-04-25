
import Entities.Reservations;
import model.exception.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Room number:");
            int roomNumber = sc.nextInt();
            sc.nextLine(); // limpa o \n pendente
            System.out.println("Check-in date (dd/MM/yyyy):");
            String checkInStr = sc.nextLine();
            LocalDate checkIn = LocalDate.parse(checkInStr, fmt);
            System.out.println("Check-out date (dd/MM/yyyy):");
            String checkOutStr = sc.nextLine();
            LocalDate checkOut = LocalDate.parse(checkOutStr, fmt);


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

            reservations.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservations);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Error in reservation " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}