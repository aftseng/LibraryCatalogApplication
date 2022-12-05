import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LibraryRunner extends Application 
{
	private StackPane rootPane;
	private Portal portal;
	
	public void start(Stage arg0)
	{
	    portal = new Portal();
	 	
	    //put gui on top of the rootPane
	    rootPane = new StackPane();
	    rootPane.getChildren().add(portal);
	    rootPane.setAlignment(portal, Pos.CENTER);
	   
	    // Create a scene and place rootPane in the arg0 stage
	    Scene scene = new Scene(rootPane, 852, 480);
	    arg0.setTitle("CSE412 Group 20 Library Catalog"); //I dunno, working name
	    arg0.setScene(scene); // Place the scene in the stage  
	      
	    arg0.show(); // Display the stage, arg0 is second so it auto-selects it	      
	}
			
	public static void main(String[] args)
	{
		launch(args);
	}
}
