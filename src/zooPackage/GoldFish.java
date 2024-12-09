package zooPackage;

public class GoldFish extends Fish {

	protected final static int LIFE_SPAN = 12;
	
	public GoldFish(int age, double length, Colors color, int happines) {
		super(age, length, Pattern.SMOOTH, color, happines);
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	public double feed() {
		return 1;
	}
}
