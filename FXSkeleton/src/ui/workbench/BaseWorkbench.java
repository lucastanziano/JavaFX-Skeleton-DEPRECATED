package ui.workbench;

import java.util.List;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.perspective.IPerspective;

public class BaseWorkbench implements IWorkbench{

	private static final int DEFAULT_PERSPECTIVE = 0;
	private final Stage primaryStage;
	private List<IPerspective> perspectives;
	private int currentPerspective = DEFAULT_PERSPECTIVE;
	private final BorderPane sceneContainer = new BorderPane();
	private double height;
	private double width;
	

	public BaseWorkbench(Stage primaryStage, List<IPerspective> perspectives){
		this.primaryStage = primaryStage;
		this.perspectives = perspectives;
		this.height = 100.0;
		this.width = 100.0;
		loadPerspective(DEFAULT_PERSPECTIVE);
		
	}
	


	@Override
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	@Override
	public void show() {
		loadPerspective(DEFAULT_PERSPECTIVE);
		Scene scene = new Scene(getSceneContainer(), getWidth(), getHeight());
		
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

	
	private double getHeight() {
		return this.height;
	}



	private double getWidth() {
		return this.width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}



	public void setWidth(double width) {
		this.width = width;
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
		this.sceneContainer.setTop(createTopBarsContainer(getCurrentPerspective()));
		this.sceneContainer.setCenter(getCurrentPerspective().getComponent().getContainer());
	}
	
	private VBox createTopBarsContainer(IPerspective perspective){
		MenuBar menuBar = perspective.getMenuBar();
		ToolBar toolBar = perspective.getToolBar();
		VBox container = new VBox();
		if(menuBar!= null && menuBar.getMenus().size()>0){
			container.getChildren().add(menuBar);
		}
		if(toolBar != null && toolBar.getItems().size()>0){
			container.getChildren().add(toolBar);
		}
		return container;
		
				
	}
	
	public IPerspective getCurrentPerspective(){
		return this.perspectives.get(currentPerspective);
	}

	@Override
	public int getCurrentPerspectiveIndex() {
		return this.currentPerspective;
	}

}
