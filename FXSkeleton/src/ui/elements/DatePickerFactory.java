package ui.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;

public class DatePickerFactory {
	
	private DatePickerFactory(){
		
	}
	
	
	public static DatePicker createDatePicker(EventHandler<ActionEvent> onAction){
		DatePicker datePicker = new DatePicker();
		datePicker.setOnAction(onAction);
		return datePicker;
	}

}
