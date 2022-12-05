/*
 * Filename: LoginScreen.java
 * Class: LoginScreen
 * Description: This is a pane we use for the initial login screen
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LoginScreen extends Screen 
{
    //children/elements/stuff
	private Label userPrompt = new Label("Username: ");
    private Label passPrompt = new Label("Password: ");
    private Label loginText = new Label("Log-in");
    private TextField userText = new TextField();
    private PasswordField passText = new PasswordField();
    public Button confirm = new Button("Log in");
    //public Button newAcc = new Button("Create Account");
    private int userSelect = 0;
    private Label errorText = new Label("\n");
    private Label confirmText = new Label("\n");

    public LoginScreen()
    {
    	//set up centerLogin formatting
    	GridPane centerLogin = new GridPane();
//        centerLogin.setPadding(new Insets(10, 10, 10, 10));	
        centerLogin.setAlignment(Pos.CENTER);
        centerLogin.setHgap(20);
        centerLogin.setVgap(15);   

        //add the username and password prompts and textfields to the center bit
        centerLogin.setConstraints(userPrompt, 0, 0);
        centerLogin.setConstraints(userText, 1, 0);
        centerLogin.setConstraints(passPrompt, 0, 1);
        centerLogin.setConstraints(passText, 1, 1);
        centerLogin.getChildren().addAll(userPrompt, userText, passPrompt, passText);
        
        //organize the side to select user type
        /*VBox rightUserType = new VBox();
        rightUserType.setSpacing(10);
        rightUserType.setAlignment(Pos.CENTER_LEFT);
        ToggleGroup radio1 = new ToggleGroup();
        Label userType = new Label("User Type:");
        
        //make the radio buttons for user type
        RadioButton patientButton = new RadioButton("Patient");
        RadioButton nurseButton = new RadioButton("Nurse");
        RadioButton doctorButton = new RadioButton("Doctor");
        patientButton.setToggleGroup(radio1);
        nurseButton.setToggleGroup(radio1);
        doctorButton.setToggleGroup(radio1);
        //add children to VBox
        rightUserType.getChildren().addAll(userType, patientButton, nurseButton, doctorButton);
        patientButton.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent event) 
			{
				if(patientButton.isSelected()) 
				{
					userSelect = 1;
				}
			}
        });
        nurseButton.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent event) 
			{
				if(nurseButton.isSelected()) 
				{
					userSelect = 2;
				}
			}
        });
        doctorButton.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent event) 
			{
				if(doctorButton.isSelected()) 
				{
					userSelect = 3;
				}
			}
        });*/
        
        HBox lowerButtons = new HBox();
        lowerButtons.setAlignment(Pos.CENTER);
        lowerButtons.setSpacing(30);
        lowerButtons.getChildren().addAll(confirm);//, newAcc);

        VBox upperStuff = new VBox();
        upperStuff.setAlignment(Pos.CENTER);
        upperStuff.setSpacing(10);
        upperStuff.getChildren().addAll(loginText, errorText, confirmText);
        errorText.setTextFill(Color.RED);
        
        //add the components to the wanted areas
        this.setPadding(new Insets(100, 50, 100, 50));	
        this.setAlignment(loginText, Pos.TOP_CENTER);
        this.setCenter(centerLogin);
        this.setTop(upperStuff);
        //this.setRight(rightUserType);
        this.setBottom(lowerButtons);
    }
    
    public int getUserType()
    {
    	return userSelect;
    }
    
    public String getUsername()
    {
    	return userText.getText();
    }
    
    public String getPassword()
    {
    	return passText.getText();
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
    
    public void goodUser()
    {
    	confirmText.setText("\nUsername and Password were found");
    }
    
//    private class UserSelectHandler implements EventHandler<ActionEvent>
//    {
//    	public void handle(ActionEvent event) 
//    	{
//    		
//    	}
//    }
}