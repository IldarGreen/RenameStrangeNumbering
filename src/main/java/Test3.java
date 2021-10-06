public class Test3 {
	public static void main(String[] args) {
		String string = "[10 Alina Orlova - cat.mp3";

		String[] str_array1 = string.split("(?=\\D)", 2);

		String string1 = str_array1[0].replaceAll("[^0-9]","");
		String string2 = str_array1[1];

		System.out.println(string1);
		System.out.println(string2);


		String[] str_array2 = string2.split("(\\b)", 2);

		String string3 = str_array2[0];
		String string4 = str_array2[1];

		System.out.println(string3);
		System.out.println(string4);
	}
}
