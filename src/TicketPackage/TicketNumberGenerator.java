package TicketPackage;

public class TicketNumberGenerator {
	
	private static int ticketCounter = 1000;
	public static int generateTicketNumber() {
		return ++ticketCounter;
	}
}
