package EmployeePackage;

import java.util.HashMap;
import java.util.Map;

public class PasswordManager {
	public static PasswordManager instance;
	private static Map<String, String> userPasswords = new HashMap<>();

	public PasswordManager() {

	}

	public static PasswordManager getInstance() {
		if (instance == null) {
			instance = new PasswordManager();
		}
		return instance;
	}

	private static final String ADMIN_USERNAME = "admin";
	private static final String ADMIN_PASSWORD = "admin";

	public static void AdminPutter() {
		userPasswords.put(ADMIN_USERNAME, ADMIN_PASSWORD);
	}

	public boolean checkUsernameAndPassword(String username, String password) {

		return validatePassword(username, password);
	}

	public boolean UserNameCheck(String username) {
		if (userPasswords.containsKey(username) == false) {
			return false;
		}
		return userPasswords.containsKey(username);
	}

	public void addUser(String username, String password) {
		userPasswords.put(username, password);
	}

	public boolean validatePassword(String username, String password) {
		return userPasswords.containsKey(username) && userPasswords.get(username).equals(password);
	}

}
