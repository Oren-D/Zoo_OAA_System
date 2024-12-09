package zooPackage;

import java.util.Arrays;

public class Spider extends Insects {

	protected static final int LIFE_SPAN = 12;

	public Spider(int age, StatusCheck venomous, Colors[] color, Pattern pattern, StatusCheck SpiderMan, int happines) {
		super(age, venomous, color, pattern, SpiderMan, happines);
	}

	@Override
	public String makeNoise() {
		return "Spider";
	}

	@Override
	public int getLifeSpan() {
		return LIFE_SPAN;
	}

	@Override
	protected double feed() {
		return 10;
	}

	@Override
	public String toString() {
		return String.format(
				"%s - [Age: %d | Venomous: %s | Colors: %s | Pattern %s | SpiderMan: %s]  -  Happines: %d ",
				getClass().getSimpleName(), age, venomous, Arrays.toString(color), pattern, SpiderMan, happines);
	}
}
