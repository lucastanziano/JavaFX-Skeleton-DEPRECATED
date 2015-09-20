package ui.menubar.items;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class ExitItem extends MenuItem {
	
	private static final KeyCodeCombination DEFAULT_ACCELERATOR = new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN);
	private static final String TITLE = "Exit";
	private static final ExitItem instance = new ExitItem();
	
	private ExitItem(){
		super(TITLE);
		setOnAction(new OnExit());
		setAccelerator(DEFAULT_ACCELERATOR);
	}
	
	
	public static ExitItem getInstance(){
		return instance;
	}


	
	public class OnExit implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
			
		}



	}
}
