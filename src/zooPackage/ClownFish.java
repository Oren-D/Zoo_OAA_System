package zooPackage;

public class ClownFish extends Fish {

	protected final static int LIFE_SPAN = 8;
	
	public ClownFish(int age, double length, int happines) {
		super(age, length, Pattern.LINES, new Colors[] { Colors.BLACK, Colors.WHITE, Colors.ORANGE }, happines);
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	protected double feed() {
		return 1;
	}
}
