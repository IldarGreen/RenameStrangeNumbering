package com.greenone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileRename {
	static int numberOfSuccess;
	static int numberOfNone;
	static int numberOfWarning;



	public static void takeListOfFile(List<File> list) {

		takeAllInRecursion(list);

		System.out.println("После рекурсии");

		AllAlert.AccumulatorOfMessage(numberOfSuccess, numberOfNone, numberOfWarning);

		System.out.println("После вызова Alert'а");

		numberOfSuccess = 0;
		numberOfNone = 0;
		numberOfWarning = 0;
	}

	private static void takeAllInRecursion (List<File> list) {
		System.out.println("method is called");
		for (File file : list) {
			if (file.isDirectory()) {
				System.out.println("folder");
				//работаем с папкой
				takeAllInRecursion(Arrays.asList(file.listFiles()));
			} else {
				System.out.println("file");
				//работаем с файлами
				renameFile(file);
			}
		}
	}

	private static void renameFile(File file) {

		String fileName = file.getName();
		Path source = Paths.get(file.getAbsolutePath());

		// Делим на две части, по не цифре (но по факту проверенная не цифра не "съедается")
		String[] stringFullName = fileName.split("(?=\\D)", 2);
		String stringNumber = stringFullName[0];
		String stringName = stringFullName[1];

		stringNumber = stringFullName[0].replaceAll("\\D", "");//Убираем все что не цифра
		//Если первая часть состоит из цифр, то редактируем название
		if (stringNumber.matches("[0-9]+")) {
			// Если одна цифра, то меняем на двузначное число начиная с ноля ( 01 )
			if (stringNumber.length() <= 1) {
				stringNumber = "0" + stringNumber;
			}

			// Делим по началу Названия
			String[] stringNameSplit = stringName.split("\\b", 2);
			String stringJustName = stringNameSplit[1];

			String newFileName = stringNumber + " - " + stringJustName;

			// Преименовываем файл
			if (!fileName.equals(newFileName)) {
				try {
					// rename a file in the same directory
					Files.move(source, source.resolveSibling(newFileName));
//					AllAlert.showInfoAlertSuccess();
					numberOfSuccess++;
				} catch (IOException e) {
					e.printStackTrace();
//					AllAlert.showWarningAlert();
					numberOfWarning++;
				}
			} else {
//				AllAlert.showInfoAlertNone();
				numberOfNone++;
			}

		} else {
//			AllAlert.showInfoAlertNone();
			numberOfWarning++;
		}
	}
}
