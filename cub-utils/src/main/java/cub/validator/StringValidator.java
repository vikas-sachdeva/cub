package cub.validator;

public class StringValidator {

	public static boolean isBlank(String str) {
		boolean blank = false;
		if (str == null || str.trim().isEmpty()) {
			blank = true;
		}
		return blank;
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

}
