package zooPackage;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ZooManager {

	static Zoo zoo = new Zoo();


	public static void addAnimalMenu() {
		String[] animalTypes = { "Herbivore", "Predator", "Reptile", "Bird", "Fish", "Insects" };
		String type = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Add Animal",
				JOptionPane.QUESTION_MESSAGE, null, animalTypes, animalTypes[0]);

		if (type == null) {
			return;

		} else if (type.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please choose a animal type.");
		}
		switch (type) {
		case "Herbivore":
			String[] herbivoreTypes = { "Zebra", "Elephant" };
			String herbivoreType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Add Animal",
					JOptionPane.QUESTION_MESSAGE, null, herbivoreTypes, herbivoreTypes[0]);

			if (herbivoreType == null) {
				return;
			}

			if (herbivoreType == "Zebra") {
				addHerbivore(Zebra.class);
			} else
				addHerbivore(Elephant.class);

			break;
		case "Predator":
			String[] predatorTypes = { "Tiger", "Lion" };
			String predatorType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Add Animal",
					JOptionPane.QUESTION_MESSAGE, null, predatorTypes, predatorTypes[0]);

			if (predatorType == null) {
				return;
			}

			if (predatorType == "Tiger") {
				addPredator(Tiger.class);
			} else
				addPredator(Lion.class);

			break;
		case "Reptile":
			String[] reptileTypes = { "Snake", "Turtle" };
			String reptileType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Add Animal",
					JOptionPane.QUESTION_MESSAGE, null, reptileTypes, reptileTypes[0]);

			if (reptileType == null) {
				return;
			}

			if (reptileType == "Snake") {
				addReptile(Snake.class);
			} else
				addReptile(Turtle.class);

			break;
		case "Bird":
			String[] birdTypes = { "Penguin", "Parrot" };
			String birdType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Add Animal",
					JOptionPane.QUESTION_MESSAGE, null, birdTypes, birdTypes[0]);

			if (birdType == null) {
				return;
			}

			if (birdType == "Penguin") {
				addBird(Penguin.class);
			} else
				addBird(Parrot.class);

			break;
		case "Fish":
			addFish();
			break;
		case "Insects":
			String[] insectTypes = { "Spider", "Bee" };
			String insectType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Add Animal",
					JOptionPane.QUESTION_MESSAGE, null, insectTypes, insectTypes[0]);

			if (insectType == null) {
				return;
			}

			if (insectType == "Spider") {
				addInsect(Spider.class);
			} else
				addInsect(Bee.class);

			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid selection.");
			break;
		}

	}

	public static void displayAnimalMenu() {
		String[] animalTypes = { "Herbivore", "Predator", "Reptile", "Bird", "Fish", "Insects", "All the animals" };
		String type = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Display Animal",
				JOptionPane.QUESTION_MESSAGE, null, animalTypes, animalTypes[0]);

		if (type == null) {
			return;

		} else if (type.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please choose a animal type.");
		}
		switch (type) {
		case "Herbivore":
			String[] herbivoreTypes = { "Zebra", "Elephant" };
			String herbivoreType = (String) JOptionPane.showInputDialog(null, "Select the animal type:",
					"Display Animal", JOptionPane.QUESTION_MESSAGE, null, herbivoreTypes, herbivoreTypes[0]);

			if (herbivoreType == null) {
				return;
			}

			if (herbivoreType == "Zebra") {
				displayAnimalsByType(Zebra.class);
			} else
				displayAnimalsByType(Elephant.class);

			break;
		case "Predator":
			String[] predatorTypes = { "Tiger", "Lion" };
			String predatorType = (String) JOptionPane.showInputDialog(null, "Select the animal type:",
					"Display Animal", JOptionPane.QUESTION_MESSAGE, null, predatorTypes, predatorTypes[0]);

			if (predatorType == null) {
				return;
			}

			if (predatorType == "Tiger") {
				displayAnimalsByType(Tiger.class);
			} else
				displayAnimalsByType(Lion.class);

			break;
		case "Reptile":
			String[] reptileTypes = { "Snake", "Turtle" };
			String reptileType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Display Animal",
					JOptionPane.QUESTION_MESSAGE, null, reptileTypes, reptileTypes[0]);

			if (reptileType == null) {
				return;
			}

			if (reptileType == "Snake") {
				displayAnimalsByType(Snake.class);
			} else
				displayAnimalsByType(Turtle.class);

			break;
		case "Bird":
			String[] birdTypes = { "Penguin", "Parrot" };
			String birdType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Display Animal",
					JOptionPane.QUESTION_MESSAGE, null, birdTypes, birdTypes[0]);
			boolean flag1 = true;
			if (birdType == null) {
				return;
			}
			switch (birdType) {
			case "Penguin":
				do {
					String sortInput = JOptionPane.showInputDialog(null,
							"How would you like to manage the penguins?\n\n"
									+ "1. Sort by name in ascending alphabetical order\n"
									+ "2. Sort by height in descending order\n" + "3. Sort by age in ascending order\n"
									+ "4. Display without sorting\n\n");
					if (sortInput == null) {
						JOptionPane.showMessageDialog(null, "Sort operation cancelled.");
						return;
					}
					try {
						int userChoice = Integer.parseInt(sortInput);
						if (userChoice < 1 || userChoice > 4) {
							throw new InvalidChoiceException(
									"Invalid choice!\n\nPlease choose:\nFor sorting by name: 1\n"
											+ "For sorting by height: 2\n" + "For sorting by age: 3\n"
											+ "For displaing without sorting: 4\n");
						} else {
							flag1 = false;
							if (userChoice >= 1 || userChoice <= 3) {
								Zoo.sortPenguins(userChoice);
								displayAnimalsByType(Penguin.class);
							} else {
								displayAnimalsByType(Penguin.class);
							}
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Invalid input!\n\nPlease choose:\nFor sorting by name: 1\n"
										+ "For sorting by height: 2\n" + "For sorting by age: 3\n"
										+ "For displaing without sorting: 4\n",
								"Error", JOptionPane.ERROR_MESSAGE);
					} catch (InvalidChoiceException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						continue;
					}
				} while (flag1);
				break;
			case "Parrot":
				displayAnimalsByType(Parrot.class);
				flag1 = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid selection.");
				break;
			}

			break;
		case "Fish":

			String[] fishTypes = { "The whole aquarium", "AquariumFish", "GoldFish", "ClownFish" };
			String fishType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Display Animal",
					JOptionPane.QUESTION_MESSAGE, null, fishTypes, fishTypes[0]);
			boolean flag = true;
			do {
				if (fishType == null) {
					return;
				}
				switch (fishType) {
				case "The whole aquarium":
					displayAquarium();
					flag = false;
					break;
				case "AquariumFish":
					displayAnimalsByType(AquariumFish.class);
					flag = false;
					break;
				case "GoldFish":
					displayAnimalsByType(GoldFish.class);
					flag = false;
					break;
				case "ClownFish":
					displayAnimalsByType(ClownFish.class);
					flag = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid selection.");
					break;
				}
			} while (flag);

			break;
		case "Insects":
			String[] insectTypes = { "Spider", "Bee" };
			String insectType = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Display Animal",
					JOptionPane.QUESTION_MESSAGE, null, insectTypes, insectTypes[0]);

			if (insectType == null) {
				return;
			}

			if (insectType == "Spider") {
				displayAnimalsByType(Spider.class);
			} else
				displayAnimalsByType(Bee.class);

			break;
		case "All the animals":
			displayAnimalsByType(Animals.class);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid selection.");
			break;
		}
	}

	public static void displayAnimalsByType(Class<? extends Animals> animalClass) {
		StringBuilder animalInfo = new StringBuilder();
		for (Animals animal : Zoo.getAnimal()) {
			if (animalClass.isInstance(animal)) {
				animalInfo.append(animal.toString()).append("\n");
			}
		}

		if (animalInfo.length() == 0) {
			JOptionPane.showMessageDialog(null, "No animals of type " + animalClass.getSimpleName() + " found.",
					animalClass.getSimpleName() + " Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			String backgroundImage = "resorces\\" + animalClass.getSimpleName() + ".jpg";
			float opacity = 0.4f;
			SwingUtilities.invokeLater(() -> {
				TextDisplay.showTextPane(animalInfo.toString(), backgroundImage, opacity,
						"The " + animalClass.getSimpleName() + " list");
			});
		}
	}

	public static void listeningToAllAnimals() {
		StringBuilder allNoises = new StringBuilder();

		for (Animals animal : Zoo.getAnimal()) {
			allNoises.append(animal.makeNoise()).append(" | ");
		}

		if (allNoises.length() > 0) {
			allNoises.setLength(allNoises.length() - 3);
		}
		String backgroundImage = "resorces\\noise.jpg";
		float opacity = 0.4f;
		SwingUtilities.invokeLater(() -> {
			TextDisplay.showTextPane(allNoises.toString(), backgroundImage, opacity, "The sound of the Animals");
		});
	}

	public static void feedAnimals() {
		Zoo.feedAllAnimals();
		JOptionPane.showMessageDialog(null, Zoo.feedAllAnimals(), "Daily Food Consumption",
				JOptionPane.INFORMATION_MESSAGE);
		Zoo.setDefaultHappinessAfterFeeding();
	}

	public static void printZooDetails() {

		JOptionPane.showMessageDialog(null, "Zoo name: " + zoo.getZooName() + "\nZoo address: " + zoo.getZooAddress()
				+ "\n\n\n" + "Predators\n Number of Lions: " + Zoo.countAnimalsByType(Lion.class) + "\n"
				+ " Number of Tigers: " + Zoo.countAnimalsByType(Tiger.class) + "\n\n"
				+ "Herbivores\n Number of Zebras: " + Zoo.countAnimalsByType(Zebra.class) + "\n"
				+ " Number of Elephants: " + Zoo.countAnimalsByType(Elephant.class) + "\n\n"
				+ "Reptiles\n Number of Snakes: " + Zoo.countAnimalsByType(Snake.class) + "\n" + " Number of Turtles: "
				+ Zoo.countAnimalsByType(Turtle.class) + "\n\n" + "Insects\n Number of Spiders: "
				+ Zoo.countAnimalsByType(Spider.class) + "\n" + " Number of Bees: " + Zoo.countAnimalsByType(Bee.class)
				+ "\n\n" + "Birds\n Number of Penguins: " + Zoo.countAnimalsByType(Penguin.class) + "\n\n"
				+ "Fish\n Number of Aquarium Fish: " + Zoo.countAnimalsByType(AquariumFish.class) + "\n"
				+ " Number of Gold Fish: " + Zoo.countAnimalsByType(GoldFish.class) + "\n" + " Number of Clown Fish: "
				+ Zoo.countAnimalsByType(ClownFish.class));
	}

	public static void deathNote() {
		Zoo.removeUnhappyOrOldAnimals(Zoo.getAnimal());
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                    FISH                                                                                          //                                        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void addFish() {
		String[] fishTypes = { "AquariumFish", "GoldFish", "ClownFish", "RandomFish" };
		String fishTypeName = (String) JOptionPane.showInputDialog(null, "Select the animal type:", "Display Animal",
				JOptionPane.QUESTION_MESSAGE, null, fishTypes, fishTypes[0]);

		if (fishTypeName == null) {
			return;
		}

		JLabel ageLabel = new JLabel("Age:");
		JLabel lengthLabel = new JLabel("Length:");
		JLabel patternLabel = new JLabel("Pattern:");
		JLabel colorLabel = new JLabel("Color:");
		JLabel colorsLabel = new JLabel("Use Ctrl Key for adding more then 1 color");

		JTextField ageField = new JTextField(10);
		JTextField lengthField = new JTextField(10);
		JComboBox<Pattern> patternBox = new JComboBox<>(Pattern.values());

		JComboBox<Colors> colorBox = new JComboBox<>(
				new Colors[] { Colors.ORANGE, Colors.GOLD, Colors.YELLOW, Colors.BLACK });

		JList<Colors> colorList = new JList<>(Colors.values());
		colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane colorScrollPane = new JScrollPane(colorList);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;

		int padding = 10;

		panel.add(ageLabel, gbc);
		gbc.gridy++;
		panel.add(ageField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);
		panel.add(lengthLabel, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lengthField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);

		if (fishTypeName == "AquariumFish") {
			panel.add(patternLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(patternBox, gbc);
			gbc.insets = new Insets(padding, 0, 0, 0);
			gbc.gridy++;
			panel.add(colorLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			panel.add(colorsLabel, gbc);
			gbc.gridy++;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(colorScrollPane, gbc);
			gbc.insets = new Insets(padding, 0, 0, 0);

		} else if (fishTypeName == "GoldFish") {
			panel.add(colorLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(colorBox, gbc);
		}

		else if (fishTypeName == "RandomFish") {
			boolean flag = true;
			do {
				String numberInput = JOptionPane.showInputDialog(null, "How many random fish do you want to add?");
				if (numberInput == null) {
					JOptionPane.showMessageDialog(null, "Random fish addition cancelled.");
					return;
				}
				int numberOfFish;
				try {
					numberOfFish = Integer.parseInt(numberInput);
					if (numberOfFish < 1) {
						throw new InvalidChoiceException("Invalid choice!\nPlease enter a positive number.");
					} else {
						flag = false;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid input!\nPlease enter a valid positive number.",
							"Error", JOptionPane.ERROR_MESSAGE);
					continue;
				} catch (InvalidChoiceException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					continue;
				}

				Zoo.addRandomFish(numberOfFish);
				JOptionPane.showMessageDialog(null, numberOfFish + " random fish added successfully!");
				return;
			} while (flag);
			flag = false;
		}

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for " + fishTypeName,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, fishTypeName + " addition cancelled.");
				return;
			}

			boolean dataComplete = !ageField.getText().isEmpty() && !lengthField.getText().isEmpty();

			if (fishTypeName.equals("AquariumFish"))
				dataComplete = dataComplete && !colorList.getSelectedValuesList().isEmpty();

			if (fishTypeName.equals("GoldFish"))
				dataComplete = dataComplete && colorBox.getSelectedIndex() > 0;

			if (!dataComplete) {
				JOptionPane.showMessageDialog(null, "Hi friend!\nIn order to finish the " + fishTypeName
						+ " addition you have to enter all the data", "Warning", JOptionPane.WARNING_MESSAGE);

			} else {
				try {
					int age = Integer.parseInt(ageField.getText());
					double length = Double.parseDouble(lengthField.getText());
					validateFish(age, length, fishTypeName);
					validInput = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid values for age and length.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidAgeException | InvalidLengthException e) {
					JOptionPane.showMessageDialog(null, ((Throwable) e).getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
					lengthField.setText("");
				}
			}
		} while (!validInput || result == JOptionPane.OK_OPTION
				&& (ageField.getText().isEmpty() || lengthField.getText().isEmpty()));

		int age = Integer.parseInt(ageField.getText());
		double length = Double.parseDouble(lengthField.getText());
		Pattern pattern = (Pattern) patternBox.getSelectedItem();
		Colors[] selectedColors = colorList.getSelectedValuesList().toArray(new Colors[0]);
		Colors color = (Colors) colorBox.getSelectedItem();

		if (fishTypeName == "AquariumFish") {
			Fish fish = new AquariumFish(age, length, pattern, selectedColors, 100);
			Zoo.addAnimal(fish);

		} else if (fishTypeName == "GoldFish") {
			Fish fish = new GoldFish(age, length, color, 100);
			Zoo.addAnimal(fish);

		} else if (fishTypeName == "ClownFish") {
			Fish fish = new ClownFish(age, length, 100);
			Zoo.addAnimal(fish);
		}

		JOptionPane.showMessageDialog(null, fishTypeName + " added successfully!");
		Music.playMusic("resorces\\Fish.wav");

	}

	public static void displayAquarium() {
		List<Animals> fishes = Zoo.getAnimal().stream().filter(animal -> animal instanceof Fish)
				.collect(Collectors.toList());

		StringBuilder allFish = new StringBuilder();
		StringBuilder allFishColor = new StringBuilder();

		for (int i = 0; i < fishes.size(); i++) {
			allFish.append("Fish ").append(i + 1).append(": ").append(fishes.get(i)).append("\n");
		}

		int colorCounter = 0;
		Colors[][] colorCheck = new Colors[fishes.size()][];
		for (int i = 0; i < fishes.size(); i++) {
			colorCheck[i] = ((Fish) fishes.get(i)).getColor();
			colorCounter += colorCheck[i].length;
		}

		Colors[] colorsLine = new Colors[colorCounter];
		colorCounter = 0;
		for (Colors[] colors : colorCheck) {
			for (Colors color : colors) {
				colorsLine[colorCounter++] = color;
			}
		}

		LinkedHashSet<Colors> uniqueColorsSet = new LinkedHashSet<>(Arrays.asList(colorsLine));

		for (Colors color : uniqueColorsSet) {
			allFishColor.append(color).append(" | ");
		}

		String aquariumContent = "Number of fish in aquarium is: " + fishes.size() + "\n" + allFish.toString()
				+ "\nNumber of colors the fish contain: " + uniqueColorsSet.size() + "\n" + allFishColor.toString()
				+ "\n\nMost dominant colors:\n" + zoo.dominantColors();

		String backgroundImage = "resorces\\aquarium.jpg";
		float opacity = 0.4f;
		SwingUtilities.invokeLater(() -> {
			TextDisplay.showTextPane(aquariumContent, backgroundImage, opacity, "Aquarium");
		});
	}

	public static void validateFish(int age, double length, String animalType)
			throws InvalidAgeException, InvalidLengthException {
		int maxLifeSpan;
		double maxLength = Zoo.getMaxFishLength();

		if ("AquariumFish".equals(animalType))
			maxLifeSpan = AquariumFish.LIFE_SPAN;
		else if ("GoldFish".equals(animalType))
			maxLifeSpan = GoldFish.LIFE_SPAN;

		else if ("ClownFish".equals(animalType)) {
			maxLifeSpan = ClownFish.LIFE_SPAN;

		} else {
			throw new IllegalArgumentException("Unknown fish type: " + animalType);
		}

		if (age < Zoo.getMinAge() || age > maxLifeSpan) {
			throw new InvalidAgeException(
					"Age must be greater than " + Zoo.getMinAge() + " and less than " + maxLifeSpan + " years.");
		}

		if (length < Zoo.getMinFishLength() || length > maxLength) {
			throw new InvalidAgeException(
					"Length must be longer than " + Zoo.getMinFishLength() + " and less than " + maxLength + " cm.");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                    BIRD                                                                                          //                                        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void addBird(Class<? extends Bird> birdClass) {
		String animalTypeName = birdClass.getSimpleName(); // Currently "Penguin", but flexible for future bird types

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel nameLabel = new JLabel("Name:");
		JLabel ageLabel = new JLabel("Age:");
		JLabel heightLabel = new JLabel("Height:");

		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(10);
		JTextField heightField = new JTextField(10);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(nameLabel, gbc);
		panel.add(nameField, gbc);
		panel.add(ageLabel, gbc);
		panel.add(ageField, gbc);
		panel.add(heightLabel, gbc);
		panel.add(heightField, gbc);

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for the new " + animalTypeName,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, animalTypeName + " addition cancelled.");
				return;
			}
			if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || heightField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Hi friend!\nIn order to finish the " + animalTypeName.toLowerCase()
						+ " addition you have to enter all the data", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					// Assuming validatePenguin is specific; replace or generalize validation as
					// needed
					validatePenguin(Integer.parseInt(ageField.getText()), Double.parseDouble(heightField.getText()));
					validInput = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid values for age and height.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidAgeException | InvalidHeightException | TallerThanLeaderPenguinException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
					heightField.setText("");
				}
			}
		} while (!validInput);

		try {
			Constructor<? extends Bird> constructor = birdClass.getConstructor(String.class, int.class, double.class,
					int.class);
			Bird bird = constructor.newInstance(nameField.getText(), Integer.parseInt(ageField.getText()),
					Double.parseDouble(heightField.getText()), 100);
			Zoo.addAnimal(bird);
			JOptionPane.showMessageDialog(null, animalTypeName + " added successfully!");
			// Adjust music path according to your project structure
			Music.playMusic("resorces\\" + animalTypeName + ".wav");
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding " + animalTypeName + ".");
		}
	}

	public static void validatePenguin(int age, double height)
			throws InvalidAgeException, InvalidHeightException, TallerThanLeaderPenguinException {
		if (height > Zoo.getMainPenguinHeight()) {
			throw new TallerThanLeaderPenguinException(
					"This penguin is taller than the current leader {" + Zoo.getMainPenguinHeight() + " cm}.");
		}
		if (age < Zoo.getMinAge() || age > Penguin.LIFE_SPAN) {
			throw new InvalidAgeException(
					"Age must be greater than " + Zoo.getMinAge() + " and less than " + Penguin.LIFE_SPAN + " years.");
		}
		if (height < Zoo.getMinPenguinHeight() || height > Zoo.getMainPenguinHeight()) {
			throw new InvalidHeightException("Height must be higher than " + Zoo.getMinPenguinHeight()
					+ " and less than " + Zoo.getMainPenguinHeight() + " cm.");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                         INSECT                                                                                   //                                        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void addInsect(Class<? extends Insects> insectClass) {
		String animalTypeName = insectClass.getSimpleName();

		JLabel ageLabel = new JLabel("Age:");
		JLabel venomousStatusLabel = new JLabel("Venomous:");
		JLabel spiderManStatusLabel = new JLabel("SpiderMan:");
		JLabel colorLabel = new JLabel("Color:");
		JLabel patternLabel = new JLabel("Pattern:");

		JTextField ageField = new JTextField(10);
		JComboBox<StatusCheck> venomousStatusBox = new JComboBox<>(StatusCheck.values());
		JComboBox<StatusCheck> spiderManStatusBox = new JComboBox<>(StatusCheck.values());
		JComboBox<Colors> colorBox = new JComboBox<>(Colors.values());
		JComboBox<Pattern> patternBox = new JComboBox<>(Pattern.values());

		JList<Colors> colorList = new JList<>(Colors.values());
		colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		int padding = 10;

		panel.add(ageLabel, gbc);
		gbc.gridy++;
		panel.add(ageField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);
		panel.add(venomousStatusLabel, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(venomousStatusBox, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);

		if (insectClass == Spider.class) {
			panel.add(spiderManStatusLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			panel.add(spiderManStatusBox, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(padding, 0, 0, 0);
			panel.add(colorLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(colorBox, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(padding, 0, 0, 0);
			panel.add(patternLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			panel.add(patternBox, gbc);
		}

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for " + animalTypeName,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, animalTypeName + " addition cancelled.");
				return;
			}
			if (ageField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Hi friend!\nIn order to finish the " + animalTypeName
						+ " addition you have to enter all the data", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					int age = Integer.parseInt(ageField.getText());
					validateInsect(age, animalTypeName);
					validInput = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input!\n\nPlease enter valid values for age.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvalidAgeException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
				}
			}
		} while (!validInput || result == JOptionPane.OK_OPTION && ageField.getText().isEmpty());

		try {
			Constructor<? extends Insects> constructor = insectClass.getConstructor(int.class, StatusCheck.class,
					Colors[].class, Pattern.class, StatusCheck.class, int.class);
			Colors[] selectedColors = colorList.getSelectedValuesList().toArray(new Colors[0]);

			Insects insect = constructor.newInstance(Integer.parseInt(ageField.getText()),
					(StatusCheck) venomousStatusBox.getSelectedItem(), selectedColors,
					(Pattern) patternBox.getSelectedItem(), (StatusCheck) spiderManStatusBox.getSelectedItem(), 100);

			Zoo.addAnimal(insect);
			JOptionPane.showMessageDialog(null, animalTypeName + " added successfully!");
			Music.playMusic("resorces\\" + (animalTypeName.equals("Bee") ? "Bee.wav" : "Spider.wav"));
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding " + animalTypeName + ".");
		}
	}

	public static void validateInsect(int age, String animalType) throws InvalidAgeException {
		int maxLifeSpan;

		if ("Bee".equals(animalType)) {
			maxLifeSpan = Bee.LIFE_SPAN;

		} else if ("Spider".equals(animalType)) {
			maxLifeSpan = Spider.LIFE_SPAN;

		} else {
			throw new IllegalArgumentException("Unknown animal type: " + animalType);
		}

		if (age < Zoo.getMinAge() || age > maxLifeSpan) {
			throw new InvalidAgeException(
					"Age must be " + Zoo.getMinAge() + " or greater and less than " + maxLifeSpan + " years.");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                      HERBIVORE                                                                                   //                                        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void addHerbivore(Class<? extends Herbivore> herbivoreClass) {
		String animalTypeName = herbivoreClass.getSimpleName();

		JLabel nameLabel = new JLabel("Name:");
		JLabel ageLabel = new JLabel("Age:");
		JLabel weightLabel = new JLabel("Weight:");
		JLabel heightLabel = new JLabel("Height:");
		JLabel genderLabel = new JLabel("Gender:");

		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(10);
		JTextField weightField = new JTextField(10);
		JTextField heightField = new JTextField(10);
		JComboBox<Sex> genderBox = new JComboBox<>(Sex.values());

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(ageLabel);
		panel.add(ageField);
		panel.add(weightLabel);
		panel.add(weightField);
		panel.add(heightLabel);
		panel.add(heightField);
		panel.add(genderLabel);
		panel.add(genderBox);

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for " + animalTypeName,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, animalTypeName + " addition cancelled.");
				return;
			}
			if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || weightField.getText().isEmpty()
					|| heightField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Hi friend!\nIn order to finish the " + animalTypeName
						+ " addition you have to enter all the data", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					int age = Integer.parseInt(ageField.getText());
					double weight = Double.parseDouble(weightField.getText());
					double height = Double.parseDouble(heightField.getText());
					validateHerbivore(age, weight, height, animalTypeName);
					validInput = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Invalid input!\n\nPlease enter valid values for age, weight, and height.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvalidAgeException | InvalidWeightException | InvalidHeightException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
					weightField.setText("");
					heightField.setText("");
				}
			}
		} while (!validInput);

		try {
			Constructor<? extends Herbivore> constructor = herbivoreClass.getConstructor(String.class, int.class,
					double.class, double.class, Pattern.class, Sex.class, int.class);
			Herbivore herbivore = constructor.newInstance(nameField.getText(), Integer.parseInt(ageField.getText()),
					Double.parseDouble(weightField.getText()), Double.parseDouble(heightField.getText()), Pattern.LINES,
					(Sex) genderBox.getSelectedItem(), 100);

			Zoo.addAnimal(herbivore);
			JOptionPane.showMessageDialog(null, animalTypeName + " added successfully!");
			Music.playMusic("resorces\\" + animalTypeName + ".wav");
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding " + animalTypeName + ".");
		}
	}

	public static void validateHerbivore(int age, double weight, double height, String animalType)
			throws InvalidAgeException, InvalidWeightException, InvalidHeightException {
		int maxLifeSpan;
		double maxWeight;
		double maxHeight;
		if ("Zebra".equals(animalType)) {
			maxLifeSpan = Zebra.LIFE_SPAN;
			maxWeight = Zoo.getMaxZebraWeight();
			maxHeight = Zoo.getMaxZebraHeight();
		} else if ("Elephant".equals(animalType)) {
			maxLifeSpan = Elephant.LIFE_SPAN;
			maxWeight = Zoo.getMaxElephantWeight();
			maxHeight = Zoo.getMaxElephantHeight();
		} else {
			throw new IllegalArgumentException("Unknown animal type: " + animalType);
		}

		if (age < Zoo.getMinAge() || age > maxLifeSpan) {
			throw new InvalidAgeException(
					"Age must be greater than " + Zoo.getMinAge() + " and less than " + maxLifeSpan + " years.");
		}
		if (weight < Zoo.getMinHerbivoreWeight() || weight > maxWeight) {
			throw new InvalidWeightException("Weight must be greater than " + Zoo.getMinHerbivoreWeight()
					+ " and less than " + maxWeight + " kg.");
		}
		if (height < Zoo.getMinHerbivoreHeight() || height > maxWeight) {
			throw new InvalidHeightException(
					"Height must be higher than " + Zoo.getMinPenguinHeight() + " and less than " + maxHeight + " cm.");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                       PREDATOR                                                                                   //                                        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void addPredator(Class<? extends Predator> predatorClass) {
		String animalTypeName = predatorClass.getSimpleName();

		JLabel nameLabel = new JLabel("Name:");
		JLabel ageLabel = new JLabel("Age:");
		JLabel weightLabel = new JLabel("Weight:");
		JLabel genderLabel = new JLabel("Gender:");

		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(10);
		JTextField weightField = new JTextField(10);
		JComboBox<Sex> genderBox = new JComboBox<>(Sex.values());

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(ageLabel);
		panel.add(ageField);
		panel.add(weightLabel);
		panel.add(weightField);
		panel.add(genderLabel);
		panel.add(genderBox);

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for " + animalTypeName,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, animalTypeName + " addition cancelled.");
				return;
			}
			if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || weightField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Hi friend!\nIn order to finish the " + animalTypeName
						+ " addition you have to enter all the data", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					int age = Integer.parseInt(ageField.getText());
					double weight = Double.parseDouble(weightField.getText());
					validatePredator(age, weight, animalTypeName);
					validInput = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Invalid input!\n\nPlease enter valid values for age and weight.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvalidAgeException | InvalidWeightException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
					weightField.setText("");
				}
			}
		} while (!validInput);

		try {
			Constructor<? extends Predator> constructor = predatorClass.getConstructor(String.class, int.class,
					double.class, Sex.class, int.class);
			Predator predator = constructor.newInstance(nameField.getText(), Integer.parseInt(ageField.getText()),
					Double.parseDouble(weightField.getText()), (Sex) genderBox.getSelectedItem(), 100);

			Zoo.addAnimal(predator);
			JOptionPane.showMessageDialog(null, animalTypeName + " added successfully!");
			Music.playMusic("resorces\\" + animalTypeName + ".wav");
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding " + animalTypeName + ".");
		}
	}

	public static void validatePredator(int age, double weight, String animalType)
			throws InvalidAgeException, InvalidWeightException {
		int maxLifeSpan = Lion.LIFE_SPAN;
		double maxWeight = Zoo.getMaxPredatorWeight();

		if (age < Zoo.getMinAge() || age > maxLifeSpan) {
			throw new InvalidAgeException(
					"Age must be greater than " + Zoo.getMinAge() + " and less than " + maxLifeSpan + " years.");
		}
		if (weight < Zoo.getMinPredatorWeight() || weight > maxWeight) {
			throw new InvalidWeightException("Weight must be greater than " + Zoo.getMinHerbivoreHeight()
					+ " and less than " + maxWeight + " kg.");
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                     REPTILE                                                                                      //                                        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void addReptile(Class<? extends Reptile> reptileClass) {
		String animalTypeName = reptileClass.getSimpleName();

		JLabel nameLabel = new JLabel("Name:");
		JLabel ageLabel = new JLabel("Age:");
		JLabel weightLabel = new JLabel("Weight:");
		JLabel lengthLabel = new JLabel("Length:");
		JLabel venomousStatusLabel = new JLabel("Venomous:");
		JLabel ninjaStatusLabel = new JLabel("Ninja:");
		JLabel colorLabel = new JLabel("Color:");
		JLabel colorsLabel = new JLabel("Use Ctrl Key for selecting multiple colors");

		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(10);
		JTextField weightField = new JTextField(10);
		JTextField lengthField = new JTextField(10);
		JComboBox<StatusCheck> venomousStatusBox = new JComboBox<>(StatusCheck.values());
		JComboBox<StatusCheck> ninjaStatusBox = new JComboBox<>(StatusCheck.values());
		JComboBox<Colors> colorBox = new JComboBox<>(
				new Colors[] { Colors.GREEN, Colors.WHITE, Colors.BLACK, Colors.BROWN });
		JList<Colors> colorList = new JList<>(Colors.values());
		colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane colorScrollPane = new JScrollPane(colorList);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		int padding = 10;

		panel.add(nameLabel, gbc);
		gbc.gridy++;
		panel.add(nameField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);
		panel.add(ageLabel, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(ageField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);
		panel.add(weightLabel, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(weightField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);
		panel.add(lengthLabel, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(lengthField, gbc);
		gbc.gridy++;
		gbc.insets = new Insets(padding, 0, 0, 0);

		if (reptileClass == Snake.class) {
			panel.add(venomousStatusLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(venomousStatusBox, gbc);
			gbc.insets = new Insets(padding, 0, 0, 0);
			gbc.gridy++;
			panel.add(colorLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			panel.add(colorsLabel, gbc);
			gbc.gridy++;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(colorScrollPane, gbc);
			gbc.insets = new Insets(padding, 0, 0, 0);

		} else if (reptileClass == Turtle.class) {
			panel.add(ninjaStatusLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(ninjaStatusBox, gbc);
			gbc.insets = new Insets(padding, 0, 0, 0);
			gbc.gridy++;
			panel.add(colorLabel, gbc);
			gbc.gridy++;
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			panel.add(colorBox, gbc);
		}

		int result;
		boolean validInput = false;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Enter the details for " + animalTypeName,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, animalTypeName + " addition cancelled.");
				return;
			}
			if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || weightField.getText().isEmpty()
					|| lengthField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Hi friend!\nIn order to finish the " + animalTypeName
						+ " addition, you have to enter all the data", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					int age = Integer.parseInt(ageField.getText());
					double weight = Double.parseDouble(weightField.getText());
					double length = Double.parseDouble(lengthField.getText());
					validateReptile(age, weight, length, animalTypeName);
					validInput = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Invalid input!\n\nPlease enter valid values for age, weight, and length.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvalidAgeException | InvalidWeightException | InvalidLengthException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
					weightField.setText("");
					lengthField.setText("");
				}
			}
		} while (!validInput);

		try {
			Constructor<? extends Reptile> constructor = reptileClass.getConstructor(String.class, int.class,
					double.class, double.class, StatusCheck.class, Colors[].class, StatusCheck.class, int.class);
			Colors[] selectedColors = colorList.getSelectedValuesList().toArray(new Colors[0]);
			Reptile reptile = constructor.newInstance(nameField.getText(), Integer.parseInt(ageField.getText()),
					Double.parseDouble(weightField.getText()), Double.parseDouble(lengthField.getText()),
					(StatusCheck) venomousStatusBox.getSelectedItem(), selectedColors,
					(StatusCheck) ninjaStatusBox.getSelectedItem(), 100);

			Zoo.addAnimal(reptile);
			JOptionPane.showMessageDialog(null, animalTypeName + " added successfully!");
			Music.playMusic("resorces\\" + animalTypeName + ".wav");
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error adding " + animalTypeName + ".");
		}
	}

	public static void validateReptile(int age, double weight, double length, String animalType)
			throws InvalidAgeException, InvalidWeightException, InvalidLengthException {
		int maxLifeSpan;
		double maxWeight;
		double maxLenght;
		double minWeight;
		double minLength;

		if ("Snake".equals(animalType)) {
			maxLifeSpan = Snake.LIFE_SPAN;
			maxWeight = Zoo.getMaxSnakeWeight();
			maxLenght = Zoo.getMaxSnakeLength();
			minWeight = Zoo.getMinSnakeWeight();
			minLength = Zoo.getMinSnakeLength();

		} else if ("Turtle".equals(animalType)) {
			maxLifeSpan = Turtle.LIFE_SPAN;
			maxWeight = Zoo.getMaxTurtleWeight();
			maxLenght = Zoo.getMaxTurtleLength();
			minWeight = Zoo.getMinTurtleWeight();
			minLength = Zoo.getMinTurtleLength();
		} else {
			throw new IllegalArgumentException("Unknown animal type: " + animalType);
		}

		if (age < Zoo.getMinAge() || age > maxLifeSpan) {
			throw new InvalidAgeException(
					"Age must be " + Zoo.getMinAge() + " or greater and less than " + maxLifeSpan + " years.");
		}
		if (weight < minWeight || weight > maxWeight) {
			throw new InvalidWeightException(
					"Weight must be greater than " + minWeight + " and less than " + maxWeight + " kg.");
		}
		if (length < minLength || length > maxLenght) {
			throw new InvalidLengthException(
					"Length must be longer than " + minLength + " and less than " + maxLenght + " m.");
		}
	}

}
