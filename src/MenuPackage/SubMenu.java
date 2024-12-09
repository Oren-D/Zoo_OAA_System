package MenuPackage;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import zooPackage.Zoo;
import zooPackage.ZooManager;

public class SubMenu {
	private static Zoo zoo = new Zoo();
	private static ManagerMenu am = new ManagerMenu();
	public static LocalDate date = LocalDate.now();

	public static void handleEmployeeEntrance() {
	if(	am.LogIn()==false) {
		return;
	}
		JOptionPane.showMessageDialog(null, "Hello Employee!\nWelcome to our crazy zoo!\n\n(p.s. Turn up the volume)\n",
				"", JOptionPane.INFORMATION_MESSAGE);
		Zoo.defaultAnimals();
		while (true) {
			String[] options = { "Display Zoo Details", "Display Animals", "Add Animal", "Add one year", "Feed Animals",
					"Listening to Animals", "Visitors Management Center", "Back to Pre-Menu" };
			String userChoice = (String) JOptionPane.showInputDialog(null, "Please select one of the choices below:",
					zoo.getZooName() + " Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (userChoice == null || userChoice.equals("Back to Pre-Menu")) {
				MainMenu.showPreMenu();
				break;
			}

			switch (userChoice) {
			case "Display Zoo Details":
				ZooManager.printZooDetails();
				break;
			case "Display Animals":
				ZooManager.displayAnimalMenu();
				break;
			case "Add Animal":
				ZooManager.addAnimalMenu();
				break;
			case "Add one year":
				date = date.plusYears(1);
				JOptionPane.showMessageDialog(null, "Hey friend !\r\n"
						+ "This action made all the animals in the zoo grow a year!\r\n"
						+ "Congratulations to our amazing animals!\r\n" + "\r\n"
						+ "Just note that this action causes the mood {happiness} of the animals to drop\nIt's worth feeding them to lift the mood! :)",
						"Message", JOptionPane.INFORMATION_MESSAGE);
				ZooManager.deathNote();

				break;
			case "Feed Animals":
				ZooManager.feedAnimals();
				break;
			case "Listening to Animals":
				ZooManager.listeningToAllAnimals();
				break;
			case "Visitors Management Center":
				am.displayLoginAndRegistrationMenu1();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void handleVisitorEntrance() {

		JOptionPane.showMessageDialog(null, "Hello Visitor!\nWelcome to our crazy zoo!\n\n(p.s. Turn up the volume)\n",
				"", JOptionPane.INFORMATION_MESSAGE);
		Zoo.defaultAnimals();
		while (true) {
			String[] options = { "Display Zoo Details", "Display Animals", "Feed Animals", "Listening to Animals",
					"Back to Pre-Menu" };
			String userChoice = (String) JOptionPane.showInputDialog(null, "Please select one of the choices below:",
					zoo.getZooName() + " Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (userChoice == null || userChoice.equals("Back to Pre-Menu")) {
				MainMenu.showPreMenu();
				break;
			}

			switch (userChoice) {
			case "Display Zoo Details":
				ZooManager.printZooDetails();
				break;
			case "Display Animals":
				ZooManager.displayAnimalMenu();
				break;
			case "Feed Animals":
				ZooManager.feedAnimals();
				break;
			case "Listening to Animals":
				ZooManager.listeningToAllAnimals();
				break;
			case "Back to Pre-Menu":
				return;
			default:
				JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
