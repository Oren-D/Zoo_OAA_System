package zooPackage;

import java.util.Arrays;

public abstract class Reptile extends Animals {

	protected static final int DEFAULT_NUM_OF_REPTILE = 5;

	protected String name;
	protected ReptilesName randomName;
	protected double weight;
	protected double length;
	protected StatusCheck venomous;
	protected Colors[] color;
	protected StatusCheck ninja;

	public Reptile(ReptilesName randomName, int age, double weight, double length, StatusCheck venomous, Colors[] color,
			StatusCheck ninja, int happines) {
		super(age, happines);
		this.randomName = randomName;
		this.weight = weight;
		this.length = length;
		this.venomous = venomous;
		this.color = color;
		this.ninja = ninja;
	}

	public Reptile(String name, int age, double weight, double length, StatusCheck venomous, Colors[] color,
			StatusCheck ninja, int happines) {
		super(age, happines);
		this.name = name;
		this.weight = weight;
		this.length = length;
		this.venomous = venomous;
		this.color = color;
		this.ninja = ninja;
	}

	public abstract int getLifeSpan();

	public abstract String makeNoise();

	public Colors[] getColor() {
		return color;
	}

	public void setColor(Colors[] color) {
		this.color = color;
	}

	public StatusCheck isNinga() {
		return ninja;
	}

	public void setNinga(StatusCheck ninga) {
		this.ninja = ninga;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReptilesName getRandomName() {
		return randomName;
	}

	public void setRandomName(ReptilesName randomName) {
		this.randomName = randomName;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public StatusCheck isVenomous() {
		return venomous;
	}

	public void setVenomous(StatusCheck venomous) {
		this.venomous = venomous;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int getDefaultNumberOfAnimals() {
		return DEFAULT_NUM_OF_REPTILE;
	}

	@Override
	public String toString() {
		String displayName = (name != null) ? name : (randomName != null ? randomName.toString() : "Unknown");
		return String.format(
				"%s - [Name: %s | Age: %d | Weight: %.2f | Length: %.2f | Colors: %s | Venomous: %s | Ninja: %s]  -  Happines: %d ",
				getClass().getSimpleName(), displayName, age, weight, length, Arrays.toString(color), venomous, ninja,
				happines);
	}

}
