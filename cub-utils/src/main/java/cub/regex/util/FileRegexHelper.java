package cub.regex.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import cub.file.util.TextFileReaderUtil;

public class FileRegexHelper {

	public static boolean isWordRegexExistInFile(String filePath, String wordRegex)
			throws FileNotFoundException, IOException {
		return TextRegexHelper.isWordRegexExistInText(TextFileReaderUtil.getFileContentAsString(filePath), wordRegex);

	}

	public static int getCountOfWordRegexInFile(String filePath, String wordRegex)
			throws FileNotFoundException, IOException {

		return TextRegexHelper.getCountOfWordRegexInText(TextFileReaderUtil.getFileContentAsString(filePath),
				wordRegex);
	}

	public static List<String> getMatchedTextOfWordRegexInFile(String filePath, String wordRegex)
			throws FileNotFoundException, IOException {

		return TextRegexHelper.getMatchedTextOfWordRegexInText(TextFileReaderUtil.getFileContentAsString(filePath),
				wordRegex);

	}

	public static List<String[]> getAllMatchedTextOfWordRegexInFile(String filePath, String wordRegex)
			throws FileNotFoundException, IOException {
		return TextRegexHelper.getAllMatchedTextOfWordRegexInText(TextFileReaderUtil.getFileContentAsString(filePath),
				wordRegex);
	}

}