package MenuPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import EmployeePackage.EmployeeManager;
import TicketPackage.Ticket;
import TicketPackage.TicketsManager;
import VisitorPackage.ObserverManager;
import VisitorPackage.VisitorManager;

public class ParkEntrance {
	private VisitorManager vm=VisitorManager.getInstance();
	private TicketsManager tm=TicketsManager.getInstance();
	private ObserverManager om=ObserverManager.getInstance();

	public boolean enterPark() {
		String idString = JOptionPane.showInputDialog("Please enter your Visitor ID:");
		if (idString == null) {
			return false;
		}

		int id;
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a numeric ID.");
			return false;
		}

		if (vm.visitorExists(vm.getVisitor(), id)) {
			List<Ticket> visitorTickets = getTicketsByVisitorId(tm.getTickets(), id);

			if (visitorTickets.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No tickets found for this ID.");
				return false;
			}

			StringBuilder ticketsInfo = new StringBuilder();
			for (Ticket ticket : visitorTickets) {
				ticketsInfo.append("Ticket Number: ").append(ticket.getTicketNumber()).append("\nTicket Type: ")
						.append(ticket.getTicketType()).append("\nCancellable: ").append(ticket.isCancellable())
						.append("\n\n");
			}

			String[] ticketOptions = { "Validate Ticket", "Exit" };
			int choice = JOptionPane.showOptionDialog(null, "Your tickets:\n" + ticketsInfo.toString(), "Your Tickets",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ticketOptions, ticketOptions[0]);

			if (choice == 0) {
				if (validateTicket(visitorTickets)) {
					om.getPromotionManager().notifyObserverById(id);
					return true;
				}
				JOptionPane.showMessageDialog(null, "Buy new ticket.");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Visitor ID not found.");
		}
		return false;
	}

	public boolean validateTicket(List<Ticket> visitorTickets) {
		String ticketNumberString = JOptionPane.showInputDialog("Enter the Ticket Number to validate:");
		if (ticketNumberString == null) {
			return false;
		}

		int ticketNumber;
		try {
			ticketNumber = Integer.parseInt(ticketNumberString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid Ticket Number. Please enter a numeric value.");
			return false;
		}

		for (Ticket ticket : visitorTickets) {
			if (ticket.getTicketNumber() == ticketNumber) {
				if (ticket.isCancellable() && (ticket.getExpiryDate().isAfter(SubMenu.date))) {
					ticket.setCancellable(false);
					JOptionPane.showMessageDialog(null, "Ticket " + ticketNumber + " has been validated.");
					return true;
				} else {

					if (ticket.getExpiryDate().isBefore(SubMenu.date)) {
						JOptionPane.showMessageDialog(null, "Sorry but your ticket " + ticketNumber + " is expired.");
						return false;
					} else if (ticket.getAnnual() == false && ticket.isCancellable() == false) {
						JOptionPane.showMessageDialog(null,
								"Sorry but your one time ticket " + ticketNumber + "is all ready validated .");
						return false;
					} else if (ticket.getAnnual() && (ticket.getExpiryDate().isAfter(SubMenu.date))) {
						JOptionPane.showMessageDialog(null, "You have annual ticket " + ticketNumber + ".");
						return true;

					}
				}
			}
		}

		JOptionPane.showMessageDialog(null, "Ticket Number not found.");
		return false;
	}

	public List<Ticket> getTicketsByVisitorId(List<Ticket> tickets, int visitorId) {
		List<Ticket> visitorTickets = new ArrayList<>();
		for (Ticket ticket : tickets) {
			if (ticket.getIdNumber() == visitorId) {
				visitorTickets.add(ticket);
			}
		}
		return visitorTickets;
	}
}
