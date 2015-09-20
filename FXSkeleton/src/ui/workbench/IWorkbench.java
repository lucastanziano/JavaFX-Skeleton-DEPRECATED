package ui.workbench;

import java.util.List;

import ui.perspective.IPerspective;
import javafx.scene.Parent;
import javafx.stage.Stage;

public interface IWorkbench {
	
	
	public Stage getPrimaryStage();
	
	public List<IPerspective> getPerspectives();
	
	public Parent getSceneContainer();
	
	public void loadPerspective(int index);
	
	public int getCurrentPerspectiveIndex();

	public void show();

}
