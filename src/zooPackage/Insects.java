package zooPackage;

public abstract class Insects extends Animals {
	
	protected static final int DEFAULT_NUM_OF_INSECTS = 6;
	
	protected StatusCheck venomous;
	protected Colors[] color;
	protected Pattern pattern;
	protected StatusCheck SpiderMan;

	public Insects(int age, StatusCheck venomous, Colors[] color, Pattern pattern, StatusCheck SpiderMan,
			int happines) {
		super(age, happines);
		this.venomous = venomous;
		this.color = color;
		this.pattern = pattern;
		this.SpiderMan = SpiderMan;
	}

	@Override
    public int getDefaultNumberOfAnimals() {
        return DEFAULT_NUM_OF_INSECTS;
    }
	
	public abstract String makeNoise();

	public abstract int getLifeSpan();

	public abstract String toString();
	
	public StatusCheck isSpiderMan() {
		return SpiderMan;
	}

	public void setSpiderMan(StatusCheck spiderMan) {
		SpiderMan = spiderMan;
	}

	public Colors[] getColor() {
		return color;
	}

	public void setColor(Colors[] color) {
		this.color = color;
	}

	public StatusCheck isVenomous() {
		return venomous;
	}

	public void setVenomous(StatusCheck venomous) {
		this.venomous = venomous;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

}
