package ui.workbench;

import java.util.List;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.pane.BorderPaneBuilder;
import ui.perspective.IPerspective;

public class BaseWorkbench implements IWorkbench{

	private static final int DEFAULT_PERSPECTIVE = 0;
	private final Stage primaryStage;
	private List<IPerspective> perspectives;
	private int currentPerspective = DEFAULT_PERSPECTIVE;
	private final BorderPane sceneContainer = new BorderPane();
	
	public BaseWorkbench(Stage primaryStage, List<IPerspective> perspectives){
		this.primaryStage = primaryStage;
		this.perspectives = perspectives;
		loadPerspective(DEFAULT_PERSPECTIVE);
	}
	


	@Override
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	@Override
	public void show() {
		loadPerspective(DEFAULT_PERSPECTIVE);
		Scene scene = new Scene(getSceneContainer());
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

	
	public List<IPerspective> getPerspectives(){
		return this.perspectives;
	}

	@Override
	public Parent getSceneContainer() {
		return this.sceneContainer;
	}

	@Override
	public void loadPerspective(int index) {
		this.currentPerspective = index;	
		this.sceneContainer.setTop(getCurrentPerspective().getMenuBar());
		this.sceneContainer.setCenter(getCurrentPerspective().getComponent().getContainer());
	}
	
	public IPerspective getCurrentPerspective(){
		return this.perspectives.get(currentPerspective);
	}

	@Override
	public int getCurrentPerspectiveIndex() {
		return this.currentPerspective;
	}

}
