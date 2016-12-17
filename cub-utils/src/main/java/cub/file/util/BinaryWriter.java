package cub.file.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryWriter {

	public static File writeByteArrayToFile(String filePath, byte[] byteArray) throws IOException {
		return writeByteArrayToFile(new File(filePath), byteArray);
	}

	public static File writeByteArrayToFile(File file, byte[] byteArray) throws IOException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			fileOutputStream.write(byteArray);
			fileOutputStream.flush();
		}
		return file;
	}
}