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

				System.out.println(fileNameFilter(f));

			}
		}
	}

	// Метод фильтрации, отбор файлов с нумерацией
	private static String fileNameFilter(File f) {
		String fileName = f.getName();
		Scanner scanner = null;
		String fileNameNumber = null;

		//fileNameNumber =  fileName.split("\\D+");

		// Делим на две части, по не цифре (не по факту проверенная не цифра не "съедается")
		String[] str_array = fileName.split("(?=\\D)", 2);
		// Убираем все не цифры
		String string_1 = str_array[0].replaceAll("\\D", "");
		String string_2 = str_array[1];

		// Если в певрой части число, то редактируем вторую чать
		if (string_1.matches("[0-9]+")) {
			// Убиравем все что перед первым словом (не нумирацией)
			string_2 = str_array[1].replaceFirst( "\\s+", "");
		}

//		System.out.println(string_1);
//		System.out.println(string_2);

//		for (String word : str_array) {
//			System.out.print(word + "|");
//		}

		String sum = string_1 + " ||| " + string_2;

		return sum;
	}


}
