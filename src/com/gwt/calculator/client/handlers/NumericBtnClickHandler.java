package com.gwt.calculator.client.handlers;

import com.gwt.calculator.client.GlobalVars;
import com.gwt.calculator.client.GlobalVars.pressedButton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Clase que se usa para controlar el evento click de los botones numéricos de la calculadora
 * @author Juan_Fran
 *
 */
public class NumericBtnClickHandler implements SelectHandler {

	//input-display de la calculadora, para escribir los números
	public TextField textBox;

	/**
	 * Clase que se usa para controlar el evento click de los botones numéricos de la calculadora
	 * @param textBox
	 * 		input-display de la calculadora, para escribir los números
	 */
	public NumericBtnClickHandler(TextField textBox) {
		this.textBox = textBox;
	}

	/**
	 * Captura el evento, y añade el valor del botón pulsado a lo que esté escrito en el display
	 */
	@Override
	public void onSelect(SelectEvent event) {
		// Valor del Botón pulsado
		String text;
		//Obtenemos el valor del display

		text = textBox.getText();

		//Obtenemos el botón que ha sido pulsado, para poner el texto
		final TextButton btn;
		btn = (TextButton) event.getSource();

		if (GlobalVars.lastPressedBtn != pressedButton.FUNCTION && GlobalVars.lastPressedBtn != pressedButton.SIGNCHANGE) {
			//Capturamos el texto del display y metemos el nuevo número
			//En caso de que sea "0", lo quitamos
			text = removeZero(text);
			// Actualizamos el display añadiendo el nuevo número pulsado
			text=text + btn.getText();
		} else {
			//Guardamos el texto del display en las variables globales y mostramos el nuevo número
			GlobalVars.operingOne=Double.parseDouble(text);
			//Actualizamos el display con el nuevo número pulsado
			text=btn.getText();
		}
		
		textBox.setText(text);
		GlobalVars.lastPressedBtn = pressedButton.NUMERIC;
	}

	/**
	 * En caso de que la cadena suministrada sea "0", se devuelve ""
	 * @param str
	 * @return
	 */
	public String removeZero(String str) {
		if (str == "0") {
			str = "";
		}

		return str;
	}

}
