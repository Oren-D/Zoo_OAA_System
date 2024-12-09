package zooPackage;

public class AquariumFish extends Fish {

	protected final static int LIFE_SPAN = 25;

	public AquariumFish(int age, double length, Pattern pattern, Colors[] color, int happines) {
		super(age, length, pattern, color, happines);
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	protected double feed() {
		if (this.getAge() < 3) {
			return 3;
		} else {
			return (3 + this.getLength());
		}
	}
}
