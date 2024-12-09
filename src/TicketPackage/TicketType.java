package TicketPackage;

public enum TicketType {
	ADULT_ONE_TIME("Adult", 71, false), ADULT_YEARLY("Adult", 330, true), CHILD_ONE_TIME("Child", 54, false),
	CHILD_YEARLY("Child", 245, true), STUDENT_ONE_TIME("Student", 54, false),
	STUDENT_YEARLY("Student", 245, true), SOLDIER_ONE_TIME("Soldier", 54, false),
	SOLDIER_YEARLY("Soldier", 245, true), SENIOR_ONE_TIME("Senior", 54, false), SENIOR_YEARLY("Senior", 245, false),
	DISABLED_ONE_TIME("Disabled", 35, false), DISABLED_YEARLY("Disabled", 245, true),
	YEARLY_COUPLE("Couple", 570, true), YEARLY_COUPLE_1_PLUS("Couple +1", 690, true),
	YEARLY_COUPLE_2_PLUS("Couple +2", 750, true), YEARLY_COUPLE_3_PLUS("Couple +3", 810, true),
	YEARLY_COUPLE_4_PLUS("Couple +4", 860, true), YEARLY_COUPLE_5_PLUS("Couple +4", 915, true),
	YEARLY_COUPLE_6_PLUS("Couple +4", 970, true), YEARLY_SINGLE_PARENT_1_PLUS("Parent +1", 515, true),
	YEARLY_SINGLE_PARENT_2_PLUS("Parent +2", 665, true), YEARLY_SINGLE_PARENT_3_PLUS("Parent +3", 735, true),
	YEARLY_SINGLE_PARENT_4_PLUS("Parent +4", 755, true), YEARLY_SINGLE_PARENT_5_PLUS("Parent +5", 795, true),
	YEARLY_SINGLE_PARENT_6_PLUS("Parent +6", 830, true),CUSTOM("",0,true);

	private final String ticketName;
	private final int price;
	private final boolean annual;

	TicketType(String cardName, int price, boolean annual) {
		this.price = price;
		this.ticketName = cardName;
		this.annual = annual;
	}

	public boolean getAnnual() {
		return annual;
	}

	public int getPrice() {
		return price;
	}

	public String getTicketName() {
		return ticketName;
	}

}