package zooPackage;

public class Parrot extends Bird {

	protected static final int LIFE_SPAN = 12;
	
	public Parrot(BirdsName randomName, int age, double height, int happines) {
		super(randomName, age, height, happines);
	}

	public Parrot(String name, int age, double height, int happines) {
		super(name, age, height, happines);
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	public String makeNoise() {
		return "parror";
	}

	@Override
	protected double feed() {
		return 2;
	}

}
