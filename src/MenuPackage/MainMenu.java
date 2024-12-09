package MenuPackage;

import javax.swing.JOptionPane;

import zooPackage.InvalidAgeException;
import zooPackage.InvalidChoiceException;
import zooPackage.InvalidHeightException;
import zooPackage.TallerThanLeaderPenguinException;

public class MainMenu {

	private static ParkEntrance pe = new ParkEntrance();
	public static void main(String[] args) throws InvalidAgeException, InvalidHeightException,
			TallerThanLeaderPenguinException, InvalidChoiceException {

		showPreMenu();
	}

	public static void showPreMenu() {
		while (true) {
			String[] options = { "Employee Entrance", "Visitor Entrance", "Exit" };
			String choice = (String) JOptionPane.showInputDialog(null, "Please select one of the options below:",
					"Zoo Entrance", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (choice == null || choice.equals("Exit")) {
				JOptionPane.showMessageDialog(null, "Goodbye\nCome back soon!");
				System.exit(0);
			} else if (choice.equals("Employee Entrance")) {
				
				SubMenu.handleEmployeeEntrance();
			} else if (choice.equals("Visitor Entrance")) {
				if (pe.enterPark()) {
					SubMenu.handleVisitorEntrance();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
