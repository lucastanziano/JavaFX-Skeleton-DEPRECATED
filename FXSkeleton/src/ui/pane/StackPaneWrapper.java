package ui.pane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

public class StackPaneWrapper extends StackPane {
	
	
	private final ObservableList<Group> items = FXCollections.observableArrayList();
	
	
	public ObservableList<Group> getItems(){
		return this.items;
	}
	
	public void showItem(int index){
		super.getChildren().clear();
		super.getChildren().add(getItems().get(index));
	}
	
	

}
