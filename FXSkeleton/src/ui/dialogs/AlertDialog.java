package ui.dialogs;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

@SuppressWarnings("rawtypes")
public class AlertDialog extends BaseDialog {



	@SuppressWarnings("unchecked")
	private AlertDialog(Alert alert) {
	    super(alert);
	}

	public static void showError(String message, Exception ex){
		createError().setStackTraceDetails(ex).setHeaderText(message).showAndWait();
	}
	
	public static void showError(Exception ex){
		createError().setStackTraceDetails(ex).showAndWait();
	}
	
	public static AlertDialog createError() {
		AlertDialog dialog = new AlertDialog(new Alert(AlertType.ERROR));
		dialog.setTitle("Error!");
		return dialog;
	}

	public static AlertDialog createInfo() {
		AlertDialog dialog = new AlertDialog(new Alert(AlertType.INFORMATION));
		dialog.setTitle("Info");
		return dialog;
	}

	public static AlertDialog createWarning() {
		AlertDialog dialog = new AlertDialog(new Alert(AlertType.WARNING));
		dialog.setTitle("Warning");
		return dialog;
	}

	public static AlertDialog createWaiting(){
		IDialog dialog =  createInfo().disableButton(ButtonType.OK);
		return (AlertDialog) dialog;
	}


	public AlertDialog setStackTraceDetails(Exception ex) {
		setContentText(dialog.getContentText() + " " + ex.getMessage());
		ex.printStackTrace();
		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		dialog.getDialogPane().setExpandableContent(expContent);
		return this;
	}
	

	

	
	public Alert getAlert(){
		return (Alert) dialog;
	}

}
