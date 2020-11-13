package gr.uoi.latexeditor.view;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.geometry.*;


public class alert {
	public static void display(String title,String message) {
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label=new Label();
		label.setText(message);
		Button closeButton=new Button("OK");
		closeButton.setOnAction(e->window.close());
		VBox layout =new VBox(20);
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene=new Scene(layout,300,250);
		window.setScene(scene);
		window.showAndWait();
	}
	public static void displayI(String title,String message) {
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);

//		Image image=new Image("/assets/info.png");
//		window.getIcons().add(image);

		window.setTitle(title);
		window.setMinWidth(250);
		Label label=new Label();
		label.setText(message);
		Button closeButton=new Button("OK");
		closeButton.setOnAction(e->window.close());
		VBox layout =new VBox(20);
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene=new Scene(layout,300,250);
		window.setScene(scene);
		window.showAndWait();
	}
}
