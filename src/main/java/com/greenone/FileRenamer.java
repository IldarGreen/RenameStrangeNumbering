package com.greenone;

import java.io.File;
import java.util.List;

public class FileRenamer {

	public static void rename(List<File> list) {

		for (File file : list) {
			try {
				System.out.println(file.getAbsolutePath());
			} catch (NullPointerException e) {
				//e.printStackTrace();
				System.out.println("File or Directory not choose or exist");
			}
		}
	}

	public static void rename(File file) {
		try {
			System.out.println(file.getAbsolutePath());
		} catch (NullPointerException e) {
			//e.printStackTrace();
			System.out.println("File or Directory not choose or exist");
		}
	}
}
