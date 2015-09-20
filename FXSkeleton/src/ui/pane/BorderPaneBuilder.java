package ui.pane;


import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class BorderPaneBuilder implements IPaneBuilder{
	
	private  Node top;
	private  Node bottom;
	private  Node left;
	private  Node right;
	private  Node center;
	
	private BorderPaneBuilder(){
		this.top = null;
		this.bottom = null;
		this.left = null;
		this.right = null;
		this.center = null;
	}
	
	public static BorderPaneBuilder newInstance(){
		return new BorderPaneBuilder();		
	}
	
	
	public BorderPaneBuilder setCenter(Node node) {
		this.center = node;
		return this;
	}
	
	
	public BorderPaneBuilder setTop(Node node) {
		this.top = node;
		return this;
	}
	

	
	public BorderPaneBuilder setLeft(Node node) {
		this.left = node;
		return this;
	}
	

	
	public BorderPaneBuilder setBottom(Node node){
		this.bottom = node;
		return this;
	}
	

	
	public BorderPaneBuilder setRight(Node node) {
		this.right = node;
		return this;
	}

	@Override
	public BorderPane build() {
		return new BorderPane(this.center, this.top, this.right, this.bottom, this.left);
	}

	

}
