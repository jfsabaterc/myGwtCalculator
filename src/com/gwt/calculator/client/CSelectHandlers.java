package com.gwt.calculator.client;

import com.google.gwt.user.client.ui.TextBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;


/**
 * Clase que usamos para almacenar los diferentes handlers de los botones de la calculadora
 * @author Juan_Fran
 *
 */
public class CSelectHandlers {
	
	public class NuevoHandler implements SelectHandler {

		TextField textBox;

		public NuevoHandler(TextField textBox) {
			this.textBox = textBox;
		}

		@Override
		public void onSelect(SelectEvent event) {
			// TODO Auto-generated method stub
			final TextButton btn;
			btn=(TextButton) event.getSource();
			
			this.textBox.setText(btn.getText());
		}
		
	}

	
	

}
