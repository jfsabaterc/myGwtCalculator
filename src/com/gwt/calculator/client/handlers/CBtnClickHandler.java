package com.gwt.calculator.client.handlers;

import com.gwt.calculator.client.GlobalVars;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Captura el evento click del botón C
 * @author Juan_Fran
 *
 */
public class CBtnClickHandler implements SelectHandler {

	public TextField textBox;

	public CBtnClickHandler(TextField textBox) {
		this.textBox = textBox;
	}

	@Override
	public void onSelect(SelectEvent event) {

		clear();
	}
	
	/**
	 * Pone el display a 0 y borra todos los valores guardados
	 */
	
	public void clear(){
		textBox.setText("0");
		
		GlobalVars.clear();

	}
	

}


