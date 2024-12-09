package EmployeePackage;

import java.util.ArrayList;
import java.util.List;


public class EmployeeManager {
	public static EmployeeManager instance;
	private static List<Worker> worker = new ArrayList<>();
	static {

	}

	public static EmployeeManager getInstance() {
		if (instance == null) {
			instance = new EmployeeManager();
		}
		return instance;
	}

	public void addWorker(Worker worker) {
		getWorker().add(worker);

	}

	public List<Worker> getWorker() {
		return worker;
	}

}
