package launcher;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.dialogs.AlertDialog;
import ui.workbench.IWorkbench;



public abstract class AbstractLauncher extends Application {


	private Stage primaryStage;
	


	@Override
	public void start(Stage primaryStage) {

		try{
			initApp();
		}
		catch(Exception e){
			AlertDialog.createError().setStackTraceDetails(e)
			.setTitle("Fatal Error")
			.setHeaderText("An error occurred initializing the app")
			.showAndWait();
		}
		
		try {
			
			createWorkbench(primaryStage).show();
			
		} catch (Exception e) {
			AlertDialog.createError().setStackTraceDetails(e)
					.setTitle("Fatal Error")
					.setHeaderText("An error occurred loading the main view")
					.showAndWait();
		}

	}




	
	protected abstract IWorkbench createWorkbench(Stage stage) throws IOException;
	
	protected abstract void initApp() throws Exception;
	
	protected Stage getPrimaryStage(){
		return primaryStage;
	}
}