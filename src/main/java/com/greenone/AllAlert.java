package com.greenone;

import javafx.scene.control.Alert;

public class AllAlert {

	public static void showInfoAlertSuccess() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(null);
		alert.setHeaderText(null);
		alert.setContentText("Файл переименован успешно");

		alert.showAndWait();
	}

	public static void showInfoAlertNone() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(null);
		alert.setHeaderText(null);
		alert.setContentText("Файл не нуждается в переименовывании");

		alert.showAndWait();
	}

	public static void showWarningAlert() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("File not exist!");

		alert.showAndWait();
	}

}
