import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.util.List;

public class JFXFileChooserAndDaD1 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("FileChooserAndDaD");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.setResizable(false);
		Image icon =  new Image(getClass().getResourceAsStream("icon2.jpg"));
		primaryStage.getIcons().add(icon);

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select files");
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Select directory");

		Button button1 = new Button("Select Files");
		button1.setMinSize(100, 25);
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
				if (list != null) {
					for (File selectedFile : list) {
						fileChooser.setInitialDirectory(selectedFile.getParentFile());
						showChoose(selectedFile);
					}
				}
			}
		});

		Button button2 = new Button("Select Directory");
		button2.setMinSize(100, 25);
		//создаем EventHandler
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				File selectedDirectory = directoryChooser.showDialog(primaryStage);
				if (selectedDirectory != null) {
					directoryChooser.setInitialDirectory(selectedDirectory.getParentFile());
				}
				showChoose(selectedDirectory);
			}
		});

		Text text = new Text("\n Or Drop File to Upload");
		VBox vBox = new VBox(4, button1, button2, text);
		vBox.setAlignment(Pos.BASELINE_CENTER);

		Scene scene = new Scene(vBox, 300, 200);

		//Change the icon of the dragged object
		scene.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				if (db.hasFiles()) {
					event.acceptTransferModes(TransferMode.COPY);
				} else {
					event.consume();
				}
			}
		});

		// Dropping over surface
		scene.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasFiles()) {
					success = true;
					String filePath = null;
					for (File file : db.getFiles()) {
						filePath = file.getAbsolutePath();
						showChoose(file);
					}
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});

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
