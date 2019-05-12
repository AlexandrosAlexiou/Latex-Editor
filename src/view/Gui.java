package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import controller.LatexEditorController;
import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Gui extends Application implements Initializable{

	private boolean letter=false;
	private boolean article=false;
	private Stage window;
	private boolean alreadySaved=false;
	private String storageStrategy="Volatile";
	private boolean versionTracking=true;
	@FXML private MenuBar myMenuBar;
	@FXML private Text myLabel;
	@FXML private Menu saveStrategy;
	@FXML private TextArea myText;
	@FXML private CheckMenuItem onBox;
	@FXML private CheckMenuItem offBox;
	@FXML private CheckMenuItem volatileBox;
	@FXML private CheckMenuItem stableBox;
	private LatexEditorController controller=new LatexEditorController();

	public Gui(){}

	@Override
	public void start(Stage primaryStage)throws Exception{
		Parent root;
		root=FXMLLoader.load(getClass().getResource("first.fxml"));
		window=primaryStage;
		primaryStage.setTitle("3A LaTeX Editor");
		Image image=new Image("/images/tex.jpg");
		window.getIcons().add(image);
		primaryStage.setScene(new Scene(root,600,750));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e->{
			e.consume();
			closeProgram();
		});
	}

	/*
	 * This method sets defaults for the application window
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		onBox.setSelected(true);
		volatileBox.setSelected(true);

	}

	@FXML
	private void save(){
		String text=myText.getText();
		String pathSave;
		FileChooser fc=new FileChooser();
		Window stage=myMenuBar.getScene().getWindow();
		fc.setTitle("Save File as");
		fc.setInitialFileName("template");
		fc.getExtensionFilters().add(new ExtensionFilter("TeX Files","*.tex"));
		File file=fc.showSaveDialog(stage);

		if (file!=null) {
			fc.setInitialDirectory(file.getParentFile());
			pathSave=file.getPath();
			System.out.println("Path to save is:"+pathSave);
			alreadySaved=true;
			System.out.println(alreadySaved);
			//controller.saveTemplateDocument(pathSave,text);
		}
		else {
			System.out.println("Invalid save file");
		}

	}

	public void viewReportTemplate(){
		boolean result=ConfirmBox.display("Warning","Opening a new template.Are you sure?");
		if(result) {
			alreadySaved=false;
			letter=false;
			article=false;
			myText.setText(this.controller.enact("CreateDocumentCommand","report"));
			myLabel.setText("Report");
		}
	}

	public void viewLetterTemplate(){
		boolean result=ConfirmBox.display("Warning","Opening a new template.Are you sure?");
			if(result) {
				alreadySaved=false;
				letter=true;
				article=false;
				myText.setText(this.controller.enact("CreateDocumentCommand","letter"));
				myLabel.setText("Letter");
			}
	}

	public void viewBookTemplate(){
		boolean result=ConfirmBox.display("Warning","Opening a new template.Are you sure?");
		if(result) {
			alreadySaved=false;
			letter=false;
			article=false;
			myText.setText(this.controller.enact("CreateDocumentCommand","book"));
			myLabel.setText("Book");
		}
	}

	public void viewArticleTemplate(){
		boolean result=ConfirmBox.display("Warning","Opening a new template.Are you sure?");
		if(result) {
			alreadySaved=false;
			article=true;
			letter=false;
			myText.setText(this.controller.enact("CreateDocumentCommand","article"));
			myLabel.setText("Article");
		}
	}

	@FXML
	private void enableVersionTracking(){
		if( onBox.isSelected()) {
			offBox.setSelected(false);
            versionTracking=true;
            saveStrategy.setVisible(true);
			//TODO code to turn on document history
		}
		else {
			offBox.setSelected(true);
			versionTracking=false;
			saveStrategy.setVisible(false);
		}
	}
	@FXML
	private void disableVersionTracking(){
		if( offBox.isSelected()) {
			onBox.setSelected(false);
			versionTracking=false;
			saveStrategy.setVisible(false);
			//TODO code to turn off document history

		}
		else {
			onBox.setSelected(true);
			versionTracking=true;
			saveStrategy.setVisible(true);
		}
	}

	@FXML
	private void enableVolatileStrategy(){
		if( volatileBox.isSelected()) {
			stableBox.setSelected(false);
			storageStrategy="Volatile";
			//TODO code to turn on volatile history

		}
		else {
			stableBox.setSelected(true);
			storageStrategy="Stable";
		}
	}
	@FXML
	private void enableStableStrategy(){
		if( stableBox.isSelected()) {
			volatileBox.setSelected(false);
			storageStrategy="Stable";
			//TODO code to turn on Stable history
		}
		else{
			volatileBox.setSelected(true);
			storageStrategy="Volatile";
		}
	}

	@FXML
	private void openFile(){
        String path;
		FileChooser fc=new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("TeX Files","*.tex"));
		File selected=fc.showOpenDialog(null);
		if (selected!=null) {
			path=selected.getAbsolutePath();
			System.out.println("This is the path:"+path);
			//myText.setText(controller.enact("Load"));
		}
		else {
			System.out.println("Invalid File");
		}
	}

	@FXML
	private void closeFile(){
		boolean result=ConfirmBox.display("Warning","All unsaved progress will be lost.Are you sure?");
		if(result) {
			window=(Stage)myMenuBar.getScene().getWindow();
			window.close();
		}

	}

	@FXML
	private void addChapter(){
		if ((article)||(letter)){
			alert.display("Warning", "Chapter not applicable in this template format");
		}
		else {
			myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddChapter"));
		}
	}

	@FXML
	private void addSection(){
		if(letter) {
			alert.display("Warning", "Section not applicable in this template format");
		}
		else {
			myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddSection"));

		}
	}

	@FXML
	private void addSubsection(){
		if (letter) {
			alert.display("Warning", "Subsection not applicable in this template format");
		}
		else {
			myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddSubSection"));
		}
	}

	@FXML
	private void addSubsubsection(){
		if (letter) {
			alert.display("Warning", "Subsubsection not applicable in this template format");
		}
		else {
			myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddSubSubSection"));
		}
	}

	@FXML
	private void addItemList(){
		myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddItemList"));
	}


	@FXML
	private void addEnumList(){
		myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddEnumList"));

	}

	@FXML
	private void addBullet(){
		myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddItem"));

	}

	@FXML
	private void addEnum(){
		myText.insertText(myText.getCaretPosition(),controller.enact("AddLatexCommand","AddItem"));
	}

    public void showInfo(){
        alert.displayI("Info", "This is the gui for a LaTeX editor");
    }

    private void closeProgram(){
        boolean result=ConfirmBox.display("Warning","All unsaved progress will be lost.Are you sure?");
        if(result) {
            window.close();
        }
    }
	public static void main(String[] args){
		Gui gui = new Gui();
		launch(args);

	}
}

