package ui.perspective;

import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import ui.component.IComponent;

public interface IPerspective {
	
	public MenuBar getMenuBar();
	
	public ToolBar getToolBar();
	
	public IComponent getComponent();
	

}
