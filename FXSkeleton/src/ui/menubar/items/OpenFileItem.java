package ui.menubar.items;

import java.io.File;
import java.lang.ref.WeakReference;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class OpenFileItem extends MenuItem{
	
	private static final KeyCodeCombination DEFAULT_ACCELERATOR = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
			
	private OpenFileItem(String title){
		super(title);
	}
	
	public static OpenFileItem newInstance(String title, ObservableList<File> result, ExtensionFilter[] filter, Stage stage){
		OpenFileItem item = new OpenFileItem(title);
		item.setOnAction(item.new OpenLoadFileDialog(result, filter, stage));
		item.setAccelerator(DEFAULT_ACCELERATOR);
		return item;
	}
	

	
	
	public class OpenLoadFileDialog implements EventHandler<ActionEvent> {

		private final ExtensionFilter[] extensionFilter;

		private final WeakReference<Stage> stage;
		
		private final WeakReference<ObservableList<File>> destination;

		public OpenLoadFileDialog(ObservableList<File> result, ExtensionFilter[] filter, Stage stage) {
			this.extensionFilter = filter;
			this.stage = new WeakReference<Stage>(stage);
			this.destination = new WeakReference<ObservableList<File>>(result);
		}

		@Override
		public void handle(ActionEvent event) throws IllegalStateException {

			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters().addAll(extensionFilter);
			fileChooser.setTitle("Select file:");
			
			File openedFile = showOpenDialog(fileChooser);
			
	        if(destination.get()!=null){
	        	(destination.get()).add(openedFile);
	        }
	        else{
	        	throw new IllegalStateException("Unable to store file reference, FileDestination object was disposed");
	        }
		}



		private File showOpenDialog(FileChooser fileChooser) throws IllegalStateException {
			if(stage.get()!=null){
				return fileChooser.showOpenDialog(stage.get());
			}
			throw new IllegalStateException("Unable to open load file dialog: parent stage was disposed");
		}

	}
}
