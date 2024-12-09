package zooPackage;

public class Tiger extends Predator {

	protected static final int LIFE_SPAN = 15;

	public Tiger(String name, int age, double weight, Sex sex, int happines) {
		super(name, age, weight, sex, happines);
	}

	public Tiger(PredatorsName name, int age, double weight, Sex sex, int happines) {
		super(name, age, weight, sex, happines);
	}

	@Override
	public String makeNoise() {
		return "roar";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	public double feed() {

		if (this.getSex() == Sex.MALE) {
			return (this.getAge() * this.getWeight() * 0.02);
		} else {
			return (this.getAge() * this.getWeight() * 0.03);
		}
	}

}
