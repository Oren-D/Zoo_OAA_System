package zooPackage;

public abstract class Herbivore extends Animals {

	protected static final int DEFAULT_NUM_OF_HERBIVORES = 4;

	protected HerbivoreName randomName;
	protected String name;
	protected double weight;
	protected double height;
	protected Pattern pattern;
	protected Sex sex;

	public Herbivore(HerbivoreName randomName, int age, double weight, double height, Pattern pattern, Sex sex,
			int happines) {
		super(age, happines);
		this.randomName = randomName;
		this.weight = weight;
		this.height = height;
		this.pattern = pattern;
		this.sex = sex;
	}

	public Herbivore(String name, int age, double weight, double height, Pattern pattern, Sex sex, int happines) {
		super(age, happines);
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.pattern = pattern;
		this.sex = sex;
	}

	public abstract int getLifeSpan();

	public abstract String makeNoise();

	protected abstract double feed();

	public HerbivoreName getRandomName() {
		return randomName;
	}

	public void setRandomName(HerbivoreName randomName) {
		this.randomName = randomName;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public int getDefaultNumberOfAnimals() {
		return DEFAULT_NUM_OF_HERBIVORES;
	}

	@Override
	public String toString() {
		String displayName = (name != null) ? name : (randomName != null ? randomName.toString() : "Unknown");
		return String.format("%s - [Name: %s | Age: %d | Weight: %.2f | Pattern: %s | Gender: %s]  -  Happines: %d ",
				getClass().getSimpleName(), displayName, age, weight, pattern, sex, happines);
	}
}
