package com.greenone;

import javafx.scene.control.Alert;

public class AllAlert {
	public static void AccumulatorOfMessage(AccDTO accDTO) {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(null);
		alert.setHeaderText(null);
		alert.setContentText("Файл переименован успешно :" + accDTO.getNumberOfSuccess() + "\n" +
							"Файл не нуждается в переименовывании : " + accDTO.getNumberOfNone() + "\n" +
							"File not exist :" + accDTO.getNumberOfWarning());
		alert.showAndWait();
	}
}
