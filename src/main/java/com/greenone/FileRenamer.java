package com.greenone;

import java.io.File;
import java.util.List;

public class FileRenamer {

	public static void takeFile(List<File> list) {

		for (File file : list) {
			try {
				renameFile(file);
			} catch (NullPointerException e) {
				//e.printStackTrace();
				System.out.println("File or Directory not choose or exist");
			}
		}
	}

	public static void takeFile(File file) {
		try {
			renameFile(file);
		} catch (NullPointerException e) {
			//e.printStackTrace();
			System.out.println("File or Directory not choose or exist");
		}
	}

	private static void renameFile(File file) {
		String fileName = file.getName();
		String pathToFile = file.getAbsolutePath();
		String pathToFolder =  file.getParent();

//		System.out.println(fileName);
//		System.out.println(pathToFile);
//		System.out.println(pathToFolder);

		// Делим на две части, по не цифре (но по факту проверенная не цифра не "съедается")
		String[] str_array1 = fileName.split("(?=\\D)", 2);

		String string1_number = str_array1[0].replaceAll("\\D", "");//Убираем все что не цифра

		//Если в певрой части было число, то редактируем название
		if (string1_number.matches("[0-9]+")) {

			// Если одна цифра, то делаем двузначное число начиная с ноля ( 01 )
			if (string1_number.length() <= 1) {
				string1_number = "0" + string1_number;
			}

			String string2 = str_array1[1];
			// Делим по началу Названия
			String[] str_array2 = string2.split("\\b", 2);
			String string4_name = str_array2[1];

			// Преименовываем файл
			File oldFile = new File(pathToFile);
			File newFile = new File(pathToFolder + "\\" + string1_number + " - " + string4_name);


			if (oldFile.renameTo(newFile)) {
				System.out.println("Файл переименован успешно");
			} else {
				System.out.println("Файл не был переименован");
			}
		}


	}
}
