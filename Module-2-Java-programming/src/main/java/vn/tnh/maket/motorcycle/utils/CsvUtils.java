package vn.tnh.maket.motorcycle.utils;

import vn.tnh.maket.motorcycle.exception.TextFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
	public static List<String> read(String filePath) {
		try {
			List<String> records = new ArrayList<>();
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException(String.format("File %s not found", filePath));
			}
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bufferedReader.readLine()) != null && !line.trim().isEmpty()) {
				records.add(line);
			}
			bufferedReader.close();
			return records;
		} catch (IOException exception) {
			throw new TextFileException(exception);
		}
	}
	
	public static <T> void write(String filePath, List<T> records) {
		try {
			File file = new File(filePath);
			if (!file.exists() && !file.createNewFile()) {
				throw new IOException(String.format("create new file %s error", filePath));
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			
			for (Object record: records) {
				bufferedWriter.write(record.toString());
				bufferedWriter.write(System.getProperty("line.separator"));
			}
			bufferedWriter.close();
		} catch (IOException exception) {
			throw new TextFileException(exception);
		}
	}
}
