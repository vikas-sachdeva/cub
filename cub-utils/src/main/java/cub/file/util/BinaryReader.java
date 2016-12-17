package cub.file.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BinaryReader {

	private static final int BUFFER_SIZE = 1024 * 10;

	public static byte[] getInputStreamContentAsByteArray(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		byte[] resultByteArray = new byte[0];
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
			int bytesRead = bufferedInputStream.read(buffer);
			while (bytesRead != -1) {
				byte[] temp = new byte[resultByteArray.length];
				System.arraycopy(resultByteArray, 0, temp, 0, resultByteArray.length);
				resultByteArray = new byte[resultByteArray.length + bytesRead];
				System.arraycopy(temp, 0, resultByteArray, 0, temp.length);
				System.arraycopy(buffer, 0, resultByteArray, temp.length, bytesRead);
				bytesRead = bufferedInputStream.read(buffer);
			}
		}
		return resultByteArray;
	}

	public static byte[] getFileContentAsByteArray(String filePath) throws FileNotFoundException, IOException {
		return getInputStreamContentAsByteArray(new FileInputStream(filePath));
	}
}
