package ui.menubar;

import javafx.scene.control.MenuBar;

public class MenuBarFactory {

	
	private MenuBarFactory(){

	}
	
	public static MenuBar newMenuBar(IMenuItemProvider itemProvider){
		MenuBar bar =  new MenuBar();
		bar.getMenus().addAll(itemProvider.createItems());
		return bar;
	}
	




	
	

}
