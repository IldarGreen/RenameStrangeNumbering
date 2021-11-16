import javafx.application.Application;
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
		button.setOnAction(e -> {
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			System.out.println(selectedFile.getAbsolutePath());
		});

		Button button2 = new Button("Select Directory");
		//создаем EventHandler
		button2.setOnAction(e -> {
			File selectedDirectory = directoryChooser.showDialog(primaryStage);
			System.out.println(selectedDirectory.getAbsolutePath());
		});

		VBox vBox = new VBox(button, button2);
		vBox.setAlignment(Pos.BASELINE_CENTER);
		Scene scene = new Scene(vBox, 300, 200);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
}