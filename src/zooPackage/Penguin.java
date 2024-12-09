package zooPackage;

public class Penguin extends Bird {

	protected static final int LIFE_SPAN = 6;
	
	public Penguin(BirdsName randomName, int age, double height, int happines) {
		super(randomName, age, height, happines);
	}

	public Penguin(String name, int age, double height, int happines) {
		super(name, age, height, happines);
	}

	@Override
	public String makeNoise() {
		return "squack";
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
