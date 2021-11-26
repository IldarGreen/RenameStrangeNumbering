package com.greenone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileRename {
	public static void takeListOfFile(List<File> list) {
		AccDTO accDTO = new AccDTO();
		takeAllInRecursion(list, accDTO);
		AllAlert.AccumulatorOfMessage(accDTO);
	}

	private static void takeAllInRecursion(List<File> list, AccDTO accDTO) {
		for (File file : list) {
			if (file.exists()) {
				if (file.isFile()) {
					renameFile(file, accDTO);//working with the file
				} else {
					try {
						takeAllInRecursion(Arrays.asList(file.listFiles()), accDTO);//working with the folder
					} catch (NullPointerException e) {
						e.printStackTrace();
						accDTO.setNumberOfWarnFolder(accDTO.getNumberOfWarnFolder() + 1);
					}
				}
			} else {
				accDTO.setNumberOfWarning(accDTO.getNumberOfWarning() + 1);
			}
		}

	}

	private static void renameFile(File file, AccDTO accDTO) {
		String fileName = file.getName();
		Path source = Paths.get(file.getAbsolutePath());

		String[] stringFullName = fileName.split("(?=\\D)", 2);// divide into two parts, by not a number
		String stringNumber = stringFullName[0].replaceAll("\\D", "");//only numbers remain
		String[] stringNameSplit = stringFullName[1].split("\\b", 2);// divide by the beginning of the names
		String stringJustName = stringNameSplit[1];

		//if the first part consists of numbers, then edit the name
		if (stringNumber.matches("[0-9]+")) {
			//if we have one digit, then we change it to a two-digit number starting from zero (01)
			if (stringNumber.length() <= 1) {
				stringNumber = "0" + stringNumber;
			}

			String newFileName = stringNumber + " - " + stringJustName;//form a new file name

			//rename a file
			if (!fileName.equals(newFileName)) {
				try {
					Files.move(source, source.resolveSibling(newFileName));//rename a file in the same directory
					accDTO.setNumberOfSuccess(accDTO.getNumberOfSuccess() + 1);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Files not move");
					accDTO.setNumberOfWarning(accDTO.getNumberOfWarning() + 1);
				}
			} else {
				accDTO.setNumberOfNone(accDTO.getNumberOfNone() + 1);
			}

		} else {
			accDTO.setNumberOfNone(accDTO.getNumberOfNone() + 1);
		}
	}
}
