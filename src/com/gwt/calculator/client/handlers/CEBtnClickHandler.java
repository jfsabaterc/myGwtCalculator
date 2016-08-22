package com.gwt.calculator.client.handlers;

import com.gwt.calculator.client.GlobalVars;
import com.gwt.calculator.client.GlobalVars.pressedButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Captura el evento click del botón CE
 * @author Juan_Fran
 *
 */
public class CEBtnClickHandler implements SelectHandler {

	public TextField textBox;

	public CEBtnClickHandler(TextField textBox) {
		this.textBox = textBox;
	}

	/**
	 * Borra el último dígito introducido, pone el display a 0 si no quedan dígitos
	 */
	@Override
	public void onSelect(SelectEvent event) {

		String text;
		
		if (GlobalVars.lastPressedBtn == pressedButton.FUNCTION) {
			//Capturamos el contenido del display
			text = textBox.getText();
			//Eliminamos último carácter
			text = removeLast(text);
			//Ponemos "0" si no quedan dígitos
			text = setZeroWhenNothing(text);
			textBox.setText(text);
		}
	}

	/**
	 * Elimina el último carácter de una cadena
	 * @param str
	 * @return
	 */
	public String removeLast(String str) {
		if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}

		return str;
	}

	/**
	 * Devuelve "0" si la cadena proporcionado es nada o no tiene longitud
	 * @param str
	 * @return
	 */
	public String setZeroWhenNothing(String str) {
		if (str == null || str.length() == 0) {
			str = "0";
		}
		return str;
	}
}