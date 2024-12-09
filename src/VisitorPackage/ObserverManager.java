package VisitorPackage;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager {
	public static ObserverManager instance;
	private static List<Observer> observers = new ArrayList<Observer>();
	static PromotionManager promotionManager = new PromotionManager();
	public static ObserverManager getInstance() {
		if (instance == null) {
			instance = new ObserverManager();
		}
		return instance;
	}
	public List<Observer> getObserver() {
		return observers;
	}

	public PromotionManager getPromotionManager() {
		return promotionManager;
	}

	public void addObserer(Observer observer) {
		getObserver().add(observer);
		promotionManager.registerObserver(observer);
	}

	public void sendMessage(String message) {
		if (message != null)
			promotionManager.setPromotionMessage(message);
	}
}
