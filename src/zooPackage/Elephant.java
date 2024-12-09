package zooPackage;

public class Elephant extends Herbivore {

	protected static final int LIFE_SPAN = 80;

	public Elephant(HerbivoreName randomName, int age, double weight, double height, Pattern pattern, Sex sex,
			int happines) {
		super(randomName, age, weight, height, Pattern.SMOOTH, sex, happines);
	}

	public Elephant(String name, int age, double weight, double height, Pattern pattern, Sex sex, int happines) {
		super(name, age, weight, height, Pattern.SMOOTH, sex, happines);
	}

	@Override
	public String makeNoise() {
		return "Wooooo";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	public double feed() {
		if (this.getSex() == Sex.MALE) {
			return 100;
		} else {
			return 120;
		}
	}

}
