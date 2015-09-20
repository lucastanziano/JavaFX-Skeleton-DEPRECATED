package ui.toolbar;

import javafx.scene.control.ToolBar;

public class ToolBarFactory {
	
	private ToolBarFactory(){
		
	}
	
	public static ToolBar newToolBar(IToolBarProvider provider){
		ToolBar bar = new ToolBar();
		bar.getItems().addAll(provider.createItems());
		return bar;
	}

}
