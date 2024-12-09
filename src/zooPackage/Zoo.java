package zooPackage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;

public class Zoo {

	// Zoo Attributes
	private final static String zooName = "Crazy Zoo";
	private final static String zooAddress = "24 Rothschild St. Tel Aviv, Israel";
	private final static NumberFormat FORMATTER = new DecimalFormat("0.00");
	private final static Random RANDOM = new Random();
	private final static int MIN_AGE = 1;
	private static List<Animals> animals = new ArrayList<>();

	// Fish Attributes
	private final static double MAX_FISH_LENGTH = 50.0;
	private final static double MIN_FISH_LENGTH = 1.0;
	private static List<Fish> fish = new ArrayList<>();

	// Bird Attributes
	private final static double MAX_PENGUIN_HEIGHT = 199.99;
	private final static double MIN_PENGUIN_HEIGHT = 10.0;
	private final static double MIN_PARROT_HEIGHT = 2.0;
	private final static double MAX_PARROT_HEIGHT = 50.0;
	private final static String MAIN_PENGUIN_NAME = "Big Mama";
	private final static int MAIN_PENGUIN_AGE = 3;
	private final static double MAIN_PENGUIN_HEIGHT = 200.0;
	private static List<Bird> birds = new ArrayList<>();

	// Insects Attributes
	private static List<Insects> insect = new ArrayList<>();

	// Herbivore Attributes
	private final static double MIN_HERBIVORE_WEIGHT = 100.0;
	private final static double MIN_HERBIVORE_HEIGHT = 40.0;
	private final static double MAX_ELEPHANT_WEIGHT = 1500.0;
	private final static double MAX_ZEBRA_WEIGHT = 450.0;
	private final static double MAX_ELEPHANT_HEIGHT = 1000.0;
	private final static double MAX_ZEBRA_HEIGHT = 250.0;
	private static List<Herbivore> herbivore = new ArrayList<>();

	// Predator Attributes
	private final static double MAX_PREDATOR_WEIGHT = 500.0;
	private final static double MIN_PREDATOR_WEIGHT = 25.0;
	private static List<Predator> predators = new ArrayList<>();

	// Reptile Attributes
	private final static double MAX_SNAKE_WEIGHT = 250.0;
	private final static double MIN_SNAKE_WEIGHT = 10.0;
	private final static double MAX_TURTLE_WEIGHT = 500.0;
	private final static double MIN_TURTLE_WEIGHT = 5.0;
	private final static double MAX_SNAKE_LENGTH = 10.0;
	private final static double MIN_SNAKE_LENGTH = 0.2;
	private final static double MAX_TURTLE_LENGTH = 1.5;
	private final static double MIN_TURTLE_LENGTH = 0.1;
	private static List<Reptile> reptile = new ArrayList<>();
	public static void addAnimal(Animals animal) {
		getAnimal().add(animal);
	}

	public static int countAnimalsByType(Class<?> type) {
		int count = 0;
		for (Animals animal : getAnimal()) {
			if (type.isInstance(animal)) {
				count++;
			}
		}
		return count;
	}

	public static void setAnimal(List<Animals> animal) {
		Zoo.animals = animal;
	}

	public static List<Animals> getAnimal() {
		return animals;
	}

	public static String feedAllAnimals() {

		Map<String, Double> foodConsumptionByType = new LinkedHashMap<>();
		Map<String, List<String>> categories = new LinkedHashMap<>();
		categories.put("Predators", Arrays.asList("Lion", "Tiger"));
		categories.put("Herbivores", Arrays.asList("Zebra", "Elephant"));
		categories.put("Reptiles", Arrays.asList("Snake", "Turtle"));
		categories.put("Birds", Arrays.asList("Penguin", "Parrot"));
		categories.put("Fish", Arrays.asList("AquariumFish", "GoldFish", "ClownFish"));
		categories.put("Insects", Arrays.asList("Spider", "Bee"));

		Map<String, String> foodTypeByAnimal = new HashMap<>();
		foodTypeByAnimal.put("Lion", "kg of meat");
		foodTypeByAnimal.put("Tiger", "kg of meat");
		foodTypeByAnimal.put("Zebra", "kg of grass");
		foodTypeByAnimal.put("Elephant", "kg of grass");
		foodTypeByAnimal.put("Snake", "mice");
		foodTypeByAnimal.put("Turtle", "kg of sea grass");
		foodTypeByAnimal.put("Spider", "fly");
		foodTypeByAnimal.put("Bee", "mg of sugar");
		foodTypeByAnimal.put("Penguin", "fish");
		foodTypeByAnimal.put("Parrot", "food portions");
		foodTypeByAnimal.put("AquariumFish", "food portions");
		foodTypeByAnimal.put("GoldFish", "food portions");
		foodTypeByAnimal.put("ClownFish", "food portions");

		for (Animals animal : animals) {
			double foodConsumed = animal.feed();
			String className = animal.getClass().getSimpleName();
			foodConsumptionByType.merge(className, foodConsumed, Double::sum);
		}

		StringBuilder consumptionSummary = new StringBuilder();

		for (String category : categories.keySet()) {
			consumptionSummary.append(category).append(":\n");
			List<String> animalsInCategory = categories.get(category);
			for (String animalType : animalsInCategory) {
				Double totalConsumption = foodConsumptionByType.getOrDefault(animalType, 0.0);
				String foodDetails = foodTypeByAnimal.get(animalType);

				consumptionSummary.append("  ").append(animalType).append(": ")
						.append(String.format("%.2f", totalConsumption)).append(" ").append(foodDetails).append("\n");

			}
			consumptionSummary.append("\n");
		}
		return consumptionSummary.toString();
	}

	public static void removeUnhappyOrOldAnimals(List<Animals> animals) {

		List<Animals> removedAnimals = new ArrayList<>();
		animals.removeIf(animal -> {
			boolean condition = animal.getHappines() <= 0 || animal.getAge() > animal.getLifeSpan();
			if (condition) {
				removedAnimals.add(animal);
				return true;
			} else
				return false;
		});
		StringBuilder sb = new StringBuilder();
		for (Animals animal : removedAnimals) {
			sb.append(animal.toString()).append("\n");
		}
		if (!removedAnimals.isEmpty()) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Removed Animals", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No animals were removed.", "Removed Animals",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void ageOneYear() {
		for (Animals animal : animals) {
			animal.setAge(animal.getAge() + 1);
			animal.setHappines(animal.getHappines() - decreaseRandomHappines());
		}
	}

	public static void setDefaultHappinessAfterFeeding() {
		for (Animals animal : animals) {
			animal.setHappines(100);
		}
	}

	public static void defaultAnimals() {
		for (int i = 0; i < Predator.DEFAULT_NUM_OF_PREDATORS; i++) {
			addAnimal(new Tiger(randomPredatorName(), randomPredatorAge(), randomPredatorWeight(), randomAnimalSex(),
					getRandomHappines()));
			addAnimal(new Lion(randomPredatorName(), randomPredatorAge(), randomPredatorWeight(), randomAnimalSex(),
					getRandomHappines()));
		}

		for (int i = 0; i < Reptile.DEFAULT_NUM_OF_REPTILE; i++) {
			addAnimal(new Snake(randomReptileName(), randomSnakeAge(), randomSnakeWeight(), randomSnakeLength(),
					randomVenomousStatus(), new Colors[] { randomReptileColor() }, StatusCheck.NO,
					getRandomHappines()));
			addAnimal(new Turtle(randomReptileName(), randomTurtleAge(), randomTurtleWeight(), randomTurtleLength(),
					StatusCheck.NO, new Colors[] { Colors.GREEN }, randomNinjaStatus(), getRandomHappines()));
		}

		for (int i = 0; i < Herbivore.DEFAULT_NUM_OF_HERBIVORES; i++) {
			addAnimal(new Zebra(randomHerbivoreName(), randomZebraAge(), randomZebraWeight(), randomZebraHeight(),
					Pattern.LINES, randomAnimalSex(), getRandomHappines()));
			addAnimal(new Elephant(randomHerbivoreName(), randomElephantAge(), randomElephantWeight(),
					randomElephantHeight(), Pattern.SMOOTH, randomAnimalSex(), getRandomHappines()));
		}

		for (int i = 0; i < Insects.DEFAULT_NUM_OF_INSECTS; i++) {
			addAnimal(new Bee(randomBeeAge(), randomVenomousStatus(), new Colors[] { Colors.BLACK, Colors.YELLOW },
					Pattern.LINES, StatusCheck.NO, getRandomHappines()));
			addAnimal(new Spider(randomSpiderAge(), randomVenomousStatus(), new Colors[] { randomSpiderColor() },
					randomSpiderPattern(), randomSpiderManStatus(), getRandomHappines()));
		}

		addAnimal(new Penguin(MAIN_PENGUIN_NAME, MAIN_PENGUIN_AGE, MAIN_PENGUIN_HEIGHT, 100));
		for (int i = 0; i < Bird.DEFAULT_NUM_OF_BIRDS; i++) {
			addAnimal(new Penguin(randomBirdName(), randomPenguinAge(), randomPenguinHeight(), getRandomHappines()));
			addAnimal(new Parrot(randomBirdName(), randomParrotAge(), randomParrotHeight(), getRandomHappines()));
		}

		addRandomFish(Fish.DEFAULT_NUM_OF_FISH);
	}

	public String dominantColors() {
		int counter = 0;
		Colors[] allFishColors = new Colors[getFish().size() * 10];
		for (int i = 0; i < getFish().size(); i++) {
			for (int j = 0; j < getFish().get(i).getColor().length && getFish().get(i).getColor()[j] != null; j++) {
				allFishColors[counter] = getFish().get(i).getColor()[j];
				counter++;
			}
		}
		Colors[] ArrayOfColors = Colors.values();
		int[] ColorCounter = new int[ArrayOfColors.length];
		for (int i = 0; i < ArrayOfColors.length; i++) {
			for (int j = 0; j < allFishColors.length; j++) {
				if (ArrayOfColors[i] == allFishColors[j]) {
					ColorCounter[i]++;
				}
			}
		}
		int dominatOne = findIndexOfLargest(ColorCounter);
		ColorCounter[dominatOne] = 0;
		int dominatTwo = findIndexOfLargest(ColorCounter);
		return "" + ArrayOfColors[dominatOne] + " + " + ArrayOfColors[dominatTwo];
	}

	public static int findIndexOfLargest(int[] array) {
		if (array == null || array.length == 0)
			return -1;

		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[maxIndex])
				maxIndex = i;
		}
		return maxIndex;
	}

	boolean colorExistsInArray(Colors color, Colors[] array) {

		for (Colors c : array) {
			if (c == color) {
				return true;
			}
		}
		return false;
	}

	public static Sex randomAnimalSex() {
		Sex[] sex = Sex.values();
		int index = RANDOM.nextInt(sex.length);
		return sex[index];
	}

	public static StatusCheck randomVenomousStatus() {
		StatusCheck[] isVenomus = StatusCheck.values();
		int index = RANDOM.nextInt(isVenomus.length);
		return isVenomus[index];
	}

	public static int getRandomHappines() {
		return 10 + RANDOM.nextInt(90);
	}

	public static int decreaseRandomHappines() {
		return 1 + RANDOM.nextInt(19);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                            FISH Methods                                                                 //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void addRandomFish(int numberOfFish) {
		for (int i = 0; i < numberOfFish; i++) {
			int fishType = RANDOM.nextInt(3) + 1;

			int age;
			double length = randomFishLength();
			Fish fish;
			if (i <= 3 && i >= 1) {
				fishType = i;
			}
			switch (fishType) {
			case 1: // Aquarium Fish
				age = randomFishAge(AquariumFish.LIFE_SPAN);
				Pattern pattern = randomFishPattern();
				int numberOfColors = 1 + RANDOM.nextInt(6);
				Colors[] colors = new Colors[numberOfColors];
				for (int j = 0; j < numberOfColors; j++) {
					colors[j] = randomFishColor();
				}
				fish = new AquariumFish(age, length, pattern, colors, getRandomHappines());
				break;
			case 2: // Gold Fish
				age = randomFishAge(GoldFish.LIFE_SPAN);
				Colors[] allowedColors = { Colors.ORANGE, Colors.GOLD, Colors.YELLOW, Colors.BLACK };
				Colors color = allowedColors[RANDOM.nextInt(allowedColors.length)];
				fish = new GoldFish(age, length, color, getRandomHappines());
				break;
			case 3: // Clown Fish
				age = randomFishAge(ClownFish.LIFE_SPAN);
				fish = new ClownFish(age, length, getRandomHappines());
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + fishType);
			}
			addAnimal(fish);
		}
	}

	public static Pattern randomFishPattern() {
		Pattern[] pattern = Pattern.values();
		int index = RANDOM.nextInt(pattern.length);
		return pattern[index];
	}

	public static Colors randomFishColor() {
		Colors[] color = Colors.values();
		int index = RANDOM.nextInt(color.length);
		return color[index];
	}

	public static double randomFishLength() {
		return (getMinFishLength() + RANDOM.nextDouble(getMaxFishLength() - getMinFishLength()));
	}

	public static int randomFishAge(int lifeSpan) {
		int randomLifeSpan = 0;

		if (lifeSpan == AquariumFish.LIFE_SPAN)
			randomLifeSpan = AquariumFish.LIFE_SPAN;
		else if (lifeSpan == GoldFish.LIFE_SPAN)
			randomLifeSpan = GoldFish.LIFE_SPAN;
		else if (lifeSpan == ClownFish.LIFE_SPAN)
			randomLifeSpan = ClownFish.LIFE_SPAN;

		return (getMinAge() + RANDOM.nextInt(randomLifeSpan - getMinAge()));
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                            BIRD Methods                                                                 //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void sortPenguins(int choice) {
		switch (choice) {
		case 1: // Sort by name (A to Z)
			animals.sort((bird1, bird2) -> {
				if (bird1 instanceof Penguin && bird2 instanceof Penguin) {
					String name1 = ((Penguin) bird1).getName();
					String name2 = ((Penguin) bird2).getName();
					BirdsName randomName1 = ((Penguin) bird1).getRandomName();
					BirdsName randomName2 = ((Penguin) bird2).getRandomName();
					String effectiveName1 = name1 != null ? name1
							: (randomName1 != null ? randomName1.toString() : null);
					String effectiveName2 = name2 != null ? name2
							: (randomName2 != null ? randomName2.toString() : null);

					if (effectiveName1 == null)
						effectiveName1 = "";
					if (effectiveName2 == null)
						effectiveName2 = "";

					return effectiveName1.compareTo(effectiveName2);
				}
				return 0;
			});
			break;

		case 2: // Sort by height

			animals.sort((bird1, bird2) -> {
				if (bird1 instanceof Penguin && bird2 instanceof Penguin) {
					return Double.compare(((Penguin) bird2).getHeight(), ((Penguin) bird1).getHeight());
				}
				return 0;
			});
			break;

		case 3: // Sort by age
			animals.sort((bird1, bird2) -> {
				if (bird1 instanceof Penguin && bird2 instanceof Penguin) {
					return Integer.compare(((Penguin) bird2).getAge(), ((Penguin) bird1).getAge());
				}
				return 0;
			});
			break;

		default:

			break;
		}
	}

	public static BirdsName randomBirdName() {
		BirdsName[] name = BirdsName.values();
		int index = RANDOM.nextInt(name.length);
		return name[index];
	}

	public static int randomPenguinAge() {
		return getMinAge() + RANDOM.nextInt(Penguin.LIFE_SPAN - getMinAge());
	}

	public static int randomParrotAge() {
		return getMinAge() + RANDOM.nextInt(Parrot.LIFE_SPAN - getMinAge());
	}

	public static double randomPenguinHeight() {
		double height = getMinHeightOfPenguin() + RANDOM.nextDouble(getMaxPenguinHeight() - getMinPenguinHeight());
		return Double.parseDouble((getFormatter().format(height).replace(",", ".")));

	}

	public static double randomParrotHeight() {
		double height = getMinParrotHeight() + RANDOM.nextDouble(getMaxParrotHeight() - getMinParrotHeight());
		return Double.parseDouble((getFormatter().format(height).replace(",", ".")));
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                     INSECTS Methods                                                          //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static StatusCheck randomSpiderManStatus() {
		StatusCheck[] isSpiderMan = StatusCheck.values();
		int index = RANDOM.nextInt(isSpiderMan.length);
		return isSpiderMan[index];
	}

	public static int randomBeeAge() {
		return getMinAge() + RANDOM.nextInt(Bee.LIFE_SPAN - getMinAge());
	}

	public static int randomSpiderAge() {
		return getMinAge() + RANDOM.nextInt(Spider.LIFE_SPAN);
	}

	public static Colors randomSpiderColor() {
		Colors[] color = Colors.values();
		int index = RANDOM.nextInt(color.length);
		return color[index];
	}

	public static Pattern randomSpiderPattern() {
		Pattern[] pattern = Pattern.values();
		int index = RANDOM.nextInt(pattern.length);
		return pattern[index];
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                       HERBIVORE Methods                                                                 //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static HerbivoreName randomHerbivoreName() {
		HerbivoreName[] name = HerbivoreName.values();
		int index = RANDOM.nextInt(name.length);
		return name[index];
	}

	public static int randomZebraAge() {
		return getMinAge() + RANDOM.nextInt(Zebra.LIFE_SPAN - getMinAge());
	}

	public static int randomElephantAge() {
		return getMinAge() + RANDOM.nextInt(Elephant.LIFE_SPAN - getMinAge());
	}

	public static double randomZebraWeight() {
		double weight = getMinHerbivoreWeight() + RANDOM.nextDouble(getMaxZebraWeight() - getMinHerbivoreWeight());
		return Double.parseDouble((getFormatter().format(weight).replace(",", ".")));
	}

	public static double randomElephantWeight() {
		double weight = getMinHerbivoreWeight() + RANDOM.nextDouble(getMaxElephantWeight() - getMinHerbivoreWeight());
		return Double.parseDouble((getFormatter().format(weight).replace(",", ".")));
	}

	public static double randomZebraHeight() {
		double length = getMinHerbivoreHeight() + RANDOM.nextDouble(getMaxZebraHeight() - getMinHerbivoreHeight());
		return Double.parseDouble((getFormatter().format(length).replace(",", ".")));
	}

	public static double randomElephantHeight() {
		double length = getMinHerbivoreHeight() + RANDOM.nextDouble(getMaxElephantHeight() - getMinHerbivoreHeight());
		return Double.parseDouble((getFormatter().format(length).replace(",", ".")));
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                           PREDATOR Methods                                                              //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static PredatorsName randomPredatorName() {
		Random randomName = new Random();
		PredatorsName[] name = PredatorsName.values();
		int index = randomName.nextInt(name.length);
		return name[index];
	}

	public static int randomPredatorAge() {
		return getMinAge() + RANDOM.nextInt(Lion.LIFE_SPAN - getMinAge());
	}

	public static double randomPredatorWeight() {
		double weight = getMinPredatorWeight() + RANDOM.nextDouble(getMaxPredatorWeight() - getMinPredatorWeight());
		return Double.parseDouble((getFormatter().format(weight)).replace(",", "."));
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                           REPTILE Methods                                                               //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                        GENERAL GETERS\SETTERS                                                           //
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ReptilesName randomReptileName() {
		ReptilesName[] name = ReptilesName.values();
		int index = RANDOM.nextInt(name.length);
		return name[index];
	}

	public static StatusCheck randomNinjaStatus() {
		StatusCheck[] isNinja = StatusCheck.values();
		int index = RANDOM.nextInt(isNinja.length);
		return isNinja[index];
	}

	public static Colors randomReptileColor() {
		Colors[] color = Colors.values();
		int index = RANDOM.nextInt(color.length);
		return color[index];
	}

	public static int randomSnakeAge() {
		return getMinAge() + RANDOM.nextInt(Snake.LIFE_SPAN - getMinAge());
	}

	public static int randomTurtleAge() {
		return getMinAge() + RANDOM.nextInt(Turtle.LIFE_SPAN - getMinAge());
	}

	public static double randomSnakeWeight() {
		double weight = getMinSnakeWeight() + RANDOM.nextDouble(getMaxSnakeWeight() - getMinSnakeWeight());
		return Double.parseDouble((getFormatter().format(weight).replace(",", ".")));
	}

	public static double randomTurtleWeight() {
		double weight = getMinTurtleWeight() + RANDOM.nextDouble(getMaxTurtleWeight() - getMinTurtleWeight());
		return Double.parseDouble((getFormatter().format(weight).replace(",", ".")));
	}

	public static double randomSnakeLength() {
		double weight = getMinSnakeLength() + RANDOM.nextDouble(getMaxSnakeLength() - getMinSnakeLength());
		return Double.parseDouble((getFormatter().format(weight).replace(",", ".")));
	}

	public static double randomTurtleLength() {
		double weight = getMinTurtleLength() + RANDOM.nextDouble(getMaxTurtleLength() - getMinTurtleLength());
		return Double.parseDouble((getFormatter().format(weight).replace(",", ".")));
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//                                                                Geters/Setters                                                                        //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getZooName() {
		return zooName;
	}

	public String getZooAddress() {
		return zooAddress;
	}

	public static NumberFormat getFormatter() {
		return FORMATTER;
	}

	public static void setFish(List<Fish> fish) {
		Zoo.fish = fish;
	}

	public static List<Fish> getFish() {
		return fish;
	}

	public static double getMaxFishLength() {
		return MAX_FISH_LENGTH;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// BIRD GETERS\SETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<Bird> getBirds() {
		return birds;
	}

	public static void setBirds(List<Bird> birds) {
		Zoo.birds = birds;
	}

	public static String getMainPenguinName() {
		return MAIN_PENGUIN_NAME;
	}

	public static int getMainPenguinAge() {
		return MAIN_PENGUIN_AGE;
	}

	public static double getMainPenguinHeight() {
		return MAIN_PENGUIN_HEIGHT;
	}

	public static double getMaximumheightofpenguin() {
		return MAX_PENGUIN_HEIGHT;
	}

	public static double getMinParrotHeight() {
		return MIN_PARROT_HEIGHT;
	}

	public static double getMaxParrotHeight() {
		return MAX_PARROT_HEIGHT;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// INSECTS GETERS\SETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<Insects> getInsect() {
		return insect;
	}

	public static void setInsect(List<Insects> insect) {
		Zoo.insect = insect;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// HERBIVORES GETERS\SETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<Herbivore> getHerbivore() {
		return herbivore;
	}

	public static void setHerbivore(List<Herbivore> herbivore) {
		Zoo.herbivore = herbivore;
	}

	public static double getMaxElephantWeight() {
		return MAX_ELEPHANT_WEIGHT;
	}

	public static double getMaxZebraWeight() {
		return MAX_ZEBRA_WEIGHT;
	}

	public static double getMaxElephantHeight() {
		return MAX_ELEPHANT_HEIGHT;
	}

	public static double getMaxZebraHeight() {
		return MAX_ZEBRA_HEIGHT;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PREDATORS GETERS\SETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<Predator> getPredators() {
		return predators;
	}

	public static void setPredators(List<Predator> predators) {
		Zoo.predators = predators;
	}

	public static double getMaxPredatorWeight() {
		return MAX_PREDATOR_WEIGHT;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// REPTILE GETERS\SETTERS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static double getMaxSnakeLength() {
		return MAX_SNAKE_LENGTH;
	}

	public static double getMaxTurtleLength() {
		return MAX_TURTLE_LENGTH;
	}

	public static double getMaxSnakeWeight() {
		return MAX_SNAKE_WEIGHT;
	}

	public static double getMaxTurtleWeight() {
		return MAX_TURTLE_WEIGHT;
	}

	public static List<Reptile> getReptile() {
		return reptile;
	}

	public static void setReptile(List<Reptile> reptile) {
		Zoo.reptile = reptile;
	}

	public static int getMinAge() {
		return MIN_AGE;
	}

	public static double getMinFishLength() {
		return MIN_FISH_LENGTH;
	}

	public static double getMaxHeightOfPenguin() {
		return MAX_PENGUIN_HEIGHT;
	}

	public static double getMinHeightOfPenguin() {
		return MIN_PENGUIN_HEIGHT;
	}

	public static double getMinHerbivoreWeight() {
		return MIN_HERBIVORE_WEIGHT;
	}

	public static double getMinHerbivoreHeight() {
		return MIN_HERBIVORE_HEIGHT;
	}

	public static double getMinPredatorWeight() {
		return MIN_PREDATOR_WEIGHT;
	}

	public static double getMinSnakeWeight() {
		return MIN_SNAKE_WEIGHT;
	}

	public static double getMinTurtleWeight() {
		return MIN_TURTLE_WEIGHT;
	}

	public static double getMinSnakeLength() {
		return MIN_SNAKE_LENGTH;
	}

	public static double getMinTurtleLength() {
		return MIN_TURTLE_LENGTH;
	}

	public static double getMaxPenguinHeight() {
		return MAX_PENGUIN_HEIGHT;
	}

	public static double getMinPenguinHeight() {
		return MIN_PENGUIN_HEIGHT;
	}

}
