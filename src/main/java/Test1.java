import java.io.File;

public class Test1 {
	public static void main(String[] args) {

		//здесь указываем абсолютный путь к файлу
		File file = new File("src/main/resources/IN/[1] B.mp3");
		File newFile = new File("src/main/resources/IN/1 - B.mp3");
		if(file.renameTo(newFile)){
			System.out.println("Файл переименован успешно");
		}else{
			System.out.println("Файл не был переименован");
		}

	}
}
