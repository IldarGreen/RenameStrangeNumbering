import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2Consol {
	public static void main(String[] args) {

		String dir = new String("C:\\Users\\magiccat\\Desktop\\Алина Орлова - Daybreak 2018");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("enter path to file");
//		String dir = scanner.nextLine();
//		System.out.println(dir);

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

				renameFile(dir, f, strings);
			}
		}
	}

	// Метод фильтрации, отбор файлов с нумерацией, и деление на номер и назвакие трека
	private static String[] fileNameSeporater(File f) {
		String fileName = f.getName();
		String[] numberAndName = new String[2];

		// Делим на две части, по не цифре (но по факту проверенная не цифра не "съедается")
		String[] str_array1 = fileName.split("(?=\\D)", 2);

		String string1_number = str_array1[0].replaceAll("\\D", "");//Убираем все что не цифра

		//Если в певрой части было число, то редактируем название
		if (string1_number.matches("[0-9]+")) {

			String string2 = str_array1[1];

			//  Делим по началу Названия
			String[] str_array2 = string2.split("\\b", 2);

			String string4_name = str_array2[1];

			numberAndName[0] = string1_number;
			numberAndName[1] = string4_name;
		} else {
			return str_array1;
		}

		return numberAndName;
	}

	// Метод переиминовывания файла
	private static void renameFile(String dir, File f, String[] strings) {
		System.out.println(strings[0]);
		System.out.println(strings[1]);

		// Если строка с номером пута, то значит его нет и файл не переименовываем
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
