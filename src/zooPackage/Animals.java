package zooPackage;

public abstract class Animals {
	protected int age;
	protected int happines;

	public Animals(int age, int happines) {
		this.age = age;
		this.happines = happines;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected int getHappines() {
		return happines;
	}

	protected void setHappines(int happines) {
		this.happines = happines;
	}

	protected abstract String makeNoise();

	protected abstract int getLifeSpan();

	protected abstract int getDefaultNumberOfAnimals();

	protected abstract double feed();

}
