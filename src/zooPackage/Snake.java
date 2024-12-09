package zooPackage;

public class Snake extends Reptile {

	protected static final int LIFE_SPAN = 22;

	public Snake(ReptilesName randomName, int age, double weight, double length, StatusCheck venomous, Colors[] color,
			StatusCheck ninja, int happines) {
		super(randomName, age, weight, length, venomous, color, StatusCheck.NO, happines);
	}

	public Snake(String name, int age, double weight, double length, StatusCheck venomous, Colors[] color,
			StatusCheck ninja, int happines) {
		super(name, age, weight, length, venomous, color, StatusCheck.NO, happines);
	}

	@Override
	public String makeNoise() {
		return "SSS";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	protected double feed() {
		if (this.getLength() <= 2) {
			return 2;
		} else {
			return 2 + this.getLength();
		}
	}

}
