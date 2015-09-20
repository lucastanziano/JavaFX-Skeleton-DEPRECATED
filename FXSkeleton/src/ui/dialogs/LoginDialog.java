package ui.dialogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class LoginDialog extends BaseDialog<DialogResult> {

	public final static String PASSWORD_LABEL = "Password";
	
	private Node loginButton;
	
	private LoginDialog(DialogDescriptor descriptor){
       super(new Dialog<DialogResult>());
	   
	   Map<TextFieldDescription, TextField> fields =  createFields(descriptor.getFields());
	   
	   Node loginButton = setupButtons(fields);
	   setLoginButton(loginButton);
	   
//TODO perform fields validation
		
      
//		// Do some validation (using the Java 8 lambda syntax).
//		username.textProperty().addListener((observable, oldValue, newValue) -> {
//		    loginButton.setDisable(newValue.trim().isEmpty());
//		});
//
//
//
//		// Request focus on the username field by default.
//		Platform.runLater(() -> username.requestFocus());
		
	}
	
	
	private Node setupButtons(Map<TextFieldDescription, TextField> fields) {
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		getDialog().getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = getDialog().getDialogPane().lookupButton(loginButtonType);
//		loginButton.setDisable(true);
		
		// Convert the result to a username-password-pair when the login button is clicked.
		getDialog().setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		    	return DialogResult.newInstance(fields);
		    }
		    return null;
		});
		
		return loginButton;
	}


	private Map<TextFieldDescription, TextField> createFields(List<TextFieldDescription> fieldsDescriptors) {
		
		Map<TextFieldDescription, TextField> fields = new HashMap<TextFieldDescription, TextField>();
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 50, 10, 10));

		
		int rowIndex = 2;
		for(TextFieldDescription fieldDescription : fieldsDescriptors ){
			TextField field = null;
			if(fieldDescription.isPassword()){
				field = new PasswordField();
			}else{
			  field = new TextField();
			}
			field.setMinWidth(300.0);
			field.setPromptText(fieldDescription.getPlaceholder());
			if(fieldDescription.getPreinsertedText() != null && fieldDescription.getPreinsertedText().length()>1){
				field.setText(fieldDescription.getPreinsertedText());
			}
			fields.put(fieldDescription, field);
			grid.add(new Label(fieldDescription.getLabel() + ":"), 0, rowIndex);
			grid.add(field, 1, rowIndex++);
		}
		
		getDialog().getDialogPane().setContent(grid);
		   
		return fields;
	}


	public static LoginDialog create(DialogDescriptor descriptor){

		LoginDialog dialog = new LoginDialog(descriptor);


		return dialog;
	}


	public Node getLoginButton() {
		return loginButton;
	}


	public void setLoginButton(Node loginButton) {
		this.loginButton = loginButton;
	}
	

}
