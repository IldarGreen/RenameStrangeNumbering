import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class JFXFileChooser1 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Rename App");

		FileChooser fileChooser = new FileChooser();
		DirectoryChooser directoryChooser = new DirectoryChooser();

		Button button = new Button("Select File");
		//создаем EventHandler
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				File selectedFile = fileChooser.showOpenDialog(primaryStage);
				showChoose(selectedFile);
			}
		});

		button.getOnAction();

		Button button2 = new Button("Select Directory");
		//создаем EventHandler
		button2.setOnAction(e -> {
			File selectedDirectory = directoryChooser.showDialog(primaryStage);
			showChoose(selectedDirectory);
		});

		VBox vBox = new VBox(button, button2);
		vBox.setAlignment(Pos.BASELINE_CENTER);
		Scene scene = new Scene(vBox, 300, 200);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void showChoose(File file) {
		try {
			System.out.println(file.getAbsolutePath());
		} catch (NullPointerException e) {
			//e.printStackTrace();
			System.out.println("File or Directory not choose or exist");
		}
	}


}