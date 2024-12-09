package VisitorPackage;

import java.util.ArrayList;
import java.util.List;

public class PromotionManager implements Subject {

	private List<Observer> observers;
	private String promotionMessage;

	public PromotionManager() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(promotionMessage);
		}
	}

	public void notifyObserverById(int id) {
		for (Observer observer : observers) {
			if (observer.getId() == id) {
				observer.update(promotionMessage);
				break;
			}
		}
	}

	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}

}
