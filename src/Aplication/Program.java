package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = input.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(input.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva, a data de checkOut não é posterior a data de checkIn.");
		}

		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();

			System.out.println("Entre com a nova data de reserva: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(input.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(input.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation! " + error);
			}
			System.out.println("Reservation: " + reservation);
		}

		Date now = new Date();
		System.out.println(now);
		input.close();
	}

}
