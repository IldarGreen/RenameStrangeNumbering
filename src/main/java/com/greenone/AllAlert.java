package com.greenone;

import javafx.scene.control.Alert;

public class AllAlert {
	static int a = 0;
	static int b = 0;
	static int c = 0;

	public static void AccumulatorOfMessage(int numberOfSuccess, int numberOfNone, int numberOfWarning) {
		a += numberOfSuccess;
		b += numberOfNone;
		c += numberOfWarning;

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(null);
		alert.setHeaderText(null);
		alert.setContentText("Файл переименован успешно :" + a + "\n" +
							"Файл не нуждается в переименовывании : "+ b + "\n" +
							"File not exist :" + c);
		alert.showAndWait();
	}
}
