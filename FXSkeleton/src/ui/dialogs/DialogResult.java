package ui.dialogs;

import java.util.Map;

import javafx.scene.control.TextField;

public class DialogResult {
	

	//TODO optimize this class. 
	
	private Map<TextFieldDescription, TextField> fieldsMap;
	
	
	private DialogResult(Map<TextFieldDescription, TextField> fields){
		setFieldsMap(fields);
	}
	
	public static DialogResult newInstance(Map<TextFieldDescription, TextField> fields){
		return new DialogResult(fields);
	}

	public Map<TextFieldDescription, TextField> getFieldsMap() {
		return fieldsMap;
	}

	public void setFieldsMap(Map<TextFieldDescription, TextField> fieldsMap) {
		this.fieldsMap = fieldsMap;
	}

	

}
