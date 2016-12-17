package cub.file.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileCopier {

	public static void copyLargeFile(String sourceFilePath, String destinationFilePath) throws IOException {
		copyLargeFile(new File(sourceFilePath), new File(destinationFilePath));

	}

	@SuppressWarnings("resource")
	public static void copyLargeFile(File sourceFile, File destinationFile) throws IOException {
		try (FileChannel inputFileChannel = new FileInputStream(sourceFile).getChannel()) {
			copyLargeChannelInFile(inputFileChannel, destinationFile);
		}
	}

	public static void copyLargeStreamInFile(InputStream inputStream, String destinationFilePath) throws IOException {
		copyLargeStreamInFile(inputStream, new File(destinationFilePath));
	}

	public static void copyLargeStreamInFile(InputStream inputStream, File destinationFile) throws IOException {
		try (ReadableByteChannel inputChannel = Channels.newChannel(inputStream)) {
			copyLargeChannelInFile(inputChannel, destinationFile);
		}
	}

	@SuppressWarnings("resource")
	public static void copyLargeChannelInFile(ReadableByteChannel inputChannel, File destinationFile)
			throws IOException {
		long offset = 0;
		long noOfBytesToTransferred = 1024 * 1024;
		long bytesTransferred;
		/**
		 * Closing FileChannel also closes underlying file streams. So, there is
		 * no need to close file streams separately.
		 */
		try (FileChannel outputFileChannel = new FileOutputStream(destinationFile).getChannel()) {
			while ((bytesTransferred = outputFileChannel.transferFrom(inputChannel, offset,
					noOfBytesToTransferred)) > 0) {
				offset += bytesTransferred;
			}
		}
	}
}