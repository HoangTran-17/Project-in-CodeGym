package vn.tnh.maket.motorcycle.utils;

import vn.tnh.maket.motorcycle.exception.TextFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileUtils {
	public static String read(String filePath) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException(String.format("File %s not found", filePath));
			}
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null && !line.trim().isEmpty()) {
				builder.append(line);
			}
			bufferedReader.close();
			return builder.toString();
		} catch (IOException exception) {
			throw new TextFileException(exception);
		}
	}
	
	public static void write(String filePath, String content) {
		try {
			File file = new File(filePath);
			if (!file.exists() && !file.createNewFile()) {
				throw new IOException(String.format("create new file %s error", filePath));
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException exception) {
			throw new TextFileException(exception);
		}
	}
}
