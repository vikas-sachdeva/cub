package cub.file.util.filter;

import java.io.File;
import java.io.FileFilter;

public class FileNameEndsWithFilter implements FileFilter {
	String[] validFileNameEndsStrings;

	public FileNameEndsWithFilter(String... validFileNameEndsStrings) {
		this.validFileNameEndsStrings = validFileNameEndsStrings;
	}

	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory()) {
			return true;
		}
		if (validFileNameEndsStrings != null) {
			for (String str : validFileNameEndsStrings) {
				if (pathname.getAbsolutePath().endsWith(str)) {
					return true;
				}
			}
		}
		return false;
	}
}
