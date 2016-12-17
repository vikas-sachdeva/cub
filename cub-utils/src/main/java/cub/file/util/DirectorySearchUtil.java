package cub.file.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DirectorySearchUtil {

	public static List<String> recursivelyGetAllFilesInDirectory(String directoryPath, FileFilter filter)
			throws FileNotFoundException {
		List<String> filesList = new ArrayList<>();

		File directory = new File(directoryPath);
		File[] fileObjList;
		if (filter != null) {
			fileObjList = directory.listFiles(filter);
		} else {
			fileObjList = directory.listFiles();
		}

		if (fileObjList == null) {
			throw new FileNotFoundException(directoryPath + " does not exist.");
		}
		for (File file : fileObjList) {
			if (file.isFile()) {
				filesList.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				filesList.addAll(recursivelyGetAllFilesInDirectory(file.getAbsolutePath(), filter));
			}
		}
		return filesList;
	}

	public static List<String> recursivelyGetAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
		return recursivelyGetAllFilesInDirectory(directoryPath, null);
	}

	public static List<String> getAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
		return getAllFilesInDirectory(directoryPath, null);
	}

	public static List<String> getAllFilesInDirectory(String directoryPath, FileFilter filter)
			throws FileNotFoundException {
		List<String> filesList = new ArrayList<>();

		File directory = new File(directoryPath);

		File[] fileObjList;

		if (filter != null) {
			fileObjList = directory.listFiles(filter);
		} else {
			fileObjList = directory.listFiles();
		}
		if (fileObjList == null) {
			throw new FileNotFoundException(directoryPath + " does not exist.");
		}
		for (File file : fileObjList) {
			if (file.isFile()) {
				filesList.add(file.getAbsolutePath());
			}
		}
		return filesList;
	}
}