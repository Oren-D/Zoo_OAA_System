package zooPackage;

public class Zebra extends Herbivore {

	protected static final int LIFE_SPAN = 16;

	public Zebra(HerbivoreName randomName, int age, double weight, double height, Pattern pattern, Sex sex,
			int happines) {
		super(randomName, age, weight, height, Pattern.LINES, sex, happines);
	}

	public Zebra(String name, int age, double weight, double height, Pattern pattern, Sex sex, int happines) {
		super(name, age, weight, height, Pattern.LINES, sex, happines);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeNoise() {
		return "zebra";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	public double feed() {
		if (this.getSex() == Sex.MALE) {
			return (this.getAge() * this.getWeight() * 0.015);
		} else {
			return (this.getAge() * this.getWeight() * 0.02);
		}
	}

}
