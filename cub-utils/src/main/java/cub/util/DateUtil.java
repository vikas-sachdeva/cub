package cub.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtil {

	private static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";

	public static String getCurrentDateInyyyyMMddFormat() {
		Date date = new Date();
		return convertDateToString(date, DATE_PATTERN_YYYYMMDD);
	}

	public static String convertDateToString(Date date, String patternString) {
		return convertDateToString(date, patternString, Locale.getDefault());
	}

	public static String convertDateToString(Date date, String patternString, Locale locale) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternString, locale);
		return simpleDateFormat.format(date);
	}

	public static Date addDaysInDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	public static List<Date> getAllDaysDateBetween(Date startDate, Date endDate, DayOfWeek dayOfWeek) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		ArrayList<Date> daysDateList = new ArrayList<>();

		while (!startCal.equals(endCal)) {
			startCal.add(Calendar.DATE, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) == dayOfWeek.getValue()) {
				daysDateList.add(startCal.getTime());
			}
		}
		return daysDateList;
	}
}