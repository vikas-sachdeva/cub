package cub.file.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TextFileReaderUtil {

	private static final String DEFAULT_ENCODING = "UTF-8";

	public static String getFileContentAsString(String filePath, String fileEncoding)
			throws FileNotFoundException, IOException {
		StringBuilder text = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		try (Scanner scanner = new Scanner(new FileInputStream(filePath), fileEncoding)) {
			boolean isFirstLine = true;
			while (scanner.hasNextLine()) {
				if (isFirstLine) {
					text.append(scanner.nextLine());
					isFirstLine = false;
				} else {
					text.append(newLine).append(scanner.nextLine());
				}
			}
		}
		return text.toString();
	}

	public static String getFileContentAsString(String filePath) throws FileNotFoundException, IOException {
		return getFileContentAsString(filePath, DEFAULT_ENCODING);
	}
}