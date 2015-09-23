package ui.elements;

import javafx.scene.control.CheckBox;

public class CheckBoxFactory {
	
	
	private CheckBoxFactory(){
	
	}
	
	
	public static CheckBox createCheckBox(String text, boolean value){
		CheckBox checkbox = new CheckBox(text);
		checkbox.setSelected(value);
		return checkbox;
	}
	
	

}
