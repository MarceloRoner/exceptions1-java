package model.entities;

import java.text.SimpleDateFormat;
import model.exceptions.DomainException;
import java.util.Date;

import java.util.concurrent.*;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		super();
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva, a data de checkOut não é posterior a data de checkIn.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Data fornecida inválida.");
		}

		else if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva, a data de checkOut não é posterior a data de checkIn.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", " + "check-in: " + sdf.format(checkIn) + ", " + "check-out: "
				+ sdf.format(checkOut) + ", " + duration() + " nights.";
	}

}
