import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SearchScreen extends Screen
{
	private TableView table = new TableView();
	//children/elements/stuff
	private Label search = new Label("Search ");
	private int userSelect = 0;
	//private Label passPrompt = new Label("Password: ");
	//private Label loginText = new Label("Log-in");
    private TextField searchText = new TextField();
  	private TextArea passText = new TextArea();
	public Button searchButton = new Button("Search");
	    //public Button newAcc = new Button("Create Account");
	private Label errorText = new Label("\n");
	//private Label confirmText = new Label("\nIT FUCKING WORKED IDIOT");
	String username = "";
	String password = "";
	
	
	
	public SearchScreen()
    {
		PostgreSQLJDBC demo;
		
		demo = new PostgreSQLJDBC();
    	//set up centerLogin formatting
    	GridPane centerLogin = new GridPane();
//        centerLogin.setPadding(new Insets(10, 10, 10, 10));	
        centerLogin.setAlignment(Pos.CENTER);
        centerLogin.setHgap(20);
        centerLogin.setVgap(15);   

        //add the username and password prompts and textfields to the center bit
        centerLogin.setConstraints(search, 0, 0);
        centerLogin.setConstraints(searchText, 0, 1);
        centerLogin.setConstraints(searchButton, 1, 1);
        //centerLogin.setConstraints(passText, 2, 0);
        //centerLogin.setConstraints(passPrompt, 0, 1);
        //centerLogin.setConstraints(passText, 1, 1);
        centerLogin.getChildren().addAll(search, searchText, searchButton);
        
        
        
        //organize the side to select user type
        VBox rightUserType = new VBox();
        rightUserType.setSpacing(10);
        rightUserType.setAlignment(Pos.CENTER_LEFT);
        ToggleGroup radio1 = new ToggleGroup();
        Label searchType = new Label("Search Type:");
        
        //make the radio buttons for user type
        RadioButton bookButton = new RadioButton("Books");
        RadioButton publisherButton = new RadioButton("Publishers");
        RadioButton reserveButton = new RadioButton("Reserved");
        bookButton.setToggleGroup(radio1);
        publisherButton.setToggleGroup(radio1);
        reserveButton.setToggleGroup(radio1);
        //add children to VBox
        rightUserType.getChildren().addAll(searchType, bookButton, publisherButton, reserveButton);
        passText.setEditable(false);
        bookButton.setOnAction(new EventHandler<ActionEvent>() 
        {
			@Override
			public void handle(ActionEvent event) 
			{
				if(bookButton.isSelected()) 
				{
					passText.setText(demo.selectBookQuery());
				}
			}
        });
        publisherButton.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent event) 
			{
				if(publisherButton.isSelected()) 
				{
					passText.setText(demo.selectPublisherQuery());
				}
			}
        });
        reserveButton.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent event) 
			{
				if(reserveButton.isSelected()) 
				{
					passText.setText(demo.selectReservationQuery());
				}
			}
        });
        
        searchButton.setOnAction(new EventHandler<ActionEvent>() 
        {
        	@Override
			public void handle(ActionEvent event) 
			{
        		String content = searchText.getText();
        		if(bookButton.isSelected() && searchText.getText() != "") 
				{
        			passText.setText(demo.selectFromBookQuery(content));
				}
        		else if(publisherButton.isSelected() && searchText.getText() != "") 
        		{
        			passText.setText(demo.selectFromPublisherQuery(content));
        		}
        		else if(reserveButton.isSelected() && searchText.getText() != "")
        		{
        			passText.setText(demo.selectFromReservationQuery(content));
        		}
			}
        });
             
        HBox lowerButtons = new HBox();
        lowerButtons.setAlignment(Pos.CENTER);
        lowerButtons.setSpacing(30);
        lowerButtons.getChildren().addAll(errorText, passText);//, newAcc);

        //VBox upperStuff = new VBox();
        //upperStuff.setAlignment(Pos.CENTER);
        //upperStuff.setSpacing(10);
        //upperStuff.getChildren().addAll(passText, errorText, confirmText);
        errorText.setTextFill(Color.RED);
        
        //add the components to the wanted areas
        this.setPadding(new Insets(100, 50, 100, 50));	
        this.setAlignment(passText, Pos.TOP_CENTER);
        this.setCenter(centerLogin);
        //this.setTop(upperStuff);
        this.setRight(rightUserType);
        this.setBottom(lowerButtons);
    }
	
	public SearchScreen(String u, String p) 
	{
		username = u;
		password = p;
	}
	
	public int getUserType()
    {
    	return userSelect;
    }
    
    public void noInputs()
    {
    	errorText.setText("\nPlease enter username and/or password");
    }
    
    public void wrongPass()
    {
    	errorText.setText("\nUsername or Password Incorrect");
    }
    
    public void resetErrorText()
    {
    	errorText.setText("\n");
    }
    
}
