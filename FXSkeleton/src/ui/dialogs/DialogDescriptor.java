package ui.dialogs;

import java.util.List;

public class DialogDescriptor {
	
	
	private String title;
	private String headerText;
	private String contentText;
	
	private List<TextFieldDescription> fields;
	
	private DialogDescriptor(List<TextFieldDescription> fields){
		setFields(fields);
	}
	


	public static DialogDescriptor newInstance(List<TextFieldDescription> fields){
		return new DialogDescriptor(fields);
	}



	public List<TextFieldDescription> getFields() {
		return fields;
	}



	public void setFields(List<TextFieldDescription> fields) {
		this.fields = fields;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getHeaderText() {
		return headerText;
	}



	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}



	public String getContentText() {
		return contentText;
	}



	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

}
