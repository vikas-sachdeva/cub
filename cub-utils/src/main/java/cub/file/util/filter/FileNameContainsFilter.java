package cub.file.util.filter;

import java.io.File;
import java.io.FileFilter;

public class FileNameContainsFilter implements FileFilter {
	String[] validFileNameContainsStrings;

	public FileNameContainsFilter(String... validFileNameContainsStrings) {
		this.validFileNameContainsStrings = validFileNameContainsStrings;
	}

	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory()) {
			return true;
		}
		if (validFileNameContainsStrings != null) {
			for (String str : validFileNameContainsStrings) {
				if (pathname.getName().contains(str)) {
					return true;
				}
			}
		}
		return false;
	}
}
