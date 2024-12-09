package zooPackage;

import java.util.Arrays;

public abstract class Fish extends Animals {

	protected static final int DEFAULT_NUM_OF_FISH = 10;

	protected double length;
	protected Pattern pattern;
	protected Colors[] colors;

	public Fish(int age, double length, Pattern pattern, Colors[] colors, int happines) {
		super(age, happines);
		this.length = length;
		this.pattern = pattern;
		this.colors = colors;
	}

	public Fish(int age, double length, Pattern pattern, Colors color, int happines) {
		this(age, length, pattern, new Colors[] { color }, happines);
	}

	public abstract int getLifeSpan();

	public String makeNoise() {
		return "blob";
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Colors[] getColor() {
		return colors;
	}

	public void setColor(Colors[] colors) {
		this.colors = colors;
	}

	@Override
	public int getDefaultNumberOfAnimals() {
		return DEFAULT_NUM_OF_FISH;
	}

	@Override
	public String toString() {
		return String.format("%s - [age: %d | length: %.2f | pattern: %s | colors: %s]  -  Happines: %d",
				getClass().getSimpleName(), age, length, pattern, Arrays.toString(colors), happines);
	}
}
