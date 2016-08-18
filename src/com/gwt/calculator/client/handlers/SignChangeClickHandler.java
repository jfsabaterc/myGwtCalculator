package com.gwt.calculator.client.handlers;

import com.gwt.calculator.client.GlobalVars;
import com.gwt.calculator.client.GlobalVars.pressedButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;

public class SignChangeClickHandler implements SelectHandler {

	TextField textBox;

	public SignChangeClickHandler(TextField textBox) {
		this.textBox = textBox;
	}

	/**
	 * Cambia el signo del número introducido
	 */
	@Override
	public void onSelect(SelectEvent event) {
		String text=textBox.getText();
		text=ChangeSign(text);
		
		textBox.setText(text);
		GlobalVars.lastPressedBtn = pressedButton.SIGNCHANGE;
	}

	/**
	 * Cambia el signo del número introducido
	 */
	public static String ChangeSign(String text) {
		//Comprobamos si podemos ponerle número
		if (text != "0" && isNumeric(text)) {
			//Comprobamos el símbolo actual
			if (text.startsWith("-")) {
				//En caso de que el símbolo sea negativo, se lo quitamos
				text = text.substring(1);
			} else {
				//En caso de que el símbolo sea positivo, se lo ponemos
				text = "-" + text;
			}
		}

		return text;
	}

	/**
	 * Comprueba si el string suministrado es numérico
	 * @param s
	 * @return
	 */
	public static boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
}
