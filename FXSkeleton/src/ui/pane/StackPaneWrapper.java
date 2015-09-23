package ui.pane;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import net.engio.mbassy.listener.Handler;
import ui.pane.events.OnStackItemSelected;

public class StackPaneWrapper extends StackPane {

	private final ObservableList<Group> items = FXCollections
			.observableArrayList();

	public ObservableList<Group> getItems() {
		return this.items;
	}

	public void showItem(int index) {
		Platform.runLater(new ShowItemThread(this, index));
	}

	private class ShowItemThread implements Runnable {

		private final StackPaneWrapper pane;
		private final int index;

		public ShowItemThread(StackPaneWrapper pane, int index) {
			this.pane = pane;
			this.index = index;
		}

		@Override
		public void run() {
			pane.getChildren().clear();
			pane.getChildren().add(getItems().get(index));
		}

	}

	@Handler
	public void itemSelectedEvent(OnStackItemSelected selectionEvent) {
		if (selectionEvent.getSelectedItem() < getItems().size()) {
			showItem(selectionEvent.getSelectedItem());
		} else {
			throw new IndexOutOfBoundsException(this.getClass()
					.getCanonicalName()
					+ ": itemSelectedEvent received "
					+ selectionEvent.getSelectedItem()
					+ " but the valid range is 0-" + (getItems().size() - 1));
		}
	}

}
