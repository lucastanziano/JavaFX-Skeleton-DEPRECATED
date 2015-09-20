package ui.dialogs;

import java.util.Optional;

import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

public class BaseDialog<T> implements IDialog<T>{

	
	protected Dialog<T> dialog;
	
	public BaseDialog(Dialog<T> dialog){
		this.dialog = dialog;
		this.dialog.setHeaderText(null);
	}
	
	@Override
	public IDialog<T> initOwner(Window owner) {
		dialog.initOwner(owner);
		return this;
	}

	@Override
	public IDialog<T> setTitle(String title) {
		dialog.setTitle(title);
		return this;
	}

	@Override
	public IDialog<T> setHeaderText(String headerText) {
		dialog.setHeaderText(headerText);
		return this;
	}

	@Override
	public IDialog<T> setContentText(String contentText) {
		dialog.setContentText(contentText);
		return this;
	}
	
	@Override
	public Optional<T> showAndWait(){		
		return dialog.showAndWait();
	}
	
	@Override
	public IDialog<T> setIcon(Image icon){
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(icon);
		return this;
	}
	
	@Override
	public IDialog<T> disableButton(ButtonType type){
		Node button = dialog.getDialogPane().lookupButton(type);
		button.setDisable(true);
		return this;
	}
	
	public Dialog<T> getDialog(){
		return dialog;
	}

	@Override
	public void close() {
		dialog.close();		
	}

}
