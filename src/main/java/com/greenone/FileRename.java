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
			if (file.isDirectory()) {
				System.out.println("folder");
				//работаем с папкой
				takeAllInRecursion(Arrays.asList(file.listFiles()), accDTO);
			} else {
				System.out.println("file");
				//работаем с файлами
				renameFile(file, accDTO);
			}
		}
	}

	private static void renameFile(File file, AccDTO accDTO) {
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
//					numberOfSuccess++;
					accDTO.setNumberOfSuccess(accDTO.getNumberOfSuccess() + 1);
				} catch (IOException e) {
					e.printStackTrace();
//					numberOfWarning++;
					accDTO.setNumberOfWarning(accDTO.getNumberOfWarning() + 1);
				}
			} else {
//				numberOfNone++;
				accDTO.setNumberOfNone(accDTO.getNumberOfNone() + 1);
			}

		} else {
//			numberOfWarning++;
			accDTO.setNumberOfWarning(accDTO.getNumberOfWarning() + 1);
		}
	}
}
