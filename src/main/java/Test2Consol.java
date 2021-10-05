import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2Consol {
	public static void main(String[] args) {

		String dir = new String("C:\\Users\\magiccat\\Desktop\\Slove - Le Danse 2011");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("enter path to file");
//		String dir = scanner.nextLine();
		System.out.println(dir);

		findFiles(dir);


	}

	// Метод поиска файлов
	private static void findFiles(String dir) {
		File file = new File(dir);

		if (!file.exists())
			System.out.println(dir + " папка не существует");

		File[] listFiles = file.listFiles();

		if (listFiles.length == 0) {
			System.out.println(dir + " не содержит файлов");
		} else {
			for (File f : listFiles) {
				// Вызываем метод переиминовывания

				System.out.println(f.getName());

				String[] strings = fileNameSeporater(f);
//				for (String string : strings) {
//					System.out.println(string);
//				}

				renameFile(dir, f, strings);

			}
		}
	}

	// Метод фильтрации, отбор файлов с нумерацией, и деление на номер и назвакие трека
	private static String[] fileNameSeporater(File f) {
		String fileName = f.getName();
		String[] numberAndName = new String[2];

		// Делим на две части, по не цифре (не по факту проверенная не цифра не "съедается")
		String[] str_array = fileName.split("(?=\\D)", 2);
		// Убираем все не цифры
		String string_1 = str_array[0].replaceAll("\\D", "");
		String string_2 = str_array[1];

		//Если в певрой части число, то редактируем вторую чать
		if (string_1.matches("[0-9]+")) {
			// Убиравем все что перед первым словом
			string_2 = str_array[1].replaceFirst("\\W+", "");
			System.out.println("true");
		}

		//System.out.println(string_1.isEmpty());

//		if (!string_1.isEmpty()) {
//			// Убиравем все что перед первым словом
//			string_2 = str_array[1].replaceFirst("\\W+", "");
//			System.out.println("tttttttttt");
//		} else {
//			string_2 = str_array[1];
//		}


		numberAndName[0] = string_1;
		numberAndName[1] = string_2;

		return numberAndName;
	}

	// Метод переиминовывания файла
	private static void renameFile(String dir, File f, String[] strings) {
		System.out.println(strings[0]);
		System.out.println(strings[1]);

		if (!strings[0].isEmpty()) {
			File file = new File(dir + "\\" + f.getName());
			File newFile = new File(dir + "\\" + strings[0] + " - " + strings[1]);

			if (file.renameTo(newFile)) {
				System.out.println("Файл переименован успешно");
			} else {
				System.out.println("Файл не был переименован");
			}
		}
	}
}
