# JavaFX-Skeleton

Note: this project is still under development

The purpose of this project is to build a UI application framework based on JavaFX, supporting developers to structure an application with loosely coupled and reusable components.


###Structure

#####Launcher
The entry point of an application is the launcher. It's scope is to initialize the application and configure the workbench.
To create a launcher extends the abstract class AbstractLauncher.
Example:

    public class ExampleAppLauncher extends AbstractLauncher {
    
    	
      	public static void main(String[] args) {
        		launch(args);
      	}
    
      	@Override
      	protected IWorkbench createWorkbench(Stage stage) throws IOException {
      	    List<IPerspective> perspectives =  ... // declare perspectives to show in the workbench;
        		BaseWorkbench bench =  new BaseWorkbench(stage, perspectives);
        		bench.setHeight(800);
        		bench.setWidth(800);
        		return bench;
      	}
    	
    	
    
      	@Override
      	protected void initApp() throws Exception {
              //init app
      	}
    }

#####Workbench
The workbench is in charge to manage perspectives. It's interface is IWorkbench but in the most of the cases you could use BaseWorkbench which adopt a BorderPane as a scene container.

#####Perspective
Perspective provides the content to be rendered when it is active. Content includes menu bar, tool bar and a main component.


#####Component


#####Fragment
