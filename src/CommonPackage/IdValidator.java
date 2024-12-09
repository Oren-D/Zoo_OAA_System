package CommonPackage;

public class IdValidator {
	public static boolean idValidator(int id) {
		String idString = String.valueOf(id);
		String regex = "[0-9]{9}";
		if (!idString.matches(regex)) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int digit = Character.getNumericValue(idString.charAt(i));
			if (i % 2 == 0) {
				sum += digit;
			} else {
				sum += digit < 5 ? digit * 2 : digit * 2 - 9;
			}
		}
		return sum % 10 == 0;
	}

}
