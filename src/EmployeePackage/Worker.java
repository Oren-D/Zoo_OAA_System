package EmployeePackage;

import CommonPackage.Person;

public class Worker extends Person {

	protected String userName;

	public Worker(int id, String name, String surname, String birthDate, int phoneNumber, String userName) {
		super(id, name, surname, birthDate, phoneNumber);
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	
}
