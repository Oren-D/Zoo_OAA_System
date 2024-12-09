package zooPackage;

public abstract class Bird extends Animals {

	protected static final int DEFAULT_NUM_OF_BIRDS = 4;

	protected BirdsName randomName;
	protected String name;
	protected double height;

	public Bird(BirdsName randomName, int age, double height, int happines) {
		super(age, happines);
		this.randomName = randomName;
		this.height = height;
	}

	public Bird(String name, int age, double height, int happines) {
		super(age, happines);
		this.name = name;
		this.height = height;
	}

	public abstract int getLifeSpan();

	public abstract String makeNoise();

	public BirdsName getRandomName() {
		return randomName;
	}

	public void setRandomName(BirdsName randomName) {
		this.randomName = randomName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int getDefaultNumberOfAnimals() {
		return DEFAULT_NUM_OF_BIRDS;
	}

	@Override
	public String toString() {
		String displayName = (name != null) ? name : (randomName != null ? randomName.toString() : "Unknown");
		return String.format("%s - [Name: %s | Age: %d | Height: %.2f]  -  Happines: %d ", getClass().getSimpleName(),
				displayName, age, height, happines);
	}
}
