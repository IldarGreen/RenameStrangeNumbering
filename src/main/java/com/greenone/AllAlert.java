package com.greenone;

import javafx.scene.control.Alert;

public class AllAlert {
	public static void AccumulatorOfMessage(AccDTO accDTO) {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(null);
		alert.setHeaderText(null);

		String message = "";

		if (accDTO.getNumberOfSuccess() > 0) {
			message += "Files renamed successfully : " + accDTO.getNumberOfSuccess() + "\n";
		}
		if (accDTO.getNumberOfNone() > 0) {
			message += "Files that do not need to be renamed : " + accDTO.getNumberOfNone() + "\n";
		}
		if (accDTO.getNumberOfWarning() > 0) {
			message += "File does not exist : " + accDTO.getNumberOfWarning() + "\n";
		}
		if (accDTO.getNumberOfWarnFolder() > 0) {
			message += "Folder does not exist : " + accDTO.getNumberOfWarnFolder();
		}
		if (message.length() == 0) {
			message += "No files were found ";
		}

		alert.setContentText(message);
		alert.showAndWait();
	}
}

