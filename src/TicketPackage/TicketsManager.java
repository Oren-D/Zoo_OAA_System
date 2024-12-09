package TicketPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import MenuPackage.SubMenu;

public class TicketsManager {
	public static TicketsManager instance;
	private static List<Ticket> tickets = new ArrayList<>();
	static {
		Ticket visitor1Ticket = new Ticket(998, 123456789, TicketType.ADULT_YEARLY, 71, true, true, SubMenu.date);
		Ticket visitor1Ticket1 = new Ticket(996, 123123123, TicketType.CHILD_ONE_TIME, 51, true, false,
				SubMenu.date.plusYears(1));
		tickets.add(visitor1Ticket);
		tickets.add(visitor1Ticket1);
	}
	public static TicketsManager getInstance() {
		if (instance == null) {
			instance = new TicketsManager();
		}
		return instance;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	public List<TicketType> getTicketsById(int id) {
		List<TicketType> purchasedTickets = new ArrayList<>();
		for (Ticket ticket : getTicket()) {
			if (ticket.getId() == id) {
				purchasedTickets.add(ticket.getTicketType());
			}
		}
		return purchasedTickets;
	}
	public int getTicketNumberByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.getTicketNumber();
			}
		}
		return 0;
	}

	public TicketType getTicketTypeByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.getTicketType();
			}
		}
		return null;
	}

	public int getTicketPriceByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.getPrice();
			}
		}
		return 0;
	}

	public LocalDate getTicketExpiryByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.getExpiryDate();
			}
		}
		return null;
	}

	public List<Ticket> getTicketsByDate(LocalDate date) {
		List<Ticket> purchasedTickets = new ArrayList<>();
		for (Ticket ticket : getTicket()) {
			if (ticket.getIssueDate().equals(date)) {
				purchasedTickets.add(ticket);
			}
		}
		return purchasedTickets;
	}

	public LocalDate getTicketIssueByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.getIssueDate();
			}
		}
		return null;
	}

	public boolean getTicketStatusCancelableByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.isCancellable();
			}
		}
		return false;
	}
	public int getBuyerIdByDate(List<Ticket> tickets, LocalDate date) {
		for (Ticket ticket : tickets) {
			if (ticket.getIssueDate().equals(date)) {
				return ticket.getId();
			}
		}
		return 0;
	}
	public void addTicket(Ticket ticket) {
		getTicket().add(ticket);
	}

	public List<Ticket> getTicket() {
		return getTickets();
	}
	public boolean deleteTicketFromList(List<Ticket> tickets, int id, TicketType ticketType) {
		for (Ticket ticket : tickets) {
			if (ticket.getId() == id && ticket.getTicketType() == ticketType) {
				ticket.setTicketType(null);
				return true;
			}
		}
		return false;
	}
}
