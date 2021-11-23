package com.greenone;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileRename {

	public static void takeListOfFile(List<File> list) {
		for (File file : list) {
			if (file.isDirectory()) {
				//работаем с папкой
				takeListOfFile(Arrays.asList(file.listFiles()));
			} else {
				//работаем с файлами
				try {
					renameFile(file);
				} catch (NullPointerException e) {
					AllAlert.showWarningAlert();
//					System.out.println("File not exist!");
				}
			}
		}
	}

	private static void renameFile(File file) {
		String fileName = file.getName();
		String pathToFile = file.getAbsolutePath();
		String pathToFolder = file.getParent();

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

			// Преименовываем файл
			File oldFile = new File(pathToFile);
			File newFile = new File(pathToFolder + "\\" + stringNumber + " - " + stringJustName);

			if (!oldFile.getAbsolutePath().equals(newFile.getAbsolutePath())) {
				if (oldFile.renameTo(newFile)) {
					AllAlert.showInfoAlertSuccess();
//					System.out.println("Файл переименован успешно");
				}
			} else {
				AllAlert.showInfoAlertNone();
//				System.out.println("Файл не нуждается в переименовывании 2");
			}

		} else {
			AllAlert.showInfoAlertNone();
//			System.out.println("Файл не нуждается в переименовывании 1");
		}
	}
}
