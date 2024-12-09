package VisitorPackage;

import java.util.ArrayList;
import java.util.List;
import TicketPackage.TicketType;

public class VisitorManager {
	public static VisitorManager instance;
	private static List<Visitor> visitors = new ArrayList<>();

	static {
		Visitor hardcodedVisitor = new Visitor(123456789, "John", "Doe", "15/15/15", 0502225454,
				TicketType.ADULT_YEARLY);

		Visitor hardcodedVisitor1 = new Visitor(123123123, "Johny", "Doey", "15/15/15", 0502225455,
				TicketType.CHILD_ONE_TIME);
		visitors.add(hardcodedVisitor);
		visitors.add(hardcodedVisitor1);

	}
	public static VisitorManager getInstance() {
		if (instance == null) {
			instance = new VisitorManager();
		}
		return instance;
	}
	public void visitorTicketAdding(List<Visitor> visitors, int id, TicketType ticket) {
		for (Visitor visitor : visitors) {
			if (visitor.getId() == id) {
				visitor.setTicketType(ticket);
			}
		}
	}
	public TicketType visitorTicket(List<Visitor> visitors, int id) {
		for (Visitor visitor : visitors) {
			if (visitor.getId() == id) {
				return visitor.getTicketType();
			}
		}
		return null;
	}

	

	public boolean removeVisitor(List<Visitor> visitors, int id) {
		for (Visitor visitor : visitors) {
			if (visitor.getId() == id) {
				visitors.remove(visitor);
				return true;
			}
		}
		return false;
	}

	public boolean visitorExists(List<Visitor> visitors, int id) {

		for (Visitor visitor : visitors) {
			if (visitor.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void addVisitor(Visitor visitor) {
		getVisitor().add(visitor);
	}

	public List<Visitor> getVisitor() {
		return visitors;
	}

}
