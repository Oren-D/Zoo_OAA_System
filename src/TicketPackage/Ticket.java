package TicketPackage;

import java.time.LocalDate;

public class Ticket {

	private int ticketNumber;
	private int idNumber;
	private TicketType ticketType;
	private int price;
	private boolean cancellable;
	private boolean annual;
	private LocalDate issueDate;
	private LocalDate expiryDate;

	public Ticket(int ticketNumber, int idNumber, TicketType ticketType, int price, boolean cancellable,boolean annual,
			LocalDate issueDate) {
		this.ticketNumber = TicketNumberGenerator.generateTicketNumber();
		this.idNumber = idNumber;
		this.ticketType = ticketType;
		this.price = price;
		this.cancellable = cancellable;
		this .annual=annual;
		this.issueDate = issueDate;
		this.expiryDate = calculateExpiryDate(issueDate);
	}

	public boolean getAnnual() {
		return annual;
	}

	public void setAnnual(boolean annual) {
		this.annual = annual;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public int getPrice() {
		return price;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public int getId() {
		return idNumber;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	private LocalDate calculateExpiryDate(LocalDate issueDate) {
		return issueDate.plusYears(1);
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}
}
