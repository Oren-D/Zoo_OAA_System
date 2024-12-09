package VisitorPackage;

import javax.swing.JOptionPane;

import CommonPackage.Person;
import TicketPackage.TicketType;

public class Visitor extends Person implements Observer{

	protected TicketType ticketType;

	public Visitor(int id, String name, String surname, String birthDate, int phoneNumber, TicketType ticketType) {
		super(id, name, surname, birthDate, phoneNumber);
		this.ticketType = ticketType;
	}
	public int getId() {
        return id; 
    }
	public String getFirstName() {
		return name;
	}
	public String getLastName() {
		return name;
	}
	

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public void update(String message) {
		JOptionPane.showMessageDialog(null, "Notification to " + getFirstName() + " " + getLastName() + ": " + message);
	}

	
}
