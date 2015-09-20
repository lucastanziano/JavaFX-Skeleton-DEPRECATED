package ui.fragment;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class FXMLLoaderWrapper implements ILoader {

	private final FXMLLoader loader;
	
	public FXMLLoaderWrapper(FXMLLoader loader){
		this.loader = loader;
	}
	
	
	@Override
	public Object load() throws IOException {
		return loader.load();
	}

	@Override
	public <T> T getController(){
		return loader.getController();
	}

}
