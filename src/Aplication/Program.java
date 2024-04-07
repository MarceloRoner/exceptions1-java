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
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro! Data inválida.");
			} 
			
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva, a data de checkOut não é posterior a data de checkIn.");
			}
			
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		input.close();
	}
}
