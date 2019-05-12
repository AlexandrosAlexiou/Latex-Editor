package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.geometry.*;

public class ConfirmBox {
	static boolean answer;
	public static boolean display(String title,String message) {
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);	
		Image image=new Image("/images/warn.png");
		window.getIcons().add(image);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label=new Label();
		label.setText(message);
		Button yesButton=new Button("Yes");
		Button noButton=new Button("No");
		
		yesButton.setOnAction(e->{
			answer=true;
			window.close();
		});
		noButton.setOnAction(e->{
			answer=false;
			window.close();
		});

		VBox layout =new VBox(20);
		layout.getChildren().addAll(label,yesButton,noButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene=new Scene(layout,350,300);//300-250
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}
