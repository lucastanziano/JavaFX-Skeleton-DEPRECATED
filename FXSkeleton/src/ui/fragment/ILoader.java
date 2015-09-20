package ui.fragment;

import java.io.IOException;

public interface ILoader {

	public Object load() throws IOException;
	
	public <T> T getController();
}
