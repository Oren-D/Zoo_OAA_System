package zooPackage;

public abstract class Predator extends Animals {

	protected static final int DEFAULT_NUM_OF_PREDATORS = 4;

	protected PredatorsName randomName;
	protected String name;
	protected double weight;
	protected Sex sex;

	public Predator(PredatorsName randomName, int age, double weight, Sex sex, int happines) {
		super(age, happines);
		this.randomName = randomName;
		this.weight = weight;
		this.sex = sex;
	}

	public Predator(String name, int age, double weight, Sex sex, int happines) {
		super(age, happines);
		this.name = name;
		this.weight = weight;
		this.sex = sex;
	}

	public abstract int getLifeSpan();

	public abstract String makeNoise();

	protected abstract double feed();

	public PredatorsName getRandomName() {
		return randomName;
	}

	public void setRandomName(PredatorsName name) {
		this.randomName = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public int getDefaultNumberOfAnimals() {
		return DEFAULT_NUM_OF_PREDATORS;
	}

	@Override
	public String toString() {
		String displayName = (name != null) ? name : (randomName != null ? randomName.toString() : "Unknown");
		return String.format("%s - [Name: %s | Age: %d | Weight: %.2f | Gender: %s]  -  Happines: %d ",
				getClass().getSimpleName(), displayName, age, weight, sex, happines);
	}
}
