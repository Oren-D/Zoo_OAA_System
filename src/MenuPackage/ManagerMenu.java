package MenuPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import EmployeePackage.EmployeeManager;
import EmployeePackage.PasswordManager;
import EmployeePackage.Worker;
import TicketPackage.Ticket;
import TicketPackage.TicketNumberGenerator;
import TicketPackage.TicketType;
import TicketPackage.TicketsManager;
import VisitorPackage.ObserverManager;
import VisitorPackage.Visitor;
import VisitorPackage.VisitorManager;
import CommonPackage.IdValidator;

public class ManagerMenu {
	private static EmployeeManager em = EmployeeManager.getInstance();
	private static PasswordManager pm = PasswordManager.getInstance();
	private static VisitorManager vm = VisitorManager.getInstance();
	private static TicketsManager tm = TicketsManager.getInstance();
	private static ObserverManager om = ObserverManager.getInstance();

	public void displayLoginAndRegistrationMenu1() {

		String[] actionTypes = { "Log In", "Employee Registration" };
		String type = (String) JOptionPane.showInputDialog(null, "Select the action type:", "....",
				JOptionPane.QUESTION_MESSAGE, null, actionTypes, actionTypes[0]);

		if (type == null) {
			return;

		} else if (type.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please choose a action type.");
		}
		switch (type) {
		case "Log In":
			if (LogIn()) {
				displayManagerMenu();
			}
			break;
		case "Employee Registration":
			addEmployee(Worker.class);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid selection.");
			break;

		}
	}

	public boolean LogIn() {
		JLabel nameLabel = new JLabel("User Name:");
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordManager.AdminPutter();
		JTextField nameField = new JTextField(10);
		JTextField PasswordField = new JTextField(10);

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(PasswordLabel);
		panel.add(PasswordField);

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the User Name and Password for loging ",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, " Loging cancelled.");
				return false;
			}
			if (nameField.getText().isEmpty() || PasswordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Hi friend!\nIn order to finish the enter full User Name and Correct Password ", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					String userName = nameField.getText();
					String password = PasswordField.getText();
					if (pm.checkUsernameAndPassword(userName, password)) {
						JOptionPane.showMessageDialog(null, "Welcome!", userName, JOptionPane.INFORMATION_MESSAGE);
						validInput = true;
						return true;
					} else {
						JOptionPane.showMessageDialog(null,
								"Invalid login or password!\n\nPlease enter valid values or registrate new user ",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input!\n\nPlease enter valid values ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (!validInput);
		return false;
	}

	private void addEmployee(Class<? extends Worker> workerClass) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel idLabel = new JLabel("Id:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel surnameLable = new JLabel("Surname:");
		JLabel birthDateLabel = new JLabel("Birth Date:");
		JLabel phoneNumberLabel = new JLabel("Phone number:");
		JLabel userNameLabel = new JLabel("User name:");
		JLabel passwordLabel = new JLabel("Password :");

		JTextField idField = new JTextField(10);
		JTextField nameField = new JTextField(10);
		JTextField surnameField = new JTextField(10);
		JTextField birthDateField = new JTextField(10);
		JTextField phoneNumberField = new JTextField(10);
		JTextField userNameField = new JTextField(10);
		JTextField passwordField = new JTextField(10);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(idLabel, gbc);
		panel.add(idField, gbc);
		panel.add(nameLabel, gbc);
		panel.add(nameField, gbc);
		panel.add(surnameLable, gbc);
		panel.add(surnameField, gbc);
		panel.add(birthDateLabel, gbc);
		panel.add(birthDateField, gbc);
		panel.add(phoneNumberLabel, gbc);
		panel.add(phoneNumberField, gbc);
		panel.add(userNameLabel, gbc);
		panel.add(userNameField, gbc);
		panel.add(passwordLabel, gbc);
		panel.add(passwordField, gbc);

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for the new ",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, " addition cancelled.");
				return;
			}
			if (idField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty()
					|| birthDateField.getText().isEmpty() || phoneNumberField.getText().isEmpty()
					|| userNameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Hi friend!\nIn order to finish the registration of visitor you have to enter all the data\"",
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {

					if (IdValidator.idValidator(Integer.parseInt(idField.getText())) != false) {
						validInput = true;
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid id ", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid id ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (!validInput);

		try {
			Constructor<? extends Worker> constructor = workerClass.getConstructor(int.class, String.class,
					String.class, String.class, int.class, String.class);
			String userName = userNameField.getText();
			String password = passwordField.getText();
			if (pm.UserNameCheck(userName)) {
				JOptionPane.showMessageDialog(null,
						"Hi friend!\nThis User Name is all ready used, please choose another ", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {
				int id = Integer.parseInt(idField.getText());
				int phoneNumber = Integer.parseInt(phoneNumberField.getText());
				Worker worker = constructor.newInstance(id, nameField.getText(), surnameField.getText(),
						birthDateField.getText(), phoneNumber, userNameField.getText());
				em.addWorker(worker);
				pm.addUser(userName, password);

			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding ");
		}

		JOptionPane.showMessageDialog(null, "Regestration complited ");

	}

	private void displayManagerMenu() {
		String[] actionTypes = { "Buy ticket", "Delete customer ticket or account", "Find active tickets by ID",
				"Search all tickets history Information", "Send advertisment"

		};

		String type = (String) JOptionPane.showInputDialog(null, "Select the action type:", "Manager Menu",
				JOptionPane.QUESTION_MESSAGE, null, actionTypes, actionTypes[0]);

		while (type != null) {
			type = type.trim();

			switch (type) {
			case "Buy ticket":
				buyTicket();
				break;

			case "Delete customer ticket or account":
				deleteTicket();
				break;

			case "Find active tickets by ID":
				findTicketById();
				break;

			case "Search all tickets history Information":
				searchInformationOfAllTickets();
				break;

			case "Send advertisment":
				SendAdvertisment();

				break;

			default:
				JOptionPane.showMessageDialog(null, "Invalid selection.");
				break;
			}

			type = (String) JOptionPane.showInputDialog(null, "Select the action type:", "Manager Menu",
					JOptionPane.QUESTION_MESSAGE, null, actionTypes, actionTypes[0]);
		}

		JOptionPane.showMessageDialog(null, "Exiting Manager Menu.");
	}

	private void SendAdvertisment() {
		String additionalMessage = JOptionPane.showInputDialog("Enter advertisment message:");
		if (additionalMessage == null) {
			JOptionPane.showMessageDialog(null, "Message input canceled.");
			return;
		}
		om.sendMessage(additionalMessage);

		JOptionPane.showMessageDialog(null, "Message was sent.");
	}

	private void buyTicket() {
		int ticketNumber = TicketNumberGenerator.generateTicketNumber();
		int finalID = 0;
		boolean validInput = false;
		boolean validInput2 = true;

		while (!validInput) {
			String[] ticketOptions = new String[TicketType.values().length];
			for (int i = 0; i < TicketType.values().length; i++) {
				ticketOptions[i] = TicketType.values()[i].toString();
			}

			String ticketChoice = (String) JOptionPane.showInputDialog(null, "Please choose a Ticket:",
					"Ticket Selection", JOptionPane.PLAIN_MESSAGE, null, ticketOptions, ticketOptions[0]);

			if (ticketChoice == null) {
				JOptionPane.showMessageDialog(null, "Ticket purchase canceled.");
				return;
			}

			TicketType newTicket = TicketType.valueOf(ticketChoice);

			String[] chooseType = { "Yes", "No" };
			String answer = (String) JOptionPane.showInputDialog(null, "Do you have a visitor account?", "....",
					JOptionPane.QUESTION_MESSAGE, null, chooseType, chooseType[0]);

			if (answer == null) {
				JOptionPane.showMessageDialog(null, "Ticket purchase canceled.");
				return;
			}

			if (answer.equals("Yes")) {
				boolean idCheck = false;
				while (!idCheck) {
					String idInput = JOptionPane
							.showInputDialog("Please enter your id (type or press 'cancel' to exit)");
					if (idInput == null || idInput.equalsIgnoreCase("cancel")) {
						JOptionPane.showMessageDialog(null, "Ticket purchase canceled.");
						return;
					}
					try {
						int id = Integer.parseInt(idInput);
						idCheck = vm.visitorExists(vm.getVisitor(), id);
						if (idCheck) {
							vm.visitorTicketAdding(vm.getVisitor(), id, newTicket);
							LocalDate issueDate = SubMenu.date;
							tm.addTicket(new Ticket(ticketNumber, id, newTicket, newTicket.getPrice(), true,
									newTicket.getAnnual(), issueDate));

							JOptionPane.showMessageDialog(null, "Perfect, your ticket was added to your account");
							validInput2 = false;
							validInput = true;

						} else {
							JOptionPane.showMessageDialog(null, "ID not found. Please try again.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a valid number.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (answer.equals("No")) {
				JOptionPane.showMessageDialog(null, "Please fill out a registration form.");
				finalID = addVisitor(Visitor.class, newTicket);
				if (finalID != 0) {
					validInput = true;
				}
			}

			if (validInput && validInput2) {
				LocalDate issueDate = SubMenu.date;
				tm.addTicket(new Ticket(ticketNumber, finalID, newTicket, newTicket.getPrice(), true,
						newTicket.getAnnual(), issueDate));
				JOptionPane.showMessageDialog(null, "Adding succeeded");
			}
		}

	}

	private static void searchInformationOfAllTickets() {
		String[] actionTypes = { "Print all tickets history by ID", "Print tickets history by specific date" };
		String type = (String) JOptionPane.showInputDialog(null, "Select the action type:", "....",
				JOptionPane.QUESTION_MESSAGE, null, actionTypes, actionTypes[0]);
		if (type == null) {
			return;
		}
		if (type.equals("Print all tickets history by ID")) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter visitor id to find ticket"));
			if (!vm.visitorExists(vm.getVisitor(), id)) {
				JOptionPane.showMessageDialog(null, "Visitor not found", "Ticket Information",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			StringBuilder message = new StringBuilder();
			message.append("Ticket Information:\n");
			message.append("-------------------\n");

			List<Ticket> tickets = tm.getTicket();

			for (Ticket ticket : tickets) {
				if (ticket.getId() == id) {
					message.append("Ticket Number: ").append(ticket.getTicketNumber()).append("\n");
					message.append("Visitor ID: ").append(ticket.getIdNumber()).append("\n");
					message.append("Ticket Type: ").append(ticket.getTicketType()).append("\n");
					message.append("Price: ").append(ticket.getPrice()).append("\n");
					message.append("Cancellable: ").append(ticket.isCancellable()).append("\n");
					message.append("Issue Date: ").append(ticket.getIssueDate()).append("\n");
					message.append("Expiry Date: ").append(ticket.getExpiryDate()).append("\n");
					message.append("-------------------\n");
				}
			}
			JOptionPane.showMessageDialog(null, message.toString(), "Ticket Information",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (type.equals("Print tickets history by specific date")) {

			try {
				LocalDate dateOfPurchase = LocalDate
						.parse(JOptionPane.showInputDialog("Enter specific date (format: yyyy-MM-dd): "));
				List<Ticket> purchasedTickets = tm.getTicketsByDate(dateOfPurchase);
				if (purchasedTickets.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tickets found for the entered date.", "Ticket Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				StringBuilder message = new StringBuilder("Ticket Information:\n");
				message.append("-------------------\n");
				message.append("Ticket Number: ").append(tm.getTicketNumberByDate(purchasedTickets, dateOfPurchase))
						.append("\n");
				message.append("Visitor ID: ").append(tm.getBuyerIdByDate(purchasedTickets, dateOfPurchase))
						.append("\n");
				message.append("Ticket Type: ").append(tm.getTicketTypeByDate(purchasedTickets, dateOfPurchase))
						.append("\n");
				message.append("Price: ").append(tm.getTicketPriceByDate(purchasedTickets, dateOfPurchase))
						.append("\n");
				message.append("Cancellable: ")
						.append(tm.getTicketStatusCancelableByDate(purchasedTickets, dateOfPurchase)).append("\n");
				message.append("Issue Date: ").append(tm.getTicketIssueByDate(purchasedTickets, dateOfPurchase))
						.append("\n");
				message.append("Expiry Date: ").append(tm.getTicketExpiryByDate(purchasedTickets, dateOfPurchase))
						.append("\n");
				message.append("-------------------\n");

				JOptionPane.showMessageDialog(null, message.toString(), "Ticket Information",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Invalid date format. Please enter in yyyy-MM-dd format.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	public void findTicketById() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter visitor id to find ticket"));
		if (!vm.visitorExists(vm.getVisitor(), id)) {
			JOptionPane.showMessageDialog(null, "Visitor not found", "Ticket Information", JOptionPane.ERROR_MESSAGE);
			return;
		}
		List<Ticket> tickets = tm.getTicket();

		StringBuilder message = new StringBuilder();

		for (Ticket ticket : tickets) {
			if ((ticket.getId() == id) && (ticket.getTicketType() != null) && (ticket.isCancellable() != false)
					&& ticket.getExpiryDate().isAfter(SubMenu.date)) {
				message.append("Ticket Number: ").append(ticket.getTicketNumber()).append("\n");
				message.append("Visitor ID: ").append(ticket.getIdNumber()).append("\n");
				message.append("Ticket Type: ").append(ticket.getTicketType()).append("\n");
				message.append("Price: ").append(ticket.getPrice()).append("\n");
				message.append("Cancellable: ").append(ticket.isCancellable()).append("\n");
				message.append("Issue Date: ").append(ticket.getIssueDate()).append("\n");
				message.append("Expiry Date: ").append(ticket.getExpiryDate()).append("\n");
				message.append("-------------------\n");
			}
		}
		TicketType ticket = vm.visitorTicket(vm.getVisitor(), id);
		if (ticket == null) {
			JOptionPane.showMessageDialog(null, "Ticket not found for this visitor", "Ticket Information",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(null, message.toString(), "Ticket Information", JOptionPane.INFORMATION_MESSAGE);
	}

	public int getVisitorId() {
		int id = 0;
		id = Integer.parseInt(JOptionPane.showInputDialog("Enter visitor id to find ticket"));
		if (id == 0) {
			return 0;
		}
		return id;
	}

	public boolean checkTicket() {
		int id = getVisitorId();
		if (!vm.visitorExists(vm.getVisitor(), id)) {
			JOptionPane.showMessageDialog(null, "Visitor not found , please sign up via employee", "Ticket Information",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		List<Ticket> ticketIds = new ArrayList<>();

		for (Ticket ticket : tm.getTickets()) {
			if (ticket.getId() == id) {
				ticketIds.add(ticket);
			}
		}

		if (ticketIds.isEmpty()) {

			JOptionPane.showMessageDialog(null, "No tickets found for this visitor , please buy a ticket",
					"Ticket Information", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		while (true) {

			StringBuilder ticketList = new StringBuilder("Select a ticket:\n");
			for (int i = 0; i < ticketIds.size(); i++) {
				ticketList.append(i + 1).append(". Ticket ").append(ticketIds.get(i).getTicketNumber() + "\n");
			}
			String ticketChoice = JOptionPane.showInputDialog(null, ticketList.toString(), "Select Ticket",
					JOptionPane.PLAIN_MESSAGE);

			if (ticketChoice == null) {
				return false;
			}

			try {
				int choice = Integer.parseInt(ticketChoice);
				if (choice < 1 || choice > ticketIds.size()) {
					JOptionPane.showMessageDialog(null, "Invalid selection. Please choose a valid ticket.", "Error",
							JOptionPane.ERROR_MESSAGE);
					continue;
				}

				Ticket selectedTicket = ticketIds.get(choice - 1);
				int ticketID = Integer.parseInt("" + selectedTicket.getId());
				TicketType ticketType = vm.visitorTicket(vm.getVisitor(), id);
				if (ticketType == null) {
					JOptionPane.showMessageDialog(null, "Ticket details not found for this ticket.",
							"Ticket Information", JOptionPane.ERROR_MESSAGE);
					return false;
				}

				StringBuilder message = new StringBuilder("Ticket Information:\n");
				message.append("-------------------\n");
				message.append("Ticket Number: ").append(selectedTicket.getTicketNumber()).append("\n");
				message.append("Visitor ID: ").append(ticketID).append("\n");
				message.append("Ticket Type: ").append(selectedTicket.getTicketType()).append("\n");
				message.append("Price: ").append(selectedTicket.getPrice()).append("\n");
				message.append("Cancellable: ").append(selectedTicket.isCancellable()).append("\n");
				message.append("Issue Date: ").append(selectedTicket.getIssueDate()).append("\n");
				message.append("Expiry Date: ").append(selectedTicket.getExpiryDate()).append("\n");
				message.append("-------------------\n");

				int option = JOptionPane.showConfirmDialog(null, message.toString(), "Ticket Information",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					return true;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private static void deleteTicket() {
		String idString = JOptionPane.showInputDialog("Enter visitor id to delete ticket");
		if (idString == null) {
			return;
		}

		int idToDelete;
		try {
			idToDelete = Integer.parseInt(idString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid ID. Please enter a numeric ID.");
			return;
		}

		while (true) {
			if (!vm.visitorExists(vm.getVisitor(), idToDelete)) {
				JOptionPane.showMessageDialog(null, "Visitor account does not exist");
				return;
			}

			String[] actionTypes = { "Delete Ticket", "Delete Account", "Cancel" };
			String type = (String) JOptionPane.showInputDialog(null, "Select the action type:", "....",
					JOptionPane.QUESTION_MESSAGE, null, actionTypes, actionTypes[0]);

			if (type == null || type.equals("Cancel")) {
				return;
			}

			if (type.equals("Delete Ticket")) {
				List<TicketType> availableTickets = tm.getTicketsById(idToDelete);

				if (availableTickets.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No tickets found for this visitor.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				TicketType[] ticketOptions = availableTickets.toArray(new TicketType[0]);
				TicketType ticketTypeToDelete = (TicketType) JOptionPane.showInputDialog(null,
						"Select the ticket type to delete:", "Delete Ticket", JOptionPane.QUESTION_MESSAGE, null,
						ticketOptions, ticketOptions[0]);

				if (ticketTypeToDelete == null) {
					return;
				}

				if (tm.deleteTicketFromList(tm.getTicket(), idToDelete, ticketTypeToDelete)) {
					JOptionPane.showMessageDialog(null, "Ticket deleted");
				} else {
					JOptionPane.showMessageDialog(null, "No such ticket found for this visitor", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (type.equals("Delete Account")) {
				vm.removeVisitor(vm.getVisitor(), idToDelete);
				JOptionPane.showMessageDialog(null, "Your account deleted");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid action type");
			}
		}
	}

	public static int addVisitor(Class<? extends Visitor> visitorClass, TicketType newticket) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel idLabel = new JLabel("Id:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel surnameLable = new JLabel("Surname:");
		JLabel birthDateLabel = new JLabel("Birth Date:");
		JLabel phoneNumberLabel = new JLabel("Phone number:");

		JTextField idField = new JTextField(10);
		JTextField nameField = new JTextField(10);
		JTextField surnameField = new JTextField(10);
		JTextField birthDateField = new JTextField(10);
		JTextField phoneNumberField = new JTextField(10);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(idLabel, gbc);
		panel.add(idField, gbc);
		panel.add(nameLabel, gbc);
		panel.add(nameField, gbc);
		panel.add(surnameLable, gbc);
		panel.add(surnameField, gbc);
		panel.add(birthDateLabel, gbc);
		panel.add(birthDateField, gbc);
		panel.add(phoneNumberLabel, gbc);
		panel.add(phoneNumberField, gbc);

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for the new ",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
				JOptionPane.showMessageDialog(null, " addition cancelled.");
				return 0;
			}
			if (idField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty()
					|| birthDateField.getText().isEmpty() || phoneNumberField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Hi friend!\nIn order to finish the registration of visitor you have to enter all the data\"",
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {

					if (IdValidator.idValidator(Integer.parseInt(idField.getText()))) {
						validInput = true;
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid id ", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid values for id ", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (!validInput);

		try {
			Constructor<? extends Visitor> constructor = visitorClass.getConstructor(int.class, String.class,
					String.class, String.class, int.class, TicketType.class);
			int id = Integer.parseInt(idField.getText());
			int phoneNumber = Integer.parseInt(phoneNumberField.getText());
			Visitor visitor = constructor.newInstance(id, nameField.getText(), surnameField.getText(),
					birthDateField.getText(), phoneNumber, newticket);
			vm.addVisitor(visitor);
			om.addObserer(visitor);
			return id;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding ");
		}

		return 0;
	}

	public static TicketType getUserChoice() {
		while (true) {
			String input = JOptionPane.showInputDialog("Please choose a ticket to buy (Enter ticket name):");
			if (input == null) {
				System.exit(0);
			}

			String ticketName = input.trim().toUpperCase();
			for (TicketType ticketType : TicketType.values()) {
				if (ticketType.getTicketName().toUpperCase().equals(ticketName)) {
					return ticketType;
				}
			}
			JOptionPane.showMessageDialog(null, "Invalid ticket name. Please try again.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}