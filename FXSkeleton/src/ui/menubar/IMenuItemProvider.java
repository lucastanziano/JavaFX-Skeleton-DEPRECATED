package ui.menubar;

import java.util.Collection;

import javafx.scene.control.Menu;

public interface IMenuItemProvider {

	public Collection<Menu> createItems();
}
