package ui.dialogs;

public class TextFieldDescription {
	
	private String label;
	private boolean password;
	private String placeholder;
	private String preinsertedText;
	
	
	private TextFieldDescription(){
		this.label = "";
		this.password = false;
		this.placeholder = "";
		this.preinsertedText = "";
	}
	
	public static TextFieldDescription newBaseDescriptor(String label){
		TextFieldDescription instance = new TextFieldDescription();
		instance.setLabel(label);
		return instance;
	}
	
	public static TextFieldDescription newPasswordDescriptor(String label){
		TextFieldDescription instance = newBaseDescriptor(label);
		instance.setPassword(true);
		return instance;
	}
	
	public static TextFieldDescription newFullDescriptor(String label, boolean isPassword, String placeholder, String preinsertedText){
		TextFieldDescription instance = newBaseDescriptor(label);
		instance.setPassword(isPassword);
		instance.setPlaceholder(placeholder);
		instance.setPreinsertedText(preinsertedText);
		return instance;
	}
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isPassword() {
		return password;
	}
	public void setPassword(boolean password) {
		this.password = password;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getPreinsertedText() {
		return preinsertedText;
	}
	public void setPreinsertedText(String preinsertedText) {
		this.preinsertedText = preinsertedText;
	}

}
