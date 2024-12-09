package zooPackage;

import java.util.Arrays;

public class Bee extends Insects {

	protected static final int LIFE_SPAN = 4;

	public Bee(int age, StatusCheck venomous, Colors[] color, Pattern pattern, StatusCheck SpiderMan, int happines) {
		super(age, venomous, new Colors[] { Colors.BLACK, Colors.YELLOW }, Pattern.LINES, StatusCheck.NO, happines);
	}

	@Override
	public String makeNoise() {
		return "BZZZ";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	protected double feed() {
		return 200;
	}

	@Override
	public String toString() {
		return String.format("%s - [Age: %d | Venomous: %s | Pattern: %s | Colors: %s]  -  Happines: %d ",
				getClass().getSimpleName(), age, venomous, pattern, Arrays.toString(color), happines);
	}
}
