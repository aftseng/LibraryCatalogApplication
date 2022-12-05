
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class Portal extends StackPane
{
	private Screen mainScreen;
	private LoginScreen login;
	private PostgreSQLJDBC demo;
	//private NewAccountScreen create;
	
	public Portal()
	{
		login = new LoginScreen();
		demo = new PostgreSQLJDBC();
		this.getChildren().add(login);
        login.confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
			@Override
			public void handle(ActionEvent event) 
			{
				if(login.userText.getText().equals("") && login.passText.getText().equals(""))
				{
					login.noInputs();
				}
				else if(login.userText.getText().equals(""))
				{
					login.noUsername();
				}
				else if(login.passText.getText().equals(""))
				{
					login.noPassword();
				}
				else if(login.userText.getText() != "" && login.passText.getText() != "")
				{
					demo.selectFromAuthenticateQuery(login.userText.getText(), login.passText.getText());
					if(PostgreSQLJDBC.result == true)
					{
						mainScreen = new SearchScreen();
						swapScreens();
					}
					else
					{
						login.wrongPass();
					}
				}
				else
				{
					login.resetErrorText();
				}
				
				
				/*switch(login.getUserType())
				{
				case 1: //patient
					mainScreen = new PatientScreen(login.getUsername(), login.getPassword());
					if(mainScreen.confirmLogin())
					{
						swapScreens();
					}
					else
					{
						login.wrongPass();
					}
					break; 
				case 2: //nurse
					mainScreen = new NurseScreen(login.getUsername(), login.getPassword());
					if(mainScreen.confirmLogin()) 
					{
						swapScreens();
					}
					else
					{
						login.wrongPass();
					}
					break;
				case 3: //doctor
					mainScreen = new DoctorScreen(login.getUsername(), login.getPassword());
					if(mainScreen.confirmLogin()) 
					{
						swapScreens();
					}
					else
					{
						login.wrongPass();
					}
					break;				
				}*/
			}
        });
        /*login.newAcc.setOnAction(new EventHandler<ActionEvent>()
        {
        	public void handle(ActionEvent event)
        	{
        		if(login.getUserType() != 0)
        		{
        			//create = new NewAccountScreen(login.getUserType());
            		swapToAccount();
        		}
        		else 
        		{
					login.noUserTypeSelected();
				}
        	}
        });*/
	}
	
	private void swapScreens()
	{
		this.getChildren().remove(login);
		this.getChildren().add(mainScreen);
	}
	
	
	private void backToLogin()
	{
		//this.getChildren().remove(create);
		this.getChildren().add(login);
	}
}
