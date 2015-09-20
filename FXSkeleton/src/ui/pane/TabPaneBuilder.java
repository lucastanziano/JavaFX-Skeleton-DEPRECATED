package ui.pane;


import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPaneBuilder implements IPaneBuilder{
	
	private final List<Tab> tabs;
	
	private TabPaneBuilder(){
		this.tabs = FXCollections.<Tab>observableArrayList();
	}
	
	public static TabPaneBuilder newInstance(){
		return new TabPaneBuilder();
	}
	
	@Override
	public Parent build(){
		TabPane pane = new TabPane();
		pane.getTabs().addAll(getTabs());
		return pane;
	}
	
	public void addTab(Tab newTab){
		this.getTabs().add(newTab);
	}
	
	public void insertTab(Tab newTab, int index){
		this.getTabs().add(index, newTab);
	}
	
	public Tab getTab(int index){
		return this.getTabs().get(index);
	}
	
	public int getTabsCounter(){
		return this.getTabs().size();
	}

	private List<Tab> getTabs() {
		return tabs;
	}
	
	

}
