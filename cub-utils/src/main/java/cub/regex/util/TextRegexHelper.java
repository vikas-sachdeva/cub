package cub.regex.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRegexHelper {

	public static boolean isWordRegexExistInText(String text, String wordRegex) {
		boolean result = false;
		Pattern pattern = Pattern.compile(wordRegex);
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			result = true;
		}
		return result;
	}

	public static int getCountOfWordRegexInText(String text, String wordRegex) {
		int count = 0;
		Pattern pattern = Pattern.compile(wordRegex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			count++;
		}
		return count;
	}

	public static List<String> getMatchedTextOfWordRegexInText(String text, String wordRegex) {
		List<String> matchedText = new ArrayList<String>();
		Pattern pattern = Pattern.compile(wordRegex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			matchedText.add(matcher.group(0));
		}
		return matchedText;
	}

	public static List<String[]> getAllMatchedTextOfWordRegexInText(String text, String wordRegex) {
		List<String[]> allMatchedText = new ArrayList<String[]>();
		Pattern pattern = Pattern.compile(wordRegex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			String[] matchedText = new String[matcher.groupCount() + 1];
			for (int i = 0; i <= matcher.groupCount(); i++) {
				matchedText[i] = matcher.group(i);
			}
			allMatchedText.add(matchedText);
		}
		return allMatchedText;
	}
}