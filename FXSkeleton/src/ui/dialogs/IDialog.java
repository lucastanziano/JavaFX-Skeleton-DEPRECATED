package ui.dialogs;

import java.util.Optional;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.stage.Window;

public interface IDialog<T> {
	
	public IDialog<T> initOwner(Window owner);

	public IDialog<T> setTitle(String title);

	public IDialog<T> setHeaderText(String headerText);

	public IDialog<T> setContentText(String contentText);

	public Optional<T> showAndWait();
	
	public IDialog<T> setIcon(Image icon);

	public IDialog<T> disableButton(ButtonType type);
	
	public void close();
	
	public Dialog<T> getDialog();
	
}
