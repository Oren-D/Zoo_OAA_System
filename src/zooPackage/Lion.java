package zooPackage;

public class Lion extends Predator {

	protected static final int LIFE_SPAN = 15;

	public Lion(PredatorsName name, int age, double weight, Sex sex, int happines) {
		super(name, age, weight, sex, happines);
	}

	public Lion(String name, int age, double weight, Sex sex, int happines) {
		super(name, age, weight, sex, happines);
	}

	@Override
	public String makeNoise() {
		return "ROAR";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	public double feed() {
		if (this.getSex() == Sex.MALE) {
			return Math.min(this.getAge() * this.getWeight() * 0.02, 25);
		} else {
			return Math.min(this.getAge() * this.getWeight() * 0.03, 25);
		}
	}

}
