package cub.validator;

import java.util.List;

public class CollectionsValidator {

	public static boolean isBlank(List<?> list) {
		boolean blank = false;
		if (list == null || list.isEmpty()) {
			blank = true;
		}
		return blank;
	}

	public static boolean isNotBlank(List<?> list) {
		return !isBlank(list);
	}

}
