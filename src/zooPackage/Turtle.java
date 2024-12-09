package zooPackage;

public class Turtle extends Reptile {

	protected static final int LIFE_SPAN = 120;

	public Turtle(ReptilesName randomName, int age, double weight, double length, StatusCheck venomous, Colors[] color,
			StatusCheck ninja, int happines) {
		super(randomName, age, weight, length, StatusCheck.NO, color, ninja, happines);
	}

	public Turtle(String name, int age, double weight, double length, StatusCheck venomous, Colors[] color,
			StatusCheck ninja, int happines) {
		super(name, age, weight, length, StatusCheck.NO, color, ninja, happines);
	}

	@Override
	public String makeNoise() {
		return "turtturt";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	protected double feed() {
		return 2;
	}

}
