package ui.pane.events;

public class OnStackItemSelected {
	
	private final int selectedItem;
	
	public OnStackItemSelected(int selectedItem){
		this.selectedItem = selectedItem;
	}
	
	public int getSelectedItem(){
		return this.selectedItem;
	}

}
